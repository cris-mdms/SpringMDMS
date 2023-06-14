package com.mdms.mdms_masters.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity()
@Table(name="m_shed_mgmt", schema="mdms_masters")
public class MShedMgmt {
	
	@Column(name="shed_code")
	private String shedCode;
	
	@Column(name="shed_name")
	private String shedName;
	
	@Column(name="zone_code")
	private String zoneCode;
	
	@Column(name="division_code")
	private String divisionCode;
	
	@Column(name="traction_code")
	private String tractionCode;
	
	@Column(name="serving_stn_code")
	private String servingStnCode;
	
//	@Column(name="serving_stn_name")
//	private String servingStnName;
	
	@Column(name="shed_type")
	private String shedType;
	
	@Column(name="approved_by")
	private String approved_by;
	
	@Column(name="user_shed")
	private String user_shed;
	
	@Column(name="entry_by")
	private String entry_by;
	
	@Column(name="status")
	private String status;
	
	@Id
	@Column(name="srno")
	private int srNo;
	
	@Column(name="remarks")
	private String remarks;
	
	private String elec_loco_in_dslshed;
	
	
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getUser_shed() {
		return user_shed;
	}

	public void setUser_shed(String user_shed) {
		this.user_shed = user_shed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getServingStnCode() {
		return servingStnCode;
	}

	public void setServingStnCode(String servingStnCode) {
		this.servingStnCode = servingStnCode;
	}

	/*
	public String getServingStnName() {
		return servingStnName;
	}

	public void setServingStnName(String servingStnName) {
		this.servingStnName = servingStnName;
	}
*/
	public String getShedType() {
		return shedType;
	}

	public void setShedType(String shedType) {
		this.shedType = shedType;
	}

	
	public String getApproved_by() {
		return approved_by;
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public String getEntry_by() {
		return entry_by;
	}

	public void setEntry_by(String entry_by) {
		this.entry_by = entry_by;
	}

	
	public String getElec_loco_in_dslshed() {
		return elec_loco_in_dslshed;
	}

	public void setElec_loco_in_dslshed(String elec_loco_in_dslshed) {
		this.elec_loco_in_dslshed = elec_loco_in_dslshed;
	}


	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="txn_timestamp")
	private Timestamp txnTimestamp;
	

}
