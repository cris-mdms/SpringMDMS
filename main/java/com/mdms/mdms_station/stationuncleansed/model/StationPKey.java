package com.mdms.mdms_station.stationuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class StationPKey implements Serializable{
	
	public StationPKey ()
	{
					
	}
	
	
	@Column(name="station_code")
	private String station_code;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST") 
	@Column(name="station_valid_from")
	private  Date station_valid_from ;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST") 
	@Column(name="station_valid_upto")
	private  Date station_valid_upto ;
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public Date getStation_valid_from() {
		return station_valid_from;
	}
	public void setStation_valid_from(Date station_valid_from) {
		this.station_valid_from = station_valid_from;
	}
	public Date getStation_valid_upto() {
		return station_valid_upto;
	}
	public void setStation_valid_upto(Date station_valid_upto) {
		this.station_valid_upto = station_valid_upto;
	}
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof StationPKey)) return false;
	        StationPKey that = (StationPKey) o;
	        return Objects.equals(getStation_code(), that.getStation_code()) &&
	                Objects.equals(getStation_valid_from(), that.getStation_valid_from()) &&
	                		 Objects.equals(getStation_valid_upto(), that.getStation_valid_upto());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getStation_code(), getStation_valid_from(),getStation_valid_upto());
	    }
}
