package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_coach_category", schema="mdms_coach")
public class MCoachCategoryType {
	
	@Id
	@Column(name="coach_category")
	private String coachCategory;
	
	private String description;
	

	public String getCoachCategory() {
		return coachCategory;
	}

	public void setCoachCategory(String coachCategory) {
		this.coachCategory = coachCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
