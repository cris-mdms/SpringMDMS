package com.mdms.loco.locouncleansed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_control_type", schema="mdms_loco")
public class MlocoControlType {

	@Id()
	private String control_type_id;
	private String control_type_name;
	
	public MlocoControlType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MlocoControlType(String control_type_id, String control_type_name) {
		super();
		this.control_type_id = control_type_id;
		this.control_type_name = control_type_name;
	}

	public String getControl_type_id() {
		return control_type_id;
	}

	public void setControl_type_id(String control_type_id) {
		this.control_type_id = control_type_id;
	}

	public String getControl_type_name() {
		return control_type_name;
	}

	public void setControl_type_name(String control_type_name) {
		this.control_type_name = control_type_name;
	}
}
