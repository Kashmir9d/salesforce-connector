/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.cookbook;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.annotations.Connect;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.Processor;

import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectorConfig;

/**
 * Salesforce Example connector
 * A connector that requests and returns the oldest Contact from a Saleforce account
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="salesforce", schemaVersion="1.0-SNAPSHOT")
public class salesforceConnector
{

	/**
	 * Partner connection
	 */
	private PartnerConnection connection;

	/**
	 * Connect
	 *
	 * @param username A username
	 * @param password A password
	 * @throws ConnectionException
	 */
	@Connect
	public void connect(@ConnectionKey String username, String password)
			throws ConnectionException {
		ConnectorConfig config = new ConnectorConfig();
		config.setUsername(username);
		config.setPassword(password);


		try {
			connection = com.sforce.soap.partner.Connector.newConnection(config);
		} catch (com.sforce.ws.ConnectionException e) {
			//Error is caught here, and e.getMessage is null
			System.out.println(e.getMessage() + " " + e.fillInStackTrace() + " " + e.getClass().getCanonicalName());
			throw new org.mule.api.ConnectionException(ConnectionExceptionCode.UNKNOWN, null, e.getMessage(), e);
		}
	}

	/**
	 * Disconnect
	 */
	@Disconnect
	public void disconnect() {
		if (connection != null){
			try {
				connection.logout();
			} catch (com.sforce.ws.ConnectionException e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		} 
	}

	/**
	 * Are we connected
	 */
	@ValidateConnection
	public boolean isConnected() {
		return connection != null;
	}

	/**
	 * Are we connected
	 */
	@ConnectionIdentifier
	public String connectionId() {
		if (connection != null){
			return connection.getSessionHeader().getSessionId();
		} else {
			return null;
		}
	}

	private Map<String, Object> sObjectToMap(SObject obj) throws com.sforce.ws.ConnectionException{
		Map<String, Object> result = new HashMap<String, Object>();
		DescribeSObjectResult desObj = connection.describeSObject(obj.getType());
		Field[] fields = desObj.getFields();
		for(int j=0;j < fields.length; j++){
			if (obj.getField(fields[j].getName()) != null){
				result.put(fields[j].getName(), obj.getField(fields[j].getName()));
			}
		}
		return result;
	}

	/**
	 * Custom processor
	 *
	 * {@sample.xml ../../../doc/salesforce-connector.xml.sample salesforce:retrieve-contact}
	 *
	 * @param lastName the last name of the account to look up
	 * @return A Map of the values from a Salesforce contact
	 * @throws ConnectionException throws a Mule ConnectionException on issues with the connection
	 */
	@Processor
	public Map<String, Object> retrieveContact(@Optional @Default("") String lastName) throws ConnectionException
	{
		QueryResult queryResults;
		try {
			if (lastName != null && !lastName.isEmpty()){
				queryResults = connection.query("SELECT Id, FirstName, LastName, Account.Name " +
						"FROM Contact WHERE AccountId != NULL AND lastName == " + lastName + " ORDER BY CreatedDate ASC LIMIT 1");

			} else{
				queryResults = connection.query("SELECT Id, FirstName, LastName, Account.Name " +
						"FROM Contact WHERE AccountId != NULL ORDER BY CreatedDate ASC LIMIT 1");
			}

			SObject[] records = queryResults.getRecords();
			if (records.length > 0){
				return  this.sObjectToMap(records[0]);
			} else {
				return null;
			}
		} catch (com.sforce.ws.ConnectionException e) {
			throw new org.mule.api.ConnectionException(ConnectionExceptionCode.UNKNOWN_HOST, null, e.getMessage(), e);
		}
	}
}
