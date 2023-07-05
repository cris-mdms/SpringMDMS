package com.mdms.app.mgmt.model;

import javax.persistence.Id;

public class SsoReceiveUserDetailsModel {
	
	@Id
	private String hrmsId;
	
	private String token;
	
	private String SessionId;
	
	private String SSOUid;

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

	public String getSessionId() {
		return SessionId;
	}

	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}

	public String getSSOUid() {
		return SSOUid;
	}

	public void setSSOUid(String sSOUid) {
		SSOUid = sSOUid;
	}

	
	
	

}
