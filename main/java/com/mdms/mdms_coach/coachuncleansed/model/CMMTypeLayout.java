package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity()
@Table(name="cmm_type_layout", schema="mdms_coach")
public class CMMTypeLayout {	
	@Id
	@Column(name="cmmcoachtype")
	private String cmmcoachtype;
	
	@Column(name="capacity")
	private String capacity;

	@Column(name="coachtypedescription")
	private String coachtypedescription;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="user_id")
	private String userid;
	
	@Column(name="filename")
	private String filename;
	
	@Column(name="status")
	private String status;
	
	@Column(name="record_entry_time")
	private Date record_entry_time;

	@Column(name="id")
	private long id;

	public String getCmmcoachtype() {
		return cmmcoachtype;
	}

	public void setCmmcoachtype(String cmmcoachtype) {
		this.cmmcoachtype = cmmcoachtype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCoachtypedescription() {
		return coachtypedescription;
	}

	public void setCoachtypedescription(String coachtypedescription) {
		this.coachtypedescription = coachtypedescription;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRecord_entry_time() {
		return record_entry_time;
	}

	public void setRecord_entry_time(Date record_entry_time) {
		this.record_entry_time = record_entry_time;
	}

	
	
	
}
