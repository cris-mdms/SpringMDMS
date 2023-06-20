package com.mdms.app.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_user_role", schema="mdms_app_mgmt")
public class MUserRole {
	@Id
	@Column(name="role_type")
	private String role_type;
	
	
	@Column(name="description")	
	private String description;


	public String getRole_type() {
		return role_type;
	}


	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


}
