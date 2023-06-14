package com.mdms.dahsboard.model;

public class ZonalUserReportModel {
	
	
	
	public ZonalUserReportModel(String d, int c, String div)
{
	this.division=d;
	this.count=c;
	this.division_name=div;
	
}
public String division;
public int count;
public String division_name;




public int getCount() {
	return count;
}


public void setCount(int count) {
	this.count = count;
}

public String getDivision() {
	return division;
}

public void setDivision(String division) {
	this.division = division;
}

public String getDivision_name() {
	return division_name;
}

public void setDivision_name(String division_name) {
	this.division_name = division_name;
}

}
