package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_coach_type_cmm_exception", schema="mdms_coach")
public class MCoachtypecmmexception {

	@Id
	@Column(name="coach_type")
	private String coach_type;
	private String coupling_type;
	
	private String power_generation_type;
	private String coach_type_description;
	private String vehicle_type;
	private String coach_category;
	private String coach_ac_flag;
	private String gauge;
	private String coach;
	public String getCoach_type() {
		return coach_type;
	}
	public void setCoach_type(String coach_type) {
		this.coach_type = coach_type;
	}
	public String getCoupling_type() {
		return coupling_type;
	}
	public void setCoupling_type(String coupling_type) {
		this.coupling_type = coupling_type;
	}
	public String getPower_generation_type() {
		return power_generation_type;
	}
	public void setPower_generation_type(String power_generation_type) {
		this.power_generation_type = power_generation_type;
	}
	public String getCoach_type_description() {
		return coach_type_description;
	}
	public void setCoach_type_description(String coach_type_description) {
		this.coach_type_description = coach_type_description;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getCoach_category() {
		return coach_category;
	}
	public void setCoach_category(String coach_category) {
		this.coach_category = coach_category;
	}
	public String getCoach_ac_flag() {
		return coach_ac_flag;
	}
	public void setCoach_ac_flag(String coach_ac_flag) {
		this.coach_ac_flag = coach_ac_flag;
	}
	public String getGauge() {
		return gauge;
	}
	public void setGauge(String gauge) {
		this.gauge = gauge;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	
	
}
