import nmon.common.NmonUtils;
import nmon.pojo.header.AAA;
import nmon.pojo.header.BBBP;
import nmon.pojo.header.Header;
import nmon.pojo.header.ProcNetDev;
import nmon.pojo.statistics.*;
import nmon.pojo.statistics.disk.Disk;
import nmon.pojo.statistics.disk.DiskImpl;
import nmon.pojo.statistics.network.NetIO;
import nmon.pojo.statistics.network.Network;
import nmon.pojo.statistics.network.NetworkImpl;
import nmon.pojo.statistics.system.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: AM 9:45
 * To change this template use File | Settings | File Templates.
 */
public class NmonLogParserTest {

    static Header HEADER = new Header();
    static AAA AAA = new AAA();
    static BBBP BBBP = new BBBP();


    static HashMap<String, Method> AAMethods = NmonUtils.extractVOMethods(AAA.getClass().getMethods(), "set");

    @Test
    public void lineSeperateTest() throws IOException, InterruptedException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        File inputFile = FileUtils.getFile("/Users/muda1120/muda1120_120208_1146.nmon");
        File inputFile = FileUtils.getFile("/Users/muda1120/Downloads/LCNCAAS01_111124_1823.nmon");
        InputStream input = FileUtils.openInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();
        ZZZZ zzzz = null;


        while (line != null) {
            if (line.indexOf(",") == -1) return;

            // Validate Header
            if ("AAA".equals(line.split(",")[0])) collectAAA(line);
            if ("BBBP".equals(line.split(",")[0])) collectBBBP(line);
            if (line.split(",")[1].contains("Network I/O")) collectNetworkOrd(line);
            if (line.split(",")[1].contains("Disk Read")) collectDiskOrd(line);


            // Validate Statistics
            if ("ZZZZ".equals(line.split(",")[0])) {
//                collectZZZZ(line);
                while (line != null) {
                    if ("ZZZZ".equals(line.split(",")[0])) {
                        if(zzzz!=null) System.out.println(zzzz.toString());
                        zzzz = collectZZZZ(line);
                    }

                    if (zzzz != null) {
                        if (line.split(",")[0].contains("CPU") && !line.split(",")[0].equals("CPU_ALL"))
                            zzzz.addCpu(collectCPU(line));
                        if (line.split(",")[0].contains("CPU_ALL")) zzzz.setCpuAll(collectCPUALL(line));
                        if (line.split(",")[0].contains("MEM")) zzzz.setMemory(collectMemory(line));
                        if (line.split(",")[0].contains("VM")) zzzz.setVm(collectVM(line));
                        if (line.split(",")[0].contains("TOP")) zzzz.addTop(collectTOP(line));
                        if (line.split(",")[0].contains("PROC")) zzzz.setProc(collectProc(line));
                        if (line.split(",")[0].contains("NET") &&
                                !line.split(",")[1].contains("Network I/O")) zzzz.setNetIOList(collectNetworkIO(line));
                        if (line.split(",")[0].contains("NETPACKET") &&
                                !line.split(",")[1].contains("Network Packets"))
                            zzzz.setNetIOList(collectNetworkIO(line));
                        if (line.split(",")[0].contains("DISKBUSY") &&
                                !line.split(",")[0].contains("Disk %Busy")) zzzz.setDiskBusyList(collectDisk(line));
                        if (line.split(",")[0].contains("DISKREAD") &&
                                !line.split(",")[0].contains("Disk Read")) zzzz.setDiskReadList(collectDisk(line));
                        if (line.split(",")[0].contains("DISKWRITE") &&
                                !line.split(",")[0].contains("Disk Write")) zzzz.setDiskWriteList(collectDisk(line));
                        if (line.split(",")[0].contains("DISKXFER") &&
                                !line.split(",")[0].contains("Disk transfers")) zzzz.setDiskXferList(collectDisk(line));
                        if (line.split(",")[0].contains("DISKBSIZE") &&
                                !line.split(",")[0].contains("Disk Block Size"))
                            zzzz.setDiskBsizeList(collectDisk(line));

                    }
                    line = reader.readLine();
                }

            }
//            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println(AAA);
        System.out.println(BBBP);
        System.out.println(HEADER);
//        System.out.println(ZZZz);
//        Thread.sleep(100000);


    }

    private List<Disk> collectDisk(String line) {
        ArrayList<Disk> diskList = new ArrayList<Disk>();
        String[] values = line.split(",");

        Iterator iterator = HEADER.getDiskOrderMap().entrySet().iterator();
        Map.Entry<String, Integer> diskOrderEntry;

        Disk disk = null;
        while (iterator.hasNext()) {
            disk = new DiskImpl();
            diskOrderEntry = (Map.Entry<String, Integer>) iterator.next();
            disk.setDiskName(diskOrderEntry.getKey());
            disk.setValue(values[diskOrderEntry.getValue()]);
            diskList.add(disk);
//            disk.toString();
        }

        return diskList;
    }

    private List<Network> collectNetworkIO(String value) {
        List<Network> netIOList = new ArrayList<Network>();
        String[] values = value.split(",");

        Iterator iterator = HEADER.getNicOrderMap().entrySet().iterator();
        Map.Entry<String, int[]> networkEntry;

        Network netIO = null;
        int[] readAndWriteOrd = null;
        while (iterator.hasNext()) {
            netIO = new NetworkImpl();
            readAndWriteOrd = new int[2];

            networkEntry = (Map.Entry<String, int[]>) iterator.next();
            readAndWriteOrd = networkEntry.getValue();

            netIO.setNicName(networkEntry.getKey());
            netIO.setRead(values[readAndWriteOrd[0]]);
            netIO.setWrite(values[readAndWriteOrd[1]]);
            netIOList.add(netIO);

        }

        return netIOList; 
    }

