package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="wagon_number_mapping", schema="mdms_wagon")
public class WagonNumberMapping {
	@Id
	@Column(name="irwms_wagon_no")
	private String  irwms_wagon_no ;
	
	@Column(name="fois_wagon_no")
	private String  fois_wagon_no ;
	
	@Column(name="owning_rly")
	private String  owning_rly ;
	
	@Column(name="wagon_type")
	private String  wagon_type ;




	
	@Column(name="user_id")
	private String  user_id ;
	
	@Column(name="status")
	private String  status ;
	

	@Column(name="date")
	private String  date ;

	public String getIrwms_wagon_no() {
		return irwms_wagon_no;
	}

	public void setIrwms_wagon_no(String irwms_wagon_no) {
		this.irwms_wagon_no = irwms_wagon_no;
	}

	public String getFois_wagon_no() {
		return fois_wagon_no;
	}

	public void setFois_wagon_no(String fois_wagon_no) {
		this.fois_wagon_no = fois_wagon_no;
	}

	public String getOwning_rly() {
		return owning_rly;
	}

	public void setOwning_rly(String owning_rly) {
		this.owning_rly = owning_rly;
	}

	public String getWagon_type() {
		return wagon_type;
	}

	public void setWagon_type(String wagon_type) {
		this.wagon_type = wagon_type;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	
	
}
