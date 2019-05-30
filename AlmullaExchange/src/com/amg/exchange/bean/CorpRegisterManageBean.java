package com.amg.exchange.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

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

import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CityMasterDesc;
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
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.LanguageType;
import com.amg.exchange.model.RuleBusinessNature;
import com.amg.exchange.model.RuleObjective;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.model.StateMasterDesc;
import com.amg.exchange.service.ICorporateRegService;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@SuppressWarnings({ "unused"})
@Component("corpregisterBean")
@Scope("session")
public class CorpRegisterManageBean<T> implements Serializable {

	private Logger log=Logger.getLogger(CorpRegisterManageBean.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICorporateRegService<T> corpRegService;

	@Autowired
	IGeneralService<T> generalService;
	
	

	private String crno;

	private String compName;

	private String compNameL;

	private Date compRegDate;
	
	private Date dateAdderForReg = new Date();

	private boolean disableDate = false;
	
	private boolean disableAML = true;
	
	private String email;
	
	private BigDecimal location;
	
	private Part part;
	
	private BigDecimal languageId ;
	
	private List<CountryMaster> countryCodeWithId;
	
	private List<StateMaster> stateCodeWithId;
	
	private String	contactPerson;
	private BigDecimal contactNumber;
	private String hitCount;

	// private Integer tel;

	// contact Details
	private BigDecimal contType;

	private String area;

	private BigDecimal countryId;

	private String street;

	private String block;

	private String tel;

	private String flat;
	
	private BigDecimal stateId;

	private BigDecimal distId;
    
    private BigDecimal cityId;
    private BigDecimal contactDetailId = null;
    
    private Boolean contactTypeVisibility = false;
    
    private Boolean countryVisibility = false;
   
    private Boolean stateVisibility = false;
    
    private Boolean districtVisibility = false;
    
    private Boolean cityVisibility = false;
    
    private Boolean areaVisibility = false;
     
    private Boolean streetVisibility = false;
    
    private Boolean blockVisibility = false;
    
    private Boolean telephoneVisibility = false;
    
    private Boolean flatVisibility = false;
    
    private Boolean duplicateContact = false;
    
    private Boolean contactListSizeVisibility = false;
   
	// Company Identity Document
	private String idno;

	private BigDecimal idtype;

	private Date idExpDate;

	private Part coPart;
	
	private String iDNoStatus;
	
	private String expDateAdder;
	
	private Boolean coIdVisibility = false;
	
	private Boolean coIdTypeVisibility = false;
	
	private Boolean coExpDateVisibility = false;
	
	private Boolean coDublicateVisibility = false;
	
	private Boolean coUploadFileVisibility = false;
	
	private Boolean identityListVisibility  = false;

	// Partners Details
	private String partName;

	private String pidno;

	private BigDecimal pidtype;

	private Date pidExpDate;

	private Part ppart;
	
	private List<CustomerIdProof>  partnerIdNoList;
	
	private String pIdNoStatus;
	
    private Boolean partnerIdVisibility = false;
	
	private Boolean partnerIdTypeVisibility = false;
	
	private Boolean partnerExpDateVisibility = false;
	
	private Boolean partnerDublicateVisibility = false;
	
	private Boolean partnerNameVisibility = false;
	
	private Boolean partnerUploadFileVisibility = false;

	// Authorized Signatories

	private String name;

	private String sidno;

	private BigDecimal sidtype;

	private Date sidExpDate;

	private Date effDate;

	private Date endDate;
	
	private Date effectiveMinDate = new Date();

	private Part spart;
	
	private List<CustomerIdProof>  authorSigIdNoList;
	
	private String sigIdNoStatus;
	
    private Boolean  authourisedIdVisibility = false;
	
	private Boolean  authourisedTypeVisibility = false;
	
	private Boolean  authourisedExpDateVisibility = false;
	
	private Boolean  authourisedDublicateVisibility = false;
	
	private Boolean  authourisedOwnerNameVisibility = false;
	
	private Boolean  authourisedEffDateVisibility = false;
	
	private Boolean  authourisedEndDateVisibility = false;
	
	private Boolean authorUploadFileVisibility = false;
	
	private Boolean authourisedListVisibility = false;

	//
	
	private BigDecimal primaryObjId;

	private BigDecimal seconObj;
	
	private BigDecimal custCorporateAdditionalId = null;
	
	private Boolean primayObjVisibility = false;
	
	private Boolean secondaryObjVisibility = false;
	
	private Boolean secondaryObjDuplicate = false;
	
	private Boolean secondaryListVisibility = false;
	
	private BigDecimal customerIdProofIdForPartner = null;
	private BigDecimal customerIdProofIdForCompanyIdentityDoc = null;
	private BigDecimal customerIdProofIdForOwner = null;
	
	

	private BigDecimal bussNature;

	private String obj;
	private BigDecimal corporateBusenessNatureId = null;
	
	private Boolean primaySecondaryBussnessVisibility = false;
	
	private Boolean natureBussineesVisibility = false;
	
	private Boolean bussenessDuplicateVisibility = false;
	
	private Boolean busenessListVisibility = false;
	/** Date Format Initialization */
	private final static String DATE_FORMAT = "dd/MM/yyyy";
	// Company Identity Document
    private boolean isImageSave=true;
	private List<CustomerIdProof> viewCustomerIdProof = new ArrayList<CustomerIdProof>();
	
	//image upload and download
	private UploadedFile identityfile;
	private UploadedFile  partnerfile;
	private UploadedFile  autherfile;
	private StreamedContent downloadFile;  
	private StreamedContent downloadFileForCompany; 
	private StreamedContent downloadFileForPartner; 
	private StreamedContent downloadFileForOwner; 
	//for customer type
	String partnerCustomer = FacesContext.getCurrentInstance().
			getExternalContext().getRequestParameterMap().get("partnerCust");
	String ownerCustomer = FacesContext.getCurrentInstance().
			getExternalContext().getRequestParameterMap().get("ownerCust");
	String corporateCustomer = FacesContext.getCurrentInstance().
			getExternalContext().getRequestParameterMap().get("corporateCust");

	private BigDecimal image_id;
	
	private BigDecimal companyImageId;
	private BigDecimal partnerImageId;	
	private BigDecimal ownerImageId;
	private boolean enabledSignatoriesDataTable;

	private boolean enableddPartnerDataTable;

	private boolean enabledddCompanyDataTable;

	private boolean enableSecondaryObjDataTable;

	private boolean enableBussineesDataTable;
	
	private boolean companyRegisterIdStatus = false;
	
	private boolean PartnerRegisterIdStatus = false;
	
	private boolean authorRegisterIdStatus = false;
	
	//Hard Coded Values
	private BigDecimal bdCompanyIdType = new BigDecimal(2);
	private BigDecimal bdAuthorizedIdType = new BigDecimal(3);
	private BigDecimal bdPartnerIdType = new BigDecimal(4);
	
	Map<BigDecimal,String> mapCountryList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapDistrictList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapStateList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapCityList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapIdentityList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapCorporateBussineesList = new HashMap<BigDecimal, String>();
	
	Map<BigDecimal,String> mapPartnerDetailsList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapAuthorSiganatureList = new HashMap<BigDecimal, String>();
	Map<BigDecimal,String> mapObjectiveList = new HashMap<BigDecimal, String>();
	
	private List<AddContactDetailBean> contactListDelete = new ArrayList<AddContactDetailBean>();
	private List<AddPartnerDetailBean> partnerListDeleted = new ArrayList<AddPartnerDetailBean>();
	private List<AddAuthSignatoriesBean> authorisedListDeleted = new ArrayList<AddAuthSignatoriesBean>();
	private final ArrayList<AddCoIdentityDetailBean> identityListDeleted = new ArrayList<AddCoIdentityDetailBean>();
	private List<AddSecondaryObjectiveBean> secondryObjectiveListDeleted = new ArrayList<AddSecondaryObjectiveBean>();
	private List<AddNatureofBussnessBean> bussenessNatureListDeleted = new ArrayList<AddNatureofBussnessBean>();	

	private BigDecimal customerId;

	private String id;
	
	private UIComponent tableForm;

	private List<Customer> empList;

	private String statusMessage;
	
	private String AMLStatus;

	private List<Amlstatus> coAMLList;
	
	private boolean renderValidate = true;
	private boolean renderObjective =false;
	private boolean renderContactDetails = false;
	private boolean renderCoIdentityDoc = false;
	private boolean renderPartnerDetail = false;
	private boolean renderOwnerDetails = false;

	private boolean coAMLPass = true;
	
	private boolean coAMLFail = false;
	
	private boolean coAMLCommon = true;
	
	private boolean coValdtBtn = true;
	
	private boolean coSave = true;
	
	private boolean readOnly = false;
	private boolean readOnlyCompanyIdDoc=false;
	private boolean disableCompIdDco = false;
	private boolean saveOrFetch =true;
	
	private String userName=FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap().get("userName")
			.toString();

   //	private String userName="AlMulla";
	private BigDecimal customerTypeId;
	
	private ContactDetail contdetail = null;
	private List<CustomerIdProof> coIdentyList;
	private CorporateBusinessNature corpBussnsNature = null;
	private RuleBusinessNature ruleBussNature = null;
	private CustCorporateAddlDetail custCorpAddDetail = null;
	private CustomerIdProof custmrIdProof = null;
	private IdentityType identityType = null;
	private Customer cust = null;
	private CountryMaster countryMstr = null;
	private CompanyMaster companyMstr = null;
	private CustomerType custmrType = null;
	private LanguageType langType = null;
	private RuleObjective  ruleObjective = null;
	private StateMaster stateMaster = null;
	private DistrictMaster districtMaster = null;
	private CountryMaster  countryMaster = null;
	private ContactType  contactType = null;
	private CityMaster   cityMaster = null;
	

    private List<CountryBean> countryList = new  ArrayList<CountryBean>();
    
    private List<RuleObjective> rulObjectList ;

	private List<ContactType> contactTypeList;
    
    private  Map<BigDecimal, String>  contactTypeMap   = new  HashMap<BigDecimal,String>();
    
    private List<RuleBusinessNature> bussinessNatureList;
	
	private Map<BigDecimal,String>	countryMap = new  HashMap<BigDecimal,String>();
	
	private  Map<BigDecimal, String>  secondryObjMap   = new  HashMap<BigDecimal,String>();
	
	private  Map<BigDecimal, String>  contacttypeHashaMap   = new  HashMap<BigDecimal,String>();

	private  Map<BigDecimal, String>  bussinessNatureHashaMap   = new  HashMap<BigDecimal,String>();
	
	private List<StateMasterDesc> lstState;
	
	private List<CityMasterDesc>lstCity;
	
	private List<StateBean> stateBeanList =  new ArrayList<StateBean>();
	
	private List<DistrictMasterDesc> distmasterList = new ArrayList<DistrictMasterDesc>();
	
	private List<DistrictBean> distBeanList = new  ArrayList<DistrictBean>();
	
	private List<CityBean>    cityBeanList = new ArrayList<CityBean>();
	
	private  List<IdentityType> lstCompanyIdentityType = new ArrayList<IdentityType>();
	private  List<IdentityType> lstPartnerIdentityType = new ArrayList<IdentityType>();
	private  List<IdentityType> lstAuthorizedIdentityType = new ArrayList<IdentityType>();

	private  List<IdentityType> identTypList = new ArrayList<IdentityType>();
	
	private Map<BigDecimal,String> cityHashaMap = new HashMap<BigDecimal,String>();
	
    private Map<BigDecimal,String> stateHashaMap = new HashMap<BigDecimal,String>();
    
    private Map<BigDecimal,String> companyIdentityTypeHashaMap = new HashMap<BigDecimal,String>();
    
    private  Map<BigDecimal,String> partnerIdentityTypeHashaMap = new HashMap<BigDecimal,String>();
    
    private  Map<BigDecimal,String> authorizedIdentityTypeHashaMap = new HashMap<BigDecimal,String>();
    
    private Map<BigDecimal,String> hashMapdistrict = new HashMap<BigDecimal, String>();
    
    private List<Customer> customerList;
    
    private List<StateMasterDesc> lstStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstCityList = new ArrayList<CityMasterDesc>();
	//Private List<Cus>

    Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();

    
    DocumentImg document = new DocumentImg();
    private String createdByCustomer;
    private Date createdDateCustomer;
    private String createdBySecondary;
    private Date createdDateSecondary;
    private String createdByBusseness;
    private Date createdDateBusseness;
    private String createdByContact;
    private Date createdDateContact;
    private String createdByComapany;
    private Date createdDateCompany;
    private String createdByPartner;
    private Date createdDatePartner;
    private String createdByOwner;
    private Date createdDateOwner;
	private SessionStateManage  sessionStateManage = null;
	private boolean renderRegisterPartner = false;
	private String registerId;
	private boolean readOnlyPartnerName = false;
	private boolean addPartner = false;
	private boolean renderImage=false;
	//TODO : Getter & Setter Part
    
    public UploadedFile getIdentityfile() {
    	return identityfile;
    }
   
	

	public boolean isSaveOrFetch() {
		return saveOrFetch;
	}



	public void setSaveOrFetch(boolean saveOrFetch) {
		this.saveOrFetch = saveOrFetch;
	}



	public boolean isRenderImage() {
		return renderImage;
	}



	public void setRenderImage(boolean renderImage) {
		this.renderImage = renderImage;
	}



	public boolean isAddPartner() {
		return addPartner;
	}



	public void setAddPartner(boolean addPartner) {
		this.addPartner = addPartner;
	}



	public boolean isReadOnlyPartnerName() {
		return readOnlyPartnerName;
	}



	public void setReadOnlyPartnerName(boolean readOnlyPartnerName) {
		this.readOnlyPartnerName = readOnlyPartnerName;
	}



	public boolean isRenderRegisterPartner() {
		return renderRegisterPartner;
	}



	public void setRenderRegisterPartner(boolean renderRegisterPartner) {
		this.renderRegisterPartner = renderRegisterPartner;
	}



	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public boolean isDisableCompIdDco() {
		return disableCompIdDco;
	}

	public void setDisableCompIdDco(boolean disableCompIdDco) {
		this.disableCompIdDco = disableCompIdDco;
	}

	public boolean isReadOnlyCompanyIdDoc() {
		return readOnlyCompanyIdDoc;
	}

	public void setReadOnlyCompanyIdDoc(boolean readOnlyCompanyIdDoc) {
		this.readOnlyCompanyIdDoc = readOnlyCompanyIdDoc;
	}

	public StreamedContent getDownloadFileForCompany() throws IOException {
		return downloadFileForCompany;
	}
	public void setDownloadFileForCompany(StreamedContent downloadFileForCompany) {
		this.downloadFileForCompany = downloadFileForCompany;
	}
	public StreamedContent getDownloadFileForPartner() {
		return downloadFileForPartner;
	}

	public void setDownloadFileForPartner(StreamedContent downloadFileForPartner) {
		this.downloadFileForPartner = downloadFileForPartner;
	}

	public StreamedContent getDownloadFileForOwner() {
		return downloadFileForOwner;
	}

	public void setDownloadFileForOwner(StreamedContent downloadFileForOwner) {
		this.downloadFileForOwner = downloadFileForOwner;
	}

	public String getCreatedByContact() {
		return createdByContact;
	}

	public void setCreatedByContact(String createdByContact) {
		this.createdByContact = createdByContact;
	}

	public Date getCreatedDateContact() {
		return createdDateContact;
	}

	public void setCreatedDateContact(Date createdDateContact) {
		this.createdDateContact = createdDateContact;
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

	public Date getCreatedDateOwner() {
		return createdDateOwner;
	}

	public void setCreatedDateOwner(Date createdDateOwner) {
		this.createdDateOwner = createdDateOwner;
	}

	public Date getCreatedDateCustomer() {
		return createdDateCustomer;
	}

	public void setCreatedDateCustomer(Date createdDateCustomer) {
		this.createdDateCustomer = createdDateCustomer;
	}

	public Date getCreatedDateSecondary() {
		return createdDateSecondary;
	}

	public void setCreatedDateSecondary(Date createdDateSecondary) {
		this.createdDateSecondary = createdDateSecondary;
	}

	public Date getCreatedDateBusseness() {
		return createdDateBusseness;
	}

	public void setCreatedDateBusseness(Date createdDateBusseness) {
		this.createdDateBusseness = createdDateBusseness;
	}

	public Date getCreatedDateCompany() {
		return createdDateCompany;
	}

	public void setCreatedDateCompany(Date createdDateCompany) {
		this.createdDateCompany = createdDateCompany;
	}

	public Date getCreatedDatePartner() {
		return createdDatePartner;
	}

	public void setCreatedDatePartner(Date createdDatePartner) {
		this.createdDatePartner = createdDatePartner;
	}

	public String getCreatedByCustomer() {
		return createdByCustomer;
	}
	public void setCreatedByCustomer(String createdByCustomer) {
		this.createdByCustomer = createdByCustomer;
	}
	public String getCreatedBySecondary() {
		return createdBySecondary;
	}
	public void setCreatedBySecondary(String createdBySecondary) {
		this.createdBySecondary = createdBySecondary;
	}
	public String getCreatedByBusseness() {
		return createdByBusseness;
	}
	public void setCreatedByBusseness(String createdByBusseness) {
		this.createdByBusseness = createdByBusseness;
	}
	public String getCreatedByComapany() {
		return createdByComapany;
	}
	public void setCreatedByComapany(String createdByComapany) {
		this.createdByComapany = createdByComapany;
	}
	public String getCreatedByPartner() {
		return createdByPartner;
	}
	public void setCreatedByPartner(String createdByPartner) {
		this.createdByPartner = createdByPartner;
	}
	public String getCreatedByOwner() {
		return createdByOwner;
	}
	public void setCreatedByOwner(String createdByOwner) {
		this.createdByOwner = createdByOwner;
	}
	public BigDecimal getCompanyImageId() {
		return companyImageId;
	}
	public void setCompanyImageId(BigDecimal companyImageId) {
		this.companyImageId = companyImageId;
	}
	public BigDecimal getPartnerImageId() {
		return partnerImageId;
	}
	public void setPartnerImageId(BigDecimal partnerImageId) {
		this.partnerImageId = partnerImageId;
	}
	public BigDecimal getOwnerImageId() {
		return ownerImageId;
	}
	public void setOwnerImageId(BigDecimal ownerImageId) {
		this.ownerImageId = ownerImageId;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public BigDecimal getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(BigDecimal contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getHitCount() {
		return hitCount;
	}
	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}
	public BigDecimal getContactDetailId() {
		return contactDetailId;
	}
	public void setContactDetailId(BigDecimal contactDetailId) {
		this.contactDetailId = contactDetailId;
	}
	public BigDecimal getCustCorporateAdditionalId() {
		return custCorporateAdditionalId;
	}
	public void setCustCorporateAdditionalId(BigDecimal custCorporateAdditionalId) {
		this.custCorporateAdditionalId = custCorporateAdditionalId;
	}
	public BigDecimal getCustomerIdProofIdForPartner() {
		return customerIdProofIdForPartner;
	}
	public void setCustomerIdProofIdForPartner(
			BigDecimal customerIdProofIdForPartner) {
		this.customerIdProofIdForPartner = customerIdProofIdForPartner;
	}
	public BigDecimal getCustomerIdProofIdForCompanyIdentityDoc() {
		return customerIdProofIdForCompanyIdentityDoc;
	}
	public void setCustomerIdProofIdForCompanyIdentityDoc(
			BigDecimal customerIdProofIdForCompanyIdentityDoc) {
		this.customerIdProofIdForCompanyIdentityDoc = customerIdProofIdForCompanyIdentityDoc;
	}
	public BigDecimal getCustomerIdProofIdForOwner() {
		return customerIdProofIdForOwner;
	}
	public void setCustomerIdProofIdForOwner(BigDecimal customerIdProofIdForOwner) {
		this.customerIdProofIdForOwner = customerIdProofIdForOwner;
	}
	public BigDecimal getCorporateBusenessNatureId() {
		return corporateBusenessNatureId;
	}
	public void setCorporateBusenessNatureId(BigDecimal corporateBusenessNatureId) {
		this.corporateBusenessNatureId = corporateBusenessNatureId;
	}
	public boolean isRenderValidate() {
		return renderValidate;
	}
	public void setRenderValidate(boolean renderValidate) {
		this.renderValidate = renderValidate;
	}
	public boolean isRenderObjective() {
		return renderObjective;
	}
	public void setRenderObjective(boolean renderObjective) {
		this.renderObjective = renderObjective;
	}
	public boolean isRenderContactDetails() {
		return renderContactDetails;
	}
	public void setRenderContactDetails(boolean renderContactDetails) {
		this.renderContactDetails = renderContactDetails;
	}
	public boolean isRenderCoIdentityDoc() {
		return renderCoIdentityDoc;
	}
	public void setRenderCoIdentityDoc(boolean renderCoIdentityDoc) {
		this.renderCoIdentityDoc = renderCoIdentityDoc;
	}
	public boolean isRenderPartnerDetail() {
		return renderPartnerDetail;
	}
	public void setRenderPartnerDetail(boolean renderPartnerDetail) {
		this.renderPartnerDetail = renderPartnerDetail;
	}
	public boolean isRenderOwnerDetails() {
		return renderOwnerDetails;
	}
	public void setRenderOwnerDetails(boolean renderOwnerDetails) {
		this.renderOwnerDetails = renderOwnerDetails;
	}
	public Date getEffectiveMinDate() {
		return effectiveMinDate;
	}
	public void setEffectiveMinDate(Date effectiveMinDate) {
		this.effectiveMinDate = effectiveMinDate;
	}
	public Boolean getIdentityListVisibility() {
		return identityListVisibility;
	}
	public void setIdentityListVisibility(Boolean identityListVisibility) {
		this.identityListVisibility = identityListVisibility;
	}
	public Boolean getAuthourisedListVisibility() {
		return authourisedListVisibility;
	}
	public void setAuthourisedListVisibility(Boolean authourisedListVisibility) {
		this.authourisedListVisibility = authourisedListVisibility;
	}
	public Boolean getSecondaryListVisibility() {
		return secondaryListVisibility;
	}
	public void setSecondaryListVisibility(Boolean secondaryListVisibility) {
		this.secondaryListVisibility = secondaryListVisibility;
	}
	public Boolean getBusenessListVisibility() {
		return busenessListVisibility;
	}
	public void setBusenessListVisibility(Boolean busenessListVisibility) {
		this.busenessListVisibility = busenessListVisibility;
	}
	public Boolean getContactListSizeVisibility() {
		return contactListSizeVisibility;
	}
	public void setContactListSizeVisibility(Boolean contactListSizeVisibility) {
		this.contactListSizeVisibility = contactListSizeVisibility;
	}
	public boolean isDisableAML() {
		return disableAML;
	}
	public void setDisableAML(boolean disableAML) {
		this.disableAML = disableAML;
	}
	public Boolean getPartnerUploadFileVisibility() {
		return partnerUploadFileVisibility;
	}
	public void setPartnerUploadFileVisibility(Boolean partnerUploadFileVisibility) {
		this.partnerUploadFileVisibility = partnerUploadFileVisibility;
	}
	public Boolean getAuthorUploadFileVisibility() {
		return authorUploadFileVisibility;
	}
	public void setAuthorUploadFileVisibility(Boolean authorUploadFileVisibility) {
		this.authorUploadFileVisibility = authorUploadFileVisibility;
	}
	public Boolean getCoUploadFileVisibility() {
		return coUploadFileVisibility;
	}
	public void setCoUploadFileVisibility(Boolean coUploadFileVisibility) {
		this.coUploadFileVisibility = coUploadFileVisibility;
	}
	public void setIdentityfile(UploadedFile identityfile) {
    	this.identityfile = identityfile;
    }
    public UploadedFile getPartnerfile() {
    	return partnerfile;
    }
    public void setPartnerfile(UploadedFile partnerfile) throws IOException {
    	//System.out.println("................................................................................................."+partnerfile.getInputstream().available());
    	this.partnerfile = partnerfile;
    }
    public UploadedFile getAutherfile() {
    	return autherfile;
    }
    public void setAutherfile(UploadedFile autherfile) {
    	this.autherfile = autherfile;
    }
    
	public Boolean getAuthourisedIdVisibility() {
		return authourisedIdVisibility;
	}
	public boolean isCompanyRegisterIdStatus() {
		return companyRegisterIdStatus;
	}
	public void setCompanyRegisterIdStatus(boolean companyRegisterIdStatus) {
		this.companyRegisterIdStatus = companyRegisterIdStatus;
	}
	public boolean isPartnerRegisterIdStatus() {
		return PartnerRegisterIdStatus;
	}
	public void setPartnerRegisterIdStatus(boolean partnerRegisterIdStatus) {
		PartnerRegisterIdStatus = partnerRegisterIdStatus;
	}
	public boolean isAuthorRegisterIdStatus() {
		return authorRegisterIdStatus;
	}
	public void setAuthorRegisterIdStatus(boolean authorRegisterIdStatus) {
		this.authorRegisterIdStatus = authorRegisterIdStatus;
	}
	public boolean isDisableDate() {
		return disableDate;
	}
	public void setDisableDate(boolean disableDate) {
		this.disableDate = disableDate;
	}
	public Date getDateAdderForReg() {
		return dateAdderForReg;
	}
	public void setDateAdderForReg(Date dateAdderForReg) {
		this.dateAdderForReg = dateAdderForReg;
	}
	public Boolean getNatureBussineesVisibility() {
		return natureBussineesVisibility;
	}
	public void setNatureBussineesVisibility(Boolean natureBussineesVisibility) {
		this.natureBussineesVisibility = natureBussineesVisibility;
	}
	public Boolean getSecondaryObjDuplicate() {
		return secondaryObjDuplicate;
	}
	public void setSecondaryObjDuplicate(Boolean secondaryObjDuplicate) {
		this.secondaryObjDuplicate = secondaryObjDuplicate;
	}
	public Boolean getPrimayObjVisibility() {
		return primayObjVisibility;
	}
	public void setPrimayObjVisibility(Boolean primayObjVisibility) {
		this.primayObjVisibility = primayObjVisibility;
	}
	public Boolean getSecondaryObjVisibility() {
		return secondaryObjVisibility;
	}
	public void setSecondaryObjVisibility(Boolean secondaryObjVisibility) {
		this.secondaryObjVisibility = secondaryObjVisibility;
	}
	public Boolean getPrimaySecondaryBussnessVisibility() {
		return primaySecondaryBussnessVisibility;
	}
	public void setPrimaySecondaryBussnessVisibility(
			Boolean primaySecondaryBussnessVisibility) {
		this.primaySecondaryBussnessVisibility = primaySecondaryBussnessVisibility;
	}
	public Boolean getBussenessDuplicateVisibility() {
		return bussenessDuplicateVisibility;
	}
	public void setBussenessDuplicateVisibility(Boolean bussenessDuplicateVisibility) {
		this.bussenessDuplicateVisibility = bussenessDuplicateVisibility;
	}
	public void setAuthourisedIdVisibility(Boolean authourisedIdVisibility) {
		this.authourisedIdVisibility = authourisedIdVisibility;
	}
	public Boolean getAuthourisedTypeVisibility() {
		return authourisedTypeVisibility;
	}
	public void setAuthourisedTypeVisibility(Boolean authourisedTypeVisibility) {
		this.authourisedTypeVisibility = authourisedTypeVisibility;
	}
	public Boolean getAuthourisedExpDateVisibility() {
		return authourisedExpDateVisibility;
	}
	public void setAuthourisedExpDateVisibility(Boolean authourisedExpDateVisibility) {
		this.authourisedExpDateVisibility = authourisedExpDateVisibility;
	}
	public Boolean getAuthourisedDublicateVisibility() {
		return authourisedDublicateVisibility;
	}
	public void setAuthourisedDublicateVisibility(
			Boolean authourisedDublicateVisibility) {
		this.authourisedDublicateVisibility = authourisedDublicateVisibility;
	}
	public Boolean getAuthourisedOwnerNameVisibility() {
		return authourisedOwnerNameVisibility;
	}
	public void setAuthourisedOwnerNameVisibility(
			Boolean authourisedOwnerNameVisibility) {
		this.authourisedOwnerNameVisibility = authourisedOwnerNameVisibility;
	}
	public Boolean getAuthourisedEffDateVisibility() {
		return authourisedEffDateVisibility;
	}
	public void setAuthourisedEffDateVisibility(Boolean authourisedEffDateVisibility) {
		this.authourisedEffDateVisibility = authourisedEffDateVisibility;
	}
	public Boolean getAuthourisedEndDateVisibility() {
		return authourisedEndDateVisibility;
	}
	public void setAuthourisedEndDateVisibility(Boolean authourisedEndDateVisibility) {
		this.authourisedEndDateVisibility = authourisedEndDateVisibility;
	}
	public IGeneralService<T> getiGeneralService() {
		return generalService;
	}
	public Boolean getPartnerIdVisibility() {
		return partnerIdVisibility;
	}
	public void setPartnerIdVisibility(Boolean partnerIdVisibility) {
		this.partnerIdVisibility = partnerIdVisibility;
	}
	public Boolean getPartnerIdTypeVisibility() {
		return partnerIdTypeVisibility;
	}
	public void setPartnerIdTypeVisibility(Boolean partnerIdTypeVisibility) {
		this.partnerIdTypeVisibility = partnerIdTypeVisibility;
	}
	public Boolean getPartnerExpDateVisibility() {
		return partnerExpDateVisibility;
	}
	public void setPartnerExpDateVisibility(Boolean partnerExpDateVisibility) {
		this.partnerExpDateVisibility = partnerExpDateVisibility;
	}
	public Boolean getPartnerDublicateVisibility() {
		return partnerDublicateVisibility;
	}
	public void setPartnerDublicateVisibility(Boolean partnerDublicateVisibility) {
		this.partnerDublicateVisibility = partnerDublicateVisibility;
	}
	public Boolean getPartnerNameVisibility() {
		return partnerNameVisibility;
	}
	public void setPartnerNameVisibility(Boolean partnerNameVisibility) {
		this.partnerNameVisibility = partnerNameVisibility;
	}


	public Boolean getDuplicateContact() {
		return duplicateContact;
	}


	public void setDuplicateContact(Boolean duplicateContact) {
		this.duplicateContact = duplicateContact;
	}


	public Boolean getDistrictVisibility() {
		return districtVisibility;
	}

	public void setDistrictVisibility(Boolean districtVisibility) {
		this.districtVisibility = districtVisibility;
	}

	public Boolean getCityVisibility() {
		return cityVisibility;
	}

	public void setCityVisibility(Boolean cityVisibility) {
		this.cityVisibility = cityVisibility;
	}

	public Boolean getAreaVisibility() {
		return areaVisibility;
	}

	public void setAreaVisibility(Boolean areaVisibility) {
		this.areaVisibility = areaVisibility;
	}


	public Boolean getStreetVisibility() {
		return streetVisibility;
	}

	public void setStreetVisibility(Boolean streetVisibility) {
		this.streetVisibility = streetVisibility;
	}

	public Boolean getBlockVisibility() {
		return blockVisibility;
	}

	public void setBlockVisibility(Boolean blockVisibility) {
		this.blockVisibility = blockVisibility;
	}

	public Boolean getTelephoneVisibility() {
		return telephoneVisibility;
	}

	public void setTelephoneVisibility(Boolean telephoneVisibility) {
		this.telephoneVisibility = telephoneVisibility;
	}

	public Boolean getFlatVisibility() {
		return flatVisibility;
	}

	public void setFlatVisibility(Boolean flatVisibility) {
		this.flatVisibility = flatVisibility;
	}

	public Boolean getContactTypeVisibility() {
		return contactTypeVisibility;
	}

	public void setContactTypeVisibility(Boolean contactTypeVisibility) {
		this.contactTypeVisibility = contactTypeVisibility;
	}

	public Boolean getCountryVisibility() {
		return countryVisibility;
	}

	public void setCountryVisibility(Boolean countryVisibility) {
		this.countryVisibility = countryVisibility;
	}

	public Boolean getStateVisibility() {
		return stateVisibility;
	}

	public void setStateVisibility(Boolean stateVisibility) {
		this.stateVisibility = stateVisibility;
	}
	public Boolean getCoDublicateVisibility() {
		return coDublicateVisibility;
	}

	public void setCoDublicateVisibility(Boolean coDublicateVisibility) {
		this.coDublicateVisibility = coDublicateVisibility;
	}

	public Boolean getCoIdVisibility() {
		return coIdVisibility;
	}

	public void setCoIdVisibility(Boolean coIdVisibility) {
		this.coIdVisibility = coIdVisibility;
	}
	public Boolean getCoIdTypeVisibility() {
		return coIdTypeVisibility;
	}
	public void setCoIdTypeVisibility(Boolean coIdTypeVisibility) {
		this.coIdTypeVisibility = coIdTypeVisibility;
	}
	public Boolean getCoExpDateVisibility() {
		return coExpDateVisibility;
	}

	public void setCoExpDateVisibility(Boolean coExpDateVisibility) {
		this.coExpDateVisibility = coExpDateVisibility;
	}

	public Map<BigDecimal, String> getMapPartnerDetailsList() {
		return mapPartnerDetailsList;
	}

	public void setMapPartnerDetailsList(
			Map<BigDecimal, String> mapPartnerDetailsList) {
		this.mapPartnerDetailsList = mapPartnerDetailsList;
	}

	public Map<BigDecimal, String> getMapAuthorSiganatureList() {
		return mapAuthorSiganatureList;
	}

	public void setMapAuthorSiganatureList(
			Map<BigDecimal, String> mapAuthorSiganatureList) {
		this.mapAuthorSiganatureList = mapAuthorSiganatureList;
	}

	public Map<BigDecimal, String> getMapObjectiveList() {
		return mapObjectiveList;
	}

	public void setMapObjectiveList(Map<BigDecimal, String> mapObjectiveList) {
		this.mapObjectiveList = mapObjectiveList;
	}

	public Map<BigDecimal, String> getMapCountryList() {
		return mapCountryList;
	}

	public void setMapCountryList(Map<BigDecimal, String> mapCountryList) {
		this.mapCountryList = mapCountryList;
	}

	public Map<BigDecimal, String> getMapDistrictList() {
		return mapDistrictList;
	}

	public void setMapDistrictList(Map<BigDecimal, String> mapDistrictList) {
		this.mapDistrictList = mapDistrictList;
	}

	public Map<BigDecimal, String> getMapStateList() {
		return mapStateList;
	}
    
	public void setMapStateList(Map<BigDecimal, String> mapStateList) {
		this.mapStateList = mapStateList;
	}

	public Map<BigDecimal, String> getMapCityList() {
		return mapCityList;
	}

	public void setMapCityList(Map<BigDecimal, String> mapCityList) {
		this.mapCityList = mapCityList;
	}

	public List<IdentityType> getLstCompanyIdentityType() {
		lstCompanyIdentityType = new ArrayList<IdentityType>();
		BigDecimal countryId = new BigDecimal(120);  
		lstCompanyIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdCompanyIdType));
		for(IdentityType identityType:lstCompanyIdentityType) {
			companyIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
		return lstCompanyIdentityType;
	}

	public void setLstCompanyIdentityType(List<IdentityType> lstCompanyIdentityType) {
		this.lstCompanyIdentityType = lstCompanyIdentityType;
	}

	public List<IdentityType> getLstPartnerIdentityType() {
		BigDecimal countryId = new BigDecimal(120);
		lstPartnerIdentityType = new ArrayList<IdentityType>();
		lstPartnerIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdPartnerIdType));
		for(IdentityType identityType:lstPartnerIdentityType) {
			partnerIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
		return lstPartnerIdentityType;
	}

	public void setLstPartnerIdentityType(List<IdentityType> lstPartnerIdentityType) {
		this.lstPartnerIdentityType = lstPartnerIdentityType;
	}

	public List<IdentityType> getLstAuthorizedIdentityType() {
		BigDecimal countryId = new BigDecimal(120);
		lstAuthorizedIdentityType = new ArrayList<IdentityType>();
		lstAuthorizedIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdAuthorizedIdType));
		for(IdentityType identityType:lstAuthorizedIdentityType) {
			authorizedIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
		return lstAuthorizedIdentityType;
	}

