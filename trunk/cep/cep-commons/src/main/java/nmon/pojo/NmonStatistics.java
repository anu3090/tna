package nmon.pojo;

import nmon.pojo.header.AAA;
import nmon.pojo.header.BBBP;
import nmon.pojo.statistics.ZZZZ;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 21.
 * Time: PM 2:44
 * To change this template use File | Settings | File Templates.
 */
public class NmonStatistics implements Serializable {
    
    private AAA aaa;
    private BBBP bbbp;
    private ZZZZ zzzz;

    public NmonStatistics(AAA aaa, BBBP bbbp, ZZZZ zzzz) {
        this.aaa = aaa;
        this.bbbp = bbbp;
        this.zzzz = zzzz;
    }

    public AAA getAaa() {
        return aaa;
    }

    public void setAaa(AAA aaa) {
        this.aaa = aaa;
    }

    public BBBP getBbbp() {
        return bbbp;
    }

    public void setBbbp(BBBP bbbp) {
        this.bbbp = bbbp;
    }

    public ZZZZ getZzzz() {
        return zzzz;
    }

    public void setZzzz(ZZZZ zzzz) {
        this.zzzz = zzzz;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("NmonStatistic");
        sb.append("{aaa=").append(aaa);
        sb.append(", bbbp=").append(bbbp);
        sb.append(", zzzz=").append(zzzz);
        sb.append('}');
        return sb.toString();
    }
}
