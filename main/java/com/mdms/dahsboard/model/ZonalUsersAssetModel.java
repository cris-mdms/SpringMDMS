package com.mdms.dahsboard.model;

public class ZonalUsersAssetModel {

	
	public ZonalUsersAssetModel(String zonecode,int total, String zonename )
	{
		this.zone=zonecode;
		this.count=total;
		this.zone_name=zonename;
		
	}
	

	public ZonalUsersAssetModel(String zonecode, int total,  String zonename,int cleansed,int draft, int uncleansed, int pending)
	{
		this.zone=zonecode;
		this.count=total;
		this.zone_name=zonename;
		this.cleansed=cleansed;
		this.draft=draft;
		this.uncleansed= uncleansed;
		this.pending=pending;
	}
	

	public ZonalUsersAssetModel(String zonecode, String shed_code, String shed_name, int total,  String zonename,int cleansed,int draft, int uncleansed, int pending)
	{
		this.zone=zonecode;
		this.shed_code=shed_code;
		this.shed_name=shed_name;
		this.count=total;
		this.zone_name=zonename;
		this.cleansed=cleansed;
		this.draft=draft;
		this.uncleansed= uncleansed;
		this.pending= pending;
	}
	



	public String shed_code;
	public String shed_name;
	public String zone;
	public int uncleansed;
	public int count;
	public String zone_name;
	public int cleansed ;
	public int draft ;
	public int pending ;

	
	
	
	public String getShed_code() {
		return shed_code;
	}

	public void setShed_code(String shed_code) {
		this.shed_code = shed_code;
	}

	public String getShed_name() {
		return shed_name;
	}

	public void setShed_name(String shed_name) {
		this.shed_name = shed_name;
	}

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
