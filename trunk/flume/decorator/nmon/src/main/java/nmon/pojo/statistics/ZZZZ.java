package nmon.pojo.statistics;

import nmon.pojo.statistics.disk.*;
import nmon.pojo.statistics.network.NetIO;
import nmon.pojo.statistics.network.NetPacket;
import nmon.pojo.statistics.system.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 3:13
 * To change this template use File | Settings | File Templates.
 */
public class ZZZZ {
    private String key;
    private String date;
    private String time;
    private CpuAll cpuAll;
    private Memory memory;
    private VM vm;
    private Proc proc;

    private List<Cpu> cpuList = new ArrayList<Cpu>();
    private List<Top> topList = new ArrayList<Top>();
    private List<NetIO> netIOList = new ArrayList<NetIO>();
    private List<NetPacket> netPacketList = new ArrayList<NetPacket>();
    private List<Busy> diskBusyList = new ArrayList<Busy>();
    private List<Read> diskReadList = new ArrayList<Read>();
    private List<Write> diskWriteList = new ArrayList<Write>();
    private List<Xfer> diskXferList = new ArrayList<Xfer>();
    private List<Bsize> diskBsizeList = new ArrayList<Bsize>();

    public List<Busy> getDiskBusyList() {
        return diskBusyList;
    }

    public void setDiskBusyList(List<Busy> diskBusyList) {
        this.diskBusyList = diskBusyList;
    }

    public List<Read> getDiskReadList() {
        return diskReadList;
    }

    public void setDiskReadList(List<Read> diskReadList) {
        this.diskReadList = diskReadList;
    }

    public List<Write> getDiskWriteList() {
        return diskWriteList;
    }

    public void setDiskWriteList(List<Write> diskWriteList) {
        this.diskWriteList = diskWriteList;
    }

    public List<Xfer> getDiskXferList() {
        return diskXferList;
    }

    public void setDiskXferList(List<Xfer> diskXferList) {
        this.diskXferList = diskXferList;
    }

    public List<NetIO> getNetIOList() {
        return netIOList;
    }

    public void setNetIOList(List<NetIO> netIOList) {
        this.netIOList = netIOList;
    }

    public List<NetPacket> getNetPacketList() {
        return netPacketList;
    }

    public void setNetPacketList(List<NetPacket> netPacketList) {
        this.netPacketList = netPacketList;
    }

    public Proc getProc() {
        return proc;
    }

    public void setProc(Proc proc) {
        this.proc = proc;
    }

    public VM getVm() {
        return vm;
    }

    public void setVm(VM vm) {
        this.vm = vm;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CpuAll getCpuAll() {
        return cpuAll;
    }

    public void setCpuAll(CpuAll cpuAll) {
        this.cpuAll = cpuAll;
    }

    public List<Cpu> getCpuList() {
        return cpuList;
    }

    public void setCpuList(List<Cpu> cpuList) {
        this.cpuList = cpuList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Top> getTopList() {
        return topList;
    }

    public void setTopList(List<Top> topList) {
        this.topList = topList;
    }

    public void addCpu(Cpu cpu) {
        cpuList.add(cpu);
    }

    public void addTop(Top top){
        topList.add(top);
    }

    public void addNetIO(NetIO netIO){
        netIOList.add(netIO);
    }

    public void addNetPacket(NetPacket netPacket){
        netPacketList.add(netPacket);
    }

    public void addDiskBusy(Busy diskBusy){
        diskBusyList.add(diskBusy);
    }

    public void addDiskRead(Read diskRead){
        diskReadList.add(diskRead);
    }

    public void addDiskWrite(Write diskWrite){
        diskWriteList.add(diskWrite);
    }

    public void addDiskXfer(Xfer diskXfer){
        diskXferList.add(diskXfer);
    }

    public void addDiskBsize(Bsize diskBsize){
        diskBsizeList.add(diskBsize);
    }


}
