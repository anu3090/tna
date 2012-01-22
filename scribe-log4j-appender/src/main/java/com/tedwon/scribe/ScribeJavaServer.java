package com.tedwon.scribe;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Created by IntelliJ IDEA.
 * User: ted
 * Date: 1/22/12
 * Time: 8:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScribeJavaServer {

    public static ScribeLogImpl handler;

    public static scribe.thrift.scribe.Processor processor;

    public static int PORT = 2463;

    public void runServer() {

        try {

            handler = new ScribeLogImpl();
            processor = new scribe.thrift.scribe.Processor(handler);

            TNonblockingServerSocket socket = new TNonblockingServerSocket(PORT);

            final TServer server = new THsHaServer(processor, socket,
                    new TFramedTransport.Factory(), new TBinaryProtocol.Factory());

            System.out.println("Starting the ScribeJavaServer... on PORT: " + PORT);

            server.serve();

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ScribeJavaServer server = new ScribeJavaServer();
        server.runServer();

    }
}
