package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_station_class", schema="mdms_station")
public class MStationClass {
	
	
	@Id
	@Column(name="station_class")
	private String station_class;
	
	@Column(name="description")
	private String description;

	public String getStation_class() {
		return station_class;
	}

	public void setStation_class(String station_class) {
		this.station_class = station_class;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
