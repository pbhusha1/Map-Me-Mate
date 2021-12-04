package com.asu.mapmemate.modules;

import java.util.List;

import com.asu.mapmemate.models.Accomdation;
import com.asu.mapmemate.queries.Accomdations;
import com.asu.mapmemate.services.AccomdationService;
import com.asu.mapmemate.services.ApartmentService;

public class TemporaryAccomdation {
	
//	private AccomdationService accdService;
	
	private ApartmentService aptService;
	
	public List<Accomdation> temporaryAccomdationDetails(String aptname) {
		
		String query = Accomdations.PREFIX + "\r\n" + Accomdations.APARTENTID_BYUNAME + Accomdations.APT_NAME_FILTER +aptname+"')}";
		
		String aptID = aptService.getApartmetntID(query);
		
		System.out.println(aptID);
		
//		List<Accomdation> accomdations = accdService.getTempAccomdationDetails(query);
//		
//		return accomdations;
		
		return null;
		
	}
	
}
