package com.mdms.app.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="master_user_login_detail", schema="mdms_app_mgmt")
public class MasterUserLoginDetail {
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="emp_password")
	private Integer emp_password;
	
	@Column(name="valid_from")
	private Date valid_from;
			

	@Column(name="valid_to")
	private Date valid_to;	
	

	

	

	public Integer getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(Integer emp_password) {
		this.emp_password = emp_password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_to() {
		return valid_to;
	}

	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
	}

	
	

}
