package com.myproject.demoSpring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiodataUsiaDto {
	private String firstName;
	private String lastName;
	private String nik;
	private String domisili;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer idPerson;
}
