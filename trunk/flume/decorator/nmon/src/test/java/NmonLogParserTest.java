import nmon.common.CmonUtils;
import nmon.pojo.header.AAA;
import nmon.pojo.header.BBBP;
import nmon.pojo.header.ProcNetDev;
import nmon.pojo.statistics.ZZZZ;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: AM 9:45
 * To change this template use File | Settings | File Templates.
 */
public class NmonLogParserTest {

    static AAA AAA = new AAA();
    static BBBP BBBP = new BBBP();


    static HashMap<String, Method> AAMethods = CmonUtils.extractVOMethods(AAA.getClass().getMethods(), "set");

    @Test
    public void lineSeperateTest() throws IOException, InterruptedException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        File inputFile = FileUtils.getFile("/Users/muda1120/muda1120_120208_1146.nmon");
        File inputFile = FileUtils.getFile("/Users/muda1120/Downloads/LCNCAAS01_111124_1823.nmon");
        InputStream input = FileUtils.openInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();
        ZZZZ zzzz;


        while (line != null) {
            if (line.indexOf(",") == -1) return;

            if ("AAA".equals(line.split(",")[0])) collectAAA(line);
            if ("BBBP".equals(line.split(",")[0])) collectBBBP(line);

            if ("ZZZZ".equals(line.split(",")[0])) {
                collectZZZZ(line);
                while (line != null){
                    if("ZZZZ".equals(line.split(",")[0])){
                        zzzz = collectZZZZ(line);
                    }


                    line = reader.readLine();
                }
                
            }
//            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println(AAA);
        System.out.println(BBBP);


    }

    private void collectAAA(String line) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] aaaArray = line.split(",");

        if (aaaArray.length == 3) {
            CmonUtils.stringInjectToPojo(AAMethods, AAA, CmonUtils.transformCamelName(aaaArray[1]), aaaArray[2]);
        } else if (aaaArray.length > 3) {
            CmonUtils.stringInjectToPojo(AAMethods, AAA, CmonUtils.transformCamelName(aaaArray[1]), aaaArray);
        }

    }

    private void collectBBBP(String line) {
        /* BBBBP,1234,/proc/meminfo,"asdasd , "asdasd" */
        String[] values = line.split(",", 4);


        if (CmonUtils.BBBP_PROCNETDEV.equals(values[2]) && values.length > 3) {
            if (values[3].contains("eth")) {
                ProcNetDev procNetDev = new ProcNetDev();

                if (values[3].replaceAll("\"", "").split(":").length < 2) return;

                String nicFace = values[3].replaceAll("\"", "").split(":")[0].replaceAll(" ", "");

                String[] nicTempInfo = values[3].replaceAll("\"", "").split(":")[1].split(" ");
                List<String> nicInfo = new ArrayList<String>();

                for (String value : nicTempInfo) {
                    if (!value.equals("")) nicInfo.add(value);
                }


                if (nicInfo.size() == 16) {
                    procNetDev.setFace(nicFace);
                    procNetDev.setReceiveBytes(nicInfo.get(0));
                    procNetDev.setReceivePackets(nicInfo.get(1));
                    procNetDev.setReceiveErrs(nicInfo.get(2));
                    procNetDev.setReceiveDrops(nicInfo.get(3));
                    procNetDev.setReceiveFifo(nicInfo.get(4));
                    procNetDev.setReceiveFrame(nicInfo.get(5));
                    procNetDev.setReceiveCompressed(nicInfo.get(6));
                    procNetDev.setReceiveMulticast(nicInfo.get(7));
                    procNetDev.setTransmitBytes(nicInfo.get(8));
                    procNetDev.setTransmitPackets(nicInfo.get(9));
                    procNetDev.setTransmitErrs(nicInfo.get(10));
                    procNetDev.setTransmitDrop(nicInfo.get(11));
                    procNetDev.setTransmitFifo(nicInfo.get(12));
                    procNetDev.setTransmitColls(nicInfo.get(13));
                    procNetDev.setTransmitCarrier(nicInfo.get(14));
                    procNetDev.setTransmitCompressed(nicInfo.get(15));
                    BBBP.setProcNetDev(procNetDev);
                }
            }
        }
    }

    private ZZZZ collectZZZZ(String line) {
        System.out.println(line);
        return null;
    }


    @Test
    public void replactionTest() {
        String value = "max_disk_sasdasd_sada_ASd_ASD_asdasd";
        System.out.println(CmonUtils.transformCamelName(value));
    }

    @Test
    public void methodInvokeTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] columes = {"DisksPerLine", "Program", "ProcStatVariables", "MaxDisks"};
        String[] values = {"111", "222", "333", "444,1111"};

        for (int i = 0; i < columes.length; i++) {
            System.out.println(columes[i] +" : "+ values[i]);
            CmonUtils.stringInjectToPojo(AAMethods, AAA, columes[i], values[i]);
        }

        System.out.println(AAA.getDisksPerLine());
        System.out.println(AAA.getMaxDisks());
        System.out.println(AAA.getProcStatVariables());

    }
}