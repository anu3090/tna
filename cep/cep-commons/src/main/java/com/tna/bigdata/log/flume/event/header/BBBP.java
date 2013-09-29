package com.tna.log.flume.event.header;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: PM 4:28
 * To change this template use File | Settings | File Templates.
 */
public class BBBP  implements Serializable {

    private List<ProcNetDev> procNetDevList = new ArrayList<ProcNetDev>();


    public List<ProcNetDev> getProcNetDevList() {
        return procNetDevList;
    }

    public void setProcNetDevList(List<ProcNetDev> procNetDevList) {
        this.procNetDevList = procNetDevList;
    }

    public void setProcNetDev(ProcNetDev procNetDev) {
        procNetDevList.add(procNetDev);
    }

    public int getProdNetDevListSize(){
        return procNetDevList.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BBBP");
        sb.append("{procNetDevList=").append(procNetDevList);
        sb.append('}');
        return sb.toString();
    }
}