	public void setLstAuthorizedIdentityType(
			List<IdentityType> lstAuthorizedIdentityType) {
		this.lstAuthorizedIdentityType = lstAuthorizedIdentityType;
	}

	public BigDecimal getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(BigDecimal customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public void setiGeneralService(IGeneralService<T> iGeneralService) {
		this.generalService = iGeneralService;
	}

	public ICorporateRegService<T> getCorpRegService() {
		return corpRegService;
	}

	public void setCorpRegService(ICorporateRegService<T> corpRegService) {
		this.corpRegService = corpRegService;
	}
	
	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal bigDecimal) {
		this.languageId = bigDecimal;
	}
	
	public String getiDNoStatus() {
		return iDNoStatus;
	}

	public void setiDNoStatus(String iDNoStatus) {
		this.iDNoStatus = iDNoStatus;
	}


	public BigDecimal getLocation() {
		return location;
	}

	public void setLocation( BigDecimal location) {
		this.location = location;
	}

	public Map<BigDecimal, String> getSecondryObjMap() {
    return secondryObjMap;
	}

	public void setSecondryMap(Map<BigDecimal, String> secondryMap) {
		
		
		this.secondryObjMap = secondryMap;
	}
	
	private boolean enableContactDataTable;

	public boolean isEnableContactDataTable() {
		return enableContactDataTable;
	}

