package com.mdms.dahsboard.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public interface DashBoardCoachCountDepoWiseModel {

	@JsonIgnore 
	@Value("#{target.owning_depot}")
	 public String getOwning_depot();
	

	@JsonIgnore 
	@Value("#{target.owning_rly}")
	public	String getOwning_rly();

	@JsonIgnore 
	@Value("#{target.uncleansed_count}")
	public	Integer getuncleansed_count();

	@JsonIgnore 
	 @Value("#{target.cleansed_count}")
	 public Integer getcleansed_count();
	@JsonIgnore 
	@Value("#{target.total_depot_count}")
	public	Integer getTotal_depo_count();

	@JsonIgnore 
	 @Value("#{target.pending_approval}")
	 public Integer getpending_approval();
	 
	@JsonIgnore 
	 @Value("#{target.draft_forward_approval_count}")
	public	Integer getdraft_forward_approval_count();

	 
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.owning_rly}")	 
		 public void setOwning_rly(String str);
		
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.Owning_depot}")	 
		 public void setOwning_depot(String str);
		
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.cleansed_count}")	 
		 public void setcleansed_count(Integer vgf);
		 
		
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.pending_approval}")	 
		 public void setpending_approval(Integer cvb);
		
		 
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.draft_forward_approval_count}")
	public	void setdraft_forward_approval(Integer cvb);
		
		@JsonIgnore 
		 @Value("#{args[0]+': '+target.total_depot_count}")	 
		 public void setTotal_depo_count(Integer cvb);
		
}
