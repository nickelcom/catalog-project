package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Facet;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistent class for the ITEM database table.
 * 
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Indexed
@Table(name="ITEM")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITEM_ID_GENERATOR", sequenceName="ITEM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Field
	@Field(name="item.combined")
	@Column(name="NAME", length=100)
	private String name;

	@Field
	@Field(name="item.combined")
	@Column(name="TYPE", length=10)
	private String type;

	@Field
	@Field(name="item.combined")
	@Column(name="DESCRIPTION", length=255)
	private String description;

	@Field
	@Field(name="item.combined")
	@Column(name="BRAND", length=128)
	@Field(name = "brand_for_facet", analyze = Analyze.NO)
	@Facet(name = "brand_facet", forField = "brand_for_facet")
	private String brand;
	
	@Field
	@Field(name="combined")
	@Column(name="LONG_DESCRIPTION", length=500)
	private String longDescription;

	@Field
	@Field(name="item.combined")
	@Column(name="UOM", length=10)
	private String uom;

	@Field
	@Field(name="item.combined")
	@Column(name="SYNONYMS", length=500)
	private String synonyms;
	
	@Field
	@Column(name="MSRP", length=500)
	private float msrp;
	
	@Field
	@Field(name="item.combined")
	@Column(name="REPLACEMENT_MFGR_NO", length=100)
	private String replacementMfgrNo;
	
	@Field
	@Column(name="GS1_GPC_CODE", length=10)
	private long gs1GpcCode;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_ITEM_COMPANY_ID"), name = "COMPANY_ID", nullable=true, referencedColumnName = "id")
	@IndexedEmbedded(depth=1)
	@JsonBackReference
	private Company company;
	
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<ItemTaxonomy> itemTaxonomy;

	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<ItemChangeLog> itemChangeLog;

	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<ItemAsset> itemAsset;

	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<ItemBarcode> itemBarCode;
	
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<ItemAttribute> itemAttribute;
	
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY,cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@JsonIgnore
	private Set<CatalogItem> catalogItem;

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