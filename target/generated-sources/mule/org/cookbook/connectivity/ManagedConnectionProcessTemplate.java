
package org.cookbook.connectivity;

import javax.annotation.Generated;
import org.cookbook.adapters.salesforceConnectorConnectionIdentifierAdapter;
import org.cookbook.process.ManagedConnectionProcessInterceptor;
import org.cookbook.process.ProcessCallbackProcessInterceptor;
import org.cookbook.process.RetryProcessInterceptor;
import org.mule.api.ConnectionManager;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessInterceptor;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-18T03:03:29-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class ManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, salesforceConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter> processInterceptor;

    public ManagedConnectionProcessTemplate(ConnectionManager<salesforceConnectorConnectionKey, salesforceConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, salesforceConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, salesforceConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, salesforceConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
