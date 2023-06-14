package com.mdms.loco.locouncleansed.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="loco_approved_data", schema = "mdms_loco")
public class LocoApprovedData {	
	@Id
	@Column(name = "loco_no")
	private int elec_locoNo;

	@Column(name = "loco_type")
	private String elec_locoType;

	@Column(name = "loco_manufacturer")
	private String elec_locoManfacturer;

	@Column(name = "loco_control_type")
	private String elec_locoControlType;

	@Column(name = "loco_permanent_domain")
	private String elec_locoPermanentDomain;

	
	@Column(name = "loco_receiving_date")
	private Date elec_locoRcvdDate;

	@Column(name = "loco_commissioning_date")
	private Date elec_locoDateOfCommision;

	@Column(name = "loco_auxilary")
	private String elec_locoAuxiliaryOutput;

	
	@Column(name = "loco_traction_motor_type")
	private String elec_locoTractionMotorType;

	@Column(name = "loco_owning_shed")
	private String elec_locoOwningShed;

	
	@Column(name = "loco_owning_zone")
	private String elec_locoOwningZone;
	
	@Column(name = "loco_owning_division")
	private String elec_locoOwningdivision;

	@Column(name = "loco_cabin_ac")
	private String elec_locoCabac;
		
	
	@Column(name = "loco_boogie_type")
	private String elec_locoBoogieType;
	
	@Column(name = "loco_lease_type")
	private String elec_locoLeaseType;	

	@Column(name = "loco_hotel_load")
	private String elec_locoHotelLoad;

	 @Column(name="is_gps_enabled")                  
	 private String isGPSEnabled; 
	 
	 @Column(name="flag_type")                  
		private String flagType; 

	@Column(name = "loco_brake_type")
	private String elec_locoBrakeType;

	@Column(name = "loco_brake_sub_type")
	private String elec_locoBrakeSubtype;

	@Column(name = "loco_entry_date")
	private Date elec_locoEntryDate;

	@Column(name = "status")
	private String elec_Status;
	
	@Column(name = "remarks")
	private String elec_Remarks;
	
	 @Column(name="record_status")                  
	 private String recordstatus; 
	 
	 @Column(name="user_id")                  
	 private String userid; 
	 
	 @Column(name="loco_flag")                  
	 private String locoflag; 
	 
	 @Column(name="txn_date")                  
	 private Date txndate;
	 
		@Column(name="loco_hauling_power")                  
		private String loco_Hauling_Power; 
		
		@Column(name="loco_axle_load")                  
		private String loco_Axleload; 
				
			
		@Column(name="loco_gauge_type")    
		 private String loco_Gaugetype;
		
		@Column(name="loco_manufacturing_country")                  
		private String loco_MfgCountry;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
		 @Column(name="loco_manufacturing_date")                  
		 private Date loco_Mfg_Dt; 
		
		@Column(name="transfer_loco_status")     
		private String transfer_loco_status;

		public String getTransfer_loco_status() {
			return transfer_loco_status;
		}

		public void setTransfer_loco_status(String transfer_loco_status) {
			this.transfer_loco_status = transfer_loco_status;
		}

		public Date getLoco_Mfg_Dt() {
			return loco_Mfg_Dt;
		}

		public void setLoco_Mfg_Dt(Date loco_Mfg_Dt) {
			this.loco_Mfg_Dt = loco_Mfg_Dt;
		}

		public int getElec_locoNo() {
			return elec_locoNo;
		}

		public void setElec_locoNo(int elec_locoNo) {
			this.elec_locoNo = elec_locoNo;
		}

		public String getElec_locoType() {
			return elec_locoType;
		}

		public void setElec_locoType(String elec_locoType) {
			this.elec_locoType = elec_locoType;
		}

		public String getElec_locoManfacturer() {
			return elec_locoManfacturer;
		}

		public void setElec_locoManfacturer(String elec_locoManfacturer) {
			this.elec_locoManfacturer = elec_locoManfacturer;
		}

		public String getElec_locoControlType() {
			return elec_locoControlType;
		}

		public void setElec_locoControlType(String elec_locoControlType) {
			this.elec_locoControlType = elec_locoControlType;
		}

		public String getElec_locoPermanentDomain() {
			return elec_locoPermanentDomain;
		}

		public void setElec_locoPermanentDomain(String elec_locoPermanentDomain) {
			this.elec_locoPermanentDomain = elec_locoPermanentDomain;
		}

