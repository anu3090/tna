package com.cloudine.bigdata.cep.service;

import com.cloudine.bigdata.cep.service.adapter.input.csv.CSVInputAdapterManagerMBean;
import com.cloudine.bigdata.cep.service.adapter.output.csv.CSVOutputAdapterManagerMBean;
import com.cloudine.bigdata.cep.service.engine.CEPEngineRunnerMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CEP Service Launcher Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPServiceLauncher {

    /**
     * SLF4J Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(CEPServiceLauncher.class);

    public static void main(String[] args) throws Exception {

        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "classpath:applicationContext.xml"
        });

        CEPEngineRunnerMBean cepEngineRunnerMBean = (CEPEngineRunnerMBean) applicationContext.getBean("cepEngineRunner");
        CSVOutputAdapterManagerMBean csvOutputAdapterManagerMBean = (CSVOutputAdapterManagerMBean) applicationContext.getBean("csvOutputAdapterManager");
        CSVInputAdapterManagerMBean csvInputAdapterManagerMBean = (CSVInputAdapterManagerMBean) applicationContext.getBean("csvInputAdapterManager");

        cepEngineRunnerMBean.start();

        csvOutputAdapterManagerMBean.start();

//        Thread.sleep(1000);

        csvInputAdapterManagerMBean.start();


        csvInputAdapterManagerMBean.stop();

        csvOutputAdapterManagerMBean.stop();

        cepEngineRunnerMBean.stop();

//        applicationContext.registerShutdownHook();

        // wait infinitely
//        synchronized (CEPServiceLauncher.class) {
//            CEPServiceLauncher.class.wait();
//        }
    }
}
