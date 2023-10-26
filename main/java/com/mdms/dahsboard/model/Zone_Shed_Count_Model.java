package com.mdms.dahsboard.model;

public class Zone_Shed_Count_Model {
	String zone_name;
	String loco_owning_zone_code;
	String shed_name;
	String loco_owning_shed_code;
	Integer total_count;
	Integer total_uncleansed;
	Integer total_draft;
	Integer total_pending;
	Integer total_cleansed;
	String ir_flag;
	
	


	public Zone_Shed_Count_Model(String zone_name, String loco_owning_zone_code, String shed_name,
			String loco_owning_shed_code, Integer total_count, Integer total_uncleansed, Integer total_draft,
			Integer total_pending, Integer total_cleansed, String ir_flag) {
		super();
		this.zone_name = zone_name;
		this.loco_owning_zone_code = loco_owning_zone_code;
		this.shed_name = shed_name;
		this.loco_owning_shed_code = loco_owning_shed_code;
		this.total_count = total_count;
		this.total_uncleansed = total_uncleansed;
		this.total_draft = total_draft;
		this.total_pending = total_pending;
		this.total_cleansed = total_cleansed;
		this.ir_flag = ir_flag;
	}


	public String getLoco_owning_zone_code() {
		return loco_owning_zone_code;
	}


	public String getLoco_owning_shed_code() {
		return loco_owning_shed_code;
	}


	public String getZone_name() {
		return zone_name;
	}


	public String getShed_name() {
		return shed_name;
	}


	public Integer getTotal_count() {
		return total_count;
	}


	public Integer getTotal_uncleansed() {
		return total_uncleansed;
	}


	public Integer getTotal_draft() {
		return total_draft;
	}


	public Integer getTotal_pending() {
		return total_pending;
	}


	public Integer getTotal_cleansed() {
		return total_cleansed;
	}


	public String getIr_flag() {
		return ir_flag;
	}

	
	
}
