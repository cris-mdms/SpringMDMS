package com.mdms.dahsboard.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public interface DashBoardStationCountDivisionWiseModel {
//	@JsonIgnore 
//	 @Value("#{target.draft_forward_approval_count}")
//public	Integer getdraft_forward_approval_count();
//	
	

@JsonIgnore 
 @Value("#{target.pending_approval}")
 public Integer getpending_approval();
 
@JsonIgnore 
 @Value("#{target.draft_forward_approval_count}")
public	Integer getDraft_forward_approval_count();

	
	//Shilpi 10-03-2021
	@JsonIgnore 
	 @Value("#{target.loco_Owningshed}")
	 public	String getLoco_Owningshed();
	 
	
	@JsonIgnore 
	 @Value("#{target.division_code}")
public	String getDivision_code();
	
	
	@JsonIgnore 
	 @Value("#{target.zone_code}")
public	String getzone_code();
	@JsonIgnore 
	 @Value("#{target.total_loco_count}")
	 public	Integer getTotal_loco_count();
	 
	@JsonIgnore 
	 @Value("#{target.uncleansed_count}")
	 public	Integer getuncleansed_count();
	 
	
	@JsonIgnore 
	 @Value("#{target.cleansed_count}")
	 public Integer getcleansed_count();
	 
	
//	@JsonIgnore 
//	 @Value("#{target.pending_approval}")
//	 public Integer getpending_approval();
//	 
	
	@JsonIgnore 
	 @Value("#{target.total_division_count}")
	 public Integer gettotal_division_count();

	
	
	


	@JsonIgnore 
	 @Value("#{args[0]+': '+target.division_code}")	 
	 public void setdivision_code(String str);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.uncleansed_count}")	 
	 public void setUncleansed_count(Integer str1);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.cleansed_count}")	 
	 public void setCleansed_count(Integer vgf);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.pending_approval}")	 
	 public void setPending_approval(Integer cvb);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.total_division_count}")	 
	 public void settotal_division_count(Integer dgd);
	
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.total_loco_count}")	 
	 public void setTotal_loco_count(Integer dgd);
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.draft_forward_approval_count}")
public	void setDraft_forward_approval_count();


}
