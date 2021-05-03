package com.ankit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.demo.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	/**
	 *  find by postal Code
	 * @param postal code
	 * @return
	 */
	public List<Contact> findAllByAddressPostalCode(String postalCode);

}
