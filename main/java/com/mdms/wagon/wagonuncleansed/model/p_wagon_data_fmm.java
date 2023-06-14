package com.mdms.wagon.wagonuncleansed.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_wagon_data_fmm", schema="mdms_wagon")
public class p_wagon_data_fmm {
	
private long  wagonid ;
	
	private String  vehicleno ;
	
	private String  owningrly;
	
	private String  vehicletype;
	
	private String  orgtype;
	
	@Id
	@Column(name="adb_timestamp")
	private Date  adb_timestamp;
	
	@Column(name="adb_l_delivery_status")
	private String  adb_l_delivery_status;

	public long getWagonid() {
		return wagonid;
	}

	public void setWagonid(long wagonid) {
		this.wagonid = wagonid;
	}

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
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

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public Date getAdb_timestamp() {
		return adb_timestamp;
	}

	public void setAdb_timestamp(Date adb_timestamp) {
		this.adb_timestamp = adb_timestamp;
	}

	public String getAdb_l_delivery_status() {
		return adb_l_delivery_status;
	}

	public void setAdb_l_delivery_status(String adb_l_delivery_status) {
		this.adb_l_delivery_status = adb_l_delivery_status;
	}

	
	
	
	
	
	
	
	
	
	
	

}
