package com.mdms.app.mgmt.model;

public class GetListUserRegistrationJsonModel {
	
	String user_type_list="";
	String user_role_list="";
	String department_list="";
	String designation_list="";
	String loco_type_list="";
	String loco_shed_list="";
	String zone_list="";
	String division_list="";
//	String loco_zone_list="";

	String depo_list="";

	String user_type_role_list="";
	
	public String getUser_type_role_list() {
		return user_type_role_list;
	}
	public void setUser_type_role_list(String user_type_role_list) {
		this.user_type_role_list = user_type_role_list;
	}
	public String getLoco_type_list() {
		return loco_type_list;
	}
	public void setLoco_type_list(String loco_type_list) {
		this.loco_type_list = loco_type_list;
	}
	public String getLoco_shed_list() {
		return loco_shed_list;
	}
	public void setLoco_shed_list(String loco_shed_list) {
		this.loco_shed_list = loco_shed_list;
	}
	public String getZone_list() {
		return zone_list;
	}
	public void setZone_list(String zone_list) {
		this.zone_list = zone_list;
	}
	public String getDivision_list() {
		return division_list;
	}
	public void setDivision_list(String division_list) {
		this.division_list = division_list;
	}
	public String getUser_type_list() {
		return user_type_list;
	}
	public void setUser_type_list(String user_type_list) {
		this.user_type_list = user_type_list;
	}
	public String getUser_role_list() {
		return user_role_list;
	}
	public void setUser_role_list(String user_role_list) {
		this.user_role_list = user_role_list;
	}
	public String getDepartment_list() {
		return department_list;
	}
	public void setDepartment_list(String department_list) {
		this.department_list = department_list;
	}
	public String getDesignation_list() {
		return designation_list;
	}
	public void setDesignation_list(String designation_list) {
		this.designation_list = designation_list;
	}

	
	public String getDepo_list() {
		return depo_list;
	}
	public void setDepo_list(String depo_list) {
		this.depo_list = depo_list;
	}

//	
//	public String getLoco_zone_list() {
//		return loco_zone_list;
//	}
//	public void setLoco_zone_list(String loco_zone_list) {
//		this.loco_zone_list = loco_zone_list;
//	}
	@Override
	public String toString() {
		return "GetListUserRegistrationJsonModel [user_type_list=" + user_type_list + ", user_role_list="
				+ user_role_list + ", department_list=" + department_list + ", designation_list=" + designation_list
				+ ", loco_type_list=" + loco_type_list + ", loco_shed_list=" + loco_shed_list + ", zone_list="
				+ zone_list + ", division_list=" + division_list + ",  depo_list=" + depo_list + "]";

	}
	
	
	
	
	

}
