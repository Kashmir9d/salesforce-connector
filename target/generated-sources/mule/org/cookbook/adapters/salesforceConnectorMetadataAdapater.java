
package org.cookbook.adapters;

import javax.annotation.Generated;
import org.cookbook.salesforceConnector;
import org.mule.api.MetadataAware;


/**
 * A <code>salesforceConnectorMetadataAdapater</code> is a wrapper around {@link salesforceConnector } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2013-03-05T09:22:04-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class salesforceConnectorMetadataAdapater
    extends salesforceConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "salesforce";
    private final static String MODULE_VERSION = "1.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.3.2";
    private final static String DEVKIT_BUILD = "UNNAMED.1377.fd7d4f9";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
