package nmon.pojo.statistics.network;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 20.
 * Time: PM 1:33
 * To change this template use File | Settings | File Templates.
 */
public class NetworkImpl implements Network, Serializable {
    private String nicName;
    private String read;
    private String write;
    
    
    @Override
    public String getNicName() {
        return nicName;
    }

    @Override
    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    @Override
    public String getRead() {
        return read;
    }

    @Override
    public void setRead(String read) {
        this.read = read;
    }

    @Override
    public String getWrite() {
        return write;
    }

    @Override
    public void setWrite(String write) {
        this.write = write;
    }

    @Override
    public String toString() {
        return "NetworkImpl{" +
                "nicName='" + nicName + '\'' +
                ", read='" + read + '\'' +
                ", write='" + write + '\'' +
                '}';
    }


}
