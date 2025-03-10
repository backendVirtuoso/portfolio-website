package com.example.portfolio.repository;

import com.example.portfolio.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByIsActive(@Param("isActive") boolean isActive);
} 