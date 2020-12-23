package com.myproject.demoSpring.service;

import java.util.List;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;

public interface BiodataService {
	DetailBiodataEntity insertAll(BiodataDto dto);
	List<DetailBiodataEntity> getAll();
	List<DetailBiodataEntity> getByUsia(Integer usia);
}
