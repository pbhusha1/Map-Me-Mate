package com.asu.mapmemate.ontologies;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Repository;

import com.asu.mapmemate.models.Apartment;

@Repository
public class Apartments {

	private Properties properties;
	
	public Apartments() {
		properties = new Properties();
		
	}
	
	public List<Apartment> executeQuery(String BASE_QUERY){
		
		String BASE_URL = "http://localhost:3030/Apartment/query";
		QueryExecution queryExFactory = null;
		
		List<Apartment> apartmentsList = new ArrayList<>();
		
		try {
			queryExFactory = QueryExecutionFactory.sparqlService(BASE_URL, BASE_QUERY);
			ResultSet results = queryExFactory.execSelect();
			
			while (results.hasNext()) {
				Apartment apt = new Apartment();
				QuerySolution result = results.next();
				
				String name = result.get("Name") != null ? result.get("Name").toString() : "NONE";
				String address = result.get("Address") != null ? result.get("Address").toString() : "NONE";
				String contact = result.get("PhoneNumber") != null ? result.get("PhoneNumber").toString() : "NONE";
				String rentRange = result.get("RentRange") != null ? result.get("RentRange").toString() : "NONE";
				String directionURL = result.get("DURL") != null ? result.get("DURL").toString() : "NONE";
				String description = result.get("Description") != null ? result.get("Description").toString() : "NONE";
				String apartmentURL = result.get("AURL") != null ? result.get("AURL").toString() : "NONE";
				String rating = result.get("Rating") != null ? result.get("Rating").toString() : "NONE";
				String imageURL = result.get("URL") != null ? result.get("URL").toString() : "NONE";
				
				apt.setName(name);
				apt.setAddress(address);
				apt.setContact(contact);
				apt.setRentRange(rentRange);
				apt.setDirectionURL(directionURL);
				apt.setDescription(description);
				apt.setApartmentURL(apartmentURL);
				apt.setRating(rating);
				apt.setImageURL(imageURL);
				
				apartmentsList.add(apt);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (queryExFactory != null) {
				queryExFactory.close();
			}
		}
		
		return apartmentsList;
		
	}
	
	
	@SuppressWarnings("unused")
	public Apartment executeQueryD(String BASE_QUERY){
		
		String BASE_URL = "http://localhost:3030/Apartment/query";
		QueryExecution queryExFactory = null;
		
		Apartment apt = new Apartment();
		
		try {
			queryExFactory = QueryExecutionFactory.sparqlService(BASE_URL, BASE_QUERY);
			ResultSet results = queryExFactory.execSelect();

			while (results.hasNext()) {
				
				QuerySolution result = results.next();
				
				String name = result.get("Name") != null ? result.get("Name").toString() : "NONE";
				String address = result.get("Address") != null ? result.get("Address").toString() : "NONE";
				String contact = result.get("PhoneNumber") != null ? result.get("PhoneNumber").toString() : "NONE";
				String rentRange = result.get("RentRange") != null ? result.get("RentRange").toString() : "NONE";
				String directionURL = result.get("DURL") != null ? result.get("DURL").toString() : "NONE";
				String description = result.get("Description") != null ? result.get("Description").toString() : "NONE";
				String apartmentURL = result.get("AURL") != null ? result.get("AURL").toString() : "NONE";
				String rating = result.get("Rating") != null ? result.get("Rating").toString() : "NONE";
				String imageURL = result.get("URL") != null ? result.get("URL").toString() : "NONE";
				
				rating = rating.replace("^^http://www.w3.org/2001/XMLSchema#decimal", "");
				apt.setName(name);
				apt.setAddress(address);
				apt.setContact(contact);
				apt.setRentRange(rentRange);
				apt.setDirectionURL(directionURL);
				apt.setDescription(description);
				apt.setApartmentURL(apartmentURL);
				apt.setRating(rating);
				apt.setImageURL(imageURL);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (queryExFactory != null) {
				queryExFactory.close();
			}
		}
		
		return apt;
	}

	public String executeQueryID(String BASE_QUERY) {
		
		String BASE_URL = "http://localhost:3030/Apartment/query";
		QueryExecution queryExFactory = null;
		String aptID = "";
		
		try {
			queryExFactory = QueryExecutionFactory.sparqlService(BASE_URL, BASE_QUERY);
			ResultSet results = queryExFactory.execSelect();

			while (results.hasNext()) {
				
				QuerySolution result = results.next();
				
				aptID = result.get("IDA") != null ? result.get("IDA").toString() : "NONE";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (queryExFactory != null) {
				queryExFactory.close();
			}
		}
		
		return aptID;
	}
}
