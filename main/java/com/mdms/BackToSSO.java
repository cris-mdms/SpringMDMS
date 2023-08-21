package com.mdms;

import java.net.Proxy;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.crypto.CryptoException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CryptoException;



public final class BackToSSO {
	

	private static RestTemplate restTemplate;
	@Autowired
	
	public BackToSSO(RestTemplate restTemplate) {
		BackToSSO.restTemplate=restTemplate;
	}
	
	private static final Logger LOGGER = LogManager.getLogger(BackToSSO.class);
	
	static String token= null ;
	private  final static String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	public static String generateToken(String hrmsId,String secretkey) {
		String url="http://10.77.48.16:8080/hrmssinglesignon/getnewtoken";
		JSONObject request = new JSONObject();
	 
	  	request.put("hrmsid", hrmsId);
	 	request.put("secretkey", "KeH45QazsQ1Edc740IRu");
	 	
	  	String plainCreds = "test_ssomdms:ssohrms@2022";
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
		
		JSONObject json=null;
	    // make a request
		try{
			
		   response = restTemp
				   .exchange(url, HttpMethod.POST, entity, String.class);
		   String body=response.getBody();
		   json=new JSONObject(body);
		   System.out.println(json.getString("status"));
		   System.out.println(json.getString("token"));
		   token=json.getString("token");
		   
		   if(json.has("status")  && json.getString("status").equals("Y")) {
			   return token;
		   }
		}catch (Exception e) {
			LOGGER.error("primesRestTemplate",e);
		}
		return token;
	}
	
	
	public static  String doEncrypt(String encodekey, String inputStr)   throws CryptoException {
        try {

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            byte[] key = encodekey.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-512");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // Use only the first 128 bits (16 bytes)
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] inputBytes = inputStr.getBytes();
            byte[] outputBytes = cipher.doFinal(inputBytes);
            return Base64.getEncoder().encodeToString(outputBytes);
            //return Base64Utils.encodeToString(outputBytes);

        } catch (Exception E) {
        	
       }
		return inputStr;
     }
}
	 
	 

