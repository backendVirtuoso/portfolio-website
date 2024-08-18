package com.example.portfolio.service;

import org.springframework.stereotype.Service;

import com.example.portfolio.domain.Contact;
import com.example.portfolio.repository.ContactRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ContactService {
	
	private final ContactRepository contactRepository;
	
	
	public Contact create(String addr, String tel, String email, String openHours) {
		Contact contact = new Contact();
		contact.setAddr(addr);
		contact.setTel(tel);
		contact.setEmail(email);
		contact.setOpenHours(openHours);
		this.contactRepository.save(contact);
		return contact;
	}
	
	public Contact getContactById(Integer id) {
		return contactRepository.findById(id).orElse(null);
	}
}
