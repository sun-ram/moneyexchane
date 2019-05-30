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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * FsLanguageType Created by Chennai ODC
 */
@Entity
@Table(name = "FS_LANGUAGE_TYPE")
public class LanguageType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal languageId;
	private String languageCode;
	private String languageName;
	private List<NationalityMasterDesc> fsNationalityMasterDescs = new ArrayList<NationalityMasterDesc>();
	private List<EmploymentType> fsEmploymentTypes = new ArrayList<EmploymentType>();
	private List<ContactType> fsContactTypes = new ArrayList<ContactType>();
	private List<Customer> fsCustomers = new ArrayList<Customer>();
	private List<CustomerIdProof> fsCustomerIdProofs = new ArrayList<CustomerIdProof>();
	private List<CustomerLogin> fsCustomerLogins = new ArrayList<CustomerLogin>();
	private List<SecurityQuestionMaster> fsSecurityQuestionMasters = new ArrayList<SecurityQuestionMaster>();
	private List<CountryMasterDesc> fsCountryMasterDescs = new ArrayList<CountryMasterDesc>();
	private List<IdentityType> fsIdentityTypes = new ArrayList<IdentityType>();
	private List<StateMasterDesc> fsStateMasterDescs = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> fsDistrictMasterDescs = new ArrayList<DistrictMasterDesc>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<CompanyGroupDesc> fsCompanyGroupDescs = new ArrayList<CompanyGroupDesc>();
	private List<CityMasterDesc> fsCityMasterDescs = new ArrayList<CityMasterDesc>();
	private List<CustomerType> fsCustomerTypes = new ArrayList<CustomerType>();
	private List<RuleObjective> fsRuleObjectives = new ArrayList<RuleObjective>();
	private List<CompanyMasterDesc> fsCompanyMasterDescs = new ArrayList<CompanyMasterDesc>();
	private List<CustCorporateAddlDetail> fsCustCorporateAddlDetails = new ArrayList<CustCorporateAddlDetail>();
	// private Set fsBussComponentComboDatas = new HashSet(0);
	private List<BussComponentComboData> fsBussComponentComboDatas = new ArrayList<BussComponentComboData>();

	public LanguageType() {
	}

	public LanguageType(BigDecimal languageId, String languageName) {
		this.languageId = languageId;
		this.languageName = languageName;
	}

	public LanguageType(BigDecimal languageId, String languageCode,
			String languageName,
			List<NationalityMasterDesc> fsNationalityMasterDescs,
			List<EmploymentType> fsEmploymentTypes,
			List<ContactType> fsContactTypes, List<Customer> fsCustomers,
			List<CustomerIdProof> fsCustomerIdProofs,
			List<CustomerLogin> fsCustomerLogins,
			List<SecurityQuestionMaster> fsSecurityQuestionMasters,
			List<CountryMasterDesc> fsCountryMasterDescs,
			List<IdentityType> fsIdentityTypes,
			List<StateMasterDesc> fsStateMasterDescs,
			List<DistrictMasterDesc> fsDistrictMasterDescs,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos,
			List<ContactDetail> fsContactDetails,
			List<CompanyGroupDesc> fsCompanyGroupDescs,
			List<CityMasterDesc> fsCityMasterDescs,
			List<CustomerType> fsCustomerTypes,
			List<RuleObjective> fsRuleObjectives,
			List<CompanyMasterDesc> fsCompanyMasterDescs,
			List<CustCorporateAddlDetail> fsCustCorporateAddlDetails,
			List<BussComponentComboData> fsBussComponentComboDatas) {
		this.languageId = languageId;
		this.languageCode = languageCode;
		this.languageName = languageName;
		this.fsNationalityMasterDescs = fsNationalityMasterDescs;
		this.fsEmploymentTypes = fsEmploymentTypes;
		this.fsContactTypes = fsContactTypes;
		this.fsCustomers = fsCustomers;
		this.fsCustomerIdProofs = fsCustomerIdProofs;
		this.fsCustomerLogins = fsCustomerLogins;
		this.fsSecurityQuestionMasters = fsSecurityQuestionMasters;
		this.fsCountryMasterDescs = fsCountryMasterDescs;
		this.fsIdentityTypes = fsIdentityTypes;
		this.fsStateMasterDescs = fsStateMasterDescs;
		this.fsDistrictMasterDescs = fsDistrictMasterDescs;
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
		this.fsContactDetails = fsContactDetails;
		this.fsCompanyGroupDescs = fsCompanyGroupDescs;
		this.fsCityMasterDescs = fsCityMasterDescs;
		this.fsCustomerTypes = fsCustomerTypes;
		this.fsRuleObjectives = fsRuleObjectives;
		this.fsCompanyMasterDescs = fsCompanyMasterDescs;
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
		this.fsBussComponentComboDatas = fsBussComponentComboDatas;
	}

	@Id
	@TableGenerator(name = "languageid", table = "fs_languageidpk", pkColumnName = "languageidkey", pkColumnValue = "languageidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "languageid")
	@Column(name = "LANGUAGE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	@Column(name = "LANGUAGE_CODE", length = 3)
	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Column(name = "LANGUAGE_NAME", nullable = false, length = 50)
	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<NationalityMasterDesc> getFsNationalityMasterDescs() {
		return this.fsNationalityMasterDescs;
	}

	public void setFsNationalityMasterDescs(
			List<NationalityMasterDesc> fsNationalityMasterDescs) {
		this.fsNationalityMasterDescs = fsNationalityMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<EmploymentType> getFsEmploymentTypes() {
		return this.fsEmploymentTypes;
	}

	public void setFsEmploymentTypes(List<EmploymentType> fsEmploymentTypes) {
		this.fsEmploymentTypes = fsEmploymentTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<ContactType> getFsContactTypes() {
		return this.fsContactTypes;
	}

	public void setFsContactTypes(List<ContactType> fsContactTypes) {
		this.fsContactTypes = fsContactTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<Customer> getFsCustomers() {
		return this.fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CustomerIdProof> getFsCustomerIdProofs() {
		return this.fsCustomerIdProofs;
	}

	public void setFsCustomerIdProofs(List<CustomerIdProof> fsCustomerIdProofs) {
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CustomerLogin> getFsCustomerLogins() {
		return this.fsCustomerLogins;
	}

	public void setFsCustomerLogins(List<CustomerLogin> fsCustomerLogins) {
		this.fsCustomerLogins = fsCustomerLogins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<SecurityQuestionMaster> getFsSecurityQuestionMasters() {
		return this.fsSecurityQuestionMasters;
	}

	public void setFsSecurityQuestionMasters(
			List<SecurityQuestionMaster> fsSecurityQuestionMasters) {
		this.fsSecurityQuestionMasters = fsSecurityQuestionMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CountryMasterDesc> getFsCountryMasterDescs() {
		return this.fsCountryMasterDescs;
	}

	public void setFsCountryMasterDescs(
			List<CountryMasterDesc> fsCountryMasterDescs) {
		this.fsCountryMasterDescs = fsCountryMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<IdentityType> getFsIdentityTypes() {
		return this.fsIdentityTypes;
	}

	public void setFsIdentityTypes(List<IdentityType> fsIdentityTypes) {
		this.fsIdentityTypes = fsIdentityTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<StateMasterDesc> getFsStateMasterDescs() {
		return this.fsStateMasterDescs;
	}

	public void setFsStateMasterDescs(List<StateMasterDesc> fsStateMasterDescs) {
		this.fsStateMasterDescs = fsStateMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<DistrictMasterDesc> getFsDistrictMasterDescs() {
		return this.fsDistrictMasterDescs;
	}

	public void setFsDistrictMasterDescs(
			List<DistrictMasterDesc> fsDistrictMasterDescs) {
		this.fsDistrictMasterDescs = fsDistrictMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return this.fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<ContactDetail> getFsContactDetails() {
		return this.fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CompanyGroupDesc> getFsCompanyGroupDescs() {
		return this.fsCompanyGroupDescs;
	}

	public void setFsCompanyGroupDescs(
			List<CompanyGroupDesc> fsCompanyGroupDescs) {
		this.fsCompanyGroupDescs = fsCompanyGroupDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CityMasterDesc> getFsCityMasterDescs() {
		return this.fsCityMasterDescs;
	}

	public void setFsCityMasterDescs(List<CityMasterDesc> fsCityMasterDescs) {
		this.fsCityMasterDescs = fsCityMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CustomerType> getFsCustomerTypes() {
		return this.fsCustomerTypes;
	}

	public void setFsCustomerTypes(List<CustomerType> fsCustomerTypes) {
		this.fsCustomerTypes = fsCustomerTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<RuleObjective> getFsRuleObjectives() {
		return this.fsRuleObjectives;
	}

	public void setFsRuleObjectives(List<RuleObjective> fsRuleObjectives) {
		this.fsRuleObjectives = fsRuleObjectives;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CompanyMasterDesc> getFsCompanyMasterDescs() {
		return this.fsCompanyMasterDescs;
	}

	public void setFsCompanyMasterDescs(
			List<CompanyMasterDesc> fsCompanyMasterDescs) {
		this.fsCompanyMasterDescs = fsCompanyMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<CustCorporateAddlDetail> getFsCustCorporateAddlDetails() {
		return this.fsCustCorporateAddlDetails;
	}

	public void setFsCustCorporateAddlDetails(
			List<CustCorporateAddlDetail> fsCustCorporateAddlDetails) {
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsLanguageType")
	public List<BussComponentComboData> getFsBussComponentComboDatas() {
		return fsBussComponentComboDatas;
	}

	public void setFsBussComponentComboDatas(
			List<BussComponentComboData> fsBussComponentComboDatas) {
		this.fsBussComponentComboDatas = fsBussComponentComboDatas;
	}

}
