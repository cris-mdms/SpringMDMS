//Developed By: Anshu Sharma , Date 09/Oct/2020 


package com.mdms.app.mgmt.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="user_otp_detail", schema="mdms_app_mgmt")
public class LoginOtpModel {	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	
	@Column(name="otp")
	private Integer otp;

	@Column(name="valid_from")
	private Date valid_from;
	
	@Column(name="valid_to")
	private Date valid_to;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
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

	@Override
	public String toString() {
		return "LoginOtpModel [user_id=" + user_id + ", otp=" + otp + ", valid_from=" + valid_from + ", valid_to="
				+ valid_to + "]";
	}
	
	
	
	
	
	

}
