package com.asu.mapmemate.queries;

public class Accomdations {
	
	//PREFIX
	public static String PREFIX = "PREFIX apt: <http://www.semanticweb.org/Apartment#>\r\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
			+ "PREFIX Temp: <http://www.semanticweb.org/TemporaryLeasingPerson#>\r\n"
			+ "PREFIX ApartAmen: <http://www.semanticweb.org/ApartmentAmenities#>"
			+ " \r\n";
	
	//GET APARTMENT ID BY UNIVERSITY NAME
	public static String APARTENTID_BYUNAME = "SELECT Distinct ?IDA"
			+ "	WHERE {\r\n"
			+ " ?APT rdf:type apt:Apartment.\r\n"
			+ " ?APT apt:hasApartmentID ?IDA.\r\n"
			+ " ?APT apt:hasApartmentName ?Name.\r\n"
			+ " \r\n";
	
	//GET ACCOMDATION FULL DETAILS
	public static String ACCOMDATION_DETAILS = "SELECT Distinct ?PName ?CourseName ?GName ?NName ?Sem ?RPDay ?RPWeek ?RPMonth ?WillNegotiate\r\n"
			+ "WHERE {\r\n"
			+ "  ?APT rdf:type Temp:Apartment.\r\n"
			+ "  ?APT Temp:hasApartmentID ?IDA.\r\n"
			+ "  ?APT Temp:hasLeasingPerson ?PID.\r\n"
			+ "  ?PID Temp:hasName ?PName.\r\n"
			+ "  ?PID Temp:hasCourse ?Course.\r\n"
			+ "  ?Course Temp:hasCourseName ?CourseName.\r\n"
			+ "  ?PID Temp:isOfGenderType ?Gtype.\r\n"
			+ "  ?Gtype Temp:hasGenderName ?GName.\r\n"
			+ "  ?PID Temp:hasNationality ?NID.\r\n"
			+ "  ?NID Temp:hasNationalityName ?NName.\r\n"
			+ "  ?PID Temp:isOfSemester ?Sem.\r\n"
			+ "  ?PID Temp:expectsRentPerDay ?RPDay.\r\n"
			+ "  ?PID Temp:expectsRentPerWeek ?RPWeek.\r\n"
			+ "  ?PID Temp:expectsRentPerMonth ?RPMonth.\r\n"
			+ "  ?PID Temp:willNegotiateAmount ?WillNegotiate.\r\n"
			+ " \r\n";
				
	//FILTER BY APT NAME
	public static String APT_NAME_FILTER = "FILTER(?Name='";
	
	//FILTER BY APT ID
	public static String APT_ID_FILTER = "FILTER(?IDA='";
	
	
}
