package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="m_wagon_manufacture", schema="mdms_wagon")
public class MWagonManufacture {
	@Id
	@Column(name="wagon_manufacture_code")
	private String  wagon_manufacture_code ;
	
	@Column(name="manufacture_name")
	private String  manufacture_name ;
	
	@Column(name="manufacture_rly")
	private String  manufacture_rly ;
	
	@Column(name="orgnization_type")
	private String  orgnization_type ;
	
	@Column(name="jdctn")
	private String  jdctn;

	public String getWagon_manufacture_code() {
		return wagon_manufacture_code;
	}

	public void setWagon_manufacture_code(String wagon_manufacture_code) {
		this.wagon_manufacture_code = wagon_manufacture_code;
	}

	public String getManufacture_name() {
		return manufacture_name;
	}

	public void setManufacture_name(String manufacture_name) {
		this.manufacture_name = manufacture_name;
	}

	public String getManufacture_rly() {
		return manufacture_rly;
	}

	public void setManufacture_rly(String manufacture_rly) {
		this.manufacture_rly = manufacture_rly;
	}

	public String getOrgnization_type() {
		return orgnization_type;
	}

	public void setOrgnization_type(String orgnization_type) {
		this.orgnization_type = orgnization_type;
	}

	public String getJdctn() {
		return jdctn;
	}

	public void setJdctn(String jdctn) {
		this.jdctn = jdctn;
	}
	
	
	
}

