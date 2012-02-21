package com.cloudine.bigdata.log.flume.decorator;

import com.cloudera.flume.conf.Context;
import com.cloudera.flume.conf.SinkFactory;
import com.cloudera.flume.core.Event;
import com.cloudera.flume.core.EventImpl;
import com.cloudera.flume.core.EventSink;
import com.cloudera.flume.core.EventSinkDecorator;
import com.cloudera.util.Pair;

import com.cloudine.bigdata.log.flume.commons.NmonCollector;
import com.cloudine.bigdata.log.flume.event.NmonStatistics;
import com.cloudine.bigdata.log.flume.event.statistics.ZZZZ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 9.
 * Time: PM 1:20
 * To change this template use File | Settings | File Templates.
 */
public class NmonDecorator<S extends EventSink> extends EventSinkDecorator<S> {
    Logger logger = LoggerFactory.getLogger(NmonDecorator.class);

    ZZZZ zzzz;

    public NmonDecorator(S s) {
        super(s);
    }

    @Override
    public void append(Event event) throws IOException, InterruptedException {

        String line = new String(event.getBody());

        if ("AAA".equals(line.split(",")[0])) NmonCollector.collectAAA(line);
        if ("BBBP".equals(line.split(",")[0])) NmonCollector.collectBBBP(line);
        if (line.split(",")[1].contains("Network I/O")) NmonCollector.collectNetworkOrd(line);
        if (line.split(",")[1].contains("Disk Read")) NmonCollector.collectDiskOrd(line);


        // Validate Statistics
        if ("ZZZZ".equals(line.split(",")[0])) {
            if (zzzz != null) {

                NmonStatistics statistics = new NmonStatistics(NmonCollector.getAAA(),NmonCollector.getBBBP(),zzzz);

                byte[] resultByte = null;

                ObjectOutput out = null;
                ByteArrayOutputStream bos = null;
                try {
                    bos = new ByteArrayOutputStream();
                    out = new ObjectOutputStream(bos);
                    out.writeObject(statistics);
                    resultByte = bos.toByteArray();

                } catch (IOException e) {
                    logger.error(e.getMessage());
                } finally {
                    if (bos != null) bos.close();
                    if (out != null) out.close();
                }


                EventImpl eventImpl = new EventImpl(resultByte,
                        event.getTimestamp(), event.getPriority(), event.getNanos(), event.getHost(),
                        event.getAttrs());


                super.append(eventImpl);

            }
            zzzz = NmonCollector.collectZZZZ(line);
        }

        if (zzzz != null) {
            if (line.split(",")[0].contains("CPU") && !line.split(",")[0].equals("CPU_ALL"))
                zzzz.addCpu(NmonCollector.collectCPU(line));
            if (line.split(",")[0].contains("CPU_ALL")) zzzz.setCpuAll(NmonCollector.collectCPUALL(line));
            if (line.split(",")[0].contains("MEM")) zzzz.setMemory(NmonCollector.collectMemory(line));
            if (line.split(",")[0].contains("VM")) zzzz.setVm(NmonCollector.collectVM(line));
            if (line.split(",")[0].contains("TOP")) zzzz.addTop(NmonCollector.collectTOP(line));
            if (line.split(",")[0].contains("PROC")) zzzz.setProc(NmonCollector.collectProc(line));
            if (line.split(",")[0].contains("NET") &&
                    !line.split(",")[1].contains("Network I/O"))
                zzzz.setNetIOList(NmonCollector.collectNetworkIO(line));
            if (line.split(",")[0].contains("NETPACKET") &&
                    !line.split(",")[1].contains("Network Packets"))
                zzzz.setNetIOList(NmonCollector.collectNetworkIO(line));
            if (line.split(",")[0].contains("DISKBUSY") &&
                    !line.split(",")[0].contains("Disk %Busy"))
                zzzz.setDiskBusyList(NmonCollector.collectDisk(line));
            if (line.split(",")[0].contains("DISKREAD") &&
                    !line.split(",")[0].contains("Disk Read"))
                zzzz.setDiskReadList(NmonCollector.collectDisk(line));
            if (line.split(",")[0].contains("DISKWRITE") &&
                    !line.split(",")[0].contains("Disk Write"))
                zzzz.setDiskWriteList(NmonCollector.collectDisk(line));
            if (line.split(",")[0].contains("DISKXFER") &&
                    !line.split(",")[0].contains("Disk transfers"))
                zzzz.setDiskXferList(NmonCollector.collectDisk(line));
            if (line.split(",")[0].contains("DISKBSIZE") &&
                    !line.split(",")[0].contains("Disk Block Size"))
                zzzz.setDiskBsizeList(NmonCollector.collectDisk(line));

        }

    }


    public static SinkFactory.SinkDecoBuilder builder() {
        return new SinkFactory.SinkDecoBuilder() {
            @Override
            public EventSinkDecorator<EventSink> build(Context context, String... argv) {

                return new NmonDecorator<EventSink>(null);
            }

        };

    }

    public static List<Pair<String, SinkFactory.SinkDecoBuilder>> getDecoratorBuilders() {
        List<Pair<String, SinkFactory.SinkDecoBuilder>> builders =
                new ArrayList<Pair<String, SinkFactory.SinkDecoBuilder>>();
        builders.add(new Pair<String, SinkFactory.SinkDecoBuilder>("nmonDeco2", builder()));

        return builders;
    }


}