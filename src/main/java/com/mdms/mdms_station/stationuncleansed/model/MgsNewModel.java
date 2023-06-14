package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="rtis_lat_long_10_01_22", schema="mdms_station")
public class MgsNewModel {
	
	@Id
	@Column(name="station_latitude")
	private float latitude;
	
	
	@Column(name="station_longitude")
	private String longitude;


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	


}
