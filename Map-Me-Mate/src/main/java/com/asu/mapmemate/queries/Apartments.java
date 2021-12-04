package com.asu.mapmemate.queries;

public class Apartments {
	
	//PREFIX
	public static String PREFIX = "PREFIX apt: <http://www.semanticweb.org/Apartment#>\r\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
			+ "PREFIX Temp: <http://www.semanticweb.org/TemporaryLeasingPerson#>\r\n"
			+ "PREFIX ApartAmen: <http://www.semanticweb.org/ApartmentAmenities#>"
			+ " \r\n";
	
	//SEARCH APARTMENTS BY UNIVERSITY NAME
	public static String APARTENTS_SEARCH_BYUNAME = "SELECT Distinct ?Name \r\n"
			+ "WHERE {\r\n"
			+ "  ?APT rdf:type apt:Apartment.\r\n"
			+ "  ?APT apt:hasApartmentID ?IDA.\r\n"
			+ "  ?APT apt:hasApartmentName ?Name.\r\n"
			+ "  ?APT apt:isAroundUniversity ?UNIV.\r\n"
			+ "  ?UNIV apt:hasUniversityID ?UNIID.\r\n"
			+ "  ?UNIV apt:hasUniversityName ?UNAME\r\n"
			+ " \r\n";
	
	//SEARCH APARTMENTS BY UNIVERSITY NAME WITH RENT & RATING FILTERS
	public static String APARTENTS_SEARCH_BYUNAME_RR = "SELECT Distinct ?Name \r\n"
				+ "WHERE {\r\n"
				+ "  ?APT rdf:type apt:Apartment.\r\n"
				+ "  ?APT apt:hasApartmentID ?IDA.\r\n"
				+ "  ?APT apt:hasApartmentName ?Name.\r\n"
				+ "  ?APT apt:isAroundUniversity ?UNIV.\r\n"
				+ "  ?UNIV apt:hasUniversityID ?UNIID.\r\n"
				+ "  ?UNIV apt:hasUniversityName ?UNAME.\r\n"
				+ "  ?APT apt:hasRating ?Rating.\r\n"
				+ "  ?APT apt:hasMinRent ?Minrent.\r\n"
				+ "  ?APT apt:hasMaxRent ?Maxrent.\r\n"
				+ " \r\n";
	
	//DISPLAY APARTMENT FULL DETAILS
	public static String APARTMENTS_FULL_DETAILS = "SELECT Distinct ?Name ?Address ?PhoneNumber ?RentRange "
				+ " ?DURL ?Description ?AURL ?Rating ?URL \r\n"
				+ " WHERE {\r\n"
				+ " ?APT rdf:type apt:Apartment.\r\n"
				+ " ?APT apt:hasApartmentID ?IDA.\r\n"
				+ " ?APT apt:hasApartmentName ?Name.\r\n"
				+ " ?APT apt:hasApartmentAddress ?Address.\r\n"
				+ " ?APT apt:hasApartmentPhoneNumber ?PhoneNumber.\r\n"
				+ " ?APT apt:hasApartmentRent ?RentRange.\r\n"
				+ " ?APT apt:hasDirectionURL ?DURL.\r\n"
				+ " ?APT apt:hasDecription ?Description.\r\n"
				+ " ?APT apt:hasApartmentURL ?AURL.\r\n"
				+ " ?APT apt:hasRating ?Rating.\r\n"
				+ " ?APT apt:hasImageURL ?URL.\r\n"
				+ " \r\n";
				
	//FILTER BY UNIVERSITY NAME
	public static String UNAME_FILTER = "FILTER(?UNAME='";
	
	//FILTER BY MIN RENT
	public static String MIN_RENT_FILTER = "FILTER(?Minrent>=";
	
	//FILTER BY MAX RENT
	public static String MAX_RENT_FILTER = "FILTER(?Maxrent<=";
	
	//FILTER BY RATING
	public static String RATING_FILTER = "FILTER(?Rating>=";
	
	//FILTER BY APT NAME
	public static String APT_NAME_FILTER = "FILTER(?Name='";
		
}
