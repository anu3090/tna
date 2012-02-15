package nmon.pojo.statistics;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 8:11
 * To change this template use File | Settings | File Templates.
 */
public class Top {  
    private String pid;
    private String cpu;
    private String usr;
    private String sys;
    private String size;
    private String resSet;
    private String resText;
    private String resData;
    private String shdLib;
    private String minorFault;
    private String majorFault;
    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMajorFault() {
        return majorFault;
    }

    public void setMajorFault(String majorFault) {
        this.majorFault = majorFault;
    }

    public String getMinorFault() {
        return minorFault;
    }

    public void setMinorFault(String minorFault) {
        this.minorFault = minorFault;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getResData() {
        return resData;
    }

    public void setResData(String resData) {
        this.resData = resData;
    }

    public String getResSet() {
        return resSet;
    }

    public void setResSet(String resSet) {
        this.resSet = resSet;
    }

    public String getResText() {
        return resText;
    }

    public void setResText(String resText) {
        this.resText = resText;
    }

    public String getShdLib() {
        return shdLib;
    }

    public void setShdLib(String shdLib) {
        this.shdLib = shdLib;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }
}
