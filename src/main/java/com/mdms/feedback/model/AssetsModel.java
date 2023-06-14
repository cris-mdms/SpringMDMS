package com.mdms.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="assets_master", schema="mdms_feedback")     // Developed by Ritu 
public class AssetsModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private String record_id;
		
	@Column(name="asset_name")
	private String asset_name;
	
	@Column(name="asset_module_name")
	private String asset_module_name;
	
	@Column(name="asset_owner_id")
	private String asset_owner_id;
	
	@Column(name="asset_owner_name")
	private String asset_owner_name;

	

	public String getRecord_id() {
		return record_id;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}

	public String getAsset_name() {
		return asset_name;
	}

	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}

	public String getAsset_module_name() {
		return asset_module_name;
	}

	public void setAsset_module_name(String asset_module_name) {
		this.asset_module_name = asset_module_name;
	}

	public String getAsset_owner_id() {
		return asset_owner_id;
	}

	public void setAsset_owner_id(String asset_owner_id) {
		this.asset_owner_id = asset_owner_id;
	}

	public String getAsset_owner_name() {
		return asset_owner_name;
	}

	public void setAsset_owner_name(String asset_owner_name) {
		this.asset_owner_name = asset_owner_name;
	}

	
	
}
