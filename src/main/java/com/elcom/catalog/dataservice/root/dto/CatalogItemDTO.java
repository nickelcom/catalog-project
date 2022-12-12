package com.elcom.catalog.dataservice.root.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.hibernate.search.annotations.Indexed;
import org.springframework.validation.annotation.Validated;

import com.elcom.catalog.dataservice.root.SubstituteItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Indexed
@Validated
@Builder
public class CatalogItemDTO extends CatalogItemBaseDTO {
	

	@JsonIgnore
	private ItemDTO item;
	
	@JsonManagedReference(value="catalogItemAttributes")
	private Set<CatalogItemAttributeDTO> catalogItemAttributes;
	
	@JsonManagedReference(value="catalogItemPrice")
	private Set<CatalogItemPriceDTO> catalogItemPrice;	
	
	@JsonIgnore
	private SubstituteItem substituteItem;// refactor to DTO?

	@JsonBackReference(value="catalogItems")
	private CatalogDTO catalog;


		

}
