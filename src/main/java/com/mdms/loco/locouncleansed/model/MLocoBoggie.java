package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_loco_boggie",schema="mdms_loco")
public class MLocoBoggie {
	@Id
	@Column(name="boggie_type")
	private int boogieId;
	
	@Column(name="boggie_type_name")
	private String boogieName;

	public int getBoogieId() {
		return boogieId;
	}

	public void setBoogieId(int boogieId) {
		this.boogieId = boogieId;
	}

	public String getBoogieName() {
		return boogieName;
	}

	public void setBoogieName(String boogieName) {
		this.boogieName = boogieName;
	}
	
	

	
	
	
}
