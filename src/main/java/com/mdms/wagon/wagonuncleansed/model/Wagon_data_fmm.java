package com.mdms.wagon.wagonuncleansed.model;

import java.security.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="wagon_data_fmm", schema = "mdms_wagon")
public class Wagon_data_fmm {
	
	@Id
	private String wagonid;
	
	private String orgtype;
	
	private String owningrly;
	
	private String vehicletype;
	
	private String vehicleno;
	
	private String vehiclenoold;
	
	private String manufacturer;
	
	private String groupname;
	
	private String wagon_status;
	
	private Date wagon_manufacture_date;
	
	private String remarks;
	
	private String wagon_valid_flag;
	
	private String base_depo_station;
	
	private String manufacturer_serial_number;
	
	private float wagon_carrying_capacity;
	
	private String wagon_scheme_name;
	
	private String alloted_by;
	
	private String allotment_letter_number;
	
	private Date allotment_date;
	
	private String roh_repair_station;
	
	private Date roh_date;
	
	private boolean rfid_tag1;
	
	private boolean rfid_tag2;
	
	private String record_status;
	
	private Timestamp insert_date;
	
	private Timestamp txn_timestamp;
	
	private Date poh_date;
	
	private String poh_workshop;
	
	private Date poh_due_date;
	
	private Timestamp update_poh_timestamp;
	
	private float wagon_tare;
	
	private String pvt_owner_code;
	
	private String wagon_usage;
	
	private String lessor_flag;
	
	private String agreement_wagon_pool;
	
	private String update_no_type_owner_flag;
	
	private String inspecting_added_organization;
	
	private String steward_user_id;

	public String getWagonid() {
		return wagonid;
	}

	public void setWagonid(String wagonid) {
		this.wagonid = wagonid;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getOwningrly() {
		return owningrly;
	}

	public void setOwningrly(String owningrly) {
		this.owningrly = owningrly;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getVehiclenoold() {
		return vehiclenoold;
	}

	public void setVehiclenoold(String vehiclenoold) {
		this.vehiclenoold = vehiclenoold;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getWagon_status() {
		return wagon_status;
	}

	public void setWagon_status(String wagon_status) {
		this.wagon_status = wagon_status;
	}



	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getWagon_valid_flag() {
		return wagon_valid_flag;
	}

	public void setWagon_valid_flag(String wagon_valid_flag) {
		this.wagon_valid_flag = wagon_valid_flag;
	}

	public String getBase_depo_station() {
		return base_depo_station;
	}

	public void setBase_depo_station(String base_depo_station) {
		this.base_depo_station = base_depo_station;
	}

	public String getManufacturer_serial_number() {
		return manufacturer_serial_number;
	}

	public void setManufacturer_serial_number(String manufacturer_serial_number) {
		this.manufacturer_serial_number = manufacturer_serial_number;
	}



	public String getWagon_scheme_name() {
		return wagon_scheme_name;
	}

	public void setWagon_scheme_name(String wagon_scheme_name) {
		this.wagon_scheme_name = wagon_scheme_name;
	}

	public String getAlloted_by() {
		return alloted_by;
	}

	public void setAlloted_by(String alloted_by) {
		this.alloted_by = alloted_by;
	}

	public String getAllotment_letter_number() {
		return allotment_letter_number;
	}

	public void setAllotment_letter_number(String allotment_letter_number) {
		this.allotment_letter_number = allotment_letter_number;
	}



	public String getRoh_repair_station() {
		return roh_repair_station;
	}

	public void setRoh_repair_station(String roh_repair_station) {
		this.roh_repair_station = roh_repair_station;
	}

	

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	



	public String getPoh_workshop() {
		return poh_workshop;
	}

	public void setPoh_workshop(String poh_workshop) {
		this.poh_workshop = poh_workshop;
	}



	public Date getWagon_manufacture_date() {
		return wagon_manufacture_date;
	}

	public void setWagon_manufacture_date(Date wagon_manufacture_date) {
		this.wagon_manufacture_date = wagon_manufacture_date;
	}

	public float getWagon_carrying_capacity() {
		return wagon_carrying_capacity;
	}

	public void setWagon_carrying_capacity(float wagon_carrying_capacity) {
		this.wagon_carrying_capacity = wagon_carrying_capacity;
	}

	public Date getAllotment_date() {
		return allotment_date;
	}

	public void setAllotment_date(Date allotment_date) {
		this.allotment_date = allotment_date;
	}

	public Date getRoh_date() {
		return roh_date;
	}

	public void setRoh_date(Date roh_date) {
		this.roh_date = roh_date;
	}

	public boolean isRfid_tag1() {
		return rfid_tag1;
	}

	public void setRfid_tag1(boolean rfid_tag1) {
		this.rfid_tag1 = rfid_tag1;
	}

	public boolean isRfid_tag2() {
		return rfid_tag2;
	}

	public void setRfid_tag2(boolean rfid_tag2) {
		this.rfid_tag2 = rfid_tag2;
	}

	public Timestamp getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}

	public Timestamp getTxn_timestamp() {
		return txn_timestamp;
	}

	public void setTxn_timestamp(Timestamp txn_timestamp) {
		this.txn_timestamp = txn_timestamp;
	}

	public Date getPoh_date() {
		return poh_date;
	}

	public void setPoh_date(Date poh_date) {
		this.poh_date = poh_date;
	}

	public Date getPoh_due_date() {
		return poh_due_date;
	}

	public void setPoh_due_date(Date poh_due_date) {
		this.poh_due_date = poh_due_date;
	}

	public Timestamp getUpdate_poh_timestamp() {
		return update_poh_timestamp;
	}

	public void setUpdate_poh_timestamp(Timestamp update_poh_timestamp) {
		this.update_poh_timestamp = update_poh_timestamp;
	}

	public float getWagon_tare() {
		return wagon_tare;
	}

	public void setWagon_tare(float wagon_tare) {
		this.wagon_tare = wagon_tare;
	}

	public String getPvt_owner_code() {
		return pvt_owner_code;
	}

	public void setPvt_owner_code(String pvt_owner_code) {
		this.pvt_owner_code = pvt_owner_code;
	}

	public String getWagon_usage() {
		return wagon_usage;
	}

	public void setWagon_usage(String wagon_usage) {
		this.wagon_usage = wagon_usage;
	}

	public String getLessor_flag() {
		return lessor_flag;
	}

	public void setLessor_flag(String lessor_flag) {
		this.lessor_flag = lessor_flag;
	}

	public String getAgreement_wagon_pool() {
		return agreement_wagon_pool;
	}

	public void setAgreement_wagon_pool(String agreement_wagon_pool) {
		this.agreement_wagon_pool = agreement_wagon_pool;
	}

	public String getUpdate_no_type_owner_flag() {
		return update_no_type_owner_flag;
	}

	public void setUpdate_no_type_owner_flag(String update_no_type_owner_flag) {
		this.update_no_type_owner_flag = update_no_type_owner_flag;
	}

	public String getInspecting_added_organization() {
		return inspecting_added_organization;
	}

	public void setInspecting_added_organization(String inspecting_added_organization) {
		this.inspecting_added_organization = inspecting_added_organization;
	}

	public String getSteward_user_id() {
		return steward_user_id;
	}

	public void setSteward_user_id(String steward_user_id) {
		this.steward_user_id = steward_user_id;
	}

	

}
