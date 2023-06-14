package com.mdms.wagon.wagonuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="wagon_cleansed_data", schema="mdms_wagon")
public class WagonCleansedData {
	@Id
	@Column(name="wagon_no")
	private String  wagon_no ;
	
	@Column(name="wagon_type")
	private String  wagon_type ;
	
	@Column(name="wagon_owning_rly")
	private String  wagon_owning_rly ;
	
	@Column(name="orgnization_type")
	private String  orgnization_type ;
	
	@Column(name="wagon_rfid1")
	private String  wagon_rfid1 ;
	
	@Column(name="wagon_rfid2")
	private String  wagon_rfid2 ;
	
	
	
	@Column(name="wagon_class_group")
	private String  wagon_class_group ;
	
	@Column(name="wagon_tare")
	private Long  wagon_tare ;
	
	@Column(name="wagon_carrying_capacity")
	private Long  wagon_carrying_capacity ;
	
	@Column(name="wagon_scheme_name")
	private String  wagon_scheme_name ;
	
	@Column(name="wagon_manufacture_code")
	private Integer  wagon_manufacture_code ;
	
	@Column(name="wagon_gauge_code")
	private String  wagon_gauge_code ;
	
	

	@Column(name="wagon_status")
	private String  wagon_status ;
	
	@Column(name="wagon_date")
	private String  wagon_date ;
	

	@Column(name="wagon_manufacture_date")
	private Date  wagon_manufacture_date ;
	
	
	
	@Column(name="wagon_co_owner")
	private String  wagon_co_owner ;
	
	@Column(name="base_depo_station")
	private String  base_depo_station ;
	
	
	@Column(name="stock_type_code")
	private String  stock_type_code ;
	
	@Column(name="manufacturing_country")
	private String  manufacturing_country ;
	
	@Column(name="serial_number")
	private String  serial_number;
	
	
	@Column(name="pohid")
	private Long  pohid ;
	
	@Column(name="wagonno_old")
	private Long  wagonno_old ;
	
	@Column(name="status")
	private String  status ;
	
	@Column(name="remarks")
	private String  remarks ;
	
	@Column(name="user_id")
	private String  user_id ;
	
	@Column(name="txn_date")
	private Date txn_dates ;
	
	@Column(name="chkdigit")
	private String chkdigit ;

	public String getWagon_no() {
		return wagon_no;
	}

	public void setWagon_no(String wagon_no) {
		this.wagon_no = wagon_no;
	}

	public String getWagon_type() {
		return wagon_type;
	}

	public void setWagon_type(String wagon_type) {
		this.wagon_type = wagon_type;
	}

	public String getWagon_owning_rly() {
		return wagon_owning_rly;
	}

	public void setWagon_owning_rly(String wagon_owning_rly) {
		this.wagon_owning_rly = wagon_owning_rly;
	}

	public String getOrgnization_type() {
		return orgnization_type;
	}

	public void setOrgnization_type(String orgnization_type) {
		this.orgnization_type = orgnization_type;
	}

	public String getWagon_rfid1() {
		return wagon_rfid1;
	}

	public void setWagon_rfid1(String wagon_rfid1) {
		this.wagon_rfid1 = wagon_rfid1;
	}

	public String getWagon_rfid2() {
		return wagon_rfid2;
	}

	public void setWagon_rfid2(String wagon_rfid2) {
		this.wagon_rfid2 = wagon_rfid2;
	}

	public String getWagon_class_group() {
		return wagon_class_group;
	}

	public void setWagon_class_group(String wagon_class_group) {
		this.wagon_class_group = wagon_class_group;
	}

	public Long getWagon_tare() {
		return wagon_tare;
	}

	public void setWagon_tare(Long wagon_tare) {
		this.wagon_tare = wagon_tare;
	}

	public Long getWagon_carrying_capacity() {
		return wagon_carrying_capacity;
	}

	public void setWagon_carrying_capacity(Long wagon_carrying_capacity) {
		this.wagon_carrying_capacity = wagon_carrying_capacity;
	}

	public String getWagon_scheme_name() {
		return wagon_scheme_name;
	}

	public void setWagon_scheme_name(String wagon_scheme_name) {
		this.wagon_scheme_name = wagon_scheme_name;
	}

	public Integer getWagon_manufacture_code() {
		return wagon_manufacture_code;
	}

	public void setWagon_manufacture_code(Integer wagon_manufacture_code) {
		this.wagon_manufacture_code = wagon_manufacture_code;
	}

	public String getWagon_gauge_code() {
		return wagon_gauge_code;
	}

	public void setWagon_gauge_code(String wagon_gauge_code) {
		this.wagon_gauge_code = wagon_gauge_code;
	}

	public String getWagon_status() {
		return wagon_status;
	}

	public void setWagon_status(String wagon_status) {
		this.wagon_status = wagon_status;
	}

	public String getWagon_date() {
		return wagon_date;
	}

	public void setWagon_date(String wagon_date) {
		this.wagon_date = wagon_date;
	}

	

	public Date getWagon_manufacture_date() {
		return wagon_manufacture_date;
	}

	public void setWagon_manufacture_date(Date wagon_manufacture_date) {
		this.wagon_manufacture_date = wagon_manufacture_date;
	}

	public String getWagon_co_owner() {
		return wagon_co_owner;
	}

	public void setWagon_co_owner(String wagon_co_owner) {
		this.wagon_co_owner = wagon_co_owner;
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

	public String getManufacturing_country() {
		return manufacturing_country;
	}

	public void setManufacturing_country(String manufacturing_country) {
		this.manufacturing_country = manufacturing_country;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public Long getPohid() {
		return pohid;
	}

	public void setPohid(Long pohid) {
		this.pohid = pohid;
	}

	public Long getWagonno_old() {
		return wagonno_old;
	}

	public void setWagonno_old(Long wagonno_old) {
		this.wagonno_old = wagonno_old;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getTxn_dates() {
		return txn_dates;
	}

	public void setTxn_dates(Date txn_dates) {
		this.txn_dates = txn_dates;
	}

	public String getChkdigit() {
		return chkdigit;
	}

	public void setChkdigit(String chkdigit) {
		this.chkdigit = chkdigit;
	}
	
	

}
