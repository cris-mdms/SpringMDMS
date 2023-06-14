package com.mdms.mdms_masters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_department", schema="mdms_masters")
public class MDepartment {
	@Id
	@Column(name="dept_code")
	private String dept_code ;
	
	@Column(name="dept_name")
	private String dept_name ;

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	 

}
