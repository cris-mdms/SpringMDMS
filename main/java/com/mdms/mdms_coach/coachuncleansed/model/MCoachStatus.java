package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_coach_status", schema="mdms_coach")
public class MCoachStatus {
	
	@Id
	@Column(name="coach_status")
	private String coachStatus;
	
	private String description;

	public String getCoachStatus() {
		return coachStatus;
	}

	public void setCoachStatus(String coachStatus) {
		this.coachStatus = coachStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
