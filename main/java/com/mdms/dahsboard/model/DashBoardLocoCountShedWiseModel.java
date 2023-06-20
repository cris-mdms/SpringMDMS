package com.mdms.dahsboard.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public interface DashBoardLocoCountShedWiseModel {
@JsonIgnore 
@Value("#{target.loco_Owningshed}")
 public	String getLoco_Owningshed();



@JsonIgnore 
@Value("#{target.uncleansed_count}")
public	Integer getuncleansed_count();





@JsonIgnore 
 @Value("#{target.cleansed_count}")
 public Integer getcleansed_count();
@JsonIgnore 
@Value("#{target.total_loco_count}")
public	Integer getTotal_loco_count();

@JsonIgnore 
 @Value("#{target.pending_approval}")
 public Integer getpending_approval();
 
@JsonIgnore 
 @Value("#{target.draft_forward_approval_count}")
public	Integer getDraft_forward_approval_count();

 
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.loco_Owningshed}")	 
	 public void setLoco_Owningshed(String str);
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.cleansed_count}")	 
	 public void setcleansed_count(Integer vgf);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.pending_approval}")	 
	 public void setpending_approval(Integer cvb);
	
	 
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.draft_forward_approval_count}")
public	void setdraft_forward_approval_count();
	

	 
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.uncleansed_count}")	 
	 public void setUncleansed_count(Integer vgf);
	 
	// Shilpi 19-03-2021
	
	
	@JsonIgnore 
	@Value("#{target.loco_owning_zone_code}")
	 public	String getLoco_owning_zone_code();
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.loco_owning_zone_code}")	 
	 public void setLoco_owning_zone_code(String vgf);

	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.total_loco_count}")	 
	 public void setTotal_loco_count(Integer vgf);
	
}



