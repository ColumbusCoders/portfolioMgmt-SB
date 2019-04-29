package com.columbuscoders.portfoliomanagement.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.columbuscoders.portfoliomanagement.models.Profile;

@Service
public class ProfileServiceImpl implements ProfileService
{
	MongoOperations mongoOperations;
	
	// constructor
	public ProfileServiceImpl(MongoOperations mOps)
	{
	    this.mongoOperations = mOps;	
	}
	
	// get all profile 
	@Override
	public List<Profile> findAllProfile() {
        List<Profile> profilelist = mongoOperations.findAll(Profile.class);
		return profilelist;
	}

	// get profile by name
	@Override
	public Profile findProfileByUserName(String userName) {
		System.out.println("Testing :" + userName);
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userName));
		return mongoOperations.findOne(query,Profile.class);
	}

	@Override
	public List<Profile> findProfileByName(String firstName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").regex("^" +firstName + ".*", "i"));
        List<Profile> profilelist = mongoOperations.find(query,Profile.class);
		return profilelist;		
	}

	// Search profile by multiple params.. 
	@Override
	public List<Profile> searchProfile(Map<String, String> allParams) {
		
		String firstName;
		String lastName;
		int age;
		Query query = new Query();

		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			
			if(entry.getKey().equals("firstName"))
			{
				firstName = entry.getValue();
				query.addCriteria(Criteria.where("firstName").regex("^" + firstName + ".*", "i"));
			}
			if(entry.getKey().equals("lastName"))
			{
				lastName= entry.getValue();
				query.addCriteria(Criteria.where("lastName").regex("^" + lastName + ".*", "i"));

			}
			if(entry.getKey().equals("age"))
			{
				age = Integer.parseInt(entry.getValue());
				query.addCriteria(Criteria.where("age").gte(age));

			}
		}
		
		System.out.println("Query String : " + query.toString());
		
        List<Profile> profilelist = mongoOperations.find(query.limit(5),Profile.class);
		return profilelist;
	}

	// create a new profile
	@Override
	public Profile createProfile(Profile pf) {
		mongoOperations.insert(pf);
		return null;
	}

	// Update an existing profile
	@Override
	public Profile UpdateProfile(String userName,Profile pf) {
		System.out.println("Testing :" + userName);
		// get the profile by name
	     Profile profile = this.findProfileByUserName(userName);
	     profile.merge(pf);
	     mongoOperations.save(profile);
	   	 return profile;
	}

	
	

}

