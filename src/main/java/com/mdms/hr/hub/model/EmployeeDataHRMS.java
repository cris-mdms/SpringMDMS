package com.mdms.hr.hub.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity()
@Table(name="employee_data_hrms", schema="mdms_hr_hub")
public class EmployeeDataHRMS {	
	@Id	
	@Column(name="hrms_id")                  
	public String hrms_id; 
	
	@Column(name="ipas_id")                  
	private String ipas_id; 	
	
	
	@Column(name="date_of_birth")                  
	public Date date_of_birth;

	
	@Column(name="date_of_appointment")                  
	public Date date_of_appointment;
	
	@Column(name="superannuation_date")                  
	public Date superannuation_date;
	
	@Column(name="gender")                  
	public String gender;
	
	@Column(name="employee_type")                  
	public String employee_type;
	
	@Column(name="nationality")                  
	public String nationality;
	
	@Column(name="community")                  
	public String community;
	
	
	@Column(name="serving_status")                  
	public String serving_status;
     
	@Column(name="billunit")                  
	public String billunit;
     
	
    
     
	@Column(name="au")                  
	public String au;
    
	@Column(name="cadre")                  
	public String cadre;
	
	@Column(name="railway_group")                  
	public String railway_group;
	
	@Column(name="railway_main_unit")                  
	public String railway_main_unit;
	
	@Column(name="railway_unit_name")                  
	public String railway_unit_name;

	
	@Column(name="office_place")
    public String office_place;
     
	@Column(name="department")
    public String department;
     
     
	@Column(name="designation")
    public String designation;
     
     
	
	@Column(name="pay_level")
    public String pay_level;
     
	
	@Column(name="basic_pay")
    public int basic_pay;
     
	
	@Column(name="handicap_type")
    public String handicap_type;
     
	
	
	@Column(name="cug_no")
    public String cug_no;
	
	
	
     
	@Column(name="permanent_address")
    public String permanent_address;
     
	@Column(name="employee_name")
    public String employee_name;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="insert_date")
    public Date insert_date;
	
	

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="txn_timestamp")
    public Date txn_timestamp;

	public String getHrms_id() {
		return hrms_id;
	}

	public void setHrms_id(String hrms_id) {
		this.hrms_id = hrms_id;
	}

	public String getIpas_id() {
		return ipas_id;
	}

	public void setIpas_id(String ipas_id) {
		this.ipas_id = ipas_id;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_of_appointment() {
		return date_of_appointment;
	}

	public void setDate_of_appointment(Date date_of_appointment) {
		this.date_of_appointment = date_of_appointment;
	}

	public Date getSuperannuation_date() {
		return superannuation_date;
	}

	public void setSuperannuation_date(Date superannuation_date) {
		this.superannuation_date = superannuation_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getServing_status() {
		return serving_status;
	}

	public void setServing_status(String serving_status) {
		this.serving_status = serving_status;
	}

	public String getBillunit() {
		return billunit;
	}

	public void setBillunit(String billunit) {
		this.billunit = billunit;
	}

	public String getAu() {
		return au;
	}

	public void setAu(String au) {
		this.au = au;
	}

	public String getCadre() {
		return cadre;
	}

	public void setCadre(String cadre) {
		this.cadre = cadre;
	}

	public String getRailway_group() {
		return railway_group;
	}

	public void setRailway_group(String railway_group) {
		this.railway_group = railway_group;
	}

	public String getRailway_main_unit() {
		return railway_main_unit;
	}

	public void setRailway_main_unit(String railway_main_unit) {
		this.railway_main_unit = railway_main_unit;
	}

	public String getRailway_unit_name() {
		return railway_unit_name;
	}

	public void setRailway_unit_name(String railway_unit_name) {
		this.railway_unit_name = railway_unit_name;
	}

	public String getOffice_place() {
		return office_place;
	}

	public void setOffice_place(String office_place) {
		this.office_place = office_place;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPay_level() {
		return pay_level;
	}

	public void setPay_level(String pay_level) {
		this.pay_level = pay_level;
	}

	public int getBasic_pay() {
		return basic_pay;
	}

	public void setBasic_pay(int basic_pay) {
		this.basic_pay = basic_pay;
	}

	public String getHandicap_type() {
		return handicap_type;
	}

	public void setHandicap_type(String handicap_type) {
		this.handicap_type = handicap_type;
	}

	public String getCug_no() {
		return cug_no;
	}

	public void setCug_no(String cug_no) {
		this.cug_no = cug_no;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	public Date getTxn_timestamp() {
		return txn_timestamp;
	}

	public void setTxn_timestamp(Date txn_timestamp) {
		this.txn_timestamp = txn_timestamp;
	}

	
     
     
	
	

}
