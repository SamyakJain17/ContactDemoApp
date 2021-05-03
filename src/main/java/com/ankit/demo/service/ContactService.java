package com.ankit.demo.service;

import java.util.List;
import com.ankit.demo.entity.Contact;

public interface ContactService {

	/**
	 * Save contact
	 * 
	 * @param contact
	 * @return
	 */

	Contact save(Contact contact);

	/**
	 * list All contact
	 * 
	 * @param contact
	 * @param contact
	 * @return
	 */

	List<Contact> getAllContact();

	/**
	 * find All Contacts by Postal Code
	 * @param postalCode
	 * @return
	 */
	List<Contact> findAllByPostalCode(String postalCode);
}
