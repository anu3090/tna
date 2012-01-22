package com.tedwon.scribe;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

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
    
    public static int PORT = 9090;

    public void runServer() {

        try {

            handler = new ScribeLogImpl();
            processor = new scribe.thrift.scribe.Processor(handler);

            TServerTransport serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(processor, serverTransport);

            System.out.println("Starting the ScribeJavaServer... on PORT: " + 9090);

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
