/*This Model class refers Station Traffic Type Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_station_junction", schema="mdms_station")
public class MTrafficType {
	
	@Id
	@Column(name="traffic_type")
	private String traffic_type;
	
	@Column(name="description")
	private String description;

	public String getTraffic_type() {
		return traffic_type;
	}

	public void setTraffic_type(String traffic_type) {
		this.traffic_type = traffic_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
