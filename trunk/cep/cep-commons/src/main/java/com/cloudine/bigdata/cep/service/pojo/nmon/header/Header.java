package com.cloudine.bigdata.cep.service.pojo.nmon.header;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 14.
 * Time: PM 5:36
 * To change this template use File | Settings | File Templates.
 */
public class Header {
    
//    private AAA;
//    private BBBP;
    private Map<String, int[]> nicOrderMap = new HashMap<String, int[]>();
    private Map<String,Integer> diskOrderMap = new HashMap<String, Integer>();

    public Map<String, int[]> getNicOrderMap() {
        return nicOrderMap;
    }

    public Map<String, Integer> getDiskOrderMap() {
        return diskOrderMap;
    }

    public void addNicOrd(String nicName, int[] ordIdx){
        nicOrderMap.put(nicName,ordIdx);
    }

    public void addDiskOrd(String diskName, int ordIdx){
        diskOrderMap.put(diskName,ordIdx);
    }
}
