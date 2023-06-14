package com.mdms.datadictionary.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class ReferentialsDynamicmodel {

	
	


	@Id
	@Column(name="latitude")
	private String latitude;
	private String longitude;
	private String station_code;
	
	
	public ReferentialsDynamicmodel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReferentialsDynamicmodel(String latitude, String longitude, String station_code) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.station_code = station_code;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getStation_code() {
		return station_code;
	}


	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	
}
