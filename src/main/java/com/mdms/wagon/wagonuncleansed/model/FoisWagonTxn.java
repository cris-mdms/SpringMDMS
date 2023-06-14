package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="fois_wagon_txn", schema="mdms_wagon")	
public class FoisWagonTxn {	
	@Id
	@Column(name="ROWID")
	String rowid;
	
	@Column(name="own_rly")
	private String  own_rly ;
	
	@Column(name="wagon_type")
	private String  wagon_type ;
	
	@Column(name="wagon_no")
	private String  wagon_no ;
	
	@Column(name="wagontest")
	private Integer  wagontest ;

	public String getOwn_rly() {
		return own_rly;
	}

	public void setOwn_rly(String own_rly) {
		this.own_rly = own_rly;
	}

	public String getWagon_type() {
		return wagon_type;
	}

	public void setWagon_type(String wagon_type) {
		this.wagon_type = wagon_type;
	}

	public String getWagon_no() {
		return wagon_no;
	}

	public void setWagon_no(String wagon_no) {
		this.wagon_no = wagon_no;
	}

	public Integer getWagontest() {
		return wagontest;
	}

	public void setWagontest(Integer wagontest) {
		this.wagontest = wagontest;
	}

	
	 
    
}
