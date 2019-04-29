package com.columbuscoders.portfoliomanagement.services;

import java.util.List;
import java.util.Map;

import com.columbuscoders.portfoliomanagement.models.Profile;


public interface ProfileService {
	
	List<Profile> findAllProfile();
	Profile findProfileByUserName(String userName);
	List<Profile> findProfileByName(String firstName);
	List<Profile> searchProfile(Map<String,String> allParams);
	Profile createProfile(Profile pf);
	Profile UpdateProfile(String userName,Profile pf);

}
