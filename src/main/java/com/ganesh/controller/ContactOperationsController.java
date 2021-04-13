package com.ganesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ganesh.application.AppConstants;
import com.ganesh.application.ApplicationProperties;
import com.ganesh.entities.ContactDetails;
import com.ganesh.services.ContactDetailsService;

@Controller
public class ContactOperationsController {
	
	private ContactDetailsService contactDetailsService;
	
	private ApplicationProperties props;
	
    public ContactOperationsController(ContactDetailsService contactDetailsService,ApplicationProperties props) {
    	this.contactDetailsService = contactDetailsService;
    	this.props = props;
	}
    
    /**
     * This method is used for updating contact details
     * @param contactId
     * @param model
     * @return
     */
	
	@GetMapping("/editContactDetails")
	public String showFormForUpdate(@RequestParam("contactId") Integer contactId,Model model) {
		ContactDetails contactDetailsById = contactDetailsService.getContactDetailsById(contactId);
		if(contactDetailsById != null) {
			model.addAttribute("contactForm", contactDetailsById);
		}		
		return AppConstants.CONTACTFORM;
	}
	
	/**
	 * This method is meant for deleting the contact details
	 * @param contactId
	 * @param rda
	 * @return
	 */
	@GetMapping("/deleteContactDetails")
	public String deleteContactDetails(@RequestParam("contactId") Integer contactId,RedirectAttributes rda) {
		 
		boolean deleteContactFlag = contactDetailsService.removeContactDetailsById(contactId);
		if(deleteContactFlag) {
			rda.addFlashAttribute("deleteMessage",props.getMessages().get("contactDeleteSuccess"));
		}else {
			rda.addFlashAttribute("deleteMessage",props.getMessages().get("contactDeleteFailure"));
		}
		return "redirect:listOfContacts";
	}
}
