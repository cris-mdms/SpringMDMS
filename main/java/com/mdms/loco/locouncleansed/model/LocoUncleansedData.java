package com.mdms.loco.locouncleansed.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity()
@Table(name="loco_uncleansed_data", schema="mdms_loco")
public class LocoUncleansedData {
	@Id
	@Column(name="loco_no")                  
	private int loco_No; 	

	@Column(name="loco_owning_zone")                  
	private String loco_Owningzone; 
			
	@Column(name="loco_type")                  
	private String loco_Type; 
			
	@Column(name="loco_owning_shed")                  
	private String loco_Owningshed; 	
			   
	@Column(name="loco_permanent_domain")                  
	private String loco_Permanentdomain; 
	
	@Column(name="loco_brake_type")                  
	private String loco_Brake; 
	
	@Column(name = "loco_brake_sub_type")
	private String locoBrakeSubtype;
	
	public String getLocoBrakeSubtype() {
		return locoBrakeSubtype;
	}

	public void setLocoBrakeSubtype(String locoBrakeSubtype) {
		this.locoBrakeSubtype = locoBrakeSubtype;
	}

	@Column(name="loco_traction_code")                  
	private String loco_Tractioncode; 
	
	
	@Column(name="loco_entry_date")                  
	private Date loco_Entrydt;
			
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	@Column(name="loco_commissioning_date")                  
	private Date loco_Doc; 
	
	@Column(name="loco_manufacturer")                  
	private String loco_Manufac; 
			
	@Column(name="loco_manufacturing_country")                  
	private String loco_MfgCountry; 
	
	@Column(name="loco_hauling_power")                  
	private String loco_Hauling_Power; 
	
	@Column(name="loco_axle_load")                  
	private String loco_Axleload; 
			
		
	@Column(name="loco_gauge_type")                  
	 private String loco_Gaugetype;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	 @Column(name="loco_receiving_date")                  
	 private Date loco_Recd_Dt; 
	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	 @Column(name="loco_manufacturing_date")                  
	 private Date loco_Mfg_Dt; 
	 
	 @Column(name="loco_control_type")                  
	 private String loco_Control_Type;
	
	@Column(name="loco_traction_motor_type")                  
	private String loco_Traction_Motor_Type;
	 
	 @Column(name="remarks")                  
	 private String dRemarks; 
	 
	 @Column(name="is_gps_enabled")                  
	 private String isGPSEnabledDiesel; 

	 @Column(name="flag_type")                  
		private String flagTypeDiesel; 
	
	 @Column(name="status")                  
	 private String vStatus; 
	 
	 @Column(name="loco_lease_type")                  
	 private String loco_lease_type;       
	 
	 @Column(name="record_status")                  
	 private String recordstatus; 
	 
	 @Column(name="user_id")                  
	 private String userid; 
	 
	 @Column(name="loco_flag")                  
	 private String locoflag; 
	 
	 @Column(name="txn_date")                  
	 private Date txndate;
	 
	 private String loco_owning_division;
	 

	public String getLoco_owning_division() {
		return loco_owning_division;
	}

	public void setLoco_owning_division(String loco_owning_division) {
		this.loco_owning_division = loco_owning_division;
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

	public Date getLoco_Doc() {
		return loco_Doc;
	}

	public void setLoco_Doc(Date loco_Doc) {
		this.loco_Doc = loco_Doc;
	}

	public String getLoco_Manufac() {
		return loco_Manufac;
	}

	public void setLoco_Manufac(String loco_Manufac) {
		this.loco_Manufac = loco_Manufac;
	}

	public String getLoco_MfgCountry() {
		return loco_MfgCountry;
	}

	public void setLoco_MfgCountry(String loco_MfgCountry) {
		this.loco_MfgCountry = loco_MfgCountry;
	}

	public String getLoco_Hauling_Power() {
		return loco_Hauling_Power;
	}

	public void setLoco_Hauling_Power(String loco_Hauling_Power) {
		this.loco_Hauling_Power = loco_Hauling_Power;
	}

	public String getLoco_Axleload() {
		return loco_Axleload;
	}

	public void setLoco_Axleload(String loco_Axleload) {
		this.loco_Axleload = loco_Axleload;
	}

	public String getLoco_Gaugetype() {
		return loco_Gaugetype;
	}

	public void setLoco_Gaugetype(String loco_Gaugetype) {
		this.loco_Gaugetype = loco_Gaugetype;
	}

	public Date getLoco_Recd_Dt() {
		return loco_Recd_Dt;
	}

	public void setLoco_Recd_Dt(Date loco_Recd_Dt) {
		this.loco_Recd_Dt = loco_Recd_Dt;
	}

	public Date getLoco_Mfg_Dt() {
		return loco_Mfg_Dt;
	}

	public void setLoco_Mfg_Dt(Date loco_Mfg_Dt) {
		this.loco_Mfg_Dt = loco_Mfg_Dt;
	}

	public String getLoco_Control_Type() {
		return loco_Control_Type;
	}

	public void setLoco_Control_Type(String loco_Control_Type) {
		this.loco_Control_Type = loco_Control_Type;
	}

	public String getLoco_Traction_Motor_Type() {
		return loco_Traction_Motor_Type;
	}

	public void setLoco_Traction_Motor_Type(String loco_Traction_Motor_Type) {
		this.loco_Traction_Motor_Type = loco_Traction_Motor_Type;
	}

	public String getdRemarks() {
		return dRemarks;
	}

	public void setdRemarks(String dRemarks) {
		this.dRemarks = dRemarks;
	}


	public String getIsGPSEnabledDiesel() {
		return isGPSEnabledDiesel;
	}

	public void setIsGPSEnabledDiesel(String isGPSEnabledDiesel) {

		this.isGPSEnabledDiesel = isGPSEnabledDiesel;
	}

	public String getFlagTypeDiesel() {
		return flagTypeDiesel;
	}

	public void setFlagTypeDiesel(String flagTypeDiesel) {
		this.flagTypeDiesel = flagTypeDiesel;
	}

	public String getvStatus() {
		return vStatus;
	}

	public void setvStatus(String vStatus) {
		this.vStatus = vStatus;
	}

	public String getLoco_lease_type() {
		return loco_lease_type;
	}

	public void setLoco_lease_type(String loco_lease_type) {
		this.loco_lease_type = loco_lease_type;
	}

	public String getRecordstatus() {
		return recordstatus;
	}

	public void setRecordstatus(String recordstatus) {
		this.recordstatus = recordstatus;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLocoflag() {
		return locoflag;
	}

	public void setLocoflag(String locoflag) {
		this.locoflag = locoflag;
	}

	public Date getTxndate() {
		return txndate;
	}

	public void setTxndate(Date txndate) {
		this.txndate = txndate;
	} 
	 
	

}
