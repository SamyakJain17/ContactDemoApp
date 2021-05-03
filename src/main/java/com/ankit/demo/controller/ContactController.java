package com.ankit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.demo.entity.Address;
import com.ankit.demo.entity.Contact;
import com.ankit.demo.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/contact")
@Api(value = "contact")
public class ContactController {

	@Autowired
	ContactService contactService;

	// Retrieve All Contacts
	@ApiOperation(value = "Retrieve All Contacts", response = Contact.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve All Contacts Successfully"),
			@ApiResponse(code = 400, message = "Bad Request, request provided is not valid"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/")
	private List<Contact> findAllContact() {
		return contactService.getAllContact();

	}

	// Create contact.
	@ApiOperation(value = "Create contat", response = Contact.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Create Contact Successfully"),
			@ApiResponse(code = 400, message = "Bad Request, request provided is not valid"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/create")
	private Contact saveContact(@RequestBody Contact contact) {
		return contactService.save(contact);
	}
	
	// Retrieve Contacts By Postal Code
		@ApiOperation(value = "Retrieve All Contacts using postalcode", response = Address.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve All Contacts using postalcode Successfully"),
				@ApiResponse(code = 400, message = "Bad Request, request provided is not valid"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
		@GetMapping("/postalCode/{postalCode}")
		private List<Contact> findByPostalCode(@PathVariable String postalCode) {
			return contactService.findAllByPostalCode(postalCode);
	}

}
