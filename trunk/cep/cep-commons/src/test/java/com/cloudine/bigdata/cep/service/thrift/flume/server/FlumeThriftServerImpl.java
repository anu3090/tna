package com.cloudine.bigdata.cep.service.thrift.flume.server;

import com.cloudine.bigdata.cep.service.pojo.nmon.statistics.ZZZZ;
import com.cloudine.bigdata.cep.service.thrift.flume.ThriftFlumeEvent;
import com.cloudine.bigdata.cep.service.thrift.flume.ThriftFlumeEventServer;
import org.apache.thrift.TException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 2.
 * Time: 오전 10:28
 * To change this template use File | Settings | File Templates.
 */
public class FlumeThriftServerImpl implements ThriftFlumeEventServer.Iface{
    long inputCnt = 0;
    @Override
    public void append(ThriftFlumeEvent evt) throws TException {
        inputCnt++;

        ByteArrayInputStream bis = new ByteArrayInputStream(evt.getBody());
        ObjectInput in = null;
        ZZZZ o = null;
        try {
            in = new ObjectInputStream(bis);
            o = (ZZZZ)in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(o.toString()+"\r");
        //System.out.println("Input Count dddd-pasdasdpp : "+inputCnt+" - Event Priority ["+evt.getPriority()+"] - "+new String(evt.getBody()));
    }

    @Override
    public void close() throws TException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
