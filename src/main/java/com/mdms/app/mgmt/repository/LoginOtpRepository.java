//Developed By: Anshu Sharma , Date 10/Oct/2020 

package com.mdms.app.mgmt.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mdms.app.mgmt.model.LoginOtpModel;
public interface LoginOtpRepository extends CrudRepository<LoginOtpModel,String>{	
	@Procedure(value=" mdms_app_mgmt.f_get_otp")
	String getOtp(@Param("p_userid") String p_userid);		
		@Query(value="SELECT * FROM mdms_app_mgmt.user_otp_detail\r\n" + 
				"WHERE user_id = ?1 AND  otp=?2 AND current_date BETWEEN valid_from AND valid_to",nativeQuery=true)
	  List<LoginOtpModel> verifyOtp(String user_id,Integer otp);

}
