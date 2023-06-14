package com.mdms.mdms_coach.coachuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_depo", schema="mdms_coach")
public class MDepot {

	@Id
	@Column(name="depo_code")
	private String depo_code;
	
	@Column(name="depo_name")
	private String depo_name;
	
	@Column(name="div_code")
	private String div_code;
	
	@Column(name="zone_code")
	private String zone_code;

	public String getDepo_code() {
		return depo_code;
	}

	public void setDepo_code(String depo_code) {
		this.depo_code = depo_code;
	}

	public String getDepo_name() {
		return depo_name;
	}

	public void setDepo_name(String depo_name) {
		this.depo_name = depo_name;
	}

	public String getDiv_code() {
		return div_code;
	}

	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}
	
	
}
