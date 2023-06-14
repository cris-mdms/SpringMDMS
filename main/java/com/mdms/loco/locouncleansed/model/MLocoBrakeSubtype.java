package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_brake_subtype", schema="mdms_loco")
public class MLocoBrakeSubtype {
	@Id()                                
	@Column(name="srno")  
	private int srno;
	
	@Column(name="brake_subtype")
	private String brakesubtype;

	public String getBrakesubtype() {
		return brakesubtype;
	}

	public void setBrakesubtype(String brakesubtype) {
		this.brakesubtype = brakesubtype;
	}

	
	
}
