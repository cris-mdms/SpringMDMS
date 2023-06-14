package com.mdms.app.mgmt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.OldUserDetailModel;


public interface OldUserDetailRepository extends CrudRepository<OldUserDetailModel,Long> {
	

	@Query(value="SELECT * from mdms_app_mgmt.old_user_detail WHERE old_user_id=?1 AND user_flag='N'",nativeQuery=true)
	 List<OldUserDetailModel> checkuserexistinoldregsitration(String olduser_id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.old_user_detail set user_flag='Y' where old_user_id=?1",nativeQuery=true)
	int updateFlag(String olduserId);
	
}
