package com.mdms.wagon.wagonuncleansed.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

  @Entity()  
  @Table(name="wagon_data_irwms", schema="mdms_wagon")
  public class WagonDataIrwms {  
  @Id
  @Column(name="wagonid")
  private BigInteger wagonid ;
  
  @Column(name="owningrly")
  private String owningrly ;
  
  
  @Column(name="vehicletype")
  private String vehicletype ;
  
  @Column(name="vehicleno")
  private BigInteger vehicleno ;
  
  
  
  
  public BigInteger getWagonid() { return wagonid; }
  
  public void setWagonid(BigInteger wagonid) { this.wagonid = wagonid; }
  
  public BigInteger getVehicleno() { return vehicleno; }
  
  public void setVehicleno(BigInteger vehicleno) { this.vehicleno = vehicleno;
  }
  
  public String getOwningrly() { return owningrly; }
  
  public void setOwningrly(String owningrly) { this.owningrly = owningrly; }
  
  public String getVehicletype() { return vehicletype; }
  
  public void setVehicletype(String vehicletype) { this.vehicletype =
  vehicletype; }
  
  
  
  
  
  
  // , , owningrly, vehicletype, pohid, chkdigit, vehiclenoold, ,
	/*
	 * manufacturingcode, groupname, status, wagon_status, datestamp,
	 * wagon_manufacture_date, wagon_manufacture_year, wagon_co_owner, remarks,
	 * wagon_valid_flag, base_depo_station, stock_type_code, serial_number,
	 * manufacturing_country, wagon_gauge_code, wagon_rfid1, wagon_rfid2,
	 * wagon_tare, wagon_carrying_capacity, wagon_scheme_name, insert_date,
	 * update_date, alloted_by, allotment_no, allotment_date
	 */
  
  
  
  }
 