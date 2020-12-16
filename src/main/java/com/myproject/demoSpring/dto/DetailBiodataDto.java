package com.myproject.demoSpring.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DetailBiodataDto {
	private String domisili;
	private Integer usia;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer personId;
	
	public DetailBiodataDto(String domisili, Integer usia, Date tanggalLahir, String hobi, String jenisKelamin,
			Integer personId) {
		super();
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
		this.personId = personId;
	}

	public DetailBiodataDto() {
		super();
	}
	
	
}
