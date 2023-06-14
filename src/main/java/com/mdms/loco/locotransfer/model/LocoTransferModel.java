package com.mdms.loco.locotransfer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity()
@Table(name="loco_transfer_detail", schema="mdms_loco")
public class LocoTransferModel {
	@Id	
	@Column(name="loco_no")                  
	private int loco_No; 
	
	@Column(name="loco_new_shed")                  
	public String loco_new_shed; 
	
	@Column(name="loco_new_zone")                  
	private String loco_new_zone; 
	
	@Column(name="loco_old_shed")                  
	public String loco_old_shed;
	
	@Column(name="loco_old_zone")                  
	private String loco_old_zone; 
	
	@Column(name="loco_traction_code")                  
	private String loco_traction_code;
	
	@Column(name="loco_transfer_letter_no") 
	private String loco_transfer_letter_no;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	@Column(name="loco_transfer_date")                  
	private Date loco_transfer_date;
	
	@Column(name="remarks")                  
	private String remarks;
	
	@Column(name="transfer_by")                  
	private String transfer_by;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	@Column(name="data_entry_date")                  
	private Date data_entry_date;
	
	@Column(name="status")                  
	private String status;

	@Column(name="loco_new_division")                  
	private String loco_new_division;
	
	
	@Column(name="count_no_of_update")                  
	private int count_no_of_update;
	
	@Column(name="loco_table_name")                  
	private String loco_table_name;
	
	private String reject_remarks;
	
	private String reject_user_id;
	
	private Date reject_txn_time;
	
	private String accept_remarks;
	
	private String accept_user_id;
	
	private Date accept_txn_time;
	
	public int getLoco_No() {
		return loco_No;
	}
	public void setLoco_No(int loco_No) {
		this.loco_No = loco_No;
	}
	public String getLoco_new_shed() {
		return loco_new_shed;
	}
	public void setLoco_new_shed(String loco_new_shed) {
		this.loco_new_shed = loco_new_shed;
	}
	public String getLoco_new_zone() {
		return loco_new_zone;
	}
	public void setLoco_new_zone(String loco_new_zone) {
		this.loco_new_zone = loco_new_zone;
	}
	public String getLoco_old_shed() {
		return loco_old_shed;
	}
	public void setLoco_old_shed(String loco_old_shed) {
		this.loco_old_shed = loco_old_shed;
	}
	public String getLoco_old_zone() {
		return loco_old_zone;
	}
	public void setLoco_old_zone(String loco_old_zone) {
		this.loco_old_zone = loco_old_zone;
	}
	
	public String getLoco_traction_code() {
		return loco_traction_code;
	}
	public void setLoco_traction_code(String loco_traction_code) {
		this.loco_traction_code = loco_traction_code;
	}
	public String getLoco_transfer_letter_no() {
		return loco_transfer_letter_no;
	}
	public void setLoco_transfer_letter_no(String loco_transfer_letter_no) {
		this.loco_transfer_letter_no = loco_transfer_letter_no;
	}
	public Date getLoco_transfer_date() {
		return loco_transfer_date;
	}
	public void setLoco_transfer_date(Date loco_transfer_date) {
		this.loco_transfer_date = loco_transfer_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTransfer_by() {
		return transfer_by;
	}
	public void setTransfer_by(String transfer_by) {
		this.transfer_by = transfer_by;
	}
	public Date getData_entry_date() {
		return data_entry_date;
	}
	public void setData_entry_date(Date data_entry_date) {
		this.data_entry_date = data_entry_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoco_new_division() {
		return loco_new_division;
	}
	public void setLoco_new_division(String loco_new_division) {
		this.loco_new_division = loco_new_division;
	}
	public int getCount_no_of_update() {
		return count_no_of_update;
	}
	public void setCount_no_of_update(int count_no_of_update) {
		this.count_no_of_update = count_no_of_update;
	}
	public String getLoco_table_name() {
		return loco_table_name;
	}
	public void setLoco_table_name(String loco_table_name) {
		this.loco_table_name = loco_table_name;
	}
	public String getReject_remarks() {
		return reject_remarks;
	}
	public void setReject_remarks(String reject_remarks) {
		this.reject_remarks = reject_remarks;
	}
	public String getReject_user_id() {
		return reject_user_id;
	}
	public void setReject_user_id(String reject_user_id) {
		this.reject_user_id = reject_user_id;
	}
	public Date getReject_txn_time() {
		return reject_txn_time;
	}
	public void setReject_txn_time(Date reject_txn_time) {
		this.reject_txn_time = reject_txn_time;
	}
	public String getAccept_remarks() {
		return accept_remarks;
	}
	public void setAccept_remarks(String accept_remarks) {
		this.accept_remarks = accept_remarks;
	}
	public String getAccept_user_id() {
		return accept_user_id;
	}
	public void setAccept_user_id(String accept_user_id) {
		this.accept_user_id = accept_user_id;
	}
	public Date getAccept_txn_time() {
		return accept_txn_time;
	}
	public void setAccept_txn_time(Date accept_txn_time) {
		this.accept_txn_time = accept_txn_time;
	}
	
	
	
	
}