	public void setEnableContactDataTable(boolean enableContactDataTable) {
		this.enableContactDataTable = enableContactDataTable;
	}
	
	 public List<ContactType> getContactTypeList() {
			return contactTypeList;
	 }

	 public void setContactTypeList(List<ContactType> contactTypeList) {
			this.contactTypeList = contactTypeList;
	 }

	public boolean isEnabledSignatoriesDataTable() {
		return enabledSignatoriesDataTable;
	}

	public void setEnabledSignatoriesDataTable(boolean enabledSignatoriesDataTable) {
		this.enabledSignatoriesDataTable = enabledSignatoriesDataTable;
	}

	public boolean isEnableddPartnerDataTable() {
		return enableddPartnerDataTable;
	}

	public void setEnableddPartnerDataTable(boolean enableddPartnerDataTable) {
		this.enableddPartnerDataTable = enableddPartnerDataTable;
	}

	public boolean isEnabledddCompanyDataTable() {
		return enabledddCompanyDataTable;
	}

	public void setEnabledddCompanyDataTable(boolean enabledddCompanyDataTable) {
		this.enabledddCompanyDataTable = enabledddCompanyDataTable;
	}

	public boolean isEnableSecondaryObjDataTable() {
		return enableSecondaryObjDataTable;
	}

	public void setEnableSecondaryObjDataTable(boolean enableSecondaryObjDataTable) {
		this.enableSecondaryObjDataTable = enableSecondaryObjDataTable;
	}

	public boolean isEnableBussineesDataTable() {
		return enableBussineesDataTable;
	}

	public void setEnableBussineesDataTable(boolean enableBussineesDataTable) {
		this.enableBussineesDataTable = enableBussineesDataTable;
	}
	public String getpIdNoStatus() {
		return pIdNoStatus;
	}

