package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CompanyAddressRepository;
import com.elcom.catalog.dataservice.root.CompanyAddress;
import com.elcom.catalog.dataservice.service.CompanyAddressService;

@Service
public class CompanyAddressServiceImpl implements CompanyAddressService {
	
	@Autowired
	CompanyAddressRepository companyAddressRepository;

	@Override
	public Optional<CompanyAddress> getCompanyAddress(CompanyAddress CompanyAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CompanyAddress> getCompanyAddressById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCompanyAddress(CompanyAddress CompanyAddress) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompanyAddress> searchCompanyAddress(String searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDetachedCompanyAddress(CompanyAddress CompanyAddress) {
		// TODO Auto-generated method stub
		
	}

}
