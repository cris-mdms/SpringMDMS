package com.mdms.app.mgmt.model;

public class DashboardJsonModel {		
	String station ="";
	String coach="";
	String loco="";
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getLoco() {
		return loco;
	}
	public void setLoco(String loco) {
		this.loco = loco;
	}
	@Override
	public String toString() {
		return "DashboardJsonModel [station=" + station + ", coach=" + coach + ", loco=" + loco + "]";
	}
	
	

}
