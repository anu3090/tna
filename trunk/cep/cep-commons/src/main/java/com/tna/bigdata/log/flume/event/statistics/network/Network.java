package com.tna.log.flume.event.statistics.network;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 20.
 * Time: PM 1:31
 * To change this template use File | Settings | File Templates.
 */
public interface Network {
    public String getNicName();
    public void setNicName(String nicName);
    public String getRead();
    public void setRead(String read);
    public String getWrite();
    public void setWrite(String write);
    public String toString();
}
