package com.mdms.dahsboard.model;


import java.util.Date;


public class DailyIntegrationModel {

public DailyIntegrationModel(String entity_name, String group_name,String asset_name, int c_count, Date publishing_date) {
this.entity_name=entity_name;
this.group_name=group_name;
this.asset_name=asset_name;
this.c_count=c_count;
this.publishing_date=publishing_date;

}




public String entity_name;
public String group_name;

public String asset_name;

public int c_count;

public Date publishing_date;

public String getEntity_name() {
	return entity_name;
}

public void setEntity_name(String entity_name) {
	this.entity_name = entity_name;
}

public String getGroup_name() {
	return group_name;
}

public void setGroup_name(String group_name) {
	this.group_name = group_name;
}

public String getAsset_name() {
	return asset_name;
}

public void setAsset_name(String asset_name) {
	this.asset_name = asset_name;
}

public int getC_count() {
	return c_count;
}

public void setC_count(int c_count) {
	this.c_count = c_count;
}

public Date getPublishing_date() {
	return publishing_date;
}

public void setPublishing_date(Date publishing_date) {
	this.publishing_date = publishing_date;
}




}

