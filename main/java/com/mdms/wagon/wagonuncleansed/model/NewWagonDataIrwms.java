package com.mdms.wagon.wagonuncleansed.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="wagon_data_irwms", schema="mdms_wagon")
public class NewWagonDataIrwms {
	@Id
	@Column(name="wagonid")
	private BigInteger wagonid;
	
	@Column(name="orgtype")
	private String orgtype;
	
	@Column(name="owningrly")
	private String owningrly;
	
	@Column(name="vehicletype")
	private String vehicletype;
	@Column(name="pohid")
	private Long pohid;
	@Column(name="chkdigit")
	private String chkdigit;
	@Column(name="vehiclenoold")
	private Long vehiclenoold;
	@Column(name="vehicleno")
	private Long vehicleno;
	@Column(name="manufacturingcode")
	private Long manufacturingcode;
	@Column(name="groupname")
	private String groupname;
	@Column(name="status")
	private String status;
	@Column(name="wagon_status")
	private String wagon_status;
	@Column(name="datestamp")
	private String datestamp;
	@Column(name="wagon_manufacture_date")
	private String wagon_manufacture_date;
	@Column(name="wagon_manufacture_year")
	private String wagon_manufacture_year;
	@Column(name="wagon_co_owner")
	private String wagon_co_owner;
	@Column(name="remarks")
	private String remarks;
	@Column(name="wagon_valid_flag")
	private String wagon_valid_flag;
	@Column(name="base_depo_station")
	private String base_depo_station;
	@Column(name="stock_type_code")
	private String stock_type_code;
	@Column(name="serial_number")
	private String serial_number;
	@Column(name="manufacturing_country")
	private String manufacturing_country;
	@Column(name="wagon_gauge_code")
	private String wagon_gauge_code;
	@Column(name="wagon_rfid1")
	private Boolean wagon_rfid1;
	@Column(name="wagon_rfid2")
	private Boolean wagon_rfid2;
	@Column(name="wagon_tare")
	private Double wagon_tare;
	@Column(name="wagon_carrying_capacity")
	private Double wagon_carrying_capacity;
	@Column(name="wagon_scheme_name")
	private String wagon_scheme_name;
	
	@Column(name="insert_date")
	private Date insert_date;
	
	
	@Column(name="update_date")
	private Date update_date;
	
	@Column(name="alloted_by")
	private String alloted_by;
	
	
	@Column(name="allotment_date")
	private Date allotment_date;
	
	@Column(name="roh_station")
	private String roh_station;
	
	@Column(name="roh_date")
	private Date roh_date;
	
	
	@Column(name="poh_date")
	private Date poh_date;
	
	@Column(name="poh_workshop")
	private String poh_workshop;
	
	@Column(name="poh_due_date")
	private Date poh_due_date;
	
	@Column(name="update_poh_timestamp")
	private Date update_poh_timestamp;
	
	@Column(name="update_roh_timestamp")
	private Date update_roh_timestamp;

	

//	public NewWagonDataIrwms(BigInteger wagonid, String orgtype, String owningrly, String vehicletype, Long pohid,
//			String chkdigit, Long vehiclenoold, Long vehicleno, Long manufacturingcode, String groupname, String status,
//			String wagon_status, String datestamp, String wagon_manufacture_date, String wagon_manufacture_year,
//			String wagon_co_owner, String remarks, String wagon_valid_flag, String base_depo_station,
//			String stock_type_code, String serial_number, String manufacturing_country, String wagon_gauge_code,
//			Boolean wagon_rfid1, Boolean wagon_rfid2, Double wagon_tare, Double wagon_carrying_capacity,
//			String wagon_scheme_name, Date insert_date, Date update_date, String alloted_by, Date allotment_date,
//			String roh_station, Date roh_date, Date poh_date, String poh_workshop, Date poh_due_date,
//			Date update_poh_timestamp, Date update_roh_timestamp) {
//		super();
//		this.wagonid = wagonid;
//		this.orgtype = orgtype;
//		this.owningrly = owningrly;
//		this.vehicletype = vehicletype;
//		this.pohid = pohid;
//		this.chkdigit = chkdigit;
//		this.vehiclenoold = vehiclenoold;
//		this.vehicleno = vehicleno;
//		this.manufacturingcode = manufacturingcode;
//		this.groupname = groupname;
//		this.status = status;
//		this.wagon_status = wagon_status;
//		this.datestamp = datestamp;
//		this.wagon_manufacture_date = wagon_manufacture_date;
//		this.wagon_manufacture_year = wagon_manufacture_year;
//		this.wagon_co_owner = wagon_co_owner;
//		this.remarks = remarks;
//		this.wagon_valid_flag = wagon_valid_flag;
//		this.base_depo_station = base_depo_station;
//		this.stock_type_code = stock_type_code;
//		this.serial_number = serial_number;
//		this.manufacturing_country = manufacturing_country;
//		this.wagon_gauge_code = wagon_gauge_code;
//		this.wagon_rfid1 = wagon_rfid1;
//		this.wagon_rfid2 = wagon_rfid2;
//		this.wagon_tare = wagon_tare;
//		this.wagon_carrying_capacity = wagon_carrying_capacity;
//		this.wagon_scheme_name = wagon_scheme_name;
//		this.insert_date = insert_date;
//		this.update_date = update_date;
//		this.alloted_by = alloted_by;
//		this.allotment_date = allotment_date;
//		this.roh_station = roh_station;
//		this.roh_date = roh_date;
//		this.poh_date = poh_date;
//		this.poh_workshop = poh_workshop;
//		this.poh_due_date = poh_due_date;
//		this.update_poh_timestamp = update_poh_timestamp;
//		this.update_roh_timestamp = update_roh_timestamp;
//	}

