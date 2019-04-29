package com.columbuscoders.portfoliomanagement.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.columbuscoders.portfoliomanagement.models.Profile;
import com.columbuscoders.portfoliomanagement.services.ProfileService;


@CrossOrigin
@RestController
@RequestMapping("/portfoliomgmt/profile")
public class PortfolioMgmtController {
	
	private ProfileService profileservice;

	@Autowired
	public void setProfileService(ProfileService profileservice)
	{
	    this.profileservice = profileservice;	
	}
	
	// Get all Profile or by Search parameters
	@GetMapping
	 public List<Profile> getProfilebySearchparams(@RequestParam Map<String,String> allParams){	
		 return profileservice.searchProfile(allParams);
	 }

	// Get Profile by UserName
	@GetMapping(path = "/{userName}")
	 public Profile getProfilebyID(@PathVariable String userName){		
		 return profileservice.findProfileByUserName(userName);
	 }
	
	  // POST method
	@PostMapping
	  public Profile createProfile(@Valid @RequestBody Profile pf) {
		  profileservice.createProfile(pf);
	    return null;
	  }
	
	//Put method
	@PutMapping(path = "/{userName}")
	public Profile updateProfile(@Valid @RequestBody Profile pf,@PathVariable String userName)
	{
		return profileservice.UpdateProfile(userName, pf);
		 
	}

}
