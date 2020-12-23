package com.myproject.demoSpring.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.PersonDto;
import com.myproject.demoSpring.entity.PersonEntity;

public interface PersonService {
	PersonEntity insertPerson(BiodataDto dto);
	List<PersonEntity> getPerson();
	PersonDto getById(Integer id);
	PersonEntity update(Integer idPerson, PersonDto dto);
	PersonEntity delete(Integer idPerson);
}
