

 
package com.mdms.app.mgmt.controller;
//import java.util.Base64;
//import java.util.List;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//
//import com.mdms.app.mgmt.model.HrmsJsonModel;
//import com.mdms.app.mgmt.model.IPassIDModel;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class HrmsRouteDataController {
}

//	private HrmsJsonModel returnObj;
//
//	Logger logger=LoggerFactory.getLogger(HrmsRouteDataController.class);	
//
//
//	
//	@RequestMapping(method=RequestMethod.POST, value="/employeedetailss")
//	public HrmsJsonModel hrmsEmployeeDetail(@RequestBody HrmsJsonModel ipassid ) {	
	
//			 String getHRMSUrl = "http://10.64.0.149:8080/HRMSWS/employeedetails?=ipasId"+ipassid;
//
//		RestTemplate restTemplate = new RestTemplate();
//			 try {
//			        HttpHeaders headers = createHttpHeaders("admin09876","dasd@1241!45"); 
//			        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//			        ResponseEntity<List<HrmsJsonModel>> response = restTemplate.exchange(getHRMSUrl, HttpMethod.POST, entity,  new ParameterizedTypeReference<List<HrmsJsonModel>>() {});
////			        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
//			        List<HrmsJsonModel> hrmsRouteData=response.getBody();			      
//
//			        if(hrmsRouteData.size()>=0) 
//			        {  System.out.println(response);
//			        	return response;
//			        	
//			        }
//			        else {
//			//	System.out.println("rbsRouteData"+rbsRouteData.get(0).getInterStations().get(0).getStnCode());  
//	         return null;
//			        }
//
//			    }
//			    catch (Exception eek) {
//			  //      System.out.println("** Exception: "+ eek.getMessage());
//			    }
//			
//			
//			return null;
//
//			    }
//			    catch (Exception eek) {
//			    }
//			
//		        
//			return ipassid ;
//
//		}
//	
//	private HttpHeaders createHttpHeaders(String user, String password)
//	{
//	    String notEncoded = user + ":" + password;
//	    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("Authorization", encodedAuth);
//	    return headers;
//	}

//}
