

package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_state", schema="mdms_masters")
public class MState {

	@Id	
	@Column(name="state_code")
	private int state_code;

	
	@Column(name="state_name")
	private String state_name;


	public int getState_code() {
		return state_code;
	}


	public void setState_code(int state_code) {
		this.state_code = state_code;
	}


	public String getState_name() {
		return state_name;
	}


	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	

}
