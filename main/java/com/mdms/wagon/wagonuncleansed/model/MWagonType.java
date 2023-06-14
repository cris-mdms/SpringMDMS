package com.mdms.wagon.wagonuncleansed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_wagon_type", schema="mdms_wagon")
public class MWagonType {	
	@Id
	@Column(name="wagon_type")
	private String  wagon_type;	

	@Column(name="tcd")
	private Integer  tcd ;
	
	@Column(name="orgnization_type")
	private String  orgnization_type ;
	
	@Column(name="group_name")
	private String  group_name;
	
	@Column(name="group_code")
	private String  group_code ;
	
	
	@Column(name="remarks")
	private String  remarks ;
	
	
	@Column(name="brake_type")
	private String  brake_type ;
	
	@Column(name="wagon_valid")
	private String  wagon_valid ;

	
	@Column(name="cvd_type")
	private String  cvd_type ;
	
	@Column(name="insrtdt")
	private Date  insrtdt ;
	
	
	@Column(name="insrtby")
	private String  insrtby ;
	
	@Column(name="poh_type")
	private String  poh_type;
	
	@Column(name="poh_run")
	private String  poh_run;
	
	
	@Column(name="phasedout")
	private String  phasedout;
	
	
	@Column(name="status")
	private String  status;
	
	@Column(name="common_type")
	private String  common_type;
	
	@Column(name="wagon_tare")
	private Integer  wagon_tare;
	
	@Column(name="wagon_carrying_capacity")
	private Integer  wagon_carrying_capacity;
	
	@Column(name="type_description")
	private String  type_description;

	public String getWagon_type() {
		return wagon_type;
	}

	public void setWagon_type(String wagon_type) {
		this.wagon_type = wagon_type;
	}

	public Integer getTcd() {
		return tcd;
	}

	public void setTcd(Integer tcd) {
		this.tcd = tcd;
	}

	public String getOrgnization_type() {
		return orgnization_type;
	}

	public void setOrgnization_type(String orgnization_type) {
		this.orgnization_type = orgnization_type;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBrake_type() {
		return brake_type;
	}

	public void setBrake_type(String brake_type) {
		this.brake_type = brake_type;
	}

	public String getWagon_valid() {
		return wagon_valid;
	}

	public void setWagon_valid(String wagon_valid) {
		this.wagon_valid = wagon_valid;
	}

	public String getCvd_type() {
		return cvd_type;
	}

	public void setCvd_type(String cvd_type) {
		this.cvd_type = cvd_type;
	}

	public Date getInsrtdt() {
		return insrtdt;
	}

	public void setInsrtdt(Date insrtdt) {
		this.insrtdt = insrtdt;
	}

	public String getInsrtby() {
		return insrtby;
	}

	public void setInsrtby(String insrtby) {
		this.insrtby = insrtby;
	}

	public String getPoh_type() {
		return poh_type;
	}

	public void setPoh_type(String poh_type) {
		this.poh_type = poh_type;
	}

	public String getPoh_run() {
		return poh_run;
	}

	public void setPoh_run(String poh_run) {
		this.poh_run = poh_run;
	}

	public String getPhasedout() {
		return phasedout;
	}

	public void setPhasedout(String phasedout) {
		this.phasedout = phasedout;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommon_type() {
		return common_type;
	}

	public void setCommon_type(String common_type) {
		this.common_type = common_type;
	}

	public Integer getWagon_tare() {
		return wagon_tare;
	}

	public void setWagon_tare(Integer wagon_tare) {
		this.wagon_tare = wagon_tare;
	}

	public Integer getWagon_carrying_capacity() {
		return wagon_carrying_capacity;
	}

	public void setWagon_carrying_capacity(Integer wagon_carrying_capacity) {
		this.wagon_carrying_capacity = wagon_carrying_capacity;
	}

	public String getType_description() {
		return type_description;
	}

	public void setType_description(String type_description) {
		this.type_description = type_description;
	}
	
	
 

		
}
