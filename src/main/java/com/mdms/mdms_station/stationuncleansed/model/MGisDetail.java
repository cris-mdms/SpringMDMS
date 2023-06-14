/*This Model class refers GIS Table for referential data input and show to user.  For Latitude, Longitude   
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_gis_detail", schema="mdms_station")
public class MGisDetail {
	
	
	
	@Column(name="gis_id")
	private int gis_id;
	
	
	@Column(name="dist_km")
	private String dist_km;
	

	@Column(name="dist_m")
	private String dist_m;
	
	
	@Column(name="latitude")
	private String latitude;
	
	
	@Column(name="longitude")
	private String longitude;
	
	@Id
	@Column(name="station_code")
	private String station_code;

	public int getGis_id() {
		return gis_id;
	}

	public void setGis_id(int gis_id) {
		this.gis_id = gis_id;
	}

	public String getDist_km() {
		return dist_km;
	}

	public void setDist_km(String dist_km) {
		this.dist_km = dist_km;
	}

	public String getDist_m() {
		return dist_m;
	}

	public void setDist_m(String dist_m) {
		this.dist_m = dist_m;
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
