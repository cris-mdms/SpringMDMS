package com.mdms.mdms_station.stationuncleansed.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mdms.mdms_station.stationuncleansed.model.StationRBSJSONGetModifiedData;
import com.mdms.mdms_station.stationuncleansed.model.StationRBSJsonModel;
import com.mdms.mdms_station.stationuncleansed.model.StationRbsAPIJSONModel;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class StationRBSIntegrationController {
	Logger logger=LoggerFactory.getLogger(StationRBSIntegrationController.class);	
	StationRbsAPIJSONModel obj_stnrbsmodel;
	
	StationRBSJSONGetModifiedData obj_stnrbsmodifiedstndata;
	
	
	@Autowired
	private  RestTemplate restTemplate2;
	
	/*
	 * @Bean public RestTemplate restTemplate2() { return new RestTemplate(); }
	 */
	
//	@RequestMapping(method=RequestMethod.POST, value="/rbsstationdatadatewise")
//	public StationRBSJSONGetModifiedData getmodifiedstncode(@RequestBody StationRBSJsonModel obj_stn) throws IOException{		
//		try {
//			
//			 restTemplate2 = new RestTemplateBuilder(new RestTemplateCustomizer(){
//				 @Override
//			        public void customize(RestTemplate restTemplate) {
//
//			        }
//				 }
//					)
//						 .build();
//			 
//			 String txnDate2 = new SimpleDateFormat("yyyy-MM-dd").format(obj_stn.getDay());
//			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
//			 String getRBSmodifiedstnUrlprod= "http://10.64.0.239/RbsWebServices/jaxrs/Rates/getModifiedStationDetail?day="+txnDate2+"";
//			 restTemplate2.getInterceptors().add(new BasicAuthorizationInterceptor("mdmrbs", "MdmRates12"));
//			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
//			
//			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
//			 obj_stnrbsmodifiedstndata =restTemplate2.getForObject(getRBSmodifiedstnUrlprod,StationRBSJSONGetModifiedData.class);				
////			 return  obj_stnrbsmodifiedstndata;
//			    
//			
//		}
//		catch(Exception e) {
//			
//			System.out.println(e);
//	    	System.out.println("some error occured in calling RBS service " + e.getMessage());	
////	    	 return obj_stnrbsmodifiedstndata;
//			
//		}
//		
//		}
		
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/rbsstationdatadatewise1")		
		  public List<StationRBSJSONGetModifiedData> greetings(@RequestBody StationRBSJsonModel obj_stn) throws IOException {
		try {
			
		    List<StationRBSJSONGetModifiedData> result = new ArrayList<>();
		    restTemplate2 = new RestTemplateBuilder(new RestTemplateCustomizer(){
				 @Override
			        public void customize(RestTemplate restTemplate) {

			        }
				 }
					)
						 .build();
			 
			 String txnDate2 = new SimpleDateFormat("yyyy-MM-dd").format(obj_stn.getDay());
			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
			 String getRBSmodifiedstnUrlprod= "http://10.64.0.239/RbsWebServices/jaxrs/Rates/getModifiedStationDetail?day="+txnDate2+"";
			 restTemplate2.getInterceptors().add(new BasicAuthorizationInterceptor("mdmrbs", "MdmRates12"));		
			 obj_stnrbsmodifiedstndata =restTemplate2.getForObject(getRBSmodifiedstnUrlprod,StationRBSJSONGetModifiedData.class);				 
		    result.add(obj_stnrbsmodifiedstndata);		   
		    return result;
		  }
		
	
	catch(Exception e) {
		
		System.out.println(e);
    	System.out.println("some error occured in calling RBS service " + e.getMessage());	
   	 return null;
	}
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/rbsstationdatadatewise11")		
	  public List<StationRBSJSONGetModifiedData> greetingsss(@RequestBody StationRBSJsonModel obj_stn) throws IOException {
	try {
		
	   
		String txnDate2 = new SimpleDateFormat("yyyy-MM-dd").format(obj_stn.getDay());
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
		 restTemplate2.getInterceptors().add(new BasicAuthorizationInterceptor("mdmrbs", "MdmRates12"));
	    ResponseEntity<List<StationRBSJSONGetModifiedData>> rateResponse =
	    		restTemplate2.exchange("http://10.64.0.239/RbsWebServices/jaxrs/Rates/getModifiedStationDetail?day="+txnDate2+"",
	                        HttpMethod.GET, null, new ParameterizedTypeReference<List<StationRBSJSONGetModifiedData>>() {
	                });
	   
	    List<StationRBSJSONGetModifiedData> result = rateResponse.getBody();
	    
	    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+result);
	    
	    
	    return result;
	  }
	

catch(Exception e) {
	
	System.out.println(e);
	System.out.println("some error occured in calling RBS service " + e.getMessage());	
	 return null;
}
}
	
	@RequestMapping(method=RequestMethod.POST, value="/rbsstationdatadatewise")
	public StationRbsAPIJSONModel getStationDatadatewise(@RequestBody StationRBSJsonModel obj_stn) throws IOException{
		System.out.println("Get Input "+obj_stn.getDay());
		 try {		

//		 Date date = new Date();
//		 Date getdate=obj_stn.getDay();	
//		 RestTemplate restTemplate2 = new RestTemplate();
		 // RBS Development Server IP 10.77.48.37 ,  production load balancer : 10.64.0.239
		 restTemplate2 = new RestTemplateBuilder(new RestTemplateCustomizer(){
			 @Override
		        public void customize(RestTemplate restTemplate) {

		        }
			 }
				)
					 .build();
		 
		 
		 System.out.println("Get Input "+obj_stn.getDay());
			 String txnDate1 = new SimpleDateFormat("yyyy-MM-dd").format(obj_stn.getDay());
			 String stncode=obj_stn.getStn_code();				
				String getRBSUrlprod= "http://10.77.48.37:8080/RbsWebServices/jaxrs/Rates/getRbsStationDetails?stnCode="+obj_stn.getStn_code()+"&day="+txnDate1+"";
				 restTemplate2.getInterceptors().add(new BasicAuthorizationInterceptor("mdmrbs", "MdmRates12"));
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+txnDate1);
//				 getRBSUrlprod = "http://10.77.48.37:8080/RbsWebServices/jaxrs/Rates/getModifiedStationDetail?day=2022-07-13";
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
		        obj_stnrbsmodel = restTemplate2.getForObject(getRBSUrlprod,StationRbsAPIJSONModel.class);	
		     	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+obj_stn.getDay());
		     	  logger.info("Controller : StationRBSIntegrationController || Method : getStationDatadatewise ||StationRBSDetail: "+obj_stnrbsmodel.toString());			     				
		    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@  below logger"+obj_stn.getDay());					        
		        return obj_stnrbsmodel;			      
		    }
		    catch (Exception e) {
		    	System.out.println(e);
		    	System.out.println("some error occured in calling RBS service " + e.getMessage());	
		    	return obj_stnrbsmodel;
		    	
		    }
	
	
	}
}
			
	
	
	
	
