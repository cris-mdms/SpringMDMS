/*This Model class refers Division Sub Master Data to show to user.     
 * Created By : Anshul, 02-11-2020
 * 
 */
package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_division", schema="mdms_masters")
public class MDivision {
	@Id
	@Column(name="division_code")
	private String division_code ;
	
	@Column(name="division_name")
	private String division_name ;
	
	@Column(name="zone_code")
	private String 	zone_code ;
	
	@Column(name="division_sr_no")
	private int division_sr_no;

	public String getDivision_code() {
		return division_code;
	}

	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public int getDivision_sr_no() {
		return division_sr_no;
	}

	public void setDivision_sr_no(int division_sr_no) {
		this.division_sr_no = division_sr_no;
	}
	
	
	
}
