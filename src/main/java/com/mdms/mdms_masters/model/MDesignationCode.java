package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_designation", schema="mdms_masters")
public class MDesignationCode {
	@Id
	@Column(name="hrms_designation")
	private String hrms_designation ;
	
	@Column(name="asset_designation_code")
	private String asset_designation_code ;
	
	@Column(name="is_active_designation")
	private String is_active_designation ;

	public String getHrms_designation() {
		return hrms_designation;
	}

	public void setHrms_designation(String hrms_designation) {
		this.hrms_designation = hrms_designation;
	}

	public String getAsset_designation_code() {
		return asset_designation_code;
	}

	public void setAsset_designation_code(String asset_designation_code) {
		this.asset_designation_code = asset_designation_code;
	}

	public String getIs_active_designation() {
		return is_active_designation;
	}

	public void setIs_active_designation(String is_active_designation) {
		this.is_active_designation = is_active_designation;
	}
	
	
	

}
