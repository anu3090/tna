package nmon.decorator;

import com.cloudera.flume.conf.Context;
import com.cloudera.flume.conf.SinkFactory;
import com.cloudera.flume.core.Event;
import com.cloudera.flume.core.EventImpl;
import com.cloudera.flume.core.EventSink;
import com.cloudera.flume.core.EventSinkDecorator;
import com.cloudera.util.Pair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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

    public NmonDecorator(S s) {
        super(s);
    }
    
    private long GLOBAL_TEST_INT = 0;
    
    @Override
    public void append(Event event) throws IOException, InterruptedException {
        GLOBAL_TEST_INT ++;
        String testAppendMsg = GLOBAL_TEST_INT+" : "+new String(event.getBody());
        EventImpl eventImpl = new EventImpl(testAppendMsg.getBytes(),
                event.getTimestamp(),event.getPriority(),event.getNanos(),event.getHost(),
                event.getAttrs());

        super.append(eventImpl);
    }
    
    
    public static SinkFactory.SinkDecoBuilder builder(){
        return new SinkFactory.SinkDecoBuilder() {
            @Override
            public EventSinkDecorator<EventSink> build(Context context, String... argv) {

                return new NmonDecorator<EventSink>(null);
            }

        };

    }
    
    public static List<Pair<String, SinkFactory.SinkDecoBuilder>> getDecoratorBuilders(){
        List<Pair<String,SinkFactory.SinkDecoBuilder>> builders = 
                new ArrayList<Pair<String,SinkFactory.SinkDecoBuilder>>();
        builders.add(new Pair<String, SinkFactory.SinkDecoBuilder>("nmonDeco",builder()));

        return builders;
    }
    
    
}
