/*This Model class refers Station Interlocking Std Table for referential data input and show to user.     
 * Created By : Anshul, 22-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_interlocking_standard", schema="mdms_station")
public class MInterlockingStandard {

	
	@Id
	@Column(name="standard_code")
	private String standard_code;
	
	
	@Column(name="description")
	private String description;


	public String getStandard_code() {
		return standard_code;
	}


	public void setStandard_code(String standard_code) {
		this.standard_code = standard_code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