		public Date getElec_locoRcvdDate() {
			return elec_locoRcvdDate;
		}

		public void setElec_locoRcvdDate(Date elec_locoRcvdDate) {
			this.elec_locoRcvdDate = elec_locoRcvdDate;
		}

		public Date getElec_locoDateOfCommision() {
			return elec_locoDateOfCommision;
		}

		public void setElec_locoDateOfCommision(Date elec_locoDateOfCommision) {
			this.elec_locoDateOfCommision = elec_locoDateOfCommision;
		}

		public String getElec_locoAuxiliaryOutput() {
			return elec_locoAuxiliaryOutput;
		}

		public void setElec_locoAuxiliaryOutput(String elec_locoAuxiliaryOutput) {
			this.elec_locoAuxiliaryOutput = elec_locoAuxiliaryOutput;
		}

		public String getElec_locoTractionMotorType() {
			return elec_locoTractionMotorType;
		}

		public void setElec_locoTractionMotorType(String elec_locoTractionMotorType) {
			this.elec_locoTractionMotorType = elec_locoTractionMotorType;
		}

		public String getElec_locoOwningShed() {
			return elec_locoOwningShed;
		}

		public void setElec_locoOwningShed(String elec_locoOwningShed) {
			this.elec_locoOwningShed = elec_locoOwningShed;
		}

		public String getElec_locoOwningZone() {
			return elec_locoOwningZone;
		}

		public void setElec_locoOwningZone(String elec_locoOwningZone) {
			this.elec_locoOwningZone = elec_locoOwningZone;
		}

		public String getElec_locoCabac() {
			return elec_locoCabac;
		}

		public void setElec_locoCabac(String elec_locoCabac) {
			this.elec_locoCabac = elec_locoCabac;
		}

		public String getElec_locoBoogieType() {
			return elec_locoBoogieType;
		}

		public void setElec_locoBoogieType(String elec_locoBoogieType) {
			this.elec_locoBoogieType = elec_locoBoogieType;
		}

		public String getElec_locoLeaseType() {
			return elec_locoLeaseType;
		}

		public void setElec_locoLeaseType(String elec_locoLeaseType) {
			this.elec_locoLeaseType = elec_locoLeaseType;
		}

		public String getElec_locoHotelLoad() {
			return elec_locoHotelLoad;
		}

		public void setElec_locoHotelLoad(String elec_locoHotelLoad) {
			this.elec_locoHotelLoad = elec_locoHotelLoad;
		}

		public String getIsGPSEnabled() {
			return isGPSEnabled;
		}

		public void setIsGPSEnabled(String isGPSEnabled) {
			this.isGPSEnabled = isGPSEnabled;
		}

		public String getFlagType() {
			return flagType;
		}

		public void setFlagType(String flagType) {
			this.flagType = flagType;
		}

		public String getElec_locoBrakeType() {
			return elec_locoBrakeType;
		}

		public void setElec_locoBrakeType(String elec_locoBrakeType) {
			this.elec_locoBrakeType = elec_locoBrakeType;
		}

		public String getElec_locoBrakeSubtype() {
			return elec_locoBrakeSubtype;
		}

		public void setElec_locoBrakeSubtype(String elec_locoBrakeSubtype) {
			this.elec_locoBrakeSubtype = elec_locoBrakeSubtype;
		}

		public Date getElec_locoEntryDate() {
			return elec_locoEntryDate;
		}

		public void setElec_locoEntryDate(Date elec_locoEntryDate) {
			this.elec_locoEntryDate = elec_locoEntryDate;
		}

		public String getElec_Status() {
			return elec_Status;
		}

		public void setElec_Status(String elec_Status) {
			this.elec_Status = elec_Status;
		}

		public String getElec_Remarks() {
			return elec_Remarks;
		}

		public void setElec_Remarks(String elec_Remarks) {
			this.elec_Remarks = elec_Remarks;
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

		public String getLoco_MfgCountry() {
			return loco_MfgCountry;
		}

		public void setLoco_MfgCountry(String loco_MfgCountry) {
			this.loco_MfgCountry = loco_MfgCountry;
		}

		public String getElec_locoOwningdivision() {
			return elec_locoOwningdivision;
		}

		public void setElec_locoOwningdivision(String elec_locoOwningdivision) {
			this.elec_locoOwningdivision = elec_locoOwningdivision;
		} 
		


}
