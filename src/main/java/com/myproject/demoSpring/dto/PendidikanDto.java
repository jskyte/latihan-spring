package com.myproject.demoSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendidikanDto {
	private Integer id;
	private String level;
	private String institusi;
	private Integer tahunMasuk;
	private Integer tahunLulus;
	private Integer idPerson;
	
		
}
