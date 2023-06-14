package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_wagon_owning_rly", schema="mdms_wagon")
public class MWagonOwningRly {
	@Id
	@Column(name="wagon_owning_rly")
	private String  wagon_owning_rly ;
	
	@Column(name="description")
	private String  description ;
	
	@Column(name="orgnization_type")
	private String  orgnization_type ;
	
	@Column(name="rcd")
	private String  rcd ;
	
	@Column(name="rly_id")
	private String  rly_id ;
	
	@Column(name="irwms_owner")
	private String  irwms_owner ;
	
	@Column(name="fois_owner")
	private String  fois_owner ;

	public String getWagon_owning_rly() {
		return wagon_owning_rly;
	}

	public void setWagon_owning_rly(String wagon_owning_rly) {
		this.wagon_owning_rly = wagon_owning_rly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrgnization_type() {
		return orgnization_type;
	}

	public void setOrgnization_type(String orgnization_type) {
		this.orgnization_type = orgnization_type;
	}

	public String getRcd() {
		return rcd;
	}

	public void setRcd(String rcd) {
		this.rcd = rcd;
	}

	public String getRly_id() {
		return rly_id;
	}

	public void setRly_id(String rly_id) {
		this.rly_id = rly_id;
	}

	public String getIrwms_owner() {
		return irwms_owner;
	}

	public void setIrwms_owner(String irwms_owner) {
		this.irwms_owner = irwms_owner;
	}

	public String getFois_owner() {
		return fois_owner;
	}

	public void setFois_owner(String fois_owner) {
		this.fois_owner = fois_owner;
	}
	
	
	

}
