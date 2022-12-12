package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the CATALOG_ITEM_PRICE database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CATALOG_ITEM_PRICE")
public class CatalogItemPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATALOG_ITEM_PRICE_ID_GENERATOR", sequenceName="CATALOG_ITEM_PRICE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOG_ITEM_PRICE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CATALOG_ITEM_PRICE_ID"), name = "CATALOG_ITEM_ID", referencedColumnName = "id")
	@JsonManagedReference
	private CatalogItem catalogItem;
	
	@Column(name="NET_AMOUNT", nullable = false, precision = 10, scale = 4)
	private BigDecimal listPrice;

	@Column(name="CURRENCY", length=3) // iso currency code
	private String currency;
	
	@Column(name="PRICE_TYPE", length=16) // e.g. public / buyer
	private String priceType;
	
	@Column(name="PRICE_BREAK_MIN_QTY")
	private Integer priceBreakMinQty;
	
	@Column(name="PRICE_BREAK_MAX_QTY")
	private Integer priceBreakMaxQty;
	
	@Column(name="PRICE_BREAK_STYLE", length=16) // straight line / cumulative
	private Integer priceBreakStyle;
	
	@Column(name="VALID_FROM")
	private Date validFrom;
	
	@Column(name="VALID_TO")
	private Date validTo;
	
	@Column(name="LEAD_TIME", length=50)
	private String leadTime;
	
	@Column(name="MIN_ORDER_QTY")
	private Integer minOrderQty;
	
	@Column(name="MAX_ORDER_QTY")
	private Integer maxOrderQty;
	
	@Column(name="TAX", length=50)
	private String tax;
	
	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;

	@CreationTimestamp
	@JsonIgnore
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@JsonIgnore
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;
}