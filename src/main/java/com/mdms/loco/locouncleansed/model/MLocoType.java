package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_type", schema="mdms_loco")
public class MLocoType {
	@Id
	@Column(name="loco_type")                  
	private String loco_Type; 
	
	private String loco_traction;
	
	
	private String loco_description;
	
	private String loco_length;
	
	@Column(name="loco_hauling_power")                  
	private String loco_Hauling_Power; 
	
	@Column(name="loco_axle_load")                  
	private String loco_Axleload; 

	
	@Column(name="loco_axle_unit")                  
	private String loco_Unit; 
	
	@Column(name="loco_gauge_code")                  
	private String loco_Gaugetype;

	public String getLoco_Type() {
		return loco_Type;
	}

	public void setLoco_Type(String loco_Type) {
		this.loco_Type = loco_Type;
	}

	public String getLoco_traction() {
		return loco_traction;
	}

	public void setLoco_traction(String loco_traction) {
		this.loco_traction = loco_traction;
	}

	public String getLoco_description() {
		return loco_description;
	}

	public void setLoco_description(String loco_description) {
		this.loco_description = loco_description;
	}

	public String getLoco_length() {
		return loco_length;
	}

	public void setLoco_length(String loco_length) {
		this.loco_length = loco_length;
	}

	public String getLoco_Hauling_Power() {
		return loco_Hauling_Power;
	}

	public void setLoco_Hauling_Power(String loco_Hauling_Power) {
		this.loco_Hauling_Power = loco_Hauling_Power;
	}

	public String getLoco_Axleload() {
		return loco_Axleload;
	}

	public void setLoco_Axleload(String loco_Axleload) {
		this.loco_Axleload = loco_Axleload;
	}

	public String getLoco_Unit() {
		return loco_Unit;
	}

	public void setLoco_Unit(String loco_Unit) {
		this.loco_Unit = loco_Unit;
	}

	public String getLoco_Gaugetype() {
		return loco_Gaugetype;
	}

	public void setLoco_Gaugetype(String loco_Gaugetype) {
		this.loco_Gaugetype = loco_Gaugetype;
	}

	
}
