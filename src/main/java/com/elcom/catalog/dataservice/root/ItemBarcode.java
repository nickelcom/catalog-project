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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the ITEM_BARCODE database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ITEM_BARCODE")
public class ItemBarcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITEM_BARCODE_ID_GENERATOR", sequenceName="ITEM_BARCODE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_BARCODE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_ITEM_BARCODE_ITEM_ID"), name="ITEM_ID", nullable=false)
	@JsonBackReference
	private Item item;

	@Column(name="CODE", length=20)
	private String code;
	
	@Column(name="TYPE", length=10)
	private String type;
	
	@Column(name="CODE_STRING", length=10)
	private String codeString;
	
	@Column(name="CODE_INT", length=10)
	private long codeInt;
	
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
	@JoinColumn(name="PARENT_ITEM_BARCODE_ID")
	@JsonBackReference
	private ItemBarcode parentItemBarcode;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="parentItemBarcode")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private Set<ItemBarcode> childItemBarcodes;
	
}