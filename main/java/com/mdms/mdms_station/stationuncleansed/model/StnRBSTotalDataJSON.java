package com.mdms.mdms_station.stationuncleansed.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StnRBSTotalDataJSON {
	@JsonProperty("stn_name")
	private String stn_name;
	
	@JsonProperty("stn_code")
	private String stn_code;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("division_code")
	private String division_code;
	
	
	@JsonProperty("division_name")
	private String division_name;
	
	@JsonProperty("zone_code")
	private String zone_code;
	
	
	@JsonProperty("district_code")
	private String district_code;
	
	@JsonProperty("state_code")
	private String state_code;
	
	@JsonProperty("gauge_type")
	private String gauge_type;
	
	@JsonProperty("pin_code")
	private String pin_code;
	
	
	@JsonProperty("tehsil")
	private String tehsil;
	
	@JsonProperty("traffic_type")
	private String traffic_type;
	
	@JsonProperty("district_name")
	private String district_name;

	
	@JsonProperty("state_name")
	private String state_name;
	
	@JsonProperty("stn_vld_from")
	private String stn_vld_from;
	
	@JsonProperty("stn_vld_upto")
	private String stn_vld_upto;
	
	@JsonProperty("div_ser_no")
	private int div_ser_no;
	
//	private List data;
	
	
	
	public int getDiv_ser_no() {
		return div_ser_no;
	}

	public void setDiv_ser_no(int div_ser_no) {
		this.div_ser_no = div_ser_no;
	}



	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getStn_name() {
		return stn_name;
	}

	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
	}

	public String getStn_code() {
		return stn_code;
	}

	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDivision_code() {
		return division_code;
	}

	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public String getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getGauge_type() {
		return gauge_type;
	}

	public void setGauge_type(String gauge_type) {
		this.gauge_type = gauge_type;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getTraffic_type() {
		return traffic_type;
	}

	public void setTraffic_type(String traffic_type) {
		this.traffic_type = traffic_type;
	}

	public String getStn_vld_from() {
		return stn_vld_from;
	}

	public void setStn_vld_from(String stn_vld_from) {
		this.stn_vld_from = stn_vld_from;
	}

	public String getStn_vld_upto() {
		return stn_vld_upto;
	}

	public void setStn_vld_upto(String stn_vld_upto) {
		this.stn_vld_upto = stn_vld_upto;
	}
	
	
	
//	select a.stn_name, a.stn_code, a.category, 
//	b.division_code, b.division_name, b.zone_code, a.district_code,a.state_code,a.gauge_type,a.pin_code
//	,a.tehsil,a.traffic_type
//	from MDMS_station.station_table_rbs a join mdms_station.rbs_division b on a.div_ser_no=b.division_ser_no
//	where current_date between stn_vld_from and stn_vld_upto 

}
