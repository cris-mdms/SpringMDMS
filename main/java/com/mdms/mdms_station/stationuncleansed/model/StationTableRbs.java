/*This Model class refers RBS Data for raw data input and show to user.     
 * Created By : Anshul, 29-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;

@Entity()
@Table(name="station_table_rbs", schema="mdms_station")
public class StationTableRbs {
	
	@EmbeddedId
    private RbsPKey rbs_id;// Composite key 
	
	@Column(name="gauge_type")
	private String gauge_type;
   
	
	@Column(name="stn_status")
	private String  stn_status ;
	
	@Column(name="stn_numeric_code")
	private  String  stn_numeric_code;
	
	@Column(name="stn_name")
	private String  stn_name;
  
	@Column(name="traffic_type")
	private String  traffic_type ;
   
	@Column(name="transhipment_flag")
	private String  transhipment_flag ;
   
		
	@Column(name="operating_class")
	private  String  operating_class ;
	
	@Column(name="junction_flag")
	private String junction_flag ;
	
	@Column(name="ic_flag")
	private String ic_flag ; 
	
	@Column(name="category")
	private String  category ;
	
	@Column(name="tehsil")
	private String tehsil ;
	
	@Column(name="pin_code")
	private String pin_code ;

	@Column(name="div_ser_no")
	private int div_ser_no ;

//	private String division_code;
	
	
	public RbsPKey getRbs_id() {
		return rbs_id;
	}

	public void setRbs_id(RbsPKey rbs_id) {
		this.rbs_id = rbs_id;
	}

	public String getGauge_type() {
		return gauge_type;
	}

	public void setGauge_type(String gauge_type) {
		this.gauge_type = gauge_type;
	}

	public String getStn_status() {
		return stn_status;
	}

	public void setStn_status(String stn_status) {
		this.stn_status = stn_status;
	}

	public String getStn_numeric_code() {
		return stn_numeric_code;
	}

	public void setStn_numeric_code(String stn_numeric_code) {
		this.stn_numeric_code = stn_numeric_code;
	}

	public String getStn_name() {
		return stn_name;
	}

	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
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

	public String getOperating_class() {
		return operating_class;
	}

	public void setOperating_class(String operating_class) {
		this.operating_class = operating_class;
	}

	public String getJunction_flag() {
		return junction_flag;
	}

	public void setJunction_flag(String junction_flag) {
		this.junction_flag = junction_flag;
	}

	public String getIc_flag() {
		return ic_flag;
	}

	public void setIc_flag(String ic_flag) {
		this.ic_flag = ic_flag;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public int getDiv_ser_no() {
		return div_ser_no;
	}

	public void setDiv_ser_no(int div_ser_no) {
		this.div_ser_no = div_ser_no;
	}

//	public String getDivision_code() {
//		return division_code;
//	}
//
//	public void setDivision_code(String division_code) {
//		this.division_code = division_code;
//	}

	
	
	
}
