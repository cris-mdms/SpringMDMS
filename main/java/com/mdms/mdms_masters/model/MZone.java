package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_zone", schema="mdms_masters")
public class MZone {
	@Id
	@Column(name="zone_code")
	private String	zone_code ;
	
	@Column(name="zone_name")
	private String	zone_name ;
	
	
	@Column(name="zone_active")
	private String	zone_active ;

	@Column(name="zone_numeric_code")
	private int	zone_numeric_code ;
	
	@Column(name="ir_zone")
	private String	ir_zone ;

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getZone_active() {
		return zone_active;
	}

	public void setZone_active(String zone_active) {
		this.zone_active = zone_active;
	}

	public int getZone_numeric_code() {
		return zone_numeric_code;
	}

	public void setZone_numeric_code(int zone_numeric_code) {
		this.zone_numeric_code = zone_numeric_code;
	}

	public String getIr_zone() {
		return ir_zone;
	}

	public void setIr_zone(String ir_zone) {
		this.ir_zone = ir_zone;
	}
	
	
	

}
