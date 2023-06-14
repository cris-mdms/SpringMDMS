//Developed By: Anshu Sharma , Date 012/Oct/2020 

package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;


public interface ShowListOfMenuRightsRepository extends CrudRepository<UserProfileRegistrationDetailModel,String>{
	
	@Query(value="SELECT menu_id from mdms_app_mgmt.menu_rights where role_type=?1 and user_type=?2",nativeQuery=true)
	  List<Integer> getMenuRightsList(String role_type,String user_type);
	
	@Query(value="SELECT user_type from mdms_app_mgmt.user_profile_registration_detail where  user_id=?1",nativeQuery=true)
	  List<String> getUserType(String user_id);
	

}
