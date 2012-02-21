package com.cloudine.bigdata.cep.service.thrift.flume.server;

import com.cloudine.bigdata.cep.service.thrift.flume.TSaneServerSocket;
import com.cloudine.bigdata.cep.service.thrift.flume.TSaneThreadPoolServer;
import com.cloudine.bigdata.cep.service.thrift.flume.ThriftFlumeEventServer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 2.
 * Time: 오전 9:44
 * To change this template use File | Settings | File Templates.
 */
public class FlumeThriftServer {
    private static Logger logger = LoggerFactory.getLogger(FlumeThriftServer.class);


    public static void main(String[] args) throws IOException {
        logger.debug("First Start");

        if (args.length < 1 || args == null) {
            System.out.println("Port must be input");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        try {
            ThriftFlumeEventServer.Processor processor = new ThriftFlumeEventServer.Processor(new FlumeThriftServerImpl());
            TBinaryProtocol.Factory protFactory = new TBinaryProtocol.Factory(true, true);

            TSaneServerSocket serverTransport = new TSaneServerSocket(port);
            TSaneThreadPoolServer server = new TSaneThreadPoolServer(processor, serverTransport, protFactory);
            logger.info(String.format(
                    "Starting blocking thread pool com.cloudine.bigdata.cep.service.thrift.flume.server on port %d...", port));

            server.start();

        } catch (TTransportException e) {
            throw new IOException("Failed to create event com.cloudine.bigdata.cep.service.thrift.flume.server " + e.getMessage(), e);
        }

    }


}
