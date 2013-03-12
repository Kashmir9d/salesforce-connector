
package org.cookbook.processors;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2013-03-05T09:22:04-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public abstract class AbstractConnectedProcessor
    extends AbstractExpressionEvaluator
{

    protected Object username;
    protected String _usernameType;
    protected Object password;
    protected String _passwordType;

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(Object value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public Object getUsername() {
        return this.username;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(Object value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public Object getPassword() {
        return this.password;
    }

}
