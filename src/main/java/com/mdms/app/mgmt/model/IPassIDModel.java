package com.mdms.app.mgmt.model;

import javax.persistence.Id;




public class IPassIDModel {
	@Id
	private String ipasId;

	public String getIpasId() {
		return ipasId;
	}

	public void setIpasId(String ipasId) {
		this.ipasId = ipasId;
	}

	


}
