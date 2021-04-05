package com.ganesh.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ganesh.entities.ContactDetails;

public interface ContactDetailsRepoistory extends CrudRepository<ContactDetails, Serializable> {  
	  

}
