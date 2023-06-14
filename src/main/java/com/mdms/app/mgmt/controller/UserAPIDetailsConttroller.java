package com.mdms.app.mgmt.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mdms.app.mgmt.model.UserJsonModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.app.mgmt.service.UserProfileRegistrationService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserAPIDetailsConttroller {
	Logger logger=LoggerFactory.getLogger(HRMSEmployeeDetailsController.class);	
	UserJsonModel userjsonData;
	@Autowired
	UserProfileRegistrationService registrationServiceObj;
	@RequestMapping(method=RequestMethod.POST, value="/getemployeedetails")
		public  List<UserProfileRegistrationDetailModel> getactiveuser1(@RequestBody UserProfileRegistrationDetailModel userObj1) {
			System.out.println(userObj1.getUser_id());			
		 String getuserUrl1 = "http://203.176.113.46/getemployeedetails";                  
			 //Proxy socksProxy  = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));
			 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.77.40.15",3128 ));
			 SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
			 requestFactory.setProxy(proxy);
			//HttpURLConnection socksConnection = (HttpURLConnection) getHRMSUrl.openConnection(socksProxy);
			// String getHRMSUrl = "http://localhost:12021/hrmsEmployeeInfo";		 
				RestTemplate restTemplate = new RestTemplate(requestFactory);
					 try {
//					        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin09876", "dasd@1241!45"));
					        //restTemplate.setr
						 userjsonData = restTemplate.postForObject(getuserUrl1, userObj1,UserJsonModel.class);	
					     	System.out.println("above logger"+userObj1);
					    	logger.info("Controller : UserProfileRegistrationController || Method : userEmployeeDetail1 ||userEmployeeInfo");			
					    	System.out.println("below logger"+userObj1);							        
					    	return registrationServiceObj.getActiveuser(userObj1);			      
					    }
					    catch (Exception eek) {
					    	System.out.println(eek);
//					    	userjsonData.setMessage("some error occured in calling HRMS service");
					    	return registrationServiceObj.getActiveuser(userObj1);
					    	
					    }
					
				
		}

}