    private void collectDiskOrd(String value) {
        String[] values = value.split(",");

        for (int i = 2; i < values.length; i++) {
            HEADER.addDiskOrd(values[i], i);
        }
        System.out.println(HEADER.getDiskOrderMap());
    }

    private void collectNetworkOrd(String value) {
//        Map<String, Integer[]> nicOrdMap = new HashMap<String, Integer[]>();
        Map<String, int[]> nicOrdMap = HEADER.getNicOrderMap();
        String[] values = value.split(",");
        String[] nicInfo;
        int[] nicReadAndWriteOrd = null;
        
        for (int i = 0; i < values.length; i++) {
            if (values[i].contains("eth")){
                nicReadAndWriteOrd = new int[2];
                nicInfo = values[i].split("-");

                if(nicOrdMap.containsKey(nicInfo[0])) nicReadAndWriteOrd = nicOrdMap.get(nicInfo[0]);

                if(nicInfo[1].equals("read")) nicReadAndWriteOrd[0] = i;
                if(nicInfo[1].equals("write")) nicReadAndWriteOrd[1] = i;

                HEADER.addNicOrd(nicInfo[0], nicReadAndWriteOrd);
            }
        }

    }

    private Proc collectProc(String value) {
        String[] values = value.split(",");
        Proc proc = new Proc(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]);
        //System.out.println(proc.toString());
        return proc;
    }

    private Top collectTOP(String value) {
        String[] values = value.split(",");
        Top top = new Top(values[1], values[3], values[4], values[5], values[6], values[7], values[8],
                values[9], values[10], values[11], values[12], values[13]);
//        System.out.println(top.toString());
        return top;
    }

    private VM collectVM(String value) {
        String[] values = value.split(",");
        VM vm = new VM(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[2], values[10]
                , values[11], values[12], values[13], values[14], values[15], values[16], values[17], values[18], values[19], values[20]
                , values[21], values[22], values[23], values[24], values[25], values[26], values[27], values[28], values[29], values[30]
                , values[31], values[32], values[33], values[34], values[35], values[36], values[37]);
//        System.out.println(vm.toString());

        return vm;
    }

    private Memory collectMemory(String value) {
        String[] values = value.split(",");
        Memory memory = new Memory(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[2], values[10]
                , values[11], values[12], values[13], values[14], values[15]);
//        System.out.println(memory.toString());

        return memory;
    }

    private CpuAll collectCPUALL(String value) {
        String[] values = value.split(",");

        CpuAll cpuAll = new CpuAll(values[2], values[3], values[4], values[5], values[6], values[7]);
//        System.out.println(cpuAll.toString());

        return cpuAll;
    }

    private Cpu collectCPU(String value) {
        //CPU001,CPU 1 LCNCAAS01,User%,Sys%,Wait%,Idle%
        String[] values = value.split(",");

        Cpu cpu = new Cpu(values[0], values[2], values[3], values[4], values[5]);
//        System.out.println(cpu.toString());

        return cpu;
    }

    private void collectAAA(String value) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] aaaArray = value.split(",");

        if (aaaArray.length == 3) {
            NmonUtils.stringInjectToPojo(AAMethods, AAA, NmonUtils.transformCamelName(aaaArray[1]), aaaArray[2]);
        } else if (aaaArray.length > 3) {
            NmonUtils.stringInjectToPojo(AAMethods, AAA, NmonUtils.transformCamelName(aaaArray[1]), aaaArray);
        }

    }

    private void collectBBBP(String value) {
        /* BBBBP,1234,/proc/meminfo,"asdasd , "asdasd" */
        String[] values = value.split(",", 4);


        if (NmonUtils.BBBP_PROCNETDEV.equals(values[2]) && values.length > 3) {
            if (values[3].contains("eth")) {
                ProcNetDev procNetDev = new ProcNetDev();

                if (values[3].replaceAll("\"", "").split(":").length < 2) return;

                String nicFace = values[3].replaceAll("\"", "").split(":")[0].replaceAll(" ", "");

                String[] nicTempInfo = values[3].replaceAll("\"", "").split(":")[1].split(" ");
                List<String> nicInfo = new ArrayList<String>();

                for (String nic : nicTempInfo) {
                    if (!nic.equals("")) nicInfo.add(nic);
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

    private ZZZZ collectZZZZ(String value) {
        String[] values = value.split(",");
        ZZZZ zzzz = new ZZZZ();
        zzzz.setKey(values[1]);
        zzzz.setTime(values[2]);
        zzzz.setDate(values[3]);

        return zzzz;
    }


    @Test
    public void replactionTest() {
        String value = "max_disk_sasdasd_sada_ASd_ASD_asdasd";
        System.out.println(NmonUtils.transformCamelName(value));
    }

    @Test
    public void methodInvokeTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] columes = {"DisksPerLine", "Program", "ProcStatVariables", "MaxDisks"};
        String[] values = {"111", "222", "333", "444,1111"};

        for (int i = 0; i < columes.length; i++) {
            System.out.println(columes[i] + " : " + values[i]);
            NmonUtils.stringInjectToPojo(AAMethods, AAA, columes[i], values[i]);
        }

        System.out.println(AAA.getDisksPerLine());
        System.out.println(AAA.getMaxDisks());
        System.out.println(AAA.getProcStatVariables());

    }
}