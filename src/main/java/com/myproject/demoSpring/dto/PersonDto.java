package com.myproject.demoSpring.dto;

public class PersonDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String message;
	private String status;
	private String nik;
	private String kodePerson;
	
	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getKodePerson() {
		return kodePerson;
	}

	public void setKodePerson(String kodePerson) {
		this.kodePerson = kodePerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PersonDto() {
		super();
	}


	public PersonDto(Integer id, String firstName, String lastName, String message, String status, String nik,
			String kodePerson) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
		this.status = status;
		this.nik = nik;
		this.kodePerson = kodePerson;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
