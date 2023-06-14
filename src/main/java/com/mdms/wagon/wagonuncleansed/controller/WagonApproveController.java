/*This controller provides all services for save and get golden record from wagon_cleansed_data.
 * Created By : Ritu, 19-07-2021
 * 
 */

package com.mdms.wagon.wagonuncleansed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.wagon.wagonuncleansed.model.WagonCleansedData;
import com.mdms.wagon.wagonuncleansed.service.WagonApproveService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonApproveController {
	@Autowired
	private WagonApproveService obj_approve;
	
	 	@RequestMapping(method=RequestMethod.POST, value="/addWagonGoldenRecord")
	 		public boolean addwagonapproveddata(@RequestBody WagonCleansedData obj_approveclass) {	 	 		
	 		boolean flag= obj_approve.addwagonapproveddata(obj_approveclass);
	 				return flag;		 		}
	 	
}
