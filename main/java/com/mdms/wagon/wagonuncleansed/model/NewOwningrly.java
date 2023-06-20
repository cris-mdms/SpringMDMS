package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="wagon_data_irwms", schema="mdms_wagon")
public class NewOwningrly {
	
	@Id
	@Column(name="owningrly")
	private String owningrly;

	public String getOwningrly() {
		return owningrly;
	}

	public void setOwningrly(String owningrly) {
		this.owningrly = owningrly;
	}

}
