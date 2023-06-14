/*This Model class refers Station Traction Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_traction", schema="mdms_station")
public class MTraction {
	
	@Id
	@Column(name="traction_code")
	private String traction_code;
	
	@Column(name="description")
	private String description;

	public String getTraction_code() {
		return traction_code;
	}

	public void setTraction_code(String traction_code) {
		this.traction_code = traction_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
