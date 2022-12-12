package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.elcom.catalog.dataservice.root.Catalog;
import com.elcom.catalog.dataservice.root.dto.CatalogDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

public interface CatalogService {

	public Optional<CatalogDTO> getCatalog(Catalog catalog);
	public Optional<CatalogDTO> getCatalogById(Long id);
	public CatalogDTO saveCatalog(CatalogDTO catalog);
	public CatalogDTO togglecatalogActiveStatus(Long catalogId);
	public void deleteCatalog(CatalogDTO catalogDTO);
	
	// hibernate search methods
	public List<Catalog> searchCatalog(String searchCriteria);
	public SearchResponse searchCatalog(SearchCriteria searchCriteria);
	
	// gets all
	List<CatalogDTO> findAllCatalog();
	
	// temporary
	public CatalogDTO deleteCatalogCatalogItem(Long catalogId, Long catalogItemId);
	
	
	

}
