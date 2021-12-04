package com.asu.mapmemate.ontologies;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Repository;

import com.asu.mapmemate.models.Accomdation;

@Repository
public class Accomdations {
	
private Properties properties;
	
	public Accomdations() {
		properties = new Properties();
		
	}
	
	public List<Accomdation> executeQuery(String BASE_QUERY){
		
		String BASE_URL = "http://localhost:3030/Apartment/query";
		QueryExecution queryExFactory = null;
		
		List<Accomdation> accomdationsList = new ArrayList<>();
		
		try {
			queryExFactory = QueryExecutionFactory.sparqlService(BASE_URL, BASE_QUERY);
			ResultSet results = queryExFactory.execSelect();
			
			while (results.hasNext()) {
				
				Accomdation accd = new Accomdation();
				QuerySolution result = results.next();
				
				String personName = result.get("PName") != null ? result.get("PName").toString() : "NONE";
				String courseName = result.get("CourseName") != null ? result.get("CourseName").toString() : "NONE";
				String gender = result.get("GName") != null ? result.get("GName").toString() : "NONE";
				String nationality = result.get("NName") != null ? result.get("NName").toString() : "NONE";
				String semester = result.get("Sem") != null ? result.get("Sem").toString() : "NONE";
				String rentPerDay = result.get("RPDay") != null ? result.get("RPDay").toString() : "NONE";
				String rentPerWeek = result.get("RPWeek") != null ? result.get("RPWeek").toString() : "NONE";
				String rentPerMonth = result.get("RPMonth") != null ? result.get("RPMonth").toString() : "NONE";
				String willNegotiate = result.get("WillNegotiate") != null ? result.get("WillNegotiate").toString() : "NONE";
				
				semester = semester.replace("^^http://www.w3.org/2001/XMLSchema#integer", "");
				rentPerDay = rentPerDay.replace("^^http://www.w3.org/2001/XMLSchema#integer", "");
				rentPerWeek = rentPerWeek.replace("^^http://www.w3.org/2001/XMLSchema#integer", "");
				rentPerMonth = rentPerMonth.replace("^^http://www.w3.org/2001/XMLSchema#integer", "");
				willNegotiate = willNegotiate.replace("^^http://www.w3.org/2001/XMLSchema#boolean", "");
				if (willNegotiate == "false")
					willNegotiate = "No";
				else
					willNegotiate = "Yes";
				accd.setPersonName(personName);
				accd.setCourseName(courseName);
				accd.setSemester(semester);
				accd.setNationality(nationality);
				accd.setGender(gender);
				accd.setRentPerDay(rentPerDay);
				accd.setRentPerWeek(rentPerWeek);
				accd.setRentPerMonth(rentPerMonth);
				accd.setWillNegotiate(willNegotiate);
				
				accomdationsList.add(accd);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (queryExFactory != null) {
				queryExFactory.close();
			}
		}
		
		return accomdationsList;
		
	}
	
	
}
