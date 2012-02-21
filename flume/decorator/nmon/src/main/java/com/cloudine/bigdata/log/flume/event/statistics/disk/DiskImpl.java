package com.cloudine.bigdata.log.flume.event.statistics.disk;


import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 20.
 * Time: AM 11:29
 * To change this template use File | Settings | File Templates.
 */
public class DiskImpl implements Disk, Serializable {
    private String diskName;
    private String value;
    
    
    @Override
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }


    @Override
    public String getDiskName() {
        return diskName;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DiskImpl{" +
                "diskName='" + diskName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
