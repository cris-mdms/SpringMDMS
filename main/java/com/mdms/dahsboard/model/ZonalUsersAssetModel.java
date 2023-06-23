package com.mdms.dahsboard.model;

public class ZonalUsersAssetModel {

	
	public ZonalUsersAssetModel(String zonecode,int total, String zonename )
	{
		this.zone=zonecode;
		this.count=total;
		this.zone_name=zonename;
		
	}
	
	public ZonalUsersAssetModel(String zonecode,int total,  String zonename,int cleansed,int draft, int pending )
	{
		this.zone=zonecode;
		this.count=total;
		this.zone_name=zonename;
		this.cleansed=cleansed;
		this.draft=draft;
//		this.uncleansed=uncleansed;
		this.pending= pending;
	}
		

	public int uncleansed;
	public String zone;
	public int count;
	public String zone_name;
	public int cleansed ;
	public int draft ;
	public int pending ;

	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}


	public int getUncleansed() {
		return uncleansed;
	}

	public void setUncleansed(int uncleansed) {
		this.uncleansed = uncleansed;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public int getCleansed() {
		return cleansed;
	}

	public void setCleansed(int cleansed) {
		this.cleansed = cleansed;
	}

	public int getDraft() {
		return draft;
	}

	public void setDraft(int draft) {
		this.draft = draft;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}
	
	
}
