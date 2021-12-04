package com.asu.mapmemate.queries;

public class Amenities {
	
		//PREFIX
		public static String PREFIX = "PREFIX apt: <http://www.semanticweb.org/Apartment#>\r\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
				+ "PREFIX Temp: <http://www.semanticweb.org/TemporaryLeasingPerson#>\r\n"
				+ "PREFIX ApartAmen: <http://www.semanticweb.org/ApartmentAmenities#>"
				+ " \r\n";
		
		//GET GROCERIES NEAR BY APARTMENT
		public static String NEARBY_GROCERIES = "SELECT Distinct ?GSName ?GSDist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasGroceryStore ?GSID.\r\n"
				+ "  ?GSID ApartAmen:hasGrocerieStoreName ?GSName.\r\n"
				+ "  ?GSID ApartAmen:GrocerieStoreDistance ?GSDist."
				+ "  \r\n";
		
		//GET BANKS NEAR BY APARTMENT
		public static String NEARBY_BANKS = "SELECT Distinct  ?BName ?BDist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasBank ?BID.\r\n"
				+ "  ?BID ApartAmen:hasBankName ?BName.\r\n"
				+ " ?BID ApartAmen:BankDistance ?BDist.\r\n"
				+ "  \r\n";
		
		//GET FOODOUTS NEAR BY APARTMENT
		public static String NEARBY_FOODOUTS = "SELECT Distinct  ?FOName ?FODist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasFoodOutlet ?FOID.\r\n"
				+ "  ?FOID ApartAmen:hasFoodOutletName ?FOName.\r\n"
				+ "  ?FOID ApartAmen:FoodOutletDistance ?FODist.\r\n"
				+ "  \r\n";
		
		//GET ATMS NEAR BY APARTMENT
		public static String NEARBY_ATMS = "SELECT Distinct  ?ATMName ?ATMDist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasATM ?ATMID.\r\n"
				+ "  ?ATMID ApartAmen:hasATMName ?ATMName.\r\n"
				+ "  ?ATMID ApartAmen:ATMDistance ?ATMDist."
				+ "  \r\n";
		
		//GET HOSPITALS NEAR BY APARTMENT
		public static String NEARBY_HOSPITALS = "SELECT Distinct  ?HName ?HDist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasHospital ?HID.\r\n"
				+ "  ?HID ApartAmen:hasHospitalName ?HName.\r\n"
				+ "  ?HID ApartAmen:HospitalDistance ?HDist."
				+ "  \r\n";
		
		//GET BUSES NEAR BY APARTMENT
		public static String NEARBY_BUSES = "SELECT Distinct  ?BSName ?BSDist\r\n"
				+ "  WHERE {\r\n"
				+ "  ?APT rdf:type ApartAmen:Apartment.\r\n"
				+ "  ?APT ApartAmen:hasApartmentID ?IDA.\r\n"
				+ "  ?APT ApartAmen:hasBustop ?BSID.\r\n"
				+ "  ?BSID ApartAmen:hasBusStopName ?BSName.\r\n"
				+ "  ?BSID ApartAmen:BusStopDistance ?BSDist."
				+ "  \r\n";
		
		//FILTER BY APT ID
		public static String APT_ID_FILTER = "FILTER(?IDA='";

}
