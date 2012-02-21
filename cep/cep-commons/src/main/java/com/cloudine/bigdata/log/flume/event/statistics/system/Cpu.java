package com.cloudine.bigdata.log.flume.event.statistics.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 3:13
 * To change this template use File | Settings | File Templates.
 */
public class Cpu implements Serializable {
    private String cpuName;
    private String user;
    private String sys;
    private String wait;
    private String idle;

    public Cpu(String cpuName, String idle, String sys, String user, String wait) {
        this.cpuName = cpuName;
        this.idle = idle;
        this.sys = sys;
        this.user = user;
        this.wait = wait;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getIdle() {
        return idle;
    }

    public void setIdle(String idle) {
        this.idle = idle;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWait() {
        return wait;
    }

    public void setWait(String wait) {
        this.wait = wait;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "cpuName='" + cpuName + '\'' +
                ", user='" + user + '\'' +
                ", sys='" + sys + '\'' +
                ", wait='" + wait + '\'' +
                ", idle='" + idle + '\'' +
                '}';
    }
}
