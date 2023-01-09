package com.entry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entry.model.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

}
