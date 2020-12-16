package com.myproject.demoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.demoSpring.entity.DetailBiodataEntity;

@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer> {
	
	List<DetailBiodataEntity> findByUsia(Integer usia);
	
	List<DetailBiodataEntity> findByDomisili(String domisili);
	
	List<DetailBiodataEntity> findByHobi(String hobi);
	
	@Query(value = "SELECT * FROM detail_biodata_entity WHERE jenis_kelamin = ? AND domisili = ?", nativeQuery = true)
	List<DetailBiodataEntity> findByJkDomisili(String jenisKelamin, String domisili);
	
}
