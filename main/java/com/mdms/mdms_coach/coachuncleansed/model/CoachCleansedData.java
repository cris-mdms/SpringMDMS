package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name="coach_cleansed_data", schema="mdms_coach")
public class CoachCleansedData {	
	@Column(name="coach_no")
	private String coach_no;
	
	@Id
	@Column(name="coach_id")
	private Long coach_id;
	
	@Column(name="coach_type")
	private String coach_type;
	
	@Column(name="owning_rly")
	private String owning_rly;
	
	@Column(name="coach_owning_div")
	private String coach_owning_div;
	
	@Column(name="fitness_type")
	private String fitness_type;
	
	@Column(name="brake_type")
	private String brake_type;

	@Column(name="tare_weight")
	private float tare_weight;
	
	@Column(name="max_speed")
	private float max_speed;
	
		@Column(name="coach_age")
	private int coach_age;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="is_biotoilet_fitted")
	private String is_biotoilet_fitted;
	
	@Column(name="built_date")
	private Date built_date;
	

	@Column(name="commissioning_date")
	private Date commissioning_date;
	

	@Column(name="coach_condemnation_date")
	private Date coach_condemnation_date;
	
	@Column(name="maintenance_depot")
	private String maintenance_depot;
	
	@Column(name="no_of_berths")
	private int no_of_berths;
	

	@Column(name="rfid_tag")
	private String rfid_tag;
	

	@Column(name="coach_status")
	private String coach_status;
	
	@Column(name="gauge")
	private String gauge;
	
	@Column(name="coupling_type")
	private String coupling_type;
	
	@Column(name="owning_depot")
	private String owning_depot;
	
	@Column(name="ac_flag")
	private String ac_flag;
	
	
	@Column(name="vehicle_type")
	private String vehicle_type;
	

@Column(name="power_generation_type")
private String power_generation_type;
	
@Column(name="factory_turnout_date")
private Date factory_turnout_date;
	
@Column(name="warranty_date")
private Date warranty_date;


@Column(name="coach_received_date")
private Date coach_received_date;



@Column(name="double_decker_flag")
private Boolean double_decker_flag;
	


@Column(name="coach_capacity")
private int coach_capacity;


@Column(name="coach_vestibule")
private String coach_vestibule;
	
@Column(name="underframe_no")
private String underframe_no;

@Column(name="shell_no")
private String shell_no;

@Column(name="pu_order_id")
private String pu_order_id;

@Column(name="coach_type_description")
private String coach_type_description;


@Column(name="record_status")
private String record_status;

@Column(name="status")
private String status;


@Column(name="user_id")
private String user_id;


@Column(name="txn_date")
private Date txn_date;

@Column(name="remarks")
private String remarks;


@Column(name="coach_category")
private String coach_category;

public String getCoach_no() {
	return coach_no;
}

public void setCoach_no(String coach_no) {
	this.coach_no = coach_no;
}

public Long getCoach_id() {
	return coach_id;
}

public void setCoach_id(Long coach_id) {
	this.coach_id = coach_id;
}

public String getCoach_type() {
	return coach_type;
}

public void setCoach_type(String coach_type) {
	this.coach_type = coach_type;
}

public String getOwning_rly() {
	return owning_rly;
}

public void setOwning_rly(String owning_rly) {
	this.owning_rly = owning_rly;
}

public String getCoach_owning_div() {
	return coach_owning_div;
}

public void setCoach_owning_div(String coach_owning_div) {
	this.coach_owning_div = coach_owning_div;
}

public String getFitness_type() {
	return fitness_type;
}

public void setFitness_type(String fitness_type) {
	this.fitness_type = fitness_type;
}

public String getBrake_type() {
	return brake_type;
}

public void setBrake_type(String brake_type) {
	this.brake_type = brake_type;
}

public float getTare_weight() {
	return tare_weight;
}

public void setTare_weight(float tare_weight) {
	this.tare_weight = tare_weight;
}

public float getMax_speed() {
	return max_speed;
}

public void setMax_speed(float max_speed) {
	this.max_speed = max_speed;
}

public int getCoach_age() {
	return coach_age;
}

public void setCoach_age(int coach_age) {
	this.coach_age = coach_age;
}

public String getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

