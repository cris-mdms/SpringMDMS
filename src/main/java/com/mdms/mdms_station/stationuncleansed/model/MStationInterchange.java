/*This Model class refers Station Interchange Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_station_interchange", schema="mdms_station")
public class MStationInterchange {

	@Id
	@Column(name="interchange_flag")
	private String interchange_flag;
	
	@Column(name="description")
	private String description;

	public String getInterchange_flag() {
		return interchange_flag;
	}

	public void setInterchange_flag(String interchange_flag) {
		this.interchange_flag = interchange_flag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