	public void setpIdNoStatus(String pIdNoStatus) {
		this.pIdNoStatus = pIdNoStatus;
	}

	public String getSigIdNoStatus() {
		return sigIdNoStatus;
	}

	public void setSigIdNoStatus(String sigIdNoStatus) {
		this.sigIdNoStatus = sigIdNoStatus;
	}

	private Boolean booUpdate;

	
	public BigDecimal getState() {
		return stateId;
	}

	public void setState(BigDecimal state) {
		this.stateId = state;
	}

	public BigDecimal getDist() {
		return distId;
	}

	public void setDist(BigDecimal dist) {
		this.distId = dist;
	}

	public BigDecimal getStateId() {
		return stateId;
	}

	public void setStateId(BigDecimal stateId) {
		this.stateId = stateId;
	}

	public BigDecimal getDistId() {
		return distId;
	}

	public void setDistId(BigDecimal distId) {
		this.distId = distId;
	}
	public List<Amlstatus> getCoAMLList() {
		return coAMLList;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getCustomerId() {
		return customerId;
	}

	public BigDecimal getCityId() {
		return cityId;
	}

	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
	}

	public void setCustomerId(BigDecimal bigDecimal) {
		this.customerId = bigDecimal;
	}

	public List<Customer> getCutList() {
		return cutList;
	}

	private List<Customer> cutList;

	public boolean isCoAMLCommon() {
		return coAMLCommon;
	}

	public void setCoAMLCommon(boolean coAMLCommon) {
		this.coAMLCommon = coAMLCommon;
	}

	private final ArrayList<AddContactDetailBean> contactList = new ArrayList<AddContactDetailBean>();
    
	public ArrayList<AddContactDetailBean> getContactList() {
		return contactList;
	}

	private final ArrayList<AddCoIdentityDetailBean> identityList = new ArrayList<AddCoIdentityDetailBean>();

	public ArrayList<AddCoIdentityDetailBean> getIdentityList() {
		return identityList;
	}

	private final ArrayList<AddPartnerDetailBean> partnerList = new ArrayList<AddPartnerDetailBean>();

	public ArrayList<AddPartnerDetailBean> getPartnerList() {
		return partnerList;
	}

	private final ArrayList<AddNatureofBussnessBean> bussnessList = new ArrayList<AddNatureofBussnessBean>();

	public ArrayList<AddNatureofBussnessBean> getBussnessList() {
		return bussnessList;
	}

	private final ArrayList<AddAuthSignatoriesBean> authorisedList = new ArrayList<AddAuthSignatoriesBean>();

	public ArrayList<AddAuthSignatoriesBean> getAuthorisedList() {
		return authorisedList;
	}

	private final ArrayList<AddSecondaryObjectiveBean> secondaryList = new ArrayList<AddSecondaryObjectiveBean>();

	public ArrayList<AddSecondaryObjectiveBean> getSecondaryList() {
		return secondaryList;
	}
	public   Map<BigDecimal, String>  getCountryMap() {
		return countryMap;
	}

	public void setCountryMap(Map<BigDecimal, String> countryMap) {
		this.countryMap = countryMap;
	}

	public List<Customer> getCutList(String id) {
		cutList = new ArrayList<Customer>();
	//	cutList.addAll(getCorpRegService().getAllData(id));
		return cutList;
	}

	public void setCutList(List<Customer> cutList) {
		this.cutList = cutList;
	}

	public void setCountryList(List<CountryBean> countryList) {
		this.countryList = countryList;
	}
	public String getCrno() {
		return crno;
	}

	public void setCrno(String crno) {
		this.crno = crno;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		System.out.println("vALUE SETTED : "+compName);
		this.compName = compName;
	}

	public String getCompNameL() {
		return compNameL;
	}

	public void setCompNameL(String compNameL) {
		this.compNameL = compNameL;
	}

	public Date getCompRegDate() {
		return compRegDate;
	}

