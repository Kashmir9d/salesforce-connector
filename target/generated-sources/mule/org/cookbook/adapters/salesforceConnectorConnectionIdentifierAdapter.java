
package org.cookbook.adapters;

import javax.annotation.Generated;
import org.cookbook.salesforceConnector;
import org.mule.api.Connection;


/**
 * A <code>salesforceConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link salesforceConnector } that implements {@link org.mule.api.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2013-03-05T09:22:04-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class salesforceConnectorConnectionIdentifierAdapter
    extends salesforceConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
