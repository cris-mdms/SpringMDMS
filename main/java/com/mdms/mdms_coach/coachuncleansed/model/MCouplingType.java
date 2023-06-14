package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_coupling_type", schema="mdms_coach")
public class MCouplingType {
	
	@Id
	@Column(name="coupling_type")
	private String couplingType;
	
	private String description;

	public String getCouplingType() {
		return couplingType;
	}

	public void setCouplingType(String couplingType) {
		this.couplingType = couplingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
