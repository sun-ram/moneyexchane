package com.amg.exchange.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.Validator;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CityMasterDesc;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.ContactType;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.CustomerType;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DistrictMasterDesc;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.EmploymentType;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.LanguageType;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.NationalityMasterDesc;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.model.StateMasterDesc;
import com.amg.exchange.service.IBranchPageService;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.RegularExpressionValidation;
import com.amg.exchange.util.SessionStateManage;

/*******************************************************************************************************************

		 File		: BranchPageManageBean.java
 
		 Project	: AlmullaExchange

		 Package	: com.amg.exchange.bean
 
		 Created	:	
 						Date	: 12-Mar-2014 9:21:34 am
		 				By		: Chennai Team, Almulla
 						Revision:
 
 		Last Change:
 						Date	: 2014-04-25
 						By		: Chennai Team, Almulla
		 				Revision:

		Description: Branch change page
 * @param <T>

********************************************************************************************************************/
@Component(value = "branchReg")  
@Scope("session")
public class BranchPageManageBean<T> implements Serializable {

	@Autowired
	IBranchPageService<T> branchpageService;
	
	@Autowired
	IGeneralService<T> generalService;
	
	private static Logger log =Logger.getLogger(BranchPageManageBean.class);
	
	private static final long serialVersionUID = 4156846251185988990L;

	// TODO : Private primitive and object declaration
	private String idType = null;
	private String idNumber = null;
	private String title = null;
	private String token = null;
	private String remName = null;
	private String lastName = null;
	private String middleName = null;
	private String shortName = null;
	private String titlel = null;
	private String firstNamel = null;
	private String lastNamel = null;
	private String middleNamel = null;
	private String shortNamel = null;
	private String nationality = null;
	private String gender = null;
	private String mobile = null;
	private String email = null;
	private String alternativeEmail = null;
	private String AMLStatus = null;
	private String numberofhits = null;
	private String contactType = null;
	private String localArea = null;
	private String country = null;
	private String streetNo = null;
	private String blockNo = null;
	private String telephoneNo = null;
	private String area = null;
	private String city = null;
	private String flatNo = null;
	private String countryOfBirth = null;
	private String birthPlace = null;
	private String fatherName = null;
	private String occupation = null;
	private String employer = null;
	private String employmentType = null;
	private String empcategory = null;
	private String originId = null;
	private String stateContact = null;
	private String stateEmployment = null;
	private String postalCode = null;
	private String officeTel = null;
	private String dist = null;
	private String idFor = null;
	private String statusMessage = null;
	private String introduceBy = null;
	private String insurance = null;
	private String rel = null;
	private String dataTableContactTypeValue = null;
	private String idnumberProof = null;
	private Boolean booIdValidator = false;
	
	private String empInfoCountry = null;
	private String empInfoState = null;
	private String empInfoDistrict = null;
	private String empInfoBlock = null;
	private String empInfoStreet = null;
	private String empInfoCity = null;
	private String empInfoEmploymentTypeId = null;

	private int count = 0;
	private int mobMin;
	private int mobMax;

	private Date expDate = null;
	private Date dateExp = null;
	private Date dob = null;

	private boolean enable;
	private Boolean boolAdditional = false;
	private Boolean booPass = false;
	private Boolean booPend = false;
	private Boolean booFailed = false;
	private Boolean booCommon = true;
	private Boolean booTable = false;
	private Boolean booValidateBtn = true;
	private Boolean booSave = true;
	private Boolean readonly = false;
	private Boolean enablePTbl;
	private boolean approved;
	private Boolean nonMatchedMsg = false;
	private Boolean booContactDetails = true;
	private Boolean booIdNumber = true;
	private Boolean booContactType = false;
	
	private Boolean booLocalArea = false;
	private Boolean booContactCountry = false;
	private Boolean booContactBlock = false;
	private Boolean booContactStreet = false;
	private Boolean booContactTel = false;
	private Boolean booContactDist = false;
	private Boolean booContactState = false;
	private Boolean booContactFlat = false;
	private Boolean booDuplicate = false;
	private Boolean booContactCity = false;
	private Boolean booContactContactType = false;
	
	private Boolean booIdType = false;
	private Boolean booIdNo = false;
	private Boolean booIdTExpDate = false;
	private Boolean booProfListDuplicate = false;
	private Boolean booIdTypeCheck = false;
	private Boolean booIdFor = false;
	
	private Boolean booUnEmp = false;

	private BigDecimal customerId;

	private List<Amlstatus> amlList = null;
	private List<CountryMasterDesc> countryList;
	private List<NationalityMaster> nationalityList;
	private List<NationalityMasterDesc> nationalityDescList;
	private List<AddContactDetailBean> addContactList = new ArrayList<AddContactDetailBean>();
	private List<AddContactDetailBean> addContactListDeleted = new ArrayList<AddContactDetailBean>();
	private List<AddContactBean> lstData = new ArrayList<AddContactBean>();
	private List<ContactDetail> lstFsContactDetails;
	private List<Customer> lstFsCustomer;
	private List<CustomerEmploymentInfo> lstFsCustEmpInfo;
	private List<CustomerIdProof> lstFsCustIdProof;
	private List<CustomerIdProof> fetchCustId;
	private List<CustomerIdProof> lstProofData;
	private List<CustomerIdProof> lstCustomerIdProof;
	private List<StateMaster> lstState;
	private List<StateMasterDesc> lstStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<StateMasterDesc> lstEmpInfoStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstEmpInfoDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstEmpInfoCityList = new ArrayList<CityMasterDesc>();
	private List<IdentityType> lstEmpInfoIdentityList = new ArrayList<IdentityType>();
	private List<ContactType> lstContactType = new ArrayList<ContactType>();
	private List<CityMaster> lstCity;
	private List<CreateProofTable> createProofList = new ArrayList<CreateProofTable>();
	private List<CreateProofTable> createProofListDelete = new ArrayList<CreateProofTable>();
	List<District> districtBean;
	private String expDateCheck;
	private String minDob;
	private Map<String,String>	countryMap = new HashMap<String,String>();
	private Map<String,String>	stateMap = new HashMap<String,String>();
	private Map<String,String>	districtMap = new HashMap<String,String>();
	private Map<String,String>	cityMap = new HashMap<String,String>();
	private Map<String,String>	idTypeMap = new HashMap<String,String>();
	private Map<String,String>	idForMap = new HashMap<String,String>();
	private Map<String,String>	conTypeMap = new HashMap<String,String>();
	private List<CityMasterDesc> contactCityList = new ArrayList<CityMasterDesc>();
	Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	private Part part;
	private UIComponent tableForm;
	private String DATE_FORMAT = "dd/MM/yyyy";
	
	private UploadedFile file;
	private StreamedContent downloadFile;  
	
	private BigDecimal image_id; 
	
	private Boolean booBrowsedFile = false;

	private Map<String, StreamedContent> imageMap = new HashMap<String, StreamedContent>();
	
	private String idTypeBranchPage = "";
	private String idTypeproof = null;
	
	private String hidden1 = "0";
	
	private Boolean booContactDetailsSize = false;
	
	@Autowired
	public BranchPageManageBean(IGeneralService<T> generalService){
		
		/*setiGeneralService(generalService);
		
		setPageIdIntoSession();
		prepareBehavior();*/
	} 
	
	// TODO : Getter and Setter methods for primitive and objects
	public List<NationalityMasterDesc> getNationalityDescList() {
		return nationalityDescList;
	}

	public void setNationalityDescList(List<NationalityMasterDesc> nationalityDescList) {
		this.nationalityDescList = nationalityDescList;
	}

	public String getIntroduceBy() {
		return introduceBy;
	}

