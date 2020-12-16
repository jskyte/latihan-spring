package com.myproject.demoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.demoSpring.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
	
	@Query(value = "SELECT * FROM person_entity WHERE first_name = ?", nativeQuery = true)
	List<PersonEntity> findByFirstName(String firstName);
	
	List<PersonEntity> findByLastName(String lastName);
	
	@Query(value = "SELECT first_name FROM person_entity WHERE id = ?", nativeQuery = true)
	String findFirstNameById(Integer id);
	
	@Query(value = "SELECT id FROM person_entity WHERE id = ?", nativeQuery = true)
	Integer findIdById(Integer Id);
}
