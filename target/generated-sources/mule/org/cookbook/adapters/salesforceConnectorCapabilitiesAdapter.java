
package org.cookbook.adapters;

import javax.annotation.Generated;
import org.cookbook.salesforceConnector;
import org.mule.api.Capabilities;
import org.mule.api.Capability;


/**
 * A <code>salesforceConnectorCapabilitiesAdapter</code> is a wrapper around {@link salesforceConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-18T03:03:29-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class salesforceConnectorCapabilitiesAdapter
    extends salesforceConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(Capability capability) {
        if (capability == Capability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == Capability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
