package com.myproject.demoSpring.dto;

import java.sql.Date;

public class DetailBiodataDto {
	private String domisili;
	private Integer usia;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	
	public DetailBiodataDto() {
		super();
	}

	public DetailBiodataDto(String domisili, Integer usia, Date tanggalLahir, String hobi, String jenisKelamin) {
		super();
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
	}

	public String getDomisili() {
		return domisili;
	}

	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}

	public Integer getUsia() {
		return usia;
	}

	public void setUsia(Integer usia) {
		this.usia = usia;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
}
