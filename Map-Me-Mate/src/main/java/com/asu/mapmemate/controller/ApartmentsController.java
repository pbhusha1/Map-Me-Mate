package com.asu.mapmemate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asu.mapmemate.models.Accomdation;
import com.asu.mapmemate.models.Amenity;
import com.asu.mapmemate.models.Apartment;
import com.asu.mapmemate.queries.Accomdations;
import com.asu.mapmemate.queries.Apartments;
import com.asu.mapmemate.queries.Amenities;
import com.asu.mapmemate.services.AccomdationService;
import com.asu.mapmemate.services.AmenitiesService;
import com.asu.mapmemate.services.ApartmentService;

@Controller
@RequestMapping("/")
public class ApartmentsController {
	
	@Autowired
	private ApartmentService aptService;
	
	@Autowired
	private AccomdationService accdService;
	
	@Autowired
	private AmenitiesService amenService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/searchapartments")
	public String apartmentsSearchByUniversity(@RequestParam(required = false) String uname, 
			HttpServletRequest request) {
		
		String query = Apartments.PREFIX + "\r\n" + Apartments.APARTENTS_SEARCH_BYUNAME + Apartments.UNAME_FILTER +uname+"')}";
		
		List<Apartment> apartments = aptService.listAllApartmentsByUniversity(query);
		
		List[] parts = equalPartition(apartments);
		
		request.setAttribute("apartments1",parts[0]);
		request.setAttribute("apartments2",parts[1]);
		
		request.setAttribute("queryMsg", "The following apartments were located near "+uname);
		request.setAttribute("uname", uname);
		request.setAttribute("mode", "MODE_RESULTS");
		
		return "homepage";
	}
	
	@SuppressWarnings("rawtypes")
	public static List[] equalPartition(List<Apartment> original)
    {
        int size = original.size();
        List<Apartment> first = new ArrayList<>(original.subList(0, (size) / 2));
        List<Apartment> second = new ArrayList<>(original.subList((size) / 2, size));
        return new List[] { first, second };
    }

	@SuppressWarnings("rawtypes")
	@RequestMapping("/searchapartments_filters")
	public String apartmentsSearchByFilters(@RequestParam(required = false) String min_rent, 
			String max_rent, String rating, String hideuname, HttpServletRequest request) {
		
		int APT_MIN_RENT = Integer.parseInt(min_rent);
		int APT_MAX_RENT = Integer.parseInt(max_rent);
		int APT_RATING = Integer.parseInt(rating);
		String U_NAME = hideuname;
		
		String query = Apartments.PREFIX + "\r\n" + Apartments.APARTENTS_SEARCH_BYUNAME_RR
				+ Apartments.UNAME_FILTER +U_NAME+"')\r\n" + Apartments.MIN_RENT_FILTER + APT_MIN_RENT+")\r\n"+ Apartments.MAX_RENT_FILTER +APT_MAX_RENT+")\r\n"+ Apartments.RATING_FILTER+ APT_RATING+")\r\n}";
		
		List<Apartment> apartments = aptService.listAllApartmentsByUniversity(query);
		
		List[] parts = equalPartition(apartments);
		
		request.setAttribute("apartments1",parts[0]);
		request.setAttribute("apartments2",parts[1]);
		
		request.setAttribute("queryMsg", "The following apartments were located near "+U_NAME);
		request.setAttribute("uname", U_NAME);
		request.setAttribute("mode", "MODE_RESULTS");
		
		return "homepage";
	}
	
	@RequestMapping("/apartmentdetails")
	public String showApartmentDetails(@RequestParam(required = false) String apt_name, HttpServletRequest request) {
		
		String APT_NAME = apt_name;
		
		String query1 = Apartments.PREFIX + "\r\n" + Apartments.APARTMENTS_FULL_DETAILS
				+ Apartments.APT_NAME_FILTER +APT_NAME+"')\r\n}";
		
		String queryID = Accomdations.PREFIX + "\r\n" + Accomdations.APARTENTID_BYUNAME
				+ Accomdations.APT_NAME_FILTER +APT_NAME+"')\r\n}";
		
		String APT_ID = aptService.getApartmetntID(queryID);
		
		String query2 = Accomdations.PREFIX + "\r\n" + Accomdations.ACCOMDATION_DETAILS
				+ Accomdations.APT_ID_FILTER +APT_ID+"')\r\n}";
		
		List<Accomdation> accomdations = accdService.getTempAccomdationDetails(query2);
		
		Apartment apartment = aptService.getApartmentDetails(query1);
		
		request.setAttribute("apartment",apartment);
		request.setAttribute("accomdations",accomdations);
		request.setAttribute("mode", "MODE_APT_DETAILS");
		
		return "homepage";
	}
	
	@RequestMapping(value="/temp_accomdation_details", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Accomdation> showTempAccomdationDetails(@RequestParam(required = false) String apt_name,
			HttpServletRequest request) {
		
		String APT_NAME = apt_name;
		
		String queryID = Accomdations.PREFIX + "\r\n" + Accomdations.APARTENTID_BYUNAME
				+ Accomdations.APT_NAME_FILTER +APT_NAME+"')\r\n}";
		
		String APT_ID = aptService.getApartmetntID(queryID);
		
		String query2 = Accomdations.PREFIX + "\r\n" + Accomdations.ACCOMDATION_DETAILS
				+ Accomdations.APT_ID_FILTER +APT_ID+"')\r\n}";
		
		List<Accomdation> accomdations = accdService.getTempAccomdationDetails(query2);
		
		return accomdations;
	}
	
	@RequestMapping(value="/show_amenities_details", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Amenity> showNearByAmenities(@RequestParam(required = false) String apt_name,
			String type, HttpServletRequest request) {
		
		String APT_NAME = apt_name;
		
		String queryID = Accomdations.PREFIX + "\r\n" + Accomdations.APARTENTID_BYUNAME
				+ Accomdations.APT_NAME_FILTER +APT_NAME+"')\r\n}";
		
		String APT_ID = aptService.getApartmetntID(queryID);
		
		String QUERY = "";
		
		if(type.equals("stores")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_GROCERIES
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else if(type.equals("foods")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_FOODOUTS
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else if(type.equals("banks")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_BANKS
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else if(type.equals("buses")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_BUSES
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else if(type.equals("hospitals")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_HOSPITALS
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else if(type.equals("atms")) {
			QUERY = Amenities.PREFIX + "\r\n" + Amenities.NEARBY_ATMS
					+ Amenities.APT_ID_FILTER +APT_ID+"')\r\n}";
		}else {
			System.out.println("case not matched!!");
		}
			
		List<Amenity> amenities = amenService.getAmenitiesDetails(QUERY, type);
		
		return amenities;
	}
}
