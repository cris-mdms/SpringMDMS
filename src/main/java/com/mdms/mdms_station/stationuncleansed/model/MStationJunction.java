/*This Model class refers Station Junction Table for referential data input and show to user.     
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
public class MStationJunction {
	
	
	@Id
	@Column(name="junction_flag")
	private String junction_flag;
	
	@Column(name="description")
	private String description;

	public String getJunction_flag() {
		return junction_flag;
	}

	public void setJunction_flag(String junction_flag) {
		this.junction_flag = junction_flag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
