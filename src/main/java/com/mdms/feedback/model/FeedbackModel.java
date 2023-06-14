package com.mdms.feedback.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name="feedback_master", schema="mdms_feedback")     /* Developer: Ritu */
public class FeedbackModel {	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="request_id")	
	private Long request_id;
	
	@Column(name="request_type")
	private String request_type;
	
	@Column(name="request_description")
	private String request_description;
	
	@Column(name="request_title")
	private String request_title;
	
	@Column(name="priority")
	private String request_priority;
	
	@Column(name="request_date")
	private Date request_date;
	
	@Column(name="asset_type")
	private String asset_type;
	
	
	@Column(name="asset_module")
	private String asset_module;
	
	@Column(name="status")
	private String request_status;
	
	@Column(name="sender_id")
	private String sender_id;
	
	@Column(name="sender_name")
	private String sender_name;
	
	@Column(name="sender_designation")
	private String sender_designation;
	
	@Column(name="sender_zone")
	private String sender_zone;
	
	@Column(name="sender_division")
	private String sender_division;
	
	@Column(name="sender_shed")
	private String sender_shed;
	
	@Column(name="sender_mobileno")
	private String sender_mobileno;
	
	@Column(name="asset_owner_id")
	private String asset_ownerid;
	
	@Column(name="request_reply_id")
	private Integer request_reply_id;
	
	@Column(name="request_reply_comment")
	private String request_reply_comment;

	@Column(name="reply_to")
	private String receiver_id;

	public Long getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getRequest_description() {
		return request_description;
	}

	public void setRequest_description(String request_description) {
		this.request_description = request_description;
	}

	public String getRequest_title() {
		return request_title;
	}

	public void setRequest_title(String request_title) {
		this.request_title = request_title;
	}

	public String getRequest_priority() {
		return request_priority;
	}

	public void setRequest_priority(String request_priority) {
		this.request_priority = request_priority;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	public String getAsset_module() {
		return asset_module;
	}

	public void setAsset_module(String asset_module) {
		this.asset_module = asset_module;
	}

	public String getRequest_status() {
		return request_status;
	}

	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getSender_designation() {
		return sender_designation;
	}

	public void setSender_designation(String sender_designation) {
		this.sender_designation = sender_designation;
	}

	public String getSender_zone() {
		return sender_zone;
	}

	public void setSender_zone(String sender_zone) {
		this.sender_zone = sender_zone;
	}

	public String getSender_division() {
		return sender_division;
	}

	public void setSender_division(String sender_division) {
		this.sender_division = sender_division;
	}

	public String getSender_shed() {
		return sender_shed;
	}

	public void setSender_shed(String sender_shed) {
		this.sender_shed = sender_shed;
	}

	public String getSender_mobileno() {
		return sender_mobileno;
	}

	public void setSender_mobileno(String sender_mobileno) {
		this.sender_mobileno = sender_mobileno;
	}

	public String getAsset_ownerid() {
		return asset_ownerid;
	}

	public void setAsset_ownerid(String asset_ownerid) {
		this.asset_ownerid = asset_ownerid;
	}

	public Integer getRequest_reply_id() {
		return request_reply_id;
	}

	public void setRequest_reply_id(Integer request_reply_id) {
		this.request_reply_id = request_reply_id;
	}

	public String getRequest_reply_comment() {
		return request_reply_comment;
	}

	public void setRequest_reply_comment(String request_reply_comment) {
		this.request_reply_comment = request_reply_comment;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	
	
	

}
