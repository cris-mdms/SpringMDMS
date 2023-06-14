package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_wagon_workshop", schema="mdms_wagon")
public class MWagonWorkshop {
	@Id
	@Column(name="workshop_id")
	private String  workshop_id ;
	
	@Column(name="workshop_name")
	private String  workshop_name ;
	
	@Column(name="workshop_rly")
	private String  workshop_rly ;
	
	@Column(name="valid")
	private String  valid ;
	
	@Column(name="workshop_type")
	private String  workshop_type ;

	public String getWorkshop_id() {
		return workshop_id;
	}

	public void setWorkshop_id(String workshop_id) {
		this.workshop_id = workshop_id;
	}

	public String getWorkshop_name() {
		return workshop_name;
	}

	public void setWorkshop_name(String workshop_name) {
		this.workshop_name = workshop_name;
	}

	public String getWorkshop_rly() {
		return workshop_rly;
	}

	public void setWorkshop_rly(String workshop_rly) {
		this.workshop_rly = workshop_rly;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getWorkshop_type() {
		return workshop_type;
	}

	public void setWorkshop_type(String workshop_type) {
		this.workshop_type = workshop_type;
	}
	
	
}
