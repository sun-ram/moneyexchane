package com.amg.exchange.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * FsCustomer Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUSTOMER")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal customerId;
	private CustomerType fsCustomerType;
	private CompanyMaster fsCompanyMaster;
	private CompanyGroup fsCompanyGroup;
	private RuleObjective fsRuleObjective;
	private LanguageType fsLanguageType;
	// private CountryMaster fsCountryMaster;
	private ArticleDetails fsArticleDetails;

	private CountryMaster fsCountryMasterByNationality;
	private CountryMaster fsCountryMasterByCountryId;
	private String shortName;
	private String shortNameLocal;
	private String amlStatus;
	private Long numberOfHits;
	private String verificationBy;
	private Date verificationDate;
	private String amlStatusUpdatedBy;
	private Date amlStatusLastUpdated;
	private Integer branchCode;
	private String activatedInd;
	private Date activatedDate;
	private Date inactivatedDate;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String titleLocal;
	private String firstNameLocal;
	private String middleNameLocal;
	private String lastNameLocal;
	private String gender;
	private Date dateOfBirth;
	// private String nationality;
	private String alterEmailId;
	private String mobile;
	private String signatureSpecimen;
	private String fingerPrintImg;
	private String introducedBy;
	private String medicalInsuranceInd;
	private String companyName;
	private String companyNameLocal;
	private String email;
	private String crNo;
	private String placeOfBirth;
	private String countryOfBirth;
	private String fatherName;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private String tokenKey;
	private String contactPerson;
	private BigDecimal contactNumber;
	private List<CustomerIdProof> fsCustomerIdProofs = new ArrayList<CustomerIdProof>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<CustomerLogin> fsCustomerLogins = new ArrayList<CustomerLogin>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<CorporateBusinessNature> fsCorporateBusinessNatures = new ArrayList<CorporateBusinessNature>();
	private List<CustCorporateAddlDetail> fsCustCorporateAddlDetails = new ArrayList<CustCorporateAddlDetail>();
	private List<Nominee> fsNomineesForNominatorCustId = new ArrayList<Nominee>();
	private List<Nominee> fsNomineesForNomineeCustId = new ArrayList<Nominee>();

	public Customer() {
	}

	public Customer(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public Customer(BigDecimal customerId, CustomerType fsCustomerType,
			CompanyMaster fsCompanyMaster, CompanyGroup fsCompanyGroup,
			RuleObjective fsRuleObjective, LanguageType fsLanguageType,
			String contactPerson, String shortName, BigDecimal contactNumber,
			CountryMaster fsCountryMasterByNationality,
			CountryMaster fsCountryMasterByCountryId, String shortNameLocal,
			String amlStatus, Long numberOfHits, String verificationBy,
			Date verificationDate, String amlStatusUpdatedBy,
			Date amlStatusLastUpdated, Integer branchCode, String activatedInd,
			Date activatedDate, Date inactivatedDate, String title,
			String firstName, String middleName, String lastName,
			String titleLocal, String firstNameLocal, String middleNameLocal,
			String lastNameLocal, String gender, Date dateOfBirth,
			String alterEmailId, String mobile, String signatureSpecimen,
			String fingerPrintImg, String introducedBy,
			String medicalInsuranceInd, String companyName,
			String companyNameLocal, String email, String crNo,
			String placeOfBirth, String countryOfBirth, String fatherName,
			String createdBy, String updatedBy, Date creationDate,
			Date lastUpdated, String tokenKey,
			List<CustomerIdProof> fsCustomerIdProofs,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos,
			List<CustomerLogin> fsCustomerLogins,
			List<ContactDetail> fsContactDetails,
			List<CorporateBusinessNature> fsCorporateBusinessNatures,
			List<CustCorporateAddlDetail> fsCustCorporateAddlDetails,
			List<Nominee> fsNomineesForNominatorCustId,
			List<Nominee> fsNomineesForNomineeCustId,
			ArticleDetails fsArticleDetails) {
		this.customerId = customerId;
		this.fsCustomerType = fsCustomerType;
		this.fsCompanyMaster = fsCompanyMaster;
		this.fsCompanyGroup = fsCompanyGroup;
		this.fsRuleObjective = fsRuleObjective;
		this.fsLanguageType = fsLanguageType;
		// this.fsCountryMaster = fsCountryMaster;
		this.shortName = shortName;
		this.shortNameLocal = shortNameLocal;
		this.amlStatus = amlStatus;
		this.numberOfHits = numberOfHits;
		this.verificationBy = verificationBy;
		this.verificationDate = verificationDate;
		this.amlStatusUpdatedBy = amlStatusUpdatedBy;
		this.amlStatusLastUpdated = amlStatusLastUpdated;
		this.branchCode = branchCode;
		this.activatedInd = activatedInd;
		this.activatedDate = activatedDate;
		this.inactivatedDate = inactivatedDate;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.titleLocal = titleLocal;
		this.firstNameLocal = firstNameLocal;
		this.middleNameLocal = middleNameLocal;
		this.lastNameLocal = lastNameLocal;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		// this.nationality = nationality;
		this.alterEmailId = alterEmailId;
		this.mobile = mobile;
		this.signatureSpecimen = signatureSpecimen;
		this.fingerPrintImg = fingerPrintImg;
		this.introducedBy = introducedBy;
		this.medicalInsuranceInd = medicalInsuranceInd;
		this.companyName = companyName;
		this.companyNameLocal = companyNameLocal;
		this.email = email;
		this.crNo = crNo;
		this.placeOfBirth = placeOfBirth;
		this.countryOfBirth = countryOfBirth;
		this.fatherName = fatherName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.tokenKey = tokenKey;
		this.contactPerson = contactPerson;
		this.contactNumber = contactNumber;
		this.fsCustomerIdProofs = fsCustomerIdProofs;
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
		this.fsCustomerLogins = fsCustomerLogins;
		this.fsContactDetails = fsContactDetails;
		this.fsArticleDetails = fsArticleDetails;
		this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
		this.fsCountryMasterByNationality = fsCountryMasterByNationality;
		this.fsCountryMasterByCountryId = fsCountryMasterByCountryId;
		this.fsNomineesForNominatorCustId = fsNomineesForNominatorCustId;
		this.fsNomineesForNomineeCustId = fsNomineesForNomineeCustId;

	}

	@Id
	@TableGenerator(name = "customerid", table = "fs_customeridpk", pkColumnName = "customeridkey", pkColumnValue = "customeridvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customerid")
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_TYPE_ID")
	public CustomerType getFsCustomerType() {
		return this.fsCustomerType;
	}

	public void setFsCustomerType(CustomerType fsCustomerType) {
		this.fsCustomerType = fsCustomerType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return this.fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public CompanyGroup getFsCompanyGroup() {
		return this.fsCompanyGroup;
	}

	public void setFsCompanyGroup(CompanyGroup fsCompanyGroup) {
		this.fsCompanyGroup = fsCompanyGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTIVE_ID")
	public RuleObjective getFsRuleObjective() {
		return this.fsRuleObjective;
	}

	public void setFsRuleObjective(RuleObjective fsRuleObjective) {
		this.fsRuleObjective = fsRuleObjective;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "CONTACT_PERSON", length = 50)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "CONTACT_NUMBER", precision = 22, scale = 0)
	public BigDecimal getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(BigDecimal contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "SHORT_NAME", length = 200)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "SHORT_NAME_LOCAL", length = 200)
	public String getShortNameLocal() {
		return this.shortNameLocal;
	}

	public void setShortNameLocal(String shortNameLocal) {
		this.shortNameLocal = shortNameLocal;
	}

	@Column(name = "AML_STATUS", length = 15)
	public String getAmlStatus() {
		return this.amlStatus;
	}

	public void setAmlStatus(String amlStatus) {
		this.amlStatus = amlStatus;
	}

	@Column(name = "NUMBER_OF_HITS", precision = 10, scale = 0)
	public Long getNumberOfHits() {
		return this.numberOfHits;
	}

	public void setNumberOfHits(Long numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	@Column(name = "VERIFICATION_BY", length = 30)
	public String getVerificationBy() {
		return this.verificationBy;
	}

	public void setVerificationBy(String verificationBy) {
		this.verificationBy = verificationBy;
	}

	@Column(name = "VERIFICATION_DATE")
	public Date getVerificationDate() {
		return this.verificationDate;
	}

	public void setVerificationDate(Date verificationDate) {
		this.verificationDate = verificationDate;
	}

	@Column(name = "AML_STATUS_UPDATED_BY", length = 20)
	public String getAmlStatusUpdatedBy() {
		return this.amlStatusUpdatedBy;
	}

	public void setAmlStatusUpdatedBy(String amlStatusUpdatedBy) {
		this.amlStatusUpdatedBy = amlStatusUpdatedBy;
	}

	@Column(name = "AML_STATUS_LAST_UPDATED")
	public Date getAmlStatusLastUpdated() {
		return this.amlStatusLastUpdated;
	}

	public void setAmlStatusLastUpdated(Date amlStatusLastUpdated) {
		this.amlStatusLastUpdated = amlStatusLastUpdated;
	}

	@Column(name = "BRANCH_CODE", precision = 6, scale = 0)
	public Integer getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "ACTIVATED_IND", length = 1)
	public String getActivatedInd() {
		return this.activatedInd;
	}

	public void setActivatedInd(String activatedInd) {
		this.activatedInd = activatedInd;
	}

	@Column(name = "ACTIVATED_DATE")
	public Date getActivatedDate() {
		return this.activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	@Column(name = "INACTIVATED_DATE")
	public Date getInactivatedDate() {
		return this.inactivatedDate;
	}

	public void setInactivatedDate(Date inactivatedDate) {
		this.inactivatedDate = inactivatedDate;
	}

	@Column(name = "TITLE", length = 10)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "FIRST_NAME", length = 200)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MIDDLE_NAME", length = 200)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LAST_NAME", length = 200)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "TITLE_LOCAL", length = 200)
	public String getTitleLocal() {
		return this.titleLocal;
	}

	public void setTitleLocal(String titleLocal) {
		this.titleLocal = titleLocal;
	}

	@Column(name = "FIRST_NAME_LOCAL", length = 200)
	public String getFirstNameLocal() {
		return this.firstNameLocal;
	}

	public void setFirstNameLocal(String firstNameLocal) {
		this.firstNameLocal = firstNameLocal;
	}

	@Column(name = "MIDDLE_NAME_LOCAL", length = 200)
	public String getMiddleNameLocal() {
		return this.middleNameLocal;
	}

	public void setMiddleNameLocal(String middleNameLocal) {
		this.middleNameLocal = middleNameLocal;
	}

	@Column(name = "LAST_NAME_LOCAL", length = 200)
	public String getLastNameLocal() {
		return this.lastNameLocal;
	}

	public void setLastNameLocal(String lastNameLocal) {
		this.lastNameLocal = lastNameLocal;
	}

	@Column(name = "GENDER", length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "DATE_OF_BIRTH")
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/*
	 * @Column(name = "NATIONALITY", length = 100) public String
	 * getNationality() { return this.nationality; }
	 * 
	 * public void setNationality(String nationality) { this.nationality =
	 * nationality; }
	 */

	@Column(name = "ALTER_EMAIL_ID", length = 200)
	public String getAlterEmailId() {
		return this.alterEmailId;
	}

	public void setAlterEmailId(String alterEmailId) {
		this.alterEmailId = alterEmailId;
	}

	@Column(name = "MOBILE", length = 12)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "SIGNATURE_SPECIMEN", length = 200)
	public String getSignatureSpecimen() {
		return this.signatureSpecimen;
	}

	public void setSignatureSpecimen(String signatureSpecimen) {
		this.signatureSpecimen = signatureSpecimen;
	}

	@Column(name = "FINGER_PRINT_IMG", length = 200)
	public String getFingerPrintImg() {
		return this.fingerPrintImg;
	}

	public void setFingerPrintImg(String fingerPrintImg) {
		this.fingerPrintImg = fingerPrintImg;
	}

	@Column(name = "INTRODUCED_BY", length = 100)
	public String getIntroducedBy() {
		return this.introducedBy;
	}

	public void setIntroducedBy(String introducedBy) {
		this.introducedBy = introducedBy;
	}

	@Column(name = "MEDICAL_INSURANCE_IND", length = 100)
	public String getMedicalInsuranceInd() {
		return this.medicalInsuranceInd;
	}

	public void setMedicalInsuranceInd(String medicalInsuranceInd) {
		this.medicalInsuranceInd = medicalInsuranceInd;
	}

	@Column(name = "COMPANY_NAME", length = 200)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "COMPANY_NAME_LOCAL", length = 200)
	public String getCompanyNameLocal() {
		return this.companyNameLocal;
	}

	public void setCompanyNameLocal(String companyNameLocal) {
		this.companyNameLocal = companyNameLocal;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CR_NO", length = 20)
	public String getCrNo() {
		return this.crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	@Column(name = "PLACE_OF_BIRTH", length = 100)
	public String getPlaceOfBirth() {
		return this.placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Column(name = "COUNTRY_OF_BIRTH", length = 100)
	public String getCountryOfBirth() {
		return this.countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	@Column(name = "FATHER_NAME", length = 200)
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<CustomerIdProof> getFsCustomerIdProofs() {
		return this.fsCustomerIdProofs;
	}

	public void setFsCustomerIdProofs(List<CustomerIdProof> fsCustomerIdProofs) {
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return this.fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<CustomerLogin> getFsCustomerLogins() {
		return this.fsCustomerLogins;
	}

	public void setFsCustomerLogins(List<CustomerLogin> fsCustomerLogins) {
		this.fsCustomerLogins = fsCustomerLogins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<ContactDetail> getFsContactDetails() {
		return this.fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<CorporateBusinessNature> getFsCorporateBusinessNatures() {
		return this.fsCorporateBusinessNatures;
	}

	public void setFsCorporateBusinessNatures(
			List<CorporateBusinessNature> fsCorporateBusinessNatures) {
		this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomer")
	public List<CustCorporateAddlDetail> getFsCustCorporateAddlDetails() {
		return fsCustCorporateAddlDetails;
	}

	public void setFsCustCorporateAddlDetails(
			List<CustCorporateAddlDetail> fsCustCorporateAddlDetails) {
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NATIONALITY")
	public CountryMaster getFsCountryMasterByNationality() {
		return fsCountryMasterByNationality;
	}

	public void setFsCountryMasterByNationality(
			CountryMaster fsCountryMasterByNationality) {
		this.fsCountryMasterByNationality = fsCountryMasterByNationality;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMasterByCountryId() {
		return fsCountryMasterByCountryId;
	}

	public void setFsCountryMasterByCountryId(
			CountryMaster fsCountryMasterByCountryId) {
		this.fsCountryMasterByCountryId = fsCountryMasterByCountryId;
	}

	@Column(name = "TOKEN_KEY", length = 50)
	public String getTokenKey() {
		return this.tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomerByNomineeCustId")
	public List<Nominee> getFsNomineesForNominatorCustId() {
		return fsNomineesForNominatorCustId;
	}

	public void setFsNomineesForNominatorCustId(
			List<Nominee> fsNomineesForNominatorCustId) {
		this.fsNomineesForNominatorCustId = fsNomineesForNominatorCustId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCustomerByNomineeCustId")
	public List<Nominee> getFsNomineesForNomineeCustId() {
		return fsNomineesForNomineeCustId;
	}

	public void setFsNomineesForNomineeCustId(
			List<Nominee> fsNomineesForNomineeCustId) {
		this.fsNomineesForNomineeCustId = fsNomineesForNomineeCustId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_DETAIL_ID")
	public ArticleDetails getFsArticleDetails() {
		return this.fsArticleDetails;
	}

	public void setFsArticleDetails(ArticleDetails fsArticleDetails) {
		this.fsArticleDetails = fsArticleDetails;
	}

}
