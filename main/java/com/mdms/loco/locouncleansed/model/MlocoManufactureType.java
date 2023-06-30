package com.mdms.loco.locouncleansed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_manufacturer", schema="mdms_loco")
public class MlocoManufactureType {	
	@Id()
	private String mfd_id;
	private String mfd_name;
	
	public MlocoManufactureType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MlocoManufactureType(String mfd_id, String mfd_name) {
		super();
		this.mfd_id = mfd_id;
		this.mfd_name = mfd_name;
	}

	public String getMfd_id() {
		return mfd_id;
	}

	public void setMfd_id(String mfd_id) {
		this.mfd_id = mfd_id;
	}

	public String getMfd_name() {
		return mfd_name;
	}

	public void setMfd_name(String mfd_name) {
		this.mfd_name = mfd_name;
	}

	
}
