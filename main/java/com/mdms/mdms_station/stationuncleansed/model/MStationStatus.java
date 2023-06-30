/*This Model class refers Station Status Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_station_status", schema="mdms_station")
public class MStationStatus {
	
	@Id
	@Column(name="status")
	private String status;
	
	@Column(name="description")
	private String description;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
