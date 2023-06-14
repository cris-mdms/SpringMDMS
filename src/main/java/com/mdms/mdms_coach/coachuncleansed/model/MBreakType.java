package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_brake_type", schema="mdms_coach")
public class MBreakType {
	
	@Id
	@Column(name="brake_type")
	private String breakType;
	
	private String description;

	public String getBreakType() {
		return breakType;
	}

	public void setBreakType(String breakType) {
		this.breakType = breakType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
