package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_wagon_gauge", schema="mdms_wagon")
public class MwagonGaugeModel {
	
	@Id
	@Column(name="wagon_gauge_code")
	private String wagon_gauge_code;
	
	private String description;

	public MwagonGaugeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MwagonGaugeModel(String wagon_gauge_code, String description) {
		super();
		this.wagon_gauge_code = wagon_gauge_code;
		this.description = description;
	}

	public String getWagon_gauge_code() {
		return wagon_gauge_code;
	}

	public void setWagon_gauge_code(String wagon_gauge_code) {
		this.wagon_gauge_code = wagon_gauge_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
