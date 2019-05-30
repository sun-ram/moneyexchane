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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.common.TokenGeneration;
import com.amg.exchange.mail.ApplicationMailer;
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
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.service.IRemmiterOnlineRegService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@Component("remmiterInfo")
@Scope("session")
public class RemmiterInfoManageBean<T> implements Serializable {  
	
	/** logger class name setting */
	Logger log = Logger.getLogger(RemmiterInfoManageBean.class);
 
	/** serial UID settings **/
	private static final long serialVersionUID = 1L;
	
	private BigDecimal pkCustomerIdProof = null;
	private String idNumber = null;
	private Date idExpDate = null;
	private String fsCustomerIdProofCreatedBy = null;
	private Date fsCustomerIdProofCreatedDate = null;
	
	private BigDecimal pkCustomerId = null;
	private String expDateCheck = null;
	private String showDob = null;
	
	private BigDecimal pkImage = null;
	private UploadedFile file = null;
	private StreamedContent downloadFile = null; 
	
	private String title = null;
	private String firstName = null;
	private String middleName = null;
	private String lastName = null;
	private String shortName = null;
	private String localTitle = null;
	private String localFirstName = null;
	private String localMiddleName = null;
	private String localLastName = null;
	private String localShortName = null;
	private BigDecimal nationality = null;
	private String gender = null;
	private String mobileNo = null;
	private String email = null;
	private String alternateEmail = null;
	private Date dateOfBirth = null;
	private String fsCustomerCreatedBy = null;
	private Date fsCustomerCreatedDate = null;
	
	public BigDecimal pkCustomerEmployeeId = null;
	private BigDecimal employmentType = null;
	private String occupation = null;
	private String department = null;
	private String employer = null;
	private String blockNo = null;
	private String streetNo = null;
	private String area = null;
	private String officeTelNo = null;
	private BigDecimal country = null;
	private BigDecimal state = null;
	private BigDecimal district = null;
	private BigDecimal city = null;
	private String postalCode = null;
	private String fsCustomerEmpCreatedBy = null;
	private Date fsCustomerEmpCreatedDate = null;
	
	public BigDecimal pkCustomerContactDetails = null;
	private BigDecimal contactType = null;
	private String contactLocalArea = null;
	private BigDecimal contactCountry = null;
	private String contactStreetNo = null;
	private BigDecimal contactState = null;
	private String contactTelephoneNo = null;
	private BigDecimal contactDistrict = null;
	private String contactFlat = null;
	private BigDecimal contactCity = null;
	private String contactBlockNo = null;
	private String fsCustomerContactDetilsCreatedBy = null;
	private Date fsCustomerContactDetilsCreatedDate = null;
	
	/**These booleans are responsible to render panels*/ 
	private Boolean booPersonalInformation = true;
	private Boolean booEmploymentInformation = false;
	private Boolean booContactDetails = false;
	
	/**Responsible to populate State,District, City in Employment Info*/
	private List<StateMasterDesc> lstStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstCityList = new ArrayList<CityMasterDesc>();
	
	/**Responsible to populate State,District, City in Contact Details*/
	private List<StateMasterDesc> lstContactStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstContactDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstContactCityList = new ArrayList<CityMasterDesc>();
	
	/**Responsible to hold Contact Type in that list */
	private List<ContactType> lstContactType = new ArrayList<ContactType>();
	
	/**This is responsible to get track upto which panel user has given input, default is first panel, that is 1*/
	private int saveUptoPanel = 1;
	
	/**Responsible to make readonly Civil ID fields, for existing customer*/ 
	private Boolean booReadonlyIdNumber = false;
	
	 /**Responsible to render the Employment Panel depending upon Employment type*/
	private Boolean booEmploymentPanel = true;
	
	 /**Responsible to disable save button when once the customer has gone to branch*/
	private Boolean booDisableSave = false;
	
	/**This variable is responsible to track that, data is already there in database or not*/
	private Boolean booViewed = false;
	
	/**This is responsible to show validation msg depending upon uploaded file type*/  
	private Boolean booImageValidation = false; 
	
	/**Responsible to show icon for showing image in growl where there is some image already stored in database*/
	private Boolean booHasImage = false;
	
	/**This is responsible to Check dupliacte Contact Details*/ 
	private Boolean booContactDetailsDuplicate= false;
	
	/**Responsible to populate data*/
	private List<Customer> lstCustomer = new ArrayList<Customer>();
	private List<CustomerEmploymentInfo> lstCustomerEmployment = new ArrayList<CustomerEmploymentInfo>();
	private List<CustomerIdProof> lstCustomerIdProof = new ArrayList<CustomerIdProof>();
	private List<ContactDetail> lstContactDetailsModel = new ArrayList<ContactDetail>();
	
	/**Responsible to holds all the contact Details Object, both Adding and fetching time*/ 
	private List<ContactDetails> lstContactDetails = new ArrayList<ContactDetails>(); 

	/**Responsible to format Date*/
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	 /**Responsible to manage session*/
	SessionStateManage sessionStateManage = new SessionStateManage();
	
	/**Responsible to support save controller*/
	private CountryMaster countryMaster = null;
	private CompanyMaster companyMaster = null;
	private Customer customer = null;
	
	/**For managing image save*/ 
	private DocumentImg image = null;
	
	/**These maps are required for, showing String in Datatable, but in database ID will save*/
	private Map<BigDecimal,String>	mapContactType = new HashMap<BigDecimal,String>();
	private Map<BigDecimal,String>	mapCountry = new HashMap<BigDecimal,String>();
	private Map<BigDecimal,String>	mapState = new HashMap<BigDecimal,String>();
	private Map<BigDecimal,String>	mapDistrict = new HashMap<BigDecimal,String>();
	private Map<BigDecimal,String>	mapCity = new HashMap<BigDecimal,String>();
	
	/**Holding the component Behavior*/
	private Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	
	/**setting token*/
	private String tokenKey = null;
	private TokenGeneration tokenGeneration = new TokenGeneration();
	
	/**
	 * Responsible to Check Civil ID is already registered or not
	 */
	private Boolean booRegistered = false;
	
	@Autowired
	IRemmiterOnlineRegService<T> remOnlineReg;
	public IRemmiterOnlineRegService<T> getRemOnlineReg() {
		return remOnlineReg;
	}
	public void setRemOnlineReg(IRemmiterOnlineRegService<T> remOnlineReg) {
		this.remOnlineReg = remOnlineReg;
	}
	
	@Autowired
	IGeneralService<T> iGeneralService;
	public IGeneralService<T> getiGeneralService() {
		return iGeneralService;
	}
	public void setiGeneralService(IGeneralService<T> iGeneralService) {
		this.iGeneralService = iGeneralService;
	}

	@Autowired
	ApplicationMailer mailService;
	public ApplicationMailer getMailService() {
		return mailService;
	}
	public void setMailService(ApplicationMailer mailService) {
		this.mailService = mailService;
	}
	
	@Autowired
	public TokenGeneration getTokenGeneration() {
		return tokenGeneration;
	}

	public void setTokenGeneration(TokenGeneration tokenGeneration) {
		this.tokenGeneration = tokenGeneration;
	}
	
