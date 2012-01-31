package com.tedwon.flume.client;

import flume.thrift.Priority;
import flume.thrift.ThriftFlumeEvent;
import flume.thrift.ThriftFlumeEventServer;
import org.apache.commons.io.FileUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scribe.thrift.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Flume Client in Java Class.
 * <p/>
 * <p/>This class read a line from a local file and
 * <p/>send the line message to the Flume central server.
 *
 * @author <a href=mailto:kiora1120@gmail.com">Tea Joon</a>
 * @version 1.0
 */
public class FlumeClient {

    private static Logger logger = LoggerFactory.getLogger(FlumeClient.class);

    private static String scribeCategory = "default";
//    private static String scribeHost = "localhost";
    private static String flumeHost = "muda1120.cafe24.com";
    private static int flumePort = 35865;


    public static void main(String[] args) {

        try {
            // Read a file from local file system

            String filePath = "/tmp/dummy.dat";
            File inputFile = FileUtils.getFile(filePath);
            InputStream input = FileUtils.openInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();


            // Open connection to Scribe Server

            TSocket sock = new TSocket(new Socket(FlumeClient.flumeHost, FlumeClient.flumePort));
            TFramedTransport transport = new TFramedTransport(sock);

            TBinaryProtocol protocol = new TBinaryProtocol(transport, false, false);
//            transport.open();

            ThriftFlumeEventServer.Client client = new ThriftFlumeEventServer.Client(protocol);

            double start = System.currentTimeMillis();
            logger.debug("Start Time: " + start);

            while (line != null) {

                perform(client, line);

                line = reader.readLine();

            }

            double curr = System.currentTimeMillis();
            double executiontime = (curr - start) / 1000;
            logger.debug("Execution Time: " + executiontime + " sec");

            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void perform(ThriftFlumeEventServer.Client client, String message) throws TException {
        ThriftFlumeEvent event = new ThriftFlumeEvent(
                System.currentTimeMillis(),
                Priority.INFO,
                ByteBuffer.wrap(message.getBytes()),
                System.nanoTime(),
            "muda1120.cafe24.com",
            new HashMap<String,ByteBuffer>()
        );
//        event.setBody(message.getBytes());

        client.append(event);
//        client.send_append(event);

    }
}
