package com.myproject.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.DetailBiodataDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;

@RestController
@RequestMapping("/biodata")
public class DetailBiodataController {
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@GetMapping("/get-biodata")
	public ResponseEntity<?> getAll() {
		List<DetailBiodataEntity> biodataEntities = detailBiodataRepository.findAll();
		return ResponseEntity.ok(biodataEntities);
	}
	
	@PostMapping("/add-biodata")
	public ResponseEntity<?> insertBiodata(@RequestBody DetailBiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setUsia(dto.getUsia());
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
}
