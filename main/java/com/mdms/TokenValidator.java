package com.mdms;

import java.net.Proxy;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public final class TokenValidator {
	
	private static RestTemplate restTemplate;
	@Autowired
	public TokenValidator(RestTemplate restTemplate) {
		TokenValidator.restTemplate=restTemplate;
	}
	
	
	private static final Logger LOGGER = LogManager.getLogger(TokenValidator.class);
	
	public static boolean validateToken(String hrmsId,String token) {
		String url="http://10.77.48.16:8080/hrmssinglesignon/tokencheck";
		JSONObject request = new JSONObject();
	  	request.put("token", token);
	  	request.put("hrmsid", hrmsId);
	  	String plainCreds = "test_ssohrms:ssohrms@2022";
	  	String base64Creds = Base64.getEncoder().encodeToString(plainCreds.getBytes());
	  	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setProxy(Proxy.NO_PROXY);
		RestTemplate restTemp=new RestTemplate();

	  	
	    String authHeader = "Basic "+base64Creds;
	    System.out.println(authHeader);
		
	    //request.put("Authorization", authHeader);
	    HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		ResponseEntity<String> response = null;
		System.out.println(token);
		JSONObject json=null;
	    // make a request
		try{
			
		   response = restTemp
				   .exchange(url, HttpMethod.POST, entity, String.class);
		   String body=response.getBody();
		   json=new JSONObject(body);
		   System.out.println(json.getString("status"));
		   if(json.has("status")  && json.getString("status").equals("1")) {
			   return true;
		   }
		}catch (Exception e) {
			LOGGER.error("primesRestTemplate",e);
		}
	    // get JSON response
	    
		 
		 return false;
	 }
	
	
}

