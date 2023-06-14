package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_wagon_status", schema="mdms_wagon")
public class MWagonStatus {
	@Id
	@Column(name="wagon_status")
	private String  wagon_status ;
	
	@Column(name="description")
	private String  description ;

	public String getWagon_status() {
		return wagon_status;
	}

	public void setWagon_status(String wagon_status) {
		this.wagon_status = wagon_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
