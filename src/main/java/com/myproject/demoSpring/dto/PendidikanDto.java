package com.myproject.demoSpring.dto;

import lombok.Data;

@Data
public class PendidikanDto {
	private Integer id;
	private String level;
	private String institusi;
	private Integer tahunMasuk;
	private Integer tahunLulus;
	private Integer idPerson;
	
	public PendidikanDto() {
		super();
	}

	public PendidikanDto(Integer id, String level, String institusi, Integer tahunMasuk, Integer tahunLulus,
			Integer idPerson) {
		super();
		this.id = id;
		this.level = level;
		this.institusi = institusi;
		this.tahunMasuk = tahunMasuk;
		this.tahunLulus = tahunLulus;
		this.idPerson = idPerson;
	}
		
}
