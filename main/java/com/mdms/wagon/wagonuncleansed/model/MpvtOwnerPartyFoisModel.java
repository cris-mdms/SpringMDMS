package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_pvtowner_partycode_fois", schema="mdms_wagonr")
public class MpvtOwnerPartyFoisModel {
	
	
	@Id
	@Column(name="pvt_owner_code")
	private String pvt_owner_code;
	private String description;
	
	public MpvtOwnerPartyFoisModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MpvtOwnerPartyFoisModel(String pvt_owner_code, String description) {
		super();
		this.pvt_owner_code = pvt_owner_code;
		this.description = description;
	}

	public String getPvt_owner_code() {
		return pvt_owner_code;
	}

	public void setPvt_owner_code(String pvt_owner_code) {
		this.pvt_owner_code = pvt_owner_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
