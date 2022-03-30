package com.example.ContactMangementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ContactMangementSystem.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
