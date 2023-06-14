package com.mdms.loco.locouncleansed.model;

import java.util.Date;

public class LocoTransferResponse {

	
	private int locoNo;
	private String locoType;
	private String locoOwningShed;
	private String locoOwningZone;
	private Date locoDateOfCommissioning;
	private String locoTractionCode;
	private String tablestatus;
	private String loco_new_division;
	private String loco_table_name;
	private String status;
	
	
	public String getTablestatus() {
		return tablestatus;
	}
	public void setTablestatus(String tablestatus) {
		this.tablestatus = tablestatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLocoNo() {
		return locoNo;
	}
	public void setLocoNo(int locoNo) {
		this.locoNo = locoNo;
	}
	public String getLocoType() {
		return locoType;
	}
	public void setLocoType(String locoType) {
		this.locoType = locoType;
	}
	public String getLocoOwningShed() {
		return locoOwningShed;
	}
	public void setLocoOwningShed(String locoOwningShed) {
		this.locoOwningShed = locoOwningShed;
	}
	public String getLocoOwningZone() {
		return locoOwningZone;
	}
	public void setLocoOwningZone(String locoOwningZone) {
		this.locoOwningZone = locoOwningZone;
	}
	public Date getLocoDateOfCommissioning() {
		return locoDateOfCommissioning;
	}
	public void setLocoDateOfCommissioning(Date locoDateOfCommissioning) {
		this.locoDateOfCommissioning = locoDateOfCommissioning;
	}
	public String getLocoTractionCode() {
		return locoTractionCode;
	}
	public void setLocoTractionCode(String locoTractionCode) {
		this.locoTractionCode = locoTractionCode;
	}
	public String getLoco_new_division() {
		return loco_new_division;
	}
	public void setLoco_new_division(String loco_new_division) {
		this.loco_new_division = loco_new_division;
	}
	public String getLoco_table_name() {
		return loco_table_name;
	}
	public void setLoco_table_name(String loco_table_name) {
		this.loco_table_name = loco_table_name;
	}
	
	
	
}
