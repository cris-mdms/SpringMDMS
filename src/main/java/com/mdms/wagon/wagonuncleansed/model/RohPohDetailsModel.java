package com.mdms.wagon.wagonuncleansed.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="wagon_data_irwms", schema="mdms_wagon")
public class RohPohDetailsModel {
	@Id
	private String roh_station;
	private Date roh_date;
	private Date poh_date;
	private String poh_workshop;
	private Date poh_due_date;
	
	
	public String getRoh_station() {
		return roh_station;
	}
	public void setRoh_station(String roh_station) {
		this.roh_station = roh_station;
	}
	public Date getRoh_date() {
		return roh_date;
	}
	public void setRoh_date(Date roh_date) {
		this.roh_date = roh_date;
	}
	public Date getPoh_date() {
		return poh_date;
	}
	public void setPoh_date(Date poh_date) {
		this.poh_date = poh_date;
	}
	public String getPoh_workshop() {
		return poh_workshop;
	}
	public void setPoh_workshop(String poh_workshop) {
		this.poh_workshop = poh_workshop;
	}
	public Date getPoh_due_date() {
		return poh_due_date;
	}
	public void setPoh_due_date(Date poh_due_date) {
		this.poh_due_date = poh_due_date;
	}
	

}
