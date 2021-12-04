package com.asu.mapmemate.ontologies;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Repository;

import com.asu.mapmemate.models.Amenity;


@Repository
public class Amenities {
	
private Properties properties;
	
	public Amenities() {
		properties = new Properties();
		
	}
	
	public List<Amenity> executeQuery(String BASE_QUERY, String type){
		
		String BASE_URL = "http://localhost:3030/Apartment/query";
		QueryExecution queryExFactory = null;
		
		List<Amenity> amenities = new ArrayList<>();
		
		String amenityName = "";
		String amenityDistance = "";
		
		if(type.equals("stores")) {
			amenityName = "GSName";
			amenityDistance = "DSDist";
		}else if(type.equals("foods")) {
			amenityName = "FOName";
			amenityDistance = "FODist";
		}else if(type.equals("banks")) {
			amenityName = "BName";
			amenityDistance = "BDist";
		}else if(type.equals("buses")) {
			amenityName = "BSName";
			amenityDistance = "BSDist";
		}else if(type.equals("hospitals")) {
			amenityName = "HName";
			amenityDistance = "HDist";
		}else if(type.equals("atms")) {
			amenityName = "ATMName";
			amenityDistance = "ATMDist";
		}else {
			System.out.println("case not matched!!");
		}
		
		
		try {
			queryExFactory = QueryExecutionFactory.sparqlService(BASE_URL, BASE_QUERY);
			ResultSet results = queryExFactory.execSelect();
			
			while (results.hasNext()) {
				
				Amenity amenity = new Amenity();
				QuerySolution result = results.next();
				
				Random rand = new Random();
				int rint = rand.nextInt(6) + 1;
				String rIntStr = Integer.toString(rint) +"^^http://www.w3.org/2001/XMLSchema#integer";
				String amenityName_1 = result.get(amenityName) != null ? result.get(amenityName).toString() : "NONE";
				String amenityDistance_1 = result.get(amenityDistance) != null ? result.get(amenityDistance).toString() : rIntStr;
				
				amenityDistance_1 = amenityDistance_1.replace("^^http://www.w3.org/2001/XMLSchema#integer", " Miles");
				amenity.setAmenityName(amenityName_1);
				amenity.setAmenityDistance(amenityDistance_1);
				
				amenities.add(amenity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			
			if (queryExFactory != null) {
				queryExFactory.close();
			}
		}
		
		return amenities;
	}
	
}
