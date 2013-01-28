
package org.cookbook.connectivity;

import javax.annotation.Generated;


/**
 * A tuple of connection parameters
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2013-01-28T10:30:16-08:00", comments = "Build UNNAMED.1377.fd7d4f9")
public class salesforceConnectorConnectionKey {

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;

    public salesforceConnectorConnectionKey(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        int hash = 1;
        hash = ((hash* 31)+ this.username.hashCode());
        return hash;
    }

    public boolean equals(Object obj) {
        return (((obj instanceof salesforceConnectorConnectionKey)&&(this.username!= null))&&this.username.equals(((salesforceConnectorConnectionKey) obj).username));
    }

}
