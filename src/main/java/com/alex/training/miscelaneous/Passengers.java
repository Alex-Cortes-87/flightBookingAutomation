package com.alex.training.miscelaneous;

public class Passengers {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String birth;
	
	public Passengers(String firstName, String middleName, String lastName, String gender, String birth) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
	}
	
	
	public String firstName() {
		return firstName;
	}
	
	public String middleName() {
		return middleName;
	}
	
	public String lastName() {
		return lastName;
	}
	
	public String passengerGender() {
		return gender;
	}
	

	private String[] birth_date_split = this.birth.split("-");
	
	
	public String birthDay() {
		
		return birth_date_split[1] ;
	}
	
	public String birthMonth() {
		
		return birth_date_split[0] ;
	}
	
	public String birthYear() {
		
		return birth_date_split[2] ;
	}
	
	

}
