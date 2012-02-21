package com.cloudine.bigdata.log.flume.event.statistics.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 17.
 * Time: AM 11:01
 * To change this template use File | Settings | File Templates.
 */
public class Memory implements Serializable {
    private String memTotal;
    private String highTotal;
    private String lowTotal;
    private String swapTotal;
    private String memFree;
    private String highFree;
    private String lowFree;
    private String swapFree;
    private String memShared;
    private String cached;
    private String active;
    private String bigFree;
    private String buffers;
    private String swapCached;
    private String inActive;


    public Memory(String memTotal, String highTotal, String lowTotal, String swapTotal, String memFree, String highFree, String lowFree, String swapFree, String memShared, String cached, String active, String bigFree, String buffers, String swapCached, String inActive) {
        this.memTotal = memTotal;
        this.highTotal = highTotal;
        this.lowTotal = lowTotal;
        this.swapTotal = swapTotal;
        this.memFree = memFree;
        this.highFree = highFree;
        this.lowFree = lowFree;
        this.swapFree = swapFree;
        this.memShared = memShared;
        this.cached = cached;
        this.active = active;
        this.bigFree = bigFree;
        this.buffers = buffers;
        this.swapCached = swapCached;
        this.inActive = inActive;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getBigFree() {
        return bigFree;
    }

    public void setBigFree(String bigFree) {
        this.bigFree = bigFree;
    }

    public String getBuffers() {
        return buffers;
    }

    public void setBuffers(String buffers) {
        this.buffers = buffers;
    }

    public String getCached() {
        return cached;
    }

    public void setCached(String cached) {
        this.cached = cached;
    }

    public String getHighFree() {
        return highFree;
    }

    public void setHighFree(String highFree) {
        this.highFree = highFree;
    }

    public String getHighTotal() {
        return highTotal;
    }

    public void setHighTotal(String highTotal) {
        this.highTotal = highTotal;
    }

    public String getInActive() {
        return inActive;
    }

    public void setInActive(String inActive) {
        this.inActive = inActive;
    }

    public String getLowFree() {
        return lowFree;
    }

    public void setLowFree(String lowFree) {
        this.lowFree = lowFree;
    }

    public String getLowTotal() {
        return lowTotal;
    }

    public void setLowTotal(String lowTotal) {
        this.lowTotal = lowTotal;
    }

    public String getMemFree() {
        return memFree;
    }

    public void setMemFree(String memFree) {
        this.memFree = memFree;
    }

    public String getMemShared() {
        return memShared;
    }

    public void setMemShared(String memShared) {
        this.memShared = memShared;
    }

    public String getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(String memTotal) {
        this.memTotal = memTotal;
    }

    public String getSwapCached() {
        return swapCached;
    }

    public void setSwapCached(String swapCached) {
        this.swapCached = swapCached;
    }

    public String getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(String swapFree) {
        this.swapFree = swapFree;
    }

    public String getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(String swapTotal) {
        this.swapTotal = swapTotal;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "active='" + active + '\'' +
                ", memTotal='" + memTotal + '\'' +
                ", highTotal='" + highTotal + '\'' +
                ", lowTotal='" + lowTotal + '\'' +
                ", swapTotal='" + swapTotal + '\'' +
                ", memFree='" + memFree + '\'' +
                ", highFree='" + highFree + '\'' +
                ", lowFree='" + lowFree + '\'' +
                ", swapFree='" + swapFree + '\'' +
                ", memShared='" + memShared + '\'' +
                ", cached='" + cached + '\'' +
                ", bigFree='" + bigFree + '\'' +
                ", buffers='" + buffers + '\'' +
                ", swapCached='" + swapCached + '\'' +
                ", inActive='" + inActive + '\'' +
                '}';
    }
}
