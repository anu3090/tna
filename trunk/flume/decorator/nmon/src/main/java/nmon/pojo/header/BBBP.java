package nmon.pojo.header;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: PM 4:28
 * To change this template use File | Settings | File Templates.
 */
public class BBBP {

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
}
