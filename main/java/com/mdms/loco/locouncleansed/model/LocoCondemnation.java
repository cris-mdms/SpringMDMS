package com.mdms.loco.locouncleansed.model;


import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loco_condemnation_mdms_user", schema = "mdms_loco")
public class LocoCondemnation {

	  @Id
	  int loco_no;
	    
	  String  loco_type ;
	  
	  String  loco_owning_shed_code ;
	  
	  String loco_owning_zone_code;
	  
	  String  loco_permanent_domain;
	  
	  String  traction_code;
	 
	  Date loco_commissiong_date;
	  
	  Date  loco_manufacturing_date ;
	  
	  Double loco_life;
	 
	  String proposal_letter_no;
	  
	  Date condemnation_date;
	 
	  String  condemnation_proposal_type;
	  
	  String proposal_doc;
	  
	  String approved_letter_no;
	  
	  String approval_doc;
	
	  String user_id;

	  String status;
	  
	  String remarks;
	  
	  LocalDateTime txn_date ;
	  

	public int getLoco_no() {
		return loco_no;
	}

	public void setLoco_no(int loco_no) {
		this.loco_no = loco_no;
	}

	public String getLoco_type() {
		return loco_type;
	}

	public void setLoco_type(String loco_type) {
		this.loco_type = loco_type;
	}

	public String getLoco_owning_shed_code() {
		return loco_owning_shed_code;
	}

	public void setLoco_owning_shed_code(String loco_owning_shed_code) {
		this.loco_owning_shed_code = loco_owning_shed_code;
	}

	public String getLoco_owning_zone_code() {
		return loco_owning_zone_code;
	}

	public void setLoco_owning_zone_code(String loco_owning_zone_code) {
		this.loco_owning_zone_code = loco_owning_zone_code;
	}

	public String getLoco_permanent_domain() {
		return loco_permanent_domain;
	}

	public void setLoco_permanent_domain(String loco_permanent_domain) {
		this.loco_permanent_domain = loco_permanent_domain;
	}

	public String getTraction_code() {
		return traction_code;
	}

	public void setTraction_code(String traction_code) {
		this.traction_code = traction_code;
	}

	public Date getLoco_commissiong_date() {
		return loco_commissiong_date;
	}

	public void setLoco_commissiong_date(Date loco_commissiong_date) {
		this.loco_commissiong_date = loco_commissiong_date;
	}

	public Date getLoco_manufacturing_date() {
		return loco_manufacturing_date;
	}

	public void setLoco_manufacturing_date(Date loco_manufacturing_date) {
		this.loco_manufacturing_date = loco_manufacturing_date;
	}

	public Double getLoco_life() {
		return loco_life;
	}

	public void setLoco_life(Double loco_life) {
		this.loco_life = loco_life;
	}



	public Date getCondemnation_date() {
		return condemnation_date;
	}

	public void setCondemnation_date(Date condemnation_date) {
		this.condemnation_date = condemnation_date;
	}

	public String getCondemnation_proposal_type() {
		return condemnation_proposal_type;
	}

	public void setCondemnation_proposal_type(String condemnation_proposal_type) {
		this.condemnation_proposal_type = condemnation_proposal_type;
	}



	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(LocalDateTime txn_date) {
		this.txn_date = txn_date;
	}

	public String getProposal_letter_no() {
		return proposal_letter_no;
	}

	public void setProposal_letter_no(String proposal_letter_no) {
		this.proposal_letter_no = proposal_letter_no;
	}

	public String getProposal_doc() {
		return proposal_doc;
	}

	public void setProposal_doc(String proposal_doc) {
		this.proposal_doc = proposal_doc;
	}

	public String getApproved_letter_no() {
		return approved_letter_no;
	}

	public void setApproved_letter_no(String approved_letter_no) {
		this.approved_letter_no = approved_letter_no;
	}

	public String getApproval_doc() {
		return approval_doc;
	}

	public void setApproval_doc(String approval_doc) {
		this.approval_doc = approval_doc;
	}

	




	  
}
