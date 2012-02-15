package nmon.pojo.header;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: PM 4:07
 * To change this template use File | Settings | File Templates.
 */
public class AAA {

    private String host;
    private String interval;
    private String progname;
    private String date;
    private String disks;
    private String version;
    private String time;
    private String command;
    private String disksPerLine;
    private String snapshots;
    private String user;
    private String runname;
    private String procStatVariables;
    private String cpus;
    private List<String> OS;
    private List<String> maxDisks;

    public String getCpus() {
        return cpus;
    }

    public void setCpus(String cpus) {
        this.cpus = cpus;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisks() {
        return disks;
    }

    public void setDisks(String disks) {
        this.disks = disks;
    }

    public String getDisksPerLine() {
        return disksPerLine;
    }

    public void setDisksPerLine(String disksPerLine) {
        this.disksPerLine = disksPerLine;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public List<String> getMaxDisks() {
        return maxDisks;
    }

    public void setMaxDisks(List<String> maxDisks) {
        this.maxDisks = maxDisks;
    }

    public List<String> getOS() {
        return OS;
    }

    public void setOS(List<String> OS) {
        this.OS = OS;
    }

    public String getProcStatVariables() {
        return procStatVariables;
    }

    public void setProcStatVariables(String procStatVariables) {
        this.procStatVariables = procStatVariables;
    }

    public String getRunname() {
        return runname;
    }

    public void setRunname(String runname) {
        this.runname = runname;
    }

    public String getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(String snapshots) {
        this.snapshots = snapshots;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProgname() {
        return progname;
    }

    public void setProgname(String progname) {
        this.progname = progname;
    }

}
