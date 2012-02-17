package nmon.pojo.statistics.disk;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 17.
 * Time: PM 2:42
 * To change this template use File | Settings | File Templates.
 */
public class Bsize {
    private String diskName;
    private String value;

    public Bsize(String diskName, String value) {
        this.diskName = diskName;
        this.value = value;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Busy{" +
                "diskName='" + diskName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
