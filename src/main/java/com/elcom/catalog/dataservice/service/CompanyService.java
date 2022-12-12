package com.elcom.catalog.dataservice.service;

import java.util.Optional;

import com.elcom.catalog.dataservice.root.Company;
import com.elcom.catalog.dataservice.root.dto.CompanyDTO;
import com.elcom.catalog.dataservice.root.dto.CompanyDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.CompanyInfoDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

public interface CompanyService {
	
	public Optional<Company> getCompany(Company companyDTO);
	public CompanyDTO getCompanyById(Long id);
	public CompanyDTO saveCompany(CompanyDTO companyDTO);
	public CompanyDTO saveDetachedCompany(CompanyDetachedDTO companyDTO);	

	// hibernate search methods
	public SearchResponse searchCompany(SearchCriteria searchCriteria);
	public Optional<Company> matchCompanyByCriteria(CompanyInfoDTO companyInfo);
	public String generateCompanyKey1(CompanyInfoDTO companyInfo);
}
