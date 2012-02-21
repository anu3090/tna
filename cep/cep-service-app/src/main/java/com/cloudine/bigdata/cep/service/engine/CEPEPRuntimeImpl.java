package com.cloudine.bigdata.cep.service.engine;

import com.espertech.esper.client.EPException;
import com.espertech.esper.client.time.CurrentTimeEvent;
import com.espertech.esper.core.service.EPRuntimeImpl;
import com.espertech.esper.core.service.EPServicesContext;
import com.espertech.esper.util.ExecutionPathDebugLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * CEP Runtime Implementation Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPEPRuntimeImpl extends EPRuntimeImpl {

    private static Logger logger = LoggerFactory.getLogger(CEPEPRuntimeImpl.class);

    private EPServicesContext services;

    private long inputCount = 0;

    private long engineLatency = 0;

    /**
     * Constructor.
     *
     * @param services - references to services
     */
    public CEPEPRuntimeImpl(final EPServicesContext services) {

        super(services);
        this.services = services;
    }

    public void timerCallback() {

        if ((ExecutionPathDebugLog.isDebugEnabled) && (logger.isDebugEnabled() && (ExecutionPathDebugLog.isTimerDebugEnabled))) {
            logger.debug(".timerCallback Evaluating scheduled callbacks");
        }

        long msec = services.getTimeSource().getTimeMillis();
        CurrentTimeEvent currentTimeEvent = new CurrentTimeEvent(msec);
        sendTimeEvent(currentTimeEvent);
    }


    public void sendEvent(Object event) throws EPException {

        if (event instanceof com.espertech.esper.client.metric.EngineMetric
                || event instanceof com.espertech.esper.client.metric.StatementMetric) {
            super.sendEvent(event);
            return;
        }

        // current time in nanoseconds
        long ns = System.nanoTime();

        super.sendEvent(event);

        // time after sending event in nanoseconds
        long nsDone = System.nanoTime();

        // calculate engine latency time
        engineLatency = nsDone - ns; // to microseconds

        inputCount++;

    }

    public void sendTimeEvent(Object event) throws EPException {

        super.sendEvent(event);
    }

    public void sendEvent(Map map, String eventTypeName) throws EPException {

        // current time in nanoseconds
        long ns = System.nanoTime();

        super.sendEvent(map, eventTypeName);

        // time after sending event in nanoseconds
        long nsDone = System.nanoTime();

        // calculate engine latency time
        engineLatency = nsDone - ns; // to microseconds

        inputCount++;

    }

    public void route(Object event) {

        super.route(event);

    }

    public void route(Map map, String eventTypeName) throws EPException {

        super.route(map, eventTypeName);

    }

    public long getInputCount() {

        return inputCount;
    }

    public void setInputCount(long inputCount) {

        this.inputCount = inputCount;
    }

    public long getEngineLatency() {

        return engineLatency;
    }

    public void setEngineLatency(long engineLatency) {

        this.engineLatency = engineLatency;
    }

    public HashMap<String, Object> getHistogram() {

        return null;//StatsHolder.getHistogram("engine");
    }
}