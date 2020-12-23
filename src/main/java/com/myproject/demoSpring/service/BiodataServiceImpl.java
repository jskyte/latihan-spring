package com.myproject.demoSpring.service;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.dto.BiodataUsiaDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService{
	
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public DetailBiodataEntity insertAll(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		
		personRepository.save(personEntity);
		detailBiodataEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
		return detailBiodataEntity;
	}
	
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
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

	@Override
	public List<DetailBiodataEntity> getAll() {
		// TODO Auto-generated method stub
		List<DetailBiodataEntity> biodataEntities = detailBiodataRepository.findAll();
		return biodataEntities;
	}

	@Override
	public List<DetailBiodataEntity> getByUsia(Integer usia) {
		// TODO Auto-generated method stub
		List<DetailBiodataEntity> detailBiodataEntities= detailBiodataRepository.findByUsia(usia);
		return detailBiodataEntities;
	}

}
