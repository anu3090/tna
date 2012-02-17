package nmon.pojo.statistics.network;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 17.
 * Time: PM 2:30
 * To change this template use File | Settings | File Templates.
 */
public class NetIO {
    private String nicName;
    private String read;
    private String write;

    public NetIO(String nicName, String read, String write) {
        this.nicName = nicName;
        this.read = read;
        this.write = write;
    }

    public NetIO() {

    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    @Override
    public String toString() {
        return "NetIO{" +
                "nicName='" + nicName + '\'' +
                ", read='" + read + '\'' +
                ", write='" + write + '\'' +
                '}';
    }
}
