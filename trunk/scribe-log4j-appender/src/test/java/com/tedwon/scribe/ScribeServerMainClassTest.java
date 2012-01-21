package com.tedwon.scribe;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.junit.Test;
import scribe.thrift.scribe;

/**
 * Scribe Client Quick Start Class.
 * <p/>See https://github.com/alexlod/scribe-log4j-appender/blob/master/ScribeAppender.java
 *
 * @author <a href="mailto:tedd824@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class ScribeServerMainClassTest {

    @Test
    public void runServer() {
        try {

            TServerSocket serverTransport = new TServerSocket(2463);
            scribe.Processor processor = new scribe.Processor(new ScribeLogImpl());
            TBinaryProtocol.Factory protFactory = new TBinaryProtocol.Factory(false, false);
            TServer server = new TThreadPoolServer(processor, serverTransport, protFactory);

            System.out.println("Starting server on port 2463 ...");

            server.serve();


        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
