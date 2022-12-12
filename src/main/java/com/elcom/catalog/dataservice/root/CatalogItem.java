package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the CATALOG_ITEM database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="CATALOG_ITEM")
public class CatalogItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATALOG_ITEM_ID_GENERATOR", sequenceName="CATALOG_ITEM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOG_ITEM_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CATALOG_ITEM_ITEM_ID"), name = "ITEM_ID", nullable=true, referencedColumnName = "id")
	@JsonBackReference
	private Item item;

	@OneToMany(mappedBy = "catalogItem" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<CatalogItemAttribute> catalogItemAttributes;
	
	@OneToMany(mappedBy = "catalogItem", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<CatalogItemPrice> catalogItemPrice;
	
	@Column(name="SUPPLIER_PART_NO", length=100)
	private String supplierPartNo;
	
	@Column(name="UOM_QTY", length=10)
	private Long uomQty;
	
	@Column(name="NAME", length=50)
	private String name;

	@Column(name="DESCRIPTION", length=255)
	private String description;

	@Column(name="TYPE", length=10)
	private String type;
	
	@Column(name="PREFERRED_ITEM_ORDER", length=10)
	private String preferredItemOrder;
	
	@Column(name="ITEM_BAND", length=10)
	private String itemBand;

	@Column(name="VALIDATED", nullable=false, length=1)
	private String validated;
	
	@Column(name="EXPENSE_CODE", nullable=false, length=10)
	private String expenseCode;
	
	@Column(name="PENDING_FROM", nullable=false, length=10)
	private String pendingFrom;

	@Column(name="HCTED", nullable=false, length=10)
	private String hcted;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CATALOG_ITEM_SUBSTITUTE_ITEM_ID"), name="SUBSTITUTE_ITEM_ID", insertable=false, updatable=false)
	@JsonBackReference
	private SubstituteItem substituteItem;
	
	@ManyToMany(mappedBy = "catalogItems")
	@JsonBackReference
	Set<Catalog> catalogs = new HashSet<>();
	
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
	
	public void addCatalog(Catalog catalog) {
		this.catalogs.add(catalog);
	}
	
}