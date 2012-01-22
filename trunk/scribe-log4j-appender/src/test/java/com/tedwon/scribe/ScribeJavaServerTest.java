package com.tedwon.scribe;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
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
public class ScribeJavaServerTest {

    @Test
    public void runServer() {

        ScribeJavaServer server = new ScribeJavaServer();
        server.runServer();

    }
}
