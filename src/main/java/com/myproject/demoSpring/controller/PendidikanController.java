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
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.PendidikanDto;
import com.myproject.demoSpring.entity.PendidikanEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.PendidikanRepository;
import com.myproject.demoSpring.repository.PersonRepository;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {
	
	@Autowired
	PendidikanRepository pendidikanRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/get-pendidikan")
	public ResponseEntity<?> getPendidikan() {
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findAll();
		return ResponseEntity.ok(pendidikanEntities);
	}
	
	@PostMapping("/add-pendidikan")
	public ResponseEntity<?> addPendidikan(@RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = convertToPendidikanEntity(dto);
		PersonEntity personEntity = personRepository.findById(dto.getIdPerson()).get();
		personEntity.setId(personRepository.findIdById(dto.getIdPerson()));
		pendidikanEntity.setPersonEntity(personEntity);
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
	@PutMapping("/update-pendidikan/{idPendidikan}")
	public ResponseEntity<?> updatePendidikan(@PathVariable Integer idPendidikan, @RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(idPendidikan).get();
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulus(dto.getTahunLulus());
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
	@DeleteMapping("/delete-pendidikan/{idPendidikan}")
	public ResponseEntity<?> deletePendidikan(@PathVariable Integer idPendidikan){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(idPendidikan).get();
		pendidikanRepository.delete(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);		
	}
	
	// Converter
	public PendidikanEntity convertToPendidikanEntity(PendidikanDto dto) {
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulus(dto.getTahunLulus());
		return pendidikanEntity;
	}
	
	
}