	public BigInteger getWagonid() {
		return wagonid;
	}

	public void setWagonid(BigInteger wagonid) {
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

	public Long getPohid() {
		return pohid;
	}

	public void setPohid(Long pohid) {
		this.pohid = pohid;
	}

	public String getChkdigit() {
		return chkdigit;
	}

	public void setChkdigit(String chkdigit) {
		this.chkdigit = chkdigit;
	}

	public Long getVehiclenoold() {
		return vehiclenoold;
	}

	public void setVehiclenoold(Long vehiclenoold) {
		this.vehiclenoold = vehiclenoold;
	}

	public Long getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(Long vehicleno) {
		this.vehicleno = vehicleno;
	}

	public Long getManufacturingcode() {
		return manufacturingcode;
	}

	public void setManufacturingcode(Long manufacturingcode) {
		this.manufacturingcode = manufacturingcode;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWagon_status() {
		return wagon_status;
	}

	public void setWagon_status(String wagon_status) {
		this.wagon_status = wagon_status;
	}

	public String getDatestamp() {
		return datestamp;
	}

	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}

	public String getWagon_manufacture_date() {
		return wagon_manufacture_date;
	}

	public void setWagon_manufacture_date(String wagon_manufacture_date) {
		this.wagon_manufacture_date = wagon_manufacture_date;
	}

	public String getWagon_manufacture_year() {
		return wagon_manufacture_year;
	}

	public void setWagon_manufacture_year(String wagon_manufacture_year) {
		this.wagon_manufacture_year = wagon_manufacture_year;
	}

	public String getWagon_co_owner() {
		return wagon_co_owner;
	}

	public void setWagon_co_owner(String wagon_co_owner) {
		this.wagon_co_owner = wagon_co_owner;
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

	public String getStock_type_code() {
		return stock_type_code;
	}

	public void setStock_type_code(String stock_type_code) {
		this.stock_type_code = stock_type_code;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getManufacturing_country() {
		return manufacturing_country;
	}

	public void setManufacturing_country(String manufacturing_country) {
		this.manufacturing_country = manufacturing_country;
	}

	public String getWagon_gauge_code() {
		return wagon_gauge_code;
	}

	public void setWagon_gauge_code(String wagon_gauge_code) {
		this.wagon_gauge_code = wagon_gauge_code;
	}

	public Boolean getWagon_rfid1() {
		return wagon_rfid1;
	}

	public void setWagon_rfid1(Boolean wagon_rfid1) {
		this.wagon_rfid1 = wagon_rfid1;
	}

	public Boolean getWagon_rfid2() {
		return wagon_rfid2;
	}

	public void setWagon_rfid2(Boolean wagon_rfid2) {
		this.wagon_rfid2 = wagon_rfid2;
	}

	public Double getWagon_tare() {
		return wagon_tare;
	}

	public void setWagon_tare(Double wagon_tare) {
		this.wagon_tare = wagon_tare;
	}

	public Double getWagon_carrying_capacity() {
		return wagon_carrying_capacity;
	}

	public void setWagon_carrying_capacity(Double wagon_carrying_capacity) {
		this.wagon_carrying_capacity = wagon_carrying_capacity;
	}

	public String getWagon_scheme_name() {
		return wagon_scheme_name;
	}

	public void setWagon_scheme_name(String wagon_scheme_name) {
		this.wagon_scheme_name = wagon_scheme_name;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getAlloted_by() {
		return alloted_by;
	}

	public void setAlloted_by(String alloted_by) {
		this.alloted_by = alloted_by;
	}

	public Date getAllotment_date() {
		return allotment_date;
	}

	public void setAllotment_date(Date allotment_date) {
		this.allotment_date = allotment_date;
	}

	public String getRoh_station() {
		return roh_station;
	}

	public void setRoh_station(String roh_station) {
		this.roh_station = roh_station;
	}

	public Date getRoh_date() {
		return roh_date;
	}

	public void setRoh_date(Date roh_date) {
		this.roh_date = roh_date;
	}

	public Date getPoh_date() {
		return poh_date;
	}

	public void setPoh_date(Date poh_date) {
		this.poh_date = poh_date;
	}

	public String getPoh_workshop() {
		return poh_workshop;
	}

	public void setPoh_workshop(String poh_workshop) {
		this.poh_workshop = poh_workshop;
	}

	public Date getPoh_due_date() {
		return poh_due_date;
	}

	public void setPoh_due_date(Date poh_due_date) {
		this.poh_due_date = poh_due_date;
	}

	public Date getUpdate_poh_timestamp() {
		return update_poh_timestamp;
	}

	public void setUpdate_poh_timestamp(Date update_poh_timestamp) {
		this.update_poh_timestamp = update_poh_timestamp;
	}

	public Date getUpdate_roh_timestamp() {
		return update_roh_timestamp;
	}

	public void setUpdate_roh_timestamp(Date update_roh_timestamp) {
		this.update_roh_timestamp = update_roh_timestamp;
	}
	
	
	 
	
	
	
	
	
	
	
}
