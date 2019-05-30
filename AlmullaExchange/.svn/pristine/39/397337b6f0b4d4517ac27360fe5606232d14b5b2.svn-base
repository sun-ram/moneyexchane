package com.amg.exchange.model;

// Generated Apr 8, 2014 6:20:38 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 * CountryMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_COUNTRY_MASTER", uniqueConstraints = @UniqueConstraint(columnNames = "COUNTRY_CODE"))
public class CountryMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal countryId;
	private Short countryCode;
	private String countryAlpha2Code;
	private String countryAlpha3Code;
	private String countryIsoCode;
	private String countryTelCode;
	private String countryActive;
	private List<StateMaster> fsStateMasters = new ArrayList<StateMaster>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<CustomerLogin> fsCustomerLogins = new ArrayList<CustomerLogin>();
	private List<CountryMasterDesc> fsCountryMasterDescs = new ArrayList<CountryMasterDesc>();
	// private List<Customer> fsCustomers = new ArrayList<Customer>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<Customer> fsCustomersForNationality = new ArrayList<Customer>();
	private List<Customer> fsCustomersForCountryId = new ArrayList<Customer>();

	private List<IdentityType> fsIdentityTypes = new ArrayList<IdentityType>();
	private List<RuleApplicationDesc> fsRuleApplicationDescs = new ArrayList<RuleApplicationDesc>();
	private List<BusinessComponentConf> fsBusinessComponentConfs = new ArrayList<BusinessComponentConf>();
	private List<ArticleMaster> fsArticleMasters = new ArrayList<ArticleMaster>();
	private List<BankDdPrintLoc> exBankDdPrintLocs = new ArrayList<BankDdPrintLoc>();
	private List<BankApplicability> exBankApplicabilities = new ArrayList<BankApplicability>();
	private List<BankMaster> exBankMasters = new ArrayList<BankMaster>();
	private List<BankAccountDetails> exBankAccountDetailses = new ArrayList<BankAccountDetails>();
	private List<BankAccount> exBankAccounts = new ArrayList<BankAccount>();

	public CountryMaster() {
	}

	public CountryMaster(BigDecimal countryId) {
		this.countryId = countryId;
	}

	public CountryMaster(BigDecimal countryId, Short countryCode,
			String countryAlpha2Code, String countryAlpha3Code,
			String countryIsoCode, String countryTelCode, String countryActive,
			List<CustomerLogin> fsCustomerLogins,
			List<IdentityType> fsIdentityTypes,
			List<ContactDetail> fsContactDetails,
			List<CountryMasterDesc> fsCountryMasterDescs,
			List<Customer> fsCustomersForNationality,
			List<Customer> fsCustomersForCountryId, List<Customer> fsCustomers,
			List<StateMaster> fsStateMasters,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos,
			List<RuleApplicationDesc> fsRuleApplicationDescs,
			List<BusinessComponentConf> fsBusinessComponentConfs,
			List<BankDdPrintLoc> exBankDdPrintLocs,
			List<BankApplicability> exBankApplicabilities,
			List<BankMaster> exBankMasters,
			List<BankAccountDetails> exBankAccountDetailses,
			List<BankAccount> exBankAccounts,
			List<ArticleMaster> fsArticleMasters) {
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryAlpha2Code = countryAlpha2Code;
		this.countryAlpha3Code = countryAlpha3Code;
		this.countryIsoCode = countryIsoCode;
		this.countryTelCode = countryTelCode;
		this.countryActive = countryActive;
		this.fsCustomerLogins = fsCustomerLogins;
		this.fsCountryMasterDescs = fsCountryMasterDescs;
		this.fsIdentityTypes = fsIdentityTypes;
		// this.fsCustomers = fsCustomers;
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
		this.fsContactDetails = fsContactDetails;
		this.fsStateMasters = fsStateMasters;
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
		this.fsCustomersForNationality = fsCustomersForNationality;
		this.fsCustomersForCountryId = fsCustomersForCountryId;
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
		this.exBankDdPrintLocs = exBankDdPrintLocs;
		this.exBankApplicabilities = exBankApplicabilities;
		this.exBankMasters = exBankMasters;
		this.exBankAccountDetailses = exBankAccountDetailses;
		this.exBankAccounts = exBankAccounts;
		this.fsArticleMasters=fsArticleMasters;

	}

	@Id
	@TableGenerator(name = "countryid", table = "fs_countryidpk", pkColumnName = "countryidkey", pkColumnValue = "countryidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "countryid")
	@Column(name = "COUNTRY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCountryId() {
		return this.countryId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}

	@Column(name = "COUNTRY_CODE", precision = 3, scale = 0)
	public Short getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(Short countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "COUNTRY_ALPHA2_CODE", length = 2)
	public String getCountryAlpha2Code() {
		return this.countryAlpha2Code;
	}

	public void setCountryAlpha2Code(String countryAlpha2Code) {
		this.countryAlpha2Code = countryAlpha2Code;
	}

	@Column(name = "COUNTRY_ALPHA3_CODE", length = 3)
	public String getCountryAlpha3Code() {
		return this.countryAlpha3Code;
	}

	public void setCountryAlpha3Code(String countryAlpha3Code) {
		this.countryAlpha3Code = countryAlpha3Code;
	}

	@Column(name = "COUNTRY_ISO_CODE", length = 20)
	public String getCountryIsoCode() {
		return this.countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	@Column(name = "COUNTRY_TEL_CODE", length = 10)
	public String getCountryTelCode() {
		return this.countryTelCode;
	}

	public void setCountryTelCode(String countryTelCode) {
		this.countryTelCode = countryTelCode;
	}

	@Column(name = "COUNTRY_ACTIVE", length = 1)
	public String getCountryActive() {
		return this.countryActive;
	}

	public void setCountryActive(String countryActive) {
		this.countryActive = countryActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<CustomerLogin> getFsCustomerLogins() {
		return this.fsCustomerLogins;
	}

	public void setFsCustomerLogins(List<CustomerLogin> fsCustomerLogins) {
		this.fsCustomerLogins = fsCustomerLogins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<CountryMasterDesc> getFsCountryMasterDescs() {
		return this.fsCountryMasterDescs;
	}

	public void setFsCountryMasterDescs(
			List<CountryMasterDesc> fsCountryMasterDescs) {
		this.fsCountryMasterDescs = fsCountryMasterDescs;
	}

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster") public
	 * List<Customer> getFsCustomers() { return this.fsCustomers; }
	 * 
	 * public void setFsCustomers(List<Customer> fsCustomers) { this.fsCustomers
	 * = fsCustomers; }
	 */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<RuleApplicationDesc> getFsRuleApplicationDescs() {
		return this.fsRuleApplicationDescs;
	}

	public void setFsRuleApplicationDescs(
			List<RuleApplicationDesc> fsRuleApplicationDescs) {
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<IdentityType> getFsIdentityTypes() {
		return fsIdentityTypes;
	}

	public void setFsIdentityTypes(List<IdentityType> fsIdentityTypes) {
		this.fsIdentityTypes = fsIdentityTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<ContactDetail> getFsContactDetails() {
		return fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<StateMaster> getFsStateMasters() {
		return fsStateMasters;
	}

	public void setFsStateMasters(List<StateMaster> fsStateMasters) {
		this.fsStateMasters = fsStateMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMasterByNationality")
	public List<Customer> getFsCustomersForNationality() {
		return fsCustomersForNationality;
	}

	public void setFsCustomersForNationality(
			List<Customer> fsCustomersForNationality) {
		this.fsCustomersForNationality = fsCustomersForNationality;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMasterByCountryId")
	public List<Customer> getFsCustomersForCountryId() {
		return fsCustomersForCountryId;
	}

	public void setFsCustomersForCountryId(
			List<Customer> fsCustomersForCountryId) {
		this.fsCustomersForCountryId = fsCustomersForCountryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BusinessComponentConf> getFsBusinessComponentConfs() {
		return fsBusinessComponentConfs;
	}

	public void setFsBusinessComponentConfs(
			List<BusinessComponentConf> fsBusinessComponentConfs) {
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BankDdPrintLoc> getExBankDdPrintLocs() {
		return exBankDdPrintLocs;
	}

	public void setExBankDdPrintLocs(List<BankDdPrintLoc> exBankDdPrintLocs) {
		this.exBankDdPrintLocs = exBankDdPrintLocs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BankApplicability> getExBankApplicabilities() {
		return exBankApplicabilities;
	}

	public void setExBankApplicabilities(
			List<BankApplicability> exBankApplicabilities) {
		this.exBankApplicabilities = exBankApplicabilities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BankMaster> getExBankMasters() {
		return exBankMasters;
	}

	public void setExBankMasters(List<BankMaster> exBankMasters) {
		this.exBankMasters = exBankMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BankAccountDetails> getExBankAccountDetailses() {
		return exBankAccountDetailses;
	}

	public void setExBankAccountDetailses(
			List<BankAccountDetails> exBankAccountDetailses) {
		this.exBankAccountDetailses = exBankAccountDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<BankAccount> getExBankAccounts() {
		return exBankAccounts;
	}

	public void setExBankAccounts(List<BankAccount> exBankAccounts) {
		this.exBankAccounts = exBankAccounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCountryMaster")
	public List<ArticleMaster> getFsArticleMasters() {
		return this.fsArticleMasters;
	}

	public void setFsArticleMasters(List<ArticleMaster> fsArticleMasters) {
		this.fsArticleMasters = fsArticleMasters;
	}
}
