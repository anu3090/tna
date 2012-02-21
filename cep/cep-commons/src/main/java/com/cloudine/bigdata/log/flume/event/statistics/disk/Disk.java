package com.cloudine.bigdata.log.flume.event.statistics.disk;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 20.
 * Time: AM 11:03
 * To change this template use File | Settings | File Templates.
 */
public interface Disk {
    
    public void setDiskName(String diskName);
    public String getDiskName();
    public void setValue(String value);
    public String getValue();

}
