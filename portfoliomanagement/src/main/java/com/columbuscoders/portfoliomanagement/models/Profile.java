package com.columbuscoders.portfoliomanagement.models;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "artiest")
public class Profile {
	@Id
	  public ObjectId _id;
	  
	  public String firstName;
	  public String lastName;
	  public String middleName;
	  public int age;
	  public String gender;
	  public ArrayList<Address> address;	  
	  public ArrayList<Skills> skills;
	  public Contact contact;
	  
	// Constructors
	  public Profile() {}
	  
	  public Profile(ObjectId _id, String firstName, String lastName, String middleName,int age,String gender,ArrayList<Address> address,Contact contact,ArrayList<Skills> skills) {
	    this._id = _id;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.middleName = middleName;
	    this.age = age;
	    this.gender = gender;
	    this.address = address;
	    this.contact = contact;
	    this.skills = skills;
	  }
	  
	  // ObjectId needs to be converted to string
	  public String get_id() { return _id.toHexString(); }
	  public void set_id(ObjectId _id) { this._id = _id; }

	  public String getfirstName() { return firstName; }
	  public void setfirstName(String firstName) { this.firstName = firstName; }
	  
	  public String getlastName() { return lastName; }
	  public void setlastName(String lastName) { this.lastName = lastName; }
	  
	  public int getage() { return age; }
	  public void setage(int age) { this.age = age; }
	  
	  public String getgender() { return gender; }
	  public void setgender(String gender) { this.gender = gender; }
	  
      public void merge(Profile pf)
      {
         this.firstName	 = pf.firstName == null ? this.firstName : pf.firstName;
         this.lastName	 = pf.lastName == null ? this.lastName : pf.lastName;
         this.middleName = pf.middleName == null ? this.middleName : pf.middleName;
         this.gender = pf.gender == null ? this.gender : pf.gender;       
         this.age = pf.age > 0 ? pf.age : this.age ;
        // this.address.addAll(pf.address);
         if(pf.contact.emails != null && !pf.contact.emails.isEmpty())
         {
             this.contact.setEmails(pf.contact.emails);
         }
         if(pf.contact.phones != null && !pf.contact.phones.isEmpty())
         {
             this.contact.setPhones(pf.contact.phones);
         }

      }

}
