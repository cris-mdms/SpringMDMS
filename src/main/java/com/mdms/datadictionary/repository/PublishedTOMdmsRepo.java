package com.mdms.datadictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.datadictionary.model.DataDictionaryDocumentModel;
import com.mdms.datadictionary.model.publishedToMdmdModel;


@Repository("publishedTOMdmsRepo")
public interface PublishedTOMdmsRepo extends CrudRepository<publishedToMdmdModel,String>  {
	@Query(value = "SELECT * FROM mdms_data_dictionary.publish_to_mdms where publisher=?1 and asset_name=?2", nativeQuery = true)
	List<publishedToMdmdModel> getPublishToMdms(String application_group_1 ,String asset_name);

	@Query(value = "SELECT * FROM mdms_data_dictionary.publish_to_mdms where subscriber=?1 and asset_name=?2", nativeQuery = true)
	List<publishedToMdmdModel> getSubscriberoMdms(String application_group_1, String asset_name);

}
