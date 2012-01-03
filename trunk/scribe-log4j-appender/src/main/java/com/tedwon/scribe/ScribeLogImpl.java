package com.tedwon.scribe;

import com.facebook.fb303.fb_status;
import org.apache.thrift.TException;
import scribe.thrift.LogEntry;
import scribe.thrift.ResultCode;
import scribe.thrift.scribe;

import java.util.List;
import java.util.Map;

/**
 * Scribe Server Log Impl Class.
 */
public class ScribeLogImpl implements scribe.Iface {

    @Override
    public ResultCode Log(List<LogEntry> messages) throws TException {

        System.out.println("test");

        return ResultCode.OK;
    }

    @Override
    public String getName() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getVersion() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public fb_status getStatus() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getStatusDetails() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, Long> getCounters() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getCounter(String key) throws TException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setOption(String key, String value) throws TException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getOption(String key) throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String> getOptions() throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getCpuProfile(int profileDurationInSec) throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long aliveSince() throws TException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reinitialize() throws TException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void shutdown() throws TException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

