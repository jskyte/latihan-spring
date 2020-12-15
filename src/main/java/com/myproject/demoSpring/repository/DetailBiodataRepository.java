package com.myproject.demoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.demoSpring.entity.DetailBiodataEntity;

@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer> {

}
