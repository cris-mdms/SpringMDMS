package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_loco_shed",schema="mdms_loco")
public class MLocoShed {
	@Id
	@Column(name="shed_code")
	private String baseshedCode;
	
	@Column(name="shed_name")
	private String shedName;
	
	@Column(name="zone_code")
	private String zoneCode;

	@Column(name="shed_flag")
	private String shedflag;
	
	@Column(name="division_code")
	private String division_code;
	
	@Column(name="serving_station")
	private String serving_station;
	
//	@Column(name="shed_type")
//	private String shed_type;
//	
		
	@Column(name="ir_flag")
	private String ir_flag;
	
//	@Column(name="fois_flag")
//	private String fois_flag;
	
	@Column(name="old_shed_code")
	private String old_shed_code;
	
//	@Column(name="fois_old_zone_code")
//	private String fois_old_zone_code;
	
	@Column(name="fois_old_shed_code")
	private String fois_old_shed_code;
	
	@Column(name="zone_name")
	private String zone_name;
	
	@Column(name="validity")
	private String validity;
	

	
	public String getIr_flag() {
		return ir_flag;
	}

	public void setIr_flag(String ir_flag) {
		this.ir_flag = ir_flag;
	}

//	public String getFois_flag() {
//		return fois_flag;
//	}
//
//	public void setFois_flag(String fois_flag) {
//		this.fois_flag = fois_flag;
//	}

	public String getOld_shed_code() {
		return old_shed_code;
	}

	public void setOld_shed_code(String old_shed_code) {
		this.old_shed_code = old_shed_code;
	}

//	public String getFois_old_zone_code() {
//		return fois_old_zone_code;
//	}
//
//	public void setFois_old_zone_code(String fois_old_zone_code) {
//		this.fois_old_zone_code = fois_old_zone_code;
//	}

	public String getFois_old_shed_code() {
		return fois_old_shed_code;
	}

	public void setFois_old_shed_code(String fois_old_shed_code) {
		this.fois_old_shed_code = fois_old_shed_code;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}


	public String getBaseshedCode() {
		return baseshedCode;
	}

	public void setBaseshedCode(String baseshedCode) {
		this.baseshedCode = baseshedCode;
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

	public String getShedflag() {
		return shedflag;
	}

	public void setShedflag(String shedflag) {
		this.shedflag = shedflag;
	}

	public String getDivision_code() {
		return division_code;
	}

	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}

	public String getServing_station() {
		return serving_station;
	}

	public void setServing_station(String serving_station) {
		this.serving_station = serving_station;
	}

//	public String getShed_type() {
//		return shed_type;
//	}
//
//	public void setShed_type(String shed_type) {
//		this.shed_type = shed_type;
//	}
//	

}
