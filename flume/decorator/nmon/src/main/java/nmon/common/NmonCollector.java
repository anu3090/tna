package nmon.common;

import nmon.pojo.header.AAA;
import nmon.pojo.header.BBBP;
import nmon.pojo.header.Header;
import nmon.pojo.header.ProcNetDev;
import nmon.pojo.statistics.ZZZZ;
import nmon.pojo.statistics.disk.Disk;
import nmon.pojo.statistics.disk.DiskImpl;
import nmon.pojo.statistics.network.Network;
import nmon.pojo.statistics.network.NetworkImpl;
import nmon.pojo.statistics.system.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 20.
 * Time: PM 3:11
 * To change this template use File | Settings | File Templates.
 */
public class NmonCollector {
    static Header HEADER = new Header();
    static AAA AAA = new AAA();
    static BBBP BBBP = new BBBP();


    public static List<Disk> collectDisk(String line) {
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

    public static List<Network> collectNetworkIO(String value) {
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

    public static void collectDiskOrd(String value) {
        String[] values = value.split(",");

        for (int i = 2; i < values.length; i++) {
            HEADER.addDiskOrd(values[i], i);
        }
        System.out.println(HEADER.getDiskOrderMap());
    }

    public static void collectNetworkOrd(String value) {
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

    public static Proc collectProc(String value) {
        String[] values = value.split(",");
        Proc proc = new Proc(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]);
        //System.out.println(proc.toString());
        return proc;
    }

    public static Top collectTOP(String value) {
        String[] values = value.split(",");
        Top top = new Top(values[1], values[3], values[4], values[5], values[6], values[7], values[8],
                values[9], values[10], values[11], values[12], values[13]);
//        System.out.println(top.toString());
        return top;
    }

    public static VM collectVM(String value) {
        String[] values = value.split(",");
        VM vm = new VM(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[2], values[10]
                , values[11], values[12], values[13], values[14], values[15], values[16], values[17], values[18], values[19], values[20]
                , values[21], values[22], values[23], values[24], values[25], values[26], values[27], values[28], values[29], values[30]
                , values[31], values[32], values[33], values[34], values[35], values[36], values[37]);
//        System.out.println(vm.toString());

        return vm;
    }

    public static Memory collectMemory(String value) {
        String[] values = value.split(",");
        Memory memory = new Memory(values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[2], values[10]
                , values[11], values[12], values[13], values[14], values[15]);
//        System.out.println(memory.toString());

        return memory;
    }

    public static CpuAll collectCPUALL(String value) {
        String[] values = value.split(",");

        CpuAll cpuAll = new CpuAll(values[2], values[3], values[4], values[5], values[6], values[7]);
//        System.out.println(cpuAll.toString());

        return cpuAll;
    }

    public static Cpu collectCPU(String value) {
        //CPU001,CPU 1 LCNCAAS01,User%,Sys%,Wait%,Idle%
        String[] values = value.split(",");

        Cpu cpu = new Cpu(values[0], values[2], values[3], values[4], values[5]);
//        System.out.println(cpu.toString());

        return cpu;
    }

    public static void collectAAA(String value){
        String[] values = value.split(",");

        if("program".equals(values[1])) AAA.setProgname(values[2]);
        if("command".equals(values[1])) AAA.setCommand(values[2]);
        if("version".equals(values[1])) AAA.setVersion(values[2]);
        if("disks_per_line".equals(values[1])) AAA.setDisksPerLine(values[2]);
        if("disks".equals(values[1])) AAA.setDisks(values[2]);
        if("host".equals(values[1])) AAA.setHost(values[2]);
        if("user".equals(values[1])) AAA.setUser(values[2]);
//        if("OS".equals(values[1])) AAA.setOS(values[2]);
        if("runname".equals(values[1])) AAA.setRunname(values[2]);
        if("time".equals(values[1])) AAA.setTime(values[2]);
        if("date".equals(values[1])) AAA.setDate(values[2]);
        if("interval".equals(values[1])) AAA.setInterval(values[2]);
        if("snapshots".equals(values[1])) AAA.setSnapshots(values[2]);
        if("cpus".equals(values[1])) AAA.setProgname(values[2]);
        if("proc_stat_variables".equals(values[1])) AAA.setProgname(values[2]);


    }

    public static void collectBBBP(String value) {
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

    public static ZZZZ collectZZZZ(String value) {
        String[] values = value.split(",");
        ZZZZ zzzz = new ZZZZ();
        zzzz.setKey(values[1]);
        zzzz.setTime(values[2]);
        zzzz.setDate(values[3]);

        return zzzz;
    }
}
