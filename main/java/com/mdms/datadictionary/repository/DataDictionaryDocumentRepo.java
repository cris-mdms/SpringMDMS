package com.mdms.datadictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.datadictionary.model.DataDictionaryDocumentModel;


public interface DataDictionaryDocumentRepo extends CrudRepository<DataDictionaryDocumentModel,String> {	
	@Query(value = "SELECT * FROM mdms_data_dictionary.data_dictionary_document where asset_name=?1", nativeQuery = true)
	List<DataDictionaryDocumentModel> getAssetDetail(String assetName);

}
