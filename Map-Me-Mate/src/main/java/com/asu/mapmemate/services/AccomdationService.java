package com.asu.mapmemate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asu.mapmemate.models.Accomdation;
import com.asu.mapmemate.ontologies.Accomdations;

@Service
public class AccomdationService {
	
	@Autowired
	private Accomdations accomdations;
	
	public List<Accomdation> getTempAccomdationDetails(String query) {
		return accomdations.executeQuery(query);
	}

}
