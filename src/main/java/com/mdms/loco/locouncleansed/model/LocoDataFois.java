package com.mdms.loco.locouncleansed.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity()
@Table(name="loco_data_fois", schema="mdms_loco")
public class LocoDataFois {	
	@Id	
	@Column(name="loco_no")                  
	private int loco_No;  
	
	@Column(name="loco_owning_zone_code")                  
	private String loco_Owningzone; 
	
	
	@Column(name="loco_type")                  
	private String loco_Type; 
	
	@Column(name="loco_owning_shed_code")                  
	public String loco_Owningshed; 
	
	@Column(name="loco_permanent_domain")                  
	private String loco_Permanentdomain; 
	
	@Column(name="loco_brake_type")                  
	private String loco_Brake; 
	
	@Column(name="loco_traction_code")                  
	private String loco_Tractioncode; 
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")  
	@Column(name="loco_entry_date")                  
	private Date loco_Entrydt;
	
	@Column(name="loco_commissiong_shed_id")                  
	private String loco_Commissiongshedid;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")  
	@Column(name="loco_doc")                  
	private Date loco_Doc; 
	
	@Column(name="loco_manufacturer")                  
	private String loco_Manufac; 
	
	 @Column(name="is_gps_enabled")                  
	 private Boolean isGPSEnabled; 	 
	
	 
	@Column(name="status")  
	private String uStatus; 
	
	
	public Boolean getIsGPSEnabled() {
		return isGPSEnabled;
	}

	public void setIsGPSEnabled(Boolean isGPSEnabled) {
		this.isGPSEnabled = isGPSEnabled;
	}

	

	public String getuStatus() {
		return uStatus;
	}

	public void setuStatus(String uStatus) {
		this.uStatus = uStatus;
	}

	public int getLoco_No() {
		return loco_No;
	}

	public void setLoco_No(int loco_No) {
		this.loco_No = loco_No;
	}

	public String getLoco_Owningzone() {
		return loco_Owningzone;
	}

	public void setLoco_Owningzone(String loco_Owningzone) {
		this.loco_Owningzone = loco_Owningzone;
	}

	public String getLoco_Type() {
		return loco_Type;
	}

	public void setLoco_Type(String loco_Type) {
		this.loco_Type = loco_Type;
	}

	public String getLoco_Owningshed() {
		return loco_Owningshed;
	}

	public void setLoco_Owningshed(String loco_Owningshed) {
		this.loco_Owningshed = loco_Owningshed;
	}

	public String getLoco_Permanentdomain() {
		return loco_Permanentdomain;
	}

	public void setLoco_Permanentdomain(String loco_Permanentdomain) {
		this.loco_Permanentdomain = loco_Permanentdomain;
	}

	public String getLoco_Brake() {
		return loco_Brake;
	}

	public void setLoco_Brake(String loco_Brake) {
		this.loco_Brake = loco_Brake;
	}

	public String getLoco_Tractioncode() {
		return loco_Tractioncode;
	}

	public void setLoco_Tractioncode(String loco_Tractioncode) {
		this.loco_Tractioncode = loco_Tractioncode;
	}

	public Date getLoco_Entrydt() {
		return loco_Entrydt;
	}

	public void setLoco_Entrydt(Date loco_Entrydt) {
		this.loco_Entrydt = loco_Entrydt;
	}

	public String getLoco_Commissiongshedid() {
		return loco_Commissiongshedid;
	}

	public void setLoco_Commissiongshedid(String loco_Commissiongshedid) {
		this.loco_Commissiongshedid = loco_Commissiongshedid;
	}

	public String getLoco_Manufac() {
		return loco_Manufac;
	}

	public void setLoco_Manufac(String loco_Manufac) {
		this.loco_Manufac = loco_Manufac;
	}

	public Date getLoco_Doc() {
		return loco_Doc;
	}

	public void setLoco_Doc(Date loco_Doc) {
		this.loco_Doc = loco_Doc;
	}

	

}
