
/*This Model class refers PRS Data for raw data input and show to user.    
 * 
 * initiated by Anshul
 * on  17-10-2023
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;

@Entity()
@Table(name="station_table_prs", schema="mdms_station")
public class StationTablePRS {
	
	@Id
	@Column(name="stn_code")
	private String  stn_code;
  
	
	@Column(name="stn_name")
	private String  stn_name;
  
	
	@Column(name="zone_code")
	private String  zone_code;
  
	
	@Column(name="division")
	private String  division;


	public String getStn_code() {
		return stn_code;
	}


	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}


	public String getStn_name() {
		return stn_name;
	}


	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
	}


	public String getZone_code() {
		return zone_code;
	}


	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}
  

}
