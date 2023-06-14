package com.mdms.app.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="old_user_detail", schema="mdms_app_mgmt")
public class OldUserDetailModel {
	@Id
	@Column(name="old_user_id")
	private String old_user_id;
	
	
	@Column(name="user_type")	
	private String user_type;

	@Column(name="user_role")
	private String user_role;
	
	@Column(name="user_flag")
	private String user_flag;
	

	public String getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(String user_flag) {
		this.user_flag = user_flag;
	}

	public String getOld_user_id() {
		return old_user_id;
	}

	public void setOld_user_id(String old_user_id) {
		this.old_user_id = old_user_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	  

}
