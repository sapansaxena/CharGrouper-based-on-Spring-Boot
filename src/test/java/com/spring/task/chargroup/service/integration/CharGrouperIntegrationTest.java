package com.spring.task.chargroup.service.integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.configuration.RestWsConfig;

/**
 * @author Sapan.Saxena
 * This class is used to do complete integration test of one of the use cases via executing actual rest calls on the server.
 * Server address and port are fetched from application.properties in resources.
 * This class launches application first and then hits URL exposed of REST call, with proper input, to fetch results.
 *
 */
public class CharGrouperIntegrationTest extends BaseTest{
	@Autowired
	private ApplicationContext appContext;
	
	  private RestTemplate rest;
	  private HttpHeaders headers;
	  private Properties prop;


	  
	/**
	 * Launches application by calling main method of the Rest WS config class with String args array.
	 * Declares headers for the rest call to be executed via the test. Fetches properties object to get server properties like address and port.
	 */
	@Before
	public void launchApplication(){
		String args[] = new String[]{};
		RestWsConfig.main(args);
		 this.rest = new RestTemplate();
		    this.headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json");
		    headers.add("Accept", "*/*");
			prop = new Properties();

			Resource resource = appContext.getResource("classpath:application.properties");
			InputStream in;
			try {
				in = resource.getInputStream();
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	/**
	 * Test class to hit REST API via HTTP and fetch response object. 
	 * Server URL properties like address and port are used from application.properties.
	 * Response object HttpStatus.OK are verified/asserted and the String output returned from the Rest call.
	 */
	@Test
	public void testGroup(){

		String uri = "/rest/chargroup/abzuaaissna";
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	    ResponseEntity<String> responseEntity = rest.exchange("http://"+prop.getProperty("server.address")+":"+prop.getProperty("server.port") + uri, HttpMethod.GET, requestEntity, String.class);
        assertEquals("\"a4bins2uz\"", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
