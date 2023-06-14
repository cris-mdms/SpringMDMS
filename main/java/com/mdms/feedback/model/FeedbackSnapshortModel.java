package com.mdms.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="feedback_snapshort_master", schema="mdms_feedback")     /* Developed By: Ritu  */
public class FeedbackSnapshortModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")	
	private Long f_id;
	
	@Column(name="request_id")	
	private String request_id;
	
	@Column(name="docname")                  
	private String file_name;
	
	@Column(name="snapshort_doc")                  
	private byte[] snapshort_file;

	public Long getF_id() {
		return f_id;
	}

	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public byte[] getSnapshort_file() {
		return snapshort_file;
	}

	public void setSnapshort_file(byte[] snapshort_file) {
		this.snapshort_file = snapshort_file;
	}
	
	
	
	
	

}
