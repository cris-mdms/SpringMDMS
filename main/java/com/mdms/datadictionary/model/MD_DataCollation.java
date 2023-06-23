package com.mdms.datadictionary.model;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "md_data_collation" , schema = "mdms_data_dictionary")
public class MD_DataCollation {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
	
	    String attribute_name;
	    
	    String mdms_attribute;
	   
	    String datatype ;
	   
	    int length;
	    
	    String constraints;
	    
	    @Column( name = "defaultvalue")
	    String defaultvalue;
	 
	    
	    String description;
	    
	    String mode_of_entry;
	    
	    String workflow_type ;
	    
	    String designation_of_approver;
	  
	    String department_of_approver;
	    
	    String level_of_approver ;
	    String designation_of_dataentry ;
	    
	    String department_of_dataentry ;
	    
	    String level_of_dataentry ;
	    
	    String type_of_operation ;
	    

		String primary_source_of_data ;
	    
	    String type_of_consumption ;
	    
	    Date date_of_capturing ;
	    
	    String letter_no ;
	    
	    Date date_of_letter;
	    
	    String entity_group ;
	    
	//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd:hh-mm-ss")  
	    LocalDateTime insert_date ;
	    
	    String user_id ;
	    
	    boolean attribute_exists;

	    
	    
	    
		public String getMdms_attribute() {
			return mdms_attribute;
		}

		public void setMdms_attribute(String mdms_attribute) {
			this.mdms_attribute = mdms_attribute;
		}

		public int getId() {
			return id;
		}

		public String getAttribute_name() {
			return attribute_name;
		}

		public void setAttribute_name(String attribute_name) {
			this.attribute_name = attribute_name;
		}

		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public String getConstraints() {
			return constraints;
		}

		public void setConstraints(String constraints) {
			this.constraints = constraints;
		}

		public String getDefaultvalue() {
			return defaultvalue;
		}

		public void setDefaultvalue(String defaultValue) {
			this.defaultvalue = defaultValue;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getMode_of_entry() {
			return mode_of_entry;
		}

		public void setMode_of_entry(String mode_of_entry) {
			this.mode_of_entry = mode_of_entry;
		}

		public String getWorkflow_type() {
			return workflow_type;
		}


		public void setWorkflow_type(String workflow_type) {
			this.workflow_type = workflow_type;
		}

		public String getDesignation_of_approver() {
			return designation_of_approver;
		}

		public void setDesignation_of_approver(String designation_of_approver) {
			this.designation_of_approver = designation_of_approver;
		}

		public String getDepartment_of_approver() {
			return department_of_approver;
		}

		public void setDepartment_of_approver(String department_of_approver) {
			this.department_of_approver = department_of_approver;
		}

		public String getLevel_of_approver() {
			return level_of_approver;
		}

		public void setLevel_of_approver(String level_of_approver) {
			this.level_of_approver = level_of_approver;
		}

		public String getDesignation_of_dataentry() {
			return designation_of_dataentry;
		}

		public void setDesignation_of_dataentry(String designation_of_dataentry) {
			this.designation_of_dataentry = designation_of_dataentry;
		}

		public String getDepartment_of_dataentry() {
			return department_of_dataentry;
		}

		public void setDepartment_of_dataentry(String department_of_dataentry) {
			this.department_of_dataentry = department_of_dataentry;
		}

		public String getLevel_of_dataentry() {
			return level_of_dataentry;
		}

		public void setLevel_of_dataentry(String level_of_dataentry) {
			this.level_of_dataentry = level_of_dataentry;
		}

		public String getType_of_operation() {
			return type_of_operation;
		}

		public void setType_of_operation(String type_of_operation) {
			this.type_of_operation = type_of_operation;
		}

		public String getPrimary_source_of_data() {
			return primary_source_of_data;
		}

		public void setPrimary_source_of_data(String primary_source_of_data) {
			this.primary_source_of_data = primary_source_of_data;
		}

		public String getType_of_consumption() {
			return type_of_consumption;
		}

		public void setType_of_consumption(String type_of_consumption) {
			this.type_of_consumption = type_of_consumption;
		}

		public Date getDate_of_capturing() {
			return date_of_capturing;
		}

		public void setDate_of_capturing(Date date_of_capturing) {
			this.date_of_capturing = date_of_capturing;
		}

		public String getLetter_no() {
			return letter_no;
		}

		public void setLetter_no(String letter_no) {
			this.letter_no = letter_no;
		}

		public Date getDate_of_letter() {
			return date_of_letter;
		}

		public void setDate_of_letter(Date date_of_letter) {
			this.date_of_letter = date_of_letter;
		}

		public String getEntity_group() {
			return entity_group;
		}

		public void setInsert_date(LocalDateTime timestamp) {
			this.insert_date = timestamp;
		}

		public void setEntity_group(String entity_group) {
			this.entity_group = entity_group;
		}

		public LocalDateTime getInsert_date() {
			return insert_date;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public boolean isAttribute_exists() {
			return attribute_exists;
		}

		public void setAttribute_exists(boolean attribute_exists) {
			this.attribute_exists = attribute_exists;
		}
	    
	    
	    

}
