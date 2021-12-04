package com.asu.mapmemate.models;

public class Apartment {
	
	private String name;
	private String address;
	private String contact;
	private String rentRange;
	private String directionURL;
	private String description;
	private String apartmentURL;
	private String rating;
	private String imageURL;
	
	public Apartment() {
		super();
	}
	
	public Apartment(String name, String address, String contact, String rentRange, String directionURL,
			String description, String apartmentURL, String rating, String imageURL) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.rentRange = rentRange;
		this.directionURL = directionURL;
		this.description = description;
		this.apartmentURL = apartmentURL;
		this.rating = rating;
		this.imageURL = imageURL;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRentRange() {
		return rentRange;
	}

	public void setRentRange(String rentRange) {
		this.rentRange = rentRange;
	}

	public String getDirectionURL() {
		return directionURL;
	}

	public void setDirectionURL(String directionURL) {
		this.directionURL = directionURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApartmentURL() {
		return apartmentURL;
	}

	public void setApartmentURL(String apartmentURL) {
		this.apartmentURL = apartmentURL;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Apartment [name=" + name + ", address=" + address + ", contact=" + contact + ", rentRange=" + rentRange
				+ ", directionURL=" + directionURL + ", description=" + description + ", apartmentURL=" + apartmentURL
				+ ", rating=" + rating + ", imageURL=" + imageURL + "]";
	}

}
