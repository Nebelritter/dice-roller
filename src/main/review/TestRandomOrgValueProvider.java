/**
 * 
 */
package com.github.nebelritter.diceroller.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;

import org.apache.log4j.Logger;

//The Client sessions package
import com.thetransactioncompany.jsonrpc2.client.*;

//The Base package for representing JSON-RPC 2.0 messages
import com.thetransactioncompany.jsonrpc2.*;

//The JSON Smart package for JSON encoding/decoding (optional)
import net.minidev.json.*;

//For creating URLs
import java.net.*;

/**
 * @author Nebelritter
 *
 */
public class TestRandomOrgValueProvider implements RandomValueProvider {
	private static final Logger LOGGER = Logger.getLogger(TestRandomOrgValueProvider.class);
	
	// from http://software.dzhuvinov.com/json-rpc-2.0-client.html
	// and https://api.random.org/json-rpc/1/introduction
	
	//or https://github.com/RandomOrg/JSON-RPC-Java
	private JSONRPC2Session randomOrgSession;

	private int idCount = 0;

	public TestRandomOrgValueProvider() {
		super();
		URL serverURL = null;
		try {
			serverURL = new URL("https://api.random.org/json-rpc/1/invoke");
		} catch (MalformedURLException e) {
			LOGGER.error("Error conecting to random.org: "+e);
		}
		// Create new JSON-RPC 2.0 client session
		randomOrgSession = new JSONRPC2Session(serverURL);

		randomOrgSession.getOptions().setRequestContentType("application/json-rpc");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.nebelritter.diceroller.random.RandomValueProvider#nextInt(int)
	 */
	@Override
	public int nextInt(int maxValue) {
		String method = "getServerTime";
		int requestID = idCount;
		JSONRPC2Request request = new JSONRPC2Request(method, requestID);
//		request.setNamedParams(namedParams);

		// Send request
		JSONRPC2Response response = null;

		try {
			response = randomOrgSession.send(request);
			idCount++;
		} catch (JSONRPC2SessionException e) {
			LOGGER.error("Error in request(for int) to random.org: "+e);
		}

		// Print response result / error
		if (response.indicatesSuccess())
			LOGGER.debug("Request(for int) successfull: "+response);
		else
			LOGGER.error("Error response from random.org: "+response.getError().getMessage());
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.nebelritter.diceroller.random.RandomValueProvider#nextBoolean(
	 * )
	 */
	@Override
	public boolean nextBoolean() {
		return false;
	}

}
