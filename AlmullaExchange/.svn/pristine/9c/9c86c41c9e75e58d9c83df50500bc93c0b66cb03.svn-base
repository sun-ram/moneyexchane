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
 * FsIdentityType Created by Chennai ODC
 */
@Entity
@Table(name = "FS_IDENTITY_TYPE" )
public class IdentityType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal identityTypeId;
	private LanguageType fsLanguageType;
	private CountryMaster fsCountryMaster;
	private CompanyMaster fsCompanyMaster;
	private CustomerType fsCustomerType;
	private String identityType;
	private List<CustomerIdProof> fsCustomerIdProofs = new ArrayList<CustomerIdProof>();

	public IdentityType() {
	}

	public IdentityType(BigDecimal identityTypeId, String identityType) {
		this.identityTypeId = identityTypeId;
		this.identityType = identityType;
	}

	public IdentityType(BigDecimal identityTypeId, LanguageType fsLanguageType,
			CountryMaster fsCountryMaster, CompanyMaster fsCompanyMaster,
			String identityType, List<CustomerIdProof> fsCustomerIdProofs,
			CustomerType fsCustomerType) {
		this.identityTypeId = identityTypeId;
		this.fsLanguageType = fsLanguageType;
		this.fsCountryMaster = fsCountryMaster;

		this.identityType = identityType;
		this.fsCustomerIdProofs = fsCustomerIdProofs;
		this.fsCompanyMaster = fsCompanyMaster;
		this.fsCustomerType = fsCustomerType;
	}

	@Id
	@TableGenerator(name = "identitytypeid", table = "fs_identitytypeidpk", pkColumnName = "identitytypeidkey", pkColumnValue = "identitytypeidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "identitytypeid")
	@Column(name = "IDENTITY_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdentityTypeId() {
		return this.identityTypeId;
	}

	public void setIdentityTypeId(BigDecimal identityTypeId) {
		this.identityTypeId = identityTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "IDENTITY_TYPE", nullable = false, length = 50)
	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsIdentityType")
	public List<CustomerIdProof> getFsCustomerIdProofs() {
		return this.fsCustomerIdProofs;
	}

	public void setFsCustomerIdProofs(List<CustomerIdProof> fsCustomerIdProofs) {
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_TYPE_ID")
	public CustomerType getFsCustomerType() {
		return fsCustomerType;
	}

	public void setFsCustomerType(CustomerType fsCustomerType) {
		this.fsCustomerType = fsCustomerType;
	}

}
