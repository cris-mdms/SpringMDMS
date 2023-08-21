package com.mdms.dahsboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class StationHomeDashboard {
	
	@Id
	String total;
	String uncleansed;
	String uncleansed_cmi;
	String uncleansed_dti;
	String nt_ini_cmi;
	String nt_ini_dti;
	String pending_dti ;
	String pending_cmi;
	String reject_cmi;
	String reject_dti;
	String drfat_cmi;
	String draft_dti;
	String cleansed;
	String clean_dti;
	String clean_cmi;
	String not_initiated ;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getUncleansed() {
		return uncleansed;
	}
	public void setUncleansed(String uncleansed) {
		this.uncleansed = uncleansed;
	}
	public String getPending_dti() {
		return pending_dti;
	}
	public void setPending_dti(String pending_dti) {
		this.pending_dti = pending_dti;
	}
	public String getPending_cmi() {
		return pending_cmi;
	}
	public void setPending_cmi(String pending_cmi) {
		this.pending_cmi = pending_cmi;
	}
	public String getReject_cmi() {
		return reject_cmi;
	}
	public void setReject_cmi(String reject_cmi) {
		this.reject_cmi = reject_cmi;
	}
	public String getReject_dti() {
		return reject_dti;
	}
	public void setReject_dti(String reject_dti) {
		this.reject_dti = reject_dti;
	}
	public String getDrfat_cmi() {
		return drfat_cmi;
	}
	public void setDrfat_cmi(String drfat_cmi) {
		this.drfat_cmi = drfat_cmi;
	}
	public String getDraft_dti() {
		return draft_dti;
	}
	public void setDraft_dti(String draft_dti) {
		this.draft_dti = draft_dti;
	}
	public String getClean_dti() {
		return clean_dti;
	}
	public void setClean_dti(String clean_dti) {
		this.clean_dti = clean_dti;
	}
	public String getClean_cmi() {
		return clean_cmi;
	}
	public void setClean_cmi(String clean_cmi) {
		this.clean_cmi = clean_cmi;
	}
	public String getNot_initiated() {
		return not_initiated;
	}
	public void setNot_initiated(String not_initiated) {
		this.not_initiated = not_initiated;
	}
	public String getNt_ini_cmi() {
		return nt_ini_cmi;
	}
	public void setNt_ini_cmi(String nt_ini_cmi) {
		this.nt_ini_cmi = nt_ini_cmi;
	}
	public String getNt_ini_dti() {
		return nt_ini_dti;
	}
	public void setNt_ini_dti(String nt_ini_dti) {
		this.nt_ini_dti = nt_ini_dti;
	}
	public String getUncleansed_cmi() {
		return uncleansed_cmi;
	}
	public void setUncleansed_cmi(String uncleansed_cmi) {
		this.uncleansed_cmi = uncleansed_cmi;
	}
	public String getUncleansed_dti() {
		return uncleansed_dti;
	}
	public void setUncleansed_dti(String uncleansed_dti) {
		this.uncleansed_dti = uncleansed_dti;
	}
	public String getCleansed() {
		return cleansed;
	}
	public void setCleansed(String cleansed) {
		this.cleansed = cleansed;
	}
	

}
