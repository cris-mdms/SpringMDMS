package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="rtis_lat_long_10_01_22", schema="mdms_station")
public class RtisLatLongModel {
	
	@Id
	@Column(name="station_latitude")
	private String station_latitude;
	
	
	@Column(name="station_longitude")
	private String station_longitude;


	public String getStation_latitude() {
		return station_latitude;
	}


	public void setStation_latitude(String station_latitude) {
		this.station_latitude = station_latitude;
	}


	public String getStation_longitude() {
		return station_longitude;
	}


	public void setStation_longitude(String station_longitude) {
		this.station_longitude = station_longitude;
	}

}
