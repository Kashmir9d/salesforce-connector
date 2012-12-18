
package org.cookbook.adapters;

import javax.annotation.Generated;
import org.cookbook.salesforceConnector;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.process.ProcessAdapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;


/**
 * A <code>salesforceConnectorProcessAdapter</code> is a wrapper around {@link salesforceConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-18T03:03:29-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class salesforceConnectorProcessAdapter
    extends salesforceConnectorLifecycleAdapter
    implements ProcessAdapter<salesforceConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, salesforceConnectorCapabilitiesAdapter> getProcessTemplate() {
        final salesforceConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,salesforceConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, salesforceConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, salesforceConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
