package com.elcom.catalog.dataservice.root.dto;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ItemAssetDetachedDTO extends ItemAssetBaseDTO {
	
	private Long itemId;
	
	private String action;
}
