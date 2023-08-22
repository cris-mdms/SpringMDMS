package com.mdms.app.mgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="sso_login_details", schema="mdms_app_mgmt")
public class SsoReceiveUserDetailsModel  implements Serializable {
	
	@Id
	@Column(name = "hrmsid")
	public String hrmsId;
	
	@Column(name = "token")
	public String token;
	@Column(name = "sessionid")
	public String SessionId;
	@Column(name = "ssouid")
	public String SSOUid;
	@Column(name = "app_code")
	public String app_code;




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

	public String getApp_code() {
		return app_code;
	}

	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}

	
	
	

}
