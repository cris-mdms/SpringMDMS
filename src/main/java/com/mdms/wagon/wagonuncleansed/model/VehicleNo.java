package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="wagon_data_irwms", schema="mdms_wagon")
public class VehicleNo {
    
	@Id
	@Column(name="vehicleno")
	private Long vehicleno;

	public Long getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(Long vehicleno) {
		this.vehicleno = vehicleno;
	}
	
}
