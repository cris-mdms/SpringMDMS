package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StationRbsAPIJSONModel {
	//private Date day;
	

	private String stnCode;   
	
	private String  stnName ;
	

	private  String  divCode;
	
	private  String  gauge_type;
	

	private String  zoneCode;
  
	
	private String  numericalCode;
   
	
	private String  junctionFlag;   
		
	
	private  String  stationStatus ;
	
	
	private String stnGauge;
	
	
	private String  latitudeDegree;
	
	
	private String latitudeHours;
	
	private String longitudeDegree;
	
	private String longitudeHours;
	
	private String operatingClass;
	
	private String stnTraffic;
	private String stnCategory;
	private String stnState;
	private String stnDistrict;
	private String stnTehsil;
	private String stnPincode;
	
	private String stn_code;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 	
	private  Date stn_vld_from ;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private  Date stn_vld_upto ;

	public String getStnCode() {
		return stnCode;
	}

	public void setStnCode(String stnCode) {
		this.stnCode = stnCode;
	}

	public String getStnName() {
		return stnName;
	}

	public void setStnName(String stnName) {
		this.stnName = stnName;
	}

	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getNumericalCode() {
		return numericalCode;
	}

	public void setNumericalCode(String numericalCode) {
		this.numericalCode = numericalCode;
	}

	public String getJunctionFlag() {
		return junctionFlag;
	}

	public void setJunctionFlag(String junctionFlag) {
		this.junctionFlag = junctionFlag;
	}

	public String getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}

	public String getStnGauge() {
		return stnGauge;
	}

	public void setStnGauge(String stnGauge) {
		this.stnGauge = stnGauge;
	}

	public String getLatitudeDegree() {
		return latitudeDegree;
	}

	public void setLatitudeDegree(String latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}

	public String getLatitudeHours() {
		return latitudeHours;
	}

	public void setLatitudeHours(String latitudeHours) {
		this.latitudeHours = latitudeHours;
	}

	public String getLongitudeDegree() {
		return longitudeDegree;
	}

	public void setLongitudeDegree(String longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}

	public String getLongitudeHours() {
		return longitudeHours;
	}

	public void setLongitudeHours(String longitudeHours) {
		this.longitudeHours = longitudeHours;
	}

	public String getOperatingClass() {
		return operatingClass;
	}

	public void setOperatingClass(String operatingClass) {
		this.operatingClass = operatingClass;
	}

	public String getStnTraffic() {
		return stnTraffic;
	}

	public void setStnTraffic(String stnTraffic) {
		this.stnTraffic = stnTraffic;
	}

	public String getStnCategory() {
		return stnCategory;
	}

	public void setStnCategory(String stnCategory) {
		this.stnCategory = stnCategory;
	}

	public String getStnState() {
		return stnState;
	}

	public void setStnState(String stnState) {
		this.stnState = stnState;
	}

	public String getStnDistrict() {
		return stnDistrict;
	}

	public void setStnDistrict(String stnDistrict) {
		this.stnDistrict = stnDistrict;
	}

	public String getStnTehsil() {
		return stnTehsil;
	}

	public void setStnTehsil(String stnTehsil) {
		this.stnTehsil = stnTehsil;
	}

	public String getStnPincode() {
		return stnPincode;
	}

	public void setStnPincode(String stnPincode) {
		this.stnPincode = stnPincode;
	}

	public String getStn_code() {
		return stn_code;
	}

	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}

	public Date getStn_vld_from() {
		return stn_vld_from;
	}

	public void setStn_vld_from(Date stn_vld_from) {
		this.stn_vld_from = stn_vld_from;
	}

	public Date getStn_vld_upto() {
		return stn_vld_upto;
	}

	public void setStn_vld_upto(Date stn_vld_upto) {
		this.stn_vld_upto = stn_vld_upto;
	}

	public String getGauge_type() {
		return gauge_type;
	}

	public void setGauge_type(String gauge_type) {
		this.gauge_type = gauge_type;
	}
	
	
	
//	"stnCode": "MAHE",
//	    "stnName": "Mahe",
//	    "divCode": "PGT ",
//	    "zoneCode": "SR  ",
//	    "interchange": "N",
//	    "numericalCode": "6532306",
//	    "junctionFlag": "N",
//	    "stationStatus": "S",
//	    "stnGauge": "S",
//	    "transhipmentFlag": "N",
//	    "latitudeDegree": 61073,
//	    "latitudeHours": 11,
//	    "longitudeDegree": 59663,
//	    "longitudeHours": 75,
//	    "operatingClass": "N",
//	    "stnTraffic": "C",
//	    "stnCategory": "D ",
//	    "stnState": "KERALA",
//	    "stnDistrict": "KOZHIKODE",
//	    "stnTehsil": "VADAKARA",
//	    "stnPincode": "673309",
//	    "stnValidFrom": "2008-01-01",
//	    "stnValidUpto": "2999-12-31"

	
}
