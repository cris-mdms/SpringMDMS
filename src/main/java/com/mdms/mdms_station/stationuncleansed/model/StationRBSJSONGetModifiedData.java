package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;

public class StationRBSJSONGetModifiedData {
	
	private String  stnCode;
	private String  stnName;
	private String  divCode;
	private String  zoneCode;
	private Boolean  interchange;
	private Integer  numericalCode;
	private Date  validFromDate;
	private Date  validUptoDate;
	public String getStnCode() {
		return stnCode;
	}
	public void setStnCode(String stnCode) {
		this.stnCode = stnCode;
	}
	public String getStnName() {
		return stnName;
	}
	public void setStnName(String stnName) {
		this.stnName = stnName;
	}
	public String getDivCode() {
		return divCode;
	}
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public Boolean getInterchange() {
		return interchange;
	}
	public void setInterchange(Boolean interchange) {
		this.interchange = interchange;
	}
	public Integer getNumericalCode() {
		return numericalCode;
	}
	public void setNumericalCode(Integer numericalCode) {
		this.numericalCode = numericalCode;
	}
	public Date getValidFromDate() {
		return validFromDate;
	}
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}
	public Date getValidUptoDate() {
		return validUptoDate;
	}
	public void setValidUptoDate(Date validUptoDate) {
		this.validUptoDate = validUptoDate;
	}
	
			
}
