package com.mdms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class PasswordSecurityConfiguration  {
	  


	 int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
	 int memoryCost = 8;      // increases memory usage
	 int parallelization = 1; // currently not supported by Spring Security
	 int keyLength = 16;      // key length in bytes
	 int saltLength = 32;     // salt length in bytes
	
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	    return new SCryptPasswordEncoder(cpuCost, memoryCost,parallelization , keyLength, saltLength);
	  }
}
