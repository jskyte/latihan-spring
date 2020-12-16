package com.myproject.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person") // localhost:8500/person
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DetailBiodataRepository DetailBiodataRepository;
	
	@GetMapping("/get-all") // localhost:8500/person/get-all
	public List<PersonEntity> getPerson() {
		List<PersonEntity> personEntities = personRepository.findAll();
		// personEntities = personRepository.findByFirstName("jayson");
		return personEntities;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	// Get Mapping By ID / Get using parameter
	@GetMapping("/get-name-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		// PersonEntity personEntity = new PersonEntity();
		PersonDto dto = new PersonDto();
		// personEntity.setFirstName(personRepository.findFirstNameById(id));
		dto.setFirstName(personRepository.findFirstNameById(id));
		dto.setMessage("Data Berhasil");
		dto.setStatus("200");
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody BiodataDto dto) {
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	// UPDATE DATA
	@PutMapping("/update-person/{idPerson}")
	public ResponseEntity<?> update(@PathVariable Integer idPerson, @RequestBody PersonDto dto){
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	// DELETE DATA
	@DeleteMapping("/delete-person/{idPerson}")
	public ResponseEntity<?> delete(@PathVariable Integer idPerson) {
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personRepository.delete(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@PostMapping("/insert-all")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto) {
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		
		personRepository.save(personEntity);
		detailBiodataEntity.setPersonEntity(personEntity);
		DetailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	// Method Convert
	// Proses POST
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		return personEntity;
	}
	
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setUsia(dto.getUsia());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		return detailBiodataEntity;
	}
	
}
