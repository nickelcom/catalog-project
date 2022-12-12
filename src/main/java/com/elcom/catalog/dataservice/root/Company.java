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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Facet;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the COMPANY database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="COMPANY")
@Indexed
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_ID_GENERATOR", sequenceName="COMPANY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Field
	@Field(name="company.combined")
	@Field(name = "cname_for_facet", analyze = Analyze.NO)
	@Facet(name = "cname_facet", forField = "cname_for_facet")
	@Column(name="COMPANY_NAME", length=100)
	private String companyName;
	
	@Field
	@Field(name="company.combined")
	@Column(name="COMPANY_KEY_1", length=100)
	private String companyKey1;
	
	@Field
	@Field(name="company.combined")
	@Column(name="COMPANY_KEY_2", length=100)
	private String companyKey2;
	
	@Field
	@Field(name="company.combined")
	@Column(name="COMPANIES_HOUSE_NO", length=100)
	private String companiesHouseNo;
	
	@Field
	@Field(name="company.combined")
	@Column(name="DUNS_NO", length=100)
	private String dunsNo;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_COMPANY_SIC_CODE_ID"), name = "SIC_CODE_ID", referencedColumnName = "id")
	@JsonManagedReference
	private SICCode sicCode;
	
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@IndexedEmbedded(depth=1)
	private Set<CompanyAddress> address;
	
	@Column(name="NUTS_CODE", length=10)
	private String nutsCode;
	
	@Column(name="STATUS", length=20)
	private String status;
	
	@OneToMany(mappedBy="company")
	@JsonManagedReference
	@ContainedIn
	private Set<Item> item;
	
	
	@Column(name="REFRESH", nullable=false, length=1)
	private String refresh;
	
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