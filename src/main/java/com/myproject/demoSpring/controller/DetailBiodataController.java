package com.myproject.demoSpring.controller;

import java.time.Year;
import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.BiodataUsiaDto;
import com.myproject.demoSpring.dto.DetailBiodataDto;
import com.myproject.demoSpring.dto.StatusMessageDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;
import com.myproject.demoSpring.service.BiodataServiceImpl;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/biodata")
public class DetailBiodataController {
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BiodataServiceImpl biodataService;
	
	@GetMapping("/get-biodata")
	public ResponseEntity<?> getAll() {
		List<DetailBiodataEntity> detailBiodataEntity = biodataService.getAll();
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	@GetMapping("/get-by-usia/{usia}")
	public ResponseEntity<?> getByUsia(@PathVariable Integer usia) {
		List<DetailBiodataEntity> detailBiodataEntities= biodataService.getByUsia(usia);
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
	public ResponseEntity<?> insertBiodata(@RequestBody BiodataUsiaDto dto) {
		Integer usia = Year.now().getValue() - dto.getTanggalLahir().getYear() - 1900;
		if (usia < 17 || usia > 50) {
			StatusMessageDto<DetailBiodataEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Umur harus diantara 17 dan 50!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
			detailBiodataRepository.save(detailBiodataEntity);
			StatusMessageDto<DetailBiodataEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(detailBiodataEntity);
			return ResponseEntity.ok(result);
		}
		
	}
	
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody DetailBiodataDto dto) {
		
		if (dto.getUsia() < 17 || dto.getUsia() > 50) {
			StatusMessageDto<DetailBiodataEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Umur harus diantara 17 dan 50!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
			PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
//			personEntity.setId(personRepository.findIdById(dto.getPersonId()));
			detailBiodataEntity.setDomisili(dto.getDomisili());
			detailBiodataEntity.setHobi(dto.getHobi());
			detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
			detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
			detailBiodataEntity.setUsia(dto.getUsia());
			detailBiodataEntity.setPersonEntity(personEntity);			
			detailBiodataRepository.save(detailBiodataEntity);
			
			StatusMessageDto<DetailBiodataEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(detailBiodataEntity);
			
			return ResponseEntity.ok(result);
		}
		
	}
	
	// Convert
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataUsiaDto dto) {
		Integer usia = Year.now().getValue() - dto.getTanggalLahir().getYear() - 1900;
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setUsia(usia);
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		return detailBiodataEntity;
	}
	
}
