package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StationRBSJsonModel {
	@Id
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST") 
	private Date day;

	private String  stn_code;
	
	public String getStn_code() {
		return stn_code;
	}

	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	
	

}
