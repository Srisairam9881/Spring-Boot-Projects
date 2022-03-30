package com.example.ContactMangementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ContactMangementSystem.dao.ContactRepository;
import com.example.ContactMangementSystem.entity.Contact;

@Controller
public class ContactController {
	private ContactRepository a;

	public ContactController(ContactRepository a) {
		super();
		this.a = a;
	}
	
/*************** Displays All Contacts list Function *******************************/
	
	@GetMapping({"/list","/"})
	public ModelAndView getAllcontacts() // here getAllcontacts() is function name
	{
		ModelAndView mav=new ModelAndView("list-contact"); // here list-contact is a template file name
		mav.addObject("contacts",a.findAll()); //here "contacts" is a key
		return mav;
	}
	
/************************** Add Contact Function ***********************************/
	@GetMapping("/addContact")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("addContact");  //here addEmployee is a template file name 
		Contact contact = new Contact();
		mav.addObject("contact", contact); //here "contact" is a key
		return mav;
	}	
	
/************************** Save Contact Function **********************************/
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute Contact contact)
	{
	a.save(contact);
	return "redirect:/list";
	}
	
/************************** Update Conatct By using id Function ********************/
	@GetMapping("/showUpdateForm")
	public ModelAndView Updatecontact(@RequestParam Long contactId) {
		ModelAndView mav = new ModelAndView("addContact");
		Contact contact = a.findById(contactId).get();
		mav.addObject("contact", contact);
		return mav;
	}
	
/********************** Delete Conatct By using id Function ************************/
	@GetMapping("/deleteEmployee")
	public String deleteContact(@RequestParam Long contactId) {
		a.deleteById(contactId);
		return "redirect:/list";
	}

}
