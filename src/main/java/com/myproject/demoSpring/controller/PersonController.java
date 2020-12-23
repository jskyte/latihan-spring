package com.myproject.demoSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.DetailBiodataDto;
import com.myproject.demoSpring.dto.PersonDto;
import com.myproject.demoSpring.dto.StatusMessageDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;
import com.myproject.demoSpring.service.BiodataServiceImpl;
import com.myproject.demoSpring.service.PersonServiceImpl;

@RestController
@RequestMapping("/person") // localhost:8500/person
public class PersonController {

	
	private PersonRepository personRepository;
	private DetailBiodataRepository DetailBiodataRepository;
	private PersonServiceImpl service;
	private BiodataServiceImpl biodataService;
	
	@Autowired
	public PersonController(PersonRepository personRepository,
			com.myproject.demoSpring.repository.DetailBiodataRepository detailBiodataRepository,
			PersonServiceImpl service, BiodataServiceImpl biodataService) {
		super();
		this.personRepository = personRepository;
		DetailBiodataRepository = detailBiodataRepository;
		this.service = service;
		this.biodataService = biodataService;
	}

	@GetMapping("/get-all") // localhost:8500/person/get-all
	public List<PersonEntity> getPerson() {
		return service.getPerson();
	}
	
	// Get Mapping By ID / Get using parameter
	@GetMapping("/get-name-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		PersonDto personDto = service.getById(id);
		return ResponseEntity.ok(personDto);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody List<BiodataDto> dto) {
		for(BiodataDto e : dto) {
			service.insertPerson(e);
		}
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/post-person-status")
	public ResponseEntity<?> insertPerson2(@RequestBody BiodataDto dto) {
		if (dto.getNik().length() != 16) {
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("NIK tidak 16 angka");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			PersonEntity personEntity = service.insertPerson(dto);
			
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(personEntity);
			return ResponseEntity.ok(result);
		}
		
	}
	
	// UPDATE DATA
	@PutMapping("/update-person/{idPerson}")
	public ResponseEntity<?> update(@PathVariable Integer idPerson, @RequestBody PersonDto dto){
		PersonEntity personEntity = service.update(idPerson, dto);
		return ResponseEntity.ok(personEntity);
	}
	
	// DELETE DATA
	@DeleteMapping("/delete-person/{idPerson}")
	public ResponseEntity<?> delete(@PathVariable Integer idPerson) {
		PersonEntity personEntity = service.delete(idPerson);
		return ResponseEntity.ok(personEntity);
	}
	
	@PostMapping("/insert-all")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto) {		
			DetailBiodataEntity detailBiodataEntity = biodataService.insertAll(dto);
			
			StatusMessageDto<DetailBiodataEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(null);
		
			return ResponseEntity.ok(result);
	}
	

	
}
