package com.mdms.dahsboard.model;

public class DashboardLocoModel {

	
	public	String division_code="null";
	public String loco_Owningshed;
	 public	Integer uncleansed_count=0;
	public Integer cleansed_count=0;
	public Integer pending_approval=0;
	public Integer draft_forward_approval_count=0;
	public String loco_owning_zone_code;
	// Shilpi 15-03-2021
	
//	public String owning_depot;
	
	//Shilpi 19-03-2021
	
	public String getLoco_owning_zone_code() {
		return loco_owning_zone_code;
	}


	public void setLoco_owning_zone_code(String loco_owning_zone_code) {
		this.loco_owning_zone_code = loco_owning_zone_code;
	}


	
	

	public Integer getTotal_depo_count() {
		return total_depo_count;
	}


	public void setTotal_depo_count(Integer total_depo_count) {
		this.total_depo_count = total_depo_count;
	}


	public Integer total_depo_count=0;
	
	public String getLoco_Owningshed() {
		return loco_Owningshed;
	}


	public void setLoco_Owningshed(String loco_Owningshed) {
		this.loco_Owningshed = loco_Owningshed;
	}



	
	
    public Integer total_division_count=0;
	
// Shilpi 10-03-2021
    
    public Integer  total_loco_count=0;



	public Integer getTotal_loco_count() {
		return total_loco_count;
	}


	public void setTotal_loco_count(Integer total_loco_count) {
		this.total_loco_count = total_loco_count;
	}






	public String getDivision_code() {
		return division_code;
	}


	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}


	public Integer getUncleansed_count() {
		return uncleansed_count;
	}


	public void setUncleansed_count(Integer uncleansed_count) {
		this.uncleansed_count = uncleansed_count;
	}


	public Integer getCleansed_count() {
		return cleansed_count;
	}


	public void setCleansed_count(Integer cleansed_count) {
		this.cleansed_count = cleansed_count;
	}


	public Integer getPending_approval() {
		return pending_approval;
	}


	public void setPending_approval(Integer pending_approval) {
		this.pending_approval = pending_approval;
	}


	public Integer getDraft_forward_approval_count() {
		return draft_forward_approval_count;
	}


	public void setDraft_forward_approval_count(Integer draft_forward_approval_count) {
		this.draft_forward_approval_count = draft_forward_approval_count;
	}



	public Integer getTotal_division_count() {
		return total_division_count;
	}


	public void setTotal_division_count(Integer total_division_count) {
		this.total_division_count = total_division_count;
	}


	

	
}
