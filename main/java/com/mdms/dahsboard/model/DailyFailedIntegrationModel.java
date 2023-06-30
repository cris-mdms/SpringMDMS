package com.mdms.dahsboard.model;

import java.util.Date;

public class DailyFailedIntegrationModel {
	public  DailyFailedIntegrationModel(String asset_name, int c_count, Date string) {
		this.asset_name=asset_name;
		this.c_count=c_count;
		this.publishing_failed_date=string;
//		this.tibco_error_detail=tibcoerror;
	}

	
	public String asset_name;
	public Date publishing_failed_date;
	public int c_count;
	public String tibco_error_detail;
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
		
	}
	public Date getPublishing_failed_date() {
		return publishing_failed_date;
	}
	public void setPublishing_failed_date(Date publishing_failed_date) {
		this.publishing_failed_date = publishing_failed_date;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	public String getTibco_error_detail() {
		return tibco_error_detail;
	}
	public void setTibco_error_detail(String tibco_error_detail) {
		this.tibco_error_detail = tibco_error_detail;
	}
	
	
}
