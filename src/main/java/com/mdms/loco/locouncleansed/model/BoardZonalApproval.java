package com.mdms.loco.locouncleansed.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity()
@Table(name="loco_uncleansed_data", schema="mdms_loco")
public class BoardZonalApproval {
	@Id
	@Column(name = "loco_no")
	private int loco_no;

	@Column(name = "loco_permanent_domain")
	private String loco_permanent_domain;

	@Column(name = "loco_type")
	private String loco_type;

	@Column(name = "loco_owning_zone")
	private String loco_owning_zone;

	@Column(name = "loco_owning_division")	
	private String loco_owning_division;


	@Column(name = "loco_manufacturing_date")
	private Date loco_manufacturing_date;

	@Column(name = "loco_owning_shed")
	private String loco_owning_shed;

	

	@Column(name = "loco_initial_cost")
	private Long loco_initial_cost;

	@Column(name = "loco_poh_cost")
	private Long loco_poh_cost;

	@Column(name = "loco_lease_type")
	private String loco_lease_type;

	@Column(name = "loco_traction_code")
	private String loco_traction_code;

	@Column(name = "loco_gauge_type")
	private String gauge_type;

	@Column(name = "loco_hauling_power")
	private Long loco_hauling_power;

	@Column(name = "loco_manufacturing_country")
	private String loco_manufacturing_country;

	@Column(name = "loco_commissioning_date")
	private Date loco_commissioning_date;

	@Column(name = "loco_commissioned_shed_id")
	private String loco_commissioning_shed_id;

	@Column(name = "loco_axle_load")
	private String loco_axle_load;

	@Column(name = "loco_axle_load_unit")
	private String loco_axle_load_unit;

	@Column(name = "loco_traction_motor_type")
	private String loco_traction_motor_type;

	@Column(name = "loco_boogie_type")
	private String loco_boogie_type;

	@Column(name = "loco_control_type")
	private String loco_control_type;

	@Column(name = "is_gps_enabled")
	private String is_gps_enabled;

	 @Column(name="flag_type")                  
		private String flag_type;
	
	 
	
	@Column(name = "loco_entry_date")
	private Date loco_entry_date;

	@Column(name = "loco_manufacturer")
	private String loco_manufacturer;

	 @Column(name="loco_flag")                  
	 private String loco_flag; 
	 

	 @Column(name="txn_date")                  
	 private Date txn_date;
	 
	 
	 @Column(name="status")                  
	 private String status; 
	
	 @Column(name="remarks")                  
	 private String remarks; 
	
	 @Column(name="record_status")                  
	 private String record_status; 
	 
	 @Column(name="user_id")                  
	 private String user_id;

	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	 @Column(name="loco_receiving_date")                  
		private Date loco_receiving_date;

	public int getLoco_no() {
		return loco_no;
	}

	public void setLoco_no(int loco_no) {
		this.loco_no = loco_no;
	}

	public String getLoco_permanent_domain() {
		return loco_permanent_domain;
	}

	public void setLoco_permanent_domain(String loco_permanent_domain) {
		this.loco_permanent_domain = loco_permanent_domain;
	}

	public String getLoco_type() {
		return loco_type;
	}

	public void setLoco_type(String loco_type) {
		this.loco_type = loco_type;
	}

	public String getLoco_owning_zone() {
		return loco_owning_zone;
	}

	public void setLoco_owning_zone(String loco_owning_zone) {
		this.loco_owning_zone = loco_owning_zone;
	}

	public String getLoco_owning_division() {
		return loco_owning_division;
	}

	public void setLoco_owning_division(String loco_owning_division) {
		this.loco_owning_division = loco_owning_division;
	}

	public Date getLoco_manufacturing_date() {
		return loco_manufacturing_date;
	}

	public void setLoco_manufacturing_date(Date loco_manufacturing_date) {
		this.loco_manufacturing_date = loco_manufacturing_date;
	}

	public String getLoco_owning_shed() {
		return loco_owning_shed;
	}

	public void setLoco_owning_shed(String loco_owning_shed) {
		this.loco_owning_shed = loco_owning_shed;
	}

