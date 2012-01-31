package com.tedwon.flume.client;

import flume.thrift.Priority;
import flume.thrift.ThriftFlumeEvent;
import flume.thrift.ThriftFlumeEventServer;
import org.apache.commons.io.FileUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


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
//    private static String flumeHost = "muda1120.cafe24.com";
    private static String flumeHost = "tedwon.com";
    private static int flumePort = 35853;


    public static void main(String[] args) {

        try {
            // Read a file from local file system

            String filePath = "/tmp/dummy.dat";
            File inputFile = FileUtils.getFile(filePath);
            InputStream input = FileUtils.openInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();

            int timeout = 100000;

            TTransport transport = new TSocket(FlumeClient.flumeHost, FlumeClient.flumePort, timeout);
            TStatsTransport stats = new TStatsTransport(transport);

            TProtocol protocol = new TBinaryProtocol(stats);
            transport.open();
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
//            client.send_close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void perform(ThriftFlumeEventServer.Client client, String message) throws TException, IOException {

        ThriftFlumeEvent event = new ThriftFlumeEvent();

        event.setPriority(Priority.INFO);
        event.setTimestamp(System.currentTimeMillis());
        event.setNanos(System.nanoTime());
        event.setBody(message.getBytes());
        client.append(event);
////        client.close();
//
//        client.send_close();

    }
}
