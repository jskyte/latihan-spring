package com.myproject.demoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.demoSpring.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	
	@Query(value = "SELECT * FROM pendidikan WHERE person_id = ?", nativeQuery = true)
	List<PendidikanEntity> findPendidikanById(Integer personId);
	
}
