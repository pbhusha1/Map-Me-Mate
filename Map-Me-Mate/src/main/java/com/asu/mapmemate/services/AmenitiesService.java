package com.asu.mapmemate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asu.mapmemate.models.Amenity;
import com.asu.mapmemate.models.Apartment;
import com.asu.mapmemate.ontologies.Amenities;

@Service
public class AmenitiesService {
	
	@Autowired
	private Amenities amenities;
	
	public List<Amenity> getAmenitiesDetails(String query, String type){
		return amenities.executeQuery(query, type);
	}

}
