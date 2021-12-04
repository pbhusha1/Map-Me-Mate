package com.asu.mapmemate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asu.mapmemate.models.Apartment;
import com.asu.mapmemate.ontologies.Apartments;

@Service
public class ApartmentService {
	
	@Autowired
	private Apartments apartments;
	
	public List<Apartment> listAllApartmentsByUniversity(String query){
		return apartments.executeQuery(query);
	}

	public Apartment getApartmentDetails(String query) {
		return apartments.executeQueryD(query);
	}

	public String getApartmetntID(String query) {
		return apartments.executeQueryID(query);
	}
}
