package com.tedwon.scribe;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import scribe.thrift.LogEntry;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ted
 * Date: 1/22/12
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScribeJavaClient {

    private static String scribeCategory = "default";

    public static void main(String[] args) {

        try {

//            TSocket sock = new TSocket(new Socket("115.68.2.182", 1464));
//            TSocket sock = new TSocket(new Socket("115.68.2.182", 2463));
            TSocket sock = new TSocket(new Socket("localhost", ScribeJavaServer.PORT));
            TFramedTransport transport = new TFramedTransport(sock);
            TBinaryProtocol protocol = new TBinaryProtocol(transport, false, false);

            scribe.thrift.scribe.Client client = new scribe.thrift.scribe.Client(protocol);

            perform(client);

            transport.close();

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    private static void perform(scribe.thrift.scribe.Client client) throws TException {

        List<LogEntry> logEntries = new ArrayList<LogEntry>(1);

        String message = String.format("%s", "Message from My Test Client Application");
        LogEntry entry = new LogEntry(scribeCategory, message);
        logEntries.add(entry);

        client.Log(logEntries);

    }
}
