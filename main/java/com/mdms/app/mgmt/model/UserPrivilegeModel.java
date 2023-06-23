package com.mdms.app.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="user_privilege", schema="mdms_app_mgmt")
public class UserPrivilegeModel {
	@Id	
	@Column(name="user_id")                  
	public String user_id; 
	 
	@Column(name="user_code")                  
	public String user_code; 
	

	@Column(name="name")                  
	public String uname; 
	

	@Column(name="privilege_name")                  
	public String privilege_name; 
	
	
	@Column(name="shed")                  
	public String shed; 
     
	@Column(name="parent_id")                  
	public String parent_id; 
     
	@Column(name="current_status")                  
	public String current_status; 	
	

	@Column(name="additional_role_type")                  
	public String additional_role_type; 
	
    
    @Column(name="additional_role_active")                  
	public String additional_role_active;


	
	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}




	
    
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_code() {
		return user_code;
	}


	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}


	public String getPrivilege_name() {
		return privilege_name;
	}


	public void setPrivilege_name(String privilege_name) {
		this.privilege_name = privilege_name;
	}


	public String getShed() {
		return shed;
	}


	public void setShed(String shed) {
		this.shed = shed;
	}


	public String getParent_id() {
		return parent_id;
	}


	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}


	public String getCurrent_status() {
		return current_status;
	}


	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}


	public String getAdditional_role_type() {
		return additional_role_type;
	}


	public void setAdditional_role_type(String additional_role_type) {
		this.additional_role_type = additional_role_type;
	}


	public String getAdditional_role_active() {
		return additional_role_active;
	}


	public void setAdditional_role_active(String additional_role_active) {
		this.additional_role_active = additional_role_active;
	} 
     
    

}
