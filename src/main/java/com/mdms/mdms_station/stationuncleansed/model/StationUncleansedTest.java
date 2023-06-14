package com.mdms.mdms_station.stationuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name="station_uncleansed_data", schema="mdms_station")
public class StationUncleansedTest {
	
	@Id
	@Column(name="station_code")
	private String station_code;
	
	@Column(name="station_numeric_code")
	private long  station_numeric_code ;
	
	@Column(name="station_name")
	private String  station_name ;
	
	@Column(name="traffic_type")
	private String  traffic_type ;
	
	@Column(name="transhipment_flag")
	private String  transhipment_flag ;
	
	@Column(name="zone_code")
	private String  zone_code ;
	
	@Column(name="division_code")
	private String  division_code ;
	
	@Column(name="gauge_code")
	private String  gauge_code ;
	
	
	public String getStation_code() {
		return station_code;
	}


	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}


	public long getStation_numeric_code() {
		return station_numeric_code;
	}


	public void setStation_numeric_code(long station_numeric_code) {
		this.station_numeric_code = station_numeric_code;
	}


	public String getStation_name() {
		return station_name;
	}


	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}


	public String getTraffic_type() {
		return traffic_type;
	}


	public void setTraffic_type(String traffic_type) {
		this.traffic_type = traffic_type;
	}


	public String getTranshipment_flag() {
		return transhipment_flag;
	}


	public void setTranshipment_flag(String transhipment_flag) {
		this.transhipment_flag = transhipment_flag;
	}


	public String getZone_code() {
		return zone_code;
	}


	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}


	public String getDivision_code() {
		return division_code;
	}


	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}


	public String getGauge_code() {
		return gauge_code;
	}


	public void setGauge_code(String gauge_code) {
		this.gauge_code = gauge_code;
	}


	

}
