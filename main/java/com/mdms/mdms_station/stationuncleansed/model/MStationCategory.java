package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_station_category", schema="mdms_station")
public class MStationCategory {
	
	@Id
	@Column(name="station_category")
	private String station_category;
	
	@Column(name="description")
	private String description;

	public String getStation_category() {
		return station_category;
	}

	public void setStation_category(String station_category) {
		this.station_category = station_category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
