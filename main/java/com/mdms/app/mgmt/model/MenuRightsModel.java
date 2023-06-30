//Developed By: Anshu Sharma , Date 13/Oct/2020 

package com.mdms.app.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="menu_rights", schema="mdms_app_mgmt")
public class MenuRightsModel {
	
	@Id
	@Column(name="menu_id")
	private Integer menu_id;
	
	
	@Column(name="user_id")
	private String user_id;

	@Column(name="user_prim_sec")
	private String user_prim_sec;
	
	@Column(name="user_type")
	private String user_type;

	
	@Column(name="role_type")
	private String role_type;

	@Column(name="sub_user_type")
	private String sub_user_type;

	@Column(name="user_desig")
	private Date user_desig;

	@Column(name="user_dept")
	private Date user_dept;

	@Column(name="entry_on")
	private Date entry_on;

	@Column(name="railway_unit")
	private String railway_unit;

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_prim_sec() {
		return user_prim_sec;
	}

	public void setUser_prim_sec(String user_prim_sec) {
		this.user_prim_sec = user_prim_sec;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	public String getSub_user_type() {
		return sub_user_type;
	}

	public void setSub_user_type(String sub_user_type) {
		this.sub_user_type = sub_user_type;
	}

	public Date getUser_desig() {
		return user_desig;
	}

	public void setUser_desig(Date user_desig) {
		this.user_desig = user_desig;
	}

	public Date getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(Date user_dept) {
		this.user_dept = user_dept;
	}

	public Date getEntry_on() {
		return entry_on;
	}

	public void setEntry_on(Date entry_on) {
		this.entry_on = entry_on;
	}

	public String getRailway_unit() {
		return railway_unit;
	}

	public void setRailway_unit(String railway_unit) {
		this.railway_unit = railway_unit;
	}

	@Override
	public String toString() {
		return "MenuRightsModel [menu_id=" + menu_id + ", user_id=" + user_id + ", user_prim_sec=" + user_prim_sec
				+ ", user_type=" + user_type + ", role_type=" + role_type + ", sub_user_type=" + sub_user_type
				+ ", user_desig=" + user_desig + ", user_dept=" + user_dept + ", entry_on=" + entry_on
				+ ", railway_unit=" + railway_unit + "]";
	}

	
	

}
