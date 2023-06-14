package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.EmbeddedId;

@Entity()
@Table(name="station_cleansed_data", schema="mdms_station")
public class StationCleansedData {
	
	@EmbeddedId
	private StationPKey stn_Id;
	
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
	
	@Column(name="latitude")
	private String  latitude ;
	
	@Column(name="longitude")
	private String  longitude ;
	
	@Column(name="station_class")
	private String  station_class ;
	
	@Column(name="junction_flag")
	private String  junction_flag ;
	
	@Column(name="interchange_flag")
	private String  interchange_flag ;
	
	@Column(name="state")
	private String  state ;
	
	@Column(name="pincode")
	private String  pincode ;
	
	@Column(name="district")
	private String  district ;
	
	@Column(name="tehsil")
	private String  tehsil ;
	
	@Column(name="station_category")
	private String  station_category ;
	
	@Column(name="station_short_name")
	private String  station_short_name ;
	
	@Column(name="station_hindi_name")
	private String  station_hindi_name ;
	
	@Column(name="interlocking_standard")
	private String  interlocking_standard ;
	
	@Column(name="traction")
	private String  traction ;
	
	@Column(name="working_division")
	private String  working_division ;
	
	@Column(name="no_of_lines")
	private String  no_of_lines ;
	
	@Column(name="weight_bridge")
	private int  weight_bridge ;
	
	@Column(name="siding")
	private String  siding ;
	
	@Column(name="block_section")
	private String  block_section ;
	
//	@Type(type = "string-array")
    @Column(
        name = "operating_station_signal"
      
    )

	private String operating_station_signal ;
	
	@Column(name="booking_type")
	private String  booking_type ;
	
	@Column(name="station_status")
	private String  station_status ;
	
	@Column(name="record_status")
	private String  record_status ;
	
	@Column(name="cmi_status")
	private String  cmi_status ;
	
	@Column(name="dti_status")
	private String  dti_status ;
	
	@Column(name="user_id_cmi")
	private String  user_id_cmi ;
	
	@Column(name="user_id_dti")
	private String  user_id_dti ;
	
	@Column(name="txn_date_cmi")
	private Date  txn_date_cmi ;
	
	@Column(name="txn_date_dti")
	private Date  txn_date_dti ;
	
	@Column(name="booking_resource")
	private String  booking_resource ;
	
	
	@Column(name="remarks")
	private String  remarks ;
	
	

	public StationPKey getStn_Id() {
		return stn_Id;
	}

	public void setStn_Id(StationPKey stn_Id) {
		this.stn_Id = stn_Id;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStation_class() {
		return station_class;
	}

	public void setStation_class(String station_class) {
		this.station_class = station_class;
	}

	public String getJunction_flag() {
		return junction_flag;
	}

	public void setJunction_flag(String junction_flag) {
		this.junction_flag = junction_flag;
	}

	public String getInterchange_flag() {
		return interchange_flag;
	}

	public void setInterchange_flag(String interchange_flag) {
		this.interchange_flag = interchange_flag;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getStation_category() {
		return station_category;
	}

	public void setStation_category(String station_category) {
		this.station_category = station_category;
	}

	public String getStation_short_name() {
		return station_short_name;
	}

	public void setStation_short_name(String station_short_name) {
		this.station_short_name = station_short_name;
	}

	public String getStation_hindi_name() {
		return station_hindi_name;
	}

	public void setStation_hindi_name(String station_hindi_name) {
		this.station_hindi_name = station_hindi_name;
	}

	public String getInterlocking_standard() {
		return interlocking_standard;
	}

	public void setInterlocking_standard(String interlocking_standard) {
		this.interlocking_standard = interlocking_standard;
	}

	public String getTraction() {
		return traction;
	}

	public void setTraction(String traction) {
		this.traction = traction;
	}

	public String getWorking_division() {
		return working_division;
	}

	public void setWorking_division(String working_division) {
		this.working_division = working_division;
	}

	public String getNo_of_lines() {
		return no_of_lines;
	}

	public void setNo_of_lines(String no_of_lines) {
		this.no_of_lines = no_of_lines;
	}

	public int getWeight_bridge() {
		return weight_bridge;
	}

	public void setWeight_bridge(int weight_bridge) {
		this.weight_bridge = weight_bridge;
	}

	public String getSiding() {
		return siding;
	}

	public void setSiding(String siding) {
		this.siding = siding;
	}

	public String getBlock_section() {
		return block_section;
	}

	public void setBlock_section(String block_section) {
		this.block_section = block_section;
	}

	public String getOperating_station_signal() {
		return operating_station_signal;
	}

	public void setOperating_station_signal(String operating_station_signal) {
		this.operating_station_signal = operating_station_signal;
	}

	public String getBooking_type() {
		return booking_type;
	}

	public void setBooking_type(String booking_type) {
		this.booking_type = booking_type;
	}

	public String getStation_status() {
		return station_status;
	}

	public void setStation_status(String station_status) {
		this.station_status = station_status;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public String getCmi_status() {
		return cmi_status;
	}

	public void setCmi_status(String cmi_status) {
		this.cmi_status = cmi_status;
	}

	public String getDti_status() {
		return dti_status;
	}

	public void setDti_status(String dti_status) {
		this.dti_status = dti_status;
	}

	public String getUser_id_cmi() {
		return user_id_cmi;
	}

	public void setUser_id_cmi(String user_id_cmi) {
		this.user_id_cmi = user_id_cmi;
	}

	public String getUser_id_dti() {
		return user_id_dti;
	}

	public void setUser_id_dti(String user_id_dti) {
		this.user_id_dti = user_id_dti;
	}

	public Date getTxn_date_cmi() {
		return txn_date_cmi;
	}

	public void setTxn_date_cmi(Date txn_date_cmi) {
		this.txn_date_cmi = txn_date_cmi;
	}

	public Date getTxn_date_dti() {
		return txn_date_dti;
	}

	public void setTxn_date_dti(Date txn_date_dti) {
		this.txn_date_dti = txn_date_dti;
	}

	public String getBooking_resource() {
		return booking_resource;
	}

	public void setBooking_resource(String booking_resource) {
		this.booking_resource = booking_resource;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
