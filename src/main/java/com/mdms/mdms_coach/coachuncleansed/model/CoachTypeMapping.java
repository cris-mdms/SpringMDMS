/* Model class – CMM Coach Type Mapping Table
Developer – Anshul ,30/12/2020
*/
package com.mdms.mdms_coach.coachuncleansed.model;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity()
@Table(name="coach_type_mapping", schema="mdms_coach")
public class CoachTypeMapping {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	
	@Column(name="cmm_coach_type")
	private String cmm_coach_type;
	
	@Column(name="prs_coach_type")
	private String prs_coach_type;
	
	
	@Column(name="capacity")
	private String capacity;

	@Column(name="coach_class")
	private String coach_class;
	
	@Column(name="coach_type_description")
	private String coach_type_description;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="status")
	private String status;
	
	

	public int getSno() {
		return sno;
	}

	public String getCmm_coach_type() {
		return cmm_coach_type;
	}

	public void setCmm_coach_type(String cmm_coach_type) {
		this.cmm_coach_type = cmm_coach_type;
	}

	public String getPrs_coach_type() {
		return prs_coach_type;
	}

	public void setPrs_coach_type(String prs_coach_type) {
		this.prs_coach_type = prs_coach_type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCoach_type_description() {
		return coach_type_description;
	}

	public void setCoach_type_description(String coach_type_description) {
		this.coach_type_description = coach_type_description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getCoach_class() {
		return coach_class;
	}

	public void setCoach_class(String coach_class) {
		this.coach_class = coach_class;
	}
	
	

}
