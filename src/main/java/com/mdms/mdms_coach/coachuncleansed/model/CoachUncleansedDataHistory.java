/* Model class – CMM Coach Type Table
Developer – Anshul ,09/07/2020
*/

package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="coach_uncleansed_data_history", schema="mdms_coach")
public class CoachUncleansedDataHistory {
	
	@Column(name="coach_no")
	private String coachNo;
	
	@Id
	@Column(name="coach_id")
	private Long coachId;
	
	@Column(name="coach_type")
	private String coachType;
	
	@Column(name="owning_rly")
	private String owningRly;
	
	@Column(name="coach_owning_div")
	private String coachOwningDiv;
	
	@Column(name="fitness_type")
	private String fitnessType;
	
	@Column(name="brake_type")
	private String brakeType;

	@Column(name="tare_weight")
	private float tareweight;
	
	@Column(name="max_speed")
	private float maximumspeed;
	
	@Column(name="coach_age")
	private int coachage;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="is_biotoilet_fitted")
	private String isBiotoiletFitted;
	
	@Column(name="built_date")
	private Date builtDate;
	

	@Column(name="commissioning_date")
	private Date coachCommissionDate;
	

	@Column(name="coach_condemnation_date")
	private Date condemnationDate;
	
	@Column(name="maintenance_depot")
	private String maintenanceDepot;
	
	@Column(name="no_of_berths")
	private int noOfBerths;
	

	@Column(name="rfid_tag")
	private String rfidTag;
	

	@Column(name="coach_status")
	private String coachStatus;
	
	@Column(name="gauge")
	private String gauge;
	
	@Column(name="coupling_type")
	private String couplingType;
	
	@Column(name="owning_depot")
	private String owningDepot;
	
	
	
	@Column(name="ac_flag")
	private String acFlag;
	
	
	@Column(name="vehicle_type")
	private String vehicleType;
	

@Column(name="power_generation_type")
private String powerGenerationType;
	
@Column(name="factoryTurnoutDate")
private Date factoryTurnoutDate;
	
@Column(name="warrantyDate")
private Date warrantyDate;


@Column(name="coach_received_date")
private Date coachReceivedDate;



@Column(name="double_decker_flag")
private Boolean doubleDeckerFlag;
	


@Column(name="coach_capacity")
private String coachCapacity;


@Column(name="coach_vestibule")
private String coachVestibule;
	
@Column(name="underframe_no")
private String underFrameNo;

@Column(name="shell_no")
private String shellNo;

@Column(name="pu_order_id")
private String puOrderId;

@Column(name="coach_type_description")
private String coachTypeDescription;


@Column(name="record_status")
private String record_status;

@Column(name="status")
private String status;


@Column(name="user_id")
private String userId;


@Column(name="txn_date")
private Date txnDate;


@Column(name="updated_date")
private Date updatedDate;


@Column(name="coach_category")
private String coach_category;


public String getCoachNo() {
	return coachNo;
}


public void setCoachNo(String coachNo) {
	this.coachNo = coachNo;
}


public Long getCoachId() {
	return coachId;
}


public void setCoachId(Long coachId) {
	this.coachId = coachId;
}


public String getCoachType() {
	return coachType;
}


public void setCoachType(String coachType) {
	this.coachType = coachType;
}


public String getOwningRly() {
	return owningRly;
}


public void setOwningRly(String owningRly) {
	this.owningRly = owningRly;
}


public String getCoachOwningDiv() {
	return coachOwningDiv;
}


public void setCoachOwningDiv(String coachOwningDiv) {
	this.coachOwningDiv = coachOwningDiv;
}


public String getFitnessType() {
	return fitnessType;
}


public void setFitnessType(String fitnessType) {
	this.fitnessType = fitnessType;
}


public String getBrakeType() {
	return brakeType;
}


public void setBrakeType(String brakeType) {
	this.brakeType = brakeType;
}


public float getTareweight() {
	return tareweight;
}


public void setTareweight(float tareweight) {
	this.tareweight = tareweight;
}


public float getMaximumspeed() {
	return maximumspeed;
}


public void setMaximumspeed(float maximumspeed) {
	this.maximumspeed = maximumspeed;
}


public int getCoachage() {
	return coachage;
}


public void setCoachage(int coachage) {
	this.coachage = coachage;
}


public String getManufacturer() {
	return manufacturer;
}


public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}


public String getIsBiotoiletFitted() {
	return isBiotoiletFitted;
}


