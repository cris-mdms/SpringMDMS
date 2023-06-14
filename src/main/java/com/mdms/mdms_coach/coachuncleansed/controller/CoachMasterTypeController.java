package com.mdms.mdms_coach.coachuncleansed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_coach.coachuncleansed.model.MBreakType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachCategoryType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachStatus;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachTypePrs;
import com.mdms.mdms_coach.coachuncleansed.model.MCouplingType;
import com.mdms.mdms_coach.coachuncleansed.model.MDepo;
import com.mdms.mdms_coach.coachuncleansed.model.MFitnessType;
import com.mdms.mdms_coach.coachuncleansed.model.MPowerGenerationType;
import com.mdms.mdms_coach.coachuncleansed.service.MasterCoachService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class CoachMasterTypeController {
	
	@Autowired
	private MasterCoachService masterCoachService;
	
	@RequestMapping(method=RequestMethod.GET, value="/mbreaktype")
	List<MBreakType> getBreakType(){
		return masterCoachService.findMbreakData();
	}

	@RequestMapping(method=RequestMethod.GET, value="/mcategorytype")
	List<MCoachCategoryType> getCategoryType(){
		return masterCoachService.findMCoachCategoryData();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/mcoachstatus")
	List<MCoachStatus> getMCoachStatusDetails(){
		return masterCoachService.findMCoachstatusData();
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/mcoachtypecmm")
	List<MCoachType> getMCoachTypeCmmDetails(){
		return masterCoachService.findMCoachTypeCmmData();
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/mcoachtypeprs")
	List<MCoachTypePrs> getMCoachTypePrsDetails(){
		return masterCoachService.findMCoachTypePrsData();
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/mcuplingtype")
	List<MCouplingType> getMCouplingTypeDetails(){
		return masterCoachService.findMCouplingType();
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/mdepo")
	List<MDepo> getMDepoDetails(){
		return masterCoachService.findMDepoData();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/mfitnesstype")
	List<MFitnessType> getMfitnessTypeDetails(){
		return masterCoachService.findMfitnessTypedata();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/mpowergenerationtype")
	List<MPowerGenerationType> getMPowerGenerationTypeDetails(){
		return masterCoachService.findMPowerGenerationTypeDetails();
	}

	@RequestMapping(method=RequestMethod.POST, value="/mcoachtypecmmreserved")
	List<MCoachType> getMCoachTypeCmmReserved(){
		return masterCoachService.getReservedCoachTypeCmmData();
	}



}






