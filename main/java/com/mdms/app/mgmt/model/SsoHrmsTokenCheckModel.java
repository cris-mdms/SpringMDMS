package com.mdms.app.mgmt.model;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SsoHrmsTokenCheckModel {
	
	@JsonProperty("hrmsId")
		private String hrmsId;
	@JsonProperty("token")
		private String token;
		
		

		public String getHrmsId() {
			return hrmsId;
		}

		public void setHrmsId(String hrmsId) {
			this.hrmsId = hrmsId;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

	

		
		}