	public BigDecimal getPkCustomerIdProof() {
		return pkCustomerIdProof;
	}
	public void setPkCustomerIdProof(BigDecimal pkCustomerIdProof) {
		this.pkCustomerIdProof = pkCustomerIdProof;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getIdExpDate() {
		return idExpDate;
	}
	public void setIdExpDate(Date idExpDate) {
		this.idExpDate = idExpDate;
	}
	
	public String getFsCustomerIdProofCreatedBy() {
		return fsCustomerIdProofCreatedBy;
	}
	public void setFsCustomerIdProofCreatedBy(String fsCustomerIdProofCreatedBy) {
		this.fsCustomerIdProofCreatedBy = fsCustomerIdProofCreatedBy;
	}
	
	public Date getFsCustomerIdProofCreatedDate() {
		return fsCustomerIdProofCreatedDate;
	}
	public void setFsCustomerIdProofCreatedDate(Date fsCustomerIdProofCreatedDate) {
		this.fsCustomerIdProofCreatedDate = fsCustomerIdProofCreatedDate;
	}
	
	public String getExpDateCheck() {
		return expDateCheck;
	}
	public void setExpDateCheck(String expDateCheck) {
		this.expDateCheck = expDateCheck;
	}
	
	public BigDecimal getPkCustomerId() {
		return pkCustomerId;
	}
	public void setPkCustomerId(BigDecimal pkCustomerId) {
		this.pkCustomerId = pkCustomerId;
	}
	
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public BigDecimal getPkImage() {
		return pkImage;
	}
	public void setPkImage(BigDecimal pkImage) {
		this.pkImage = pkImage;
	}
	
	public StreamedContent getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(StreamedContent downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLocalTitle() {
		return localTitle;
	}
	public void setLocalTitle(String localTitle) {
		this.localTitle = localTitle;
	}

	public String getLocalFirstName() {
		return localFirstName;
	}
	public void setLocalFirstName(String localFirstName) {
		this.localFirstName = localFirstName;
	}

	public String getLocalMiddleName() {
		return localMiddleName;
	}
	public void setLocalMiddleName(String localMiddleName) {
		this.localMiddleName = localMiddleName;
	}

	public String getLocalLastName() {
		return localLastName;
	}
	public void setLocalLastName(String localLastName) {
		this.localLastName = localLastName;
	}

	public String getLocalShortName() {
		return localShortName;
	}
	public void setLocalShortName(String localShortName) {
		this.localShortName = localShortName;
	}

	public BigDecimal getNationality() {
		return nationality;
	}
	public void setNationality(BigDecimal nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFsCustomerCreatedBy() {
		return fsCustomerCreatedBy;
	}
	public void setFsCustomerCreatedBy(String fsCustomerCreatedBy) {
		this.fsCustomerCreatedBy = fsCustomerCreatedBy;
	}
	
	public Date getFsCustomerCreatedDate() {
		return fsCustomerCreatedDate;
	}
	public void setFsCustomerCreatedDate(Date fsCustomerCreatedDate) {
		this.fsCustomerCreatedDate = fsCustomerCreatedDate;
	}
	
	public BigDecimal getPkCustomerEmployeeId() {
		return pkCustomerEmployeeId;
	}
	public void setPkCustomerEmployeeId(BigDecimal pkCustomerEmployeeId) {
		this.pkCustomerEmployeeId = pkCustomerEmployeeId;
	}
	
	public BigDecimal getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(BigDecimal employmentType) {
		this.employmentType = employmentType;
	}

	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getOfficeTelNo() {
		return officeTelNo;
	}
	public void setOfficeTelNo(String officeTelNo) {
		this.officeTelNo = officeTelNo;
	}

	public BigDecimal getCountry() {
		return country;
	}
	public void setCountry(BigDecimal country) {
		this.country = country;
	}

	public BigDecimal getState() {
		return state;
	}
	public void setState(BigDecimal state) {
		this.state = state;
	}

	public BigDecimal getDistrict() {
		return district;
	}
	public void setDistrict(BigDecimal district) {
		this.district = district;
	}

	public BigDecimal getCity() {
		return city;
	}
	public void setCity(BigDecimal city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getFsCustomerEmpCreatedBy() {
		return fsCustomerEmpCreatedBy;
	}
	public void setFsCustomerEmpCreatedBy(String fsCustomerEmpCreatedBy) {
		this.fsCustomerEmpCreatedBy = fsCustomerEmpCreatedBy;
	}
	
	public Date getFsCustomerEmpCreatedDate() {
		return fsCustomerEmpCreatedDate;
	}
	public void setFsCustomerEmpCreatedDate(Date fsCustomerEmpCreatedDate) {
		this.fsCustomerEmpCreatedDate = fsCustomerEmpCreatedDate;
	}
	
	public BigDecimal getPkCustomerContactDetails() {
		return pkCustomerContactDetails;
	}
	public void setPkCustomerContactDetails(BigDecimal pkCustomerContactDetails) {
		this.pkCustomerContactDetails = pkCustomerContactDetails;
	}
	
	public BigDecimal getContactType() {
		return contactType;
	}
	public void setContactType(BigDecimal contactType) {
		this.contactType = contactType;
	}

	public String getContactLocalArea() {
		return contactLocalArea;
	}
	public void setContactLocalArea(String contactLocalArea) {
		this.contactLocalArea = contactLocalArea;
	}

	public BigDecimal getContactCountry() {
		return contactCountry;
	}
	public void setContactCountry(BigDecimal contactCountry) {
		this.contactCountry = contactCountry;
	}

	public String getContactStreetNo() {
		return contactStreetNo;
	}
	public void setContactStreetNo(String contactStreetNo) {
		this.contactStreetNo = contactStreetNo;
	}

	public BigDecimal getContactState() {
		return contactState;
	}
	public void setContactState(BigDecimal contactState) {
		this.contactState = contactState;
	}

	public String getContactTelephoneNo() {
		return contactTelephoneNo;
	}
	public void setContactTelephoneNo(String contactTelephoneNo) {
		this.contactTelephoneNo = contactTelephoneNo;
	}

	public BigDecimal getContactDistrict() {
		return contactDistrict;
	}
	public void setContactDistrict(BigDecimal contactDistrict) {
		this.contactDistrict = contactDistrict;
	}

	public String getContactFlat() {
		return contactFlat;
	}
	public void setContactFlat(String contactFlat) {
		this.contactFlat = contactFlat;
	}

	public BigDecimal getContactCity() {
		return contactCity;
	}
	public void setContactCity(BigDecimal contactCity) {
		this.contactCity = contactCity;
	}

	public String getContactBlockNo() {
		return contactBlockNo;
	}
	public void setContactBlockNo(String contactBlockNo) {
		this.contactBlockNo = contactBlockNo;
	}
	
	public String getFsCustomerContactDetilsCreatedBy() {
		return fsCustomerContactDetilsCreatedBy;
	}
	public void setFsCustomerContactDetilsCreatedBy(String fsCustomerContactDetilsCreatedBy) {
		this.fsCustomerContactDetilsCreatedBy = fsCustomerContactDetilsCreatedBy;
	}
	
	public Date getFsCustomerContactDetilsCreatedDate() {
		return fsCustomerContactDetilsCreatedDate;
	}
	public void setFsCustomerContactDetilsCreatedDate(
			Date fsCustomerContactDetilsCreatedDate) {
		this.fsCustomerContactDetilsCreatedDate = fsCustomerContactDetilsCreatedDate;
	}
	
	public String getShowDob() {
		return showDob;
	}
	public void setShowDob(String showDob) {
		this.showDob = showDob;
	}

	public Boolean getBooPersonalInformation() {
		return booPersonalInformation;
	}
	public void setBooPersonalInformation(Boolean booPersonalInformation) {
		this.booPersonalInformation = booPersonalInformation;
	}
	
	public Boolean getBooEmploymentInformation() {
		return booEmploymentInformation;
	}
	public void setBooEmploymentInformation(Boolean booEmploymentInformation) {
		this.booEmploymentInformation = booEmploymentInformation;
	}
	
	public Boolean getBooContactDetails() {
		return booContactDetails;
	}
	public void setBooContactDetails(Boolean booContactDetails) {
		this.booContactDetails = booContactDetails;
	}
	
	public int getSaveUptoPanel() {
		return saveUptoPanel;
	}
	public void setSaveUptoPanel(int saveUptoPanel) {
		this.saveUptoPanel = saveUptoPanel;
	}
	
	public Boolean getBooReadonlyIdNumber() {
		return booReadonlyIdNumber;
	}
	public void setBooReadonlyIdNumber(Boolean booReadonlyIdNumber) {
		this.booReadonlyIdNumber = booReadonlyIdNumber;
	}
	
	public Boolean getBooEmploymentPanel() {
		return booEmploymentPanel;
	}
	public void setBooEmploymentPanel(Boolean booEmploymentPanel) {
		this.booEmploymentPanel = booEmploymentPanel;
	}
	
	public Boolean getBooDisableSave() {
		return booDisableSave;
	}
	public void setBooDisableSave(Boolean booDisableSave) {
		this.booDisableSave = booDisableSave;
	}
	
	public Boolean getBooViewed() {
		return booViewed;
	}
	public void setBooViewed(Boolean booViewed) {
		this.booViewed = booViewed;
	}
	
	public Boolean getBooImageValidation() {
		return booImageValidation;
	}
	public void setBooImageValidation(Boolean booImageValidation) {
		this.booImageValidation = booImageValidation;
	}
	
	public Boolean getBooHasImage() {
		return booHasImage;
	}
	public void setBooHasImage(Boolean booHasImage) {
		this.booHasImage = booHasImage;
	}
	
	public Boolean getBooContactDetailsDuplicate() {
		return booContactDetailsDuplicate;
	}
	public void setBooContactDetailsDuplicate(Boolean booContactDetailsDuplicate) {
		this.booContactDetailsDuplicate = booContactDetailsDuplicate;
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
	
	public List<CityMasterDesc> getLstCityList() {
		return lstCityList;
	}
	public void setLstCityList(List<CityMasterDesc> lstCityList) {
		this.lstCityList = lstCityList;
	}
	
	public List<StateMasterDesc> getLstContactStateList() {
		return lstContactStateList;
	}
	public void setLstContactStateList(List<StateMasterDesc> lstContactStateList) {
		this.lstContactStateList = lstContactStateList;
	}
	
	public List<DistrictMasterDesc> getLstContactDistrictList() {
		return lstContactDistrictList;
	}
	public void setLstContactDistrictList(	List<DistrictMasterDesc> lstContactDistrictList) {
		this.lstContactDistrictList = lstContactDistrictList;
	}
	
	public List<CityMasterDesc> getLstContactCityList() {
		return lstContactCityList;
	}
	public void setLstContactCityList(List<CityMasterDesc> lstContactCityList) {
		this.lstContactCityList = lstContactCityList;
	}
	
	public List<ContactType> getLstContactType() {
		return lstContactType;
	}
	public void setLstContactType(List<ContactType> lstContactType) {
		this.lstContactType = lstContactType;
	}
	
	public List<Customer> getLstCustomer() {
		return lstCustomer;
	}
	public void setLstCustomer(List<Customer> lstCustomer) {
		this.lstCustomer = lstCustomer;
	}
	
	public List<CustomerEmploymentInfo> getLstCustomerEmployment() {
		return lstCustomerEmployment;
	}
	public void setLstCustomerEmployment(List<CustomerEmploymentInfo> lstCustomerEmployment) {
		this.lstCustomerEmployment = lstCustomerEmployment;
	}
	
	public List<CustomerIdProof> getLstCustomerIdProof() {
		return lstCustomerIdProof;
	}
	public void setLstCustomerIdProof(List<CustomerIdProof> lstCustomerIdProof) {
		this.lstCustomerIdProof = lstCustomerIdProof;
	}
	
	public List<ContactDetail> getLstContactDetailsModel() {
		return lstContactDetailsModel;
	}
	public void setLstContactDetailsModel(List<ContactDetail> lstContactDetailsModel) {
		this.lstContactDetailsModel = lstContactDetailsModel;
	}
	
	public Map<BigDecimal, String> getMapContactType() {
		return mapContactType;
	}
	public void setMapContactType(Map<BigDecimal, String> mapContactType) {
		this.mapContactType = mapContactType;
	}
	
	public Map<BigDecimal, String> getMapCountry() {
		return mapCountry;
	}
	public void setMapCountry(Map<BigDecimal, String> mapCountry) {
		this.mapCountry = mapCountry;
	}
	
	public Map<BigDecimal, String> getMapState() {
		return mapState;
	}
	public void setMapState(Map<BigDecimal, String> mapState) {
		this.mapState = mapState;
	}
	
	public Map<BigDecimal, String> getMapDistrict() {
		return mapDistrict;
	}
	public void setMapDistrict(Map<BigDecimal, String> mapDistrict) {
		this.mapDistrict = mapDistrict;
	}
	
	public Map<BigDecimal, String> getMapCity() {
		return mapCity;
	}
	public void setMapCity(Map<BigDecimal, String> mapCity) {
		this.mapCity = mapCity;
	}
	
	public String getTokenKey() {
		return tokenKey;
	}
	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}
	
	public List<ContactDetails> getLstContactDetails() {
		return lstContactDetails;
	}
	
	public Boolean getBooRegistered() {
		return booRegistered;
	}
	public void setBooRegistered(Boolean booRegistered) {
		this.booRegistered = booRegistered;
	}
	
	/**
	 * Responsible to populate nationality
	 * @return
	 */
	public List<CountryMasterDesc> getNationalityList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> lstCountry = getiGeneralService().getNationalityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		return lstCountry;
	}
	
	/**
	 * Responsible to populate Country
	 * @return
	 */
	public List<CountryMasterDesc> getCountryNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> lstCountry = getiGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		/**we will utilize the map in contact details at adding time, we will show country name and  will id in database */
		for (CountryMasterDesc countryMasterDesc : lstCountry) {
			mapCountry.put(countryMasterDesc.getCountryMasterId(), countryMasterDesc.getCountryName());
		}
		return lstCountry;
	}
	
	/**
	 * clear Personal Information
	 */
	public void clearPersonalInformation() {
				//setIdNumber("");
				setIdExpDate(null);
				//setShowDob("");
				//setFileUpload
				setTitle("");
				setFirstName("");
				setMiddleName("");
				setLastName("");
				setShortName("");
				setLocalTitle("");
				setLocalFirstName("");
				setLocalMiddleName("");
				setLocalLastName("");
				setLocalShortName("");
				setNationality(null);
				setGender("");
				setMobileNo("");
				//setEmail("");
				setAlternateEmail("");
	}
	
	/********************************************FOR EMPLOYEMNT DETAILS*****************************************************/
	/**
	 * Responsible to prepare stateList by country change, Country List is common for Both Employment And Contact Details
	 * @param event
	 */
	public void generateStateList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getiGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountry()); 
		setLstStateList(stateMaster);
		
		/***reset State, District, City, as country is changing*/ 
		setState(null);
		setDistrict(null);
		setCity(null);
		
		setLstDistrictList(null);
		setLstCityList(null);
	}
	
