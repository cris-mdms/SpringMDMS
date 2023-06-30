/* Model class – PRS Coach Type Table
Developer – Anshul ,28/12/2020
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
@Table(name="m_coach_type_prs", schema="mdms_coach")

public class MCoachTypePrs {
	
	@Id
	@Column(name="s_no")
	private Long sr_no;
	
	@Column(name="coach_code")
	private String coach_code;
	
	@Column(name="prs_class")
	private String prs_class;
	
	@Column(name="total_accomodation")
	private String total_accomodation;
	
	@Column(name="composite_coach")
	private String composite_coach;
	
	@Column(name="double_decker")
	private String double_decker;

	
	
	
	public Long getSr_no() {
		return sr_no;
	}

	public void setSr_no(Long sr_no) {
		this.sr_no = sr_no;
	}

	public String getCoach_code() {
		return coach_code;
	}

	public void setCoach_code(String coach_code) {
		this.coach_code = coach_code;
	}

	public String getPrs_class() {
		return prs_class;
	}

	public void setPrs_class(String prs_class) {
		this.prs_class = prs_class;
	}

	public String getTotal_accomodation() {
		return total_accomodation;
	}

	public void setTotal_accomodation(String total_accomodation) {
		this.total_accomodation = total_accomodation;
	}

	public String getComposite_coach() {
		return composite_coach;
	}

	public void setComposite_coach(String composite_coach) {
		this.composite_coach = composite_coach;
	}

	public String getDouble_decker() {
		return double_decker;
	}

	public void setDouble_decker(String double_decker) {
		this.double_decker = double_decker;
	}




}
