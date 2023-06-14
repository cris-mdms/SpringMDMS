package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_brake_type", schema="mdms_loco")
public class MLocoBrakeType {
	
	@Id()                                
	@Column(name="brake_type")                  
	private String breakID;
	
	@Column(name="brake_type_name")                 
	private String breakName;

	public String getBreakID() {
		return breakID;
	}

	public void setBreakID(String breakID) {
		this.breakID = breakID;
	}

	public String getBreakName() {
		return breakName;
	}

	public void setBreakName(String breakName) {
		this.breakName = breakName;
	}
	
	

}
