
package com.mdms.datadictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.datadictionary.model.DataDictionaryDocumentModel;
import com.mdms.datadictionary.service.DataDictionaryService;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class DataDictionaryDocumentController {
	@Autowired
	private DataDictionaryService dataDictionaryDocumentService;
	
//	 @RequestMapping(method=RequestMethod.POST, value="/assetDetail")
//	public List<DataDictionaryDocumentModel> getAssetData(@RequestBody DataDictionaryDocumentModel dataDictionaryDocumentModel){
//		
//		List<DataDictionaryDocumentModel> listt = dataDictionaryDocumentService.findDataDictionaryDocument(dataDictionaryDocumentModel.getAssetName());
//		return listt;
//	 }
}

/*
 * package com.mdms.datadictionary.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.mdms.datadictionary.model.DataDictionaryDocumentModel; import
 * com.mdms.datadictionary.service.DataDictionaryDocumentService;
 * 
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("datadictionarydocument") public class
 * DataDictionaryDocumentController {
 * 
 * //need to delete
 * 
 * @Autowired private DataDictionaryDocumentService
 * dataDictionaryDocumentService;
 * 
 * @RequestMapping(method=RequestMethod.POST, value="/assetDetail") public
 * List<DataDictionaryDocumentModel> getAssetData(@RequestBody
 * DataDictionaryDocumentModel dataDictionaryDocumentModel){
 * 
 * List<DataDictionaryDocumentModel> listt =
 * dataDictionaryDocumentService.findDataDictionaryDocument(
 * dataDictionaryDocumentModel.getAssetName()); return listt; }
 * 
 * }
 */

