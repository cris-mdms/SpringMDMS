package com.mdms.app.mgmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrisJsonModel {		
	@JsonProperty("idno")
	private String idno;
	
	@JsonProperty("name")
	private String name;
		
    @JsonProperty("desig")
	private String desig;
	
	@JsonProperty("dept")
	private String dept;
	
	@JsonProperty("city")
	private String city;


	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
