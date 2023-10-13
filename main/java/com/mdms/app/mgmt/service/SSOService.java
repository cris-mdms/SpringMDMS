package com.mdms.app.mgmt.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.CryptoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.SsoLogin;
import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;
import com.mdms.app.mgmt.repository.ssosavedetails;

@Service
public class SSOService {
	
	@Autowired
	
	ssosavedetails sso_details;
	@Autowired
	UserProfileRegistrationRepository userprofilerepo;
	
	 Logger logger=LoggerFactory.getLogger(SSOService.class);
	 SsoReceiveUserDetailsModel hrmsidModel1 =new SsoReceiveUserDetailsModel();	 
		private  final static String TRANSFORMATION = "AES/ECB/PKCS5Padding";
		
	 public boolean savessodetails(SsoReceiveUserDetailsModel ssodata)
	 {SsoReceiveUserDetailsModel temp;
		 
	 boolean prsent =sso_details.existsById(ssodata.getHrmsId());
	 if(!prsent) {
		temp= sso_details.save(ssodata);
		
		if (temp!=null)
				return true;
		else return false;
		 
	 }
	 else
	 {int i=sso_details.updatedetails(ssodata.getSessionId(),ssodata.getSSOUid(),ssodata.getToken(),ssodata.getHrmsId());
	 
	   if(i>0)
		   return true;
	   else return false;
	 
		 }
	 }
	 
	 // fetch sso user details
	 public SsoReceiveUserDetailsModel getssodetails(String hrmsid)
	 {
		 SsoReceiveUserDetailsModel temp;
		 temp=sso_details.getSSOUserById(hrmsid);
		 return temp;
	 }
	 
	 
	 public char chcekuserexists(String hrmsid)
	 {
		 boolean b;
		 
		 b=userprofilerepo.existsById(hrmsid);
		 if(b)
		 {
			String role= userprofilerepo.getUserRole(hrmsid);
			if(role.equals("N"))
				return 'R';//registered user but not cris user
			else return 'C';//registered user but cris user
			
		 }
		 
		  return 'N';//not registered
	 }
	 

	 public void decrypt(String inputstring)
	 
	 
	 {
		 
		 
		 String hrmsidModel2="VpOjySeCBuGta2BhPhnXYz9/Oxa9idByv8Ok8HSnrz1y3QnaU7p872hr0z9n+J+JxEDKr6fPEnjaqVf8QHj1G51CTJMP5IjgfIiduXXcIwWTMsFti75a8HvdIxsaDkUQXbyGstJEX9/IZ+R5N5QVpvuGMqmMhOKmy6ctx+N6KNyQATY2B8lPC+u/vjVVXApy0BsJ0FVyR6AlnVgLoyhUaPRJmd/GCqwNhWHQtkzA6QqXvOp0fLMTKxnffRh6P1NFLgB2e2n9JNH70NV4C2xqPVtpsQABB92M8/nEV7G4h0uFmrBxLz3jWNB1kxioVkiE4ZXky/+TWH606Gnn5ICbRJI2W5PygwA8wSHWT4+m2Zo=";
		 String decryptedData= SSOService.doDecrypt("a5e922f36498d43983cb1afaf991459250bcf40d8b1f7909322e010d058a772e",hrmsidModel2);
	        
		   String [] dataArr=decryptedData.split("\\|");
	  
	       for(int i=0 ; i < dataArr.length ;i++){
		      String enqData=dataArr[i];
		      String [] enqDataArr=enqData.split("=");
		    	System.out.println(enqDataArr[0]+"==="+enqDataArr[1]);
			}
	   
	   String[] dataArray = decryptedData.split("\\|");
		for (String item : dataArray) {
		    String[] keyValue = item.split("=");
		    if (keyValue.length == 2) {
		        String key = keyValue[0];
		        String value = keyValue[1];
		        System.out.println("Key: " + key + ", Value: " + value);
		        if("SessionId".equalsIgnoreCase(key)) {
		        	hrmsidModel1.setSessionId(value);
		        }
		        else if("token".equalsIgnoreCase(key)) {
		        	hrmsidModel1.setToken(value);
		        	
		        }
		        else if("hrmsId".equalsIgnoreCase(key)) {
		        	hrmsidModel1.setHrmsId(value);
		        }
		        else if("SSOUid".equalsIgnoreCase(key)) {
		        	hrmsidModel1.setSSOUid(value);
		        }
		        else if("app_code".equalsIgnoreCase(key)) {
		        	hrmsidModel1.setApp_code(value);
		        }
		    }
		}
		 
		 
		
	 }
	 
	 public static  String doDecrypt(String encodekey,String encrptedStr) { 
         try {     

       	  Cipher dcipher = Cipher.getInstance(TRANSFORMATION);
             byte[] key = encodekey.getBytes(StandardCharsets.UTF_8);
             MessageDigest sha = MessageDigest.getInstance("SHA-512");
             key = sha.digest(key);
             key = Arrays.copyOf(key, 16); // Use only the first 128 bits (16 bytes)
             SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
             dcipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
             byte[] plainText = dcipher.doFinal(Base64.getDecoder().decode(encrptedStr));
             return new String(plainText, StandardCharsets.UTF_8);
           // decode with base64 to get bytes
          } catch (Exception e) {

           //e.printStackTrace();

         }
     return null;
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
