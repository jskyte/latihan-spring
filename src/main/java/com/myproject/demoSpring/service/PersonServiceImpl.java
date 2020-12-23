package com.myproject.demoSpring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.PersonDto;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public PersonEntity insertPerson(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return personEntity;
	}
	
	@Override
	public List<PersonEntity> getPerson() {
		// TODO Auto-generated method stub
		List<PersonEntity> personEntities = personRepository.findAll();
		return personEntities;
	}
	
	@Override
	public PersonDto getById(Integer id) {
		// TODO Auto-generated method stub
		PersonDto dto = new PersonDto();
		// personEntity.setFirstName(personRepository.findFirstNameById(id));
		dto.setFirstName(personRepository.findFirstNameById(id));
		dto.setMessage("Data Berhasil");
		dto.setStatus("200");
		return dto;
	}
	
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}

	@Override
	public PersonEntity update(Integer idPerson, PersonDto dto) {
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return personEntity;
	}

	@Override
	public PersonEntity delete(Integer idPerson) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personRepository.delete(personEntity);
		return personEntity;
	}

	
}
