package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CatalogItemRepository;
import com.elcom.catalog.dataservice.repository.CatalogRepository;
import com.elcom.catalog.dataservice.root.Catalog;
import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.dto.CatalogDTO;
import com.elcom.catalog.dataservice.search.dao.SearchDao;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.CatalogService;
@Service
public class CatalogServiceImpl extends BaseServiceImpl implements CatalogService  {

	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	CatalogItemRepository catalogItemRepository;



	@Autowired
	SearchDao searchDao;


	@Override
	public Optional<CatalogDTO> getCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatalogDTO> findAllCatalog(){
		return catalogRepository.findAll().stream().map(object ->(CatalogDTO) mapObject(object, CatalogDTO.class)).toList();
	}

	@Override
	public Optional<CatalogDTO> getCatalogById(Long id) {

		Optional<Catalog> catalog = catalogRepository.findById(id);

		if (catalog.isPresent()) {
			return Optional.of((CatalogDTO) mapObject(catalog.get(), CatalogDTO.class));
		}
		return null;
		//return catalogRepository.findById(id);
	}

	@Override
	public CatalogDTO saveCatalog(CatalogDTO catalogDTO) {
		Catalog Catalog = (Catalog) mapObject(catalogDTO, Catalog.class);
		Catalog = catalogRepository.saveAndFlush(Catalog);

		return (CatalogDTO) mapObject(Catalog, CatalogDTO.class);
	}

	@Override
	public List<Catalog> searchCatalog(String searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchResponse searchCatalog(SearchCriteria searchCriteria) {

		searchCriteria.setFieldToSearch("catalog.combined");
		searchCriteria.setAdditionalFieldsToSearch(new String[] {"company.companyName","organisation.name"});
		searchCriteria.setSearchFacets(new String[] {"company.cname_facet","organisation.oname_facet"});
		searchCriteria.setObjectToSearch(Catalog.class);
		searchCriteria.setObjectToReturn(CatalogDTO.class);

		return searchDao.search(searchCriteria);

	}

	@Override
	public CatalogDTO togglecatalogActiveStatus(Long catalogId) {
		Optional<Catalog> catalogOpt = catalogRepository.findById(catalogId);

		if (catalogOpt.isPresent()) {
			Catalog catalog = catalogOpt.get();
			String activeStatus = catalog.getActiveFlag();
			catalog.setActiveFlag("Y".equals(activeStatus) ? "N" : "Y");
			catalog = catalogRepository.saveAndFlush(catalog);

			return (CatalogDTO) mapObject(catalog, CatalogDTO.class);
		}
		return null;
	}

	@Override
	public void deleteCatalog(CatalogDTO catalogDTO) {
		catalogRepository.deleteById(catalogDTO.getId());

	}

	// temporary
	@Override
	public CatalogDTO deleteCatalogCatalogItem(Long catalogId, Long catalogItemId) {
		
		// retrieve catalog to remove item ref from  and catalog from which i want to remove it
		Optional<Catalog> catalogOpt = catalogRepository.findById(catalogId);
		Optional<CatalogItem> catalogItemOpt = catalogItemRepository.findById(catalogItemId);
		
		
		// remove the catalogitem from the set of catalog items within that that table
		if (catalogOpt.isPresent() && catalogItemOpt.isPresent()) {
			// get the actual objects
			Catalog catalog = catalogOpt.get();
			CatalogItem catalogItem = catalogItemOpt.get();
			catalog.getCatalogItems().remove(catalogItem);
			catalog = catalogRepository.saveAndFlush(catalog);
			return (CatalogDTO) mapObject(catalog, CatalogDTO.class);
		}
		return null;
	}

}
