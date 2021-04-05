package com.ganesh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contact_details")
public class ContactDetails {
	
    @Id
	@Column(name="contact_id")
    @GeneratedValue
	private Integer contactId;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@Column(name="contact_number")
	private Long contactNumber;
	
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	
	public Integer getContactId() {
		return contactId;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Long getContactNumber() {
		return contactNumber;
	}

	@Override
	public String toString() {
		return "ContactDetails [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", contactNumber=" + contactNumber + "]";
	}
}
