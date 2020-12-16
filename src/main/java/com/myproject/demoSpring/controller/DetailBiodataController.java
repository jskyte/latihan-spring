package com.myproject.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.DetailBiodataDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/biodata")
public class DetailBiodataController {
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/get-biodata")
	public ResponseEntity<?> getAll() {
		List<DetailBiodataEntity> biodataEntities = detailBiodataRepository.findAll();
		return ResponseEntity.ok(biodataEntities);
	}
	
	@GetMapping("/get-by-usia/{usia}")
	public ResponseEntity<?> getByUsia(@PathVariable Integer usia) {
		List<DetailBiodataEntity> detailBiodataEntities= detailBiodataRepository.findByUsia(usia);
		return ResponseEntity.ok(detailBiodataEntities);		
	}
 	
	@GetMapping("/get-by-domisili/{domisili}")
	public ResponseEntity<?> getByDomisili(@PathVariable String domisili) {
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findByDomisili(domisili);
		return ResponseEntity.ok(detailBiodataEntities);
	}
	
	@GetMapping("/get-by-hobi/{hobi}")
	public ResponseEntity<?> getByHobi(@PathVariable String hobi) {
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findByHobi(hobi);
		return ResponseEntity.ok(detailBiodataEntities);
	}
	
	@GetMapping("/get-by-jk-domisili/{jenisKelamin}/{domisili}")
	public ResponseEntity<?> getByJkDomisili(@PathVariable String jenisKelamin, @PathVariable String domisili) {
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findByJkDomisili(jenisKelamin, domisili);
		return ResponseEntity.ok(detailBiodataEntities);
	}
	
	
	@PostMapping("/add-biodata")
	public ResponseEntity<?> insertBiodata(@RequestBody BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody DetailBiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
		personEntity.setId(personRepository.findIdById(dto.getPersonId()));
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setUsia(dto.getUsia());
		detailBiodataEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	// Convert
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