	public void setIntroduceBy(String introduceBy) {
		this.introduceBy = introduceBy;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public IBranchPageService<T> getBranchpageService() {
		return branchpageService;
	}

	public Date getDateExp() {
		return dateExp;
	}

	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

	
	public void setBranchpageService(IBranchPageService<T> branchpageService) {
		this.branchpageService = branchpageService;
	}

	public Boolean getBooSave() {
		return booSave;
	}

	public void setBooSave(Boolean booSave) {
		this.booSave = booSave;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Boolean getBoolAdditional() {
		return boolAdditional;
	}

	public void setBoolAdditional(Boolean boolAdditional) {
		this.boolAdditional = boolAdditional;
	}

	public Boolean getBooPass() {
		return booPass;
	}

	public void setBooPass(Boolean booPass) {
		this.booPass = booPass;
	}

	public Boolean getBooPend() {
		return booPend;
	}

	public void setBooPend(Boolean booPend) {
		this.booPend = booPend;
	}

	public Boolean getBooFailed() {
		return booFailed;
	}

	public void setBooFailed(Boolean booFailed) {
		this.booFailed = booFailed;
	}

	public Boolean getBooCommon() {
		return booCommon;
	}

	public void setBooCommon(Boolean booCommon) {
		this.booCommon = booCommon;
	}

	public Boolean getBooTable() {
		return booTable;
	}

	public void setBooTable(Boolean booTable) {
		this.booTable = booTable;
	}

	public void setAddContactList(List<AddContactDetailBean> addContactList) {
		this.addContactList = addContactList;
	}

	public List<CountryMasterDesc> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryMasterDesc> countryList) {
		this.countryList = countryList;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public List<AddContactBean> getLstData() {
		return lstData;
	}

	public List<AddContactDetailBean> getAddContactList() {
		return addContactList;
	}

	public UIComponent getTableForm() {
		return tableForm;
	}

	public void setTableForm(UIComponent tableForm) {
		this.tableForm = tableForm;
	}

	public String getLocalArea() {
		return localArea;
	}

	public void setLocalArea(String localArea) {
		this.localArea = localArea;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idtype) {
		this.idType = idtype;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRemName() {
		return remName;
	}

	public void setRemName(String firstName) {
		this.remName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middlename) {
		this.middleName = middlename;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTitlel() {
		return titlel;
	}

	public void setTitlel(String titlel) {
		this.titlel = titlel;
	}

	public String getFirstNamel() {
		return firstNamel;
	}

	public void setFirstNamel(String firstnamel) {
		this.firstNamel = firstnamel;
	}

	public String getLastNamel() {
		return lastNamel;
	}

	public void setLastNamel(String lastNamel) {
		this.lastNamel = lastNamel;
	}

	public String getMiddleNamel() {
		return middleNamel;
	}

	public void setMiddleNamel(String middlenamel) {
		this.middleNamel = middlenamel;
	}

	public String getShortNamel() {
		return shortNamel;
	}

	public void setShortNamel(String shortNamel) {
		this.shortNamel = shortNamel;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNumberofhits() {
		return numberofhits;
	}

	public void setNumberofhits(String numberofhits) {
		this.numberofhits = numberofhits;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean isEnable) {
		this.enable = isEnable;
	}

	public Boolean getBooValidateBtn() {
		return booValidateBtn;
	}

	public String getAMLStatus() {
		return AMLStatus;
	}

	public void setAMLStatus(String aMLStatus) {
		AMLStatus = aMLStatus;
	}

	public void setBooValidateBtn(Boolean booValidateBtn) {
		this.booValidateBtn = booValidateBtn;
	}

	public int getCount() {
		return count;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEmpcategory() {
		return empcategory;
	}

	public void setEmpcategory(String empcategory) {
		this.empcategory = empcategory;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getStateContact() {
		return stateContact;
	}

	public void setStateContact(String stateContact) {
		this.stateContact = stateContact;
	}

	public String getStateEmployment() {
		return stateEmployment;
	}

	public void setStateEmployment(String stateEmployment) {
		this.stateEmployment = stateEmployment;
	}

	public String getPostal_code() {
		return postalCode;
	}

	public void setPostal_code(String postal_code) {
		this.postalCode = postal_code;
	}

	public String getOffice_tel() {
		return officeTel;
	}

	public void setOffice_tel(String office_tel) {
		this.officeTel = office_tel;
	}

	public String getId_for() {
		return idFor;
	}

	public void setId_for(String id_for) {
		this.idFor = id_for;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public boolean getApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Boolean getEnablePTbl() {
		return enablePTbl;
	}

	public int getMobMin() {
		return mobMin;
	}

	public void setMobMin(int mobMin) {
		this.mobMin = mobMin;
	}

	public int getMobMax() {
		return mobMax;
	}

	public void setMobMax(int mobMax) {
		this.mobMax = mobMax;
	}

	public void setEnablePTbl(Boolean enablePTbl) {
		this.enablePTbl = enablePTbl;
	}

	public List<NationalityMaster> getNationalityList() {
		return nationalityList;
	}

	public void setNationalityList(List<NationalityMaster> nationalityList) {
		this.nationalityList = nationalityList;
	}
	
	public Boolean getBooIdNumber() {
		return booIdNumber;
	}

	public void setBooIdNumber(Boolean booIdNumber) {
		this.booIdNumber = booIdNumber;
	}

	public Boolean getBooContactDetails() {
		return booContactDetails;
	}

	public void setBooContactDetails(Boolean booContactDetails) {
		this.booContactDetails = booContactDetails;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public Boolean getNonMatchedMsg() {
		return nonMatchedMsg;
	}

	public void setNonMatchedMsg(Boolean nonMatchedMsg) {
		this.nonMatchedMsg = nonMatchedMsg;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getOfficeTel() {
		return officeTel;
	}
	
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	
	public String getIdFor() {
		return idFor;
	}
	
	public void setIdFor(String idFor) {
		this.idFor = idFor;
	}
	
	public BigDecimal getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}
	
	public List<Amlstatus> getAmlList() {
		return amlList;
	}
	
	public void setAmlList(List<Amlstatus> amlList) {
		this.amlList = amlList;
	}
	
	public List<ContactDetail> getLstFsContactDetails() {
		return lstFsContactDetails;
	}
	
	public void setLstFsContactDetails(List<ContactDetail> lstFsContactDetails) {
		this.lstFsContactDetails = lstFsContactDetails;
	}
	
	public List<Customer> getLstFsCustomer() {
		return lstFsCustomer;
	}
	
	public void setLstFsCustomer(List<Customer> lstFsCustomer) {
		this.lstFsCustomer = lstFsCustomer;
	}
	
	public List<CustomerEmploymentInfo> getLstFsCustEmpInfo() {
		return lstFsCustEmpInfo;
	}
	
	public void setLstFsCustEmpInfo(List<CustomerEmploymentInfo> lstFsCustEmpInfo) {
		this.lstFsCustEmpInfo = lstFsCustEmpInfo;
	}
	
	public List<CustomerIdProof> getLstFsCustIdProof() {
		return lstFsCustIdProof;
	}
	
	public void setLstFsCustIdProof(List<CustomerIdProof> lstFsCustIdProof) {
		this.lstFsCustIdProof = lstFsCustIdProof;
	}
	
	public List<CustomerIdProof> getFetchCustId() {
		return fetchCustId;
	}
	
	public void setFetchCustId(List<CustomerIdProof> fetchCustId) {
		this.fetchCustId = fetchCustId;
	}
	
	public List<CustomerIdProof> getLstProofData() {
		return lstProofData;
	}
	
	public void setLstProofData(List<CustomerIdProof> lstProofData) {
		this.lstProofData = lstProofData;
	}
	
	public List<StateMaster> getLstState() {
		return lstState;
	}
	
	public void setLstState(List<StateMaster> lstState) {
		this.lstState = lstState;
	}
	
	public List<CityMaster> getLstCity() {
		return lstCity;
	}
	
	public void setLstCity(List<CityMaster> lstCity) {
		this.lstCity = lstCity;
	}
	
	public void setLstData(List<AddContactBean> lstData) {
		this.lstData = lstData;
	}
	
	public void setCreateProofList(List<CreateProofTable> createProofList) {
		this.createProofList = createProofList;
	}

	public List<CustomerIdProof> getLstCustomerIdProof() {
		return lstCustomerIdProof;
	}

	public void setLstCustomerIdProof(List<CustomerIdProof> lstCustomerIdProof) {
		this.lstCustomerIdProof = lstCustomerIdProof;
	}
	
	public IGeneralService<T> getGeneralService() {
		return generalService;
	}
	
	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}
	
	public List<StateMasterDesc> getLstStateList() {
		return lstStateList;
	}

	public void setLstStateList(List<StateMasterDesc> lstStateList) {
		this.lstStateList = lstStateList;
	}
	
	public List<DistrictMasterDesc> getLstDistrictList() {
		return lstDistrictList;
	}

	public void setLstDistrictList(List<DistrictMasterDesc> lstDistrictList) {
		this.lstDistrictList = lstDistrictList;
	}

	
	public List<ContactType> getLstContactType() {
		return lstContactType;
	}

	public void setLstContactType(List<ContactType> lstContactType) {
		this.lstContactType = lstContactType;
	}
	
	public String getDataTableContactTypeValue() {
		return dataTableContactTypeValue;
	}

	public void setDataTableContactTypeValue(String dataTableContactTypeValue) {
		this.dataTableContactTypeValue = dataTableContactTypeValue;
	}

	public String getEmpInfoCountry() {
		return empInfoCountry;
	}

	public void setEmpInfoCountry(String empInfoCountry) {
		this.empInfoCountry = empInfoCountry;
	}

	public String getEmpInfoState() {
		return empInfoState;
	}

	public void setEmpInfoState(String empInfoState) {
		this.empInfoState = empInfoState;
	}

	public String getEmpInfoCity() {
		return empInfoCity;
	}

	public void setEmpInfoCity(String empInfoCity) {
		this.empInfoCity = empInfoCity;
	}

	public String getEmpInfoEmploymentTypeId() {
		return empInfoEmploymentTypeId;
	}

	public void setEmpInfoEmploymentTypeId(String empInfoEmploymentTypeId) {
		this.empInfoEmploymentTypeId = empInfoEmploymentTypeId;
	}
	
	public List<StateMasterDesc> getLstEmpInfoStateList() {
		return lstEmpInfoStateList;
	}

	public void setLstEmpInfoStateList(List<StateMasterDesc> lstEmpInfoStateList) {
		this.lstEmpInfoStateList = lstEmpInfoStateList;
	}

	public List<DistrictMasterDesc> getLstEmpInfoDistrictList() {
		return lstEmpInfoDistrictList;
	}

	public void setLstEmpInfoDistrictList(List<DistrictMasterDesc> lstEmpInfoDistrictList) {
		this.lstEmpInfoDistrictList = lstEmpInfoDistrictList;
	}

	public String getEmpInfoDistrict() {
		return empInfoDistrict;
	}

	public void setEmpInfoDistrict(String empInfoDistrict) {
		this.empInfoDistrict = empInfoDistrict;
	}
	
	public List<CityMasterDesc> getLstEmpInfoCityList() {
		return lstEmpInfoCityList;
	}

	public void setLstEmpInfoCityList(List<CityMasterDesc> lstEmpInfoCityList) {
		this.lstEmpInfoCityList = lstEmpInfoCityList;
	}
	
	public List<IdentityType> getLstEmpInfoIdentityList() {
		return lstEmpInfoIdentityList;
	}

	public void setLstEmpInfoIdentityList(List<IdentityType> lstEmpInfoIdentityList) {
		this.lstEmpInfoIdentityList = lstEmpInfoIdentityList;
	}
	
	public Boolean getBooContactCountry() {
		return booContactCountry;
	}

	public void setBooContactCountry(Boolean booContactCountry) {
		this.booContactCountry = booContactCountry;
	}

	public Boolean getBooContactBlock() {
		return booContactBlock;
	}

	public void setBooContactBlock(Boolean booContactBlock) {
		this.booContactBlock = booContactBlock;
	}

	public Boolean getBooContactStreet() {
		return booContactStreet;
	}

	public void setBooContactStreet(Boolean booContactStreet) {
		this.booContactStreet = booContactStreet;
	}

	public Boolean getBooContactTel() {
		return booContactTel;
	}

	public void setBooContactTel(Boolean booContactTel) {
		this.booContactTel = booContactTel;
	}

	public Boolean getBooContactDist() {
		return booContactDist;
	}

	public void setBooContactDist(Boolean booContactDist) {
		this.booContactDist = booContactDist;
	}

	public Boolean getBooContactState() {
		return booContactState;
	}

	public void setBooContactState(Boolean booContactState) {
		this.booContactState = booContactState;
	}
	
	public Boolean getBooContactFlat() {
		return booContactFlat;
	}

	public void setBooContactFlat(Boolean booContactFlat) {
		this.booContactFlat = booContactFlat;
	}
	
	public Boolean getBooDuplicate() {
		return booDuplicate;
	}

	public void setBooDuplicate(Boolean booDuplicate) {
		this.booDuplicate = booDuplicate;
	}
	
	public Boolean getBooIdType() {
		return booIdType;
	}

	public void setBooIdType(Boolean booIdType) {
		this.booIdType = booIdType;
	}

	public Boolean getBooIdNo() {
		return booIdNo;
	}

	public void setBooIdNo(Boolean booIdNo) {
		this.booIdNo = booIdNo;
	}

	public Boolean getBooIdTExpDate() {
		return booIdTExpDate;
	}

	public void setBooIdTExpDate(Boolean booIdTExpDate) {
		this.booIdTExpDate = booIdTExpDate;
	}
	
	public Boolean getBooProfListDuplicate() {
		return booProfListDuplicate;
	}

	public void setBooProfListDuplicate(Boolean booProfListDuplicate) {
		this.booProfListDuplicate = booProfListDuplicate;
	}
	
	public List<AddContactDetailBean> getAddContactListDeleted() {
		return addContactListDeleted;
	}

	public void setAddContactListDeleted(
			List<AddContactDetailBean> addContactListDeleted) {
		this.addContactListDeleted = addContactListDeleted;
	}
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public StreamedContent getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(StreamedContent downloadFile) {
		this.downloadFile = downloadFile;
	}
	
	public BigDecimal getImage_id() {
		return image_id;
	}

	public void setImage_id(BigDecimal image_id) {
		this.image_id = image_id;
	}
	
	public Boolean getBooBrowsedFile() {
		return booBrowsedFile;
	}

	public void setBooBrowsedFile(Boolean booBrowsedFile) {
		this.booBrowsedFile = booBrowsedFile;
	}
	
	public Boolean getBooIdTypeCheck() {
		return booIdTypeCheck;
	}

	public void setBooIdTypeCheck(Boolean booIdTypeCheck) {
		this.booIdTypeCheck = booIdTypeCheck;
	}
	
	public Blob storeImage() throws IOException, SerialException, SQLException {
        
	   	InputStream stream = null;
	   	
	   	try {
	   		stream =  file.getInputstream();
	        }catch(Exception e){
	           e.printStackTrace();
	        }
	   	return new javax.sql.rowset.serial.SerialBlob(readFully(stream));
	}
	
	public void veryfiAllClick() {
		if(getApproved()){
			for (CreateProofTable element : createProofList) {
				element.setChecked(true);
			}
		} else{
			for (CreateProofTable element : createProofList) {
				element.setChecked(false);
			}
		}
	}
	
	public  byte[] readFully(InputStream input) throws IOException {
		byte[] buffer = new byte[8192];
	    int bytesRead;
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    
	    while ((bytesRead = input.read(buffer)) != -1) {
	    	output.write(buffer, 0, bytesRead);
	    }
	    return output.toByteArray();
	}
	
	private BigDecimal individualIdType = new BigDecimal(1);

	public List<ContactType> getFetchContactTypeList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<ContactType>  lstContactType =  getGeneralService().getContactTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		for (ContactType contactType : lstContactType) {
			conTypeMap.put(contactType.getContactTypeId().toPlainString(), contactType.getContactType());
		}
		
		setLstContactType(lstContactType);
		return getLstContactType();
	}
	
	public List<IdentityType> getFetchIdType(){
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<IdentityType> idType = getGeneralService().getIdentityTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1),
				new BigDecimal(sessionStateManage.getSessionValue("countryId")), individualIdType
				);
		
		for (IdentityType identityType : idType) {
			idTypeMap.put(identityType.getIdentityTypeId().toPlainString(), identityType.getIdentityType());
		}
		
		setLstEmpInfoIdentityList(idType);
		
		return idType;
	}

	/*public List<ContactType> getContactTypeListDB(){
		contactTypeList = new ArrayList<ContactType>();
		contactTypeList.addAll(getCorpRegService().getContactTypeListFromDB());
		for(ContactType contType:contactTypeList) {
			contactTypeMap.put(contType.getContactTypeId(), contType.getContactType());
		}
		return contactTypeList;
	}*/
	
	public List<CountryMasterDesc> getCountryNameList() {

		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> lstCountry = getGeneralService().getNationalityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		for(CountryMasterDesc element: lstCountry){
        	countryMap.put(element.getCountryMasterId().toPlainString() , element.getCountryName());
        }
		
		return lstCountry;
	}

	//For Employment information panel
	public List<EmploymentType> getEmploymentTypeList() {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		return getGeneralService().getEmploymentTypes(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
	}

	//For Employment information panel
	public void generateIdentityTypeList(AjaxBehaviorEvent event) {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<IdentityType> idType = getGeneralService().getIdentityTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1),
				new BigDecimal(getEmpInfoCountry().equals("")?""+(-1):getEmpInfoCountry())
				);
		
		for (IdentityType identityType : idType) {
			idTypeMap.put(identityType.getIdentityTypeId().toPlainString(), identityType.getIdentityType());
		}
		
		setLstEmpInfoIdentityList(idType);
	}
	
	
	public void getContactDbForShow(){
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<ContactType>  lstContactType =  getGeneralService().getContactTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		for (ContactType contactType : lstContactType) {
			conTypeMap.put(contactType.getContactTypeId().toPlainString(), contactType.getContactType());
		}
	}
	
	public void generateStateList(AjaxBehaviorEvent event) {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getCountry().equals("")?""+(-1):getCountry())); 
		
		for (StateMasterDesc stateMasterDesc : stateMaster) {
			stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
		}
		
		setLstStateList(stateMaster);
		
	}
	
	
	public void  getIDTypeValue(AjaxBehaviorEvent event) {
		
		System.out.println("Called from change");
		
		setIdTypeBranchPage(getIdType());
		
		setBooPass(false);
		setBooValidateBtn(true);
		
		setToken("");
		setRemName("");
		setMiddleName("");
		setLastName("");
		setShortName("");
		setFirstNamel("");
		setMiddleNamel("");
		setLastNamel("");
		setShortNamel("");
		setMobile("");
		setAlternativeEmail("");
		setDob(null);
		setAMLStatus(""); 
		setNationality("1");
		setGender("1");
		setIdNumber("");
	}
	
	public void generateDistrictList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getCountry().equals("")?"-1":getCountry()),
				new BigDecimal(getStateContact().equals("")?"-1":getStateContact())
				);
		
