package nmon.pojo.header;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: AM 11:16
 * To change this template use File | Settings | File Templates.
 */
public class ProcNetDev {

    private String face;
    private String receiveBytes;
    private String receivePackets;
    private String receiveErrs;
    private String receiveDrops;
    private String receiveFifo;
    private String receiveFrame;
    private String receiveCompressed;
    private String receiveMulticast;
    private String transmitBytes;
    private String transmitPackets;
    private String transmitErrs;
    private String transmitDrop;
    private String transmitFifo;
    private String transmitColls;
    private String transmitCarrier;
    private String transmitCompressed;

    public ProcNetDev() {
    }

    public ProcNetDev(String receiveBytes, String receivePackets, String receiveErrs, String receiveDrops, String receiveFifo, String receiveFrame, String receiveCompressed, String receiveMulticast, String transmitBytes, String transmitPackets, String transmitErrs, String transmitDrop, String transmitFifo, String transmitColls, String transmitCarrier, String transmitCompressed) {
        this.receiveBytes = receiveBytes;
        this.receivePackets = receivePackets;
        this.receiveErrs = receiveErrs;
        this.receiveDrops = receiveDrops;
        this.receiveFifo = receiveFifo;
        this.receiveFrame = receiveFrame;
        this.receiveCompressed = receiveCompressed;
        this.receiveMulticast = receiveMulticast;
        this.transmitBytes = transmitBytes;
        this.transmitPackets = transmitPackets;
        this.transmitErrs = transmitErrs;
        this.transmitDrop = transmitDrop;
        this.transmitFifo = transmitFifo;
        this.transmitColls = transmitColls;
        this.transmitCarrier = transmitCarrier;
        this.transmitCompressed = transmitCompressed;
    }

    public String getReceiveBytes() {
        return receiveBytes;
    }

    public void setReceiveBytes(String receiveBytes) {
        this.receiveBytes = receiveBytes;
    }

    public String getReceiveCompressed() {
        return receiveCompressed;
    }

    public void setReceiveCompressed(String receiveCompressed) {
        this.receiveCompressed = receiveCompressed;
    }

    public String getReceiveDrops() {
        return receiveDrops;
    }

    public void setReceiveDrops(String receiveDrops) {
        this.receiveDrops = receiveDrops;
    }

    public String getReceiveErrs() {
        return receiveErrs;
    }

    public void setReceiveErrs(String receiveErrs) {
        this.receiveErrs = receiveErrs;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getReceiveFifo() {
        return receiveFifo;
    }

    public void setReceiveFifo(String receiveFifo) {
        this.receiveFifo = receiveFifo;
    }

    public String getReceiveFrame() {
        return receiveFrame;
    }

    public void setReceiveFrame(String receiveFrame) {
        this.receiveFrame = receiveFrame;
    }

    public String getReceiveMulticast() {
        return receiveMulticast;
    }

    public void setReceiveMulticast(String receiveMulticast) {
        this.receiveMulticast = receiveMulticast;
    }

    public String getReceivePackets() {
        return receivePackets;
    }

    public void setReceivePackets(String receivePackets) {
        this.receivePackets = receivePackets;
    }

    public String getTransmitBytes() {
        return transmitBytes;
    }

    public void setTransmitBytes(String transmitBytes) {
        this.transmitBytes = transmitBytes;
    }

    public String getTransmitCarrier() {
        return transmitCarrier;
    }

    public void setTransmitCarrier(String transmitCarrier) {
        this.transmitCarrier = transmitCarrier;
    }

    public String getTransmitColls() {
        return transmitColls;
    }

    public void setTransmitColls(String transmitColls) {
        this.transmitColls = transmitColls;
    }

    public String getTransmitCompressed() {
        return transmitCompressed;
    }

    public void setTransmitCompressed(String transmitCompressed) {
        this.transmitCompressed = transmitCompressed;
    }

    public String getTransmitDrop() {
        return transmitDrop;
    }

    public void setTransmitDrop(String transmitDrop) {
        this.transmitDrop = transmitDrop;
    }

    public String getTransmitErrs() {
        return transmitErrs;
    }

    public void setTransmitErrs(String transmitErrs) {
        this.transmitErrs = transmitErrs;
    }

    public String getTransmitFifo() {
        return transmitFifo;
    }

    public void setTransmitFifo(String transmitFifo) {
        this.transmitFifo = transmitFifo;
    }

    public String getTransmitPackets() {
        return transmitPackets;
    }

    public void setTransmitPackets(String transmitPackets) {
        this.transmitPackets = transmitPackets;
    }

    @Override
    public String toString() {
        return "ProcNetDev{" +
                "face='" + face + '\'' +
                ", receiveBytes='" + receiveBytes + '\'' +
                ", receivePackets='" + receivePackets + '\'' +
                ", receiveErrs='" + receiveErrs + '\'' +
                ", receiveDrops='" + receiveDrops + '\'' +
                ", receiveFifo='" + receiveFifo + '\'' +
                ", receiveFrame='" + receiveFrame + '\'' +
                ", receiveCompressed='" + receiveCompressed + '\'' +
                ", receiveMulticast='" + receiveMulticast + '\'' +
                ", transmitBytes='" + transmitBytes + '\'' +
                ", transmitPackets='" + transmitPackets + '\'' +
                ", transmitErrs='" + transmitErrs + '\'' +
                ", transmitDrop='" + transmitDrop + '\'' +
                ", transmitFifo='" + transmitFifo + '\'' +
                ", transmitColls='" + transmitColls + '\'' +
                ", transmitCarrier='" + transmitCarrier + '\'' +
                ", transmitCompressed='" + transmitCompressed + '\'' +
                '}';
    }
}
