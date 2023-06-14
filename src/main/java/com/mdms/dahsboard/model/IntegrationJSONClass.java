package com.mdms.dahsboard.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
public class IntegrationJSONClass {
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("from_date")
	private Date fromdt;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("to_date")
	private Date todt;
	
	@JsonProperty("stn_code")
	

	public Date getFromdt(){
		return fromdt;
	}

	public void setFromdt(Date fromdt) {
		this.fromdt = fromdt;
	}

	public Date getTodt() {
		return todt;
	}

	public void setTodt(Date todt) {
		this.todt = todt;
	}
	
	
}
