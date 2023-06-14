/*Developed By: Anshu Sharma , Date 12/Oct/2020 
 */


package com.mdms.app.mgmt.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.repository.LoginOtpRepository;
@Service
public class LoginOtpService{	
	@Autowired
	private LoginOtpRepository loginOtpRepo;
	Logger logger=LoggerFactory.getLogger(LoginOtpService.class);			 
	 public String  getOtp(String user_id) {
	 String response=loginOtpRepo.getOtp(user_id);
		logger.info("Service : LoginOtpService || Method : getOtp||user_id: "+user_id+"||response:"+response);
	 return response;
	 } 
	 
	 public List<LoginOtpModel> verifyOtp(String user_id,Integer otp){
		 List<LoginOtpModel> responselist=	 loginOtpRepo.verifyOtp(user_id,otp);
			logger.info("Service : LoginOtpService || Method : verifyOtp||user_id: "+user_id+"||responselist:"+responselist.size());
		 return responselist;
	 }

}
