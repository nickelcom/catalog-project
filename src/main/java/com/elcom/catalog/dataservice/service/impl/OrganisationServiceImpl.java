package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.OrganisationRepository;
import com.elcom.catalog.dataservice.root.Organisation;
import com.elcom.catalog.dataservice.root.dto.OrganisationDTO;
import com.elcom.catalog.dataservice.service.OrganisationService;

@Service
public class OrganisationServiceImpl implements OrganisationService {
	
	@Autowired
	OrganisationRepository organisationRepository;

	@Override
	public OrganisationDTO getOrganisation(OrganisationDTO organisationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganisationDTO getOrganisationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrganisation(OrganisationDTO organisationDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrganisationDTO> searchOrganisation(String searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
