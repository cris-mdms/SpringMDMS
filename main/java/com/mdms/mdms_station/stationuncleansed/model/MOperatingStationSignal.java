package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_operating_station_signal", schema="mdms_station")
public class MOperatingStationSignal {

	@Id
	@Column(name="operating_signal_code")
	private String operating_signal_code;
	
	
	@Column(name="description")
	private String description;


	public String getOperating_signal_code() {
		return operating_signal_code;
	}


	public void setOperating_signal_code(String operating_signal_code) {
		this.operating_signal_code = operating_signal_code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
