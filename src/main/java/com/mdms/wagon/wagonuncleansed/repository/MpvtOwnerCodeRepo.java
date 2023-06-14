package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MpvtOwnerPartyFoisModel;


public interface MpvtOwnerCodeRepo extends CrudRepository<MpvtOwnerPartyFoisModel,String>{
	
	@Query(value="SELECT * FROM mdms_wagon.m_pvtowner_partycode_fois;", nativeQuery=true)
	List<MpvtOwnerPartyFoisModel> getMpvtownerPartyCodeFois();

}
