package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_traction_motor", schema="mdms_loco")
public class MLocoTractionMotor {
	@Id()                                
	@Column(name="loco_traction_motor_type")                  
	private String tractionCode;

	public String getTractionCode() {
		return tractionCode;
	}

	public void setTractionCode(String tractionCode) {
		this.tractionCode = tractionCode;
	}
	
	

}
