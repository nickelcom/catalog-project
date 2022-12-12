package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.CatalogItemPrice;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDetachedDTO;

public interface CatalogItemService {
	
	public Optional<CatalogItem> getCatalogItem(CatalogItem catalogItem);
	public Optional<CatalogItem> getCatalogItemById(Long id);
	public void saveCatalogItem(CatalogItem catalogItem);
	public CatalogItemDTO saveDetachedCatalogItem(CatalogItemDetachedDTO catalogItem);
	public void deleteCatalogItem(Long id);
	public List<CatalogItem> getAllCatalogItems();
	


}
