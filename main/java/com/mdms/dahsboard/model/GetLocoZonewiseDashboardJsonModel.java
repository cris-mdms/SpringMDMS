package com.mdms.dahsboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetLocoZonewiseDashboardJsonModel {
	
	public GetLocoZonewiseDashboardJsonModel(String loco_owningzone, int tot_count, int unclen, int dft,
			int pend, int appv) 
	
	{
		this.loco_owningzone=loco_owningzone;
		this.tot_count=tot_count;
		this.unclen=unclen;
		this.dft=dft;
		this.pend=pend;
		this.appv=appv;
	}

	
	public String loco_owningzone;
	
	
	
	public int tot_count;
	public int unclen;
	
	public int dft;
	public int pend;
	public int appv;
	
	public String getLoco_owningzone() {
		return loco_owningzone;
	}
	public void setLoco_owningzone(String loco_owningzone) {
		this.loco_owningzone = loco_owningzone;
	}
	public int getTot_count() {
		return tot_count;
	}
	public void setTot_count(int tot_count) {
		this.tot_count = tot_count;
	}
	public int getUnclen() {
		return unclen;
	}
	public void setUnclen(int unclen) {
		this.unclen = unclen;
	}
	public int getDft() {
		return dft;
	}
	public void setDft(int dft) {
		this.dft = dft;
	}
	public int getPend() {
		return pend;
	}
	public void setPend(int pend) {
		this.pend = pend;
	}
	public int getAppv() {
		return appv;
	}
	public void setAppv(int appv) {
		this.appv = appv;
	}
	
	


	
}
