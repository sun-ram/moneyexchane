package com.amg.exchange.model;

// Generated Apr 8, 2014 6:20:38 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * CompanyMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_Company_MASTER", uniqueConstraints = @UniqueConstraint(columnNames = "COMPANY_CODE"))
public class CompanyMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal companyId;
	private String companyCode;
	private String companyActive;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;

	private List<CompanyMasterDesc> fsCompanyMasterDescs = new ArrayList<CompanyMasterDesc>();
	private List<Customer> fsCustomers = new ArrayList<Customer>();
	private List<IdentityType> fsIdentityTypes = new ArrayList<IdentityType>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<CustomerLogin> fsCustomerLogins = new ArrayList<CustomerLogin>();
	private List<RuleApplicationDesc> fsRuleApplicationDescs = new ArrayList<RuleApplicationDesc>();
	private List<BusinessComponentConf> fsBusinessComponentConfs = new ArrayList<BusinessComponentConf>();
	private List<BankApplicability> exBankApplicabilities = new ArrayList<BankApplicability>();
	private List<BankAccountDetails> exBankAccountDetailses = new ArrayList<BankAccountDetails>();
	private List<BankAccount> exBankAccounts = new ArrayList<BankAccount>();
	private List<ArticleMaster> fsArticleMasters = new ArrayList<ArticleMaster>();

	public CompanyMaster() {
	}

	public CompanyMaster(BigDecimal companyId) {
		this.companyId = companyId;
	}

	public CompanyMaster(BigDecimal companyId, String companyCode,
			String companyActive, String createdBy, String updatedBy,
			Date creationDate, Date lastUpdated,
			List<IdentityType> fsIdentityTypes,
			List<CompanyMasterDesc> fsCompanyMasterDescs,
			List<Customer> fsCustomers,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos,
			List<CustomerLogin> fsCustomerLogins,
			List<RuleApplicationDesc> fsRuleApplicationDescs,
			List<BusinessComponentConf> fsBusinessComponentConfs,
			List<BankApplicability> exBankApplicabilities,
			List<BankAccountDetails> exBankAccountDetailses,
			List<BankAccount> exBankAccounts,
			List<ArticleMaster> fsArticleMasters) {
		this.companyId = companyId;
		this.companyCode = companyCode;
		this.companyActive = companyActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsCompanyMasterDescs = fsCompanyMasterDescs;
		this.fsCustomers = fsCustomers;
		this.fsCustomerLogins = fsCustomerLogins;
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
		this.fsIdentityTypes = fsIdentityTypes;
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
		this.exBankApplicabilities = exBankApplicabilities;
		this.exBankAccountDetailses = exBankAccountDetailses;
		this.exBankAccounts = exBankAccounts;
		this.fsArticleMasters=fsArticleMasters;
	}

	@Id
	@TableGenerator(name = "companyid", table = "fs_companyidpk", pkColumnName = "companyidkey", pkColumnValue = "companyidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "companyid")
	@Column(name = "COMPANY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_CODE", length = 10)
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "COMPANY_ACTIVE", length = 1)
	public String getCompanyActive() {
		return this.companyActive;
	}

	public void setCompanyActive(String companyActive) {
		this.companyActive = companyActive;
	}

	@Column(name = "CREATED_BY", length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY", length = 30)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "CREATION_DATE")
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "LAST_UPDATED")
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<CompanyMasterDesc> getFsCompanyMasterDescs() {
		return this.fsCompanyMasterDescs;
	}

	public void setFsCompanyMasterDescs(
			List<CompanyMasterDesc> fsCompanyMasterDescs) {
		this.fsCompanyMasterDescs = fsCompanyMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<Customer> getFsCustomers() {
		return this.fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<CustomerLogin> getFsCustomerLogins() {
		return this.fsCustomerLogins;
	}

	public void setFsCustomerLogins(List<CustomerLogin> fsCustomerLogins) {
		this.fsCustomerLogins = fsCustomerLogins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<RuleApplicationDesc> getFsRuleApplicationDescs() {
		return this.fsRuleApplicationDescs;
	}

	public void setFsRuleApplicationDescs(
			List<RuleApplicationDesc> fsRuleApplicationDescs) {
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<IdentityType> getFsIdentityTypes() {
		return fsIdentityTypes;
	}

	public void setFsIdentityTypes(List<IdentityType> fsIdentityTypes) {
		this.fsIdentityTypes = fsIdentityTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<BusinessComponentConf> getFsBusinessComponentConfs() {
		return fsBusinessComponentConfs;
	}

	public void setFsBusinessComponentConfs(
			List<BusinessComponentConf> fsBusinessComponentConfs) {
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<BankApplicability> getExBankApplicabilities() {
		return exBankApplicabilities;
	}

	public void setExBankApplicabilities(
			List<BankApplicability> exBankApplicabilities) {
		this.exBankApplicabilities = exBankApplicabilities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<BankAccountDetails> getExBankAccountDetailses() {
		return exBankAccountDetailses;
	}

	public void setExBankAccountDetailses(
			List<BankAccountDetails> exBankAccountDetailses) {
		this.exBankAccountDetailses = exBankAccountDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<BankAccount> getExBankAccounts() {
		return exBankAccounts;
	}

	public void setExBankAccounts(List<BankAccount> exBankAccounts) {
		this.exBankAccounts = exBankAccounts;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyMaster")
	public List<ArticleMaster> getFsArticleMasters() {
		return this.fsArticleMasters;
	}

	public void setFsArticleMasters(List<ArticleMaster> fsArticleMasters) {
		this.fsArticleMasters = fsArticleMasters;
	}
}
