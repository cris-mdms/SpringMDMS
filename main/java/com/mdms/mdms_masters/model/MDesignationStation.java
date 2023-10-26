package com.mdms.mdms_masters.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_designation_station", schema="mdms_masters")
public class MDesignationStation {
	@Id
	@Column(name="hrms_designation")
	private String hrms_designation ;
	
	@Column(name="asset_designation_code")
	private String asset_designation_code ;
	
	@Column(name="is_active")
	private String is_active ;
	
	@Column(name="user_role")
	private String user_role ;
	
	@Column(name="asset")
	private String asset;

	@Column(name="asset_sub_desig")
	private String asset_sub_desig;
	
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

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getAsset_sub_desig() {
		return asset_sub_desig;
	}

	public void setAsset_sub_desig(String asset_sub_desig) {
		this.asset_sub_desig = asset_sub_desig;
	}

	
	
}
