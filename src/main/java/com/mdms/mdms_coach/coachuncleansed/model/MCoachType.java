package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_coach_type_cmm", schema="mdms_coach")
public class MCoachType {
	@Id
	@Column(name="coach_type")
	private String coach_type;
	
	@Column(name="coupling_type")
	private String coupling_type;
	
	@Column(name="power_generation_type")
	private String power_generation_type;
	
	@Column(name="coach_type_description")
	private String coach_type_description;
	
	@Column(name="vehicle_type")
	private String vehicle_type;
	
	@Column(name="coach_category")
	private String coach_category;
	
	@Column(name="coach_ac_flag")
	private String coach_ac_flag;
	
	@Column(name="coach_class")
	private String coach_class;
	
	@Column(name="prs_class")
	private String prs_class;
	
	@Column(name="gauge")
	private String gauge;
	
	@Column(name="coach_capacity")
	private String coach_capacity;
	
	@Column(name="brake_type")
	private String brake_type;

	@Column(name="tare_weight")
	private String tare_weight;
	
	@Column(name="max_speed")
	private String max_speed;
	
	@Column(name="reserved_flag")
	private String reserved_flag;

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

	
	public String getPrs_class() {
		return prs_class;
	}

	public void setPrs_class(String prs_class) {
		this.prs_class = prs_class;
	}

	public String getCoach_class() {
		return coach_class;
	}

	public void setCoach_class(String coach_class) {
		this.coach_class = coach_class;
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

	public String getCoach_capacity() {
		return coach_capacity;
	}

	public void setCoach_capacity(String coach_capacity) {
		this.coach_capacity = coach_capacity;
	}

	public String getBrake_type() {
		return brake_type;
	}

	public void setBrake_type(String brake_type) {
		this.brake_type = brake_type;
	}

	public String getTare_weight() {
		return tare_weight;
	}

	public void setTare_weight(String tare_weight) {
		this.tare_weight = tare_weight;
	}

	public String getMax_speed() {
		return max_speed;
	}

	public void setMax_speed(String max_speed) {
		this.max_speed = max_speed;
	}

	public String getReserved_flag() {
		return reserved_flag;
	}

	public void setReserved_flag(String reserved_flag) {
		this.reserved_flag = reserved_flag;
	}

	
	
	
}
