package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ItemDTO {

	private Long id;
	@NotBlank(message="Item name is required")
	private String name;
	@NotBlank(message = "Item type is required")
	private String type;
	@NotBlank(message = "Item description is required")
	private String description;
	private String brand;
	private String longDescription;
	private String uom;
	private String synonyms;
	private float msrp;
	private String replacementMfgrNo;
	private long gs1GpcCode;
	
	private CompanyInfoDTO companyInfo;
	
	@Default
	@JsonManagedReference(value="itemTaxonomy")
	private Set<ItemTaxonomyDTO> itemTaxonomy = new HashSet<>();
	@Default
	@JsonManagedReference(value="itemChangeLog")
	private Set<ItemChangeLogDTO> itemChangeLog = new HashSet<>();
	@Default
	@JsonManagedReference(value="itemAsset")
	private Set<ItemAssetDTO> itemAsset = new HashSet<>();
	@Default
	@JsonManagedReference(value="itemBarCode")
	private Set<ItemBarcodeDTO> itemBarCode = new HashSet<>();
	@Default
	@JsonManagedReference(value="itemAttribute")
	private Set<ItemAttributeDTO> itemAttribute = new HashSet<>();
	@JsonIgnore
	private Set<CatalogItemDTO> catalogItem;
	@Default
	private String activeFlag = "Y";
	@JsonIgnore
	private Date dateRowAdded;
	@JsonIgnore
	private Date dateRowUpdated;
	
	public void addBarcode(ItemBarcodeDTO barcode) {
		this.itemBarCode.add(barcode);
	}
	
	public void addItemChangeLog(ItemChangeLogDTO itemChangeLog) {
		this.itemChangeLog.add(itemChangeLog);
	}
	
	public void addTaxonomy(ItemTaxonomyDTO itemTaxonomy) {
		this.itemTaxonomy.add(itemTaxonomy);
	}
	
	public void addAsset(ItemAssetDTO itemAsset) {
		this.itemAsset.add(itemAsset);
	}
	
	
}
