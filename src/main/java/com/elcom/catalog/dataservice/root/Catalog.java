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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the CATALOG_ITEM database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Indexed
@Table(name="CATALOG")
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATALOG_ID_GENERATOR", sequenceName="CATALOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOG_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CATALOG_COMPANY_ID"), name = "COMPANY_ID", nullable=true, referencedColumnName = "id")
	@IndexedEmbedded
	private Company company;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CATALOG_ORG_ID"), name = "ORGANISATION_ID", nullable=true, referencedColumnName = "id")
	@IndexedEmbedded
	private Organisation organisation;

	@Column(name="KEY", length=50)
	@Field
	@Field(name="catalog.combined")
	private String key;
	
	@Column(name="NAME", length=50)
	@Field
	@Field(name="catalog.combined")
	private String name;

	@Column(name="DESCRIPTION", length=255)
	@Field
	@Field(name="catalog.combined")
	private String description;

	@Column(name="TYPE", length=10)
	@Field
	@Field(name="catalog.combined")
	private String type;
	
	@Column(name="VERSION")
	private Integer version;
	
	@Column(name="SITE", length=50)
	@Field
	@Field(name="catalog.combined")
	private String site;
	
	// this cascade type seems to be one that is recommended as safe... although i think all apart from REMOVE seem to be safe to use with @ManyToMany 
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.DETACH})
	@JoinTable(name = "catalog_catalog_item", 
			   joinColumns = @JoinColumn(name = "catalog_id", foreignKey = @ForeignKey(name = "FK_CATALOG_CHILD_ID")), 
			   inverseJoinColumns = @JoinColumn(name = "catalog_item_id", foreignKey = @ForeignKey(name = "FK_CATALOG_ITEM_CHILD_ID")))
	@JsonManagedReference
	@JsonIgnore
	Set<CatalogItem> catalogItems;
	
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
	
	// self join
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_CATALOG_ID", foreignKey = @ForeignKey(name = "FK_CATALOG_ID"))
	@JsonManagedReference
	private Catalog parentCatalog;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="parentCatalog", fetch=FetchType.LAZY, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonBackReference
	private Set<Catalog> childCatalog;
	
}