package com.mdms.datadictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class publishedToMdmdModel {	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="s_no")	
	private Long s_no;
	
	@Column(name="attribute_name")
	private String attribute_name;
	
	@Column(name="asset_name")
	private String asset_name;
	
	private String subscriber;
	
	private String publisher;

	public publishedToMdmdModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public publishedToMdmdModel(Long s_no, String attribute_name, String subscriber, String publisher) {
		super();
		this.s_no=s_no;
		this.attribute_name = attribute_name;
		this.subscriber = subscriber;
		this.publisher = publisher;
	}

	public Long getS_no() {
		return s_no;
	}

	public void setS_no(Long s_no) {
		this.s_no = s_no;
	}

	

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAsset_name() {
		return asset_name;
	}

	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}

	
	}
