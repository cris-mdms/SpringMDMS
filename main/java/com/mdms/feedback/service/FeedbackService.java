package com.mdms.feedback.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.feedback.model.AssetsModel;
import com.mdms.feedback.model.FeedbackModel;
import com.mdms.feedback.model.FeedbackSnapshortModel;
import com.mdms.feedback.repository.AssetsRepository;
import com.mdms.feedback.repository.FeedbackRepository;
import com.mdms.feedback.repository.FeedbackSnapshortRepository;
@Service
public class FeedbackService {
	
	@Autowired
	private  FeedbackRepository obj_repo ;
	
	@Autowired
	private  AssetsRepository objAssetRepo ;
	
	@Autowired
	private FeedbackSnapshortRepository objSnapRepo;
	
	 Logger logger=LoggerFactory.getLogger(FeedbackService.class);
	public boolean savefeedback(FeedbackModel objClass)
	{
		try {
		if(obj_repo.save(objClass)!=null)
			return true;	
		}
		catch(Exception e){
			
			System.out.println(e);
			
			}
			return false;

}
	
	public List<AssetsModel> getAllAssetData(AssetsModel objAssetClass) {
		String assettype= objAssetClass.getAsset_name();
		objAssetRepo.findAllModule(assettype);
		List<AssetsModel> objAsset=new ArrayList<>();		
		objAssetRepo.findAllModule(assettype).forEach(objAsset::add);
		return objAssetRepo.findAllModule(assettype);
}
	
	public List<FeedbackModel>getAllData(FeedbackModel objFeedClass) {
		String senderid= objFeedClass.getSender_id();
		obj_repo.findAll(senderid);
		List<FeedbackModel> objFeed=new ArrayList<>();		
		obj_repo.findAll(senderid).forEach(objFeed::add);
		return obj_repo.findAll(senderid);
}
	
	public List<FeedbackModel>getfeedbackinbox(FeedbackModel objFeedinbox) {
		String assetownerid= objFeedinbox.getAsset_ownerid();
		obj_repo.findOwnerFeedback(assetownerid);
		List<FeedbackModel> objownerfeedback=new ArrayList<>();		
		obj_repo.findOwnerFeedback(assetownerid).forEach(objownerfeedback::add);
		return obj_repo.findOwnerFeedback(assetownerid);
}
	
	public List<FeedbackModel>getsuperuserfeedbackinbox(FeedbackModel objsuperuserFeedinbox) {
	    obj_repo.superuserfeedback();
		List<FeedbackModel> objownerfeedback=new ArrayList<>();		
		obj_repo.superuserfeedback().forEach(objownerfeedback::add);
		return obj_repo.superuserfeedback();
}
	
	public boolean updaterecord(FeedbackModel obj_updatestatus) {
		try{					
		String var1=obj_updatestatus.getRequest_status();
		Long rid=obj_updatestatus.getRequest_id();
		System.out.println(var1);
		System.out.println(rid);		
		obj_repo.updatestatus(var1, rid);
		return  true ;	
		}
		catch(Exception e){
			
			System.out.println(e);
			return false;
		}			
	}
	
	
	public boolean addsnapshort( FeedbackSnapshortModel objfeedbacksnapshort) {
		String rid = objfeedbacksnapshort.getRequest_id();
		System.out.println(rid);
	if(objSnapRepo.save(objfeedbacksnapshort) != null)			
					return true;				
				else return false;
			}
	
	
	
	
	public int getrequestid(FeedbackModel obj_requestid) {		
		try {
//		String at=obj_requestid.getAssetType();
	  return  obj_repo.getrequestid();
	    
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return 0;
		 
		
}
	

	public String getSnapfilename(FeedbackSnapshortModel objsnapshort) {
		String rid1= objsnapshort.getRequest_id();			
		String snapid= objSnapRepo.getfilename(rid1);
		return snapid;

		
}
	
	public int insertFeedbackReplyByAdmin(FeedbackModel modelObj) {
		System.out.println("reply inserting");
		System.out.println(modelObj.getReceiver_id());
		int insertResponse=	obj_repo.insertReplyByAdmin(modelObj.getRequest_title(),modelObj.getAsset_module(),modelObj.getRequest_status(),modelObj.getSender_id(),modelObj.getSender_name(),
				modelObj.getSender_designation(),modelObj.getAsset_ownerid(),modelObj.getAsset_type(),modelObj.getRequest_reply_id(),modelObj.getRequest_reply_comment(),modelObj.getReceiver_id());		
		logger.info("Service : FeedbackService|| Method: insertFeedbackReplyByAdmin || insertReplyByAdmin Query resonse: "+insertResponse);
		System.out.println(insertResponse );
		return insertResponse;
		
			
		}
	
	
	//get  reply 
	public List<FeedbackModel>getfeedbackReply(FeedbackModel obj_reply) {
		String receverid= obj_reply.getReceiver_id();
		obj_repo.getreplybyadmin(receverid);
		List<FeedbackModel> obj_replyfeedback=new ArrayList<>();		
		obj_repo.getreplybyadmin(receverid).forEach(obj_replyfeedback::add);
		return obj_repo.getreplybyadmin(receverid);
}
	
	//get reply count 
	public int getreplycount(FeedbackModel obj_replycount) {		
		try {
		int replyid=obj_replycount.getRequest_reply_id();
		System.out.println(replyid);
	  return  obj_repo.getcountreply(replyid);
	    
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return 0;
		 
		
}

}