public void setIsBiotoiletFitted(String isBiotoiletFitted) {
	this.isBiotoiletFitted = isBiotoiletFitted;
}


public Date getBuiltDate() {
	return builtDate;
}


public void setBuiltDate(Date builtDate) {
	this.builtDate = builtDate;
}


public Date getCoachCommissionDate() {
	return coachCommissionDate;
}


public void setCoachCommissionDate(Date coachCommissionDate) {
	this.coachCommissionDate = coachCommissionDate;
}


public Date getCondemnationDate() {
	return condemnationDate;
}


public void setCondemnationDate(Date condemnationDate) {
	this.condemnationDate = condemnationDate;
}


public String getMaintenanceDepot() {
	return maintenanceDepot;
}


public void setMaintenanceDepot(String maintenanceDepot) {
	this.maintenanceDepot = maintenanceDepot;
}


public int getNoOfBerths() {
	return noOfBerths;
}


public void setNoOfBerths(int noOfBerths) {
	this.noOfBerths = noOfBerths;
}


public String getRfidTag() {
	return rfidTag;
}


public void setRfidTag(String rfidTag) {
	this.rfidTag = rfidTag;
}


public String getCoachStatus() {
	return coachStatus;
}


public void setCoachStatus(String coachStatus) {
	this.coachStatus = coachStatus;
}


public String getGauge() {
	return gauge;
}


public void setGauge(String gauge) {
	this.gauge = gauge;
}


public String getCouplingType() {
	return couplingType;
}


public void setCouplingType(String couplingType) {
	this.couplingType = couplingType;
}


public String getOwningDepot() {
	return owningDepot;
}


public void setOwningDepot(String owningDepot) {
	this.owningDepot = owningDepot;
}


public String getAcFlag() {
	return acFlag;
}


public void setAcFlag(String acFlag) {
	this.acFlag = acFlag;
}


public String getVehicleType() {
	return vehicleType;
}


public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}


public String getPowerGenerationType() {
	return powerGenerationType;
}


public void setPowerGenerationType(String powerGenerationType) {
	this.powerGenerationType = powerGenerationType;
}


public Date getFactoryTurnoutDate() {
	return factoryTurnoutDate;
}


public void setFactoryTurnoutDate(Date factoryTurnoutDate) {
	this.factoryTurnoutDate = factoryTurnoutDate;
}


public Date getWarrantyDate() {
	return warrantyDate;
}


public void setWarrantyDate(Date warrantyDate) {
	this.warrantyDate = warrantyDate;
}


public Date getCoachReceivedDate() {
	return coachReceivedDate;
}


public void setCoachReceivedDate(Date coachReceivedDate) {
	this.coachReceivedDate = coachReceivedDate;
}


public Boolean getDoubleDeckerFlag() {
	return doubleDeckerFlag;
}


public void setDoubleDeckerFlag(Boolean doubleDeckerFlag) {
	this.doubleDeckerFlag = doubleDeckerFlag;
}


public String getCoachCapacity() {
	return coachCapacity;
}


public void setCoachCapacity(String coachCapacity) {
	this.coachCapacity = coachCapacity;
}


public String getCoachVestibule() {
	return coachVestibule;
}


public void setCoachVestibule(String coachVestibule) {
	this.coachVestibule = coachVestibule;
}


public String getUnderFrameNo() {
	return underFrameNo;
}


public void setUnderFrameNo(String underFrameNo) {
	this.underFrameNo = underFrameNo;
}


public String getShellNo() {
	return shellNo;
}


public void setShellNo(String shellNo) {
	this.shellNo = shellNo;
}


public String getPuOrderId() {
	return puOrderId;
}


public void setPuOrderId(String puOrderId) {
	this.puOrderId = puOrderId;
}


public String getCoachTypeDescription() {
	return coachTypeDescription;
}


public void setCoachTypeDescription(String coachTypeDescription) {
	this.coachTypeDescription = coachTypeDescription;
}


public String getRecord_status() {
	return record_status;
}


public void setRecord_status(String record_status) {
	this.record_status = record_status;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}


public Date getTxnDate() {
	return txnDate;
}


public void setTxnDate(Date txnDate) {
	this.txnDate = txnDate;
}


public Date getUpdatedDate() {
	return updatedDate;
}


public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}



public String getCoach_category() {
	return coach_category;
}


public void setCoach_category(String coach_category) {
	this.coach_category = coach_category;
}


	
}
