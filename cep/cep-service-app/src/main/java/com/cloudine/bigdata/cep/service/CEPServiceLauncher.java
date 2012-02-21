package com.cloudine.bigdata.cep.service;

import com.cloudine.bigdata.cep.service.runtime.CEPServiceApplicationRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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


        List<CEPServiceApplicationRuntime> cepServiceList = (List<CEPServiceApplicationRuntime>) applicationContext.getBean("cepServiceList");

        System.out.println(cepServiceList);

        for (CEPServiceApplicationRuntime cepService : cepServiceList) {
            cepService.start();
        }

//        for (CEPServiceApplicationRuntime cepService : cepServiceList) {
//            cepService.stop();
//        }

        applicationContext.registerShutdownHook();

        // wait infinitely
        synchronized (CEPServiceLauncher.class) {
            CEPServiceLauncher.class.wait();
        }
    }
}
