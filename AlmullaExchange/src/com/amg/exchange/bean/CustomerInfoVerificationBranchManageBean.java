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
import org.primefaces.event.SelectEvent;
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
import com.amg.exchange.model.CorporateBusinessNature;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.CustCorporateAddlDetail;
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
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;
import com.sun.imageio.plugins.common.BogusColorSpace;
import com.sun.xml.internal.bind.v2.model.core.ID;

@Component("customerInfoBranch")
@Scope("session")
public class CustomerInfoVerificationBranchManageBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599730867382515210L;
	
	private boolean renderBasicInfo = true;
	private boolean renderCustomerDetails = false;
	private boolean renderCustomeInfoEditable = false;
	private boolean renderCustomeInfoLocal = false;
    private boolean renderContactDetails = false;
    private boolean renderContactDetailsMatch = false;
    private boolean renderEmployeementInfo = false;
    private boolean renderIdProof = false;
    private boolean renderDigitalSign = false;
    private boolean renderIdNotReg  = false;
    private BigDecimal methodTypeId =null;
    private String tokenNumber = null;
    private String idNumber = null;
    private BigDecimal customerId = null;
    private BigDecimal languageId ;
    private Date ExpiryDateforEdit;

    //customer details
    private String idType = null;
    private String title;
    private String titleL;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String shortName = null;
    private String firstNameL = null;
    private String middleNameL = null;
    private String lastNameL = null;
    private String shortNameL = null;
    private BigDecimal nationalityId = null;
    private String gender = null;
    private Date  idExpiryDate = null;
    private Date  dateOfBirth = null;
    private String  mobileNo = null;
    private String  email = null;
    private String amlStatus = null;
    private String numberOfHits = null;
    private boolean approved;
    private String createdBy = null;
    private Date createdDate = null;
    private String tokenKey = null;
    private BigDecimal groupId = null;
    private BigDecimal companyId = null;
    private String alternateEmail = null;
   
	//contact details
    private BigDecimal contactTypeId = null;
    private BigDecimal  countryId = null;
    private BigDecimal  stateId = null;
    private BigDecimal  districtId = null;
    private BigDecimal  cityId = null;
    private String  localArea = null;
    private String streetNo = null;
    private String  telephoneNo = null;
    private String  flatNo = null;
    private String   blockNo= null;
    private List<ContactType> contactTypeList;
    
    /*Holding the component Behavior*/
	private Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	
    private  Map<BigDecimal, String>  contactTypeMap   = new  HashMap<BigDecimal,String>();
    //employement info
    private String occupation = null;
	private String employer = null;
	private String employmentType = null;
	private String empcategory = null;
	private String originId = null;
	private String stateEmployment = null;
	private String postalCode = null;
    private BigDecimal empInfoCountry = null;
	private BigDecimal empInfoState = null;
	private BigDecimal empInfoDistrict = null;
	private String empInfoBlock = null;
	private String empInfoStreet = null;
	private BigDecimal empInfoCity = null;
	private String empInfoArea = null;
	private String empInfoOfficeTel = null;
	private String department = null;
	private BigDecimal empInfoEmploymentTypeId = null;
	private BigDecimal custEmployeementInfoId = null;
	
	private List<StateMasterDesc> lstStateEmpList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictEmpList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstCityEmpList = new ArrayList<CityMasterDesc>();
	
	private UploadedFile file;
	private StreamedContent downloadFile;  
	
	private BigDecimal image_id; 
	
	private String idFor = null;
	private Date dateExp = null;
	public String getTitleL() {
		return titleL;
	}

	public void setTitleL(String titleL) {
		this.titleL = titleL;
	}
	private String idnumberProof = null;
	private Boolean booBrowsedFile = false;
	private Boolean enablePTbl;
	private String DATE_FORMAT = "dd/MM/yyyy";

	private String expDateAdder;
	private int saveUptoPanel = 1;

	public int getSaveUptoPanel() {
		return saveUptoPanel;
	}

	public void setSaveUptoPanel(int saveUptoPanel) {
		this.saveUptoPanel = saveUptoPanel;
	}
	private Map<String, StreamedContent> imageMap = new HashMap<String, StreamedContent>();
	
	private String idTypeBranchPage = "";
	private String idTypeproof = null;
	 Logger log = Logger.getLogger(CustomerInfoVerificationBranchManageBean.class);
	    
	
    private ContactDetail contactDetail = null;
	private CorporateBusinessNature corpBussnsNature = null;
	private CustCorporateAddlDetail custCorpAddDetail = null;
	private CustomerIdProof custmrIdProof = null;
	private IdentityType identityType = null;
	private Customer customer = null;
	private CountryMaster countryMstr = null;
	private CompanyMaster companyMstr = null;
	private CustomerType custmrType = null;
	private LanguageType langType = null;
	private StateMaster stateMaster = null;
	private DistrictMaster districtMaster = null;
	private CountryMaster  countryMaster = null;
	private CountryMaster  countryMasterForNationality = null;
	private ContactType  contactType = null;
	private CityMaster   cityMaster = null;
	private CompanyMaster companyMaster = null;
    private List<CountryMasterDesc>  countryList;
    private List<StateMasterDesc> lstState;
	private List<CityMasterDesc>lstCity;
	private List<DistrictMasterDesc>lstDistrict;
	private SessionStateManage sessionStateManage = null;
	private List<AddContactDetailBean> contactList = new ArrayList<AddContactDetailBean>();
	private List<AddContactDetailBean> contactListDelete = new ArrayList<AddContactDetailBean>();
	private Map<String,String>	idTypeMap = new HashMap<String,String>();
	private List<IdentityType> lstEmpInfoIdentityList = new ArrayList<IdentityType>();
	private List<CreateProofTable> createProofList = new ArrayList<CreateProofTable>();
	private List<CreateProofTable> createProofListDelete = new ArrayList<CreateProofTable>();
	private boolean enableContactDataTable = true;	
	private List<StateMasterDesc> stateList;
	private List<DistrictMasterDesc> districtList;
	private List<CityMasterDesc> cityList;
	private Map<String,String>	idForMap = new HashMap<String,String>();
	Map<BigDecimal,String> mapCountryList = new HashMap<BigDecimal,String>();
	Map<BigDecimal,String> mapStateList = new HashMap<BigDecimal,String>();
	Map<BigDecimal,String> mapDistirictList = new HashMap<BigDecimal,String>();
	Map<BigDecimal,String> mapCityList = new HashMap<BigDecimal,String>();
	private List<CustomerIdProof> customerIdProofList = new ArrayList<CustomerIdProof>();
	private List<Customer> customerList = new  ArrayList<Customer>();
	private List<ContactDetail> contactDetailList = new ArrayList<ContactDetail>();
	private List<CustomerEmploymentInfo>   customerEmploymentInfoList = new ArrayList<CustomerEmploymentInfo>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	/*private String userName=FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap().get("userName")
			.toString();*/

	private BigDecimal customerIdToNominee = null;
	
	private String userName="AlMulla";
	//TODO
	
	@Autowired
	IGeneralService<T> generalService;
	
	@Autowired
	IBranchPageService<T> branchpageService;
	
	@Autowired
	ICorporateRegService<T>   corpRegService;
    
	

	public Date getExpiryDateforEdit() {
		return ExpiryDateforEdit;
	}

	public void setExpiryDateforEdit(Date expiryDateforEdit) {
		ExpiryDateforEdit = expiryDateforEdit;
	}

	public boolean isRenderIdNotReg() {
		return renderIdNotReg;
	}

	public void setRenderIdNotReg(boolean renderIdNotReg) {
		this.renderIdNotReg = renderIdNotReg;
	}

	public String getExpDateAdder() {
		return expDateAdder;
	}

	public void setExpDateAdder(String expDateAdder) {
		this.expDateAdder = expDateAdder;
	}

	public List<StateMasterDesc> getLstStateEmpList() {
		return lstStateEmpList;
	}

	public void setLstStateEmpList(List<StateMasterDesc> lstStateEmpList) {
		this.lstStateEmpList = lstStateEmpList;
	}

	public List<DistrictMasterDesc> getLstDistrictEmpList() {
		return lstDistrictEmpList;
	}

	public void setLstDistrictEmpList(List<DistrictMasterDesc> lstDistrictEmpList) {
		this.lstDistrictEmpList = lstDistrictEmpList;
	}

	public List<CityMasterDesc> getLstCityEmpList() {
		return lstCityEmpList;
	}

	public void setLstCityEmpList(List<CityMasterDesc> lstCityEmpList) {
		this.lstCityEmpList = lstCityEmpList;
	}

	public BigDecimal getGroupId() {
		return groupId;
	}

	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	public BigDecimal getCompanyId() {
		return companyId;
	}

	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public BigDecimal getCustEmployeementInfoId() {
		return custEmployeementInfoId;
	}

	public void setCustEmployeementInfoId(BigDecimal custEmployeementInfoId) {
		this.custEmployeementInfoId = custEmployeementInfoId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmpInfoOfficeTel() {
		return empInfoOfficeTel;
	}

	public void setEmpInfoOfficeTel(String empInfoOfficeTel) {
		this.empInfoOfficeTel = empInfoOfficeTel;
	}

	public String getEmpInfoArea() {
		return empInfoArea;
	}

	public void setEmpInfoArea(String empInfoArea) {
		this.empInfoArea = empInfoArea;
	}

	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	public ICorporateRegService<T> getCorpRegService() {
		return corpRegService;
	}

	public void setCorpRegService(ICorporateRegService<T> corpRegService) {
		this.corpRegService = corpRegService;
	}

	public boolean isRenderEmployeementInfo() {
		return renderEmployeementInfo;
	}

	public void setRenderEmployeementInfo(boolean renderEmployeementInfo) {
		this.renderEmployeementInfo = renderEmployeementInfo;
	}

	public String getAmlStatus() {
		return amlStatus;
	}

	public void setAmlStatus(String amlStatus) {
		this.amlStatus = amlStatus;
	}

	public String getNumberOfHits() {
		return numberOfHits;
	}

	public void setNumberOfHits(String numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	public BigDecimal getEmpInfoCountry() {
		return empInfoCountry;
	}

	public void setEmpInfoCountry(BigDecimal empInfoCountry) {
		this.empInfoCountry = empInfoCountry;
	}

	public BigDecimal getEmpInfoDistrict() {
		return empInfoDistrict;
	}

	public void setEmpInfoDistrict(BigDecimal empInfoDistrict) {
		this.empInfoDistrict = empInfoDistrict;
	}

	public BigDecimal getEmpInfoEmploymentTypeId() {
		return empInfoEmploymentTypeId;
	}

	public void setEmpInfoEmploymentTypeId(BigDecimal empInfoEmploymentTypeId) {
		this.empInfoEmploymentTypeId = empInfoEmploymentTypeId;
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

	public BigDecimal getEmpInfoState() {
		return empInfoState;
	}

	public void setEmpInfoState(BigDecimal empInfoState) {
		this.empInfoState = empInfoState;
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

	public BigDecimal getEmpInfoCity() {
		return empInfoCity;
	}

	public void setEmpInfoCity(BigDecimal empInfoCity) {
		this.empInfoCity = empInfoCity;
	}

	public List<CreateProofTable> getCreateProofList() {
		return createProofList;
	}

	public void setCreateProofList(List<CreateProofTable> createProofList) {
		this.createProofList = createProofList;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Boolean getEnablePTbl() {
		return enablePTbl;
	}

	public void setEnablePTbl(Boolean enablePTbl) {
		this.enablePTbl = enablePTbl;
	}

	public List<IdentityType> getLstEmpInfoIdentityList() {
		return lstEmpInfoIdentityList;
	}

	public void setLstEmpInfoIdentityList(List<IdentityType> lstEmpInfoIdentityList) {
		this.lstEmpInfoIdentityList = lstEmpInfoIdentityList;
	}

	public Date getDateExp() {
		return dateExp;
	}

	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

	public String getIdFor() {
		return idFor;
	}

	public void setIdFor(String idFor) {
		this.idFor = idFor;
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

	public String getIdTypeBranchPage() {
		return idTypeBranchPage;
	}

	public void setIdTypeBranchPage(String idTypeBranchPage) {
		this.idTypeBranchPage = idTypeBranchPage;
	}

	public String getIdTypeproof() {
		return idTypeproof;
	}

	public void setIdTypeproof(String idTypeproof) {
		this.idTypeproof = idTypeproof;
	}

	public IdentityType getIdentityType() {
		return identityType;
	}

	public void setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
	}

	public IBranchPageService<T> getBranchpageService() {
		return branchpageService;
	}

	public void setBranchpageService(IBranchPageService<T> branchpageService) {
		this.branchpageService = branchpageService;
	}

	public BigDecimal getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public List<AddContactDetailBean> getContactList() {
		return contactList;
	}

	public void setContactList(List<AddContactDetailBean> contactList) {
		this.contactList = contactList;
	}

	public boolean isEnableContactDataTable() {
		return enableContactDataTable;
	}

	public void setEnableContactDataTable(boolean enableContactDataTable) {
		this.enableContactDataTable = enableContactDataTable;
	}

	public boolean isRenderBasicInfo() {
		return renderBasicInfo;
	}

	public void setRenderBasicInfo(boolean renderBasicInfo) {
		this.renderBasicInfo = renderBasicInfo;
	}

	public boolean isRenderCustomeInfoEditable() {
		return renderCustomeInfoEditable;
	}

	public void setRenderCustomeInfoEditable(boolean renderCustomeInfoEditable) {
		this.renderCustomeInfoEditable = renderCustomeInfoEditable;
	}

	public boolean isRenderCustomeInfoLocal() {
		return renderCustomeInfoLocal;
	}

	public void setRenderCustomeInfoLocal(boolean renderCustomeInfoLocal) {
		this.renderCustomeInfoLocal = renderCustomeInfoLocal;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public IGeneralService<T> getGeneralService() {
		return generalService;
	}

	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}

	public boolean isRenderCustomerDetails() {
		return renderCustomerDetails;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getMethodTypeId() {
		return methodTypeId;
	}

	public void setMethodTypeId(BigDecimal methodTypeId) {
		this.methodTypeId = methodTypeId;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public BigDecimal getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(BigDecimal contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
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

	public BigDecimal getCityId() {
		return cityId;
	}

	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
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

	public String getFirstNameL() {
		return firstNameL;
	}

	public void setFirstNameL(String firstNameL) {
		this.firstNameL = firstNameL;
	}

	public String getMiddleNameL() {
		return middleNameL;
	}

	public void setMiddleNameL(String middleNameL) {
		this.middleNameL = middleNameL;
	}

	public String getLastNameL() {
		return lastNameL;
	}

	public void setLastNameL(String lastNameL) {
		this.lastNameL = lastNameL;
	}

	public String getShortNameL() {
		return shortNameL;
	}

	public void setShortNameL(String shortNameL) {
		this.shortNameL = shortNameL;
	}

	public BigDecimal getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(BigDecimal nationalityId) {
		this.nationalityId = nationalityId;
	}
	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getLocalArea() {
		return localArea;
	}

	public void setLocalArea(String localArea) {
		this.localArea = localArea;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
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

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public boolean isRenderContactDetailsMatch() {
		return renderContactDetailsMatch;
	}

	public void setRenderContactDetailsMatch(boolean renderContactDetailsMatch) {
		this.renderContactDetailsMatch = renderContactDetailsMatch;
	}

	public boolean isRenderIdProof() {
		return renderIdProof;
	}

	public void setRenderIdProof(boolean renderIdProof) {
		this.renderIdProof = renderIdProof;
	}

	public boolean isRenderDigitalSign() {
		return renderDigitalSign;
	}

	public void setRenderDigitalSign(boolean renderDigitalSign) {
		this.renderDigitalSign = renderDigitalSign;
	}

	public boolean isRenderContactDetails() {
		return renderContactDetails;
	}

	public void setRenderContactDetails(boolean renderContactDetails) {
		this.renderContactDetails = renderContactDetails;
	}

	public void setRenderCustomerDetails(boolean renderCustomerDetails) {
		this.renderCustomerDetails = renderCustomerDetails;
	}
	
	public void panelSaveController() throws SerialException, IOException, SQLException, ParseException {
		if(getSaveUptoPanel() == 1) {
			saveCustomerInfo();
		} else if(getSaveUptoPanel() == 2) {
			saveContactDetails();
		} else if(getSaveUptoPanel() == 3){
			saveEmployeementInfo();
		} else {
			
		saveCustomerIdProof();	
		}
	}
	
	/**
	 * method is responsible to populate List of countries from DB 
	 * @return
	 */
	public List<CountryMasterDesc> getCountryListFromDB() {
	   /* sessionStateManage = new SessionStateManage(); 
		countryList = new ArrayList<CountryMasterDesc>();
		countryList.addAll( getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1")));*/
 		return countryList;
	}
	/**
	 * method is responsible to populate List of countries from DB 
	 * @return
	 */
	public List<CountryMasterDesc> getCountryNameList() {
		 sessionStateManage = new SessionStateManage(); 
		 countryList = new ArrayList<CountryMasterDesc>();
		 countryList.addAll( getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1")));
		
		for(CountryMasterDesc countryMasterDesc:countryList) {
			mapCountryList.put(countryMasterDesc.getFsCountryMaster().getCountryId(), countryMasterDesc.getCountryName());
		}
 		return countryList;
	}
	public List<CountryMasterDesc> getNationalityNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> nationalityList = getGeneralService().getNationalityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));
		return nationalityList;
	}
	/*
	*
	*method to get state from db and add all the state code and name will be mapped to hashMap
	*/
	public void popState(AjaxBehaviorEvent e) {
		lstState = new ArrayList<StateMasterDesc>();
		lstState.addAll(getGeneralService().getStateList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId()));
		for(StateMasterDesc stateMasterDesc:lstState) {
			mapStateList.put(stateMasterDesc.getFsStateMaster().getStateId(), stateMasterDesc.getStateName());
		}
	}
	public List<StateMasterDesc> getStateListFromDB() {
		return lstState;
	}
	/*
	*
	*method to get District from db and add all the state code and name will be mapped to hashMap
	*/
	public void popDistrict(AjaxBehaviorEvent e) {
		lstDistrict = new ArrayList<DistrictMasterDesc>();
		lstDistrict.addAll(getGeneralService().getDistrictList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId(),getStateId()));
		for(DistrictMasterDesc districtMasterDesc:lstDistrict) {
			mapDistirictList.put(districtMasterDesc.getFsDistrictMaster().getDistrictId(), districtMasterDesc.getDistrict());
		}
	}
	public List<DistrictMasterDesc> getDistrictListFromDB() {
		return lstDistrict;
	}
	/*
	*
	*method to get city from db and add all the state code and name will be mapped to hashMap
	*/
	public void popCity(AjaxBehaviorEvent e) {
		lstCity = new ArrayList<CityMasterDesc>();
		lstCity.addAll(getGeneralService().getCityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId(),getStateId(),getDistrictId()));
		for(CityMasterDesc cityMasterDesc:lstCity) {
			mapCityList.put(cityMasterDesc.getFsCityMaster().getCityId(), cityMasterDesc.getCityName());
		}
	}
	public List<CityMasterDesc> getCityListFromDB() {
		return lstCity;
		
	}
	public void idExpDateChange(SelectEvent event ) {
		System.out.println("the changed date is"+getDateExp());
		for(CreateProofTable element:createProofList) {
			if(element.getId_number().equals(getIdNumber())) {
				element.setDate_expiary(new SimpleDateFormat(DATE_FORMAT).format(getExpiryDateforEdit()));
				System.out.println("insid if condition exp date"+element.getDate_expiary());
			}
		}
		
	}
	/*
	*
	*method to get state from db  for empinfo
	*/
	public void popStateEmp(AjaxBehaviorEvent e) {
		setLstStateEmpList(null);
		sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> statemasterDesc = getGeneralService().getStateList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry());
	    setLstStateEmpList(statemasterDesc);
	}
	/*
	*method to get district from db  for empinfo
	*/
	public void popDistrictEmp(AjaxBehaviorEvent e) {
		setLstDistrictEmpList(null);
		sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> districtmasterDesc = getGeneralService().getDistrictList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry(),getEmpInfoState());
	    setLstDistrictEmpList(districtmasterDesc);
	}
	/*
	*method to get city from db  for empinfo
	*/
	public void popCityEmp(AjaxBehaviorEvent e) {
		setLstCityEmpList(null);
		sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> citymasterDesc = getGeneralService().getCityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry(),getEmpInfoState(),getEmpInfoDistrict());
	    setLstCityEmpList(citymasterDesc);
	}
	private BigDecimal individualIdType = new BigDecimal(1);
	public List<IdentityType> getFetchIdType(){
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<IdentityType> idType = getGeneralService().getIdentityTypes(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1),
				new BigDecimal(120), individualIdType
				);
		//sessionStateManage.getSessionValue("countryId")
		for (IdentityType identityType : idType) {
			idTypeMap.put(identityType.getIdentityTypeId().toPlainString(), identityType.getIdentityType());
		}
		
		setLstEmpInfoIdentityList(idType);
		
		return idType;
	}
	public List<ContactType> getContactTypeListDB(){
		contactTypeList = new ArrayList<ContactType>();
		//System.out.println("sjsjsijofeeeeeeeevwjifjievjirg3jjihghjoijiohgeegegeggggggej");
		contactTypeList.addAll(getCorpRegService().getContactTypeListFromDB());
		for(ContactType contType:contactTypeList) {
			contactTypeMap.put(contType.getContactTypeId(), contType.getContactType());
		}
		return contactTypeList;
	}
	public List<EmploymentType> getEmploymentTypeList() {
		
		 sessionStateManage = new SessionStateManage();
		return getGeneralService().getEmploymentTypes(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
	}
	
	//TODO
	/*
	 * method to fetch the record from db
	 * 
	 */
	public void fetchCustomerInfo() {
		System.out.println("Enter.....");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH,+ 90);
		
		Date today90 = cal.getTime();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String finalDate = form.format(today90);
        setExpDateAdder(finalDate);
		
        SimpleDateFormat  smpDate = new SimpleDateFormat("dd/MM/yyyy");
		SessionStateManage sessionStateManage = new SessionStateManage();
		setLanguageId(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		
		try {
		customerIdProofList= getBranchpageService().getCustomerIdProof(getIdNumber());
		System.out.println("the size is"+customerIdProofList.size());
		if(customerIdProofList.size()>0){
			System.out.println(customerIdProofList.get(0).getFsCustomer().getCustomerId());
			idForMap.put("1", "Address Proof");
			idForMap.put("2", "Identity Proof");
			if(customerIdProofList.size()>0) {
				customerList = getBranchpageService().getCustomerInfoWithToken(customerIdProofList.get(0).getFsCustomer().getCustomerId(), getTokenNumber());
				if(customerList.size() > 0) {
					getFetchIdType();
					getContactTypeListDB();
					setCustomerIdProof();
					setCustomerDetails();
					fillCountryList();
					fillStateList();
					fillDistrictList();
					fillCityList();
					System.out.println("calling contact details");
					setContactDetails();
					setEmployeementInfo();
					setRenderCustomerDetails(true);
					setRenderCustomeInfoEditable(true);
					setRenderCustomeInfoLocal(true);
					setRenderBasicInfo(false);
				} else {
					setRenderIdNotReg(true);
				}
			}else {
				setRenderIdNotReg(true);
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCustomerIdProof() {
		setCustomerId(customerIdProofList.get(0).getFsCustomer().getCustomerId());
		setExpiryDateforEdit(customerIdProofList.get(0).getIdentityExpiryDate());
		customerIdProofList.clear();
		CreateProofTable   createProofTable = new CreateProofTable(); 
		customerIdProofList = getBranchpageService().getCustomerIdProofList(getCustomerId());
		for(CustomerIdProof  customerIdProof:customerIdProofList ) {
			/*CreateProofTable createProofTable = new CreateProofTable(customerIdProof.getIdentityFor(), customerIdProof.getIdentityFor(), customerIdProof.getIdentityInt(), df, "insert", 0, 
					idForMap.get(customerIdProof.getIdentityFor()), idTypeMap.get(customerIdProof.getFsIdentityType().getIdentityTypeId()), customerIdProof.getFsDocumentImg().getImgId());*/
			System.out.println("the id for id is "+customerIdProof.getIdentityFor());
			
			System.out.println("...................."+customerIdProof.getIdentityFor());
			System.out.println("the id for map is"+idForMap.get(customerIdProof.getIdentityFor()));
			System.out.println("the id type id is"+customerIdProof.getFsIdentityType().getIdentityTypeId());
			System.out.println("the id type id of map is"+idTypeMap.get(customerIdProof.getFsIdentityType().getIdentityTypeId()));
			createProofTable.setIdFor(idForMap.get(customerIdProof.getIdentityFor()));
			createProofTable.setId_for(customerIdProof.getIdentityFor());
			createProofTable.setId_number(customerIdProof.getIdentityInt());
			createProofTable.setIdType(idTypeMap.get(customerIdProof.getFsIdentityType().getIdentityTypeId().toString()));
			createProofTable.setImageId(customerIdProof.getFsDocumentImg().getImgId());
			createProofTable.setCustomerIdProofId(customerIdProof.getCustProofId());
			createProofTable.setDate_expiary(new SimpleDateFormat(DATE_FORMAT).format(customerIdProof.getIdentityExpiryDate()));
			createProofTable.setId_type(customerIdProof.getFsIdentityType().getIdentityTypeId().toString());
			if(customerIdProof.getApprovedBy() == "0") {
				createProofTable.setChecked(false);
			}else{
				createProofTable.setChecked(true);
			}
			//createProofTable.setChecked(customerIdProof.getApprovedBy().equals("0")?false:true);
			createProofList.add(createProofTable);
		}
	}
	public void setCustomerDetails() {
		System.out.println("the customer id inside customer details is"+getCustomerId());
		customerList = getBranchpageService().getCustomerInfo(getCustomerId());
		
		System.out.println("the customer size is"+customerList.size());
		//System.out.println("the gender is"+);
		//for(Customer customer: customerList) {
			System.out.println("gender is"+customerList.get(0).getGender());
			System.out.println("title"+customerList.get(0).getTitle());
			System.out.println("title local"+customerList.get(0).getTitleLocal());
		    System.out.println("the nationality id is"+customerList.get(0).getFsCountryMasterByNationality().getCountryId());
			setNationalityId(customerList.get(0).getFsCountryMasterByNationality().getCountryId());
			setFirstName(customerList.get(0).getFirstName());
			setFirstNameL(customerList.get(0).getFirstNameLocal());
			setMiddleName(customerList.get(0).getMiddleName());
			setMiddleNameL(customerList.get(0).getMiddleNameLocal());
			setShortName(customerList.get(0).getShortName());
			setShortNameL(customerList.get(0).getShortNameLocal());
			setLastName(customerList.get(0).getLastName());
			setLastNameL(customerList.get(0).getLastNameLocal());
			setEmail(customerList.get(0).getEmail());
			setTitle(customerList.get(0).getTitle());
			setTitleL(customerList.get(0).getTitleLocal());
			setMobileNo(customerList.get(0).getMobile());
			setGender(customerList.get(0).getGender());
			setDateOfBirth(customerList.get(0).getDateOfBirth());
			setAlternateEmail(customerList.get(0).getAlterEmailId());
			setTokenKey(customerList.get(0).getTokenKey());
			setCreatedBy(customerList.get(0).getCreatedBy());
			setCreatedDate(customerList.get(0).getCreationDate());
			
			setAmlStatus("pass");
			setNumberOfHits("1");
			
			
			if(customerList.get(0).getActivatedInd() == "0") {
				setApproved(false);
			}else {
				setApproved(true);
			}
			
			
		//}
	}
	//Get country list and store into local map object  
		private void fillCountryList(){
			
			if(mapCountryList.size()==0){
				mapCountryList.clear();
			//	System.out.println("the laguageId"+getLanguageId());
				for(CountryMasterDesc countryMasterDesc : getGeneralService().getCountryList(getLanguageId())){
					mapCountryList.put(countryMasterDesc.getFsCountryMaster().getCountryId(), countryMasterDesc.getCountryName());
				}
				
			}
		}

		//Get state list and store into local map object  
		private void fillStateList(){
			
			if(mapStateList.size()==0){
				mapStateList.clear();
				for(StateMasterDesc stateMasterDesc : getGeneralService().getStateList(languageId)){
					mapStateList.put(stateMasterDesc.getFsStateMaster().getStateId(), stateMasterDesc.getStateName());
				}
			}
		}
		
		//Get district list and store into local map object 
		private void fillDistrictList(){
			
			if(mapDistirictList.size()==0){
				mapDistirictList.clear();
				for(DistrictMasterDesc districtMasterDesc : getGeneralService().getDistrictList(getLanguageId())){
					mapDistirictList.put(districtMasterDesc.getFsDistrictMaster().getDistrictId(), districtMasterDesc.getDistrict());
				}
			}
		}
		
		//Get city list and store into local map object  
		private void fillCityList(){
			
			if(mapCityList.size()==0){
				mapCityList.clear();
				for(CityMasterDesc cityMasterDesc : getGeneralService().getCityList(getLanguageId())){
					mapCityList.put(cityMasterDesc.getFsCityMaster().getCityId(), cityMasterDesc.getCityName());
				}
			}
		}
	public void setContactDetails() {
		System.out.println("the customer id inside contact details is"+getCustomerId());
		contactDetailList.addAll(getBranchpageService().getCustomerContactDetails(getCustomerId()));
		System.out.println("the contact details list size is"+contactDetailList.size());
		if(contactDetailList.size()>0) {
		
		for(ContactDetail cdetail: contactDetailList) {
			AddContactDetailBean addContactDetailBean = new AddContactDetailBean(cdetail.getFsContactType()
					.getContactType(), cdetail.getArea(),
					mapCountryList.get(cdetail.getFsCountryMaster()
							.getCountryId()), cdetail.getStreet(),
					cdetail.getBlock(), cdetail.getTelephone(),
					cdetail.getFlat(), mapStateList.get(cdetail
							.getFsStateMaster().getStateId()),
					mapDistirictList.get(cdetail.getFsDistrictMaster()
							.getDistrictId()), mapCityList.get(cdetail
							.getFsCityMaster().getCityId()), false, false,
					cdetail.getFsContactType().getContactTypeId(), cdetail
							.getFsCountryMaster().getCountryId(), cdetail
							.getFsStateMaster().getStateId(), cdetail
							.getFsDistrictMaster().getDistrictId(), cdetail
							.getFsCityMaster().getCityId(), cdetail
							.getContactDetailId());
			System.out.println("contact details id is"+cdetail.getContactDetailId());
			contactList.add(addContactDetailBean);
		}
		}
		
	}
	public void populateState() {
		sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> statemasterDesc = getGeneralService().getStateList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry());
	    setLstStateEmpList(statemasterDesc);
	}
	public void populateDistrict() {
		sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> districtmasterDesc = getGeneralService().getDistrictList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry(),getEmpInfoState());
	    setLstDistrictEmpList(districtmasterDesc);
	}
	public void populateCity() {
		sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> citymasterDesc = getGeneralService().getCityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getEmpInfoCountry(),getEmpInfoState(),getEmpInfoDistrict());
	    setLstCityEmpList(citymasterDesc);
	}
	public void setEmployeementInfo() {
		System.out.println("the customer id inside employee details is"+getCustomerId());
		customerEmploymentInfoList.addAll(getBranchpageService().getCustomerEmploymentInfo(getCustomerId()));
		System.out.println("the employeement list is"+customerEmploymentInfoList.size());
		if(customerEmploymentInfoList.size()>0) {
			System.out.println("the satae id is"+customerEmploymentInfoList.get(0).getFsStateMaster().getStateId());
			System.out.println("the district id is"+customerEmploymentInfoList.get(0).getFsDistrictMaster().getDistrictId());
			System.out.println("the city id is"+customerEmploymentInfoList.get(0).getFsCityMaster().getCityId());
			setEmpInfoEmploymentTypeId(customerEmploymentInfoList.get(0).getFsEmploymentType().getEmploymentTypeId());
			setOccupation(customerEmploymentInfoList.get(0).getOccupation());
			setEmployer(customerEmploymentInfoList.get(0).getEmployerName());
			setEmpInfoCountry(customerEmploymentInfoList.get(0).getFsCountryMaster().getCountryId());
			populateState();
			setEmpInfoState(customerEmploymentInfoList.get(0).getFsStateMaster().getStateId());
			populateDistrict();
			setEmpInfoDistrict(customerEmploymentInfoList.get(0).getFsDistrictMaster().getDistrictId());
			populateCity();
			setEmpInfoCity(customerEmploymentInfoList.get(0).getFsCityMaster().getCityId());
			setEmpInfoStreet(customerEmploymentInfoList.get(0).getStreet());
			setPostalCode(customerEmploymentInfoList.get(0).getPostal());
			setEmpInfoBlock(customerEmploymentInfoList.get(0).getBlock());
			setEmpInfoArea(customerEmploymentInfoList.get(0).getArea());
			setEmpInfoOfficeTel(customerEmploymentInfoList.get(0).getOfficeTelephone());
			setDepartment(customerEmploymentInfoList.get(0).getDepartment());
			setCustEmployeementInfoId(customerEmploymentInfoList.get(0).getCustEmpInfoId());
			
		}
	}
	/*
	 * method is responsible to clear basic info
	 * 
	 */
	public void clearBasicInfo() {
		System.out.println("inside basic clear");
		setMethodTypeId(null);
		setTokenNumber("");
		setIdNumber("");
	}
	/*
	 * method is responsible to back basic info and hide other panels
	 * 
	 */
	public void backCustomerInfoToBasicInfo() {
		System.out.println("inside back of basic");
		setRenderBasicInfo(true);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
	}
	/*
	 * method is responsible to clear  customer info
	 * 
	 */
	public void clearCustomerInfo() {
		System.out.println("inside cleare of customer");
		setFirstName("");
		setMiddleName("");
		setLastName("");
		setShortName("");
		setFirstNameL("");
		setMiddleNameL("");
		setLastNameL("");
		setShortNameL("");
		setTitle("");
		setGender("");
		setNationalityId(null);
		setEmail("");
		setIdExpiryDate(null);
		setDateOfBirth(null);
		setMobileNo("");
	}
	/*
	 * method is responsible to display (contact details) and hide other panels 
	 * 
	 */
	public void nextContactDetails() {
		System.out.println("inside contact details");
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(true);
		setSaveUptoPanel(2);
	}
	/*
	 * method is responsible to add contact in a dataTable
	 * 
	 */
	public void addContactDataTable() {
		System.out.println("inside contact details");
	    AddContactDetailBean addContact = new AddContactDetailBean();
	    
	    addContact.setContType(contactTypeMap.get(this.contactTypeId));
	    addContact.setContactTypeId(this.contactTypeId);
	    addContact.setCountryId(this.countryId);
	    addContact.setCountry(mapCountryList.get(this.countryId));
	    addContact.setStateId(this.stateId);
	    addContact.setState(mapStateList.get(this.stateId));
	    addContact.setDistrictId(this.districtId);
	    addContact.setDist(mapDistirictList.get(this.districtId));
	    addContact.setCityId(this.cityId);
	    addContact.setCity(mapCityList.get(this.cityId));
	    addContact.setArea(this.localArea);
	    addContact.setStreet(this.streetNo);
	    addContact.setFlat(this.flatNo);
	    addContact.setTel(this.telephoneNo);
	    addContact.setBlock(this.blockNo);
		contactList.add(addContact);
		setContactTypeId(new BigDecimal(0));
		setCountryId(new BigDecimal(0));
		setStateId(new BigDecimal(0));
		setDistrictId(new BigDecimal(0));
		setCityId(new BigDecimal(0));
		setLocalArea("");
		setStreetNo("");
		setBlockNo("");
		setTelephoneNo("");
		setFlatNo("");
		setEnableContactDataTable(true);
	}
	public void addRows() {
		
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
		System.out.println("the id type is"+this.idTypeproof);
		System.out.println("the id type is"+idTypeMap.get(this.idTypeproof));
		CreateProofTable createProofTable = new CreateProofTable(this.idFor, this.idTypeproof, this.idnumberProof, df, "insert", 0, 
															idForMap.get(this.idFor), idTypeMap.get(this.idTypeproof), image_id);
		createProofList.add(createProofTable);

		setEnablePTbl(true);
		
		//setExpDate(null);
		setDateExp(null);
		setIdTypeproof("");
		setIdnumberProof("");
		setIdFor("");
	} catch (Exception e) {

	}
	}
	public void removeContactDetail(AddContactDetailBean bean) {
		System.out.println("inside remove contact details beaan");
	contactList.remove(bean);
	if (bean.getContactDetailsId() != new BigDecimal(0)) {
	contactListDelete.add(bean);
	}
	}
	public void removeIdProof(CreateProofTable proofTable) {
		createProofList.remove(proofTable);
		if (proofTable.getCustomerIdProofId() != new BigDecimal(0)) {	
		createProofListDelete.add(proofTable);
		}
	}
	/*
	 * method is responsible to clear contact details
	 * 
	 */
	public void clearContactDetails() {
		System.out.println("inside clear contacts");
		setContactTypeId(new BigDecimal(0));
		setCountryId(new BigDecimal(0));
		setStateId(new BigDecimal(0));
		setDistrictId(new BigDecimal(0));
		setCityId(new BigDecimal(0));
		setLocalArea("");
		setStreetNo("");
		setBlockNo("");
		setTelephoneNo("");
		setFlatNo("");
	}
	/*
	 * method is responsible to display customer info
	 * 
	 */
	public void backToCustomerInfo() {
		System.out.println("back to customer info from contacts");
		setRenderCustomeInfoEditable(true);
		setRenderCustomeInfoLocal(true);
		setRenderCustomerDetails(true);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
		setRenderIdProof(false);
		setRenderBasicInfo(false);
		
	}
	public void nextToEmpInfo() {
		System.out.println("next to emp");
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
		setRenderIdProof(false);
		setSaveUptoPanel(3);
		setRenderEmployeementInfo(true);
	}
	public void bactToContactMatch() {
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderCustomerDetails(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(true);
		setRenderIdProof(false);
		setRenderBasicInfo(false);
		setRenderEmployeementInfo(false);
		
	}
	/*
	 * method is responsible to display scan document
	 * 
	 */
	public void nextToScanDoc() {
		System.out.println("next to scan doc");
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
		setRenderEmployeementInfo(false);
		setRenderIdProof(true);
	}
	public void backTOContact() {
		System.out.println("back to contact");
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(true);
		setRenderEmployeementInfo(false);
		
	}
	public void nextToDigital() {
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
		setRenderDigitalSign(true);
	}
	public void bactToEmpInfo() {
		setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
		setRenderDigitalSign(false);
		setRenderIdProof(false);
		setRenderEmployeementInfo(true);
	}
	/*
	 * method is responsible to save the customer details 
	 */
	public String saveCustomerInfo() {
        customer = new Customer();
        companyMaster = new CompanyMaster();
        langType = new LanguageType();
        countryMaster = new CountryMaster();
        countryMasterForNationality  = new CountryMaster();
        customer.setTokenKey(getTokenNumber());
        countryMaster.setCountryId(getNationalityId());
        countryMasterForNationality.setCountryId(getNationalityId());     
        companyMaster = new CompanyMaster();
		companyMaster.setCompanyId(new BigDecimal(1));
		
		/*Customer Type*/
		CustomerType customerType = new CustomerType();
		customerType.setCustomerTypeId(new BigDecimal(1));
		
		/*TODO Hard coded Group ID*/
		CompanyGroup companyGroup = new CompanyGroup();
		companyGroup.setGroupId(new BigDecimal(1));
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
			setLanguageId(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().
																			equalsIgnoreCase("ar") ? new BigDecimal(2) : new BigDecimal(1));
		}
        langType.setLanguageId(getLanguageId());
        customer.setFsCountryMasterByCountryId(countryMaster);
        customer.setFsCountryMasterByNationality( countryMasterForNationality);
        customer.setFsLanguageType(langType);
        customer.setFsCustomerType(customerType);
        customer.setFsCompanyGroup(companyGroup);
        customer.setFsCompanyMaster(companyMaster);
        customer.setFirstName(getFirstName());
        customer.setLastName(getLastName() );
        customer.setFirstNameLocal(getFirstNameL());
        customer.setLastNameLocal(getLastNameL());
        customer.setMiddleName(getMiddleName());
        customer.setMiddleNameLocal(getMiddleNameL());
        customer.setShortName(getShortName());
        customer.setShortNameLocal(getShortNameL());
        customer.setTokenKey(getTokenKey());
        customer.setGender(getGender());
		//customer.setI
		System.out.println("the date of birth"+getDateOfBirth());
		System.out.println("the mobile no is"+getMobileNo());
		System.out.println("the email id is"+getEmail());
		System.out.println("the customer id is"+getCustomerId());
        customer.setDateOfBirth(getDateOfBirth());
        customer.setMobile(getMobileNo());
        customer.setEmail(getEmail());
        customer.setCustomerId(getCustomerId());
        customer.setTitle(getTitle());
        customer.setAmlStatus(getAmlStatus());
        customer.setAmlStatusLastUpdated(new Date());
        customer.setAmlStatusUpdatedBy(userName);
        customer.setUpdatedBy(userName);
    	customer.setLastUpdated(new Date());
    	customer.setAlterEmailId(getAlternateEmail());
    	
    	/*Seeting Article ID*/
		ArticleDetails details = new ArticleDetails();
		details.setArticleDetailId(getArticle());
		customer.setFsArticleDetails(details);
		
       if(isApproved()){
			customer.setActivatedInd("1");
			customer.setActivatedDate(new Date());
			customer.setVerificationBy(userName);
			customer.setVerificationDate(new Date());
		} else {
			customer.setActivatedInd("0");
			customer.setInactivatedDate(new Date());
		}
        /*It will return true always, except the very first time*/  
        /*if(getCustomerId() != null) {
        	customer.setCustomerId(getCustomerId());
        	customer.setUpdatedBy(userName);
        	customer.setLastUpdated(new Date());
        	getBranchpageService().saveOrUpdateVerifiedCustomer(customer);
        }else {*/
            getBranchpageService().saveOrUpdateVerifiedCustomer(customer);
            customerIdToNominee = customer.getCustomerId();
      //  }
      //  saveContactDetails();
        
        //customer.setUpdatedBy(updatedBy);
       // customer.set
            System.out.println("the updated customer id is"+getCustomerId());
    		/*setRenderBasicInfo(false);
    		setRenderCustomerDetails(false);
    		setRenderCustomeInfoEditable(false);
    		setRenderCustomeInfoLocal(false);
    		setRenderContactDetails(false);
    		setRenderContactDetailsMatch(true);
    		//setRenderEmployeementInfo(true);
*/		return"";
	}
   public void	saveContactDetails(){
	       customer = new Customer();
	       if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
				setLanguageId(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().
																				equalsIgnoreCase("ar") ? new BigDecimal(2) : new BigDecimal(1));
			}
	   try {
			for (AddContactDetailBean addContact : contactList) {
				System.out.println("the customer id inside contact details is"+getCustomerId());
				
				contactDetail = new ContactDetail();
				customer.setCustomerId(getCustomerId());
				contactDetail.setFsCustomer(customer);
				langType = new LanguageType();
				countryMaster = new CountryMaster();
				stateMaster = new StateMaster();
				districtMaster = new DistrictMaster();
				cityMaster = new CityMaster();

				contactType = new ContactType();

				contactType.setContactTypeId(addContact.getContactTypeId());
				countryMaster.setCountryId(addContact.getCountryId());
				stateMaster.setStateId(addContact.getStateId());
				districtMaster.setDistrictId(addContact.getDistrictId());
				cityMaster.setCityId(addContact.getCityId());
				contactDetail.setFsContactType(contactType);
				contactDetail.setFsCountryMaster(countryMaster);
				contactDetail.setFsDistrictMaster(districtMaster);
				contactDetail.setFsStateMaster(stateMaster);
				contactDetail.setFsCityMaster(cityMaster);
				langType.setLanguageId(getLanguageId());
				contactDetail.setFsLanguageType(langType);
				contactDetail.setAlterEmailId(getEmail());
				contactDetail.setArea(addContact.getArea());
				contactDetail.setBlock(addContact.getBlock());
				contactDetail.setStreet(addContact.getStreet());
				contactDetail.setFlat(addContact.getFlat());
				//contactDetail.setAlterEmailId(getEmail());// doubt
				contactDetail.setApproved(userName);// doubt
				contactDetail.setTelephone(addContact.getTel());
				contactDetail.setContactDetailId(addContact
						.getContactDetailsId());
				contactDetail.setCreatedBy(userName);
				contactDetail.setCreationDate(new Date());
				contactDetail.setUpdatedBy(userName);
				contactDetail.setLastUpdated(new Date());
				/*if (addContact.isObjstatus() == true
						&& addContact.isModified() == true) {*/
					contactDetail.setCreatedBy(userName);
					contactDetail.setCreationDate(new Date());
					contactDetail.setActiveStatus("1");
					getCorpRegService().saveCorporateContDtl(contactDetail);
					/*setRenderBasicInfo(false);
		    		setRenderCustomerDetails(false);
		    		setRenderCustomeInfoEditable(false);
		    		setRenderCustomeInfoLocal(false);
		    		setRenderContactDetails(false);
		    		setRenderContactDetailsMatch(false);
				    setRenderEmployeementInfo(true);*/
/*
				if (addContact.isModified() == true
						&& addContact.isObjstatus() == false) {
					contactDetail.setUpdatedBy(userName);
					contactDetail.setLastUpdated(new Date());
					contactDetail.setActiveStatus("0");
					getCorpRegService().updateContact(contactDetail,
							contactDetail.getContactDetailId());
				}*/
			}
			for (AddContactDetailBean addContact : contactListDelete) {
				contactDetail = new ContactDetail();
				customer.setCustomerId(getCustomerId());
				contactDetail.setFsCustomer(customer);
				langType = new LanguageType();
				countryMaster = new CountryMaster();
				stateMaster = new StateMaster();
				districtMaster = new DistrictMaster();
				cityMaster = new CityMaster();
				contactType = new ContactType();
				contactType.setContactTypeId(addContact.getContactTypeId());
				countryMaster.setCountryId(addContact.getCountryId());
				stateMaster.setStateId(addContact.getStateId());
				districtMaster.setDistrictId(addContact.getDistrictId());
				cityMaster.setCityId(addContact.getCityId());
				contactDetail.setFsContactType(contactType);
				contactDetail.setFsCountryMaster(countryMaster);
				contactDetail.setFsDistrictMaster(districtMaster);
				contactDetail.setFsStateMaster(stateMaster);
				contactDetail.setFsCityMaster(cityMaster);
				langType.setLanguageId(getLanguageId());
				contactDetail.setFsLanguageType(langType);
				contactDetail.setAlterEmailId(getEmail());
				contactDetail.setArea(addContact.getArea());
				contactDetail.setBlock(addContact.getBlock());
				contactDetail.setStreet(addContact.getStreet());
				contactDetail.setFlat(addContact.getFlat());
				contactDetail.setAlterEmailId(getEmail());// doubt
				contactDetail.setApproved(userName);// doubt
				contactDetail.setTelephone(addContact.getTel());
				contactDetail.setContactDetailId(addContact
						.getContactDetailsId());
				contactDetail.setActiveStatus("0");
				contactDetail.setCreatedBy(userName);
				contactDetail.setCreationDate(new Date());
				contactDetail.setUpdatedBy(userName);
				contactDetail.setLastUpdated(new Date());
				contactDetail.setUpdatedBy(userName);
				contactDetail.setLastUpdated(new Date());

				getCorpRegService().updateContact(contactDetail,
						contactDetail.getContactDetailId());
				// }
			}
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception ioexp) {
			ioexp.printStackTrace();
		}
	    /*setRenderBasicInfo(false);
		setRenderCustomerDetails(false);
		setRenderCustomeInfoEditable(false);
		setRenderCustomeInfoLocal(false);
		setRenderContactDetails(false);
		setRenderContactDetailsMatch(false);
	    setRenderEmployeementInfo(true);*/
   }
   public void saveEmployeementInfo() {
	    CustomerEmploymentInfo custEmp = new CustomerEmploymentInfo();
	    if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
			setLanguageId(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().
																			equalsIgnoreCase("ar") ? new BigDecimal(2) : new BigDecimal(1));
		}

		EmploymentType employmentType = new EmploymentType();
		employmentType.setEmploymentTypeId(getEmpInfoEmploymentTypeId());
		langType = new LanguageType();
		countryMaster = new CountryMaster();
		stateMaster = new StateMaster();
		districtMaster = new DistrictMaster();
		cityMaster = new CityMaster();
		customer = new Customer();
		customer.setCustomerId(getCustomerId());
		langType.setLanguageId(getLanguageId());
		countryMaster.setCountryId(getEmpInfoCountry());
		stateMaster.setStateId(getEmpInfoState());
		districtMaster.setDistrictId(getEmpInfoDistrict());
		cityMaster.setCityId(getEmpInfoCity());
		custEmp.setFsCustomer(customer);
		custEmp.setFsLanguageType(langType);
		custEmp.setFsCountryMaster(countryMaster);
		custEmp.setFsStateMaster(stateMaster);
		custEmp.setFsDistrictMaster(districtMaster);
		custEmp.setFsCityMaster(cityMaster);
		custEmp.setOccupation(getOccupation());
		custEmp.setEmployerName(getEmployer());
		custEmp.setFsEmploymentType(employmentType);
		custEmp.setDepartment(getDepartment());
		custEmp.setArea(getEmpInfoArea());
		custEmp.setBlock(getEmpInfoBlock());
		custEmp.setStreet(getEmpInfoStreet());
		custEmp.setOfficeTelephone(getEmpInfoOfficeTel());
		custEmp.setPostal(getPostalCode());
		custEmp.setCustEmpInfoId(getCustEmployeementInfoId());
		
		if(getCustEmployeementInfoId()!=null) {
			custEmp.setUpdatedBy(userName);
			custEmp.setLastUpdated(new Date());
			getBranchpageService().saveOrUpdateEmpInfo(custEmp);
		}else {
			custEmp.setCreatedBy(userName);
			custEmp.setCreationDate(new Date());
			getBranchpageService().saveOrUpdateEmpInfo(custEmp);
		}
		
		 /*setRenderBasicInfo(false);
			setRenderCustomerDetails(false);
			setRenderCustomeInfoEditable(false);
			setRenderCustomeInfoLocal(false);
			setRenderContactDetails(false);
			setRenderContactDetailsMatch(false);
		    setRenderEmployeementInfo(false);
		    setRenderIdProof(true);*/
   }
   
   public String saveCustomerIdProof() throws ParseException {
	   
	   saveCustomerInfo();
	   saveContactDetails();
	   saveEmployeementInfo();
	   
	   if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
			setLanguageId(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().
																			equalsIgnoreCase("ar") ? new BigDecimal(2) : new BigDecimal(1));
		}
	    CustomerType customerType = new CustomerType();
		customerType.setCustomerTypeId(new BigDecimal("1"));
		
		customer = new Customer();
		customer.setCustomerId(getCustomerId());
		IdentityType idType =new IdentityType();
		langType = new LanguageType();
		langType.setLanguageId(getLanguageId());
		for (CreateProofTable createProofTable : createProofList){
			CustomerIdProof custProof = new CustomerIdProof();
			custProof.setFsCustomer(customer);
			custProof.setFsLanguageType(langType);
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
			
			custProof.setCustProofId(createProofTable.getCustomerIdProofId());
            if(createProofTable.getCustomerIdProofId()!= null) {
            	custProof.setUpdatedBy(userName);
            	custProof.setLastUpdatedDate(new Date());
            	getBranchpageService().saveOrUpdateCustomerIdProof(custProof);
            } else {
            	custProof.setCreatedBy(userName);
    			custProof.setCreationDate(new Date());
    			getBranchpageService().saveOrUpdateCustomerIdProof(custProof);
            }
		}
		
		for (CreateProofTable createProofTable : createProofListDelete){
			
			langType = new LanguageType();
			langType.setLanguageId(getLanguageId());
			CustomerIdProof custProof = new CustomerIdProof();
			custProof.setFsCustomer(customer);
			custProof.setFsLanguageType(langType);
			custProof.setFsCustomerType(customerType);
			idType.setIdentityTypeId(new BigDecimal(createProofTable.getId_type()));
			custProof.setFsIdentityType(idType);
			
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
			custProof.setCreatedBy(userName);
			custProof.setCreationDate(new Date());
			custProof.setCustProofId(createProofTable.getCustomerIdProofId());

			getBranchpageService().saveOrUpdateCustomerIdProof(custProof);
		}
		
		if(getNominee()) {
			System.out.println("FROM BRANCH PAGE : "+customerIdToNominee);
			getNomineeRegistration().setNominatorId(customerIdToNominee);
			return "nominee";
		} else {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
				context.invalidateSession();
				context.redirect("../common/success.xhtml");
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
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

public Blob storeImage() throws IOException, SerialException, SQLException {
   	InputStream stream = null;
   	try {
   		stream =  file.getInputstream();
        }catch(Exception e){
           e.printStackTrace();
        }
   	return new javax.sql.rowset.serial.SerialBlob(readFully(stream));
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

 public void veryfiAllClick() {
	 System.out.println("the verify method is call");
	if(isApproved()){
		for (CreateProofTable element : createProofList) {
			element.setChecked(true);
		}
	} else{
		for (CreateProofTable element : createProofList) {
			element.setChecked(false);
		}
	}
}
public String getIdnumberProof() {
	return idnumberProof;
}

public void setIdnumberProof(String idnumberProof) {
	this.idnumberProof = idnumberProof;
}

/*************************************************Rule Engine Implementation***************************************************/
/**
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

/**
 * Responsible to get the page ID
 */
private void setPageIdIntoSession(){
	String pageName = FacesContext.getCurrentInstance().getViewRoot().getViewId();
	pageName = pageName.substring(pageName.lastIndexOf('/')+1, pageName.indexOf(".xhtml"));
	
	try{
		BigDecimal pageId = getGeneralService().getPageId(pageName);
		new SessionStateManage().setSessionValue("pageId", pageId.toString());
	}catch(Exception e){
		log.info("Page id not found for pagename :: "+pageName+" :: "+e);
	}
}

/**
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
																			"Alternate Email",
                                                                            "Date of Birth",
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
	mapComponentBehavior =  getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
}



/*********************************************12/06/2014***************************************************/
	
	private BigDecimal article = null;
	private BigDecimal level = null;
	private List<ArticleDetails> lstLevel = new ArrayList<ArticleDetails>(); 
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
	
	public Boolean getNominee() {
		return nominee;
	}
	public void setNominee(Boolean nominee) {
		this.nominee = nominee;
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

	

}  


