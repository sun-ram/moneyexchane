package com.amg.exchange.model;

 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * FsCustomerType Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUSTOMER_TYPE" )
public class CustomerType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal customerTypeId;
	private LanguageType fsLanguageType;
	private String customerType;
	private List<CustomerIdProof> fsCustomerIdProofs = new ArrayList<CustomerIdProof>();
	private List<Customer> fsCustomers = new ArrayList<Customer>();
	private List<IdentityType> fsIdentityTypes = new ArrayList<IdentityType>();

	public CustomerType() {
	}

	public CustomerType(BigDecimal customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public CustomerType(BigDecimal customerTypeId, LanguageType fsLanguageType,
			String customerType, List<CustomerIdProof> fsCustomerIdProofs,
			List<Customer> fsCustomers, List<IdentityType> fsIdentityTypes) {
		this.customerTypeId = customerTypeId;
		this.fsLanguageType = fsLanguageType;
		this.customerType = customerType;
		this.fsCustomerIdProofs = fsCustomerIdProofs;
		this.fsCustomers = fsCustomers;
		this.fsIdentityTypes = fsIdentityTypes;
	}

	@Id
	@TableGenerator(name = "customertypeid", table = "fs_customertypeidpk", pkColumnName = "customertypeidkey", pkColumnValue = "customertypeidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customertypeid")
	@Column(name = "CUSTOMER_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(BigDecimal customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "CUSTOMER_TYPE", length = 50)
	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomerType")
	public List<CustomerIdProof> getFsCustomerIdProofs() {
		return this.fsCustomerIdProofs;
	}

	public void setFsCustomerIdProofs(List<CustomerIdProof> fsCustomerIdProofs) {
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomerType")
	public List<Customer> getFsCustomers() {
		return this.fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomerType")
	public List<IdentityType> getFsIdentityTypes() {
		return fsIdentityTypes;
	}

	public void setFsIdentityTypes(List<IdentityType> fsIdentityTypes) {
		this.fsIdentityTypes = fsIdentityTypes;
	}

}
