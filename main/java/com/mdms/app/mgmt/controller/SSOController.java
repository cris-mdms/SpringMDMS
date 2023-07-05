package com.mdms.app.mgmt.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class SSOController implements ErrorController{
	Logger logger=LoggerFactory.getLogger(SSOController.class);
	
	 @GetMapping("/error")
	    public String error() {
	        return "forward:/index.html";
	    }

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @GetMapping("/login")
	    public String pageone()
	 {		 
		 logger.info("Controller : SSOController : login ");	
   		 return "redirect:http://localhost:4200/login";
	    }
	 
	 
	 @GetMapping("/dashboard")
	 public String dashboard()
	 {		 
		 logger.info("Controller : SSOController : dashboard ");	
   		 return "redirect:http://localhost:4200/data-dictionary";
	    }

	
	

}
