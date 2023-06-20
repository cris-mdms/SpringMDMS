
package com.mdms.app.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity()
@Table(name="user_profile_registration_history_table", schema="mdms_app_mgmt")
public class UserProfileRegistrationDetailHistory {
	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="name")	
	private String uname;

	@Column(name="designation")
	private String designation;
	
	@Column(name="department")
	private String department;
	
	@Column(name="loco_type")
	private String loco_type;
	
	@Column(name="shed")
	private String shed;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="from_date")
	private Date from_date;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="to_date")
	private Date to_date;
	
	@Column(name="role_type")
	private String role_type;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="mobile_no")
	private String mobile_no;
	
	@Column(name="entity")
	private String entity;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_by")
	private String created_by;
	

	@Column(name="zone")
	private String zone;
	
	@Column(name="division")
	private String division;

	
	@Column(name="user_register_approval")
	private String user_register_approval;
	
	@Column(name="service_status")
	private String hrms_service_status;
	
	
	

	@Column(name="depo")
	private String depo;
	
	@Column(name="old_user_id")
	private String old_user_id;
	
	@Column(name="cris_user")
	private String cris_user;
	
	@Column(name="asset_designation_code")
	private String asset_designation_code;
	

	@Column(name="additional_shed")
	private String additional_shed;
	
	@Column(name="additional_shed_active")
	private String additional_shed_active;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="additional_shed_date")
	private Date additional_shed_date;
	
	private String last_status;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date status_update_time;
	
	private String updated_by;
	
	public String getLast_status() {
		return last_status;
	}

	public void setLast_status(String last_status) {
		this.last_status = last_status;
	}

	public Date getStatus_update_time() {
		return status_update_time;
	}

	public void setStatus_update_time(Date status_update_time) {
		this.status_update_time = status_update_time;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getAsset_designation_code() {
		return asset_designation_code;
	}

	public void setAsset_designation_code(String asset_designation_code) {
		this.asset_designation_code = asset_designation_code;
	}

	public String getCris_user() {
		return cris_user;
	}

	public void setCris_user(String cris_user) {
		this.cris_user = cris_user;
	}

	public String getOld_user_id() {
		return old_user_id;
	}

	public void setOld_user_id(String old_user_id) {
		this.old_user_id = old_user_id;
	}

	public String getDepo() {
		return depo;
	}

	public void setDepo(String depo) {
		this.depo = depo;
	}


	public String getHrms_service_status() {
		return hrms_service_status;
	}

	public void setHrms_service_status(String hrms_service_status) {
		this.hrms_service_status = hrms_service_status;
	}

	
	
	public String getUser_register_approval() {
		return user_register_approval;
	}

	public void setUser_register_approval(String user_register_approval) {
		this.user_register_approval = user_register_approval;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLoco_type() {
		return loco_type;
	}

	public void setLoco_type(String loco_type) {
		this.loco_type = loco_type;
	}

	public String getShed() {
		return shed;
	}

	public void setShed(String shed) {
		this.shed = shed;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getAdditional_shed() {
		return additional_shed;
	}

	public void setAdditional_shed(String additional_shed) {
		this.additional_shed = additional_shed;
	}

	public String getAdditional_shed_active() {
		return additional_shed_active;
	}

	public void setAdditional_shed_active(String additional_shed_active) {
		this.additional_shed_active = additional_shed_active;
	}

	public Date getAdditional_shed_date() {
		return additional_shed_date;
	}

	public void setAdditional_shed_date(Date additional_shed_date) {
		this.additional_shed_date = additional_shed_date;
	}

	@Override
	public String toString() {
		return "UserProfileRegistrationDetailModel [user_id=" + user_id + ", name=" + uname + ", designation="
				+ designation + ", department=" + department + ", loco_type=" + loco_type + ", shed=" + shed
				+ ", from_date=" + from_date + ", to_date=" + to_date + ", role_type=" + role_type + ", user_type="
				+ user_type + ", mobile_no=" + mobile_no + ", entity=" + entity + ", email=" + email + ", created_by="
				+ created_by + ", zone=" + zone + ", division=" + division + ", user_register_approval="
				+ user_register_approval + "]";
	}

	

	
	
	
	 
	

}
