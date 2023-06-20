package com.mdms.feedback.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdms.feedback.model.AssetsModel;
import com.mdms.feedback.model.FeedbackModel;
import com.mdms.feedback.model.FeedbackSnapshortModel;
import com.mdms.feedback.repository.FeedbackSnapshortRepository;
import com.mdms.feedback.service.FeedbackService;


@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class FeedbackController {
Logger logger=LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackService obj_service;	
	
	@Autowired 
	private FeedbackSnapshortRepository obj_imagerepo;
	
	@RequestMapping(method=RequestMethod.POST,value="/savefeedback")
	public boolean adddata(@RequestBody FeedbackModel objclass) {
		System.out.println(objclass.getAsset_ownerid());
		System.out.println(objclass.getAsset_module());
		System.out.println(objclass.getRequest_id());
		System.out.println(objclass.getAsset_type());
		System.out.println(objclass.getRequest_description());
		boolean flag= obj_service.savefeedback(objclass);		
		return true;
		
			
	}
	
	
	 @RequestMapping(method=RequestMethod.POST,value="/getassetdata")
	 public List<AssetsModel> getassetdata(@RequestBody AssetsModel obj_asset){
		System.out.println("Asset Name"+ obj_asset.getAsset_name());
		return obj_service.getAllAssetData(obj_asset); 	
	}
	//service call to feedback data as per sender id 
	 @RequestMapping(method=RequestMethod.POST,value="/getfeedback")
	 public List<FeedbackModel> getfeedbackdata(@RequestBody FeedbackModel objclass){
		System.out.println("Sender ID"+ objclass.getSender_id());
		return obj_service.getAllData(objclass); 	
	}
	
	//service call to feedback data as per sender id 
		 @RequestMapping(method=RequestMethod.POST,value="/getfeedbackinbox")
		 public List<FeedbackModel> getfeedbackinbox(@RequestBody FeedbackModel objclass){
			System.out.println("Asset Owner ID"+ objclass.getAsset_ownerid());
			return obj_service.getfeedbackinbox(objclass); 	
		}
		 
		//service call to feedback data for super user as per sender id 
		 @RequestMapping(method=RequestMethod.POST,value="/getsuperuserfeedbackinbox")
		 public List<FeedbackModel> getsuperfeedbackinbox(@RequestBody FeedbackModel objsuperuserclass){
				return obj_service.getsuperuserfeedbackinbox(objsuperuserclass); 	
		}
		 
		//status update feedback - Developer - Ritu 04-07-2020	
			@RequestMapping(method=RequestMethod.POST, value="/updatefeedbackstatus")
			public boolean updatestatus(@RequestBody FeedbackModel obj_update) {
				System.out.println(obj_update.getRequest_status());
				System.out.println(obj_update.getRequest_id());		
						boolean flag=obj_service.updaterecord(obj_update);
							return flag;
					}
			
			@RequestMapping(method=RequestMethod.POST, value="/savefeedbacksnapshort")
			public boolean addproposal(@RequestParam("file") MultipartFile file, @RequestParam("feedbackproposal") String feedbackproposal) throws JSONException, JsonMappingException, IOException 
			{		FeedbackSnapshortModel feed=new ObjectMapper().readValue(feedbackproposal,FeedbackSnapshortModel.class);	
			feed.setSnapshort_file(file.getBytes());
			feed.setFile_name(file.getOriginalFilename());
				System.out.println("doc name"+feed.getFile_name());
				System.out.println("rid"+feed.getRequest_id());				
				boolean flag=obj_service.addsnapshort(feed);
					return flag;
					
			}
			
			//service call to get request id asset type wise -Developer-Ritu 14.8.2020
			@RequestMapping(method=RequestMethod.POST,value="/getrequestid")
			 public int  getrequestid(@RequestBody FeedbackModel obj_reqid){
//				System.out.println(obj_reqid.getAssetType());				
					return obj_service.getrequestid(obj_reqid);
			}
		
			//service call to get request id asset type wise -Developer-Ritu 14.8.2020
			@RequestMapping(method=RequestMethod.POST,value="/getsnapfilename")
			 public String  getfilename(@RequestBody FeedbackSnapshortModel objsnapshort){				
		System.out.println(objsnapshort.getRequest_id());				
					return obj_service.getSnapfilename(objsnapshort);
			}
			
			@RequestMapping(method=RequestMethod.POST, value="/addfeedbackreplydbyadmin")
			public String addFeedbackReplyByAdmin(@RequestParam("form1")  String form1) {
				
				FeedbackModel modelObj = null;
				try {
					modelObj = new ObjectMapper().readValue(form1,FeedbackModel.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}

					
				
			int response=obj_service.insertFeedbackReplyByAdmin(modelObj);
			logger.info("controller : FeedbackController || Method : addFeedbackReplyByAdmin || insertFeedbackReplyByAdmin query response: "+response);

			
		if(response==1) {
			
			
			return JSONObject.quote("Reply Inserted Successfully");
			
		}else {
			return JSONObject.quote("Reply did not insert");
		}
				
					}
			
			//service call to get reply as per receiver id 
			 @RequestMapping(method=RequestMethod.POST,value="/getreplybyadmin")
			 public List<FeedbackModel> getreply(@RequestBody FeedbackModel obj_reply){
				System.out.println("receiver ID"+ obj_reply.getReceiver_id());
				return obj_service.getfeedbackReply(obj_reply); 	
			}
			 
			//service call to get request id asset type wise -Developer-Ritu 14.8.2020
				@RequestMapping(method=RequestMethod.POST,value="/getreplycount")
				 public int  getreplycount(@RequestBody FeedbackModel obj_replycount){
//					System.out.println(obj_reqid.getAssetType());				
					int count=	obj_service.getreplycount(obj_replycount);
					System.out.println("total reply"+count);
					return count;
					
				}


	
	
}
