package com.myproject.demoSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pendidikan")
public class PendidikanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="level")
	private String level;
	
	@Column(name="institusi")
	private String institusi;
	
	@Column(name="tahun_masuk")
	private Integer tahunMasuk;
	
	@Column(name = "tahun_lulus")
	private Integer tahunLulus;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private PersonEntity personEntity;
	
	// Join ke tabel lain menggunakan index
//	@ManyToOne
//	@JoinColumn(name="kode_person", referencedColumnName = "kode_person")
//	private String kodePerson;

	public PendidikanEntity() {
		super();
	}

	public PendidikanEntity(Integer id, String level, String institusi, Integer tahunMasuk, Integer tahunLulus,
			PersonEntity personEntity) {
		super();
		this.id = id;
		this.level = level;
		this.institusi = institusi;
		this.tahunMasuk = tahunMasuk;
		this.tahunLulus = tahunLulus;
		this.personEntity = personEntity;
	}
	
}
