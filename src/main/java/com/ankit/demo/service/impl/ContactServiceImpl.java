package com.ankit.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.demo.entity.Contact;
import com.ankit.demo.repository.ContactRepository;
import com.ankit.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> findAllByPostalCode(String postalCode) {
		return contactRepository.findAllByAddressPostalCode(postalCode);
	}

}
