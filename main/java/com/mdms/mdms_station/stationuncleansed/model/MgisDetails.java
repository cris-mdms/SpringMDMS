package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name="m_gis_detail", schema="mdms_station")
public class MgisDetails {
	@Id
	@Column(name="latitude")
	private String latitude;
	
	
	@Column(name="longitude")
	private String longitude;
	
	//private String table_name;

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

	/*
	 * public String getTable_name() { return table_name; }
	 * 
	 * public void setTable_name(String table_name) { this.table_name = table_name;
	 * }
	 */


}
