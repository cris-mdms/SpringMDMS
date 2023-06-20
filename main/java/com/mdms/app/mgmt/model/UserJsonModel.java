package com.mdms.app.mgmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJsonModel {
	
	@JsonProperty("message")
	private String message;
	@JsonProperty("user_id")
	private String user_id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("department")
	private String department;
	
	@JsonProperty("user_type")
	private String user_type;
	
	@JsonProperty("zone")
	private String zone;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	
	

}
