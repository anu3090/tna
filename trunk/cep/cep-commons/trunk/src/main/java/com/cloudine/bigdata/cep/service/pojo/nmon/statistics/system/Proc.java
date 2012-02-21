package com.cloudine.bigdata.cep.service.pojo.nmon.statistics.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 8:24
 * To change this template use File | Settings | File Templates.
 */
public class Proc implements Serializable {
    private String runnable;
    private String blocked;
    private String pswitch;
    private String syscall;
    private String read;
    private String write;
    private String fork;
    private String exec;
    private String sem;
    private String msg;

    public Proc(String runnable, String blocked, String pswitch, String syscall, String read, String write, String fork, String exec, String sem, String msg) {
        this.runnable = runnable;
        this.blocked = blocked;
        this.pswitch = pswitch;
        this.syscall = syscall;
        this.read = read;
        this.write = write;
        this.fork = fork;
        this.exec = exec;
        this.sem = sem;
        this.msg = msg;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPswitch() {
        return pswitch;
    }

    public void setPswitch(String pswitch) {
        this.pswitch = pswitch;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getRunnable() {
        return runnable;
    }

    public void setRunnable(String runnable) {
        this.runnable = runnable;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getSyscall() {
        return syscall;
    }

    public void setSyscall(String syscall) {
        this.syscall = syscall;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    @Override
    public String toString() {
        return "Proc{" +
                "blocked='" + blocked + '\'' +
                ", runnable='" + runnable + '\'' +
                ", pswitch='" + pswitch + '\'' +
                ", syscall='" + syscall + '\'' +
                ", read='" + read + '\'' +
                ", write='" + write + '\'' +
                ", fork='" + fork + '\'' +
                ", exec='" + exec + '\'' +
                ", sem='" + sem + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
