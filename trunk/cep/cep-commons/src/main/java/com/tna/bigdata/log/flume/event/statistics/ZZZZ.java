package com.tna.log.flume.event.statistics;

import com.tna.log.flume.event.statistics.disk.Disk;
import com.tna.log.flume.event.statistics.network.Network;
import com.tna.log.flume.event.statistics.system.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 3:13
 * To change this template use File | Settings | File Templates.
 */
public class ZZZZ implements Serializable {
    private String key;
    private String date;
    private String time;
    private CpuAll cpuAll;
    private Memory memory;
    private VM vm;
    private Proc proc;

    private List<Cpu> cpuList = new ArrayList<Cpu>();
    private List<Top> topList = new ArrayList<Top>();
    private List<Network> netIOList = new ArrayList<Network>();
    private List<Network> netPacketList = new ArrayList<Network>();
    private List<Disk> diskBusyList = new ArrayList<Disk>();
    private List<Disk> diskReadList = new ArrayList<Disk>();
    private List<Disk> diskWriteList = new ArrayList<Disk>();
    private List<Disk> diskXferList = new ArrayList<Disk>();
    private List<Disk> diskBsizeList = new ArrayList<Disk>();

    public List<Disk> getDiskBsizeList() {
        return diskBsizeList;
    }

    public void setDiskBsizeList(List<Disk> diskBsizeList) {
        this.diskBsizeList = diskBsizeList;
    }

    public List<Disk> getDiskBusyList() {
        return diskBusyList;
    }

    public void setDiskBusyList(List<Disk> diskBusyList) {
        this.diskBusyList = diskBusyList;
    }

    public List<Disk> getDiskReadList() {
        return diskReadList;
    }

    public void setDiskReadList(List<Disk> diskReadList) {
        this.diskReadList = diskReadList;
    }

    public List<Disk> getDiskWriteList() {
        return diskWriteList;
    }

    public void setDiskWriteList(List<Disk> diskWriteList) {
        this.diskWriteList = diskWriteList;
    }

    public List<Disk> getDiskXferList() {
        return diskXferList;
    }

    public void setDiskXferList(List<Disk> diskXferList) {
        this.diskXferList = diskXferList;
    }

    public List<Network> getNetIOList() {
        return netIOList;
    }

    public void setNetIOList(List<Network> netIOList) {
        this.netIOList = netIOList;
    }

    public List<Network> getNetPacketList() {
        return netPacketList;
    }

    public void setNetPacketList(List<Network> netPacketList) {
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

    public void addNetIO(Network netIO){
        netIOList.add(netIO);
    }

    public void addNetPacket(Network netPacket){
        netPacketList.add(netPacket);
    }

    public void addDiskBusy(Disk diskBusy){
        diskBusyList.add(diskBusy);
    }

    public void addDiskRead(Disk diskRead){
        diskReadList.add(diskRead);
    }

    public void addDiskWrite(Disk diskWrite){
        diskWriteList.add(diskWrite);
    }

    public void addDiskXfer(Disk diskXfer){
        diskXferList.add(diskXfer);
    }

    public void addDiskBsize(Disk diskBsize){
        diskBsizeList.add(diskBsize);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZZZZ");
        sb.append("{key='").append(key).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append(", cpuAll=").append(cpuAll);
        sb.append(", memory=").append(memory);
        sb.append(", vm=").append(vm);
        sb.append(", proc=").append(proc);
        sb.append(", cpuList=").append(cpuList);
        sb.append(", topList=").append(topList);
        sb.append(", netIOList=").append(netIOList);
        sb.append(", netPacketList=").append(netPacketList);
        sb.append(", diskBusyList=").append(diskBusyList);
        sb.append(", diskReadList=").append(diskReadList);
        sb.append(", diskWriteList=").append(diskWriteList);
        sb.append(", diskXferList=").append(diskXferList);
        sb.append(", diskBsizeList=").append(diskBsizeList);
        sb.append('}');
        return sb.toString();
    }
}
