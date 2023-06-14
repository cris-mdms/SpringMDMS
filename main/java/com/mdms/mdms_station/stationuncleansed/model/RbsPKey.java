package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;
@Embeddable

public class RbsPKey implements Serializable{
	
	public RbsPKey() {
		
	}
	
	@Column(name="stn_code")
	private String stn_code;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	@Column(name="stn_vld_from")
	private  Date stn_vld_from ;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	@Column(name="stn_vld_upto")
	private  Date stn_vld_upto ;

	public String getStn_code() {
		return stn_code;
	}

	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}

	public Date getStn_vld_from() {
		return stn_vld_from;
	}

	public void setStn_vld_from(Date stn_vld_from) {
		this.stn_vld_from = stn_vld_from;
	}

	public Date getStn_vld_upto() {
		return stn_vld_upto;
	}

	public void setStn_vld_upto(Date stn_vld_upto) {
		this.stn_vld_upto = stn_vld_upto;
	}
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof RbsPKey)) return false;
	        RbsPKey that = (RbsPKey) o;
	        return Objects.equals(getStn_code(), that.getStn_code()) &&
	                Objects.equals(getStn_vld_from(), that.getStn_vld_from()) &&
	                		 Objects.equals(getStn_vld_upto(), that.getStn_vld_upto());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getStn_code(), getStn_vld_from(),getStn_vld_upto());
	    }

	
	
}
