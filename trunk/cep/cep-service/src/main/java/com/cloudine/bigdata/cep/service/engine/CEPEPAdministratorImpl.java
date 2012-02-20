package com.cloudine.bigdata.cep.service.engine;

import com.espertech.esper.client.EventType;
import com.espertech.esper.core.service.EPAdministratorContext;
import com.espertech.esper.core.service.EPAdministratorImpl;
import com.espertech.esper.core.service.EPServicesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CEP Administrator Implementation Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPEPAdministratorImpl extends EPAdministratorImpl {

   /**
     * SLF4J Logging.
     */
    private Logger logger = LoggerFactory.getLogger(CEPEPAdministratorImpl.class);

    private EPServicesContext services;

    /**
     * Constructor - takes the services context as argument.
     *
     * @param adminContext - administrative context
     */
    public CEPEPAdministratorImpl(EPAdministratorContext adminContext) {

        super(adminContext);
        this.services = adminContext.getServices();
    }

    public EventType getEventType(String eventTypeName) {

        EventType eventType = this.services.getEventAdapterService().getExistsTypeByName(eventTypeName);
        return eventType;
    }

    public EventType[] getAllTypes() {

        EventType[] allTypes = this.services.getEventAdapterService().getAllTypes();
        return allTypes;
    }
}
