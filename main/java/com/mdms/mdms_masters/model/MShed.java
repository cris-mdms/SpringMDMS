package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_shed_code_management_existing", schema="mdms_masters")
public class MShed {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name="srno")
	private int srNo;
	
	@Column(name="zone_code")
	private String zoneCode;
	
	@Column(name="division_code")
	private String divisionCode;
	
	@Column(name="traction_code")
	private String tractionCode;
	
	@Column(name="shed_code")
	private String shedCode;
	
	@Column(name="shed_name")
	private String shedName;
	
	@Column(name="serving_stn_code")
	private String servingStnCode;
	
	@Column(name="serving_stn_name")
	private String servingStnName;
	
	@Column(name="shed_type")
	private String shedType;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="description")
	private String description;
	

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getTractionCode() {
		return tractionCode;
	}

	public void setTractionCode(String tractionCode) {
		this.tractionCode = tractionCode;
	}

	public String getShedCode() {
		return shedCode;
	}

	public void setShedCode(String shedCode) {
		this.shedCode = shedCode;
	}

	public String getShedName() {
		return shedName;
	}

	public void setShedName(String shedName) {
		this.shedName = shedName;
	}

	public String getServingStnCode() {
		return servingStnCode;
	}

	public void setServingStnCode(String servingStnCode) {
		this.servingStnCode = servingStnCode;
	}

	public String getServingStnName() {
		return servingStnName;
	}

	public void setServingStnName(String servingStnName) {
		this.servingStnName = servingStnName;
	}

	public String getShedType() {
		return shedType;
	}

	public void setShedType(String shedType) {
		this.shedType = shedType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	
	
	
	
}

