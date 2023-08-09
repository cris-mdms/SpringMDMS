package com.mdms.dahsboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="loco_data_slam_250723", schema="mdms_analysis")
public class LocoDataSlamModel {
	@Id
	@Column(name="loco_no")
    private Integer	 loco_no ;

    @Column(name="loco_type")
    private String	 loco_type; 
    
//    @Column(name="loco_commissioning_date")
//    private Date loco_commissioning_date; 
//    
    @Column(name="loco_owning_zone")
    private String	 loco_owning_zone; 
    
    @Column(name="loco_owning_shed")
    private String	 loco_owning_shed; 
    
    @Column(name="loco_owning_division")
    private String	 loco_owning_division; 
	    
//    @Column(name="loco_manufacturing_date")
//    private Date	 loco_manufacturing_date; 
//    
//    @Column(name="loco_receiving_date")
//    private Date	 loco_receiving_date; 
//    
//    @Column(name="loco_manufacturer")
//    private String	 loco_manufacturer; 
//    @Column(name="loco_traction_code")
//    private String	 loco_traction_code; 
//	    
//    @Column(name="loco_brake_type")
//    private String	 loco_brake_type; 
//    
//    @Column(name="loco_control_type")
//    private String	 loco_control_type; 
//    
//    @Column(name="loco_permanent_domain")
//    private String	 loco_permanent_domain; 
//    
//    @Column(name="loco_gauge_type")
//    private String	 loco_gauge_type; 
//    
//    @Column(name="loco_auxilary")
//    private String	 loco_auxilary; 
    
//    @Column(name="loco_boogie_type")
//    private String	 loco_boogie_type; 
//	
    @Column(name="locostatus")
    private String	 locostatus;

	public Integer getLoco_no() {
		return loco_no;
	}

	public void setLoco_no(Integer loco_no) {
		this.loco_no = loco_no;
	}

	public String getLoco_type() {
		return loco_type;
	}

	public void setLoco_type(String loco_type) {
		this.loco_type = loco_type;
	}

//	public Date getLoco_commissioning_date() {
//		return loco_commissioning_date;
//	}
//
//	public void setLoco_commissioning_date(Date loco_commissioning_date) {
//		this.loco_commissioning_date = loco_commissioning_date;
//	}

	public String getLoco_owning_zone() {
		return loco_owning_zone;
	}

	public void setLoco_owning_zone(String loco_owning_zone) {
		this.loco_owning_zone = loco_owning_zone;
	}

	public String getLoco_owning_shed() {
		return loco_owning_shed;
	}

	public void setLoco_owning_shed(String loco_owning_shed) {
		this.loco_owning_shed = loco_owning_shed;
	}

	public String getLoco_owning_division() {
		return loco_owning_division;
	}

	public void setLoco_owning_division(String loco_owning_division) {
		this.loco_owning_division = loco_owning_division;
	}

//	public Date getLoco_manufacturing_date() {
//		return loco_manufacturing_date;
//	}
//
//	public void setLoco_manufacturing_date(Date loco_manufacturing_date) {
//		this.loco_manufacturing_date = loco_manufacturing_date;
//	}
//
//	public Date getLoco_receiving_date() {
//		return loco_receiving_date;
//	}
//
//	public void setLoco_receiving_date(Date loco_receiving_date) {
//		this.loco_receiving_date = loco_receiving_date;
//	}
//
//	public String getLoco_manufacturer() {
//		return loco_manufacturer;
//	}
//
//	public void setLoco_manufacturer(String loco_manufacturer) {
//		this.loco_manufacturer = loco_manufacturer;
//	}
//
//	public String getLoco_traction_code() {
//		return loco_traction_code;
//	}
//
//	public void setLoco_traction_code(String loco_traction_code) {
//		this.loco_traction_code = loco_traction_code;
//	}
//
//	public String getLoco_brake_type() {
//		return loco_brake_type;
//	}
//
//	public void setLoco_brake_type(String loco_brake_type) {
//		this.loco_brake_type = loco_brake_type;
//	}
//
//	public String getLoco_control_type() {
//		return loco_control_type;
//	}
//
//	public void setLoco_control_type(String loco_control_type) {
//		this.loco_control_type = loco_control_type;
//	}
//
//	public String getLoco_permanent_domain() {
//		return loco_permanent_domain;
//	}
//
//	public void setLoco_permanent_domain(String loco_permanent_domain) {
//		this.loco_permanent_domain = loco_permanent_domain;
//	}
//
//	public String getLoco_gauge_type() {
//		return loco_gauge_type;
//	}
//
//	public void setLoco_gauge_type(String loco_gauge_type) {
//		this.loco_gauge_type = loco_gauge_type;
//	}
//
//	public String getLoco_auxilary() {
//		return loco_auxilary;
//	}
//
//	public void setLoco_auxilary(String loco_auxilary) {
//		this.loco_auxilary = loco_auxilary;
//	}
//
//	public String getLoco_boogie_type() {
//		return loco_boogie_type;
//	}
//
//	public void setLoco_boogie_type(String loco_boogie_type) {
//		this.loco_boogie_type = loco_boogie_type;
//	}

	public String getLocostatus() {
		return locostatus;
	}

	public void setLocostatus(String locostatus) {
		this.locostatus = locostatus;
	} 
    
  
}
