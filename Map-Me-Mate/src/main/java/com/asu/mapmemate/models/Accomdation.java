package com.asu.mapmemate.models;

public class Accomdation {
	
	private String personName;
	private String courseName;
	private String gender;
	private String nationality;
	private String semester;
	private String rentPerDay;
	private String rentPerWeek;
	private String rentPerMonth;
	private String willNegotiate;
	
	public Accomdation() {
		super();
	}
	
	public Accomdation(String personName, String courseName, String gender, String nationality, String semester, String rentPerDay,
			String rentPerWeek, String rentPerMonth, String willNegotiate) {
		super();
		this.personName = personName;
		this.courseName = courseName;
		this.gender = gender;
		this.nationality = nationality;
		this.semester = semester;
		this.rentPerDay = rentPerDay;
		this.rentPerWeek = rentPerWeek;
		this.rentPerMonth = rentPerMonth;
		this.willNegotiate = willNegotiate;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(String rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	public String getRentPerWeek() {
		return rentPerWeek;
	}
	public void setRentPerWeek(String rentPerWeek) {
		this.rentPerWeek = rentPerWeek;
	}
	public String getRentPerMonth() {
		return rentPerMonth;
	}
	public void setRentPerMonth(String rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}
	public String getWillNegotiate() {
		return willNegotiate;
	}
	public void setWillNegotiate(String willNegotiate) {
		this.willNegotiate = willNegotiate;
	}
	
}