	/**
	 * Responsible to populate District depending upon state selection
	 * @param event
	 */
	public void generateDistrictList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getiGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountry(), getState()
				);
		setLstDistrictList(lstDistrict);
		
		/**reset District, City, as state is changing*/ 
		setDistrict(null);
		setCity(null);
	}
	
	/**
	 * Responsible to populate city depending upon district selection
	 * @param event
	 */
	public void generateCityList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																												getCountry(),	 getState(), getDistrict()
				); 
		setLstCityList(lstCity);
		
	}
	
	/**
	 * This method will call when city change happen
	 * It's a do-nothing method, except this after click back button,  selected cityId will not bind with bean  
	 * @param event
	 */
	public void getCity(AjaxBehaviorEvent event) {}
	
	/**
	 * This method is responsible to populate State depending upon country selection
	 */
	private void populateState() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getiGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountry()); 
		setLstStateList(stateMaster);
	}
	
	/**
	 * This method is responsible to populate district depending upon state election 
	 */
	private void populateDistrict() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getiGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountry(), getState()
				);
		setLstDistrictList(lstDistrict);
	}
	
	/**
	 * This method is responsible to populate City depending upon district selection 
	 */
	private void populateCity() {
		System.out.println("populate City called : "+getDistrict());
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																												getCountry(),	getState(),getDistrict()
				); 
		
		for (CityMasterDesc cityMasterDesc : lstCity) {
			System.out.println(cityMasterDesc.getCityName());
		}
		
		setLstCityList(lstCity);
	}
	
	/**
	 * Responsible to populate Employment Type
	 * @return
	 */
	public List<EmploymentType> getEmploymentTypeList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		return getiGeneralService().getEmploymentTypes(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
	}
	
	/**
	 * This is responsible to render Panel, depending upon Employment Type selection
	 * @param event
	 */
	public void getEmploymentStatus(AjaxBehaviorEvent event) {
		/***3 means unemployed and 0 means Select*/
		System.out.println("Enter : "+getEmploymentType());
		if(getEmploymentType().intValue() == 3 || getEmploymentType().intValue() == 0) {
			setBooEmploymentPanel(false);
		} else {
			setBooEmploymentPanel(true);
		}
	}
	
	/**Responsible to clear only Employment Details Fields*/
	public void clearEmploymentDetails() {
		setEmploymentType(null);
		setOccupation("");
		setEmployer("");
		setBlockNo("");
		setStreetNo("");
		setArea("");
		setOfficeTelNo("");
		setCountry(null);
		setState(null);
		setDistrict(null);
		setCity(null);
		setPostalCode("");
		setDepartment("");
	}
	
	/********************************************FOR CONTACT DETAILS*****************************************************/
	
	/**
	 * Responsible to get all the Contact Type, and populate in Map
	 * @return
	 */
	public List<ContactType> getFetchContactTypeList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<ContactType>  lstContactType =  getiGeneralService().getContactTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		/**we will use this map when we will do ADD for Contact details ADD*/
		for (ContactType contactType : lstContactType) {
			mapContactType.put(contactType.getContactTypeId(), contactType.getContactType());
		}
		setLstContactType(lstContactType);
		return getLstContactType();
	}
	
	/**
	 * Responsible to prepare stateList by country change
	 * @param event
	 */
	public void generateContactStateList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getiGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getContactCountry()); 
		setLstContactStateList(stateMaster);
		
		/**We will use this map at Adding time in Contact Details*/
		for (StateMasterDesc stateMasterDesc : stateMaster) {
			mapState.put(stateMasterDesc.getStateDescId(), stateMasterDesc.getStateName());
		}
		
		/**reset State, District, City, as country is changing*/ 
		setContactState(null);
		setContactDistrict(null);
		setContactCity(null);
		
		setLstContactDistrictList(null);
		setLstContactCityList(null);
	}
	
	/**
	 * Responsible to populate District depending upon state selection
	 * @param event
	 */
	public void generateContactDistrictList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getiGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getContactCountry(), getContactState()
				);
		setLstContactDistrictList(lstDistrict);
		
		/**We will use in Add time in Contact Details*/
		for (DistrictMasterDesc districtMasterDesc : lstDistrict) {
			mapDistrict.put(districtMasterDesc.getDistrictDescId(), districtMasterDesc.getDistrict());
		}
		
		/**reset District, City, as state is changing*/ 
		setContactDistrict(null);
		setContactCity(null);
	}
	
	/**
	 * Responsible to populate city depending upon district selection
	 * @param event
	 */
	public void generateContactCityList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																									getContactCountry(),	 getContactState(), getContactDistrict()
				); 
		setLstContactCityList(lstCity);
		
		/**We will use Adding time*/
		for (CityMasterDesc cityMasterDesc : lstCity) {
			mapCity.put(cityMasterDesc.getCityMasterId(), cityMasterDesc.getCityName());
		}
	}
	
	/**
	 * This method will call when city change happen
	 * It's a do-nothing method, except this after click back button,  selected cityId will not bind with bean  
	 * @param event
	 */
	public void getContactCity(AjaxBehaviorEvent event) {}
	
	/**
	 * This method is responsible to populate State depending upon country selection
	 */
	private void populateContactState() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getiGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getContactCountry()); 
		
		for (StateMasterDesc stateMasterDesc : stateMaster) {
			mapState.put(stateMasterDesc.getStateDescId(), stateMasterDesc.getStateName());
		}
		
		setLstContactStateList(stateMaster);
	}
	
	/**
	 * This method is responsible to populate district depending upon state election 
	 */
	private void populateContactDistrict() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getiGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getContactCountry(), getContactState()
				);
		
		for (DistrictMasterDesc districtMasterDesc : lstDistrict) {
			mapDistrict.put(districtMasterDesc.getDistrictDescId(), districtMasterDesc.getDistrict());
		}
		
		setLstContactDistrictList(lstDistrict);
	}
	
	/**
	 * This method is responsible to populate City depending upon district selection 
	 */
	private void populateContactCity() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																												getContactCountry(),	getContactState(),getContactDistrict()
				); 
		
		for (CityMasterDesc cityMasterDesc : lstCity) {
			mapCity.put(cityMasterDesc.getCityMasterId(), cityMasterDesc.getCityName());
		}
		
		setLstContactCityList(lstCity);
	}
	
	/**
	 * Responsible to Add Contact Details, when ADD button is pressed
	 */
	public void addContactDetails() {
		/**This boolean is responsible to show and off the duplicate record message*/ 
		setBooContactDetailsDuplicate(false);
		for (ContactDetails contactDetails : lstContactDetails) {
			
			/**System.out.println(getContactType().intValue()+"===="+contactDetails.getContactType().intValue()+"/////////"+ 
					getContactCountry().intValue()+"===="+contactDetails.getCountry().intValue()+"/////////"+
					getContactState().intValue()+"===="+contactDetails.getState().intValue()+"/////////"+
					getContactDistrict().intValue()+"===="+contactDetails.getDistrict().intValue()+"/////////"+
					getContactCity().intValue()+"===="+ contactDetails.getCity().intValue()+"/////////"+
					getContactLocalArea()+"===="+contactDetails.getLocalArea()+"/////////"+
					getContactStreetNo()+"===="+contactDetails.getStreet()+"/////////"+ 
					getContactFlat()+"===="+contactDetails.getFlat() +"/////////"+
					getContactTelephoneNo()+"===="+contactDetails.getTelephone() +"/////////"+
					getContactBlockNo()+"===="+contactDetails.getBlock());*/
			
			/**Checking of duplicate records*/ 
			if(getContactType().intValue()==contactDetails.getContactType().intValue() && 
					getContactCountry().intValue()==contactDetails.getCountry().intValue()&&
					getContactState().intValue()==contactDetails.getState().intValue()&&
					getContactDistrict().intValue()==contactDetails.getDistrict().intValue()&&
					getContactCity().intValue()== contactDetails.getCity().intValue()&&
					getContactLocalArea().equalsIgnoreCase(contactDetails.getLocalArea())&&
					getContactStreetNo().equalsIgnoreCase(contactDetails.getStreet()) && 
					getContactFlat().equalsIgnoreCase(contactDetails.getFlat()) &&
					getContactTelephoneNo().equalsIgnoreCase(contactDetails.getTelephone()) &&
					getContactBlockNo().equalsIgnoreCase(contactDetails.getBlock())) {
				
				/**Showing the Duplicate record message*/
				setBooContactDetailsDuplicate(true);
				break;
			}
		}
		
		/**If not duplicate then we will add the record in datatable*/
		if(!getBooContactDetailsDuplicate()) {
			ContactDetails contactDetails = new ContactDetails(getContactType(), mapContactType.get(getContactType()), 
																						getContactCountry(), mapCountry.get(getContactCountry()), 
																						getContactState(), mapState.get(getContactState()), 
																						getContactDistrict(), mapDistrict.get(getContactDistrict()), 
																						getContactCity(), mapCity.get(getContactCity()), 
																						getContactLocalArea(), getContactStreetNo(), 
																						getContactTelephoneNo(),	getContactFlat(), 
																						getContactBlockNo(), new BigDecimal(0), null, null); 
			
				lstContactDetails.add(contactDetails);
		}
		
		/**Responsible to clear the Contact details fields*/ 
		clearContactDetails();
	}
	
	/**Responsible to clear only Contact Details Fields*/
	public void clearContactDetails() {
		setContactType(null);
		setContactLocalArea("");
		setContactCountry(null);
		setContactStreetNo("");
		setContactState(null);
		setContactTelephoneNo("");
		setContactDistrict(null);
		setContactFlat("");
		setContactCity(null);
		setContactBlockNo("");
		
		setBooContactDetailsDuplicate(false);
	}
	
	/** **************************************************************************************************************** */
	/***
	 * This is responsible to save image, by next button 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void managingImageSaveByNextPanel() throws SQLException, IOException {
		/**Rendering the Panel*/
		setBooPersonalInformation(false);
		setBooEmploymentInformation(true);
		setBooContactDetails(false);
		
		/**once reach to 3rd panel, the that's final */		
		if(getSaveUptoPanel()!=3) {
			setSaveUptoPanel(2);
		}
		
		/**Image saving*/ 
		image = new DocumentImg();
		image.setImage(storeImage());
		image.setUploadDate(new Date());
		image.setImageName(getFile().getFileName());
		image.setImgStatus("1");
		image.setUploadDate(new Date());
		
		/**Manipulating save/update*/
		if(getPkImage()!=null) {
			image.setImgId(getPkImage());
		}
		
		if(image.getImage().length()> 0 && !getBooDisableSave()){
			getRemOnlineReg().saveImage(image);
			setPkImage(image.getImgId());
		}
	}
	
	/***
	 * This is responsible to save Image from the first panel
	 * @throws SQLException
	 * @throws IOException
	 */
	public void managingImageSaveFromFirstPanelSave() throws SQLException, IOException {
		image = new DocumentImg();
		image.setImage(storeImage());
		image.setUploadDate(new Date());
		image.setImageName(getFile().getFileName());
		image.setImgStatus("1");
		image.setUploadDate(new Date());
		
		/**Here is deciding save or update*/
		if(getPkImage()!=null) {
			image.setImgId(getPkImage());
		}
		
		/**save will happen only if there is any image and this person not went branch*/ 
		if(image.getImage().length()>0 && !getBooDisableSave()){
			getRemOnlineReg().saveImage(image);
		}
		
	}
	
	/***
	 * when Next button will press from Personal Information, we need to save image also at that time
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws SerialException 
	 */
	public void nextFromPersonalInfo() throws SerialException, IOException, SQLException {
		
		/**Offing the image validation message*/ 
		setBooImageValidation(false);
		
		/**Means data is already there, that means customer is already registered*/
		if(getBooViewed()) {
			/**This will check there is any uploaded file or not*/
			if(getFile().getFileName()!=null && getFile().getFileName().length()>0){
				/**This will check file extension means file type*/
				if(getFile().getFileName().contains(".doc") || getFile().getFileName().contains(".docx") || getFile().getFileName().contains(".pdf") ||
						getFile().getFileName().contains(".png") || getFile().getFileName().contains(".jpg") || getFile().getFileName().contains(".jpeg")) {
					setBooImageValidation(false);
					managingImageSaveByNextPanel();
				} else {
					setBooImageValidation(true);
				}
			} else {
				setBooImageValidation(false);
				managingImageSaveByNextPanel();
			}
		} else {
			if(getFile().getFileName()!=null && (getFile().getFileName().contains(".doc") || getFile().getFileName().contains(".docx") || getFile().getFileName().contains(".pdf") ||
					getFile().getFileName().contains(".png") || getFile().getFileName().contains(".jpg") || getFile().getFileName().contains(".jpeg"))){
				
				setBooImageValidation(false);
				managingImageSaveByNextPanel();
			} else {
				setBooImageValidation(true);
			}
		}
		
	}
	
	/***
	 * Back button is pressed from Employee panel, back to Personal Information panel
	 */
	public void backFromEmp() {
		setBooPersonalInformation(true);
		setBooEmploymentInformation(false);
		setBooContactDetails(false);
	}
	
	/***
	 * Next button is pressed from Employee Panel, next panel is contact details 
	 */
	public void nextFromEmp() {
		setBooPersonalInformation(false);
		setBooEmploymentInformation(false);
		setBooContactDetails(true);
		setSaveUptoPanel(3);
	}
	
	/***
	 * Back button pressed from Contact Details
	 */
	public void backFromContactDetails() {
		setBooPersonalInformation(false);
		setBooEmploymentInformation(true);
		setBooContactDetails(false);
	}
	
	/***
	 * Responsible to fetch data after login
	 * @param userName
	 * @param customerId
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String view(String userName, String customerId, String emailId) throws SQLException, IOException, ParseException {
		
		setEmail(emailId);
		/**This condition will return true if the customer is already done first time online registration*/
		if(!customerId.equalsIgnoreCase("empty")) {
			setBooViewed(true);
			/**Responsible to clear the bean*/
			clear();
			
			/**If already registered then, it will show first panel*/
			setBooPersonalInformation(true);
			setBooEmploymentInformation(false);
			setBooContactDetails(false);
			
			/**We are getting customerID from from our login table*/
			setPkCustomerId(new BigDecimal(customerId));
			
			/**populating data from customer table*/
			lstCustomer.addAll(getRemOnlineReg().getFsCustomer(getPkCustomerId()));
			setBooReadonlyIdNumber(lstCustomer.size()>0?true:false);
			setShowDob(lstCustomer.get(0).getDateOfBirth()==null?"":formatter.format(lstCustomer.get(0).getDateOfBirth()));
			/**setDateOfBirth(lstCustomer.get(0).getDateOfBirth());*/
			setTitle(lstCustomer.get(0).getTitle());
			setFirstName(lstCustomer.get(0).getFirstName());
			setMiddleName(lstCustomer.get(0).getMiddleName());
			setLastName(lstCustomer.get(0).getLastName());
			setShortName(lstCustomer.get(0).getShortName());
			setLocalTitle(lstCustomer.get(0).getTitleLocal());
			setLocalFirstName(lstCustomer.get(0).getFirstNameLocal());
			setLocalMiddleName(lstCustomer.get(0).getMiddleNameLocal());
			setLocalLastName(lstCustomer.get(0).getLastNameLocal());
			setLocalShortName(lstCustomer.get(0).getShortNameLocal());
			setNationality(lstCustomer.get(0).getFsCountryMasterByNationality().getCountryId());
			setGender(lstCustomer.get(0).getGender());
			setMobileNo(lstCustomer.get(0).getMobile());
			setEmail(lstCustomer.get(0).getEmail());
			setAlternateEmail(lstCustomer.get(0).getAlterEmailId());
			setTokenKey(lstCustomer.get(0).getTokenKey());
			
			/**Here the icon for growling will be shown, because here image is available in Database*/ 
			setBooHasImage(true);
			setFsCustomerCreatedBy(lstCustomer.get(0).getCreatedBy());
			setFsCustomerCreatedDate(lstCustomer.get(0).getCreationDate());
			
			/**Once customer went to branch, we need to off update by online*/
			setBooDisableSave(lstCustomer.get(0).getActivatedInd().equalsIgnoreCase("0")?false:true);
			
			/**populating data from customer proof table*/
			lstCustomerIdProof = getRemOnlineReg().getFsCustIdProof(getPkCustomerId());
			setPkCustomerIdProof(lstCustomerIdProof.get(0).getCustProofId());
			setIdNumber(lstCustomerIdProof.get(0).getIdentityInt());
			setIdExpDate(lstCustomerIdProof.get(0).getIdentityExpiryDate());
			setFsCustomerIdProofCreatedBy(lstCustomerIdProof.get(0).getCreatedBy());
			setFsCustomerIdProofCreatedDate(lstCustomerIdProof.get(0).getCreationDate());
			
			String dob = null;
			if(getIdNumber().charAt(0)=='2'){
				dob = getIdNumber().substring(5, 7)+"/"+getIdNumber().substring(3, 5)+"/19"+getIdNumber().substring(1, 3);
			} else {
				dob = getIdNumber().substring(5, 7)+"/"+getIdNumber().substring(3, 5)+"/20"+getIdNumber().substring(1, 3);
			}
			Date date = formatter.parse(dob);
			setDateOfBirth(date);
			setShowDob(formatter.format(date));
			
			/**Responsible to populate image*/
			setPkImage(lstCustomerIdProof.get(0).getFsDocumentImg().getImgId());
			showImage(lstCustomerIdProof.get(0).getFsDocumentImg().getImage(), lstCustomerIdProof.get(0).getFsDocumentImg().getImageName());
			
			/**populating Customer Employment Information*/
			lstCustomerEmployment.addAll(getRemOnlineReg().getFsCustEmpInfo(getPkCustomerId()));
			/**If there is any data exist, setting the value*/ 
			if(lstCustomerEmployment!= null && lstCustomerEmployment.size() > 0) {
				setPkCustomerEmployeeId(lstCustomerEmployment.get(0).getCustEmpInfoId());
				setEmploymentType(lstCustomerEmployment.get(0).getFsEmploymentType().getEmploymentTypeId());
				setOccupation(lstCustomerEmployment.get(0).getOccupation());
				setDepartment(lstCustomerEmployment.get(0).getDepartment());
				setEmployer(lstCustomerEmployment.get(0).getEmployerName());
				setBlockNo(lstCustomerEmployment.get(0).getBlock());
				setStreetNo(lstCustomerEmployment.get(0).getStreet());
				setArea(lstCustomerEmployment.get(0).getArea());
				setOfficeTelNo(lstCustomerEmployment.get(0).getOfficeTelephone());
				setCountry(lstCustomerEmployment.get(0).getFsCountryMaster().getCountryId());
				populateState();
				setState(lstCustomerEmployment.get(0).getFsStateMaster().getStateId());
				populateDistrict();
				setDistrict(lstCustomerEmployment.get(0).getFsDistrictMaster().getDistrictId());
				populateCity();
				setCity(lstCustomerEmployment.get(0).getFsCityMaster().getCityId());
				setPostalCode(lstCustomerEmployment.get(0).getPostal());
				setFsCustomerEmpCreatedBy(lstCustomerEmployment.get(0).getCreatedBy());
				setFsCustomerEmpCreatedDate(lstCustomerEmployment.get(0).getCreationDate());
			}
			
			/**Fetching Contact Details Data*/
			lstContactDetailsModel.addAll(getRemOnlineReg().getFsContactDetails(getPkCustomerId()));
			if(lstContactDetailsModel!=null && lstContactDetailsModel.size()>0){
				lstContactDetails.clear();
				ContactDetails contactetails = null;
				for (ContactDetail contactDetail : lstContactDetailsModel) {
					setContactCountry(contactDetail.getFsCountryMaster().getCountryId());
					/**This method will populate the Contact Type, and map also, by which we can get Name by passing ID*/ 
					getFetchContactTypeList();
					/**This method for country map populate*/
					getCountryNameList();
					populateContactState();
					setContactState(contactDetail.getFsStateMaster().getStateId());
					populateContactDistrict();
					setContactDistrict(contactDetail.getFsDistrictMaster().getDistrictId());
					populateContactCity();
					contactetails = new ContactDetails(contactDetail.getFsContactType().getContactTypeId(), 
																		mapContactType.get(contactDetail.getFsContactType().getContactTypeId()), 
																		contactDetail.getFsCountryMaster().getCountryId(), 
																		mapCountry.get(contactDetail.getFsCountryMaster().getCountryId()), 
																		contactDetail.getFsStateMaster().getStateId(), 
																		mapState.get(contactDetail.getFsStateMaster().getStateId()), 
																		contactDetail.getFsDistrictMaster().getDistrictId(), 
																		mapDistrict.get(contactDetail.getFsDistrictMaster().getDistrictId()), 
																		contactDetail.getFsCityMaster().getCityId(), 
																		mapCity.get(contactDetail.getFsCityMaster().getCityId()), 
																		contactDetail.getArea(), 
																		contactDetail.getStreet(),
																		contactDetail.getTelephone(),
																		contactDetail.getFlat(), 
																		contactDetail.getBlock(), 
																		contactDetail.getContactDetailId(),
																		contactDetail.getCreatedBy(),
																		contactDetail.getCreationDate());
					lstContactDetails.add(contactetails);
				}
				
				/**After populating all the bean for datatable, we need to clear the components, we used these for populating data, and show in datatable*/
				clearContactDetails();
			}
		} else {
			setBooViewed(false);
			setBooHasImage(false);
		}
		return "remmiterInfo";
		
	}
	
	/***
	 *Responsible to fetch Image and populate in page 
	 * @param image
	 * @param fullImageName
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void showImage(Blob image, String fullImageName) throws SQLException, IOException {
		/**Just a confirmation, that there is a Image exist*/
		if(fullImageName!=null) {
			String imageExtention = fullImageName.substring(fullImageName.lastIndexOf("."));
			String imageName = fullImageName.substring(0,fullImageName.lastIndexOf(".")-1);
			byte[] blobAsBytes = image.getBytes(1, (int) image.length());
			InputStream stream = new ByteArrayInputStream(blobAsBytes);
	        downloadFile = new DefaultStreamedContent(stream, "image/jpg",  imageName  + imageExtention);
		}
	}
	
	/***
	 * Responsible to populate Date of birth from Civil Id and get the minimum expire date of ID
	 */
	public void popDob() {
		try{
			clear();
			/**Date of birth manipulation from CIVIL ID*/
			String id = getIdNumber(); 
			String dob = null;
			if(id.charAt(0)=='2'){
				dob = id.substring(5, 7)+"/"+id.substring(3, 5)+"/19"+id.substring(1, 3);
			} else {
				dob = id.substring(5, 7)+"/"+id.substring(3, 5)+"/20"+id.substring(1, 3);
			}
			
			Date date = formatter.parse(dob);
			setDateOfBirth(date);
			setShowDob(formatter.format(date));
			
			/**ID proof minimum date manipulation*/
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH,+ 90);
			Date today90 = cal.getTime();
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
			String minExpDate = form.format(today90);
			setExpDateCheck(minExpDate);
			
			/**civil ID is already Registered or not checking*/
			List<CustomerIdProof> matchCustomerId= new ArrayList<CustomerIdProof>();
			matchCustomerId.addAll(getRemOnlineReg().getCustomerIdProof(getIdNumber()));
			if(matchCustomerId.size() > 0) {
				setBooRegistered(true);
				clear();
			} else {
				setBooRegistered(false);
			}
			
		} catch(Exception e) {
			log.info("Problem to manupulate Date of Birth from CIVIL ID");
		}

	}		
	
	/***
	 * Responsible to clear all the fields
	 */
	public void clear(){
		clearPersonalInformation();
		clearEmploymentDetails();
		clearContactDetails();

	}
	
	/***
	 * Responsible to return a blob format of image 
	 * @return
	 * @throws IOException
	 * @throws SerialException
	 * @throws SQLException
	 */
    public Blob storeImage() throws IOException, SerialException, SQLException {
    	InputStream stream = null;
    	try {
    		stream =  file.getInputstream();
         }catch(Exception e){
            e.printStackTrace();
         }
    	return new javax.sql.rowset.serial.SerialBlob(readFully(stream));
    }
    
    /***
     * Responsible to prepare a byte array from InputStream
     * @param input
     * @return
     * @throws IOException
     */
    public  byte[] readFully(InputStream input) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }
	
    /***
     * This will control upto which panel need to save
     * @throws ParseException 
     * @throws SQLException 
     * @throws IOException 
     * @throws SerialException 
     */
    public void panelSaveController() throws SerialException, IOException, SQLException, ParseException {
    	if(getSaveUptoPanel() == 1) {
    		savePersonalInfoPanel("direct");
    	} else if(getSaveUptoPanel() == 2) {
    		savePersonalInfoPanelAndEmploymentPanel("direct");
    	} else {
    		saveAllPanel("direct");
    	}
    }
	
    /***
     * Responsible to send mail, with Customer ID with the Token Number 
     */
    public void createTokenId() {
    	String strToken = null;
		try{
			strToken = getTokenGeneration().getRandomIdentifier(8);
		} catch(Exception e){
			log.info("Problem in Token Generation"+ e);
		}
		
		boolean tokenConfirm = true;
		while(tokenConfirm){
			try{
				if(getRemOnlineReg().CheckTokenAvailable(strToken).size() > 0){
					tokenConfirm = true;
					strToken = getTokenGeneration().getRandomIdentifier(8);
				}else{
					tokenConfirm = false;
				}
			}catch(Exception e){
				tokenConfirm = false;
			}
		}
		setTokenKey(strToken);
		
    }
    
	/***
	 * Responsible to save data
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws SerialException 
	 * @throws ParseException 
	 */
	public void savePersonalInfoPanel(String fromWhereCalling) throws SerialException, IOException, SQLException, ParseException {
		
		/**Country ID save*/
		countryMaster = new CountryMaster();
		countryMaster.setCountryId(sessionStateManage.getCountryId());
		
		/**Nationality Id save*/
		CountryMaster nationality = new CountryMaster();
		nationality.setCountryId(getNationality());
		
		/**save company*/
		companyMaster = new CompanyMaster();
		companyMaster.setCompanyId(sessionStateManage.getCompanyId());
		
		/**Customer Type*/
		CustomerType customerType = new CustomerType();
		customerType.setCustomerTypeId(new BigDecimal(1));
		
		/**TODO Hard coded Group ID*/
		CompanyGroup companyGroup = new CompanyGroup();
		companyGroup.setGroupId(new BigDecimal(1));
		
		/**Calculating Language ID*/
		int languageID = 1;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
			languageID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().equalsIgnoreCase("ar")?2:1;
		}
		LanguageType langType = new LanguageType();
		langType.setLanguageId(new BigDecimal(languageID));
		
		/**Customer base table*/
		customer = new Customer();
		customer.setFsCountryMasterByCountryId(countryMaster);
		customer.setFsCompanyMaster(companyMaster);
		customer.setFsCustomerType(customerType);
		customer.setFsLanguageType(langType);
		customer.setFsCompanyGroup(companyGroup);
		customer.setFsCountryMasterByNationality(nationality);
		customer.setTitle(getTitle());
		customer.setFirstName(getFirstName());
		customer.setMiddleName(getMiddleName());
		customer.setLastName(getLastName());
		customer.setShortName(getShortName());
		customer.setTitleLocal(getLocalTitle());
		customer.setFirstNameLocal(getLocalFirstName());
		customer.setMiddleNameLocal(getLocalMiddleName());
		customer.setLastNameLocal(getLocalLastName());
		customer.setShortNameLocal(getLocalShortName());
		customer.setGender(getGender());
		customer.setMobile(getMobileNo());
		customer.setEmail(getEmail());
		customer.setAlterEmailId(getAlternateEmail());
		customer.setDateOfBirth(getDateOfBirth());
		customer.setTokenKey(getTokenKey());
		customer.setActivatedInd("0");
		
		/**Managing save or update, if condition will return true from second time(update time)*/
		if(getPkCustomerId()!=null) {
			customer.setCustomerId(getPkCustomerId());
			customer.setUpdatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			customer.setLastUpdated(new Date());
			customer.setCreatedBy(getFsCustomerCreatedBy());
			customer.setCreationDate(getFsCustomerCreatedDate());
			getRemOnlineReg().saveCustomer(customer);
		} else {
			customer.setCreatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			customer.setCreationDate(new Date());
			
			/**Responsible to create token randomly*/
			createTokenId();
			customer.setTokenKey(getTokenKey());
			/**save the data in customer table, with token ID*/
			getRemOnlineReg().saveCustomer(customer);
			
			/**After save first time we have to save the customer ID primary key field, by which we will send mail to that customer*/
			setPkCustomerId(customer.getCustomerId());
			
			/**First Time will go the mail, with the generated Token*/
			getMailService().sendTokenMail(getEmail(), "Successfully Registered", getPkCustomerId().toPlainString(), getTokenKey());
		}
		
		/***
		 * Image will save by here, only if anyone will save from the panel itself
		 */
		if(fromWhereCalling.equalsIgnoreCase("direct")) {
			
			if(getBooViewed()) {
				/**This will check there is any uploaded file or not*/
				if(getFile().getFileName()!=null){
					/**This will check file extension means file type*/
					if(getFile().getFileName().contains(".doc") || getFile().getFileName().contains(".docx") || getFile().getFileName().contains(".pdf") ||
							getFile().getFileName().contains(".png") || getFile().getFileName().contains(".jpg") || getFile().getFileName().contains(".jpeg")) {
						
						setBooImageValidation(false);
						managingImageSaveFromFirstPanelSave();
					} else {
						setBooImageValidation(true);
					}
				} else {
					setBooImageValidation(false);
				}
			} else {
				if(getFile().getFileName()!=null && (getFile().getFileName().contains(".doc") || getFile().getFileName().contains(".docx") || getFile().getFileName().contains(".pdf") ||
						getFile().getFileName().contains(".png") || getFile().getFileName().contains(".jpg") || getFile().getFileName().contains(".jpeg"))){
					
					setBooImageValidation(false);
					managingImageSaveFromFirstPanelSave();
				} else {
					setBooImageValidation(true);
				}
			}
			
		}
		
		IdentityType identityType = new IdentityType();
		//TODO hard coded CIVIL ID identity number, this page is specifically for those having CIVIL ID 
		identityType.setIdentityTypeId(new BigDecimal(1));
		
		CustomerIdProof idProof = new CustomerIdProof(); 
		idProof.setFsCustomer(customer);
		idProof.setFsCustomerType(customerType);
		idProof.setFsLanguageType(langType);
		idProof.setFsIdentityType(identityType);
		idProof.setIdentityInt(getIdNumber());
		idProof.setIdentityStatus("1");
		idProof.setIdentityExpiryDate(getIdExpDate());
		idProof.setFsDocumentImg(image);
		
		/**Managing save or update*/
		if(getPkCustomerIdProof()!=null) {
			idProof.setCustProofId(getPkCustomerIdProof());
			idProof.setUpdatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			idProof.setLastUpdatedDate(new Date());
			idProof.setCreatedBy(getFsCustomerIdProofCreatedBy());
			idProof.setCreationDate(getFsCustomerIdProofCreatedDate());
		} else {
			idProof.setCreatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			idProof.setCreationDate(new Date());
		}
		
		getRemOnlineReg().saveCustomerEmploymentProofInfo(idProof);
		
		/**It will update Login Table first time by Customer ID*/ 
		if(!getBooViewed()) {
			getRemOnlineReg().updateLoginCustomerId(sessionStateManage.getSessionValue("userName"), customer.getCustomerId() );
		}
		
		/**It will redirect only when it will direct call, from that panel*/
		if(fromWhereCalling.equalsIgnoreCase("direct")) {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
				context.invalidateSession();
				context.redirect("../common/success.xhtml");
			} catch(Exception e) {
				log.info("Problem to Redirect the page : "+e);
			}
		} 
		
	}
	
	/***
	 *  Responsible to save Personal Information panel and Employment Information panel
	 * @param fromWhereCalling
	 * @throws SerialException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void savePersonalInfoPanelAndEmploymentPanel(String fromWhereCalling) throws SerialException, IOException, SQLException, ParseException {
		savePersonalInfoPanel("fromEmployment");
		
		CustomerEmploymentInfo employmentInfo = new CustomerEmploymentInfo();
		
		/**set Country*/
		countryMaster = new CountryMaster();
		countryMaster.setCountryId(getCountry());
		employmentInfo.setFsCountryMaster(countryMaster);
		
		/**set Company*/
		companyMaster = new CompanyMaster();
		companyMaster.setCompanyId(sessionStateManage.getCompanyId());
		employmentInfo.setFsCompanyMaster(companyMaster);
		
		/**Calculating Language ID*/
		int languageID = 1;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
			languageID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().equalsIgnoreCase("ar")?2:1;
		}
		LanguageType langType = new LanguageType();
		langType.setLanguageId(new BigDecimal(languageID));
		employmentInfo.setFsLanguageType(langType);
		
		/**save customer*/
		employmentInfo.setFsCustomer(customer);
		
		employmentInfo.setOccupation(getOccupation());
		
		/**Employment Type*/
		EmploymentType employemntType = new EmploymentType();
		employemntType.setEmploymentTypeId(getEmploymentType());
		employmentInfo.setFsEmploymentType(employemntType);
		
		employmentInfo.setEmployerName(getEmployer());
		employmentInfo.setDepartment(getDepartment());
		
		/**saving state*/
		StateMaster state = new StateMaster();
		state.setStateId(getState());
		employmentInfo.setFsStateMaster(state);
		
		/**saving District*/
		DistrictMaster district = new DistrictMaster();
		district.setDistrictId(getDistrict());
		employmentInfo.setFsDistrictMaster(district);
		
		/**saving city*/
		CityMaster cityMaster = new CityMaster();
		cityMaster.setCityId(getCity());
		employmentInfo.setFsCityMaster(cityMaster);
	
	
		employmentInfo.setArea(getArea());
		employmentInfo.setBlock(getBlockNo());
		employmentInfo.setStreet(getStreetNo());
		employmentInfo.setPostal(getPostalCode());
		employmentInfo.setOfficeTelephone(getOfficeTelNo());

		/**This condition will return true from 2nd time*/
		if(getPkCustomerEmployeeId()!=null){
			employmentInfo.setCustEmpInfoId(getPkCustomerEmployeeId());
			employmentInfo.setUpdatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			employmentInfo.setLastUpdated(new Date());
			employmentInfo.setCreatedBy(getFsCustomerEmpCreatedBy());
			employmentInfo.setCreationDate(getFsCustomerEmpCreatedDate());
		} else {
			employmentInfo.setCreatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
			employmentInfo.setCreationDate(new Date());
		}
		
		/**Responsible to save*/
		getRemOnlineReg().saveCustomerEmploymentInfo(employmentInfo);
		
		/**It will redirect only when it will direct call, from that panel*/
		if(fromWhereCalling.equalsIgnoreCase("direct")) {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
				context.invalidateSession();
				context.redirect("../common/success.xhtml");
			} catch(Exception e) {
				log.info("Problem to redirect: "+e);
			}
		} 
		
	}
	
	/***
	 * Responsible to Save All panel
	 * @param fromWhereCalling
	 * @throws SerialException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void saveAllPanel(String fromWhereCalling) throws SerialException, IOException, SQLException, ParseException {
		savePersonalInfoPanelAndEmploymentPanel("fromContactDetails");
		ContactDetail contactDetailModel = null;
		/**We will iterate the loop, and will get the Objects and set the value in ContactDetails Model class for saving*/
		for (ContactDetails contactDetails : lstContactDetails) {
			
			contactDetailModel = new ContactDetail();
			contactDetailModel.setFsCustomer(customer);
			
			ContactType contactType = new ContactType();
			contactType.setContactTypeId(contactDetails.getContactType());
			contactDetailModel.setFsContactType(contactType);
			
			int languageID = 1;
			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
				languageID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().equalsIgnoreCase("ar")?2:1;
			}
			LanguageType langType = new LanguageType();
			langType.setLanguageId(new BigDecimal(languageID));
			contactDetailModel.setFsLanguageType(langType);
			
			CountryMaster countryMaster = new CountryMaster();
			countryMaster.setCountryId(contactDetails.getCountry());
			contactDetailModel.setFsCountryMaster(countryMaster);
			
			StateMaster stateMaster = new StateMaster();
			stateMaster.setStateId(contactDetails.getState());
			contactDetailModel.setFsStateMaster(stateMaster);
			
			DistrictMaster districtMaster = new DistrictMaster();
			districtMaster.setDistrictId(contactDetails.getDistrict());
			contactDetailModel.setFsDistrictMaster(districtMaster);
			
			CityMaster cityMaster = new CityMaster();
			cityMaster.setCityId(contactDetails.getCity());
			contactDetailModel.setFsCityMaster(cityMaster);
			
			contactDetailModel.setArea(contactDetails.getLocalArea());
			contactDetailModel.setBlock(contactDetails.getBlock());
			contactDetailModel.setStreet(contactDetails.getStreet());
			contactDetailModel.setFlat(contactDetails.getFlat());
			contactDetailModel.setTelephone(contactDetails.getTelephone());
			contactDetailModel.setActiveStatus("1");
			
			if(contactDetails.getPkContactDetails().intValue()!=0) {
				contactDetailModel.setContactDetailId(contactDetails.getPkContactDetails());
				contactDetailModel.setUpdatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
				contactDetailModel.setLastUpdated(new Date());
				contactDetailModel.setCreatedBy(contactDetails.getCreatedBy());
				contactDetailModel.setCreationDate(contactDetails.getCreationDate());
			} else {
				contactDetailModel.setCreatedBy(sessionStateManage.isExists("userName")?sessionStateManage.getSessionValue("userName"):"root");
				contactDetailModel.setCreationDate(new Date());
			}
			getRemOnlineReg().saveContactDetails(contactDetailModel);
		}

		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.invalidateSession();
			context.redirect("../common/success.xhtml");
		} catch(Exception e) {
			log.info("Problem to redirect: "+e);
		}
	}
	
	/**************************************************Rule Engine Implementation***************************************************/
	/***
	 * This method will call from page, to get the behavior
	 * @param componentName
	 * @param type
	 * @return
	 */
	public String viewBehaviorBean(String componentName, String type){
		if(mapComponentBehavior==null || mapComponentBehavior.size()==0){
			setPageIdIntoSession();
			prepareBehavior();
		}
		return new CollectionUtil().fetchBehavior(mapComponentBehavior, componentName, type);
	}
	
	/***
	 * Responsible to get the page ID
	 */
	private void setPageIdIntoSession(){
		String pageName = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		pageName = pageName.substring(pageName.lastIndexOf('/')+1, pageName.indexOf(".xhtml"));
		
		try{
			BigDecimal pageId = getiGeneralService().getPageId(pageName);
			new SessionStateManage().setSessionValue("pageId", pageId.toString());
		}catch(Exception e){
			log.info("Page id not found for pagename :: "+pageName+" :: "+e);
		}
	}
	
	/***
	 * Responsible to take data and prepare the behavior for each component 
	 */
	private void prepareBehavior(){
		SessionStateManage manage = new SessionStateManage(); 
		List<String> lstComponentName = Arrays.asList("Title",
																				"First Name",
																				"Middle Name",
																				"Last Name",
																				"Short Name",
																				"Local Title",
																				"Local First Name",
																				"Local Middle name",
																				"Local Last Name",
																				"Local Short Name",
																				"Nationality",
																				"Gender",
																				"Mobile No",
																				"Email",
																				"ID Expiary Date",
																				
																				"Employment Type",
																				"occupation",
																				"Employer Name",
																				"Country",
																				"Block",
																				"State",
																				"Street",
																				"District",
																				"Area",
																				"City",
																				"Telephone Number",
																				"Postal Code",
																				"Department",
																				
																				"Contact Type",
																				/*"Contact Country",*/
																				/*"Contact State",*/
																				/*"Contact District",*/
																				/*"Contact City",*/
																				"Contact Local Area",
																				"Contact Street No",
																				"Contact Telephone No",
																				"Contact Flat No",
																				"Contact Block No");
		mapComponentBehavior =  getiGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
	}
	
}  

