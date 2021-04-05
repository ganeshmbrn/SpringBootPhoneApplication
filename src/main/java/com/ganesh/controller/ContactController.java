package com.ganesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ganesh.application.AppConstants;
import com.ganesh.application.ApplicationProperties;
import com.ganesh.entities.ContactDetails;
import com.ganesh.services.ContactDetailsService;

@Controller
public class ContactController {

	private ContactDetailsService contactDetailsService;
	
	private ApplicationProperties props;

	@Autowired
	public ContactController(ContactDetailsService csd,ApplicationProperties props) {
		this.contactDetailsService = csd;
		this.props = props;
	}

	/**
	 * This method is used for displaying contact form adding
	 * 
	 * @return
	 */
	@GetMapping("/loadContactForm")
	public String loadContactForm(Model model) {

		// Model object is used to send data from controller to UI
		model.addAttribute("contactForm", new ContactDetails());

		// returning the logical view name
		return "contactForm";
	}

	/**
	 * This Method is used for Creating new contact
	 * 
	 * @param contactDetails
	 * @param model
	 * @return
	 */
	@PostMapping("/createContactDetails")
	public String contactSubmitAction(@ModelAttribute("contactForm") ContactDetails contactDetails, Model model) {
		Integer cid  = contactDetails.getContactId();
		boolean recordFlag = contactDetailsService.createOrEditContactDetails(contactDetails);
		if (recordFlag) {
			if (cid == null) {
				System.out.println("Test");
				model.addAttribute(AppConstants.message, props.getMessages().get("contactSavedSuccess"));
			} else {
				model.addAttribute(AppConstants.message, props.getMessages().get("contactUpdateSuccess"));
			}
		} else {
			model.addAttribute(AppConstants.message, props.getMessages().get("contactSavedFailure"));
		}
		
		return "contactForm";
	}

	/**
	 * This method is used for retreiving all contacts from database
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/listOfContacts")
	public String viewAllContactAction(Model model) {
		List<ContactDetails> allContactDetails = contactDetailsService.getAllContactDetails();
		model.addAttribute("contactsList", allContactDetails);

		return "contactViewDetails";
	}

}
