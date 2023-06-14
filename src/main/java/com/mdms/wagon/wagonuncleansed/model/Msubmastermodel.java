package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_orgnization_type", schema="mdms_wagon")
public class Msubmastermodel {
	
	@Id
	@Column(name="orgnization_type")
	private String orgnization_type;
	
	private String description;

	public Msubmastermodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Msubmastermodel(String orgnization_type, String description) {
		super();
		this.orgnization_type = orgnization_type;
		this.description = description;
	}

	public String getOrgnization_type() {
		return orgnization_type;
	}

	public void setOrgnization_type(String orgnization_type) {
		this.orgnization_type = orgnization_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
