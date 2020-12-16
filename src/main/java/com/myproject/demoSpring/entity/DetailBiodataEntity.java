package com.myproject.demoSpring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "domisili")
	private String domisili;
	
	@Column(name = "usia")
	private Integer usia;
	
	@Column(name = "tanggal_lahir")
	private Date tanggalLahir;
	
	@Column(name = "hobi")
	private String hobi;
	
	@Column(name="jenis_kelamin")
	private String jenisKelamin;

	public DetailBiodataEntity() {
		super();
	}

	public DetailBiodataEntity(Integer id, String domisili, Integer usia, Date tanggalLahir, String hobi,
			String jenisKelamin, PersonEntity personEntity) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
		this.personEntity = personEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;
	
}
