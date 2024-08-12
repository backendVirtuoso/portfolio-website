package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	Optional<Contact> findById(Integer id);
}