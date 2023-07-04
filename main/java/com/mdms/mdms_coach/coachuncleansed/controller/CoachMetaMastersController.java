/*This controller provides all Station Meta Masters .
 * Gauge,Gis,Interlocking,Operating_signal,Category,Station Class,Interchange Junction,Status,Traction,Traffic Type
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_coach.coachuncleansed.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.mdms_coach.coachuncleansed.model.CMMTypeLayout;
import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachClass;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachTypePrs;
import com.mdms.mdms_coach.coachuncleansed.model.PRSTypeLayout;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoach_class_Repo;
import com.mdms.mdms_coach.coachuncleansed.service.CoachMetaMastersService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class CoachMetaMastersController {

	@Autowired
	private CoachMetaMastersService coach_meta_serv;
	
	@Autowired
	private MCoach_class_Repo coach_class;


    Logger logger=LoggerFactory.getLogger(CoachMetaMastersController.class);

	@RequestMapping(method=RequestMethod.GET, value="/coachmaster")
	public MCoachType getCoachTypeDetails(@RequestParam (value="coachtype") String coachtype){
		return coach_meta_serv.getCoachTypeDetails(coachtype);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/coachtype")
	public List<String> getCoachTypes(){
		return coach_meta_serv.getCoachTypes();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coachtypecmm")
	public List<String> getCoachTypesCmm(){
		return coach_meta_serv.getCoachTypesCmm();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/cmmtypelayout")
	public List<String> getCoachTypesCmmLayout(){
		return coach_meta_serv.getCoachTypesCmmLayout();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/prstypelayout")
	public List<String> getCoachTypesPrsLayout(){
		return coach_meta_serv.getCoachTypesPrsLayout();
	}

	@RequestMapping(method=RequestMethod.POST, value="/coachdepot")
	public List<String> getCoachDepot(){
		return coach_meta_serv.getCoachDepot();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coachcategory")
	public List<String> getCoachCategory(){
		return coach_meta_serv.getCoachCategory();
	}
		@RequestMapping(method=RequestMethod.POST, value="/coachCouplingTpe")
		public List<String> getCoachCouplingTpe(){
			return coach_meta_serv.getCoachCouplingTpe();
	}
	
		@RequestMapping(method=RequestMethod.POST, value="/fitnesType")
		public List<String> getFitnessType(){
			return coach_meta_serv.getFitnessType();
	}
		@RequestMapping(method=RequestMethod.POST, value="/powerGenType")
		public List<String> getPowerGenType(){
			return coach_meta_serv.getPowerGenType();
	}
		
		@RequestMapping(method=RequestMethod.POST, value="/brakeType")
		public List<String> getBrakeType(){
			return coach_meta_serv.getBrakeType();
	}
		
		@RequestMapping(method=RequestMethod.POST, value="/mfgType")
		public List<String> getMfgType(){
			return coach_meta_serv.getMfgType();
	}
		
		@RequestMapping(method=RequestMethod.POST, value="/coachtypeprs")
		public List<String> getCoachTypesPrs(){
			return coach_meta_serv.getCoachTypesPrs();
		}
		
//		@RequestMapping(method=RequestMethod.POST, value="/coachtypeprsdata")
//		public List<MCoachTypePrs> getCoachTypesPrsData(@RequestBody String obj){		
//			System.out.println("coachcode"+obj);
//			coach_meta_serv.getCoachTypesPrsData(obj);
//			return coach_meta_serv.getCoachTypesPrsData(obj);
//		}
		@RequestMapping(method=RequestMethod.POST, value="/coachtypeprsdata")
		public List<MCoachTypePrs> getlocotypedata(@RequestBody MCoachTypePrs unlocotype){		 
		 System.out.println( "controller" + unlocotype.getCoach_code());
		 coach_meta_serv.getCoachTypesPrsData(unlocotype);
				System.out.println(coach_meta_serv.getCoachTypesPrsData(unlocotype));					
			  return coach_meta_serv.getCoachTypesPrsData(unlocotype);		 	 	
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/sendlayouttypes")
		public List<CMMTypeLayout> getUnappCMMLayout(){
			return coach_meta_serv.getUnappCMMLayout();
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/prslayouttypes")
		public List<PRSTypeLayout> getUnappPRSLayout(){
			return coach_meta_serv.getUnappPRSLayout();
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/appcmmlayout")
		public String approveCmmCoachLayout(@RequestBody String cmmcoachtype){
			return coach_meta_serv.approveCmmCoachLayout(cmmcoachtype);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/appprslayout")
		public String approvePrsCoachLayout(@RequestBody String cmmcoachtype){
			return coach_meta_serv.approvePrsCoachLayout(cmmcoachtype);
		}

		
		@RequestMapping(method=RequestMethod.POST, value="/aprvdprslayout")
		public List<PRSTypeLayout> getAppPRSLayout(){
			return coach_meta_serv.getAppPRSLayout();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/aprvdcmmlayout")
		public List<CMMTypeLayout> getAppCMMLayout(){
			return coach_meta_serv.getAppCMMLayout();
		}

		@RequestMapping(method=RequestMethod.POST, value="/getcoachmapdata")
		public List<CoachTypeMapping> getCoachMapData(){
			return coach_meta_serv.getCoachMapData();
		}
		@RequestMapping(method=RequestMethod.POST, value="/getcoachlayoutdata")
		public List<CMMTypeLayout> getCoachMapLayout(){
			return coach_meta_serv.getCoachLayoutData();
		}

		
		@GetMapping("/coach_classes")
		public List<MCoachClass>get_coach_classes()
		{
			return (List<MCoachClass>) coach_class.findAll();		
		}
		

}
