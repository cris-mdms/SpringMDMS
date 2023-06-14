package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_power_gen_type", schema="mdms_coach")
public class MPowerGenerationType {
	
	@Id
	@Column(name="power_generation_type")
	private String powerGenerationType;
	
	private String description;

	public String getPowerGenerationType() {
		return powerGenerationType;
	}

	public void setPowerGenerationType(String powerGenerationType) {
		this.powerGenerationType = powerGenerationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
