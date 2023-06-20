package com.mdms.mdms_coach.coachuncleansed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_coach_class", schema = "mdms_coach")
public class MCoachClass {
	
	 String class_code ;
	 
	  String class_name;
	  
	  @Id
	  int class_index;

		public String getClass_code() {
			return class_code;
		}
	
		public void setClass_code(String class_code) {
			this.class_code = class_code;
		}
	
		public String getClass_name() {
			return class_name;
		}
	
		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}

		public int getClass_index() {
			return class_index;
		}

		
	  
}
