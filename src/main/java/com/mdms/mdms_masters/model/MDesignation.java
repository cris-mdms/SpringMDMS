package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_designation_old", schema="mdms_masters")
public class MDesignation {
	@Id
	@Column(name="designation_code")
	private String designation_code ;
	
	@Column(name="designation_name")
	private String designation_name ;
	
	@Column(name="department_code")
	private int 	department_code ;
	
	@Column(name="station_user")
	private String station_user;
	
	@Column(name="loco_user")
	private String loco_user;
	@Column(name="coach_user")
	private String coach_user;
	@Column(name="wagon_user")
	private String wagon_user;
	public String getDesignation_code() {
		return designation_code;
	}
	public void setDesignation_code(String designation_code) {
		this.designation_code = designation_code;
	}
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}
	public int getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(int department_code) {
		this.department_code = department_code;
	}
	public String getStation_user() {
		return station_user;
	}
	public void setStation_user(String station_user) {
		this.station_user = station_user;
	}
	public String getLoco_user() {
		return loco_user;
	}
	public void setLoco_user(String loco_user) {
		this.loco_user = loco_user;
	}
	public String getCoach_user() {
		return coach_user;
	}
	public void setCoach_user(String coach_user) {
		this.coach_user = coach_user;
	}
	public String getWagon_user() {
		return wagon_user;
	}
	public void setWagon_user(String wagon_user) {
		this.wagon_user = wagon_user;
	}
	
	

}
