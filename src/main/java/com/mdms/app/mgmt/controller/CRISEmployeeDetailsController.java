package com.mdms.app.mgmt.controller;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import com.mdms.app.mgmt.model.CrisIDModel1;
import com.mdms.app.mgmt.model.CrisJsonModel;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class CRISEmployeeDetailsController {
	Logger logger=LoggerFactory.getLogger(CRISEmployeeDetailsController.class);	
	
	CrisJsonModel crisEmpData;
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
		

	@RequestMapping(method=RequestMethod.POST, value="/crisemployeedetails")
	public CrisJsonModel crisEmployeeDetail(@RequestBody CrisIDModel1 crisid ) throws IOException {		
		 try {
//			 System.setProperty("http.proxyHost", "172.16.1.61");
//				System.setProperty("http.proxyPort", "8080");
//				
		System.out.println("CRISempid" + crisid.getIdno());
		String empid=crisid.getIdno();			
		 String getCRISUrlprod = "http://10.64.26.68/CRISWebESS/rest/essapi/musrsapi/"+empid+"mdMuw";	
//		 http://10.64.26.68/CRISWebESS/rest/essapi/musrsapi/5422mdMuw
//		 String getCRISUrltesting = "http://10.64.26.68/CRISWebESS/rest/essapi/musrsapi/"+empid+"mdMuw";	
		   restTemplate = new RestTemplateBuilder(new RestTemplateCustomizer() {
			@Override
	        public void customize(RestTemplate restTemplate) {
//	            HttpHost proxy = new HttpHost("172.16.1.61", 8080);
	          //  CloseableHttpClient httpClient = HttpClientBuilder.create()
	            //    .setRoutePlanner(new DefaultProxyRoutePlanner(proxy) 
	               // {
//	                    @Override
//	                    public HttpHost determineProxy(HttpHost target, org.apache.http.HttpRequest request, HttpContext context) throws HttpException {
//	                    	return super.determineProxy(target, request, context);
//	                    }
//	                }).build();
//	            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
	        }
		   }
	   // }
			).build();
		  
					 crisEmpData = restTemplate.getForObject(getCRISUrlprod,CrisJsonModel.class);	
					 System.out.println("empiddata " +  crisEmpData.getIdno());
					 System.out.println("empiddata " +  crisEmpData.getDesig());
				logger.info("Controller : CRISEmployeeDetailsController || Method : crisEmployeeDetail ||crisEmployeeInfo: "+crisEmpData.toString());	
				      return crisEmpData;			      
				    }
				    catch (RestClientResponseException | ResourceAccessException  eek) {
				    	System.out.println(eek);
				    	System.out.println("some error occured in calling CRIS service " + eek.getMessage());				    	
				    	return crisEmpData;
				    	
				    }
				
			
	}

   public RestTemplate proxyRestTemplate() {
  SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//// //   Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.1.61", 8080));
//// //   requestFactory.setProxy(proxy);
    return new RestTemplate(requestFactory);
//    
}


	 
}

