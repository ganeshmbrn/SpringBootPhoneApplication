package com.ganesh.services;

import java.util.List;

import com.ganesh.entities.ContactDetails;

public interface ContactDetailsService {
	
	public boolean createOrEditContactDetails(ContactDetails contactDetails);
	
	public boolean removeContactDetailsById(Integer contactDetailsId);
	
	public List<ContactDetails> getAllContactDetails();
	
	public ContactDetails getContactDetailsById(Integer ContactDetailsId);
	
}
