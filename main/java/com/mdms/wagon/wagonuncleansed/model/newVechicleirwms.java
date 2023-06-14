package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="wagon_data_irwms", schema="mdms_wagon")
public class newVechicleirwms {

	@Id
	@Column(name="vehicletype")
	private String vehicletype;

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
}