public String getIs_biotoilet_fitted() {
	return is_biotoilet_fitted;
}

public void setIs_biotoilet_fitted(String is_biotoilet_fitted) {
	this.is_biotoilet_fitted = is_biotoilet_fitted;
}

public Date getBuilt_date() {
	return built_date;
}

public void setBuilt_date(Date built_date) {
	this.built_date = built_date;
}

public Date getCommissioning_date() {
	return commissioning_date;
}

public void setCommissioning_date(Date commissioning_date) {
	this.commissioning_date = commissioning_date;
}

public Date getCoach_condemnation_date() {
	return coach_condemnation_date;
}

public void setCoach_condemnation_date(Date coach_condemnation_date) {
	this.coach_condemnation_date = coach_condemnation_date;
}

public String getMaintenance_depot() {
	return maintenance_depot;
}

public void setMaintenance_depot(String maintenance_depot) {
	this.maintenance_depot = maintenance_depot;
}

public int getNo_of_berths() {
	return no_of_berths;
}

public void setNo_of_berths(int no_of_berths) {
	this.no_of_berths = no_of_berths;
}

public String getRfid_tag() {
	return rfid_tag;
}

public void setRfid_tag(String rfid_tag) {
	this.rfid_tag = rfid_tag;
}

public String getCoach_status() {
	return coach_status;
}

public void setCoach_status(String coach_status) {
	this.coach_status = coach_status;
}

public String getGauge() {
	return gauge;
}

public void setGauge(String gauge) {
	this.gauge = gauge;
}

public String getCoupling_type() {
	return coupling_type;
}

public void setCoupling_type(String coupling_type) {
	this.coupling_type = coupling_type;
}

public String getOwning_depot() {
	return owning_depot;
}

public void setOwning_depot(String owning_depot) {
	this.owning_depot = owning_depot;
}

public String getAc_flag() {
	return ac_flag;
}

public void setAc_flag(String ac_flag) {
	this.ac_flag = ac_flag;
}

public String getVehicle_type() {
	return vehicle_type;
}

public void setVehicle_type(String vehicle_type) {
	this.vehicle_type = vehicle_type;
}

public String getPower_generation_type() {
	return power_generation_type;
}

public void setPower_generation_type(String power_generation_type) {
	this.power_generation_type = power_generation_type;
}

public Date getFactory_turnout_date() {
	return factory_turnout_date;
}

public void setFactory_turnout_date(Date factory_turnout_date) {
	this.factory_turnout_date = factory_turnout_date;
}

public Date getWarranty_date() {
	return warranty_date;
}

public void setWarranty_date(Date warranty_date) {
	this.warranty_date = warranty_date;
}

public Date getCoach_received_date() {
	return coach_received_date;
}

public void setCoach_received_date(Date coach_received_date) {
	this.coach_received_date = coach_received_date;
}

public Boolean getDouble_decker_flag() {
	return double_decker_flag;
}

public void setDouble_decker_flag(Boolean double_decker_flag) {
	this.double_decker_flag = double_decker_flag;
}

public int getCoach_capacity() {
	return coach_capacity;
}

public void setCoach_capacity(int coach_capacity) {
	this.coach_capacity = coach_capacity;
}

public String getCoach_vestibule() {
	return coach_vestibule;
}

public void setCoach_vestibule(String coach_vestibule) {
	this.coach_vestibule = coach_vestibule;
}

public String getUnderframe_no() {
	return underframe_no;
}

public void setUnderframe_no(String underframe_no) {
	this.underframe_no = underframe_no;
}

public String getShell_no() {
	return shell_no;
}

public void setShell_no(String shell_no) {
	this.shell_no = shell_no;
}

public String getPu_order_id() {
	return pu_order_id;
}

public void setPu_order_id(String pu_order_id) {
	this.pu_order_id = pu_order_id;
}

public String getCoach_type_description() {
	return coach_type_description;
}

public void setCoach_type_description(String coach_type_description) {
	this.coach_type_description = coach_type_description;
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

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public Date getTxn_date() {
	return txn_date;
}

public void setTxn_date(Date txn_date) {
	this.txn_date = txn_date;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}

public String getCoach_category() {
	return coach_category;
}

public void setCoach_category(String coach_category) {
	this.coach_category = coach_category;
}





}
