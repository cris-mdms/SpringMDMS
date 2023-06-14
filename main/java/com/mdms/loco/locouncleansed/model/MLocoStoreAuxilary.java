package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_loco_store_auxilary",schema="mdms_loco")
public class MLocoStoreAuxilary {
	@Id
	@Column(name="auxi_id")
	private int axoId;
	
	@Column(name="auxi_name")
	private String axoName;

	public int getAxoId() {
		return axoId;
	}

	public void setAxoId(int axoId) {
		this.axoId = axoId;
	}

	public String getAxoName() {
		return axoName;
	}

	public void setAxoName(String axoName) {
		this.axoName = axoName;
	}
	

}
