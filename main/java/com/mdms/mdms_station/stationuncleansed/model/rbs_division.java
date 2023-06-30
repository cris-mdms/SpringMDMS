package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="rbs_division", schema="mdms_station")
public class rbs_division {
	@Id
	@Column(name="division_ser_no")
	private int division_ser_no;
	
	@Column(name="division_code")
	private String division_code;
	
	@Column(name="division_name")
	private String division_name;
	
	@Column(name="zone_code")
	private String zone_code;
	
	
	
	@Column(name="division_vld_from")
	private String division_vld_from;
	
	@Column(name="division_vld_upto")
	private String division_vld_upto;

	

	public int getDivision_ser_no() {
		return division_ser_no;
	}

	public void setDivision_ser_no(int division_ser_no) {
		this.division_ser_no = division_ser_no;
	}

	public String getDivision_code() {
		return division_code;
	}

	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public String getDivision_vld_from() {
		return division_vld_from;
	}

	public void setDivision_vld_from(String division_vld_from) {
		this.division_vld_from = division_vld_from;
	}

	public String getDivision_vld_upto() {
		return division_vld_upto;
	}

	public void setDivision_vld_upto(String division_vld_upto) {
		this.division_vld_upto = division_vld_upto;
	}
	 
	
	
	
	
	
}
