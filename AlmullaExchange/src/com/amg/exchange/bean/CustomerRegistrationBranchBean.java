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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.ArticleDetails;
import com.amg.exchange.model.ArticleMaster;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CityMasterDesc;
import com.amg.exchange.model.CompanyGroup;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.ContactType;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerType;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DistrictMasterDesc;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.EmploymentType;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.LanguageType;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.model.StateMasterDesc;
import com.amg.exchange.service.IBranchPageService;
import com.amg.exchange.service.ICorporateRegService;
import com.amg.exchange.service.ICustomerRegistrationBranchService;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;
		
		@Component(value = "branchRegistration")
		@Scope("session")
		public class CustomerRegistrationBranchBean<T> implements Serializable {
			Logger log = Logger.getLogger(CustomerRegistrationBranchBean.class);
		
			private static final long serialVersionUID = 1L;
		
			public BigDecimal pkCustomerId = null;
			public String expDateCheck = null;
			private String idType = null;
			private String selectType = null;
			private String manual = null;
			private String smartCard = null;
		
			// this is used for Remitter Information
			private String idNumber = null;
			private String title = null;
			private String token = null;
			private String firstName = null;
			private String lastName = null;
			private String middleName = null;
			private String shortName = null;
			private String titlel = null;
			private String firstNamel = null;
			private String lastNamel = null;
			private String middleNamel = null;
			private String shortNamel = null;
			private BigDecimal nationality = null;
			private String gender = null;
			private String mobile = null;
			private String email = null;
			private String alternativeEmail = null;
			private String AMLStatus = null;
			private String numberofhits = null;
		
			// This is used for Contact Details Panel
			public BigDecimal pkCustomerContactDetails = null;
			private BigDecimal contactTypeId = null;
			private String localArea = null;
			private BigDecimal countryId = null;
			private String street = null;
			private String block = null;
			private String telephone = null;
			private String area = null;
			private BigDecimal cityId = null;
			private String flat = null;
			private String countryOfBirth = null;
			private String birthPlace = null;
			private String fatherName = null;
		
			public BigDecimal pkCustomerEmployeeId = null;
			private String occupation = null;
			private String employer = null;
			private BigDecimal employmentType = null;
			private String empcategory = null;
			private String originId = null;
			private BigDecimal stateId = null;
			private String stateEmployment = null;
			private String postalCode = null;
			private String officeTel = null;
			private BigDecimal districtId = null;
			private String statusMessage = null;
			private String introduceBy = null;
			private String insurance = null;
			private String rel = null;
			private String dataTableContactTypeValue = null;
			private String idnumberProof = null;
			private String department = null;
		
			private BigDecimal empCountryId = null;
			private BigDecimal empStateId = null;
			private BigDecimal empDistrictId = null;
			private String empInfoBlock = null;
			private String empInfoStreet = null;
			private String emparea = null;
			private BigDecimal empCityId = null;
			private BigDecimal empInfoEmploymentTypeId = null;
			private BigDecimal languageId;
		
			public BigDecimal pkCustomerIdProof = null;
			private String idTypeproof = null;
			private String idFor = null;
			private Date expDate = null;
			private Date dateExp = null;
			private Date dob = null;
			private String minDob;
		
			private Map<String, String> idTypeMap = new HashMap<String, String>();
			private List<IdentityType> identityTypeList = new ArrayList<IdentityType>();
			private List<ContactType> contactTypeList = new ArrayList<ContactType>();
			private List<AddContactDetailBean> contactList = new ArrayList<AddContactDetailBean>();
			private List<AddContactDetailBean> contactListDelete = new ArrayList<AddContactDetailBean>();
			private List<CreateProofTable> createProofList = new ArrayList<CreateProofTable>();
			private List<CreateProofTable> createProofListDelete = new ArrayList<CreateProofTable>();
			private List<CustomerIdProof> customerIdProofList = new ArrayList<CustomerIdProof>();
			private List<CustomerEmploymentInfo> customerEmploymentInfoList = new ArrayList<CustomerEmploymentInfo>();
			private List<Customer> customerList = new ArrayList<Customer>();
			private List<ContactDetail> contactDetailList = new ArrayList<ContactDetail>();
			private List<CountryMasterDesc> countryList;
			private List<StateMasterDesc> lstState;
			private List<CityMasterDesc> lstCity;
			private List<DistrictMasterDesc> lstDistrict;
			private SessionStateManage sessionStateManage = null;
		
			/* Responsible to populate State,District, City in emp Details */
			private List<StateMasterDesc> lstEmpStateList = new ArrayList<StateMasterDesc>();
			private List<DistrictMasterDesc> lstEmpDistrictList = new ArrayList<DistrictMasterDesc>();
			private List<CityMasterDesc> lstEmpCityList = new ArrayList<CityMasterDesc>();
		
			Map<BigDecimal, String> mapContactTypeList = new HashMap<BigDecimal, String>();
			Map<BigDecimal, String> mapCountryList = new HashMap<BigDecimal, String>();
			Map<BigDecimal, String> mapStateList = new HashMap<BigDecimal, String>();
			Map<BigDecimal, String> mapDistirictList = new HashMap<BigDecimal, String>();
			Map<BigDecimal, String> mapCityList = new HashMap<BigDecimal, String>();
			private Map<String, String> idForMap = new HashMap<String, String>();
			Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String, BussComponentConfDetail>();
		
			private Boolean booManual = true;
			private Boolean booSmartcard = false;
			private Boolean booIdDetail = true;
			private Boolean booCustomerDetails = false; // this is rendered for if select smart card
			private Boolean booRemitterInfo = false;  // this is rendered for if select manual
			private Boolean booContactDetails = false;  // this is rendered for Contact Detail panel
			private Boolean booEmploymentDetails = false; // this is rendered for Employment Detail panel
			private Boolean booProof = false; // this is rendered for Proof Detail panel
			private boolean contactDataTable = false; // this is rendered for Contact Detail Datatable
			private boolean idListcheck = false; // this is for atleast add one proof details message
			private boolean booidproofDatatable = false; //// this is rendered for proof Detail Datatable
			
			// this is for Nominee
			private boolean boonomeneeCheck = false;
			private BigDecimal nomineeId = null;
			private boolean nomineeApprove;
		
			private Boolean booProfListDuplicate = false;
			private Boolean booIdTypeCheck = false;
		
			private Boolean booUnEmp = false;
			private Boolean enablePTbl;
			private boolean approved;
			private Boolean boolAdditional = false;
			private Boolean contactlistcheck = false;// this is for atleast add one contact details message
			private Boolean prooflistcheck = false;
		
			private Part part;
			private UIComponent tableForm;
			private String DATE_FORMAT = "dd/MM/yyyy";
		
			private UploadedFile file;
			private StreamedContent downloadFile;
		
			private BigDecimal image_id;
		
			private Boolean booBrowsedFile = false;
			private Boolean booEmploymentInformation = false;
			private Boolean booEmploymentPanel = true;
			private Map<String, StreamedContent> imageMap = new HashMap<String, StreamedContent>();
		
			private String idTypeBranchPage = "";
			// private String idTypeproof = null;
		
			private String hidden1 = "0";
			private int saveUptoPanel = 1;
		
			private Boolean booContactDetailsSize = false;
		
			/* To track which id type has been selected */
			private String selectedIdType = null;
		
			public String getIdType() {
				return idType;
			}
		
			public void setIdType(String idType) {
				this.idType = idType;
			}
		
			public String getSelectType() {
				return selectType;
			}
		
			public void setSelectType(String selectType) {
				this.selectType = selectType;
			}
		
			public String getManual() {
				return manual;
			}
		
			public void setManual(String manual) {
				this.manual = manual;
			}
		
			public String getSmartCard() {
				return smartCard;
			}
		
			public void setSmartCard(String smartCard) {
				this.smartCard = smartCard;
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
		
			public String getFirstName() {
				return firstName;
			}
		
			public void setFirstName(String firstName) {
				this.firstName = firstName;
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
		
			public void setMiddleName(String middleName) {
				this.middleName = middleName;
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
		
			public void setFirstNamel(String firstNamel) {
				this.firstNamel = firstNamel;
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
		
			public void setMiddleNamel(String middleNamel) {
				this.middleNamel = middleNamel;
			}
		
			public String getShortNamel() {
				return shortNamel;
			}
		
			public void setShortNamel(String shortNamel) {
				this.shortNamel = shortNamel;
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
		
			public String getAMLStatus() {
				return AMLStatus;
			}
		
			public void setAMLStatus(String aMLStatus) {
				AMLStatus = aMLStatus;
			}
		
			public String getNumberofhits() {
				return numberofhits;
			}
		
			public void setNumberofhits(String numberofhits) {
				this.numberofhits = numberofhits;
			}
		
			public BigDecimal getContactTypeId() {
				return contactTypeId;
			}
		
			public void setContactTypeId(BigDecimal contactTypeId) {
				this.contactTypeId = contactTypeId;
			}
		
			public String getLocalArea() {
				return localArea;
			}
		
			public void setLocalArea(String localArea) {
				this.localArea = localArea;
			}
		
			public String getStreet() {
				return street;
			}
		
			public void setStreet(String street) {
				this.street = street;
			}
		
			public String getBlock() {
				return block;
			}
		
			public void setBlock(String block) {
				this.block = block;
			}
		
			public String getTelephone() {
				return telephone;
			}
		
			public void setTelephone(String telephone) {
				this.telephone = telephone;
			}
		
			public String getArea() {
				return area;
			}
		
			public void setArea(String area) {
				this.area = area;
			}
		
			public String getFlat() {
				return flat;
			}
		
			public void setFlat(String flat) {
				this.flat = flat;
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
		
			public String getOccupation() {
				return occupation;
			}
		
			public void setOccupation(String occupation) {
				this.occupation = occupation;
			}
		
			public String getEmployer() {
				return employer;
			}
		
			public void setEmployer(String employer) {
				this.employer = employer;
			}
		
			public BigDecimal getEmploymentType() {
				return employmentType;
			}
		
			public void setEmploymentType(BigDecimal employmentType) {
			
				this.employmentType = employmentType;
			}
		
			public String getEmpcategory() {
				return empcategory;
			}
		
			public void setEmpcategory(String empcategory) {
				this.empcategory = empcategory;
			}
		
			public String getOriginId() {
				return originId;
			}
		
			public void setOriginId(String originId) {
				this.originId = originId;
			}
		
			public String getStateEmployment() {
				return stateEmployment;
			}
		
			public void setStateEmployment(String stateEmployment) {
				this.stateEmployment = stateEmployment;
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
		
			public String getStatusMessage() {
				return statusMessage;
			}
		
			public void setStatusMessage(String statusMessage) {
				this.statusMessage = statusMessage;
			}
		
			public String getIntroduceBy() {
				return introduceBy;
			}
		
			public void setIntroduceBy(String introduceBy) {
				this.introduceBy = introduceBy;
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
		
			public String getDataTableContactTypeValue() {
				return dataTableContactTypeValue;
			}
		
			public void setDataTableContactTypeValue(String dataTableContactTypeValue) {
				this.dataTableContactTypeValue = dataTableContactTypeValue;
			}
		
			public String getIdnumberProof() {
				return idnumberProof;
			}
		
			public void setIdnumberProof(String idnumberProof) {
				this.idnumberProof = idnumberProof;
			}
		
			public String getEmparea() {
				return emparea;
			}
		
			public void setEmparea(String emparea) {
				this.emparea = emparea;
			}
		
			public String getIdTypeproof() {
				return idTypeproof;
			}
		
			public String getExpDateCheck() {
				return expDateCheck;
			}
		
			public void setExpDateCheck(String expDateCheck) {
				this.expDateCheck = expDateCheck;
			}
		
			public BigDecimal getNationality() {
				return nationality;
			}
		
			public void setNationality(BigDecimal nationality) {
				this.nationality = nationality;
			}
		
			public BigDecimal getEmpCountryId() {
				return empCountryId;
			}
		
			public void setEmpCountryId(BigDecimal empCountryId) {
				this.empCountryId = empCountryId;
			}
		
			public BigDecimal getEmpStateId() {
				return empStateId;
			}
		
			public void setEmpStateId(BigDecimal empStateId) {
				this.empStateId = empStateId;
			}
		
			public BigDecimal getEmpDistrictId() {
				return empDistrictId;
			}
		
			public void setEmpDistrictId(BigDecimal empDistrictId) {
				this.empDistrictId = empDistrictId;
			}
		
			public BigDecimal getEmpCityId() {
				return empCityId;
			}
		
			public void setEmpCityId(BigDecimal empCityId) {
				this.empCityId = empCityId;
			}
		
			public void setIdTypeproof(String idTypeproof) {
				this.idTypeproof = idTypeproof;
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
		
			public BigDecimal getEmpInfoEmploymentTypeId() {
				return empInfoEmploymentTypeId;
			}
		
			public void setEmpInfoEmploymentTypeId(BigDecimal empInfoEmploymentTypeId) {
				this.empInfoEmploymentTypeId = empInfoEmploymentTypeId;
			}
		
			public Map<String, String> getIdTypeMap() {
				return idTypeMap;
			}
		
			public void setIdTypeMap(Map<String, String> idTypeMap) {
				this.idTypeMap = idTypeMap;
			}
		
			public Boolean getContactlistcheck() {
				return contactlistcheck;
			}
		
			public void setContactlistcheck(Boolean contactlistcheck) {
				this.contactlistcheck = contactlistcheck;
			}
		
			public BigDecimal getLanguageId() {
				return languageId;
			}
		
			public void setLanguageId(BigDecimal languageId) {
				this.languageId = languageId;
			}
		
			public List<IdentityType> getIdentityTypeList() {
				return identityTypeList;
			}
		
			public void setIdentityTypeList(List<IdentityType> identityTypeList) {
				this.identityTypeList = identityTypeList;
			}
		
			public BigDecimal getCountryId() {
				return countryId;
			}
		
			public void setCountryId(BigDecimal countryId) {
				this.countryId = countryId;
			}
		
			public BigDecimal getCityId() {
				return cityId;
			}
		
			public void setCityId(BigDecimal cityId) {
				this.cityId = cityId;
			}
		
			public BigDecimal getStateId() {
				return stateId;
			}
		
			public void setStateId(BigDecimal stateId) {
				this.stateId = stateId;
			}
		
			public BigDecimal getDistrictId() {
				return districtId;
			}
		
			public void setDistrictId(BigDecimal districtId) {
				this.districtId = districtId;
			}
		
			public List<CountryMasterDesc> getCountryList() {
				return countryList;
			}
		
			public void setCountryList(List<CountryMasterDesc> countryList) {
				this.countryList = countryList;
			}
		
			public List<StateMasterDesc> getLstState() {
				return lstState;
			}
		
			public void setLstState(List<StateMasterDesc> lstState) {
				this.lstState = lstState;
			}
		
			public List<CityMasterDesc> getLstCity() {
				return lstCity;
			}
		
			public void setLstCity(List<CityMasterDesc> lstCity) {
				this.lstCity = lstCity;
			}
		
			public List<DistrictMasterDesc> getLstDistrict() {
				return lstDistrict;
			}
		
			public void setLstDistrict(List<DistrictMasterDesc> lstDistrict) {
				this.lstDistrict = lstDistrict;
			}
		
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
		
			public BigDecimal getPkCustomerId() {
				return pkCustomerId;
			}
		
			public void setPkCustomerId(BigDecimal pkCustomerId) {
				this.pkCustomerId = pkCustomerId;
			}
		
			public BigDecimal getPkCustomerContactDetails() {
				return pkCustomerContactDetails;
			}
		
			public void setPkCustomerContactDetails(BigDecimal pkCustomerContactDetails) {
				this.pkCustomerContactDetails = pkCustomerContactDetails;
			}
		
			public BigDecimal getPkCustomerEmployeeId() {
				return pkCustomerEmployeeId;
			}
		
			public void setPkCustomerEmployeeId(BigDecimal pkCustomerEmployeeId) {
				this.pkCustomerEmployeeId = pkCustomerEmployeeId;
			}
		
			public BigDecimal getPkCustomerIdProof() {
				return pkCustomerIdProof;
			}
		
			public void setPkCustomerIdProof(BigDecimal pkCustomerIdProof) {
				this.pkCustomerIdProof = pkCustomerIdProof;
			}
		
			public Part getPart() {
				return part;
			}
		
			public void setPart(Part part) {
				this.part = part;
			}
		
			public Boolean getBooManual() {
				return booManual;
			}
		
			public void setBooManual(Boolean booManual) {
				this.booManual = booManual;
			}
		
			public Boolean getBooSmartcard() {
				return booSmartcard;
			}
		
			public void setBooSmartcard(Boolean booSmartcard) {
				this.booSmartcard = booSmartcard;
			}
		
			public Boolean getBooIdDetail() {
				return booIdDetail;
			}
		
			public void setBooIdDetail(Boolean booIdDetail) {
				this.booIdDetail = booIdDetail;
			}
		
			public Boolean getBooCustomerDetails() {
				return booCustomerDetails;
			}
		
			public void setBooCustomerDetails(Boolean booCustomerDetails) {
				this.booCustomerDetails = booCustomerDetails;
			}
		
			public Boolean getBooRemitterInfo() {
				return booRemitterInfo;
			}
		
			public void setBooRemitterInfo(Boolean booRemitterInfo) {
				this.booRemitterInfo = booRemitterInfo;
			}
		
			public Boolean getBooContactDetails() {
				return booContactDetails;
			}
		
			public void setBooContactDetails(Boolean booContactDetails) {
				this.booContactDetails = booContactDetails;
			}
		
			public Boolean getBooEmploymentDetails() {
				return booEmploymentDetails;
			}
		
			public void setBooEmploymentDetails(Boolean booEmploymentDetails) {
				this.booEmploymentDetails = booEmploymentDetails;
			}
		
			public Boolean getBooProof() {
				return booProof;
			}
		
			public void setBooProof(Boolean booProof) {
				this.booProof = booProof;
			}
		
			public List<ContactType> getContactTypeList() {
				return contactTypeList;
			}
		
			public void setContactTypeList(List<ContactType> contactTypeList) {
				this.contactTypeList = contactTypeList;
			}
		
			public String getDATE_FORMAT() {
				return DATE_FORMAT;
			}
		
			public void setDATE_FORMAT(String dATE_FORMAT) {
				DATE_FORMAT = dATE_FORMAT;
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
		
			public Map<String, StreamedContent> getImageMap() {
				return imageMap;
			}
		
			public void setImageMap(Map<String, StreamedContent> imageMap) {
				this.imageMap = imageMap;
			}
		
			public String getIdTypeBranchPage() {
				return idTypeBranchPage;
			}
		
			public void setIdTypeBranchPage(String idTypeBranchPage) {
				this.idTypeBranchPage = idTypeBranchPage;
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
		
			public Date getExpDate() {
				return expDate;
			}
		
			public void setExpDate(Date expDate) {
				this.expDate = expDate;
			}
		
			public Date getDateExp() {
				return dateExp;
			}
		
			public void setDateExp(Date dateExp) {
				this.dateExp = dateExp;
			}
		
			public Date getDob() {
				return dob;
			}
		
			public void setDob(Date dob) {
				this.dob = dob;
			}
		
			public List<AddContactDetailBean> getContactList() {
				setContactDataTable(contactList.size() > 0 ? true : false);
				return contactList;
			}
		
			/*
			 * public void setContactList(List<AddContactDetailBean> contactList) {
			 * this.contactList = contactList; }
			 */
		
			public boolean isContactDataTable() {
				return contactDataTable;
			}
		
			public void setContactDataTable(boolean contactDataTable) {
				this.contactDataTable = contactDataTable;
			}
		
			public List<AddContactDetailBean> getContactListDelete() {
				return contactListDelete;
			}
		
			public void setContactListDelete(
					List<AddContactDetailBean> contactListDelete) {
				this.contactListDelete = contactListDelete;
			}
		
			public List<CreateProofTable> getCreateProofList() {
				return createProofList;
			}
		
			public void setCreateProofList(List<CreateProofTable> createProofList) {
				this.createProofList = createProofList;
			}
		
			public List<CreateProofTable> getCreateProofListDelete() {
				return createProofListDelete;
			}
		
			public void setCreateProofListDelete(
					List<CreateProofTable> createProofListDelete) {
				this.createProofListDelete = createProofListDelete;
			}
		

		
			public Boolean getBooProfListDuplicate() {
				return booProfListDuplicate;
			}
		
			public void setBooProfListDuplicate(Boolean booProfListDuplicate) {
				this.booProfListDuplicate = booProfListDuplicate;
			}
		
			public Boolean getBooIdTypeCheck() {
				return booIdTypeCheck;
			}
		
			public void setBooIdTypeCheck(Boolean booIdTypeCheck) {
				this.booIdTypeCheck = booIdTypeCheck;
			}
		
		
			public Boolean getBooUnEmp() {
				return booUnEmp;
			}
		
			public void setBooUnEmp(Boolean booUnEmp) {
				this.booUnEmp = booUnEmp;
			}
		
			public Boolean getEnablePTbl() {
				return enablePTbl;
			}
		
			public void setEnablePTbl(Boolean enablePTbl) {
				this.enablePTbl = enablePTbl;
			}
		
			public boolean getApproved() {
				return approved;
			}
		
			public void setApproved(boolean approved) {
				this.approved = approved;
			}
		
			public Boolean getBoolAdditional() {
				return boolAdditional;
			}
		
			public void setBoolAdditional(Boolean boolAdditional) {
				this.boolAdditional = boolAdditional;
			}
		
			public Boolean getProoflistcheck() {
				return prooflistcheck;
			}
		
			public void setProoflistcheck(Boolean prooflistcheck) {
				this.prooflistcheck = prooflistcheck;
			}
		
			// private String
			// userName=sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root";
		
			public String getDepartment() {
				return department;
			}
		
			public void setDepartment(String department) {
				this.department = department;
			}
		
			public String getMinDob() {
				return minDob;
			}
		
			public void setMinDob(String minDob) {
				this.minDob = minDob;
			}
		
			public Boolean getBooEmploymentInformation() {
				return booEmploymentInformation;
			}
		
			public void setBooEmploymentInformation(Boolean booEmploymentInformation) {
				this.booEmploymentInformation = booEmploymentInformation;
			}
		
			public Boolean getBooEmploymentPanel() {
				return booEmploymentPanel;
			}
		
			public void setBooEmploymentPanel(Boolean booEmploymentPanel) {
				this.booEmploymentPanel = booEmploymentPanel;
			}
		
			public int getSaveUptoPanel() {
				return saveUptoPanel;
			}
		
			public void setSaveUptoPanel(int saveUptoPanel) {
				this.saveUptoPanel = saveUptoPanel;
			}
		
			public List<StateMasterDesc> getLstEmpStateList() {
				return lstEmpStateList;
			}
		
			public void setLstEmpStateList(List<StateMasterDesc> lstEmpStateList) {
				this.lstEmpStateList = lstEmpStateList;
			}
		
			public List<DistrictMasterDesc> getLstEmpDistrictList() {
				return lstEmpDistrictList;
			}
		
			public void setLstEmpDistrictList(
					List<DistrictMasterDesc> lstEmpDistrictList) {
				this.lstEmpDistrictList = lstEmpDistrictList;
			}
		
			public List<CityMasterDesc> getLstEmpCityList() {
				return lstEmpCityList;
			}
		
			public void setLstEmpCityList(List<CityMasterDesc> lstEmpCityList) {
				this.lstEmpCityList = lstEmpCityList;
			}
		
			public String getSelectedIdType() {
				return selectedIdType;
			}
		
			public void setSelectedIdType(String selectedIdType) {
				this.selectedIdType = selectedIdType;
			}
			
			
		
			public Map<BigDecimal, String> getMapContactTypeList() {
				return mapContactTypeList;
			}

			public void setMapContactTypeList(Map<BigDecimal, String> mapContactTypeList) {
				this.mapContactTypeList = mapContactTypeList;
			}



			public boolean isBoonomeneeCheck() {
				return boonomeneeCheck;
			}

			public void setBoonomeneeCheck(boolean boonomeneeCheck) {
				this.boonomeneeCheck = boonomeneeCheck;
			}



			public BigDecimal getNomineeId() {
				return nomineeId;
			}

			public void setNomineeId(BigDecimal nomineeId) {
				this.nomineeId = nomineeId;
			}



			public boolean getIdListcheck() {
				return idListcheck;
			}

			public void setIdListcheck(boolean idListcheck) {
				this.idListcheck = idListcheck;
			}

			public boolean getBooidproofDatatable() {
				return booidproofDatatable;
			}

			public void setBooidproofDatatable(boolean booidproofDatatable) {
				this.booidproofDatatable = booidproofDatatable;
			}



			@Autowired
			IGeneralService<T> generalService;
			@Autowired
			ICustomerRegistrationBranchService<T> icustomerRegistrationService;
		
			@Autowired
			IBranchPageService<T> branchpageService;
			
			@Autowired
			ICorporateRegService<T>   corpRegService;
		
			public IGeneralService<T> getGeneralService() {
				return generalService;
			}
		
			public void setGeneralService(IGeneralService<T> generalService) {
				this.generalService = generalService;
			}
		
			public ICustomerRegistrationBranchService<T> getIcustomerRegistrationService() {
				return icustomerRegistrationService;
			}
		
			public void setIcustomerRegistrationService(
					ICustomerRegistrationBranchService<T> icustomerRegistrationService) {
				this.icustomerRegistrationService = icustomerRegistrationService;
			}
		
			public IBranchPageService<T> getBranchpageService() {
				return branchpageService;
			}
		
			public void setBranchpageService(IBranchPageService<T> branchpageService) {
				this.branchpageService = branchpageService;
			}
		
			public String viewBehaviorBean(String componentName, String type) {
		
				return new CollectionUtil().fetchBehavior(mapComponentBehavior,
						componentName, type);
			}
			
			
			private String userName=FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("userName")
					.toString();
			
			public ICorporateRegService<T> getCorpRegService() {
				return corpRegService;
			}

			public void setCorpRegService(ICorporateRegService<T> corpRegService) {
				this.corpRegService = corpRegService;
			}

			@Autowired
			public CustomerRegistrationBranchBean(IGeneralService<T> generalService) {
		
				setGeneralService(generalService);
		
				setPageIdIntoSession();
				prepareBehavior();
			}
		
			private void setPageIdIntoSession() {
		
				String pageName = FacesContext.getCurrentInstance().getViewRoot()
						.getViewId();
				pageName = pageName.substring(pageName.lastIndexOf('/') + 1,
						pageName.indexOf(".xhtml"));
		
				try {
					BigDecimal pageId = getGeneralService().getPageId(pageName);
					new SessionStateManage().setSessionValue("pageId",
							pageId.toString());
				} catch (Exception e) {
				
				}
			}
		
			private void prepareBehavior() {
		
				SessionStateManage manage = new SessionStateManage();
				List<String> lstComponentName = Arrays.asList("Civil ID", "First Name",
						"Middle Name", "Last Name", "Short Name", "Local First Name",
						"Local Middle name", "Local Last Name", "Local Short Name","Nationality",
						"Mobile No", "Email", "Alternate Email Id", "Date of Birth", "State", "District","City","Block","Flat",
						"Street", "Local Area", "Office Telephone", "Postal Code","Department",
						"First Name", "Last Name", "Civil Id Expiary Date","Employment Type",
						"Employee State", "Employee District", "Employee City",
						"Employer Name", "Employee Area", "Employee Street",
						"Telephone Number", "Employee Flat", "Employee Block",
						"Country", "Contact Type","Id Type", "Id Number");
		
				mapComponentBehavior = getGeneralService().getComponentBehavior(
						lstComponentName, manage.getLevel(), manage.getApplicationId(),
						manage.getCompanyId(), manage.getCountryId(),
						manage.getPageId());
			}
		
			private CountryMaster countryMaster = null;
			private CompanyMaster companyMaster = null;
			private Customer customer = null;
			private StateMaster stateMaster = null;
			private DistrictMaster districtMaster = null;
			private CityMaster cityMaster = null;
			private ContactType contactType = null;
			private LanguageType languageType= null;
			
			public Blob storeImage() throws IOException, SerialException, SQLException {
		
				InputStream stream = null;
		
				try {
					stream = file.getInputstream();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new javax.sql.rowset.serial.SerialBlob(readFully(stream));
			}
		
			public void veryfiAllClick() {
				if (getApproved()) {
					for (CreateProofTable element : createProofList) {
						element.setChecked(true);
					}
				} else {
					for (CreateProofTable element : createProofList) {
						element.setChecked(false);
					}
				}
			}
		
			public byte[] readFully(InputStream input) throws IOException {
				byte[] buffer = new byte[8192];
				int bytesRead;
				ByteArrayOutputStream output = new ByteArrayOutputStream();
		
				while ((bytesRead = input.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
				return output.toByteArray();
			}
		
			private BigDecimal individualIdType = new BigDecimal(1);
		
			public List<IdentityType> getFetchIdType() {
				SessionStateManage sessionStateManage = new SessionStateManage();
				List<IdentityType> idType = getGeneralService()
						.getIdentityTypes(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1),
								new BigDecimal(sessionStateManage
										.getSessionValue("countryId")),
								individualIdType);
		
				for (IdentityType identityType : idType) {
					idTypeMap.put(identityType.getIdentityTypeId().toPlainString(),
							identityType.getIdentityType());
				}
		
				setIdentityTypeList(idType);
		
				return idType;
		
			}
		
			public List<ContactType> getFetchContactTypeList() {
				
				contactTypeList = new ArrayList<ContactType>();
				SessionStateManage sessionStateManage = new SessionStateManage();
				
			/*	List<ContactType> lstContactType = getGeneralService()
						.getContactTypes(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1));*/
		
				contactTypeList.addAll( getGeneralService()
						.getContactTypes(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1)));
				
				for(ContactType contType:contactTypeList) {
					mapContactTypeList.put(contType.getContactTypeId(), contType.getContactType());
					
					System.out.println("----------------------mapContactTypeList------------------"+mapContactTypeList);
			
			}
				return contactTypeList;
			}
			
			
			/**
			 * method is responsible to populate List of Nationality from DB
			 * 
			 * @return
			 */
			
		/*	public List<CountryMasterDesc> getArticleList() {
				SessionStateManage sessionStateManage = new SessionStateManage();
				return getGeneralService()
						.getNationalityList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"));
			}*/
			
			
			/**
			 * method is responsible to populate List of Nationality from DB
			 * 
			 * @return
			 */
			
			public List<CountryMasterDesc> getNationalityNameList() {
				SessionStateManage sessionStateManage = new SessionStateManage();
				return getGeneralService()
						.getNationalityList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"));
			}
		
			/**
			 * method is responsible to populate List of countries from DB
			 * 
			 * @return
			 */
			public List<CountryMasterDesc> getCountryNameList() {
				sessionStateManage = new SessionStateManage();
				countryList = new ArrayList<CountryMasterDesc>();
				countryList.addAll(getGeneralService()
						.getCountryList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1")));
		
				for (CountryMasterDesc countryMasterDesc : countryList) {
					mapCountryList.put(countryMasterDesc.getFsCountryMaster()
							.getCountryId(), countryMasterDesc.getCountryName());
				}
				return countryList;
			}
		
			/**
			 * 
			 * method to get state from db and add all the state code and name will be
			 * mapped to hashMap
			 */
			public void popState(AjaxBehaviorEvent e) {
		
				lstState = new ArrayList<StateMasterDesc>();
				lstState.addAll(getGeneralService()
						.getStateList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"),
								getCountryId()));
				for (StateMasterDesc stateMasterDesc : lstState) {
					mapStateList.put(stateMasterDesc.getFsStateMaster().getStateId(),
							stateMasterDesc.getStateName());
				}
			}
		
			public List<StateMasterDesc> getStateListFromDB() {
				return lstState;
			}
		
			/*
			 * 
			 * method to get District from db and add all the state code and name will
			 * be mapped to hashMap
			 */
			public void popDistrict(AjaxBehaviorEvent e) {
				lstDistrict = new ArrayList<DistrictMasterDesc>();
				lstDistrict.addAll(getGeneralService()
						.getDistrictList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"),
								getCountryId(), getStateId()));
				for (DistrictMasterDesc districtMasterDesc : lstDistrict) {
					mapDistirictList.put(districtMasterDesc.getFsDistrictMaster()
							.getDistrictId(), districtMasterDesc.getDistrict());
				}
			}
		
			public List<DistrictMasterDesc> getDistrictListFromDB() {
				return lstDistrict;
		
			}
		
			/**
			 * 
			 * method to get city from db and add all the state code and name will be
			 * mapped to hashMap
			 */
			public void popCity(AjaxBehaviorEvent e) {
				lstCity = new ArrayList<CityMasterDesc>();
				lstCity.addAll(getGeneralService()
						.getCityList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"),
								getCountryId(), getStateId(), getDistrictId()));
				for (CityMasterDesc cityMasterDesc : lstCity) {
					mapCityList.put(cityMasterDesc.getFsCityMaster().getCityId(),
							cityMasterDesc.getCityName());
				}
			}
		
			/**
			 * 
			 * method to get state from db and add all the state code and name will be
			 * mapped to hashMap
			 */
			public void popEmpState(AjaxBehaviorEvent e) {
		
			
		
				SessionStateManage sessionStateManage = new SessionStateManage();
				List<StateMasterDesc> stateMaster = getGeneralService()
						.getStateList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1),
								getEmpCountryId());
				setLstEmpStateList(stateMaster);
			}
		
			/*
			 * 
			 * method to get District from db and add all the state code and name will
			 * be mapped to hashMap
			 */
			public void popEmpDistrict(AjaxBehaviorEvent e) {
				SessionStateManage sessionStateManage = new SessionStateManage();
				List<DistrictMasterDesc> lstDistrict = getGeneralService()
						.getDistrictList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1),
								getEmpCountryId(), getEmpStateId());
				setLstEmpDistrictList(lstDistrict);
			}
		
			/**
			 * 
			 * method to get city from db and add all the state code and name will be
			 * mapped to hashMap
			 */
			public void popEmpCity(AjaxBehaviorEvent e) {
		
				SessionStateManage sessionStateManage = new SessionStateManage();
				List<CityMasterDesc> lstCity = getGeneralService()
						.getCityList(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1),
								getEmpCountryId(), getEmpStateId(), getEmpDistrictId());
				setLstEmpCityList(lstCity);
		
			}
		
			/*
			 * public List<CityMasterDesc> getEmpCityListFromDB() { return lstCity;
			 * 
			 * }
			 */
		
			public List<CityMasterDesc> getCityListFromDB() {
				return lstCity;
		
			}
		
			public List<EmploymentType> getEmploymentTypeList() {
		
				sessionStateManage = new SessionStateManage();
				return getGeneralService()
						.getEmploymentTypes(
								new BigDecimal(sessionStateManage
										.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "" + 1));
			}
		
			/**
			 * This is responsible to render Panel, depending upon Employment Type
			 * selection
			 * 
			 * @param event
			 */
			public void getEmploymentStatus(AjaxBehaviorEvent event) {
				/* 3 means unemployed and 0 means Select */
			
				if(getEmploymentType().intValue() == 3 || getEmploymentType().intValue() == 0) {
					setBooEmploymentPanel(false);
				} else {
					setBooEmploymentPanel(true);
				}
			}
		
			public void getIDTypeValue(AjaxBehaviorEvent event) {
				setSelectedIdType(getIdType());
				}
		
			public void onblurId(AjaxBehaviorEvent event) {
			
				// setIdTypeBranchPage(getIdType());
		
			
				if (getSelectedIdType().equalsIgnoreCase("1")) {
					setBooIdTypeCheck(true);
					// SessionStateManage sessionStateManage = new SessionStateManage();
					// BigDecimal language = new
					// BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1);
					String value = getIdNumber();
					
					// String validityStatus = "";
					String civilidPartial = "";
					int remainder = 0;
					int civilidLength = 0;
					int civilidCal = 0;
					int civilidLastDigit = 0;
					int civilidCalChkDigit = 0;
					final int ELEVEN = 11;
					final int TWELVE = 12;
					// -- Check Length Civil ID
					civilidLength = value.toString().length();
					
		
					if (civilidLength != TWELVE) {
						setBooIdTypeCheck(true);
					
					} else {
						try {
		
							// -- First 11 Characters for Calculation.
							civilidPartial = value.toString().substring(0, ELEVEN);
							// -- 12th Character Check Digit
							value.toString().intern();
							civilidLastDigit = Integer.parseInt(value.toString()
									.substring(11, 12));
							// -- Calculation as per PACI Rules for calculating check
							// digit
							civilidCal = Integer.parseInt(civilidPartial
									.substring(0, 1))
									* 2
									+ Integer.parseInt(civilidPartial.substring(1, 2))
									* 1
									+ Integer.parseInt(civilidPartial.substring(2, 3))
									* 6
									+ Integer.parseInt(civilidPartial.substring(3, 4))
									* 3
									+ Integer.parseInt(civilidPartial.substring(4, 5))
									* 7
									+ Integer.parseInt(civilidPartial.substring(5, 6))
									* 9
									+ Integer.parseInt(civilidPartial.substring(6, 7))
									* 10
									+ Integer.parseInt(civilidPartial.substring(7, 8))
									* 5
									+ Integer.parseInt(civilidPartial.substring(8, 9))
									* 8
									+ Integer.parseInt(civilidPartial.substring(9, 10))
									* 4
									+ Integer
											.parseInt(civilidPartial.substring(10, 11))
									* 2;
		
							// -- Calculate Remainder by dividing 11
							remainder = civilidCal % ELEVEN;
		
							// -- Get Check Digit by subtracting W_REM from 11
							civilidCalChkDigit = ELEVEN - remainder;
		
							// -- Check digit can not be 0 or 10
							if (civilidCalChkDigit == 0 || civilidCalChkDigit == 10) {
								setBooIdTypeCheck(false);
							} else {
								// -- Calculated and Actual Check Digit same OK
								if (civilidCalChkDigit == civilidLastDigit) {
									setBooIdTypeCheck(false);
								} else {
									setBooIdTypeCheck(true);
								}
							}
						} catch (Exception e) {
							setBooIdTypeCheck(false);
						}
					}
		
				} else {
					setBooIdTypeCheck(false);
				}
			}
		
			public void idInfo() {
		
				setBooRemitterInfo(false);
				setBooIdDetail(true);
				setBooCustomerDetails(false);
				setBooContactDetails(false);
				setBooEmploymentDetails(false);
				setBooProof(false);
			}
		
			/**
			 * Next or Back button is pressed from Remitter Panel, next panel is contact details 
			 * This method called from Go button
			 */
			
			public void nextRemitterInfo() {
				
				fetchCustomerInfo();
		
					
			 if (getSelectType() != null && getSelectType().equalsIgnoreCase("1")) {
		
					setBooRemitterInfo(true);
					setBooIdDetail(false);
					setBooCustomerDetails(false);
					setBooContactDetails(false);
					setBooEmploymentDetails(false);
					setBooProof(false);
		
				} else {
					setBooRemitterInfo(false);
					setBooIdDetail(false);
					setBooCustomerDetails(true);
					setBooContactDetails(false);
					setBooEmploymentDetails(false);
					setBooProof(false);
				}
		
			}
		
			/**
			 * Next or Back button is pressed from Contact Detail Panel, next panel is Employment details and Back panel is Remitter Info
			 */
			
			public void nextContactDetails() {
				setBooRemitterInfo(false);
				setBooIdDetail(false);
				setBooCustomerDetails(false);
				setBooContactDetails(true);
				setBooEmploymentDetails(false);
				setBooProof(false);
				
				System.out.println("MIDDLE NAME : "+getMiddleName());
		
			}
		
			/**
			 * Next or Back button is pressed from Employment Detail Panel, next panel is proof details and Back panel is Contact Details Panel
			 */
			
			public void nextEmploymentDetails() {
		
				if (contactList.size() == 0) {
					setContactlistcheck(true);
				
				} else {
					setBooRemitterInfo(false);
					setBooIdDetail(false);
					setBooCustomerDetails(false);
					setBooContactDetails(false);
					setBooProof(false);
					setBooEmploymentDetails(true);
				
				}
			}
		
			/**
			 * Back button is pressed from Employment Detail Panel,  Back panel is Employment Details Panel
			 */
			
			public void nextProofDetails() {
		
			
				setBooRemitterInfo(false);
				setBooIdDetail(false);
				setBooCustomerDetails(false);
				setBooContactDetails(false);
				setBooProof(true);
				setBooEmploymentDetails(false);
			
		
			}
		
public void backRemitterInfo() {
				
			
		
					
			 if (getSelectType() != null && getSelectType().equalsIgnoreCase("1")) {
		
					setBooRemitterInfo(true);
					setBooIdDetail(false);
					setBooCustomerDetails(false);
					setBooContactDetails(false);
					setBooEmploymentDetails(false);
					setBooProof(false);
		
				} else {
					setBooRemitterInfo(false);
					setBooIdDetail(false);
					setBooCustomerDetails(true);
					setBooContactDetails(false);
					setBooEmploymentDetails(false);
					setBooProof(false);
				}
		
			}

					public void backContactDetails() {
						setBooRemitterInfo(false);
						setBooIdDetail(false);
						setBooCustomerDetails(false);
						setBooContactDetails(true);
						setBooEmploymentDetails(false);
						setBooProof(false);
						
					
					}
					
					public void backEmploymentDetails() {
						
						if (createProofList.size() == 0) {
							setIdListcheck(true);
						
						} else {
							setBooRemitterInfo(false);
							setBooIdDetail(false);
							setBooCustomerDetails(false);
							setBooContactDetails(false);
							setBooProof(false);
							setBooEmploymentDetails(true);
							
						}
					}
			
			/**
			 * this panel is used for card Details
			 */
			
			public void appearCarddetail() {
		
				if (getSelectType().equalsIgnoreCase("1") && getSelectType() != null) {
		
					// setBooRemitterInfo(true);
					setBooCustomerDetails(false);
					setBooManual(true);
		
				} else {
		
					setBooCustomerDetails(false);
					setBooRemitterInfo(false);
					setBooManual(false);
		
				}
		
			}
		
			/**
			 * This will control upto which panel need to save
			 * 
			 * @throws ParseException
			 * @throws SQLException
			 * @throws IOException
			 * @throws SerialException
			 */
			/*public void panelSaveController() throws SerialException, IOException,
					SQLException, ParseException {
				if (getSaveUptoPanel() == 1) {
					saveCustomerInfo();
				} else if (getSaveUptoPanel() == 2) {
					saveContactDetails();
				} else if (getSaveUptoPanel() == 3) {
					saveEmployementDetails();
				} else {
		
					saveProofDetails();
				}
			}*/
		
			public String saveCustomerInfo() throws IOException, ParseException {
				
				String country = "120";
		
			    customer = new Customer();
				SessionStateManage sessionStateManage = new SessionStateManage();
				

				if(sessionStateManage.isExists("countryId")){
					country = sessionStateManage.getSessionValue("countryId");
				}
				// try{
				/* Country ID save */
				System.out.println("the country id=========================="+getCountryId());
				countryMaster = new CountryMaster();
				countryMaster.setCountryId(new BigDecimal(country));
		
				/* Nationality Id save */
				CountryMaster nationality = new CountryMaster();
				nationality.setCountryId(getNationality());
		
				/* save company */
				companyMaster = new CompanyMaster();
				companyMaster.setCompanyId(sessionStateManage.getCompanyId());
		
				/* Customer Type */
				CustomerType customerType = new CustomerType();
				customerType.setCustomerTypeId(new BigDecimal(1));
		
				/* TODO Hard coded Group ID */
				CompanyGroup companyGroup = new CompanyGroup();
				companyGroup.setGroupId(new BigDecimal(1));
				

				ArticleDetails articleDetail = new ArticleDetails();
				articleDetail.setArticleDetailId(getArticle());
				customer.setFsArticleDetails(articleDetail);
				
				// } catch(Exception e) {
				// e.printStackTrace();
				// }
		
				int languageID = 1;
				if (FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().containsKey("languageCode")) {
					languageID = FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap().get("languageCode").toString()
							.equalsIgnoreCase("ar") ? 2 : 1;
				}
		
				languageType = new LanguageType();
				languageType.setLanguageId(new BigDecimal(languageID));
				customer.setFsLanguageType(languageType);
				customer.setFsCountryMasterByCountryId(countryMaster);
				customer.setShortName(getShortName());
				customer.setShortNameLocal(getShortNamel());
				customer.setAmlStatus(getAMLStatus());
				customer.setTitle(getTitle());
				customer.setFirstName(getFirstName());
				customer.setMiddleName(getMiddleName());
				customer.setLastName(getLastName());
				customer.setTitleLocal(getTitlel());
				customer.setFirstNameLocal(getFirstNamel());
				customer.setMiddleNameLocal(getMiddleNamel());
				customer.setLastNameLocal(getLastNamel());
				customer.setGender(getGender());
				customer.setDateOfBirth(getDob());
				customer.setAlterEmailId(getAlternativeEmail());
				customer.setMobile(getMobile());
				customer.setEmail(getEmail());
				// customer.setCreatedBy(userName);
				//customer.setActivatedInd("0");
		
				// TITLE, TITLE(L), Gender ned to be save
		
				//customer.setFsCountryMasterByCountryId(countryMaster);
				customer.setFsCompanyMaster(companyMaster);
				customer.setFsCustomerType(customerType);
				customer.setFsCompanyGroup(companyGroup);
				customer.setFsCountryMasterByNationality(nationality);
		
				/* Managing save or update */
				if (getPkCustomerId() != null) {
					customer.setCustomerId(getPkCustomerId());
					customer.setUpdatedBy(userName);
					customer.setLastUpdated(new Date());
				
				} else {
					customer.setCreatedBy(userName);
					customer.setCreationDate(new Date());
					//getIcustomerRegistrationService().saveCustomer(customer);
					//setPkCustomerId(customer.getCustomerId());
				}
				
				if(getApproved()){
					customer.setActivatedInd("1");
					customer.setActivatedDate(new Date());
					customer.setVerificationBy(userName);
					customer.setVerificationDate(new Date());
				} else {
					customer.setActivatedInd("0");
					customer.setInactivatedDate(new Date());
				}
				
				getIcustomerRegistrationService().saveCustomer(customer);
				setPkCustomerId(customer.getCustomerId());
				 customerIdToNominee = customer.getCustomerId();
			//	getNomineeRegistration().setCustomerIdFromBranchBean(customer.getCustomerId());
				
		saveContactDetails();
		saveEmployementDetails();
		
		saveProofDetails();
		
		System.out.println("Nominee : "+getNominee());		
		if(getNominee()) {
			System.out.println("FROM BRANCH PAGE : "+customerIdToNominee);
			getNomineeRegistration().setNominatorId(customerIdToNominee);
			return "nominee";
		} else {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
				context.invalidateSession();
				context.redirect("../common/successcustinfobranch.xhtml");
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
			}
		
			/**
			 * Save in Contact Details
			 */
			public String saveContactDetails() throws IOException, ParseException {
				
	
				SessionStateManage sessionStateManage = new SessionStateManage();
				countryMaster = new CountryMaster();
				stateMaster = new StateMaster();
			    districtMaster = new DistrictMaster();
			    cityMaster = new CityMaster();
			    contactType = new ContactType();
				
				customer = new Customer();
			
		
				/* Calculating Language ID */
				int languageID = 1;
				if (FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().containsKey("languageCode")) {
					languageID = FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap().get("languageCode").toString()
							.equalsIgnoreCase("ar") ? 2 : 1;
				}
			    languageType = new LanguageType();
				languageType.setLanguageId(new BigDecimal(languageID));
		
				for (AddContactDetailBean details : contactList) {
		
					ContactDetail contactDetail = new ContactDetail();
					contactType.setContactTypeId(details.getContactTypeId());
					System.out.println("getPkCustomerId()./...................................."+getPkCustomerId());
					customer.setCustomerId(getPkCustomerId());    
					contactDetail.setFsContactType(contactType);   	
					contactDetail.setFsCustomer(customer);
					contactDetail.setFsCountryMaster(countryMaster);
					contactDetail.setFsLanguageType(languageType);
					contactDetail.setFsStateMaster(stateMaster);
					contactDetail.setFsDistrictMaster(districtMaster);
					contactDetail.setFsCityMaster(cityMaster);
					
					countryMaster.setCountryId(details.getCountryId());
		            stateMaster.setStateId(details.getStateId());
                    districtMaster.setDistrictId(details.getDistrictId());
                    cityMaster.setCityId(details.getCityId());
		
					contactDetail.setArea(details.getArea());
					contactDetail.setBlock(details.getBlock());
					contactDetail.setFlat(details.getFlat());
					contactDetail.setStreet(details.getStreet());
					contactDetail.setTelephone(details.getTel());
		
					contactDetail.setCreatedBy(userName);
					contactDetail.setCreationDate(new Date());
					contactDetail.setActiveStatus("1");
		
				
					//if (getPkCustomerContactDetails() != null) {
					if(details.getContactDetailsId().intValue() != 0){
						contactDetail.setContactDetailId(details.getContactDetailsId());
						contactDetail
								.setUpdatedBy(userName);
						contactDetail.setLastUpdated(new Date());
						getIcustomerRegistrationService().saveContactDetails(contactDetail);
					} else {
						contactDetail
								.setCreatedBy(userName);
						contactDetail.setCreationDate(new Date());
						getIcustomerRegistrationService().saveContactDetails(contactDetail);
					}

				}
					for (AddContactDetailBean details : contactListDelete) {
						
						ContactDetail contactDetail = new ContactDetail();
						contactType.setContactTypeId(details.getContactTypeId());
						customer.setCustomerId(getPkCustomerId());    
						contactDetail.setFsContactType(contactType);   //	
						contactDetail.setFsCustomer(customer);
						contactDetail.setFsCountryMaster(countryMaster);
						contactDetail.setFsLanguageType(languageType);
						contactDetail.setFsStateMaster(stateMaster);
						contactDetail.setFsDistrictMaster(districtMaster);
						contactDetail.setFsCityMaster(cityMaster);
						
						countryMaster.setCountryId(details.getCountryId());
			            stateMaster.setStateId(details.getStateId());
	                    districtMaster.setDistrictId(details.getDistrictId());
	                    cityMaster.setCityId(details.getCityId());
			
						contactDetail.setArea(details.getArea());
						contactDetail.setBlock(details.getBlock());
						contactDetail.setFlat(details.getFlat());
						contactDetail.setStreet(details.getStreet());
						contactDetail.setTelephone(details.getTel());
			
						contactDetail.setCreatedBy(userName);
						contactDetail.setCreationDate(new Date());
						contactDetail.setActiveStatus("0");
			
						
						
					}
			
		
				//}
		
				return "";
		
			}
		
			/**
			 * This method will call when city change happen It's a do-nothing method,
			 * except this after click back button, selected cityId will not bind with
			 * bean
			 * 
			 * @param event
			 */
			public void getCity(AjaxBehaviorEvent event) {
			}
		
			/**
			 * Save in CustomerEmployment Table
			 */
			public void saveEmployementDetails() throws IOException, ParseException {
		
		
				SessionStateManage sessionStateManage = new SessionStateManage();
		
				/* Calculating Language ID */
				int languageID = 1;
				if (FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().containsKey("languageCode")) {
					languageID = FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap().get("languageCode").toString()
							.equalsIgnoreCase("ar") ? 2 : 1;
				}
				
				CustomerEmploymentInfo custEmp = new CustomerEmploymentInfo();
				
				EmploymentType employmentType = new EmploymentType();
		
			
				employmentType.setEmploymentTypeId(getEmploymentType());
				custEmp.setFsEmploymentType(employmentType);
				customer = new Customer();
				customer.setCustomerId(getPkCustomerId());
				custEmp.setFsCustomer(customer);
				 languageType = new LanguageType();
				    languageType.setLanguageId(new BigDecimal(languageID));
				custEmp.setFsLanguageType(languageType);
				try{
					if(getEmploymentType().intValue()!=3){
			   /* languageType = new LanguageType();
			    languageType.setLanguageId(new BigDecimal(languageID));
				*/
				/*customer = new Customer();
				customer.setCustomerId(getPkCustomerId());*/
				
				/* save company */
			    companyMaster = new CompanyMaster();
				companyMaster.setCompanyId(sessionStateManage.getCompanyId());
		
		
				
				/*CustomerEmploymentInfo custEmp = new CustomerEmploymentInfo();
		
				EmploymentType employmentType = new EmploymentType();
		
			
				employmentType.setEmploymentTypeId(getEmploymentType());*/
				//custEmp.setFsEmploymentType(employmentType);
				// langType = new LanguageType();
				countryMaster = new CountryMaster();
			    stateMaster = new StateMaster();
			    districtMaster = new DistrictMaster();
				cityMaster = new CityMaster();
				
				countryMaster.setCountryId(getEmpCountryId());
				stateMaster.setStateId(getEmpStateId());
				districtMaster.setDistrictId(getEmpDistrictId());
				cityMaster.setCityId(getEmpCityId());
				custEmp.setFsCompanyMaster(companyMaster);
				//custEmp.setFsCustomer(customer);
				//custEmp.setFsLanguageType(languageType);
				custEmp.setFsCountryMaster(countryMaster);
				custEmp.setFsStateMaster(stateMaster);
				custEmp.setFsDistrictMaster(districtMaster);
				custEmp.setFsCityMaster(cityMaster);
				custEmp.setOccupation(getOccupation());
				custEmp.setEmployerName(getEmployer());
				//custEmp.setFsEmploymentType(employmentType);
				custEmp.setDepartment(getDepartment());
				custEmp.setArea(getEmparea());
				custEmp.setBlock(getEmpInfoBlock());
				custEmp.setStreet(getEmpInfoStreet());
				custEmp.setOfficeTelephone(getOfficeTel());
				custEmp.setPostal(getPostalCode());
					}
				
				//custEmp.setCustEmpInfoId(getPkCustomerEmployeeId());
				
				custEmp.setCustEmpInfoId(getEmpInfoEmploymentTypeId());
				if (getEmpInfoEmploymentTypeId() != null) {
					//custEmp.setCustEmpInfoId(getPkCustomerEmployeeId());
					custEmp.setUpdatedBy(userName);
					custEmp.setLastUpdated(new Date());
				} else {
					custEmp.setCreatedBy(userName);
					custEmp.setCreationDate(new Date());
				}
				getIcustomerRegistrationService().saveCustomerEmploymentInfo(custEmp);
		
			
				} catch (NullPointerException npexp) {
					npexp.printStackTrace();
				} catch (Exception ioexp) {
					ioexp.printStackTrace();
				}
				
		
			}
		
			/**
			 * Save Customer ID proof
			 */
			public void saveProofDetails() throws IOException, ParseException {
				
				if (createProofList.size() == 0) {
				     setIdListcheck(true);
			    }else{
				    setIdListcheck(false);
				    
	    
				SessionStateManage sessionStateManage = new SessionStateManage();
				CustomerType customerType = new CustomerType();
				customerType.setCustomerTypeId(new BigDecimal("1"));
				customer = new Customer();
				customer.setCustomerId(getPkCustomerId());
				int languageID = 1;
				
				if (FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().containsKey("languageCode")) {
					languageID = FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap().get("languageCode").toString()
							.equalsIgnoreCase("ar") ? 2 : 1;
				}
		
				languageType = new LanguageType();
				languageType.setLanguageId(new BigDecimal(languageID));
		
				//IdentityType idType = null;
				IdentityType idType =new IdentityType();
		
				for (CreateProofTable createProofTable : createProofList) {
					//idType = new IdentityType();
					CustomerIdProof custProof = new CustomerIdProof();
					custProof.setFsCustomer(customer);
					custProof.setFsLanguageType(languageType);
					custProof.setFsCustomerType(customerType);
					
					
					System.out.println("the id value is in customer is"+createProofTable.getId_type());
					System.out.println("the id value is in customer id is"+createProofTable.getId_for());
					
					idType.setIdentityTypeId(new BigDecimal(createProofTable.getId_type()));
					
					custProof.setFsIdentityType(idType);
					
		
					DocumentImg imgDoc = new DocumentImg();
					imgDoc.setImgId(createProofTable.getImageId());
					custProof.setFsDocumentImg(imgDoc);
		
					custProof.setIdentityFor(createProofTable.getId_for());
					custProof.setIdentityInt(createProofTable.getId_number());
					custProof.setIdentityStatus("1");
				
					if (createProofTable.getChecked()) {
						custProof.setApprovedBy(userName);
						custProof.setApprovedDate(new Date());
					} else {
						custProof.setApprovedBy("0");
						custProof.setApprovedDate(new Date());
					}
					
					Date expDate = new SimpleDateFormat("dd/MM/yyyy").parse(createProofTable.getDate_expiary());
		
					custProof.setIdentityExpiryDate(expDate);
					//custProof.setCreatedBy(userName);
					//custProof.setCreationDate(new Date());
					
					custProof.setCustProofId(createProofTable.getCustomerIdProofId());
					  if(createProofTable.getCustomerIdProofId().intValue()!=0) {
			            	custProof.setUpdatedBy(userName);
			            	custProof.setLastUpdatedDate(new Date());
			            
			            } else {
			            	custProof.setCreatedBy(userName);
			    			custProof.setCreationDate(new Date());
			    			
			            }
					getIcustomerRegistrationService().saveCustomerIdProof(custProof);
				}
				
				for (CreateProofTable createProofTable : createProofListDelete) {
					//idType = new IdentityType();
					CustomerIdProof custProof = new CustomerIdProof();
					custProof.setFsCustomer(customer);
					custProof.setFsLanguageType(languageType);
					custProof.setFsCustomerType(customerType);
					
					
					System.out.println("the id value is in customer is"+createProofTable.getId_type());
					System.out.println("the id value is in customer id is"+createProofTable.getId_for());
					
					idType.setIdentityTypeId(new BigDecimal(createProofTable.getId_type()));
					
					custProof.setFsIdentityType(idType);
					
		
					DocumentImg imgDoc = new DocumentImg();
					imgDoc.setImgId(createProofTable.getImageId());
					custProof.setFsDocumentImg(imgDoc);
		
					custProof.setIdentityFor(createProofTable.getId_for());
					custProof.setIdentityInt(createProofTable.getId_number());
					custProof.setIdentityStatus("0");
				
					if (createProofTable.getChecked()) {
						custProof.setApprovedBy(userName);
						custProof.setApprovedDate(new Date());
					} else {
						custProof.setApprovedBy("0");
						custProof.setApprovedDate(new Date());
					}
					
					Date expDate = new SimpleDateFormat("dd/MM/yyyy").parse(createProofTable.getDate_expiary());
		
					custProof.setIdentityExpiryDate(expDate);
					//custProof.setCreatedBy(userName);
					//custProof.setCreationDate(new Date());
					
					custProof.setCustProofId(createProofTable.getCustomerIdProofId());
					  if(createProofTable.getCustomerIdProofId().intValue()!=0) {
			            	custProof.setUpdatedBy(userName);
			            	custProof.setLastUpdatedDate(new Date());
			            
			            } else {
			            	custProof.setCreatedBy(userName);
			    			custProof.setCreationDate(new Date());
			    			
			            }
					getIcustomerRegistrationService().saveCustomerIdProof(custProof);
				}
					
		   }
				
				//	getBranchpageService().saveOrUpdateCustomerIdProof(custProof);
				//}
		
				
			}
		
			/*
			 * method to fetch the record from db
			 */
			public String fetchCustomerInfo() {
		
				Calendar cal = new GregorianCalendar();
				cal.setTime(new Date());
				cal.add(Calendar.DAY_OF_MONTH, +90);
				Date today90 = cal.getTime();
				SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
				String finalDate = form.format(today90);
				setExpDateCheck(finalDate);
				SimpleDateFormat smpDate = new SimpleDateFormat("dd/MM/yyyy");
				SessionStateManage sessionStateManage = new SessionStateManage();
				setLanguageId(new BigDecimal(
						sessionStateManage.isExists("languageId") ? sessionStateManage
								.getSessionValue("languageId") : "" + 1));
				
				//setIdnumberProof(getIdNumber());
	           // setIdTypeproof(getIdType());
				
				try {
				
					customerIdProofList = getBranchpageService().getCustomerIdProof(
							getIdNumber());
					
					System.out.println("Fetch Data  ::::::::::::::::::::::::::::::::::::::"+customerIdProofList.size());
					
					idForMap.put("1", "Address Proof");
					idForMap.put("2", "Identity Proof");
					if (customerIdProofList.size() > 0) {
						getFetchIdType();
						setCustomerIdProof();
						setCustomerDetails();
						getFetchContactTypeList();
						fillCountryList();
						fillStateList();
						fillDistrictList();
						fillCityList();
						setContactDetails();
						setEmployeementInfo();
					} else {
					// setBooCustomerDetails(true);
					/*
					 * setRenderCustomeInfoEditable(true);
					 * setRenderCustomeInfoLocal(true); setRenderBasicInfo(false);
					 */
		
					// if(getSelectType().equalsIgnoreCase("1") &&
					// getSelectType()!=null){
	            	setIdnumberProof(getIdNumber());
		            setIdTypeproof(getIdType());
					setBooRemitterInfo(true);
					setBooIdDetail(false);
					setBooCustomerDetails(false);
					setBooContactDetails(false);
					setBooEmploymentDetails(false);
					setBooProof(false);
		
					
		
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "";
			}
		
		
			public void setCustomerIdProof() {
				System.out.println("Called");
				setPkCustomerId(customerIdProofList.get(0).getFsCustomer().getCustomerId());
				System.out.println("setted "+getPkCustomerId());
			
				//customerIdProofList.clear();
				
			
				CreateProofTable createProofTable = null;
				customerIdProofList.clear();
				customerIdProofList = getBranchpageService().getCustomerIdProofList(getPkCustomerId());
				
				System.out.println("List Value :::::::::::::::::::::"+customerIdProofList.size());
				
				for (Map.Entry<String, String> entry : idTypeMap.entrySet()) {
					System.out.println("Key : " + entry.getKey() + " Value : "
						+ entry.getValue());
				}
				
				
				createProofList.clear();
				for (CustomerIdProof customerIdProof : customerIdProofList) {
					createProofTable = new CreateProofTable();
					System.out.println(customerIdProof.getFsIdentityType().getIdentityTypeId().toString());
					
					
					System.out.println();
					
					System.out.println("the value is"+customerIdProof.getIdentityInt());
					createProofTable.setIdFor(idForMap.get(customerIdProof.getIdentityFor()));
					createProofTable.setId_for(customerIdProof.getIdentityFor());
					
					createProofTable.setId_number(customerIdProof.getIdentityInt());
					createProofTable.setIdType(idTypeMap.get(customerIdProof.getFsIdentityType().getIdentityTypeId().toString()));
					createProofTable.setImageId(customerIdProof.getFsDocumentImg().getImgId());
					//createProofTable.setCustomerIdProofId(customerIdProof.getCustProofId());
					createProofTable.setDate_expiary(new SimpleDateFormat(DATE_FORMAT).format(customerIdProof.getIdentityExpiryDate()));
					createProofTable.setId_type(customerIdProof.getFsIdentityType().getIdentityTypeId().toString());
					createProofTable.setCustomerIdProofId(customerIdProof.getCustProofId());
					
					if(customerIdProof.getApprovedBy()!= null) {
						if(customerIdProof.getApprovedBy().equalsIgnoreCase("0")) {
							createProofTable.setChecked(false);
						}else{
							createProofTable.setChecked(true);
						}
					} 
					
					createProofList.add(createProofTable);
					setBooidproofDatatable(true);
				}
		
			}
		
			public void setCustomerDetails() {
			
		
				customerList = getBranchpageService()
						.getCustomerInfo(getPkCustomerId());
		
	
				setNationality(customerList.get(0).getFsCountryMasterByNationality()
						.getCountryId());
				//setLevel(customerList.get(0).getFsArticleDetails().getArticleDetailId());
				setFirstName(customerList.get(0).getFirstName());
				setFirstNamel(customerList.get(0).getFirstNameLocal());
				setMiddleName(customerList.get(0).getMiddleName());
				setMiddleNamel(customerList.get(0).getMiddleNameLocal());
				setShortName(customerList.get(0).getShortName());
				setShortNamel(customerList.get(0).getShortNameLocal());
				setLastName(customerList.get(0).getLastName());
				setLastNamel(customerList.get(0).getLastNameLocal());
				setEmail(customerList.get(0).getEmail());
				setTitle(customerList.get(0).getTitle());
				setMobile(customerList.get(0).getMobile());
				setGender(customerList.get(0).getGender());
				setDob(customerList.get(0).getDateOfBirth());
				setAlternativeEmail(customerList.get(0).getAlterEmailId());
				setTitlel(customerList.get(0).getTitleLocal());
				//setCountryId(customerList.get(0).getFsCountryMasterByCountryId().getCountryId());
				
				System.out.println("Country _ Id "+getCountryId());
				//setCountryId(customerList.get(0).getFsCountryMasterByCountryId().getCountryId());
				// setC(customerList.get(0).getCreatedBy());
				// setCreatedDate(customerList.get(0).getCreationDate());
				setLevel(customerList.get(0).getFsArticleDetails().getArticleDetailId());
				
		
				setAMLStatus("pass");
				setNumberofhits("1");
				
				System.out.println("Activated IND : "+customerList.get(0).getActivatedInd());
				
				if (customerList.get(0).getActivatedInd().equalsIgnoreCase("0")) {
					setApproved(false);
				} else {
					setApproved(true);
				}
			}
		
			// Get country list and store into local map object 
			private void fillCountryList() {
		
				if (mapCountryList.size() == 0) {
					mapCountryList.clear();
				
					for (CountryMasterDesc countryMasterDesc : getGeneralService()
							.getCountryList(getLanguageId())) {
						mapCountryList.put(countryMasterDesc.getFsCountryMaster()
								.getCountryId(), countryMasterDesc.getCountryName());
					}
		
				}
			}
		
			// Get state list and store into local map object
			private void fillStateList() {
		
				if (mapStateList.size() == 0) {
					mapStateList.clear();
					for (StateMasterDesc stateMasterDesc : getGeneralService()
							.getStateList(languageId)) {
						mapStateList.put(stateMasterDesc.getFsStateMaster()
								.getStateId(), stateMasterDesc.getStateName());
					}
				}
			}
		
			// Get district list and store into local map object 
			private void fillDistrictList() {
		
				if (mapDistirictList.size() == 0) {
					mapDistirictList.clear();
					for (DistrictMasterDesc districtMasterDesc : getGeneralService()
							.getDistrictList(getLanguageId())) {
						mapDistirictList.put(districtMasterDesc.getFsDistrictMaster()
								.getDistrictId(), districtMasterDesc.getDistrict());
					}
				}
			}
		
			// Get city list and store into local map object
			private void fillCityList() {
		
				if (mapCityList.size() == 0) {
					mapCityList.clear();
					for (CityMasterDesc cityMasterDesc : getGeneralService()
							.getCityList(getLanguageId())) {
						mapCityList.put(cityMasterDesc.getFsCityMaster().getCityId(),
								cityMasterDesc.getCityName());
					}
				}
			}
		
			public void setContactDetails() {
				
				contactDetailList.addAll(getBranchpageService().getCustomerContactDetails(getPkCustomerId()));
		
				if (contactDetailList.size() > 0) {
					contactList.clear();
					for (ContactDetail cdetail : contactDetailList) {
						AddContactDetailBean addContactDetailBean = new AddContactDetailBean(
								
								cdetail.getFsContactType().getContactType(),
								cdetail.getArea(), 
								mapCountryList.get(cdetail.getFsCountryMaster().getCountryId()),
								cdetail.getStreet(), 
								cdetail.getBlock(),
								cdetail.getTelephone(), 
								cdetail.getFlat(),
								mapStateList.get(cdetail.getFsStateMaster().getStateId()), 
								mapDistirictList.get(cdetail.getFsDistrictMaster().getDistrictId()),
								mapCityList.get(cdetail.getFsCityMaster().getCityId()),
								false, false, cdetail.getFsContactType().getContactTypeId(), 
								cdetail.getFsCountryMaster().getCountryId(), 
								cdetail.getFsStateMaster().getStateId(), 
								cdetail.getFsDistrictMaster().getDistrictId(), 
								cdetail.getFsCityMaster().getCityId(),
								cdetail.getContactDetailId());
						
						contactList.add(addContactDetailBean);
						setContactDataTable(true);
					}
		
				}
				
				
				System.out.println("Final Size : "+contactList.size());
			}
		
			
			public void populateState() {
				sessionStateManage = new SessionStateManage();
				List<StateMasterDesc> statemasterDesc = getGeneralService().getStateList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpCountryId());
				setLstEmpStateList(statemasterDesc);
			}
			public void populateDistrict() {
				sessionStateManage = new SessionStateManage();
				List<DistrictMasterDesc> districtmasterDesc = getGeneralService().getDistrictList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpCountryId(),getEmpStateId());
			    setLstEmpDistrictList(districtmasterDesc);
			}
			public void populateCity() {
				sessionStateManage = new SessionStateManage();
				List<CityMasterDesc> citymasterDesc = getGeneralService().getCityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpCountryId(),getEmpStateId(),getEmpDistrictId());
			    setLstEmpCityList(citymasterDesc);
			}
			public void setEmployeementInfo() {
		
				
				customerEmploymentInfoList.addAll(getBranchpageService()
						.getCustomerEmploymentInfo(getPkCustomerId()));
				if (customerEmploymentInfoList.size() > 0) {
					setEmploymentType(customerEmploymentInfoList.get(0).getFsEmploymentType().getEmploymentTypeId());
					setEmpInfoEmploymentTypeId(customerEmploymentInfoList.get(0).getCustEmpInfoId());
					setOccupation(customerEmploymentInfoList.get(0).getOccupation());
					setEmployer(customerEmploymentInfoList.get(0).getEmployerName());
		
					setEmpCountryId(customerEmploymentInfoList.get(0).getFsCountryMaster().getCountryId());
					populateState();
					setEmpStateId(customerEmploymentInfoList.get(0).getFsStateMaster().getStateId());
					populateDistrict();
					setEmpDistrictId(customerEmploymentInfoList.get(0).getFsDistrictMaster().getDistrictId());
					populateCity();
					setEmpCityId(customerEmploymentInfoList.get(0).getFsCityMaster().getCityId());
					setEmpInfoStreet(customerEmploymentInfoList.get(0).getStreet());
					setPostalCode(customerEmploymentInfoList.get(0).getPostal());
					setEmpInfoBlock(customerEmploymentInfoList.get(0).getBlock());
					setEmparea(customerEmploymentInfoList.get(0).getArea());
					setOfficeTel(customerEmploymentInfoList.get(0).getOfficeTelephone());
					setDepartment(customerEmploymentInfoList.get(0).getDepartment());
		
				}
			}
		
			public void clear() {
		
				setIdType("");
				setIdNumber("");
				setSelectType("");
				setTitle("");
				setFirstName("");
				setLastName("");
				setMiddleName("");
				setShortName("");
				setTitlel("");
				setFirstNamel("");
				setLastNamel("");
				setMiddleNamel("");
				setShortNamel("");
				setNationality(null);
				setGender("");
				setMobile("");
				setEmail("");
				setAlternativeEmail("");
				setDob(null);
				setContactTypeId(null);
				setLocalArea("");
				setCountryId(null);
				setStreet("");
				setStateId(null);
				setTelephone("");
				setDistrictId(null);
				setFlat("");
				setCityId(null);
				setBlock("");
				setEmploymentType(null);
				setOccupation("");
				setEmployer("");
				setEmpInfoBlock("");
				setDepartment("");
		
			}
		
			
			public void clearFirst() {
		
				setIdType("");
				setIdNumber("");
				setSelectType("");
				setLevel(null);
				setArticle(null);
		
			}
		
			/*
			 * method is responsible foe Clear Remitter Information
			 */
			public void clearRemitterInfo() {
				
				setTitle("");
				setFirstName("");
				setLastName("");
				setMiddleName("");
				setShortName("");
				setTitlel("");
				setFirstNamel("");
				setLastNamel("");
				setMiddleNamel("");
				setShortNamel("");
				setNationality(null);
				setGender("");
				setMobile("");
				setEmail("");
				setAlternativeEmail("");
				setDob(null);
				setAMLStatus("");
				setNumberofhits("");
				
				
			}
			
			/*
			 * method is responsible foe Clear Contact Information
			 */
			public void clearContactDetail() {
				
				setContactTypeId(null);
				setLocalArea("");
				setCountryId(null);
				setStreet("");
				setStateId(null);
				setTelephone("");
				setDistrictId(null);
				setFlat("");
				setCityId(null);
				setBlock("");
			}
			
			
			/*
			 * method is responsible foe Clear Employment Information
			 */
			public void clearEmploymentInfo() {
				
				setEmploymentType(null);
				setOccupation("");
				setEmployer("");
				setEmpInfoBlock("");
				setEmparea("");
				setEmpCountryId(null);
				setEmpStateId(null);
				setEmpCityId(null);
				setEmpDistrictId(null);
				setEmpInfoStreet("");
				setOfficeTel("");
				setPostalCode("");
				setDepartment("");
			}
			
			/*
			 * method is responsible foe Clear Customer Proof Information
			 */
			public void clearProofInfo() {
	
				setIdTypeproof("");
				setIdTypeproof("");
				setIdnumberProof("");
				setDateExp(null);
			}
			
			/*
			 * method is responsible to add contact in a dataTable
			 */
			public void addContactDetailsDataTable() {
			
				AddContactDetailBean addContact = new AddContactDetailBean();
				addContact.setContactTypeId(this.contactTypeId);
				addContact.setContType(mapContactTypeList.get(this.contactTypeId));
			
				addContact.setCountryId(this.countryId);
				addContact.setCountry(mapCountryList.get(this.countryId));
				addContact.setStateId(this.stateId);
				addContact.setState(mapStateList.get(this.stateId));
				addContact.setDistrictId(this.districtId);
				addContact.setDist(mapDistirictList.get(this.districtId));
				addContact.setCityId(this.cityId);
				addContact.setCity(mapCityList.get(this.cityId));
				addContact.setArea(this.localArea);
				addContact.setStreet(this.street);
				addContact.setFlat(this.flat);
				addContact.setTel(this.telephone);
				addContact.setBlock(this.block);
				addContact.setContactDetailsId(new BigDecimal(0));
				contactList.add(addContact);
				setContactTypeId(null);
				setCountryId(null);
				setStateId(null);
				setDistrictId(null);
				setCityId(null);
				setLocalArea("");
				setStreet("");
				setBlock("");
				setTelephone("");
				setFlat("");
				setContactDataTable(true);
			}
		
			public void addRows() {
		
				try {
		
					idForMap.put("1", "Address Proof");
					idForMap.put("2", "Identity Proof");
		
					Blob blob = storeImage();
					int blobLength = (int) blob.length();
					//System.out.println("BlobLength" + blobLength);
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					InputStream stream = new ByteArrayInputStream(blobAsBytes);
					downloadFile = new DefaultStreamedContent(stream, "image/jpg",
							"image.jpg");
		
					// Save Image
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
					String df = dateformat.format(getDateExp());
					CreateProofTable createProofTable = new CreateProofTable(this.idFor, this.idTypeproof, this.idnumberProof, df,"insert", 0, idForMap.get(this.idFor),
							idTypeMap.get(this.idTypeproof), image_id);
					createProofTable.setCustomerIdProofId(new BigDecimal(0));
					createProofList.add(createProofTable);
		
					setBooidproofDatatable(true);
		
					// setExpDate(null);
					setDateExp(null);
					setIdTypeproof("");
					setIdnumberProof("");
					setIdFor("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			public void removeIdProof(CreateProofTable proofTable) {
				createProofList.remove(proofTable);
				createProofListDelete.add(proofTable);
			}
		
			public void removeContactDetail(AddContactDetailBean bean) {
				contactList.remove(bean);
				if (bean.getContactDetailsId() != new BigDecimal(0)) {
					contactListDelete.add(bean);
				}
			}
		
			public StreamedContent downloadFile(BigDecimal imageId) {
		
				StreamedContent image = null;
				try {
		
					image = getImage(imageId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return image;
			}
		
			public StreamedContent getImage(BigDecimal imageId) {
				try {
					if (imageId.toPlainString().length() > 0 && imageId != null) {
						Blob blob = getBranchpageService().getImage(imageId).get(0)
								.getImage();
						String imageNameWithExtention = getBranchpageService()
								.getImage(imageId).get(0).getImageName();
						String imageExtention = imageNameWithExtention
								.substring(imageNameWithExtention.lastIndexOf("."));
						String imagename = imageNameWithExtention.substring(0,
								imageNameWithExtention.lastIndexOf(".") - 1);
						// System.out.println("imageExtention  :"+imageExtention+"image name :"+imagename);
						int blobLength = (int) blob.length();
						byte[] blobAsBytes = blob.getBytes(1, blobLength);
						InputStream stream = new ByteArrayInputStream(blobAsBytes);
						downloadFile = new DefaultStreamedContent(stream, "image/jpg",
								imagename + imageExtention);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return downloadFile;
			}
		
			/*public void getNominee(){
				
				if(getNomineeApprove()){
					
					setBoonomeneeCheck(true);
				}else{
				
					
					setBoonomeneeCheck(false);
				
				}	
			}
*/
			public boolean getNomineeApprove() {
				return nomineeApprove;
			}

			public void setNomineeApprove(boolean nomineeApprove) {
				this.nomineeApprove = nomineeApprove;
			}
			
			
			
			private BigDecimal article = null;
			private BigDecimal level = null;
			private List<ArticleDetails> lstLevel = new ArrayList<ArticleDetails>(); 
			private BigDecimal customerIdToNominee = null;
			private Boolean nominee = false;
			
			@Autowired
			NomineeRegistration nomineeRegistration;
			
			public NomineeRegistration getNomineeRegistration() {
				return nomineeRegistration;
			}
			public void setNomineeRegistration(NomineeRegistration nomineeRegistration) {
				this.nomineeRegistration = nomineeRegistration;
			}
			
			public BigDecimal getArticle() {
				return article;
			}

			public void setArticle(BigDecimal article) {
				this.article = article;
			}

			public BigDecimal getLevel() {
				return level;
			}

			public void setLevel(BigDecimal level) {
				this.level = level;
			}
			
			

			public List<ArticleDetails> getLevelData() {
				return lstLevel;
			}
			

			public BigDecimal getCustomerIdToNominee() {
				return customerIdToNominee;
			}

			public void setCustomerIdToNominee(BigDecimal customerIdToNominee) {
				this.customerIdToNominee = customerIdToNominee;
			}

			/**
			 * This method will call on on change of Article 
			 */
			public void generateLevel() {
				lstLevel = getBranchpageService().getLevelData(getArticle());
			}
			
			public List<ArticleMaster> getArticleData() {
				List<ArticleMaster> lstArticles = getBranchpageService().getArtilces();
				return lstArticles;
			}

			public Boolean getNominee() {
				return nominee;
			}

			public void setNominee(Boolean nominee) {
			
				this.nominee = nominee;
			}

			
			public void ShowFromSearchPage(String civil_id, String id_type) {
				//setBooIdTypeCheck(false);
				setIdType(id_type);
				setIdNumber(civil_id);
			}
			
		}
