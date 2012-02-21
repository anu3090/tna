package com.cloudine.bigdata.cep.service.pojo.nmon.statistics.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 3:13
 * To change this template use File | Settings | File Templates.
 */
public class CpuAll implements Serializable {
    private String user;
    private String sys;
    private String wait;
    private String idle;
    private String busy;
    private String cpus;

    public CpuAll(String user, String sys, String wait, String idle, String busy, String cpus) {
        this.user = user;
        this.sys = sys;
        this.wait = wait;
        this.idle = idle;
        this.busy = busy;
        this.cpus = cpus;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getCpus() {
        return cpus;
    }

    public void setCpus(String cpus) {
        this.cpus = cpus;
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
        return "CpuAll{" +
                "busy='" + busy + '\'' +
                ", user='" + user + '\'' +
                ", sys='" + sys + '\'' +
                ", wait='" + wait + '\'' +
                ", idle='" + idle + '\'' +
                ", cpus='" + cpus + '\'' +
                '}';
    }
}
