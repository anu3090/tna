package nmon.pojo.statistics;

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
    
    private List<Cpu> cpuList = new ArrayList<Cpu>();
    private List<Top> topList = new ArrayList<Top>();
    private List<Proc> procList = new ArrayList<Proc>();
    private CpuAll cpuAll;

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

    public List<Proc> getProcList() {
        return procList;
    }

    public void setProcList(List<Proc> procList) {
        this.procList = procList;
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

    public void addTop

}
