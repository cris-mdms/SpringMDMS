/*This Model class refers Gauge Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_gauge", schema="mdms_masters")
public class MGauge {

	@Id
	@Column(name="gauge_code")
	private String gauge_code;
	
	@Column(name="description")
	private String description;

	public String getGauge_code() {
		return gauge_code;
	}

	public void setGauge_code(String gauge_code) {
		this.gauge_code = gauge_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