	public void setCompRegDate(Date compRegDate) {
		this.compRegDate = compRegDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public BigDecimal getContType() {
		return contType;
	}

	public void setContType(BigDecimal contType) {
		this.contType = contType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}

	public void setCountryId(BigDecimal country) {
		this.countryId = country;
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
	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public BigDecimal getIdtype() {
		return idtype;
	}

	public void setIdtype(BigDecimal idtype) {
		this.idtype = idtype;
	}

	public Date getIdExpDate() {
		return idExpDate;
	}

	public void setIdExpDate(Date idExpDate) {
		this.idExpDate = idExpDate;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getSeconObj() {
		return seconObj;
	}

	public void setSeconObj(BigDecimal seconObj) {
		this.seconObj = seconObj;
	}

	public BigDecimal getBussNature() {
		return bussNature;
	}

	public void setBussNature(BigDecimal string) {
		this.bussNature = string;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public List<Customer> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Customer> empList) {
		this.empList = empList;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getPidno() {
		return pidno;
	}

	public void setPidno(String pidno) {
		this.pidno = pidno;
	}

	public BigDecimal getPidtype() {
		return pidtype;
	}

	public void setPidtype(BigDecimal pidtype) {
		this.pidtype = pidtype;
	}

	public Date getPidExpDate() {
		return pidExpDate;
	}

	public void setPidExpDate(Date pidExpDate) {
		this.pidExpDate = pidExpDate;
	}

	public Part getPpart() {
		return ppart;
	}

	public void setPpart(Part ppart) {
		this.ppart = ppart;
	}

	public String getSidno() {
		return sidno;
	}

	public void setSidno(String sidno) {
		this.sidno = sidno;
	}

	public BigDecimal getSidtype() {
		return sidtype;
	}

	public void setSidtype(BigDecimal sidtype) {
		this.sidtype = sidtype;
	}

	public Date getSidExpDate() {
		return sidExpDate;
	}

	public void setSidExpDate(Date sidExpDate) {
		this.sidExpDate = sidExpDate;
	}

	public Part getSpart() {
		return spart;
	}

	public void setSpart(Part spart) {
		this.spart = spart;
	}

	public UIComponent getTableForm() {
		return tableForm;
	}

	public void setTableForm(UIComponent tableForm) {
		this.tableForm = tableForm;
	}

	public Boolean getBooUpdate() {
		return booUpdate;
	}

	public void setBooUpdate(Boolean booUpdate) {
		this.booUpdate = booUpdate;
	}

	public String getAMLStatus() {
		return AMLStatus;
	}

	public void setAMLStatus(String aMLStatus) {
		AMLStatus = aMLStatus;
	}

	public boolean isCoAMLPass() {
		return coAMLPass;
	}

	public void setCoAMLPass(boolean coAMLPass) {
		this.coAMLPass = coAMLPass;
	}

	public boolean isCoAMLFail() {
		return coAMLFail;
	}

	public void setCoAMLFail(boolean coAMLFail) {
		this.coAMLFail = coAMLFail;
	}

	public boolean isCoValdtBtn() {
		return coValdtBtn;
	}

	public void setCoValdtBtn(boolean coValdtBtn) {
		this.coValdtBtn = coValdtBtn;
	}

	public boolean isCoSave() {
		return coSave;
	}

	public void setCoSave(boolean coSave) {
		this.coSave = coSave;
	}

	public List<Amlstatus> getCoAMLList(String compName) {
		coAMLList = new ArrayList<Amlstatus>();
		coAMLList.addAll(getCorpRegService().getAMLStatusList(compName));
		return coAMLList;
	}
	public   List<IdentityType> getPIdentityTypeList() {
		return identTypList;
	}
	public   List<IdentityType> getAuthorIdentityTypeList() {
		return identTypList;
	}

	public Map<BigDecimal, String> getCityHashaMap() {
		return cityHashaMap;
	}

	public void setCityHashaMap(Map<BigDecimal, String> cityHashaMap) {
		this.cityHashaMap = cityHashaMap;
	}

	public Map<BigDecimal, String> getStateHashaMap() {
		return stateHashaMap;
	}

	public void setStateHashaMap(Map<BigDecimal, String> stateHashaMap) {
		this.stateHashaMap = stateHashaMap;
	}
	
	public String getExpDateAdder() {
		return expDateAdder;
	}

	public void setExpDateAdder(String expDateAdder) {
		this.expDateAdder = expDateAdder;
	}
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public List<IdentityType> getIdentTypList() {
		return identTypList;
	}

	public void setIdentTypList(List<IdentityType> identTypList) {
		this.identTypList = identTypList;
	}

	public void setCoAMLList(List<Amlstatus> coAMLList) {
		this.coAMLList = coAMLList;
	}
	List<CountryBean> countrybean = new ArrayList<CountryBean>();
	public List<CountryBean> getCountryList1() {
		return countrybean;
	}
	public BigDecimal getPrimaryObjId() {
		return primaryObjId;
	}

	public void setPrimaryObjId(BigDecimal primaryObjId) {
		this.primaryObjId = primaryObjId;
	}
	public Map<BigDecimal, String> getMapCorporateBussineesList() {
		return mapCorporateBussineesList;
	}

	public void setMapCorporateBussineesList(
			Map<BigDecimal, String> mapCorporateBussineesList) {
		this.mapCorporateBussineesList = mapCorporateBussineesList;
	}

	public Map<BigDecimal, String> getMapSecoundryList() {
		return mapSecoundryList;
	}

	public void setMapSecoundryList(Map<BigDecimal, String> mapSecoundryList) {
		this.mapSecoundryList = mapSecoundryList;
	}

	Map<BigDecimal,String> mapSecoundryList = new HashMap<BigDecimal, String>();

	public Map<BigDecimal, String> getMapIdentityList() {
		return mapIdentityList;
	}

	public void setMapIdentityList(Map<BigDecimal, String> mapIdentityList) {
		this.mapIdentityList = mapIdentityList;
	}
	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	public BigDecimal getImage_id() {
		return image_id;
	}
	public void setImage_id(BigDecimal image_id) {
		this.image_id = image_id;
	}

	public void checkCompanyAMLStatus() {
		System.out.println("Company Name : "+getCompName());
		System.out.println("CR NO. : "+getCrno());
		
		try{
			List<Amlstatus> coList = getCoAMLList(getCompName());
			System.out.println("the size of list is" + coList.size());
			if (coList.get(0).getRemStatus().equalsIgnoreCase("pass")) {
				setAMLStatus("pass");
				setHitCount("1");
				setRenderObjective(true);
				setRenderContactDetails(false);
				setRenderCoIdentityDoc(false);
				setRenderPartnerDetail(false);
				setRenderOwnerDetails(false);
				//setCoAMLPass(true);
				setIdno(getCrno());
			    setIdtype(new BigDecimal(9));
				setReadOnly(true);
				setDisableDate(true);
				setCoAMLFail(false);
				setCoValdtBtn(false);
				setDisableAML(false);
			} else {
	
				setAMLStatus("fail");
				setCoAMLFail(true);
				setCoAMLCommon(false);
				setCoAMLPass(false);
				
			}
		}catch(ArrayIndexOutOfBoundsException aiobexp) {
			aiobexp.printStackTrace();
		}
	}
    /*
     * code to check get language id from the session
     * 
     */
	

	/*
	 * method to save Company
	 */
	public void saveData() throws SerialException, IOException, SQLException {
		saveOwnerImage();
		System.out.println("Save");
		
		
		cust = new Customer();
		ruleObjective = new RuleObjective();
		countryMaster = new CountryMaster();
		try {
			if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")) {
				setLanguageId(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().
																				equalsIgnoreCase("ar") ? new BigDecimal(2) : new BigDecimal(1));
			}
			countryMaster.setCountryId(getLocation());
			ruleObjective.setObjectiveId(getPrimaryObjId());
			langType = new LanguageType();
			langType.setLanguageId((getLanguageId()));
			cust.setFsCountryMasterByCountryId(countryMaster);
			cust.setFsLanguageType(langType);
			cust.setFsRuleObjective(ruleObjective);
			cust.setCompanyName(getCompName());
			cust.setCompanyNameLocal(getCompNameL());
			cust.setEmail(getEmail());
			cust.setCrNo(getCrno());
			cust.setDateOfBirth(getCompRegDate());
			cust.setContactNumber(getContactNumber());
			cust.setContactPerson(getContactPerson());
			cust.setActivatedDate(new Date());
			cust.setActivatedInd("1");
			countryMstr = new CountryMaster();
			countryMstr.setCountryId(getLocation());
			cust.setFsCountryMasterByCountryId(countryMstr);
			cust.setFsCountryMasterByNationality(countryMstr);
			custmrType = new CustomerType();
			custmrType.setCustomerTypeId(bdCompanyIdType);
			cust.setFsCustomerType(custmrType);
			cust.setAmlStatus(getAMLStatus());
		//	cust.setNumberOfHits(1);
			cust.setCustomerId(getCustomerId());
			
			if(getCustomerId() != null) {
				cust.setAmlStatusUpdatedBy(userName);
				cust.setUpdatedBy(userName);
                cust.setLastUpdated(new Date());
                cust.setAmlStatusUpdatedBy(userName);//doubt
                cust.setCreatedBy(getCreatedByCustomer());
                cust.setCreationDate(getCreatedDateCustomer());
			}else {
				cust.setCreatedBy(userName);
				cust.setCreationDate(new Date());
			}
			getCorpRegService().updateCorpCustomer(cust);
			setCustomerId(cust.getCustomerId());
			saveSecondaryObjective();
			saveBussnessNature();
			saveContact();
			saveCompanyIdentityDocument();
			if(isAddPartner()) {
			   savePartnerDetail();
			}
			saveAuthourizeSignatoriesDetail();
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception ioexp) {
			ioexp.printStackTrace();
		}
		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.invalidateSession();
			context.redirect("../common/successcuscorporate.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void saveContact() {
		try {
				contdetail = new ContactDetail();
				cust.setCustomerId(getCustomerId());
				contdetail.setFsCustomer(cust);
				langType = new LanguageType();
				countryMaster = new CountryMaster();
				stateMaster = new StateMaster();
				districtMaster = new DistrictMaster();
				cityMaster = new CityMaster();
				contactType = new ContactType();
				contactType.setContactTypeId(getContType());
				countryMaster.setCountryId(getCountryId());
				stateMaster.setStateId(getStateId());
				districtMaster.setDistrictId(getDistId());
				cityMaster.setCityId(getCityId());
				contdetail.setFsContactType(contactType);
				contdetail.setFsCountryMaster(countryMaster);
				contdetail.setFsDistrictMaster(districtMaster);
				contdetail.setFsStateMaster(stateMaster);
				contdetail.setFsCityMaster(cityMaster);
				langType.setLanguageId(getLanguageId());
				contdetail.setFsLanguageType(langType);
				contdetail.setArea(getArea());
				contdetail.setBlock(getBlock());
				contdetail.setStreet(getStreet());
				contdetail.setFlat(getFlat());
				contdetail.setApproved(userName);// doubt
				contdetail.setTelephone(getTel());
				contdetail.setContactDetailId(getContactDetailId());
				contdetail.setCreatedBy(userName);
				contdetail.setCreationDate(new Date());
				contdetail.setUpdatedBy(userName);
				contdetail.setLastUpdated(new Date());
			   if(getContactDetailId() != null) {
				   contdetail.setUpdatedBy(userName);
				   contdetail.setLastUpdated(new Date());
				   contdetail.setCreatedBy(getCreatedByContact());
				   contdetail.setCreationDate(getCreatedDateContact());
				   contdetail.setActiveStatus("1");
			   }else{
				   contdetail.setCreatedBy(userName);
				   contdetail.setCreationDate(new Date());
				   contdetail.setActiveStatus("1");
			   }
					getCorpRegService().saveCorporateContDtl(contdetail);
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception ioexp) {
			ioexp.printStackTrace();
		}
	}
	public void saveSecondaryObjective() {
		try {
				cust = new Customer();
				cust.setCustomerId(getCustomerId());
				custCorpAddDetail = new CustCorporateAddlDetail();
				ruleObjective = new RuleObjective();
				ruleObjective.setObjectiveId(getSeconObj());
				langType = new LanguageType();
				langType.setLanguageId(getLanguageId());
				custCorpAddDetail.setFsLanguageType(langType);
				custCorpAddDetail.setFsCustomer(cust);
				custCorpAddDetail.setFsRuleObjective(ruleObjective);
				custCorpAddDetail.setAddlStatus("1");
				custCorpAddDetail.setCorpAddlId(getCustCorporateAdditionalId());
				if(getCustCorporateAdditionalId() != null) {
					custCorpAddDetail.setUpdatedBy(userName);
					custCorpAddDetail.setLastUpdated(new Date());
					custCorpAddDetail.setCreatedBy(getCreatedBySecondary());
					custCorpAddDetail.setCreationDate(getCreatedDateSecondary());
				}else {
					custCorpAddDetail.setCreatedBy(userName);
					custCorpAddDetail.setCreationDate(new Date());
				}
			getCorpRegService().saveOrUpdateSecondaryObjective(custCorpAddDetail);
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception ioexp) {
			ioexp.printStackTrace();
		}
	}

	public void saveBussnessNature() {
		corpBussnsNature = new CorporateBusinessNature();
		ruleBussNature = new RuleBusinessNature();
		try {
				ruleBussNature.setNatureOfBusinessId(getBussNature());
				//corpBussnsNature.setObjectiveType(addnature.getObj());
				corpBussnsNature.setFsRuleBusinessNature(ruleBussNature);
				cust = new Customer();
				cust.setCustomerId(getCustomerId());
				corpBussnsNature.setFsCustomer(cust);
				corpBussnsNature.setCreatedBy(userName);
				corpBussnsNature.setCreationDate(new Date());
				corpBussnsNature.setBusinessStatus("1");
				corpBussnsNature.setCorporateBusinessId(getCorporateBusenessNatureId());
				if(getCorporateBusenessNatureId() != null) {
					corpBussnsNature.setUpdatedBy(userName);
					corpBussnsNature.setLastUpdated(new Date());
					corpBussnsNature.setCreatedBy(getCreatedByBusseness());
					corpBussnsNature.setCreationDate(getCreatedDateBusseness());
				}else {
					corpBussnsNature.setCreatedBy(userName);
					corpBussnsNature.setCreationDate(new Date());
				}
				getCorpRegService().saveBussnessNature(corpBussnsNature);
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception ioexp) {
			ioexp.printStackTrace();
		}
	}
	public void saveCompanyIdentityDocument() {
		
		try { 
	   		   System.out.println("the company image id is"+getCompanyImageId());
	   		    custmrIdProof = new CustomerIdProof();
			    DocumentImg imgDoc = new DocumentImg();
			    imgDoc.setImgId(getCompanyImageId());
			    custmrIdProof.setFsDocumentImg(imgDoc);
				cust = new Customer();
				cust.setCustomerId(getCustomerId());
				custmrIdProof.setFsCustomer(cust);
				langType = new LanguageType();
				langType.setLanguageId(getLanguageId());
				custmrIdProof.setFsLanguageType(langType);
				identityType = new IdentityType();
				identityType.setIdentityTypeId(getIdtype());
				custmrIdProof.setFsIdentityType(identityType);
				custmrType = new CustomerType();
				custmrType.setCustomerTypeId(bdCompanyIdType);
				custmrIdProof.setFsCustomerType(custmrType);
				custmrIdProof.setIdentityInt(getIdno());
				custmrIdProof.setIdentityExpiryDate(getIdExpDate());
				custmrIdProof.setIdentityStatus("1");
				custmrIdProof.setCustProofId(getCustomerIdProofIdForCompanyIdentityDoc());
				if(getCustomerIdProofIdForCompanyIdentityDoc() != null) {
					custmrIdProof.setUpdatedBy(userName);
					custmrIdProof.setLastUpdatedDate(new Date());
					custmrIdProof.setCreatedBy(getCreatedByComapany());
					custmrIdProof.setCreationDate(getCreatedDateCompany());
					
			    }else {
					custmrIdProof.setCreatedBy(userName);
					custmrIdProof.setCreationDate(new Date());
					custmrIdProof.setApprovedBy(userName);
					custmrIdProof.setApprovedDate(new Date());
		    	}
				getCorpRegService().commonSaveOrUpdateIdProof(custmrIdProof);
	 	  } catch (NullPointerException npexp) {
		      npexp.printStackTrace();
	      }  catch (Exception ioexp) {
		      ioexp.printStackTrace();
	      }
	 }			
	 public void savePartnerDetail() {
		try {
			System.out.println("the partner image id is"+getPartnerImageId());
			    custmrIdProof = new CustomerIdProof();
			    DocumentImg imgDoc = new DocumentImg();
			    imgDoc.setImgId(getPartnerImageId());
				cust = new Customer();
				cust.setCustomerId(getCustomerId());
				custmrIdProof.setFsCustomer(cust);
				custmrIdProof.setFsDocumentImg(imgDoc);
				langType = new LanguageType();
				langType.setLanguageId(getLanguageId());
				custmrIdProof.setFsLanguageType(langType);
				custmrType = new CustomerType();
				identityType = new IdentityType();// doubt
				identityType.setIdentityTypeId(getPidtype());
				custmrIdProof.setFsIdentityType(identityType);
				custmrType.setCustomerTypeId(bdPartnerIdType);
				custmrIdProof.setFsCustomerType(custmrType);
				custmrIdProof.setName(getPartName());
				custmrIdProof.setIdentityInt(getPidno());
				custmrIdProof.setCustProofId(getCustomerIdProofIdForPartner());
				custmrIdProof.setIdentityExpiryDate(getPidExpDate());
				custmrIdProof.setIdentityStatus("1");
				if(getCustomerIdProofIdForPartner() != null) {
					custmrIdProof.setUpdatedBy(userName);
					custmrIdProof.setLastUpdatedDate(new Date());
					custmrIdProof.setCreatedBy(getCreatedByPartner());
					custmrIdProof.setCreationDate(getCreatedDatePartner());
				}else{
					custmrIdProof.setApprovedBy(userName);
					custmrIdProof.setApprovedDate(new Date());
					custmrIdProof.setCreatedBy(userName);
					custmrIdProof.setCreationDate(new Date());
				}
				getCorpRegService().commonSaveOrUpdateIdProof(custmrIdProof);
		 } catch (NullPointerException npexp) {
				npexp.printStackTrace();
		 }catch (Exception ioexp) {
				ioexp.printStackTrace();
		 }
	}
		public void saveAuthourizeSignatoriesDetail() {
			try {
				System.out.println("the owner image id is"+getOwnerImageId());
				    custmrIdProof = new CustomerIdProof();
					DocumentImg imgDoc = new DocumentImg();
					imgDoc.setImgId(getOwnerImageId());
					cust = new Customer();
					cust.setCustomerId(getCustomerId());
					custmrIdProof.setFsCustomer(cust);
					langType = new LanguageType();
					langType.setLanguageId(getLanguageId());
					custmrIdProof.setFsLanguageType(langType);
					custmrType = new CustomerType();
					identityType = new IdentityType();
					identityType.setIdentityTypeId(getSidtype());
					custmrIdProof.setFsIdentityType(identityType);
					custmrType.setCustomerTypeId(bdAuthorizedIdType);
					custmrIdProof.setFsCustomerType(custmrType);
					custmrIdProof.setName(getName());
					custmrIdProof.setFsDocumentImg(imgDoc);
					custmrIdProof.setIdentityInt(getSidno());
					custmrIdProof.setCustProofId(getCustomerIdProofIdForOwner());			
					custmrIdProof.setIdentityExpiryDate(getSidExpDate());
					custmrIdProof.setIdentityEffDate(getEffDate());
					custmrIdProof.setIdentityEndDate(getEndDate());
					custmrIdProof.setIdentityStatus("1");
					if(getCustomerIdProofIdForOwner() != null) {
						custmrIdProof.setUpdatedBy(userName);
						custmrIdProof.setLastUpdatedDate(new Date());
						custmrIdProof.setCreatedBy(getCreatedByOwner());
						custmrIdProof.setCreationDate(getCreatedDateOwner());
					}else{
						custmrIdProof.setApprovedBy(userName);
						custmrIdProof.setApprovedDate(new Date());
						custmrIdProof.setCreatedBy(userName);
						custmrIdProof.setCreationDate(new Date());
					}
					getCorpRegService().commonSaveOrUpdateIdProof(custmrIdProof);
					
				} catch (NullPointerException npexp) {
				npexp.printStackTrace();
				}  catch (Exception ioexp) {
				ioexp.printStackTrace();
				}
		}	
		/*
		 * method to validate contact details,primary secondary,bussiness nature
		 * 
		 */
	   public void validateDataTables() {
		   if(contactList.size() == 0) {
			   
		   }
	   }
     /*
      * method to fill company identity document in dataTable at the time of fetching
      */
	
	
	private void setCompanyIdProofDetail(){
		System.out.println("In company ID proof");
		try{
		identityList.clear();
		List<CustomerIdProof> customerIdProof = getCorpRegService().getCustomerIdProof(getLanguageId(), getCustomerId(), bdCompanyIdType);
		if(customerIdProof.size()>0) {
			System.out.println("the image is"+customerIdProof.get(0).getFsDocumentImg().getImage()+"the image name is"+customerIdProof.get(0).getFsDocumentImg().getImageName());
			showImageForCompany(customerIdProof.get(0).getFsDocumentImg().getImage(), customerIdProof.get(0).getFsDocumentImg().getImageName());
			setCustomerIdProofIdForCompanyIdentityDoc(customerIdProof.get(0).getCustProofId());
			setIdno(customerIdProof.get(0).getIdentityInt());
			setIdtype(customerIdProof.get(0).getFsIdentityType().getIdentityTypeId());
			setIdExpDate(customerIdProof.get(0).getIdentityExpiryDate());
			setCreatedByComapany(customerIdProof.get(0).getCreatedBy());
			setCreatedDateCompany(customerIdProof.get(0).getCreationDate());
			System.out.println("Image Id:::::::::::::::::::::::::::: "+customerIdProof.get(0).getFsDocumentImg().getImgId());
			setCompanyImageId(customerIdProof.get(0).getFsDocumentImg().getImgId());
		}
		}catch(NullPointerException npexp){
			npexp.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
     * method to fill company partner details  in dataTable at the time of fetching
     */
	private void setPartnerIdProofDetail(){
		try{
			
		List<CustomerIdProof> customerIdProof = getCorpRegService().getCustomerIdProof(getLanguageId(), getCustomerId(), bdPartnerIdType);
		if(customerIdProof.size()>0) {
			
			showImageForPartner(customerIdProof.get(0).getFsDocumentImg().getImage(), customerIdProof.get(0).getFsDocumentImg().getImageName());
			System.out.println("the image for partner is"+customerIdProof.get(0).getFsDocumentImg().getImage()+"the image name  for partner is"+customerIdProof.get(0).getFsDocumentImg().getImageName());
			setCustomerIdProofIdForPartner(customerIdProof.get(0).getCustProofId());
			setPidno(customerIdProof.get(0).getIdentityInt());
			setPidExpDate(customerIdProof.get(0).getIdentityExpiryDate());
			setPartName(customerIdProof.get(0).getName());
			setPidtype(customerIdProof.get(0).getFsIdentityType().getIdentityTypeId());
			setPartnerImageId(customerIdProof.get(0).getFsDocumentImg().getImgId());
		    setCreatedByPartner(customerIdProof.get(0).getCreatedBy());
		    setCreatedDatePartner(customerIdProof.get(0).getCreationDate());
		    setAddPartner(true);
		}
		}catch(NullPointerException npexp){
			npexp.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
     * method to fill Authorized Signature  document(owner details) in dataTable at the time of fetching
     */
	private void setAuthroizedIdProofDetail(){
	 try {
		authorisedList.clear();
		List<CustomerIdProof> customerIdProof = getCorpRegService().getCustomerIdProof(getLanguageId(), getCustomerId(), bdAuthorizedIdType);
		if(customerIdProof.size()>0) {
			showImageForOwner(customerIdProof.get(0).getFsDocumentImg().getImage(), customerIdProof.get(0).getFsDocumentImg().getImageName());
			System.out.println("the image for owner is"+customerIdProof.get(0).getFsDocumentImg().getImage()+"the image name  for owner is"+customerIdProof.get(0).getFsDocumentImg().getImageName());
			setCustomerIdProofIdForOwner(customerIdProof.get(0).getCustProofId());
			setName(customerIdProof.get(0).getName());
			setSidno(customerIdProof.get(0).getIdentityInt());
			setSidtype(customerIdProof.get(0).getFsIdentityType().getIdentityTypeId());
			setSidExpDate(customerIdProof.get(0).getIdentityExpiryDate());
			setEndDate(customerIdProof.get(0).getIdentityEndDate());
			setEffDate(customerIdProof.get(0).getIdentityEffDate());
			setOwnerImageId(customerIdProof.get(0).getFsDocumentImg().getImgId());
			setCreatedByOwner(customerIdProof.get(0).getCreatedBy());
			setCreatedDateOwner(customerIdProof.get(0).getCreationDate());
		}
		
	 }catch(NullPointerException nexp){
		 nexp.printStackTrace();
	 }catch(Exception exp) {
		 exp.printStackTrace();
	 }
	 
	}
	public void populateState() {
		sessionStateManage = new SessionStateManage();
		for(StateMasterDesc  statMastrDesc: getGeneralService().getStateList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId()) ){
			   StateBean  stsatBean = new StateBean(statMastrDesc.getFsStateMaster().getStateId(), statMastrDesc.getStateName());
		       stateBeanList.add(stsatBean);
		}
	}
	public void populateDistrict() {
		sessionStateManage = new SessionStateManage();
		for(DistrictMasterDesc districtMasterDesc: getGeneralService().getDistrictList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId(),getStateId()) ){
		       distBeanList.add(new DistrictBean(districtMasterDesc.getFsDistrictMaster().getDistrictId() , districtMasterDesc.getDistrict()));
		}
	}
	public void populateCity() {
		sessionStateManage = new SessionStateManage();
     for(     CityMasterDesc cityMasterDesc : getGeneralService().getCityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId(),getStateId(),getDistId()) ){
			cityBeanList.add(new CityBean(cityMasterDesc.getFsCityMaster().getCityId(), cityMasterDesc.getCityName()));
		}
	}
	public void populateIdentityForCompany() {
		lstCompanyIdentityType = new ArrayList<IdentityType>();
		lstCompanyIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(),getCountryId(), bdCompanyIdType));
	}
	public void populateIdentityForPartner() {
		lstPartnerIdentityType = new ArrayList<IdentityType>();
		lstPartnerIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), getCountryId(), bdPartnerIdType));
	}
	public void populateIdentityForOwner() {
		lstAuthorizedIdentityType = new ArrayList<IdentityType>();
		lstAuthorizedIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), getCountryId(), bdAuthorizedIdType));
	}
	/*
     * method to fill contact details in dataTable at the time of fetching
     */
	private void setCustomerContactDetails(){
		try{
		contactList.clear();
		List<ContactDetail> cdetail = getCorpRegService().getContactDetail(getCustomerId());
		if(cdetail.size()>0) {
			getContactTypeListDB();
			setContType(cdetail.get(0).getFsContactType().getContactTypeId());
			setContactDetailId(cdetail.get(0).getContactDetailId());
			getCountryListFromDB();
			setCountryId(cdetail.get(0).getFsCountryMaster().getCountryId());
			populateState();
			setStateId(cdetail.get(0).getFsStateMaster().getStateId());
			populateDistrict();
			setDistId(cdetail.get(0).getFsDistrictMaster().getDistrictId());
			populateCity();
			setCityId(cdetail.get(0).getFsCityMaster().getCityId());
			setArea(cdetail.get(0).getArea());
			setStreet(cdetail.get(0).getStreet());
			setBlock(cdetail.get(0).getBlock());
			setFlat(cdetail.get(0).getFlat());
			setTel(cdetail.get(0).getTelephone());
			setCreatedByContact(cdetail.get(0).getCreatedBy());
			setCreatedDateContact(cdetail.get(0).getCreationDate());
		}
		}catch(NullPointerException npexp){
			npexp.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
     * method to set secoundryObjective  
     */
	private void setSecondaryObjectiveDetails(){
		try {
			
		List<CustCorporateAddlDetail> custCorporateAddlDetail =  getCorpRegService().getCustomerCorporateAdditionalDetail(getLanguageId(),getCustomerId());
	    setSeconObj(custCorporateAddlDetail.get(0).getFsRuleObjective().getObjectiveId());
	    setCustCorporateAdditionalId(custCorporateAddlDetail.get(0).getCorpAddlId());
	    setCreatedBySecondary(custCorporateAddlDetail.get(0).getCreatedBy());
	    setCreatedDateSecondary(custCorporateAddlDetail.get(0).getCreationDate());
		} catch (NullPointerException npexp) {
			npexp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
     * method to fill Corporate Business nature in dataTable at the time of fetching
     */
	private void setNatureOfBusinessDetails(){
		try{
			 List<CorporateBusinessNature> corporateBusinessNature = getCorpRegService().getCorporateBusinessNatureDetails(getCustomerId());	
			setBussNature(corporateBusinessNature.get(0).getFsRuleBusinessNature().getNatureOfBusinessId());
			setCorporateBusenessNatureId(corporateBusinessNature.get(0).getCorporateBusinessId());
			setCreatedByBusseness(corporateBusinessNature.get(0).getCreatedBy());
			setCreatedDateBusseness(corporateBusinessNature.get(0).getCreationDate());
		}catch(NullPointerException npexp){
			npexp.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
     /*
      * method to fetch the company registration details with cr no.
      * 
      */
	public void fetchData() {
		 
		/*
		 * method to get the registration status  of the company
		 */
	try {	
		customerList = new ArrayList<Customer>();
		customerList.addAll(getCorpRegService().getCompanyRegistrationStatus(getCrno()));
	//	System.out.println("the size of fetch is"+customerList.size());
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH,+ 90);
		Date today90 = cal.getTime();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String finalDate = form.format(today90);
        setExpDateAdder(finalDate);
		SimpleDateFormat  smpDate = new SimpleDateFormat("dd/MM/yyyy");
		/*setCoAMLCommon(true);
		setCoAMLPass(true);*/

		if (customerList.size() > 0) {
			int cust_id = 0;
			setReadOnly(true);
			    setCustomerId(customerList.get(0).getCustomerId());
				setCrno(customerList.get(0).getCrNo());
				setCompName(customerList.get(0).getCompanyName());
				setCompNameL(customerList.get(0).getCompanyNameLocal());
				setEmail(customerList.get(0).getEmail());
				setContactNumber(customerList.get(0).getContactNumber());
				setContactPerson(customerList.get(0).getContactPerson());
				setCreatedByCustomer(customerList.get(0).getCreatedBy());
                setCreatedDateCustomer(customerList.get(0).getCreationDate());
				setAMLStatus(customerList.get(0).getAmlStatus());
				setCompRegDate(customerList.get(0).getDateOfBirth());
				getCountryListFromDB();
				setLocation(customerList.get(0).getFsCountryMasterByCountryId().getCountryId());
				getObjectivesFromDB();
				setPrimaryObjId(customerList.get(0).getFsRuleObjective().getObjectiveId());
				setHitCount("1");
				    setSecondaryObjectiveDetails();
				    getBussineesNatureFromDB();
				    setNatureOfBusinessDetails();
					setCustomerContactDetails();
					populateIdentityForCompany();
					setCompanyIdProofDetail();
					populateIdentityForPartner();
					setPartnerIdProofDetail();
					populateIdentityForOwner();
					setAuthroizedIdProofDetail();
					
					/*setCoAMLCommon(true);
					setCoAMLPass(true);
					setCoAMLFail(false);*/
					setCoValdtBtn(false);
					/*setCoSave(false);
					setBooUpdate(true);*/
					setRenderValidate(true);
					setRenderObjective(true);
					setRenderImage(true);
					setSaveOrFetch(false);
					/*setPartnerfile(null);
					setIdentityfile(null);
					setAutherfile(null);
					System.out.println("the company image is"+getIdentityfile());
					System.out.println("the partner image is"+getPartnerfile());
					System.out.println("the owner image is"+getAutherfile());*/
					setDisableDate(true);
					setReadOnly(true);
					setReadOnlyCompanyIdDoc(true);
					setDisableCompIdDco(true);
			}
		   
		
	
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}

	/*
	 * public String addContactTable(){ AddContact addContact = new
	 * AddContact(this.contType, this.area, this.country, this.street,
	 * this.block, this.flat, this.tel); contactList.add(addContact);
	 * tableForm.setRendered(true); return null; }
	 */

	

	
	
	public String cancel() {

		return "cancel";

	}    
/*public List<CountryMasterDesc> getCountryNameList() {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		return getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
	}*/
    
    public List<CountryBean> getCountryListFromDB() {
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		setLanguageId(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		countrybean.clear();
      
    	List<CountryMasterDesc> lstCountryMasterDesc = getiGeneralService().getCountryList((getLanguageId())); 
    
     
			for (CountryMasterDesc desc : lstCountryMasterDesc) {
				
				  CountryBean cntryBean = new CountryBean(desc.getCountryMasterId(), desc.getCountryName());	
				  countrybean.add(cntryBean );
				  countryMap.put(desc.getCountryMasterId(), desc.getCountryName());
				}
        return countrybean;
	}
    /*
	*
	*method to get state from db and add all the state code and name will be mapped to hashMap
	*/
	public void popState(AjaxBehaviorEvent e) {
		stateBeanList.clear();
		lstState = new ArrayList<StateMasterDesc>();
		lstState.addAll(getiGeneralService().getStateList(getLanguageId(),getCountryId()));
      
			for(StateMasterDesc  statMastrDesc: lstState ){
				
				   StateBean  stsatBean = new StateBean(statMastrDesc.getFsStateMaster().getStateId(), statMastrDesc.getStateName());
			       stateBeanList.add(stsatBean);
			       stateHashaMap.put(stsatBean.getStateId(),stsatBean.getStateName());
			}
		  
			getCompanyIdentityTypeList(e);
			getPartnerIdentityTypeList(e);
			getAuthorizedIdentityTypeList(e);
		
	}
	
	
	
	
	public List<StateBean> getStateFromDb() {
      return stateBeanList;
    }
	
	public void popDistrict(AjaxBehaviorEvent e) {
		distBeanList.clear();
		distmasterList = new ArrayList<DistrictMasterDesc>();
		distmasterList.addAll(getiGeneralService().getDistrictList(getLanguageId(), getCountryId(), getStateId()));
		
		for(DistrictMasterDesc districtMasterDesc: distmasterList ){
			
		       distBeanList.add(new DistrictBean(districtMasterDesc.getFsDistrictMaster().getDistrictId() , districtMasterDesc.getDistrict()));
		       hashMapdistrict.put(districtMasterDesc.getFsDistrictMaster().getDistrictId() , districtMasterDesc.getDistrict());
		}
	}
	
	public List<DistrictBean> getDistricFromDb() {
		return distBeanList;
	}
	
	public void popCity(AjaxBehaviorEvent e) {
		cityBeanList.clear();
		lstCity = new ArrayList<CityMasterDesc>();
		lstCity.addAll(getiGeneralService().getCityList(getLanguageId(), getCountryId(), getStateId(), getDistId()));
		
		for(CityMasterDesc cityMasterDesc : lstCity ){
			
			cityBeanList.add(new CityBean(cityMasterDesc.getFsCityMaster().getCityId(), cityMasterDesc.getCityName()));
			cityHashaMap.put(cityMasterDesc.getFsCityMaster().getCityId(), cityMasterDesc.getCityName());
		}
	}
	
	public List<CityBean> getCityFromDb() {
		return cityBeanList;
	}
	/*
	 * method to populate the identity type drop down list
	 */
	
	public void getCompanyIdentityTypeList(AjaxBehaviorEvent event) {
		
		lstCompanyIdentityType = new ArrayList<IdentityType>();
		SessionStateManage sessionManage = new SessionStateManage();
		System.out.println("the sissiom object id is is"+sessionManage.getSessionValue("countryId"));
		String count = sessionManage.getSessionValue("countryId").toString();
    	BigDecimal countryId = new BigDecimal(count); 
		lstCompanyIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdCompanyIdType));
		for(IdentityType identityType:lstCompanyIdentityType) {
			companyIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
	} 
	public void getPartnerIdentityTypeList(AjaxBehaviorEvent event) {
		SessionStateManage sessionManage = new SessionStateManage();
		String count = sessionManage.getSessionValue("countryId").toString();
    	BigDecimal countryId = new BigDecimal(count);
		lstPartnerIdentityType = new ArrayList<IdentityType>();
		lstPartnerIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdPartnerIdType));
		for(IdentityType identityType:lstPartnerIdentityType) {
			partnerIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
	} 
    public void getAuthorizedIdentityTypeList(AjaxBehaviorEvent event) {
    	SessionStateManage sessionManage = new SessionStateManage();
		String count = sessionManage.getSessionValue("countryId").toString();
    	BigDecimal countryId = new BigDecimal(count);
		lstAuthorizedIdentityType = new ArrayList<IdentityType>();
		lstAuthorizedIdentityType.addAll(getiGeneralService().getIdentityTypes(getLanguageId(), countryId, bdAuthorizedIdType));
		for(IdentityType identityType:lstAuthorizedIdentityType) {
			authorizedIdentityTypeHashaMap.put( identityType.getIdentityTypeId(),  identityType.getIdentityType());
		}
    } 
	public List<IdentityType> getIdentityTypeListFromExistingList() {
		return identTypList;
	}
	private List<CustomerType> customerTypeList ;
	
	private void getCustomerTypeList() {
		customerTypeList = new ArrayList<CustomerType>();
		//fcustomerTypeList.add
	}
	
	/*
	 * method to get Objectives from Data Base
	 */
	public List<RuleObjective> getObjectivesFromDB() {
		rulObjectList = new ArrayList<RuleObjective>();
		rulObjectList.addAll(getCorpRegService().getObjectiveList());
		/*for(RuleObjective rulObjective:rulObjectList){
			secondryObjMap.put(rulObjective.getObjectiveId(), rulObjective.getObjectiveDesc());
		}*/
		return rulObjectList ;
	}
	/*
	 * method to get objectives from existing List to no hits to DB
	 */
	public List<RuleObjective> getObjectivesFromExistingList() {
		return rulObjectList;
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
	public List<RuleBusinessNature>  getBussineesNatureFromDB() {
		bussinessNatureList = new ArrayList<RuleBusinessNature>();
		bussinessNatureList.addAll(getCorpRegService().getCorpBussinessNature());
		for(RuleBusinessNature ruleBussnature:bussinessNatureList){
			bussinessNatureHashaMap.put(ruleBussnature.getNatureOfBusinessId(), ruleBussnature.getNatureOfBusinessDesc());
		}
		return bussinessNatureList;
	}
	
    /*
     * method is responsible  go for next to contact details
     * 
     */
	public void nextToContact() {
		setRenderContactDetails(true);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderCoIdentityDoc(false);
		setRenderPartnerDetail(false);
		setRenderOwnerDetails(false);
	}
	 /*
     * method is responsible  go  to compasny identity doc
     * 
     */
	public void nextToCompanyIdentityDoc() {
		setRenderCoIdentityDoc(true);
		setRenderContactDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderPartnerDetail(false);
		setRenderOwnerDetails(false);
	}
	 /*
     * method is responsible  go  to partner details and add image of company identity doc
     * 
     */
	public void nextToPartnerDetails() throws SerialException, IOException, SQLException {
		/*System.out.println("the comapany image id is"+getCompanyImageId());
		System.out.println("the company image name is"+getIdentityfile());
		System.out.println("the image  name is"+getIdentityfile().getFileName());
		System.out.println("the image  size is"+getIdentityfile().getSize());
		System.out.println("the content type  value is"+getIdentityfile().getContentType());*/
		if(isSaveOrFetch()) {
			String fileName = getIdentityfile().getFileName();
			if(getIdentityfile().getFileName() == null) {
				setCoUploadFileVisibility(true);
				setRenderCoIdentityDoc(true);
				setRenderPartnerDetail(false);
				setRenderContactDetails(false);
				setRenderValidate(false);
				setRenderObjective(false);
				setRenderOwnerDetails(false);
			}else {
				if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
						fileName.contains(".png") || fileName.contains(".pdf")) {
					    saveDocument(fileName,getCustomerId(),getIdentityfile(),"company");
					    setCoUploadFileVisibility(false);
					    setRenderCoIdentityDoc(false);
					    if(isAddPartner()) {
						   setRenderPartnerDetail(true);
					    }else{
					    	setRenderOwnerDetails(true);
					    }
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
				}else{
					setCoUploadFileVisibility(true);
					setRenderCoIdentityDoc(true);
					setRenderPartnerDetail(false);
					setRenderContactDetails(false);
					setRenderValidate(false);
					setRenderObjective(false);
					setRenderOwnerDetails(false);
				}
			}
			
		}
		/*setRenderCoIdentityDoc(false);
		setRenderPartnerDetail(true);
		setRenderContactDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderOwnerDetails(false);*/
		else{
			//if(getCompanyImageId()!= null) {
				System.out.println("inside null upload");
				setCoUploadFileVisibility(false);
				setRenderCoIdentityDoc(false);
				if(isAddPartner()) {
					setRenderPartnerDetail(true);
				}else{
					setRenderOwnerDetails(true);
					System.out.println("inside null upload else of owner");
				}
				setRenderContactDetails(false);
				setRenderValidate(false);
				setRenderObjective(false);
				
			//}
		}	
		
	}	
			/**//*else{
				if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
						fileName.contains(".png") || fileName.contains(".pdf")) {
					    saveDocument(fileName,getCustomerId(),getIdentityfile(),"company");
					    setRenderPartnerDetail(true);
						setRenderCoIdentityDoc(false);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderOwnerDetails(false);
				}else{
					setCoUploadFileVisibility(true);
					setRenderCoIdentityDoc(true);
					setRenderPartnerDetail(false);
					setRenderContactDetails(false);
					setRenderValidate(false);
					setRenderObjective(false);
					setRenderOwnerDetails(false);
					
				}*/
				
			//}
			
		
	
		
	//	String imagename=getIdentityfile().getFileName();
		/*saveDocument(imagename,getCustomerId(),getIdentityfile(),"company");
		setRenderPartnerDetail(true);
		setRenderCoIdentityDoc(false);
		setRenderContactDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderOwnerDetails(false);*/
	
	 /*
     * method is responsible  go  to compasny identity doc
     * 
     */
	public void nextToAuthorDetails() throws SerialException, IOException, SQLException {
	   if(isAddPartner()) {	
		   System.out.println("the partner iamge id is"+getPartnerImageId());
		   System.out.println("the parner image is"+getPartnerfile());
			if(isSaveOrFetch()) {
				String fileName = getPartnerfile().getFileName();
				if(getPartnerfile().getFileName() == null) {
					setPartnerUploadFileVisibility(true);
					setRenderOwnerDetails(false);
					setRenderCoIdentityDoc(false);
					setRenderContactDetails(false);
					setRenderValidate(false);
					setRenderObjective(false);
					setRenderPartnerDetail(true);
				}else {
					if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
							fileName.contains(".png") || fileName.contains(".pdf")) {
						    saveDocument(fileName,getCustomerId(),getPartnerfile(),"partner");
						    setPartnerUploadFileVisibility(false);
							setRenderOwnerDetails(true);
							setRenderCoIdentityDoc(false);
							setRenderContactDetails(false);
							setRenderValidate(false);
							setRenderObjective(false);
							setRenderPartnerDetail(false);
					}else{
						setPartnerUploadFileVisibility(true);
						setRenderCoIdentityDoc(false);
						setRenderPartnerDetail(true);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderOwnerDetails(false);
					}
				}
				
			}else{
				 System.out.println("the value of  else partner  is"+getPartnerfile());
				 System.out.println("the value of partner file name  is"+getPartnerfile().getFileName());
				 System.out.println("the value of partner size  is"+getPartnerfile().getSize());
				 
				 if(getPartnerfile() != null  && getPartnerfile().getSize()==0) {
					 System.out.println("inside if condation ");
					 setPartnerUploadFileVisibility(false);
						setRenderPartnerDetail(false);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderOwnerDetails(true);
				 }else{
					   if(getPartnerfile().getFileName() == null) {
					    setPartnerUploadFileVisibility(true);
						setRenderPartnerDetail(false);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderOwnerDetails(true);
					}else{ 
						String fileName = getPartnerfile().getFileName(); 				
						if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
								fileName.contains(".png") || fileName.contains(".pdf")) {
							    saveDocument(fileName,getCustomerId(),getPartnerfile(),"partner");
							    setPartnerUploadFileVisibility(false);
							    setRenderPartnerDetail(false);
								setRenderCoIdentityDoc(false);
								setRenderContactDetails(false);
								setRenderValidate(false);
								setRenderObjective(false);
								setRenderOwnerDetails(true);
						}else{
							setPartnerUploadFileVisibility(true);
							setRenderCoIdentityDoc(false);
							setRenderPartnerDetail(true);
							setRenderContactDetails(false);
							setRenderValidate(false);
							setRenderObjective(false);
							setRenderOwnerDetails(false);
						}
						
					}
				}
			}			 
	   }else{
		    setRenderCoIdentityDoc(false);
			setRenderPartnerDetail(false);
			setRenderContactDetails(false);
			setRenderValidate(false);
			setRenderObjective(false);
			setRenderOwnerDetails(true);
	   }
							
		/*setRenderCoIdentityDoc(false);
		setRenderPartnerDetail(false);
		setRenderContactDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderOwnerDetails(true);*/
		
		/*String imagename=getPartnerfile().getFileName();
		saveDocument(imagename,getCustomerId(),getPartnerfile(),"partner");
		setRenderOwnerDetails(true);
		setRenderCoIdentityDoc(false);
		setRenderContactDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
		setRenderPartnerDetail(false);*/
	}
	public void saveOwnerImage() throws SerialException, IOException, SQLException {
		if(getOwnerImageId() == null) {
			String fileName = getAutherfile().getFileName();
			if(getAutherfile().getFileName() == null) {
				setAuthorUploadFileVisibility(true);
				setRenderOwnerDetails(true);
				setRenderCoIdentityDoc(false);
				setRenderContactDetails(false);
				setRenderValidate(false);
				setRenderObjective(false);
				setRenderPartnerDetail(false);
			}else {
				if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
						fileName.contains(".png") || fileName.contains(".pdf")) {
					    saveDocument(fileName,getCustomerId(),getAutherfile(),"owner");
					    setAuthorUploadFileVisibility(false);
						setRenderOwnerDetails(true);
						setRenderCoIdentityDoc(false);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderPartnerDetail(false);
				}else{
					setAuthorUploadFileVisibility(true);
					setRenderCoIdentityDoc(false);
					setRenderPartnerDetail(false);
					setRenderContactDetails(false);
					setRenderValidate(false);
					setRenderObjective(false);
					setRenderOwnerDetails(true);
				}
			}
			
		}else{
			if(getAutherfile().getFileName() == null) {
				setAuthorUploadFileVisibility(false);
				setRenderPartnerDetail(false);
				setRenderContactDetails(false);
				setRenderValidate(false);
				setRenderObjective(false);
				setRenderOwnerDetails(true);
			}else{ 
				String fileName = getAutherfile().getFileName(); 				
				if(fileName.contains(".doc") || fileName.contains(".docx") || fileName.contains(".jpg") || fileName.contains(".jpeg") || 
						fileName.contains(".png") || fileName.contains(".pdf")) {
				    	saveDocument(fileName,getCustomerId(),getAutherfile(),"owner");
				    	setAuthorUploadFileVisibility(false);
					    setRenderPartnerDetail(false);
						setRenderCoIdentityDoc(false);
						setRenderContactDetails(false);
						setRenderValidate(false);
						setRenderObjective(false);
						setRenderOwnerDetails(true);
				}else{
					setAuthorUploadFileVisibility(true);
					setRenderCoIdentityDoc(false);
					setRenderPartnerDetail(false);
					setRenderContactDetails(false);
					setRenderValidate(false);
					setRenderObjective(false);
					setRenderOwnerDetails(true);
					
				}
				
			}
			
		}
	}
	/*
     * method is responsible  go  back company identity doc
     * 
     */
	public void backFromContactDetails() {
		setRenderValidate(true);
		setRenderObjective(true);
		setRenderCoIdentityDoc(false);
		setRenderContactDetails(false);
		setRenderPartnerDetail(false);
		setRenderOwnerDetails(false);
	}
	/*
     * method is responsible  go  back company identity doc
     * 
     */
	public void backFromPartnerDetails() {
		setRenderCoIdentityDoc(true);
		setRenderContactDetails(false);
		setRenderPartnerDetail(false);
		setRenderOwnerDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
	}
	/*
     * method is responsible  go  back comapany identity doc
     * 
     */
	public void backFromCompanyIdentity() {
		setRenderContactDetails(true);
		setRenderPartnerDetail(false);
		setRenderOwnerDetails(false);
		setRenderCoIdentityDoc(false);
		setRenderValidate(false);
		setRenderObjective(false);
	}
	/*
     * method is responsible  go  back comapany or partner 
     * 
     */
	public void backToPartnerOrCompany() {
		setRenderContactDetails(false);
		/*
		 * if add partner is checked then it will back to partner details else it go to 
		 */
		if(isAddPartner()) {
			setRenderPartnerDetail(true);
		}else{
			setRenderCoIdentityDoc(true);
		}
		setRenderOwnerDetails(false);
		setRenderValidate(false);
		setRenderObjective(false);
	}
	
	 // Store file in the database
   public Blob storeImage(UploadedFile file) throws IOException, SerialException, SQLException {
            
   	InputStream stream = null;
   	
   	try {
   		stream =  file.getInputstream();
        }catch(Exception e){
           e.printStackTrace();
        }
   	 return new javax.sql.rowset.serial.SerialBlob(readFully(stream));
   }
   
   public  byte[] readFully(InputStream input) throws IOException
   {
       byte[] buffer = new byte[8192];
       int bytesRead;
       ByteArrayOutputStream output = new ByteArrayOutputStream();
       while ((bytesRead = input.read(buffer)) != -1)
       {
           output.write(buffer, 0, bytesRead);
       }
       return output.toByteArray();
   }
   
   public StreamedContent downloadFile(BigDecimal imageId) {
	   System.out.println("Image id : "+imageId);
	   StreamedContent image = null;
	   try{
		   System.out.println("Image ID within getDownloadFile :::::::::::::::::::::::::::::::::::::::::::::::::: "+getImage_id());
		   image = getImage(imageId); 
	   } catch(Exception e){
		   e.printStackTrace();
	   }
	   return image;
	}
   public StreamedContent getImage(BigDecimal imageId){
		try{
			if (imageId.toPlainString().length() > 0 && imageId!=null) {
				Blob blob = getCorpRegService().getImage(imageId).get(0).getImage();
				String imageNameWithExtention=getCorpRegService().getImage(imageId).get(0).getImageName();
				String imageExtention=imageNameWithExtention.substring(imageNameWithExtention.lastIndexOf("."));
				String imagename=imageNameWithExtention.substring(0,imageNameWithExtention.lastIndexOf(".")-1);
				
				int blobLength = (int) blob.length();
				byte[] blobAsBytes = blob.getBytes(1, blobLength);
				InputStream stream = new ByteArrayInputStream(blobAsBytes);
				downloadFile = new DefaultStreamedContent(stream, "image/jpg", imagename + imageExtention);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	return downloadFile;
   }
   
   public StreamedContent imageDownload(){
	  Customer viewCustomer = null;
		CustomerEmploymentInfo viewCustomerEmpInfo = null;
 		for(CustomerIdProof idProof: viewCustomerIdProof){
 				try{
 					
 					log.info("idproof : "+idProof.getCustProofId());
 					Blob blob = idProof.getFsDocumentImg().getImage();
 					int blobLength = (int) blob.length();  
 					byte[] blobAsBytes = blob.getBytes(1, blobLength);
 					InputStream stream=new ByteArrayInputStream(blobAsBytes);
 			        downloadFile = new DefaultStreamedContent(stream, "image/jpg",  idProof.getFsDocumentImg().getImgId().toPlainString()+".jpg");
 		   } catch(Exception e) {
 			   log.error("image upload Error", e);
 			   e.printStackTrace();
 		 }
 	}
 		//image upload end 
 		return downloadFile;
 	}
 /**
  * Document Save
  * @throws SerialException
  * @throws IOException
  * @throws SQLException
  */
   public void saveDocument(String imagename,BigDecimal customerId,UploadedFile file,String idProofImageType) throws SerialException, IOException, SQLException{
		Blob blob = storeImage(file);
		int blobLength = (int) blob.length();  
		byte[] blobAsBytes = blob.getBytes(1, blobLength);
		
	
		InputStream stream=new ByteArrayInputStream(blobAsBytes);
		 if(idProofImageType.equalsIgnoreCase("company")) {
			 System.out.println("the stream value is"+stream.available());
				setDownloadFileForCompany(new DefaultStreamedContent(stream, "image/jpg", "image.jpg"));
			}else if (idProofImageType.equalsIgnoreCase("partner")) {
				setDownloadFileForPartner(new DefaultStreamedContent(stream, "image/jpg", "image.jpg"));
			}else {
				setDownloadFileForOwner(new DefaultStreamedContent(stream, "image/jpg", "image.jpg"));
			}
		
     //downloadFile = new DefaultStreamedContent(stream, "image/jpg", "image.jpg");
     
		/**
		 * Image Saving Start
		 */
		DocumentImg document = new DocumentImg();
		try {
			document.setImage(storeImage(file));
		} catch (SerialException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		document.setUploadDate(new Date());
		document.setImageName(imagename);
		if(!isImageSave) {
			try {
				if(document.getImage().length()>0) {
				  getCorpRegService().updateImage(document, customerId);
				  if(idProofImageType.equalsIgnoreCase("company")) {
						setCompanyImageId(document.getImgId());
					}else if (idProofImageType.equalsIgnoreCase("partner")) {
						setPartnerImageId(document.getImgId());
					}else {
						setOwnerImageId(document.getImgId());
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			getCorpRegService().saveImage(document);
			if(idProofImageType.equalsIgnoreCase("company")) {
				setCompanyImageId(document.getImgId());
				System.out.println("inside company image id"+getCompanyImageId());
			}else if (idProofImageType.equalsIgnoreCase("partner")) {
				setPartnerImageId(document.getImgId());
				System.out.println("inside partner image id"+getPartnerImageId());
			}else {
				setOwnerImageId(document.getImgId());
				System.out.println("inside ownerr image id"+getOwnerImageId());
			}
		}
		
   }
   public void clearObjetive() {
	   setBussNature(null);
	   setSeconObj(null);
	   setPrimaryObjId(null);
   }
   public void clearContact() {
	    setCountryId(new BigDecimal(0));
		setContType(new BigDecimal(0));
		setStateId(new BigDecimal(0));
		setDistId(new BigDecimal(0));
		setCityId(new BigDecimal(0));
		setArea("");
		setStreet("");
		setBlock("");
		setTel("");
		setFlat("");
   }
   public void clearCompanyDoc() {
	   setIdExpDate(null);
	   setIdentityfile(null);
   }
   public void clearPartnerDetails() {
	    setPartName("");
		setPidno("");
		setPidtype(new BigDecimal(0));
		setPidExpDate(null);
   }
   
  /*
   * 
   * method to clear the fields
   * 
   */
   public String clearAction(){
	   setCoAMLCommon(true);
		setCoAMLPass(false);
		setReadOnly(false);
		setDisableDate(false);
		setCoValdtBtn(true);
		setCrno("");
		setCompName("");
		setCompNameL("");
		setCompRegDate(null);
		setEmail("");
		setLocation(new BigDecimal(0));
		setAMLStatus("");
		setDisableAML(true);
		setEnableContactDataTable(false);
		setContactTypeVisibility(false);
		setCountryVisibility(false);
		setStateVisibility(false);
		setDistrictVisibility(false);
		setCityVisibility(false);
		setAreaVisibility(false);
		setStreetVisibility(false);
		setBlockVisibility(false);
		setTelephoneVisibility(false);
		setFlatVisibility(false);
		setDuplicateContact(false);
		setContactListSizeVisibility(false);
		setCountryId(new BigDecimal(0));
		setContType(new BigDecimal(0));
		setStateId(new BigDecimal(0));
		setDistId(new BigDecimal(0));
		setCityId(new BigDecimal(0));
		setArea("");
		setStreet("");
		setBlock("");
		setTel("");
		setFlat("");
		
		contactList.clear();
		contactListDelete.clear();
		
		secondaryList.clear();
		secondryObjectiveListDeleted.clear();
		
		bussnessList.clear();
		bussenessNatureListDeleted.clear();
		
		setEnableSecondaryObjDataTable(false);
		setPrimayObjVisibility(false);
		setSecondaryObjVisibility(false);
		setSecondaryObjDuplicate(false);
		setSeconObj(new BigDecimal(0));
		setPrimaryObjId(new BigDecimal(0));
		setSecondaryListVisibility(false);
		
		setEnableBussineesDataTable(false);
		setBussenessDuplicateVisibility(false);
		setPrimaySecondaryBussnessVisibility(false);
		setNatureBussineesVisibility(false);
		setBusenessListVisibility(false);
		setBussNature(new BigDecimal(0));
		setObj("");
		return "";
   }
   public void checkRegisterId() {
	    System.out.println("the register id is"+getRegisterId());
	    List<CustomerIdProof>  registerIdProofList= getCorpRegService().getRegisterId(getRegisterId());
	    System.out.println("the register id size"+registerIdProofList.size());
	    if(registerIdProofList.size()>0) {
		 BigDecimal customerIdLocal = registerIdProofList.get(0).getFsCustomer().getCustomerId();
		 List<Customer> custList = getCorpRegService().getCustomerNameFromCustomer(customerIdLocal);
		 setPartName(custList.get(0).getFirstName());
		 setReadOnlyPartnerName(true);
		 setRenderRegisterPartner(false);
	 }else{
		 setRenderRegisterPartner(true);
	 }
	   
   }
   public void redirectToBranch() {
	   try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.invalidateSession();
			context.redirect("../registration/customerregistrationbranch.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
   }

   public IGeneralService<T> getGeneralService() {
   		return generalService;
   }

   public void setGeneralService(IGeneralService<T> generalService) {
   	this.generalService = generalService;
   }

   public String viewBehaviorBean(String componentName, String type){
        if(mapComponentBehavior==null || mapComponentBehavior.size()==0){
			setPageIdIntoSession();
			prepareBehavior();
		}
   		return new CollectionUtil().fetchBehavior(mapComponentBehavior, componentName, type);
   	}
   
   /**
	 *Responsible to fetch Image and populate in page 
	 * @param image
	 * @param fullImageName
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void showImageForCompany(Blob image, String fullImageName) throws SQLException, IOException {
		/*Just a confirmation, that there is a Image exist*/
		if(fullImageName!=null) {
			String imageExtention = fullImageName.substring(fullImageName.lastIndexOf("."));
			String imageName = fullImageName.substring(0,fullImageName.lastIndexOf(".")-1);
			byte[] blobAsBytes = image.getBytes(1, (int) image.length());
			InputStream stream = new ByteArrayInputStream(blobAsBytes);
	        setDownloadFileForCompany(new DefaultStreamedContent(stream, "image/jpg",  imageName  + imageExtention)); 
		}
	}
	/**
	 *Responsible to fetch Image and populate in page 
	 * @param image
	 * @param fullImageName
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void showImageForPartner(Blob image, String fullImageName) throws SQLException, IOException {
		/*Just a confirmation, that there is a Image exist*/
		if(fullImageName!=null) {
			String imageExtention = fullImageName.substring(fullImageName.lastIndexOf("."));
			String imageName = fullImageName.substring(0,fullImageName.lastIndexOf(".")-1);
			byte[] blobAsBytes = image.getBytes(1, (int) image.length());
			InputStream stream = new ByteArrayInputStream(blobAsBytes);
			setDownloadFileForPartner(new DefaultStreamedContent(stream, "image/jpg",  imageName  + imageExtention));
		}
	}
	/**
	 *Responsible to fetch Image and populate in page 
	 * @param image
	 * @param fullImageName
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void showImageForOwner(Blob image, String fullImageName) throws SQLException, IOException {
		/*Just a confirmation, that there is a Image exist*/
		if(fullImageName!=null) {
			String imageExtention = fullImageName.substring(fullImageName.lastIndexOf("."));
			String imageName = fullImageName.substring(0,fullImageName.lastIndexOf(".")-1);
			byte[] blobAsBytes = image.getBytes(1, (int) image.length());
			InputStream stream = new ByteArrayInputStream(blobAsBytes);
	        setDownloadFileForOwner(new DefaultStreamedContent(stream, "image/jpg",  imageName  + imageExtention));
		}
	}
   	@Autowired
   	public CorpRegisterManageBean(IGeneralService<T> generalService){
   		
   		setGeneralService(generalService);
   		
   		//setPageIdIntoSession();
   		/*prepareBehavior();*/
   		//setReadOnly();
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
   		List<String> lstComponentName = Arrays.asList("Cr Number","Company Name","Company Name(L)","Company Registration Date","Email","Location","AML Status","Country","State","District","City","Area","Street","Telephone Number","Flat","Block","Contact Type","Primary/Secondary Objective","Primary Objective","Secondary Objective","Business Nature","Id Number","Partner Name","Id Type","Owner","Contact Person","Contact Number");
   		mapComponentBehavior =  getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());   	}
	
}