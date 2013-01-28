
package org.cookbook.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/salesforce</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2013-01-28T10:30:16-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class SalesforceNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new salesforceConnectorConfigDefinitionParser());
        registerBeanDefinitionParser("my-processor", new MyProcessorDefinitionParser());
    }

}