		districtBean = new ArrayList<District>();
		for (DistrictMasterDesc districtDes : lstDistrict) {
			districtBean.add( new District(districtDes.getFsDistrictMaster().getDistrictId().toPlainString(), districtDes.getDistrict()));
			districtMap.put(districtDes.getFsDistrictMaster().getDistrictId().toPlainString(), districtDes.getDistrict());
		}
	}
	
	public List<District> getDistrictFromDb() {
		return districtBean;
	}
	
	/*public void getChkVeryfyAll() {
		System.out.println("Called");
		System.out.println(getApproved());
	}*/
	
	//For Employee Information get state list
	public void generateEmpInfoStateList(AjaxBehaviorEvent event) {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> lstState = getGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry()));
		
		for (StateMasterDesc stateMasterDesc : lstState) {
			stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
		}
		
		setLstEmpInfoStateList(lstState);
		
		generateIdentityTypeList(event);
	}

	public void getEmploymentStatus(AjaxBehaviorEvent event) {
		if(getEmploymentType().equalsIgnoreCase("3") || getEmploymentType().equalsIgnoreCase("0")){
			setBooUnEmp(false);
		} else {
			setBooUnEmp(true);
		}
		
	}

	//For Employee Information get district list
	public void generateEmpInfoDistrictList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<DistrictMasterDesc> lstDistrit = getGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry()),
				new BigDecimal(getEmpInfoState().equals("")?"-1":getEmpInfoState())
				); 
		
		for (DistrictMasterDesc districtMasterDesc : lstDistrit) {
			stateMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
		}
		
		setLstEmpInfoDistrictList(lstDistrit);
	}

	//For Employee Information get city list
	public void generateEmpInfoCityList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<CityMasterDesc> lstCity = getGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry()),
				new BigDecimal(getEmpInfoState().equals("")?"-1":getEmpInfoState()),
				new BigDecimal(getEmpInfoDistrict().equals("")?"-1":getEmpInfoDistrict())
				); 
		
		for (CityMasterDesc cityMasterDesc : lstCity) {
			cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
		}
		setLstEmpInfoCityList(lstCity);
	}

	public List<NationalityMaster> getNationalityNameList() {
		nationalityList = new ArrayList<NationalityMaster>();
		nationalityList.addAll(getBranchpageService().getNationality());
		return nationalityList;
	}

	public List<CountryMasterDesc> getNationalityDescNameList() {

		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> obj = getBranchpageService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		return obj;
	}

	public void addAction() {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		BigDecimal Language = new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1);
		
		if(viewBehaviorBean("Contact Type","REQUIRED").equalsIgnoreCase("true") && (this.contactType == null || this.contactType.equalsIgnoreCase(""))){
			setBooContactContactType(true);
			setBooLocalArea(false);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactDist(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			FacesContext.getCurrentInstance().addMessage("ContactType", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose Contact Type !!!!!! "));
		} else if (viewBehaviorBean("Local Area","REQUIRED").equalsIgnoreCase("true") && (this.localArea == null || this.localArea.equalsIgnoreCase(""))) {
			setBooLocalArea(true);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactDist(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("localarea", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter Local Area !!!!!! "));
		}  else if (viewBehaviorBean("Country","REQUIRED").equalsIgnoreCase("true") && (this.country == null || this.country.equalsIgnoreCase(""))) {
			setBooContactCountry(true);
			
			setBooLocalArea(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactDist(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("Country", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose a Country. !!!!!! "));
		} else if (viewBehaviorBean("State","REQUIRED").equalsIgnoreCase("true") && (this.stateContact == null || this.stateContact.equalsIgnoreCase(""))) {
			setBooContactState(true);
			
			setBooLocalArea(false);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactDist(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("State", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose a State !!!!!! "));
		} else if(viewBehaviorBean("District","REQUIRED").equalsIgnoreCase("true") && (this.dist  == null || this.dist .equalsIgnoreCase(""))) {
			setBooContactDist(true);
			
			setBooLocalArea(false);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("District", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose a District !!!!!! "));
		} else if(viewBehaviorBean("City","REQUIRED").equalsIgnoreCase("true") && (this.city  == null || this.city.equalsIgnoreCase(""))) {
			setBooContactCity(true);
			
			setBooContactDist(false);
			setBooLocalArea(false);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactStreet(false);
			setBooContactTel(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("District", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose a District !!!!!! "));
		} else if (viewBehaviorBean("Street","REQUIRED").equalsIgnoreCase("true") && (this.streetNo == null || this.streetNo.equalsIgnoreCase(""))) {
			setBooContactStreet(true);
			
			setBooLocalArea(false);
			setBooContactCountry(false);
			setBooContactBlock(false);
			setBooContactTel(false);
			setBooContactDist(false);
			setBooContactState(false);
			setBooContactFlat(false);
			setBooContactCity(false);
			setBooContactContactType(false);
			FacesContext.getCurrentInstance().addMessage("Street", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter a Strret No. !!!!!! "));
		} else if(viewBehaviorBean("Telephone Number","REQUIRED").equalsIgnoreCase("true") && (this.telephoneNo == null ||	this.telephoneNo.equalsIgnoreCase(""))){
				setBooContactTel(true);
				
				setBooLocalArea(false);
				setBooContactCountry(false);
				setBooContactBlock(false);
				setBooContactStreet(false);
				setBooContactDist(false);
				setBooContactState(false);
				setBooContactFlat(false);
				setBooContactCity(false);
				setBooContactContactType(false);
				FacesContext.getCurrentInstance().addMessage("Telephone", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter Telephone Number !!!!!! "));
		} else if(Integer.parseInt(viewBehaviorBean("Telephone Number","MAX_VALUE")) != this.telephoneNo.length()){
				setBooContactTel(true);
				
				setBooLocalArea(false);
				setBooContactCountry(false);
				setBooContactBlock(false);
				setBooContactStreet(false);
				setBooContactDist(false);
				setBooContactState(false);
				setBooContactFlat(false);
				setBooContactCity(false);
				setBooContactContactType(false);
				FacesContext.getCurrentInstance().addMessage("Telephone", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter Telephone Number !!!!!! "));
		} else if(viewBehaviorBean("Flat","REQUIRED").equalsIgnoreCase("true") && (this.flatNo == null || this.flatNo.equalsIgnoreCase(""))) {
				setBooContactFlat(true);
				
				setBooLocalArea(false);
				setBooContactCountry(false);
				setBooContactBlock(false);
				setBooContactStreet(false);
				setBooContactTel(false);
				setBooContactDist(false);
				setBooContactState(false);
				setBooContactCity(false);
				setBooContactContactType(false);
				FacesContext.getCurrentInstance().addMessage("Flat", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter Flat No. !!!!!! "));
		} else if(viewBehaviorBean("Block online rem","REQUIRED").equalsIgnoreCase("true") && (this.blockNo == null || this.blockNo.equalsIgnoreCase(""))) {
				setBooContactBlock(true);
				
				setBooLocalArea(false);
				setBooContactCountry(false);
				setBooContactStreet(false);
				setBooContactTel(false);
				setBooContactDist(false);
				setBooContactState(false);
				setBooContactFlat(false);
				setBooContactCity(false);
				setBooContactContactType(false);
				FacesContext.getCurrentInstance().addMessage("BlockNo", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Enter Block No. !!!!!! "));
		}  else {
				setBooLocalArea(false);
				setBooContactCountry(false);
				setBooContactBlock(false);
				setBooContactStreet(false);
				setBooContactTel(false);
				setBooContactDist(false);
				setBooContactState(false);
				setBooContactFlat(false);
				setBooContactCity(false);
				setBooContactContactType(false);
				
				setBooDuplicate(false);
			
				for (AddContactDetailBean element : addContactList) {
					
					
					/*System.out.println(this.contactType+"  "+element.getContactTypeId().toPlainString()+"     "+
							this.localArea+"  "+element.getArea()+"     "+
							this.stateContact+"  "+element.getStateId()+"     "+
							this.streetNo+"  "+element.getStreet()+"     "+
							this.flatNo+"  "+element.getFlat()+"     "+
							this.telephoneNo+"  "+element.getTel()+"     "+
							this.country+"  "+element.getCountryId().toPlainString()+"     "+
							this.blockNo+"  "+element.getBlock()+"     "+
							this.dist+"  "+element.getDistrictId().toPlainString()+"     "+
							this.city+"  "+element.getCityId().toPlainString()
							);*/
				
				
				
				if(this.contactType.equalsIgnoreCase(element.getContactTypeId().toPlainString()) && 
						this.localArea.equalsIgnoreCase(element.getArea()) && 
						this.stateContact.equalsIgnoreCase(element.getStateId().toPlainString())&&
						this.streetNo.equalsIgnoreCase(element.getStreet()) && 
						this.flatNo.equalsIgnoreCase(element.getFlat()) &&
						this.telephoneNo.equalsIgnoreCase(element.getTel()) &&
						this.country.equalsIgnoreCase(element.getCountryId().toPlainString()) &&
						this.blockNo.equalsIgnoreCase(element.getBlock()) &&
						this.dist.equalsIgnoreCase(element.getDistrictId().toPlainString()) &&
						this.city.equalsIgnoreCase(element.getCityId().toPlainString())
						){
					
					setBooDuplicate(true);
					break;
				}
			}
			
			if(!getBooDuplicate()){
				
				List<CountryMasterDesc> countryDesc = new ArrayList<CountryMasterDesc>();
				List<StateMasterDesc> statemaster = new ArrayList<StateMasterDesc>();
				List<DistrictMasterDesc> ditrsict = new ArrayList<DistrictMasterDesc>();
				List<CityMasterDesc> ciy = new ArrayList<CityMasterDesc>();
				
				
				try{
					countryDesc = getGeneralService().getCountryList(Language); 
					for (CountryMasterDesc countryMasterDesc : countryDesc) {
						countryMap.put(countryMasterDesc.getFsCountryMaster().getCountryId().toPlainString(), countryMasterDesc.getCountryName());
					}
					
					
					try{
						statemaster = getGeneralService().getStateList(Language, new BigDecimal(this.country));
						for (StateMasterDesc stateMasterDesc : statemaster) {
							stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
						}
						
					} catch(Exception e){
						statemaster = getGeneralService().getStateList(Language, new BigDecimal(120));
						for (StateMasterDesc stateMasterDesc : statemaster) {
							stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
						}
					}
					
					try{
						ditrsict = getGeneralService().getDistrictList(Language, new BigDecimal(this.country) , new BigDecimal(this.stateContact)); 
						for (DistrictMasterDesc districtMasterDesc : ditrsict) {
							districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
						}
					} catch(Exception e){
						ditrsict = getGeneralService().getDistrictList(Language, new BigDecimal(120), new BigDecimal(this.stateContact)); 
						for (DistrictMasterDesc districtMasterDesc : ditrsict) {
							districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
						}
					}
					
					try{
						ciy = getGeneralService().getCityList(Language, new BigDecimal(this.country), new BigDecimal(this.stateContact), new BigDecimal(this.dist)); 
						for (CityMasterDesc cityMasterDesc : ciy) {
							cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
						}
					} catch(Exception e){
						ciy = getGeneralService().getCityList(Language, new BigDecimal(120), new BigDecimal(this.stateContact) , new BigDecimal(this.dist)); 
						for (CityMasterDesc cityMasterDesc : ciy) {
							cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
						}
					}
					
					conTypeMap.put("1", "Residence");
					conTypeMap.put("2", "Office");
					
					 AddContactDetailBean addContact = new AddContactDetailBean( conTypeMap.get(this.contactType), this.localArea,
				 				countryMap.get(this.country), this.streetNo, this.blockNo, this.telephoneNo, this.flatNo, stateMap.get(this.stateContact),
				 				districtMap.get(this.dist),
				 				cityMap.get(this.city),false ,true, new BigDecimal(this.contactType) ,new BigDecimal(this.country), new BigDecimal(this.stateContact), 
				 				new BigDecimal(this.dist), new BigDecimal(this.city), new BigDecimal(0));
						
					 addContact.setLstCountryList(countryDesc);
					 addContact.setLstStateList(statemaster);
					 addContact.setLstDistrictList(ditrsict);
					 addContact.setLstCityList(ciy);
					 
					conTypeMap.put("1", "Residence");
					conTypeMap.put("2", "Office");
					
					addContact.setContType(conTypeMap.containsKey(this.contactType)?conTypeMap.get(this.contactType):"");
					addContact.setCountry(countryMap.containsKey(this.country)?countryMap.get(this.country):"");
					addContact.setState(stateMap.containsKey(this.stateContact)?stateMap.get(this.stateContact):"");
					addContact.setDist(districtMap.containsKey(this.dist)?districtMap.get(this.dist):"");
					addContact.setCity(cityMap.containsKey(this.city)?cityMap.get(this.city):"");
					
					addContactList.add(addContact);
					setContactType("");
					setLocalArea("");
					setStateContact("");
					setStreetNo("");
					setBlockNo("");
					setTelephoneNo("");
					setDist("");
					setFlatNo("");
					setCountry("");
					setCity("");
					setBooContactDetailsSize(false); 
					setEnable(true);
								
				} catch(Exception e){
					
					countryDesc = getGeneralService().getCountryList(Language); 
					for (CountryMasterDesc countryMasterDesc : countryDesc) {
						countryMap.put(countryMasterDesc.getFsCountryMaster().getCountryId().toPlainString(), countryMasterDesc.getCountryName());
					}
					
					
					try{
						statemaster = getGeneralService().getStateList(Language, new BigDecimal(this.country));
						for (StateMasterDesc stateMasterDesc : statemaster) {
							stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
						}
						
					} catch(Exception ex){
						statemaster = getGeneralService().getStateList(Language, new BigDecimal(120));
						for (StateMasterDesc stateMasterDesc : statemaster) {
							stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
						}
					}
					
					try{
						ditrsict = getGeneralService().getDistrictList(Language, new BigDecimal(this.country) , new BigDecimal(this.stateContact)); 
						for (DistrictMasterDesc districtMasterDesc : ditrsict) {
							districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
						}
					} catch(Exception exx){
						ditrsict = getGeneralService().getDistrictList(Language, new BigDecimal(120), new BigDecimal(this.stateContact)); 
						for (DistrictMasterDesc districtMasterDesc : ditrsict) {
							districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
						}
					}
					
					try{
						ciy = getGeneralService().getCityList(Language, new BigDecimal(this.country), new BigDecimal(this.stateContact), new BigDecimal(this.dist)); 
						for (CityMasterDesc cityMasterDesc : ciy) {
							cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
						}
					} catch(Exception exx){
						ciy = getGeneralService().getCityList(Language, new BigDecimal(120), new BigDecimal(this.stateContact) , new BigDecimal(this.dist)); 
						for (CityMasterDesc cityMasterDesc : ciy) {
							cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
						}
					}
					
					 AddContactDetailBean addContact = new AddContactDetailBean( conTypeMap.get(this.contactType), this.localArea,
				 				countryMap.get(this.country), this.streetNo, this.blockNo, this.telephoneNo, this.flatNo, stateMap.get(this.stateContact),
				 				districtMap.get(this.dist),
				 				cityMap.get(this.city),false ,true, new BigDecimal(this.contactType) ,new BigDecimal(this.country), new BigDecimal(this.stateContact), 
				 				new BigDecimal(this.dist), new BigDecimal(0), new BigDecimal(0));
						
					 
					 addContact.setLstCountryList(countryDesc);
					 addContact.setLstStateList(statemaster);
					 addContact.setLstDistrictList(ditrsict);
					 addContact.setLstCityList(ciy);
						
						
					addContact.setContType(conTypeMap.containsKey(this.contactType)?conTypeMap.get(this.contactType):"");
					addContact.setCountry(countryMap.containsKey(this.country)?countryMap.get(this.country):"");
					addContact.setState(stateMap.containsKey(this.stateContact)?stateMap.get(this.stateContact):"");
					addContact.setDist(districtMap.containsKey(this.dist)?districtMap.get(this.dist):"");
					addContact.setCity(cityMap.containsKey(this.city)?cityMap.get(this.city):"");
					
					addContactList.add(addContact);
					setLocalArea("");
					setStateContact("");
					setStreetNo("");
					setBlockNo("");
					setTelephoneNo("");
					setDist("");
					setFlatNo("");
					setCountry("");
					setBooContactDetailsSize(false); 
					setEnable(true);
				}
			} else {
				setBooDuplicate(true);
				FacesContext.getCurrentInstance().addMessage("Message", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Duplicate Contact Details !!!!!! "));
			}
		}
	}
	
	public void generateCityList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<CityMasterDesc> lstCity = getGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getCountry().equals("")?"-1":getCountry()),
				new BigDecimal(getStateContact().equals("")?"-1":getStateContact()),
				new BigDecimal(getDist().equals("")?"-1":getDist())
				); 
		
		for (CityMasterDesc cityMasterDesc : lstCity) {
			cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
		}
		setContactCityList(lstCity);
	}
	
	public void ShowFromSearchPage(String civil_id, String id_type) {
		setBooIdTypeCheck(false);
		setIdType(id_type);
		setIdNumber(civil_id);
	}
	
	// Get customer id using id number
	private boolean getCustomerIdProofDetail(){
		try{
		//	setCustomerId(getBranchpageService().getCustomerIdProof(getIdNumber()).getFsCustomer().getCustomerId());
			return true;
		}catch(Exception e){
			log.error("Error fetch customer id from database ================== "+e);
			return false;
		}
	}

	private void setCustomerIdProofDataTable(){
		
		lstCustomerIdProof = getBranchpageService().getCustomerIdProofListAll();
		for (CustomerIdProof element : lstCustomerIdProof) {
			if(element.getIdentityInt().equalsIgnoreCase(getIdNumber())){
				setCustomerId(element.getFsCustomer().getCustomerId());
			}
		}
		
		lstCustomerIdProof.clear();
		lstCustomerIdProof = getBranchpageService().getCustomerIdProofList(getCustomerId());
		
		CreateProofTable createProofTable = null;
	
		for (CustomerIdProof beanElement : lstCustomerIdProof) {
			try {
				createProofTable = new CreateProofTable(
						beanElement.getIdentityFor(),
						beanElement.getFsIdentityType().getIdentityTypeId().toPlainString(),
						beanElement.getIdentityInt(),
						new SimpleDateFormat(DATE_FORMAT).format(beanElement.getIdentityExpiryDate()),
						"update",
						beanElement.getCustProofId().intValue(),
						idForMap.get(beanElement.getIdentityFor()),
						idTypeMap.get(beanElement.getFsIdentityType().getIdentityTypeId().toPlainString()),
						beanElement.getFsDocumentImg().getImgId()
						);
			} catch(Exception e) {
				createProofTable = new CreateProofTable(
						beanElement.getIdentityFor(),
						beanElement.getFsIdentityType().getIdentityTypeId().toPlainString(),
						beanElement.getIdentityInt(),
						new SimpleDateFormat(DATE_FORMAT).format(beanElement.getIdentityExpiryDate()),
						"update",
						beanElement.getCustProofId().intValue(),
						idForMap.get(beanElement.getIdentityFor()),
						idTypeMap.get(beanElement.getFsIdentityType().getIdentityTypeId().toPlainString()),
						beanElement.getFsDocumentImg().getImgId());
			}
			
			
			createProofTable.setChecked(beanElement.getApprovedBy().equals("0")?false:true);
			createProofList.add(createProofTable);
		}
	}
	
	//Fetch customer entire detail if it is available
	private void getCustomerCompleteDetail(){
		
		lstFsCustomer = new ArrayList<Customer>();
		lstFsContactDetails = new ArrayList<ContactDetail>();
		lstFsCustEmpInfo = new ArrayList<CustomerEmploymentInfo>();
		lstFsCustIdProof = new ArrayList<CustomerIdProof>();
		
		//Fetch customer table info
		try{
			lstFsCustomer.addAll(getBranchpageService().getCustomerInfo(getCustomerId()));
		}catch(Exception e){
			log.error(getCustomerId().intValue()+" customer detail not found ! :: "+e);
		}
		
		//Fetch customer contact details info
		try{
			lstFsContactDetails.addAll(getBranchpageService().getCustomerContactDetails(getCustomerId()));
		}catch(Exception e){
			log.error(getCustomerId().intValue()+" customer contact detail not found ! :: "+e);
		}
		
		//Fetch customer employment details info
		try{
			lstFsCustEmpInfo.addAll(getBranchpageService().getCustomerEmploymentInfo(getCustomerId()));
		}catch(Exception e){
			log.error(getCustomerId().intValue()+" customer employment detail not found ! :: "+e);
		}
		
		//Fetch customer ID Proof details info
		try{
			lstFsCustIdProof.addAll(getBranchpageService().getCustomerIdProofList(getCustomerId()));
		}catch(Exception e){
			log.error(getCustomerId().intValue()+" customer ID Proof detail not found ! :: "+e);
		}
	}
	
	// Set Customer Email id. ie if email exists for this customer in customer login
	private void setCustomerEmail(){

		try {
			setEmail(((CustomerLogin) getBranchpageService().getLoginInfoForCustomer(getCustomerId()).get(0)).getEmail());
		} catch (Exception e) {
			log.error("Email Id not found in customer login for customer ID : "+getCustomerId().intValue());
		}
	}
	
	public void remove(AddContactDetailBean bean) {
		addContactList.remove(bean);
		addContactListDeleted.add(bean);
	}
	
	public void removeIdProof(CreateProofTable proofTable) {
		createProofList.remove(proofTable);
		createProofListDelete.add(proofTable);
	}
	
	public void modified(AddContactDetailBean obj) {
		
		conTypeMap.put("1", "Residence");
		conTypeMap.put("2", "Office");
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		BigDecimal Language = new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1);
		
		List<CountryMasterDesc> countryDesc = getGeneralService().getCountryList(Language); 
		for (CountryMasterDesc countryMasterDesc : countryDesc) {
			countryMap.put(countryMasterDesc.getFsCountryMaster().getCountryId().toPlainString(), countryMasterDesc.getCountryName());
		}
		obj.setLstCountryList(countryDesc);
		
		try{
			List<StateMasterDesc> statemaster = getGeneralService().getStateList(Language, obj.getCountryId());
			for (StateMasterDesc stateMasterDesc : statemaster) {
				stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
			}
			obj.setLstStateList(statemaster);
		} catch(Exception e){
			List<StateMasterDesc> statemaster = getGeneralService().getStateList(Language, new BigDecimal(120));
			for (StateMasterDesc stateMasterDesc : statemaster) {
				stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
			}
			obj.setLstStateList(statemaster);
		}
		
		try{
			List<DistrictMasterDesc> ditrsict = getGeneralService().getDistrictList(Language, obj.getCountryId(), new BigDecimal(1)); 
			for (DistrictMasterDesc districtMasterDesc : ditrsict) {
				districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
			}
			obj.setLstDistrictList(ditrsict);
		} catch(Exception e){
			List<DistrictMasterDesc> ditrsict = getGeneralService().getDistrictList(Language, new BigDecimal(120), new BigDecimal(1)); 
			for (DistrictMasterDesc districtMasterDesc : ditrsict) {
				districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
			}
			obj.setLstDistrictList(ditrsict);
		}
		
		try{
			List<CityMasterDesc> ciy = getGeneralService().getCityList(Language, obj.getCountryId(), obj.getStateId(), obj.getDistrictId()); 
			for (CityMasterDesc cityMasterDesc : ciy) {
				cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
			}
			obj.setLstCityList(ciy);
		} catch(Exception e){
			List<CityMasterDesc> ciy = getGeneralService().getCityList(Language, new BigDecimal(120), obj.getStateId(), obj.getDistrictId()); 
			for (CityMasterDesc cityMasterDesc : ciy) {
				cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
			}
		}
		
		obj.setContType(conTypeMap.containsKey(obj.getContactTypeId().toPlainString())?conTypeMap.get(obj.getContactTypeId().toPlainString()):"");
		obj.setCountry(countryMap.get(obj.getCountryId().toPlainString()));
		obj.setState(stateMap.containsKey(obj.getStateId().toPlainString())?stateMap.get(obj.getStateId().toPlainString()):"");
		obj.setDist(districtMap.containsKey(obj.getDistrictId().toPlainString())?districtMap.get(obj.getDistrictId().toPlainString()):"");
		/*obj.setCity(cityMap.containsKey(obj.getCity())?cityMap.get(obj.getCity()):"");*/
	}
	
	
	public void modifiedProofList(CreateProofTable table) {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		idForMap.put("1", "Address Proof");
		idForMap.put("2", "Identity Proof");
		
		List<IdentityType> idType = getGeneralService().getIdentityTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1),
				new BigDecimal(sessionStateManage.getSessionValue("countryId")), individualIdType
				);
		
		for (IdentityType identityType : idType) {
			idTypeMap.put(identityType.getIdentityTypeId().toPlainString(), identityType.getIdentityType());
		}
		
		table.setIdFor(idForMap.get(table.getId_for()));
		table.setIdType(idTypeMap.get(table.getId_type()));
	}
	
	
	public void viewDetails() {
		setBooPass(false);
		setBooValidateBtn(true);
		
		setToken("");
		setRemName("");
		setMiddleName("");
		setLastName("");
		setShortName("");
		setFirstNamel("");
		setMiddleNamel("");
		setLastNamel("");
		setShortNamel("");
		setMobile("");
		setAlternativeEmail("");
		setDob(null);
		setAMLStatus(""); 
		setNationality("1");
		setGender("1");
		
		if(getIdTypeBranchPage().equalsIgnoreCase("")){
			setBooIdTypeCheck(true);
		} else if(!getIdTypeBranchPage().equalsIgnoreCase("1")){
			setIdType(getIdTypeBranchPage());
			setBooIdTypeCheck(false);
			setBooIdValidator(false);
			SessionStateManage sessionStateManage = new SessionStateManage();
			BigDecimal language = new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1);
			
			if(getIdNumber().length() == 12){
				try {
					Calendar cal = new GregorianCalendar();
					cal.setTime(new Date());
					cal.add(Calendar.DAY_OF_MONTH,+ 90);
					Date today90 = cal.getTime();
					
					SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
					String finalDate = form.format(today90);

					setExpDateCheck(finalDate);
					
					idForMap.put("1", "Address Proof");
					idForMap.put("2", "Identity Proof");
					
									
				} catch (Exception e) {
		
				}

				setCustomerId(new BigDecimal(0));
				boolean isCustomerIdExists = getCustomerIdProofDetail();

				//Get and set customer email if it is exist in CUSTOMER_LOGIN table
				setCustomerEmail();
				
				if (isCustomerIdExists) {
					
					getFetchIdType();
					//Get customer id proof detail
					setCustomerIdProofDataTable();
					
					//Get Customer Complete Detail
					getCustomerCompleteDetail();
				}
				
				// There is data in Database for that Civil Id
				if (lstFsCustIdProof !=null && lstFsCustIdProof.size() > 0) {
					getCountryNameList();
					setEmpInfoCountry(lstFsCustEmpInfo.get(0).getFsCountryMaster().getCountryId().toString());
					getStateFromDb();
					/*setEmpInfoState(lstFsCustEmpInfo.get(0).getStateId().toPlainString());
					getDistrictFromDbForShow();
					setEmpInfoDistrict(lstFsCustEmpInfo.get(0).getDistrictId().toPlainString());
					popCityForShow();
					setEmpInfoCity(lstFsCustEmpInfo.get(0).getCityId().toPlainString());
					getContactDbForShow();*/
					
					setNonMatchedMsg(false);

					addContactList.clear();
					AddContactDetailBean contact = new AddContactDetailBean();
					for (ContactDetail details : lstFsContactDetails) {
						try{
							
							List<CountryMasterDesc> countryDesc = getGeneralService().getCountryList(language); 
							for (CountryMasterDesc countryMasterDesc : countryDesc) {
								countryMap.put(countryMasterDesc.getFsCountryMaster().getCountryId().toPlainString(), countryMasterDesc.getCountryName());
							}
							
							List<StateMasterDesc> statemaster = getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId());
							for (StateMasterDesc stateMasterDesc : statemaster) {
								stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
							}
							
							List<DistrictMasterDesc> ditrsict = getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()); 
							for (DistrictMasterDesc districtMasterDesc : ditrsict) {
								districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
							}
							List<CityMasterDesc> ciy = getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), 
																							details.getFsDistrictMaster().getDistrictId()); 
							for (CityMasterDesc cityMasterDesc : ciy) {
								cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
							}
							
							 contact =  new AddContactDetailBean(
										details.getFsContactType().getContactType() ,
										details.getArea(),
										countryMap.get(details.getFsCountryMaster().getCountryId().toPlainString()) , 
										details.getStreet(), 
										details.getBlock(),details.getTelephone(),details.getFlat(),
										stateMap.get(details.getFsStateMaster().getStateId().toPlainString()),
										districtMap.get(details.getFsDistrictMaster().getDistrictId().toPlainString()),
										cityMap.get(details.getFsCityMaster().getCityId().toPlainString()),
												true,false,
												details.getFsContactType().getContactTypeId(),
												details.getFsCountryMaster().getCountryId(),
												details.getFsStateMaster().getStateId(),
												details.getFsDistrictMaster().getDistrictId(),
												details.getFsCityMaster().getCityId(),
												details.getContactDetailId());
										
								contact.setLstCountryList(getGeneralService().getCountryList(language));
								contact.setLstStateList(getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId()));
								contact.setLstDistrictList(getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()));
								contact.setLstCityList(getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), details.getFsDistrictMaster().getDistrictId()));
								addContactList.add(contact);
								setEnable(true);
						} catch(Exception e){
							
							 contact =  new AddContactDetailBean(
										details.getFsContactType().getContactType() ,
										details.getArea(),
										countryMap.get(details.getFsCountryMaster().getCountryId()) , 
										details.getStreet(), 
										details.getBlock(),details.getTelephone(),details.getFlat(),
										stateMap.get(details.getFsStateMaster().getStateId()),
										districtMap.get(details.getFsDistrictMaster().getDistrictId()),
										"",
												true,false,
												details.getFsContactType().getContactTypeId(),
												details.getFsCountryMaster().getCountryId(),
												details.getFsStateMaster().getStateId(),
												details.getFsDistrictMaster().getDistrictId(),
												new BigDecimal(1),
												details.getContactDetailId());
										
								contact.setLstCountryList(getGeneralService().getCountryList(language));
								contact.setLstStateList(getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId()));
								contact.setLstDistrictList(getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()));
								contact.setLstCityList(getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), details.getFsDistrictMaster().getDistrictId()));
								addContactList.add(contact);
								setEnable(true);
						}
							
					}
					
					if (lstFsContactDetails.size() > 0) {
						setBooContactDetails(false);
					} else {
						setBooContactDetails(true);
					}

					setShortName(lstFsCustomer.get(0).getShortName());
					setShortNamel(lstFsCustomer.get(0).getShortNameLocal());
					setAMLStatus(lstFsCustomer.get(0).getAmlStatus());
					
					if (lstFsCustomer.get(0).getActivatedInd()!=null && lstFsCustomer.get(0).getActivatedInd().equalsIgnoreCase("1")) {
						setApproved(true);
					} else {
						setApproved(false);
					}

					setRemName(lstFsCustomer.get(0).getFirstName());
					setToken(lstFsCustomer.get(0).getTokenKey());
					setLastName(lstFsCustomer.get(0).getLastName());
					setMiddleName(lstFsCustomer.get(0).getMiddleName());
					setFirstNamel(lstFsCustomer.get(0).getFirstNameLocal());
					setMiddleNamel(lstFsCustomer.get(0).getMiddleNameLocal());
					setLastNamel(lstFsCustomer.get(0).getLastNameLocal());
					setTitle(lstFsCustomer.get(0).getTitle());
					setTitlel(lstFsCustomer.get(0).getTitleLocal());
					setGender(lstFsCustomer.get(0).getGender());
					
					Calendar cal = new GregorianCalendar();
					cal.setTime(new Date());
					cal.add(Calendar.DAY_OF_MONTH,- 6480);
					Date today90 = cal.getTime();
					
					SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
					String finalDate = form.format(today90);
					
					setMinDob(finalDate);
					
					setDob(lstFsCustomer.get(0).getDateOfBirth());
					setNationality(lstFsCustomer.get(0).getFsCountryMasterByNationality().getCountryId().toPlainString());
					setAlternativeEmail(lstFsCustomer.get(0).getAlterEmailId());
					setMobile(lstFsCustomer.get(0).getMobile());
					
					
					setEmail(lstFsCustomer.get(0).getEmail());
					if(lstFsCustEmpInfo.size() > 0){
						setEmploymentType(lstFsCustEmpInfo.get(0).getFsEmploymentType().getEmploymentTypeId().toPlainString());
						
						if(getEmploymentType().equalsIgnoreCase("3") || getEmploymentType().equalsIgnoreCase("0")){
							setBooUnEmp(false);
						} else{
							setBooUnEmp(true);
						}
						setOccupation(lstFsCustEmpInfo.get(0).getOccupation());
						setEmployer(lstFsCustEmpInfo.get(0).getEmployerName());
						setEmpInfoBlock(lstFsCustEmpInfo.get(0).getBlock());
						setEmpInfoStreet(lstFsCustEmpInfo.get(0).getStreet());
						setArea(lstFsCustEmpInfo.get(0).getArea());
						setPostal_code(lstFsCustEmpInfo.get(0).getPostal());
						
						
						//setId_number(getIdNumber());
						
						setStateEmployment(lstFsCustEmpInfo.get(0).getFsEmploymentType().getEmploymentType());
						
						setOffice_tel(lstFsCustEmpInfo.get(0).getOfficeTelephone());
					}
					
					setExpDate(lstFsCustIdProof.get(0).getIdentityEndDate());
					//setIdNumber("");
					//setIdType("");
					setBooSave(false); //Means need to update depending upon Civil ID, not save
					setBooValidateBtn(false);
					setBooTable(true);
					setBooCommon(true);
					
					setBooPass(true);
				} else {
					setBooSave(true); //need to save
					setBooCommon(true);
					setBooPass(false);
					setBooValidateBtn(true);
					setBooTable(false);
					setReadonly(false);
					if(addContactList!=null){addContactList.clear();}
					if(createProofList!=null){createProofList.clear();}
					setShortName(null);
					setShortNamel(null);
					setAMLStatus(null);
					setRemName(null);
					setLastName(null);
					setMiddleName(null);
					setFirstNamel(null);
					setMiddleNamel(null);
					setLastNamel(null);
					setTitle(null);
					setTitlel(null);
					setGender(null);
					setDob(null);
					setNationality(null);
					setAlternativeEmail(null);
					setMobile(null);
					setEmploymentType(null);
					setOccupation(null);
					setEmployer(null);
					setBlockNo(null);
					setStreetNo(null);
					setArea(null);
					setPostal_code(null);
//					getStateFromDb();
					setStateEmployment(null);
					popCityForShow(null);
					setCity(null);
					setOffice_tel(null);
					setExpDate(null);
					setNonMatchedMsg(true);
				}
			}
		} else {
			setIdType(getIdTypeBranchPage());
			setBooIdTypeCheck(false);
			String value = getIdNumber();
			String validityStatus = "";
	        String civilidPartial = "";
	        int remainder = 0;
	        int civilidLength = 0;
	        int civilidCal = 0;
	        int civilidLastDigit = 0;
	        int civilidCalChkDigit = 0;
	        final int ELEVEN=11;
	        final int TWELVE=12;
	        // -- Check Length Civil ID
	        civilidLength = value.toString().length();
	        if (civilidLength != TWELVE) {
	               validityStatus = "false";
	        } else {
	        	try{

		        	// -- First 11 Characters for Calculation.
		            civilidPartial = value.toString().substring(0, ELEVEN);
		            // -- 12th Character Check Digit
		            value.toString().intern();
		            civilidLastDigit = Integer.parseInt(value.toString().substring(11, 12));
		            // -- Calculation as per PACI Rules for calculating check digit
		            civilidCal = Integer.parseInt(civilidPartial.substring(0, 1)) * 2
		                            + Integer.parseInt(civilidPartial.substring(1, 2)) * 1
		                            + Integer.parseInt(civilidPartial.substring(2, 3)) * 6
		                            + Integer.parseInt(civilidPartial.substring(3, 4)) * 3
		                            + Integer.parseInt(civilidPartial.substring(4, 5)) * 7
		                            + Integer.parseInt(civilidPartial.substring(5, 6)) * 9
		                            + Integer.parseInt(civilidPartial.substring(6, 7)) * 10
		                            + Integer.parseInt(civilidPartial.substring(7, 8)) * 5
		                            + Integer.parseInt(civilidPartial.substring(8, 9)) * 8
		                            + Integer.parseInt(civilidPartial.substring(9, 10)) * 4
		                            + Integer.parseInt(civilidPartial.substring(10, 11)) * 2;
		               
		               // -- Calculate Remainder by dividing 11
		               remainder = civilidCal % ELEVEN;
		        
		               // -- Get Check Digit by subtracting W_REM from 11
		               civilidCalChkDigit = ELEVEN - remainder;
		               
		               // -- Check digit can not be 0 or 10
		               if (civilidCalChkDigit == 0 || civilidCalChkDigit == 10) {
		                     validityStatus = "false";
		               } else {
		                     // -- Calculated and Actual Check Digit same OK
		                     if (civilidCalChkDigit == civilidLastDigit) {
		                             validityStatus = "true";
		                      } else {
		                             validityStatus = "false";
		                      }
		                }
	        	} catch(Exception e) {
	        		validityStatus = "false";
	        	}
	        }
			
	        if(validityStatus.equalsIgnoreCase("false")){
	        	setBooIdValidator(true);
	        } else {
	        	setBooIdValidator(false);
			
				SessionStateManage sessionStateManage = new SessionStateManage();
				BigDecimal language = new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1);
				
				if(getIdNumber().length() == 12){
					try {
						String id = getIdNumber();
						String dob = id.substring(5, 7) + "/" + id.substring(3, 5) + "/19" + id.substring(1, 3);
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date = formatter.parse(dob);
	
						setDob(date);
						
						Calendar cal = new GregorianCalendar();
						cal.setTime(new Date());
						cal.add(Calendar.DAY_OF_MONTH,+ 90);
						Date today90 = cal.getTime();
						
						SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
						String finalDate = form.format(today90);
	
						setExpDateCheck(finalDate);
						
						idForMap.put("1", "Address Proof");
						idForMap.put("2", "Identity Proof");
						
										
					} catch (Exception e) {
			
					}
	
					setCustomerId(new BigDecimal(0));
					boolean isCustomerIdExists = getCustomerIdProofDetail();
	
					//Get and set customer email if it is exist in CUSTOMER_LOGIN table
					setCustomerEmail();
					
					if (isCustomerIdExists) {
						
						getFetchIdType();
						//Get customer id proof detail
						setCustomerIdProofDataTable();
						
						//Get Customer Complete Detail
						getCustomerCompleteDetail();
					}
					
					// There is data in Database for that Civil Id
					if (lstFsCustIdProof !=null && lstFsCustIdProof.size() > 0) {
						getCountryNameList();
						setEmpInfoCountry(lstFsCustEmpInfo.get(0).getFsCountryMaster().getCountryId().toString());
						getStateFromDb();
						/*setEmpInfoState(lstFsCustEmpInfo.get(0).getStateId().toPlainString());
						getDistrictFromDbForShow();
						setEmpInfoDistrict(lstFsCustEmpInfo.get(0).getDistrictId().toPlainString());
						popCityForShow();
						setEmpInfoCity(lstFsCustEmpInfo.get(0).getCityId().toPlainString());
						getContactDbForShow();
						*/
						setNonMatchedMsg(false);
	
						addContactList.clear();
						AddContactDetailBean contact = new AddContactDetailBean();
						for (ContactDetail details : lstFsContactDetails) {
							try{
								
								List<CountryMasterDesc> countryDesc = getGeneralService().getCountryList(language); 
								for (CountryMasterDesc countryMasterDesc : countryDesc) {
									countryMap.put(countryMasterDesc.getFsCountryMaster().getCountryId().toPlainString(), countryMasterDesc.getCountryName());
								}
								
								List<StateMasterDesc> statemaster = getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId());
								for (StateMasterDesc stateMasterDesc : statemaster) {
									stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
								}
								
								List<DistrictMasterDesc> ditrsict = getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()); 
								for (DistrictMasterDesc districtMasterDesc : ditrsict) {
									districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
								}
								List<CityMasterDesc> ciy = getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), 
																								details.getFsDistrictMaster().getDistrictId()); 
								for (CityMasterDesc cityMasterDesc : ciy) {
									cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
								}
								
								 contact =  new AddContactDetailBean(
											details.getFsContactType().getContactType() ,
											details.getArea(),
											countryMap.get(details.getFsCountryMaster().getCountryId().toPlainString()) , 
											details.getStreet(), 
											details.getBlock(),details.getTelephone(),details.getFlat(),
											stateMap.get(details.getFsStateMaster().getStateId().toPlainString()),
											districtMap.get(details.getFsDistrictMaster().getDistrictId().toPlainString()),
											cityMap.get(details.getFsCityMaster().getCityId().toPlainString()),
													true,false,
													details.getFsContactType().getContactTypeId(),
													details.getFsCountryMaster().getCountryId(),
													details.getFsStateMaster().getStateId(),
													details.getFsDistrictMaster().getDistrictId(),
													details.getFsCityMaster().getCityId(),
													details.getContactDetailId());
											
									contact.setLstCountryList(getGeneralService().getCountryList(language));
									contact.setLstStateList(getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId()));
									contact.setLstDistrictList(getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()));
									contact.setLstCityList(getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), details.getFsDistrictMaster().getDistrictId()));
									addContactList.add(contact);
									setEnable(true);
							} catch(Exception e){
								
								 contact =  new AddContactDetailBean(
											details.getFsContactType().getContactType() ,
											details.getArea(),
											countryMap.get(details.getFsCountryMaster().getCountryId()) , 
											details.getStreet(), 
											details.getBlock(),details.getTelephone(),details.getFlat(),
											stateMap.get(details.getFsStateMaster().getStateId()),
											districtMap.get(details.getFsDistrictMaster().getDistrictId()),
											"",
													true,false,
													details.getFsContactType().getContactTypeId(),
													details.getFsCountryMaster().getCountryId(),
													details.getFsStateMaster().getStateId(),
													details.getFsDistrictMaster().getDistrictId(),
													new BigDecimal(1),
													details.getContactDetailId());
											
									contact.setLstCountryList(getGeneralService().getCountryList(language));
									contact.setLstStateList(getGeneralService().getStateList(language, details.getFsCountryMaster().getCountryId()));
									contact.setLstDistrictList(getGeneralService().getDistrictList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId()));
									contact.setLstCityList(getGeneralService().getCityList(language, details.getFsCountryMaster().getCountryId(), details.getFsStateMaster().getStateId(), details.getFsDistrictMaster().getDistrictId()));
									addContactList.add(contact);
									setEnable(true);
							}
								
						}
						
						if (lstFsContactDetails.size() > 0) {
							setBooContactDetails(false);
						} else {
							setBooContactDetails(true);
						}
	
						setShortName(lstFsCustomer.get(0).getShortName());
						setShortNamel(lstFsCustomer.get(0).getShortNameLocal());
						setAMLStatus(lstFsCustomer.get(0).getAmlStatus());
						
						if (lstFsCustomer.get(0).getActivatedInd()!=null && lstFsCustomer.get(0).getActivatedInd().equalsIgnoreCase("1")) {
							setApproved(true);
						} else {
							setApproved(false);
						}
	
						setRemName(lstFsCustomer.get(0).getFirstName());
						setToken(lstFsCustomer.get(0).getTokenKey());
						setLastName(lstFsCustomer.get(0).getLastName());
						setMiddleName(lstFsCustomer.get(0).getMiddleName());
						setFirstNamel(lstFsCustomer.get(0).getFirstNameLocal());
						setMiddleNamel(lstFsCustomer.get(0).getMiddleNameLocal());
						setLastNamel(lstFsCustomer.get(0).getLastNameLocal());
						setTitle(lstFsCustomer.get(0).getTitle());
						setTitlel(lstFsCustomer.get(0).getTitleLocal());
						setGender(lstFsCustomer.get(0).getGender());
						
						Calendar cal = new GregorianCalendar();
						cal.setTime(new Date());
						cal.add(Calendar.DAY_OF_MONTH,- 6480);
						Date today90 = cal.getTime();
						
						SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
						String finalDate = form.format(today90);
						
						setMinDob(finalDate);
						
						setDob(lstFsCustomer.get(0).getDateOfBirth());
						setNationality(lstFsCustomer.get(0).getFsCountryMasterByNationality().getCountryId().toPlainString());
						setAlternativeEmail(lstFsCustomer.get(0).getAlterEmailId());
						setMobile(lstFsCustomer.get(0).getMobile());
						
						
						setEmail(lstFsCustomer.get(0).getEmail());
						if(lstFsCustEmpInfo.size() > 0){
							setEmploymentType(lstFsCustEmpInfo.get(0).getFsEmploymentType().getEmploymentTypeId().toPlainString());
							
							if(getEmploymentType().equalsIgnoreCase("3") || getEmploymentType().equalsIgnoreCase("0")){
								setBooUnEmp(false);
							} else{
								setBooUnEmp(true);
							}
							setOccupation(lstFsCustEmpInfo.get(0).getOccupation());
							setEmployer(lstFsCustEmpInfo.get(0).getEmployerName());
							setEmpInfoBlock(lstFsCustEmpInfo.get(0).getBlock());
							setEmpInfoStreet(lstFsCustEmpInfo.get(0).getStreet());
							setArea(lstFsCustEmpInfo.get(0).getArea());
							setPostal_code(lstFsCustEmpInfo.get(0).getPostal());
							
							
							//setId_number(getIdNumber());
							
							setStateEmployment(lstFsCustEmpInfo.get(0).getFsEmploymentType().getEmploymentType());
							
							setOffice_tel(lstFsCustEmpInfo.get(0).getOfficeTelephone());
						}
						
						setExpDate(lstFsCustIdProof.get(0).getIdentityEndDate());
						//setIdNumber("");
						//setIdType("");
						setBooSave(false); //Means need to update depending upon Civil ID, not save
						setBooValidateBtn(false);
						setBooTable(true);
						setBooCommon(true);
						
						setBooPass(true);
					}
				} else {
					setBooSave(true); //need to save
					setBooCommon(true);
					setBooPass(false);
					setBooValidateBtn(true);
					setBooTable(false);
					setReadonly(false);
					if(addContactList!=null){addContactList.clear();}
					if(createProofList!=null){createProofList.clear();}
					setShortName(null);
					setShortNamel(null);
					setAMLStatus(null);
					setRemName(null);
					setLastName(null);
					setMiddleName(null);
					setFirstNamel(null);
					setMiddleNamel(null);
					setLastNamel(null);
					setTitle(null);
					setTitlel(null);
					setGender(null);
					setDob(null);
					setNationality(null);
					setAlternativeEmail(null);
					setMobile(null);
					setEmploymentType(null);
					setOccupation(null);
					setEmployer(null);
					setBlockNo(null);
					setStreetNo(null);
					setArea(null);
					setPostal_code(null);
//					getStateFromDb();
					setStateEmployment(null);
					popCityForShow(null);
					setCity(null);
					setOffice_tel(null);
					setExpDate(null);
					setNonMatchedMsg(true);
				}
			}
		}
		
		System.out.println("ID Type : "+getIdType());
	}

	private void popCityForShow() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<CityMasterDesc> lstCity = getGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry()),
				new BigDecimal(getEmpInfoState().equals("")?"-1":getEmpInfoState()),
				new BigDecimal(getEmpInfoDistrict().equals("")?"-1":getEmpInfoDistrict())
				); 
		
		for (CityMasterDesc cityMasterDesc : lstCity) {
			cityMap.put(cityMasterDesc.getFsCityMaster().getCityId().toPlainString(), cityMasterDesc.getCityName());
		}
		
		setLstEmpInfoCityList(lstCity);
	}

	private void getDistrictFromDbForShow() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<DistrictMasterDesc> lstDistrict = getGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry()),
				new BigDecimal(getEmpInfoState().equals("")?"-1":getEmpInfoState())
				); 
		
		for (DistrictMasterDesc districtMasterDesc : lstDistrict) {
			districtMap.put(districtMasterDesc.getFsDistrictMaster().getDistrictId().toPlainString(), districtMasterDesc.getDistrict());
		}
		
		setLstEmpInfoDistrictList(lstDistrict);
	}

	// method to check the aml status
	private void getStateFromDb() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		List<StateMasterDesc> lstStateMasterDesc = getGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
				new BigDecimal(getEmpInfoCountry().equals("")?"-1":getEmpInfoCountry())); 
		
		for (StateMasterDesc stateMasterDesc : lstStateMasterDesc) {
			stateMap.put(stateMasterDesc.getFsStateMaster().getStateId().toPlainString(), stateMasterDesc.getStateName());
		}
				
		setLstEmpInfoStateList(lstStateMasterDesc);
	}

	public void checkData() {
		try {
			List<Amlstatus> data = getAMLStatus(getRemName());
			
			if (data.get(0).getRemStatus().equalsIgnoreCase("Pass")) {
				setAMLStatus("Pass");
				setBooPend(false);
				setBooFailed(false);
				setBooCommon(true);
				setBooPass(true);
				setReadonly(true);
			} else if (data.get(0).getRemStatus().equalsIgnoreCase("Pendding")) {
				setAMLStatus("Pendding");
				setBooCommon(false);
				setBooPass(false);
				setBooPend(true);
				setBooFailed(false);
				setBooTable(false);
				setReadonly(false);
			} else {
				setAMLStatus("Fail");
				setBooCommon(false);
				setBooPass(false);
				setBooPend(false);
				setBooFailed(true);
				setReadonly(false);
			}
		} catch (NullPointerException npex) {
		} catch (HibernateException hbex) {
			hbex.printStackTrace();
		} catch (Exception e){
		}
	}

	public List<Amlstatus> getAMLStatus(String name) {
		amlList = new ArrayList<Amlstatus>();
		amlList.addAll(getBranchpageService().getAmlStatus(name));
		return amlList;
	}

	public String addAdditional() {
		setBoolAdditional(true);
		setBooCommon(true);
		setBooPass(true);
		setBooPend(false);
		setBooFailed(false);

		return "";
	}

	public String cancelAdditional() {
		setBooCommon(false);
		setBooPass(false);
		setBooPend(false);
		setBooFailed(true);
		return "";
	}

	public String cancel() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "cancel";
	}
	
	public String back() {
		return "back";
	}

	public String next() {
		if(addContactList.size() == 0){
			setBooContactDetailsSize(true);
			return "";
		} else {
			setBooContactDetailsSize(false); 
			return "next";
		}
	}

	public List<CreateProofTable> getCreateProofList() {
		return createProofList;
	}

	public void addRows() {
		if(this.idFor == null || this.idFor.equalsIgnoreCase("")){
			setBooIdFor(true);
			setBooIdType(false);
			setBooIdNo(false);
			setBooIdTExpDate(false);
			FacesContext.getCurrentInstance().addMessage("IdFor", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose ID For !!!!!! "));
		} else if (this.idTypeproof == null || this.idTypeproof.equalsIgnoreCase("")) {
			setBooIdType(true);
			setBooIdFor(false);
			setBooIdNo(false);
			setBooIdTExpDate(false);
			FacesContext.getCurrentInstance().addMessage("idTypeproof", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Choose a ID Type !!!!!! "));
		}  else if (viewBehaviorBean("Id Number","REQUIRED").equalsIgnoreCase("true") && 		(this.idnumberProof == null || this.idnumberProof.equalsIgnoreCase(""))) {
			setBooIdType(false);
			setBooIdNo(true);
			setBooIdTExpDate(false);
			setBooIdFor(false);
			FacesContext.getCurrentInstance().addMessage("idNumber", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Give a ID Number !!!!!! "));
		} else if(viewBehaviorBean("Id Number","REQUIRED").equalsIgnoreCase("true") && (this.dateExp == null)){
			setBooIdType(false);
			setBooIdNo(false);
			setBooIdTExpDate(true);
			setBooIdFor(false);
			FacesContext.getCurrentInstance().addMessage("expDate", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Give a Expiary Date !!!!!! "));
		} else {
			String fileName = getFile().getFileName();
			if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
								fileName.contains(".png") || fileName.contains(".pdf")) {
				
				setBooIdType(false);
				setBooIdNo(false);
				setBooIdTExpDate(false);
				setBooIdFor(false);
				
				setBooProfListDuplicate(false);
				
				for (CreateProofTable element : createProofList) {
					
					if(this.idFor.equalsIgnoreCase(element.getId_for())
							&& this.idTypeproof.equalsIgnoreCase(element.getId_type())
							&& this.idnumberProof.equalsIgnoreCase(element.getId_number())	) {
						
							setBooProfListDuplicate(true);
							break;
					}	
				}
				
				if(!getBooProfListDuplicate()){
					try {
						Blob blob = storeImage();
						int blobLength = (int) blob.length();  
						byte[] blobAsBytes = blob.getBytes(1, blobLength);
						InputStream stream=new ByteArrayInputStream(blobAsBytes);
				        downloadFile = new DefaultStreamedContent(stream, "image/jpg", "image.jpg");
				        
						//Save Image
						DocumentImg document = new DocumentImg();
						try {
							document.setImage(storeImage());
						} catch (SerialException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						document.setUploadDate(new Date());
						document.setImageName(getFile().getFileName());
						
						getBranchpageService().saveImage(document);
						image_id = document.getImgId(); 
						setImage_id(image_id);
				     			        
						SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
						String df = dateformat.format(this.dateExp);
						CreateProofTable createProofTable = new CreateProofTable(this.idFor, this.idTypeproof, this.idnumberProof, df, "insert", 0, 
																			idForMap.get(this.idFor), idTypeMap.get(this.idType), image_id);
						createProofList.add(createProofTable);

						setEnablePTbl(true);
						
						//setExpDate(null);
						setDateExp(null);
						setIdTypeproof("");
						setIdnumberProof("");
						setIdFor("");
					} catch (Exception e) {

					}
				} else {
					setBooProfListDuplicate(true);
					FacesContext.getCurrentInstance().addMessage("Message", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Duplicate ID Proof !!!!!! "));
				}

				setBooBrowsedFile(false);
			} else {
				setBooIdType(false);
				setBooIdNo(false);
				setBooIdTExpDate(false);
				setBooBrowsedFile(true);
			}
		}
	}

	public void onCancel(CreateProofTable obj) {
		createProofList.remove(obj);
	}

	public List<CustomerIdProof> getProofDataList(String id) {
		lstProofData = new ArrayList<CustomerIdProof>();
		lstProofData.addAll(getBranchpageService().popUploadedData(id));

		/*for (CustomerIdProof proof : lstProofData) {
			
		}*/

		return lstProofData;
	}



	/*@SuppressWarnings("unchecked")
	public List<StateMaster> getStateFromDb() {

		lstState = new ArrayList<StateMaster>();
		lstState.addAll(getBranchpageService().getState());
		return lstState;
	}*/

	public void popCity(AjaxBehaviorEvent e) {
		lstCity = new ArrayList<CityMaster>();
		lstCity.addAll(getBranchpageService().getCity(new BigDecimal(getStateEmployment())));
	}

	public void popCityForShow(String stateCode) {
		if(stateCode!=null){
			lstCity = new ArrayList<CityMaster>();
			lstCity.addAll(getBranchpageService().getCity(new BigDecimal(stateCode)));
		}
	}

	public List<CityMaster> getCityFromDb() {
		return lstCity;
	}

	public String save() throws IOException, ParseException {

		System.out.println("Save");
		
		String username = "tanumoy";
		String company = "1";
		String country = "120";
		
		Date currentDate = new Date();
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		if(sessionStateManage.isExists("userName")){
			username = sessionStateManage.getSessionValue("userName");
		}
		
		if(sessionStateManage.isExists("companyId")){
			company = sessionStateManage.getSessionValue("companyId");
		}
		
		if(sessionStateManage.isExists("countryId")){
			country = sessionStateManage.getSessionValue("countryId");
		}
		
		Customer customer = new Customer();
		
		CountryMaster countryMaster = new CountryMaster();
		countryMaster.setCountryId(new BigDecimal(country));
		customer.setFsCountryMasterByCountryId(countryMaster);
		
		CompanyMaster companyMaster = new CompanyMaster();
		companyMaster.setCompanyId(new BigDecimal(company));
		customer.setFsCompanyMaster(companyMaster);
		
		int languageID = 1;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")){
			languageID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().equalsIgnoreCase("ar")?2:1;
		}
		
		LanguageType languageType = new LanguageType();
		languageType.setLanguageId(new BigDecimal(languageID));
		customer.setFsLanguageType(languageType);
		
		customer.setShortName(getShortName());
		customer.setShortNameLocal(getShortNamel());
		customer.setAmlStatus(getAMLStatus());
		customer.setTitle(getTitle());
		customer.setFirstName(getRemName());
		customer.setMiddleName(getMiddleName());
		customer.setLastName(getLastName());
		customer.setTitleLocal(getTitlel());
		customer.setFirstNameLocal(getFirstNamel());
		customer.setMiddleNameLocal(getMiddleNamel());
		customer.setLastNameLocal(getLastNamel());
		customer.setGender(getGender());
		customer.setDateOfBirth(getDob());
		customer.setFsCountryMasterByNationality(countryMaster);
		customer.setAlterEmailId(getAlternativeEmail());
		customer.setMobile(getMobile());
		customer.setEmail(getEmail());
		customer.setCreatedBy(username);
		customer.setCreationDate(currentDate);
		if(getApproved()){
			customer.setActivatedInd("1");
			customer.setActivatedDate(new Date());
			customer.setVerificationBy(username);
			customer.setVerificationDate(new Date());
		} else {
			customer.setActivatedInd("0");
			customer.setInactivatedDate(new Date());
		}
		
		if (boolAdditional) {
			customer.setPlaceOfBirth(getBirthPlace());
			customer.setFatherName(getFatherName());
			customer.setCountryOfBirth(getCountryOfBirth());
		}
		
		if (!getBooSave()) {
			customer.setCustomerId(customerId);
			getBranchpageService().saveCustomer(customer, getCustomerId());
		} else {
			customer.setAmlStatus(getAMLStatus());
			getBranchpageService().saveCustomer(customer, new BigDecimal(0));
			setCustomerId(customer.getCustomerId());
		}
	
		/**
		 * Save in CustomerEmployment Table
		 */
		CustomerEmploymentInfo custEmp = new CustomerEmploymentInfo();

		EmploymentType employmentType = new EmploymentType();
		employmentType.setEmploymentTypeId(new BigDecimal(getEmploymentType()));
		//TODO hardCoded
		//employmentType.setEmploymentTypeId(getEmploymentType().equals("") ? null : new BigDecimal(getEmploymentType()));
		
		custEmp.setFsCustomer(customer);
		custEmp.setFsLanguageType(languageType);
		custEmp.setFsCompanyMaster(companyMaster);
		custEmp.setFsCountryMaster(countryMaster);
		custEmp.setOccupation(getOccupation());
		custEmp.setEmployerName(getEmployer());
		custEmp.setFsEmploymentType(employmentType);
		custEmp.setDepartment(getEmpcategory());
		/*custEmp.setStateId(new BigDecimal(getEmpInfoState()));
		custEmp.setDistrictId(getEmpInfoDistrict().equals("") ? null : new BigDecimal(getEmpInfoDistrict()));
		custEmp.setCityId(new BigDecimal(getEmpInfoCity()));*/
		custEmp.setArea(getArea());
		custEmp.setBlock(getEmpInfoBlock());
		custEmp.setStreet(getEmpInfoStreet().toString());
		custEmp.setOfficeTelephone(getOffice_tel());
		custEmp.setPostal(getPostal_code());
		custEmp.setCreatedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
		custEmp.setCreationDate(new Date());

		if (!getBooSave()) {
			getBranchpageService().saveCustomerEmploymentInfo(custEmp, getCustomerId());
		} else {
			getBranchpageService().saveCustomerEmploymentInfo(custEmp, new BigDecimal(0));
		}
		
		/**
		 * Save in Contact Details
		 */
		
		CountryMaster countMaster = new CountryMaster();
		StateMaster stateMaster = new StateMaster();
		DistrictMaster districtmaster = new DistrictMaster();
		CityMaster cistyMaster = new CityMaster(); 
		ContactType contactType =new ContactType();
		
		for (AddContactDetailBean details : addContactList) {
			
			countMaster.setCountryId(details.getCountryId());
			
			if(details.getStateId() == null) {
				stateMaster.setStateId(details.getStateId());
			}else{
				stateMaster.setStateId(new BigDecimal(1));
			}
			
			if(details.getDistrictId() == null){
				districtmaster.setDistrictId(new BigDecimal(1));
			} else {
				districtmaster.setDistrictId(details.getDistrictId());
			}
			
			contactType.setContactTypeId(details.getContactTypeId());
			
			try{
				cistyMaster.setCityId(details.getCityId());
			} catch(Exception e){
				cistyMaster.setCityId(new BigDecimal(1));
			}
			
			ContactDetail adContact = new ContactDetail();
			adContact.setFsContactType(contactType);
			adContact.setFsCustomer(customer);
			adContact.setFsCountryMaster(countryMaster);
			adContact.setFsLanguageType(languageType);
			adContact.setFsStateMaster(stateMaster);
			adContact.setFsDistrictMaster(districtmaster);
			adContact.setFsCityMaster(cistyMaster); 
			/*if(details.getCityId()!=null){
				cistyMaster.setCityId(details.getCityId());
				adContact.setFsCityMaster(cistyMaster);
			}*/
			adContact.setArea(details.getArea());
			adContact.setBlock(details.getBlock());
			adContact.setFlat(details.getFlat());
			adContact.setStreet(details.getStreet());
			adContact.setTelephone(details.getTel());
			
			adContact.setCreatedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
			adContact.setCreationDate(new Date());
			adContact.setActiveStatus("1");
			
			//isModify false is setting from addAction, nd true is setting from view(loading time of page, to fetch earlier record)
			if (details.isModified() == false) {
				getBranchpageService().addContactDetails(adContact, new BigDecimal(0));
			} else {
				getBranchpageService().addContactDetails(adContact, details.getContactDetailsId());
			}
		}
		
		
		for (AddContactDetailBean details : addContactListDeleted) {
			
			countMaster.setCountryId(details.getCountryId());
			
			if(details.getStateId() == null) {
				stateMaster.setStateId(details.getStateId());
			}else{
				stateMaster.setStateId(new BigDecimal(1));
			}
			
			if(details.getDistrictId() == null){
				districtmaster.setDistrictId(new BigDecimal(1));
			} else {
				districtmaster.setDistrictId(details.getDistrictId());
			}
			
			contactType.setContactTypeId(details.getContactTypeId());
			
			try{
				cistyMaster.setCityId(details.getCityId());
			} catch(Exception e){
				cistyMaster.setCityId(new BigDecimal(1));
			}
			
			ContactDetail adContact = new ContactDetail();
			adContact.setFsContactType(contactType);
			adContact.setFsCustomer(customer);
			adContact.setFsCountryMaster(countryMaster);
			adContact.setFsLanguageType(languageType);
			adContact.setFsStateMaster(stateMaster);
			adContact.setFsDistrictMaster(districtmaster);
			adContact.setFsCityMaster(cistyMaster); 
			/*if(details.getCityId()!=null){
				cistyMaster.setCityId(details.getCityId());
				adContact.setFsCityMaster(cistyMaster);
			}*/
			adContact.setArea(details.getArea());
			adContact.setBlock(details.getBlock());
			adContact.setFlat(details.getFlat());
			adContact.setStreet(details.getStreet());
			adContact.setTelephone(details.getTel());
			
			adContact.setCreatedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
			adContact.setCreationDate(new Date());
			adContact.setActiveStatus("0");
			
			//isModify false is setting from addAction, nd true is setting from view(loading time of page, to fetch earlier record)
			if (details.isModified() == false) {
				getBranchpageService().addContactDetails(adContact, new BigDecimal(0));
			} else {
				getBranchpageService().addContactDetails(adContact,details.getContactDetailsId());
			}
		}
		
		/**
		 * Customer ID proof
		 */
		CustomerType customerType = new CustomerType();
		customerType.setCustomerTypeId(new BigDecimal("1"));
		
		IdentityType idType =new IdentityType();
		
		for (CreateProofTable createProofTable : createProofList){
			CustomerIdProof custProof = new CustomerIdProof();
			custProof.setFsCustomer(customer);
			custProof.setFsLanguageType(languageType);
			custProof.setFsCustomerType(customerType);
			idType.setIdentityTypeId(new BigDecimal(createProofTable.getId_type()));
			custProof.setFsIdentityType(idType);
			
			DocumentImg imgDoc = new DocumentImg();
			imgDoc.setImgId(createProofTable.getImageId());
			custProof.setFsDocumentImg(imgDoc);
			
			custProof.setIdentityFor(createProofTable.getId_for());
			custProof.setIdentityInt(createProofTable.getId_number());
			custProof.setIdentityStatus("1");
			
			if (createProofTable.getChecked()) {
				custProof.setApprovedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
				custProof.setApprovedDate(new Date());
			} else {
				custProof.setApprovedBy("0");
				custProof.setApprovedDate(new Date());
			}

			Date expDate = new SimpleDateFormat("dd/MM/yyyy").parse(createProofTable.getDate_expiary());

			custProof.setIdentityExpiryDate(expDate);
			custProof.setCreatedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
			custProof.setCreationDate(new Date());

			if (createProofTable.getSaveOrUpdate().equalsIgnoreCase("insert")) {
				getBranchpageService().saveCustomerEmploymentProofInfo(custProof, new BigDecimal("0"));
			} else {
				getBranchpageService().saveCustomerEmploymentProofInfo(custProof, new BigDecimal(createProofTable.getPk()));
			}
		}
		
		for (CreateProofTable createProofTable : createProofListDelete){
			
			
			CustomerIdProof custProof = new CustomerIdProof();
			custProof.setFsCustomer(customer);
			custProof.setFsLanguageType(languageType);
			custProof.setFsCustomerType(customerType);
			idType.setIdentityTypeId(new BigDecimal(createProofTable.getId_type()));
			custProof.setFsIdentityType(idType);
			
			custProof.setIdentityFor(createProofTable.getId_for());
			custProof.setIdentityInt(createProofTable.getId_number());
			custProof.setIdentityStatus("0");
			
			if (createProofTable.getChecked()) {
				custProof.setApprovedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
				custProof.setApprovedDate(new Date());
			} else {
				custProof.setApprovedBy("0");
				custProof.setApprovedDate(new Date());
			}

			Date expDate = new SimpleDateFormat("dd/MM/yyyy").parse(createProofTable.getDate_expiary());

			custProof.setIdentityExpiryDate(expDate);
			custProof.setCreatedBy(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
			custProof.setCreationDate(new Date());

			if (createProofTable.getSaveOrUpdate().equalsIgnoreCase("insert")) {
				getBranchpageService().saveCustomerEmploymentProofInfo(custProof, new BigDecimal("0"));
			} else {
				getBranchpageService().saveCustomerEmploymentProofInfo(custProof, new BigDecimal(createProofTable.getPk()));
			}
		}
		

		if(getApproved()){
			return "success";
		} else {
			return "pending";
		}
	}
	
	public StreamedContent downloadFile(BigDecimal imageId) {
	
		   
		   StreamedContent image = null;
		   try{
			  
			   image = getImage(imageId); 
		   } catch(Exception e){
			   e.printStackTrace();
		   }
		   return image;
		}
	   
	public StreamedContent getImage(BigDecimal imageId){
		try{
			if (imageId.toPlainString().length() > 0 && imageId!=null) {
				Blob blob = getBranchpageService().getImage(imageId).get(0).getImage();
				String imageNameWithExtention=getBranchpageService().getImage(imageId).get(0).getImageName();
				String imageExtention=imageNameWithExtention.substring(imageNameWithExtention.lastIndexOf("."));
				String imagename=imageNameWithExtention.substring(0,imageNameWithExtention.lastIndexOf(".")-1);
		//		System.out.println("imageExtention  :"+imageExtention+"image name :"+imagename);
				int blobLength = (int) blob.length();
				byte[] blobAsBytes = blob.getBytes(1, blobLength);
				InputStream stream = new ByteArrayInputStream(blobAsBytes);
				downloadFile = new DefaultStreamedContent(stream, "image/jpg", imagename  + imageExtention);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	return downloadFile;
   }

	public String getEmpInfoBlock() {
		return empInfoBlock;
	}

	public void setEmpInfoBlock(String empInfoBlock) {
		this.empInfoBlock = empInfoBlock;
	}

	public String getEmpInfoStreet() {
		return empInfoStreet;
	}

	public void setEmpInfoStreet(String empInfoStreet) {
		this.empInfoStreet = empInfoStreet;
	}

	public Map<String, String> getStateMap() {
		return stateMap;
	}

	public void setStateMap(Map<String, String> stateMap) {
		this.stateMap = stateMap;
	}

	public Map<String, String> getDistrictMap() {
		return districtMap;
	}

	public void setDistrictMap(Map<String, String> districtMap) {
		this.districtMap = districtMap;
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = cityMap;
	}

	public Map<String,String> getCountryMap() {
		return countryMap;
	}

	public void setCountryMap(Map<String,String> countryMap) {
		this.countryMap = countryMap;
	}

	public Map<String,String> getIdTypeMap() {
		return idTypeMap;
	}

	public void setIdTypeMap(Map<String,String> idTypeMap) {
		this.idTypeMap = idTypeMap;
	}

	public String getExpDateCheck() {
		return expDateCheck;
	}

	public void setExpDateCheck(String expDateCheck) {
		this.expDateCheck = expDateCheck;
	}

	public Map<String,String> getConTypeMap() {
		return conTypeMap;
	}

	public void setConTypeMap(Map<String,String> conTypeMap) {
		this.conTypeMap = conTypeMap;
	}

	public Map<String,String> getIdForMap() {
		return idForMap;
	}

	public void setIdForMap(Map<String,String> idForMap) {
		this.idForMap = idForMap;
	}
	
	public Boolean getBooContactType() {
		return booContactType;
	}

	public void setBooContactType(Boolean booContactType) {
		this.booContactType = booContactType;
	}

	public Boolean getBooLocalArea() {
		return booLocalArea;
	}

	public void setBooLocalArea(Boolean booLocalArea) {
		this.booLocalArea = booLocalArea;
	}
	
	public Boolean getBooUnEmp() {
		return booUnEmp;
	}

	public void setBooUnEmp(Boolean booUnEmp) {
		this.booUnEmp = booUnEmp;
	}

	public List<CityMasterDesc> getContactCityList() {
		return contactCityList;
	}

	public void setContactCityList(List<CityMasterDesc> contactCityList) {
		this.contactCityList = contactCityList;
	}

	public Boolean getBooContactCity() {
		return booContactCity;
	}

	public void setBooContactCity(Boolean booContactCity) {
		this.booContactCity = booContactCity;
	}

	public List<CreateProofTable> getCreateProofListDelete() {
		return createProofListDelete;
	}

	public void setCreateProofListDelete(List<CreateProofTable> createProofListDelete) {
		this.createProofListDelete = createProofListDelete;
	}

	public Map<String, StreamedContent> getImageMap() {
		return imageMap;
	}

	public void setImageMap(Map<String, StreamedContent> imageMap) {
		this.imageMap = imageMap;
	}

	public String getMinDob() {
		return minDob;
	}

	public void setMinDob(String minDob) {
		this.minDob = minDob;
	}

	public String getIdnumberProof() {
		return idnumberProof;
	}

	public void setIdnumberProof(String idnumberProof) {
		this.idnumberProof = idnumberProof;
	}

	public Boolean getBooIdValidator() {
		return booIdValidator;
	}

	public void setBooIdValidator(Boolean booIdValidator) {
		this.booIdValidator = booIdValidator;
	}

	public String getIdTypeBranchPage() {
		return idTypeBranchPage;
	}

	public void setIdTypeBranchPage(String idTypeBranchPage) {
		this.idTypeBranchPage = idTypeBranchPage;
	}

	public Boolean getBooContactContactType() {
		return booContactContactType;
	}

	public void setBooContactContactType(Boolean booContactContactType) {
		System.out.println("Setting : "+booContactContactType);
		this.booContactContactType = booContactContactType;
	}
	
	//Rule Engine Implementation
		public String viewBehaviorBean(String componentName, String type){
			
			if(mapComponentBehavior==null || mapComponentBehavior.size()==0){
				setPageIdIntoSession();
				prepareBehavior();
			}
			return new CollectionUtil().fetchBehavior(mapComponentBehavior, componentName, type);
		}
		
		private void setPageIdIntoSession(){
		
			String pageName = FacesContext.getCurrentInstance().getViewRoot().getViewId();
			pageName = pageName.substring(pageName.lastIndexOf('/')+1, pageName.indexOf(".xhtml"));
			
			try{
				BigDecimal pageId = getGeneralService().getPageId(pageName);
				new SessionStateManage().setSessionValue("pageId", pageId.toString());
			}catch(Exception e){
				System.out.println("Page id not found for pagename :: "+pageName+" :: "+e);
			}
		}
		
		private void prepareBehavior(){
			
			SessionStateManage manage = new SessionStateManage(); 
			List<String> lstComponentName = Arrays.asList("Civil ID", "First Name", "Middle Name",
					"Last Name", "Short Name", "Local First Name", "Local Middle name",
					"Local Last Name", "Local Short Name", "Mobile in online reg", "Email","Alternate Email Id",
					"DOB", "Block online rem", 
					"Employer Name", "Street online rem", "area online rem", 
					"officetel online rem", "postal online rem", "First Name", "Last Name",
					"Civil Id Expiary Date", "State", "District", "City",
					"Local Area", "Street", "Telephone Number", "Flat", "Block online rem", "Country", "Contact Type", "Id Number");
			
			mapComponentBehavior =  getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
		}

		public Boolean getBooIdFor() {
			return booIdFor;
		}

		public void setBooIdFor(Boolean booIdFor) {
			this.booIdFor = booIdFor;
		}

		public String getIdTypeproof() {
			return idTypeproof;
		}

		public void setIdTypeproof(String idTypeproof) {
			this.idTypeproof = idTypeproof;
		}

		public String getHidden1() {
			return hidden1;
		}

		public void setHidden1(String hidden1) {
			this.hidden1 = hidden1;
		}

		public Boolean getBooContactDetailsSize() {
			return booContactDetailsSize;
		}

		public void setBooContactDetailsSize(Boolean booContactDetailsSize) {
			this.booContactDetailsSize = booContactDetailsSize;
		}
}