package com.asu.mapmemate.models;

public class Amenity {
	
	private String amenityName;
	private String amenityDistance;
	
	public Amenity() {
		super();
	}

	public Amenity(String amenityName, String amenityDistance) {
		super();
		this.amenityName = amenityName;
		this.amenityDistance = amenityDistance;
	}

	public String getAmenityName() {
		return amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public String getAmenityDistance() {
		return amenityDistance;
	}

	public void setAmenityDistance(String amenityDistance) {
		this.amenityDistance = amenityDistance;
	}
	
}
