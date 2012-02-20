package com.cloudine.bigdata.cep.service.engine;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 * CEP Engine Runner Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPEngineRunner {

    public void start() throws Exception {

        Configuration config = new Configuration();

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

    }

    public void stop() {

    }

}
