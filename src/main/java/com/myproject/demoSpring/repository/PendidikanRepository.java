package com.myproject.demoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.demoSpring.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {

}
