package com.ganesh.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ganesh.entities.ContactDetails;

public interface ContactDetailsRepoistory extends CrudRepository<ContactDetails, Serializable> {

}
