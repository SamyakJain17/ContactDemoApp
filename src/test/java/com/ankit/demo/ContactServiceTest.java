package com.ankit.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.ankit.demo.entity.Contact;
import com.ankit.demo.repository.ContactRepository;
import com.ankit.demo.service.impl.ContactServiceImpl;

@RunWith(SpringRunner.class)
public class ContactServiceTest {

	@Mock
	ContactRepository contactRepository;

	@InjectMocks
	ContactServiceImpl service;

	Contact contact;

	@Before
	public void init() {
		contact = new Contact();
		contact.setFullName("test");
		LocalDate date = LocalDate.parse("yyyy-MM-dd");
		contact.setDateOfBirth(date);
	}

	@Test
	public void test_save() {
		service.save(contact);
		Mockito.verify(contactRepository, Mockito.times(1)).save(Mockito.any(Contact.class));
	}

	@Test
	public void test_getAllContact() {
		Mockito.when(contactRepository.findAll()).thenReturn(new ArrayList<Contact>());
		service.getAllContact();

		Mockito.verify(contactRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	public void test_findByPostalCode() {
		List<Contact> contacts =  new ArrayList<Contact>();;
		Mockito.when(contactRepository.findAllByAddressPostalCode(Mockito.anyString())).thenReturn(contacts);
		service.findAllByPostalCode("postalCode");
		Mockito.verify(contactRepository, Mockito.times(1)).findAllByAddressPostalCode(Mockito.anyString());
	}
}
