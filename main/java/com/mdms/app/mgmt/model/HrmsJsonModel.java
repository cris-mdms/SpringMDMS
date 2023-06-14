package com.mdms.app.mgmt.model;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HrmsJsonModel {
	
	
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("ipasEmployeeId")
	private String ipasEmployeeId;
	
	
	@JsonProperty("employeeNameSr")
	private String name;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("departmentDescription")
	private String departmentDescription;
	
	@JsonProperty("serviceStatusDescription")
	private String serviceStatusDescription;
	
	@JsonProperty("railwayZonePU")
	private String railwayZonePU;
	
	@JsonProperty("railwayUnitDivision")
	private String railwayUnitDivision;
	
	@JsonProperty("unitTypeFlag")
	private String unitTypeFlag;
	
	@JsonProperty("unitTypeDesc")
	private String unitTypeDesc;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getServiceStatusDescription() {
		return serviceStatusDescription;
	}

	public void setServiceStatusDescription(String serviceStatusDescription) {
		this.serviceStatusDescription = serviceStatusDescription;
	}

	

	public String getIpasEmployeeId() {
		return ipasEmployeeId;
	}

	public void setIpasEmployeeId(String ipasEmployeeId) {
		this.ipasEmployeeId = ipasEmployeeId;
	}

	public String getRailwayZonePU() {
		return railwayZonePU;
	}

	public void setRailwayZonePU(String railwayZonePU) {
		this.railwayZonePU = railwayZonePU;
	}

	public String getRailwayUnitDivision() {
		return railwayUnitDivision;
	}

	public void setRailwayUnitDivision(String railwayUnitDivision) {
		this.railwayUnitDivision = railwayUnitDivision;
	}

	


	

	public String getUnitTypeFlag() {
		return unitTypeFlag;
	}

	public void setUnitTypeFlag(String unitTypeFlag) {
		this.unitTypeFlag = unitTypeFlag;
	}

	public String getUnitTypeDesc() {
		return unitTypeDesc;
	}

	public void setUnitTypeDesc(String unitTypeDesc) {
		this.unitTypeDesc = unitTypeDesc;
	}
	

	
	
	
	
	
}