	public Long getLoco_initial_cost() {
		return loco_initial_cost;
	}

	public void setLoco_initial_cost(Long loco_initial_cost) {
		this.loco_initial_cost = loco_initial_cost;
	}

	public Long getLoco_poh_cost() {
		return loco_poh_cost;
	}

	public void setLoco_poh_cost(Long loco_poh_cost) {
		this.loco_poh_cost = loco_poh_cost;
	}

	public String getLoco_lease_type() {
		return loco_lease_type;
	}

	public void setLoco_lease_type(String loco_lease_type) {
		this.loco_lease_type = loco_lease_type;
	}

	public String getLoco_traction_code() {
		return loco_traction_code;
	}

	public void setLoco_traction_code(String loco_traction_code) {
		this.loco_traction_code = loco_traction_code;
	}


	public String getGauge_type() {
		return gauge_type;
	}

	public void setGauge_type(String gauge_type) {
		this.gauge_type = gauge_type;
	}

	public Long getLoco_hauling_power() {
		return loco_hauling_power;
	}

	public void setLoco_hauling_power(Long loco_hauling_power) {
		this.loco_hauling_power = loco_hauling_power;
	}

	public String getLoco_manufacturing_country() {
		return loco_manufacturing_country;
	}

	public void setLoco_manufacturing_country(String loco_manufacturing_country) {
		this.loco_manufacturing_country = loco_manufacturing_country;
	}

	public Date getLoco_commissioning_date() {
		return loco_commissioning_date;
	}

	public void setLoco_commissioning_date(Date loco_commissioning_date) {
		this.loco_commissioning_date = loco_commissioning_date;
	}

	public String getLoco_commissioning_shed_id() {
		return loco_commissioning_shed_id;
	}

	public void setLoco_commissioning_shed_id(String loco_commissioning_shed_id) {
		this.loco_commissioning_shed_id = loco_commissioning_shed_id;
	}

	public String getLoco_axle_load() {
		return loco_axle_load;
	}

	public void setLoco_axle_load(String loco_axle_load) {
		this.loco_axle_load = loco_axle_load;
	}

	public String getLoco_axle_load_unit() {
		return loco_axle_load_unit;
	}

	public void setLoco_axle_load_unit(String loco_axle_load_unit) {
		this.loco_axle_load_unit = loco_axle_load_unit;
	}

	public String getLoco_traction_motor_type() {
		return loco_traction_motor_type;
	}

	public void setLoco_traction_motor_type(String loco_traction_motor_type) {
		this.loco_traction_motor_type = loco_traction_motor_type;
	}

	public String getLoco_boogie_type() {
		return loco_boogie_type;
	}

	public void setLoco_boogie_type(String loco_boogie_type) {
		this.loco_boogie_type = loco_boogie_type;
	}

	public String getLoco_control_type() {
		return loco_control_type;
	}

	public void setLoco_control_type(String loco_control_type) {
		this.loco_control_type = loco_control_type;
	}

	public String getIs_gps_enabled() {
		return is_gps_enabled;
	}

	public void setIs_gps_enabled(String is_gps_enabled) {
		this.is_gps_enabled = is_gps_enabled;
	}

	public String getFlag_type() {
		return flag_type;
	}

	public void setFlag_type(String flag_type) {
		this.flag_type = flag_type;
	}

	public Date getLoco_entry_date() {
		return loco_entry_date;
	}

	public void setLoco_entry_date(Date loco_entry_date) {
		this.loco_entry_date = loco_entry_date;
	}

	public String getLoco_manufacturer() {
		return loco_manufacturer;
	}

	public void setLoco_manufacturer(String loco_manufacturer) {
		this.loco_manufacturer = loco_manufacturer;
	}

	public String getLoco_flag() {
		return loco_flag;
	}

	public void setLoco_flag(String loco_flag) {
		this.loco_flag = loco_flag;
	}

	public Date getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getLoco_receiving_date() {
		return loco_receiving_date;
	}

	public void setLoco_receiving_date(Date loco_receiving_date) {
		this.loco_receiving_date = loco_receiving_date;
	}

	
	
	 
}
