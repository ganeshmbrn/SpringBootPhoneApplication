package com.ganesh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ganesh.dao.ContactDetailsRepoistory;
import com.ganesh.entities.ContactDetails;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

	private ContactDetailsRepoistory contactDetailsRepo;

	public ContactDetailsServiceImpl(ContactDetailsRepoistory contactDetailsRepo) {
		this.contactDetailsRepo = contactDetailsRepo;
	}

	@Override
	public boolean createOrEditContactDetails(ContactDetails contactDetails) {
		return contactDetailsRepo.save(contactDetails) != null;
	}

	@Override
	public ContactDetails getContactDetailsById(Integer ContactDetailsId) {
		Optional<ContactDetails> findById = contactDetailsRepo.findById(ContactDetailsId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean removeContactDetailsById(Integer contactDetailsId) {
		boolean isDeleted = false;
		try {
			contactDetailsRepo.deleteById(contactDetailsId);
			isDeleted = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public List<ContactDetails> getAllContactDetails() {
		return (List<ContactDetails>) contactDetailsRepo.findAll();
	}

}
