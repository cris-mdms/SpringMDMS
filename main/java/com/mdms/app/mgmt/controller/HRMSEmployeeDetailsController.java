package com.mdms.app.mgmt.controller;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mdms.app.mgmt.model.HrmsJsonModel;
import com.mdms.app.mgmt.model.IPassIDModel;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class HRMSEmployeeDetailsController {
	Logger logger=LoggerFactory.getLogger(HRMSEmployeeDetailsController.class);	
	HrmsJsonModel hrmsEmpData;	
	
	@RequestMapping(method=RequestMethod.POST, value="/employeedetails")
	public HrmsJsonModel hrmsEmployeeDetail(@RequestBody IPassIDModel ipassid ) {
		System.out.println(ipassid.getIpasId());
	 String getHRMSUrl = "http://10.77.56.35:80/HRMSWS/employeedetails";
		 //Proxy socksProxy  = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));
//		 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.77.40.15",3128 ));
		 SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//		 requestFactory.setProxy(proxy);
		//HttpURLConnection socksConnection = (HttpURLConnection) getHRMSUrl.openConnection(socksProxy);
		// String getHRMSUrl = "http://localhost:12021/hrmsEmployeeInfo";		 
			RestTemplate restTemplate = new RestTemplate(requestFactory);
				 try {
				        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin09876", "dasd@1241!45"));
				        //restTemplate.setr
				         hrmsEmpData = restTemplate.postForObject(getHRMSUrl, ipassid,HrmsJsonModel.class);	
				     	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+ipassid);
				    	logger.info("Controller : HRMSEmployeeDetailsController || Method : hrmsEmployeeDetail ||hrmsEmployeeInfo: "+hrmsEmpData.toString());			
				    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@  below logger"+ipassid);
							        
				        return hrmsEmpData;			      

				    }
				    catch (Exception eek) {
				    	System.out.println(eek);
				    	hrmsEmpData.setMessage("some error occured in calling HRMS service");
				    	return hrmsEmpData;
				    	
				    }
				
			
	}
	
	
	
//	@RequestMapping(method=RequestMethod.GET, value="/getemployeedetails")
//	public HrmsJsonModel hrmsEmployeeDetail1(@RequestParam(value="ipasId") String ipasId  ) {
//		System.out.println(ipasId);
//	 String getHRMSUrl = "http://10.77.56.35:80/HRMSWS/employeedetails";
//		 //Proxy socksProxy  = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));
//		 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.77.40.15",3128 ));
//		 SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//		 requestFactory.setProxy(proxy);
//		//HttpURLConnection socksConnection = (HttpURLConnection) getHRMSUrl.openConnection(socksProxy);
//		// String getHRMSUrl = "http://localhost:12021/hrmsEmployeeInfo";		 
//			RestTemplate restTemplate = new RestTemplate(requestFactory);
//				 try {
//				        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin09876", "dasd@1241!45"));
//				        //restTemplate.setr
//				         hrmsEmpData = restTemplate.postForObject(getHRMSUrl, ipasId,HrmsJsonModel.class);	
//				     	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@above logger"+ipasId);
//				    	logger.info("Controller : HRMSEmployeeDetailsController || Method : hrmsEmployeeDetail ||hrmsEmployeeInfo: "+hrmsEmpData.toString());			
//				    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@  below logger"+ipasId);
//							        
//				        return hrmsEmpData;			      
//				    }
//				    catch (Exception eek) {
//				    	System.out.println(eek);
//				    	hrmsEmpData.setMessage("some error occured in calling HRMS service");
//				    	return hrmsEmpData;
//				    	
//				    }
//				
//			
//	}
//	
	}

