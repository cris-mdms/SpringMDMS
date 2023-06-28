package com.mdms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*",allowedHeaders="*", maxAge = 4800, allowCredentials = "false")
@RestController
@SpringBootApplication(scanBasePackages={"com.mdms"})
@ComponentScan("com.mdms")

public class StartApp extends SpringBootServletInitializer {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(StartApp.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	
	}
	 
	@RequestMapping(value="/")
	public void index()
	{
	    Logger logger = LoggerFactory.getLogger(StartApp.class);
		logger.info("/index service called of development project");
	}
	
}