package com.amg.exchange.treasury.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CityMasterDesc;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DistrictMasterDesc;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.model.StateMasterDesc;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.treasury.service.IBankMasterService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@Component("bankMaster")
@Scope("session")
public class BankMasterInfoBean<T> implements Serializable {

	/**
	 * @author 
	 */
	private static final long serialVersionUID = -1333138778448003609L;
	
	Logger log=Logger.getLogger(BankMasterInfoBean.class);
	
	/**
	 * Constructor
	 */
	public BankMasterInfoBean() {
		setValidationValue();
	}
	
	private BigDecimal bankIdInternal = null;
	private String bankCode = null;
	private String fullName = null;
	private String shortName = null;
	private String languageBank = null;
	private String address1 = null;
	private String address2 = null;
	private BigDecimal countryId = null;
	private BigDecimal stateId = null;
	private BigDecimal districtId = null;
	private BigDecimal cityId = null;
	private String zip = null;
	private String telephone = null;
	private String fax = null;
	private String email = null;
	private String contactPerson = null;
	private String designation = null;
	private String department = null;
	private String localFullName = null;
	private String localShortname = null;
	private String localAddress1 = null;
	private String localAddress2 = null;
	private String localContactPerson = null;
	private String localDesignation = null;
	private String localDepartment = null;
	private String IFSCLength = null;
	private String reutersBankNname = null;
	private String fileSpecificOrAll = null;
	private String fileBranchWiseYOrN = null;
	private String MICRReuters = null;
	private String remmiterModeYOrN = null; 
	
	private Boolean booBankGenInfo = true;
	private Boolean booBankAddress = false;
	private Boolean booLocalPanelRender = false;
	private Boolean booFileAcceptance = false;
	private List<StateMasterDesc> lstStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstCityList = new ArrayList<CityMasterDesc>();
	Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLanguageBank() {
		return languageBank;
	}
	public void setLanguageBank(String languageBank) {
		this.languageBank = languageBank;
	}

	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}
	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}
	
	public BigDecimal getDistrictId() {
		return districtId;
	}
	public void setDistrictId(BigDecimal districtId) {
		this.districtId = districtId;
	}
	
	public BigDecimal getStateId() {
		return stateId;
	}
	public void setStateId(BigDecimal stateId) {
		this.stateId = stateId;
	}

	public BigDecimal getCityId() {
		return cityId;
	}
	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocalFullName() {
		return localFullName;
	}
	public void setLocalFullName(String localFullName) {
		this.localFullName = localFullName;
	}

	public String getLocalShortname() {
		return localShortname;
	}
	public void setLocalShortname(String localShortname) {
		this.localShortname = localShortname;
	}

	public String getLocalAddress1() {
		return localAddress1;
	}
	public void setLocalAddress1(String localAddress1) {
		this.localAddress1 = localAddress1;
	}

	public String getLocalAddress2() {
		return localAddress2;
	}
	public void setLocalAddress2(String localAddress2) {
		this.localAddress2 = localAddress2;
	}

	public String getLocalContactPerson() {
		return localContactPerson;
	}
	public void setLocalContactPerson(String localContactPerson) {
		this.localContactPerson = localContactPerson;
	}

	public String getLocalDesignation() {
		return localDesignation;
	}
	public void setLocalDesignation(String localDesignation) {
		this.localDesignation = localDesignation;
	}

	public String getLocalDepartment() {
		return localDepartment;
	}
	public void setLocalDepartment(String localDepartment) {
		this.localDepartment = localDepartment;
	}

	public String getIFSCLength() {
		return IFSCLength;
	}
	public void setIFSCLength(String iFSCLength) {
		IFSCLength = iFSCLength;
	}

	public String getReutersBankNname() {
		return reutersBankNname;
	}
	public void setReutersBankNname(String reutersBankNname) {
		this.reutersBankNname = reutersBankNname;
	}

	public String getFileSpecificOrAll() {
		return fileSpecificOrAll;
	}
	public void setFileSpecificOrAll(String fileSpecificOrAll) {
		this.fileSpecificOrAll = fileSpecificOrAll;
	}

	public String getFileBranchWiseYOrN() {
		return fileBranchWiseYOrN;
	}
	public void setFileBranchWiseYOrN(String fileBranchWiseYOrN) {
		this.fileBranchWiseYOrN = fileBranchWiseYOrN;
	}

	public String getMICRReuters() {
		return MICRReuters;
	}
	public void setMICRReuters(String mICRReuters) {
		MICRReuters = mICRReuters;
	}

	public String getRemmiterModeYOrN() {
		return remmiterModeYOrN;
	}
	public void setRemmiterModeYOrN(String remmiterModeYOrN) {
		this.remmiterModeYOrN = remmiterModeYOrN;
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
	
	public Boolean getBooBankGenInfo() {
		return booBankGenInfo;
	}
	public void setBooBankGenInfo(Boolean booBankGenInfo) {
		this.booBankGenInfo = booBankGenInfo;
	}
	
	public Boolean getBooBankAddress() {
		return booBankAddress;
	}
	public void setBooBankAddress(Boolean booBankAddress) {
		this.booBankAddress = booBankAddress;
	}
	
	public boolean getBooLocalPanelRender() {
		return booLocalPanelRender;
	}
	public void setBooLocalPanelRender(boolean booLocalPanelRender) {
		this.booLocalPanelRender = booLocalPanelRender;
	}
	
	public Boolean getBooFileAcceptance() {
		return booFileAcceptance;
	}
	public void setBooFileAcceptance(Boolean booFileAcceptance) {
		this.booFileAcceptance = booFileAcceptance;
	}

	public BigDecimal getBankIdInternal() {
		return bankIdInternal;
	}
	public void setBankIdInternal(BigDecimal bankIdInternal) {
		this.bankIdInternal = bankIdInternal;
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
	IBankMasterService<T> bankMasterInfoService;
	public IBankMasterService<T> getBankMasterInfoService() {
		return bankMasterInfoService;
	}
	public void setBankMasterInfoService(IBankMasterService<T> bankMasterInfoService) {
		this.bankMasterInfoService = bankMasterInfoService;
	}
	
	/**
	 * Responsible to populate Country
	 * @return
	 */
	public List<CountryMasterDesc> getCountryNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> lstCountry = getiGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
		return lstCountry;
	}
	
	/**
	 * Responsible to prepare stateList by country change
	 * @param event
	 */
	public void generateStateList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<StateMasterDesc> stateMaster =getiGeneralService().getStateList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountryId()); 
		setLstStateList(stateMaster);
		
		if(getCountryId()!= null && getCountryId().intValue() != 120) {
			setBooLocalPanelRender(false);
		} else {
			setBooLocalPanelRender(true);
		}
		
		/*reset State, District, City, as country is changing*/ 
		setStateId(null);
		setDistrictId(null);
		setCityId(null);
		
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
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountryId(), getStateId()
				);
		setLstDistrictList(lstDistrict);
		
		/*reset District, City, as state is changing*/ 
		setDistrictId(null);
		setCityId(null);
	}
	
	/**
	 * Responsible to populate city depending upon district selection
	 * @param event
	 */
	public void generateCityList(AjaxBehaviorEvent event) {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																												getCountryId(),	getStateId(),	getDistrictId()
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
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountryId()); 
		setLstStateList(stateMaster);
	}
	
	/**
	 * This method is responsible to populate district depending upon state election 
	 */
	private void populateDistrict() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<DistrictMasterDesc> lstDistrict = getiGeneralService().getDistrictList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), getCountryId(), getStateId()
				);
		setLstDistrictList(lstDistrict);
	}
	
	/**
	 * This method is responsible to populate City depending upon district selection 
	 */
	private void populateCity() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CityMasterDesc> lstCity = getiGeneralService().getCityList(
				new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1), 
																												getCountryId(),	getStateId(),	getDistrictId()
				); 
		setLstCityList(lstCity);
	}
	
	/**
	 * method is responsible to cancel the Bank Master
	 * @return
	 */
	public void cancel() {
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../login/login.xhtml");
		} catch(Exception e) {
			log.info("Redirection Problem to Login by Cancel button");
		}
	}
	
	/**
	 * Responsible to save Bank Master details 
	 * @return
	 */
	public void save() {
		BankMaster bankMaster = new BankMaster();
		bankMaster.setBankCode(getBankCode());
		bankMaster.setBankFullName(getFullName());
		bankMaster.setBankShortName(getShortName());
		bankMaster.setLanguageInd(getLanguageBank());
		bankMaster.setAddress1(getAddress1());
		bankMaster.setAddress2(getAddress2());
		bankMaster.setZipCode(getZip());
		bankMaster.setTeleponeNo(getTelephone());
		bankMaster.setFaxNo(getFax());
		bankMaster.setEmail(getEmail());
		bankMaster.setBankFullNameAr(getLocalFullName());
		bankMaster.setBankShortNameAr(getLocalShortname());
		bankMaster.setAddress1Ar(getLocalAddress1());
		bankMaster.setAddress2Ar(getLocalAddress2());
		bankMaster.setIfscLen(new BigDecimal(getIFSCLength()));
		bankMaster.setReutersBankName(getReutersBankNname() );
		bankMaster.setFileAlls(getFileSpecificOrAll());
		bankMaster.setFileBranch(getFileBranchWiseYOrN());
		bankMaster.setMicrCode(getMICRReuters());
		bankMaster.setFileRemitMode(getRemmiterModeYOrN());
		
		CountryMaster countryMaster =  new CountryMaster();
		countryMaster.setCountryId(getCountryId());
		bankMaster.setFsCountryMaster(countryMaster);
		
		StateMaster statemaster = new StateMaster();
		statemaster.setStateId(getStateId());
		bankMaster.setFsStateMaster(statemaster);
		
		DistrictMaster districtMaster = new DistrictMaster();
		districtMaster.setDistrictId(getDistrictId());
		bankMaster.setFsDistrictMaster(districtMaster);
		
		CityMaster cityMaster = new CityMaster();
		cityMaster.setCityId(getCityId());
		bankMaster.setFsCityMaster(cityMaster);
		
		//TODO hard code user name   
		bankMaster.setCreator("Tanumoy");
		bankMaster.setCreateDate(new Date());
		
		/*It will return true always, except the very first time*/  
		if(getBankIdInternal() != null){
			bankMaster.setBankId(getBankIdInternal());
			bankMaster.setUpdateDate(new Date());
			bankMaster.setModifier("Tanumoy");
		}
		getBankMasterInfoService().saveBankMasterInfo(bankMaster);
		
		/*setting primary key*/
		setBankIdInternal(bankMaster.getBankId());
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../treasury/bankcontactdetails.xhtml");
		} catch(Exception e) {
			log.info("Problem to redirect:"+e);
		}
	}
	
	/**
	 * Responsible to clear all component of Bank Master
	 * @return
	 */
	public void clear() {
		setBankCode("");
		setFullName("");
		setShortName("");
		setLanguageBank("");
		setAddress1("");
		setAddress2("");
		setCountryId(null);
		setStateId(null);
		setDistrictId(null);
		setCityId(null);
		setZip("");
		setTelephone("");
		setFax("");
		setEmail("");
		setContactPerson("");
		setDesignation("");
		setDepartment("");
		setLocalFullName("");
		setLocalShortname("");
		setLocalAddress1("");
		setLocalAddress2("");
		setLocalContactPerson("");
		setLocalDesignation("");
		setLocalDepartment("");
		setIFSCLength(null);
		setReutersBankNname("");
		setFileSpecificOrAll("");
		setFileBranchWiseYOrN("");
		setMICRReuters("");
		setRemmiterModeYOrN(""); 
		
		setBooBankGenInfo(true);
		setBooBankAddress(false);
		setBooFileAcceptance(false);
		
		setBankIdInternal(null);
	}
	
	/**
	 * Fetch data depending upon given bank Code 
	 */
	public void fetchBankMasterInfo() {
		List<BankMaster> lstBankMasterInfo = new ArrayList<BankMaster>();
		/*Checking that BankCode field empty or not*/ 
		if(getBankCode() != null && getBankCode().length() > 0){
			lstBankMasterInfo = getBankMasterInfoService().getBankMasterInfo(getBankCode());
			/*checking that data is there in database or not, for the given Bank Code*/   
			if(lstBankMasterInfo != null && lstBankMasterInfo.size() > 0) {
				/*setting primary key*/ 
				setBankIdInternal(lstBankMasterInfo.get(0).getBankId());
				/*setBankCode(lstBankMasterInfo.get(0).getBankCode());*/
				setFullName(lstBankMasterInfo.get(0).getBankFullName());
				setShortName(lstBankMasterInfo.get(0).getBankShortName());
				setLanguageBank(lstBankMasterInfo.get(0).getLanguageInd());
				setAddress1(lstBankMasterInfo.get(0).getAddress1());
				setAddress2(lstBankMasterInfo.get(0).getAddress2());
				setCountryId(lstBankMasterInfo.get(0).getFsCountryMaster().getCountryId());
				/*Now we need to populate state depending upon country(saved), otherwise state will not set with the state previously saved state*/
				populateState(); 
				setStateId(lstBankMasterInfo.get(0).getFsStateMaster().getStateId());
				/*Now we need to populate District depending upon state(saved), otherwise district will not set with the district previously saved district*/
				populateDistrict();
				setDistrictId(lstBankMasterInfo.get(0).getFsDistrictMaster().getDistrictId());
				/*Now we need to populate City depending upon city(saved), otherwise city will not set with the city previously saved city*/
				populateCity();
				setCityId(lstBankMasterInfo.get(0).getFsCityMaster().getCityId());
				setZip(lstBankMasterInfo.get(0).getZipCode());
				setTelephone(lstBankMasterInfo.get(0).getTeleponeNo());
				setFax(lstBankMasterInfo.get(0).getFaxNo());
				setEmail(lstBankMasterInfo.get(0).getEmail());
				setLocalFullName(lstBankMasterInfo.get(0).getBankFullNameAr());
				setLocalShortname(lstBankMasterInfo.get(0).getBankShortNameAr());
				setLocalAddress1(lstBankMasterInfo.get(0).getAddress1Ar());
				setLocalAddress2(lstBankMasterInfo.get(0).getAddress2Ar());
				setIFSCLength(lstBankMasterInfo.get(0).getIfscLen().toPlainString());
				setReutersBankNname(lstBankMasterInfo.get(0).getReutersBankName());
				setFileSpecificOrAll(lstBankMasterInfo.get(0).getFileAlls());
				setFileBranchWiseYOrN(lstBankMasterInfo.get(0).getFileBranch());
				setMICRReuters(lstBankMasterInfo.get(0).getMicrCode());
				setRemmiterModeYOrN(lstBankMasterInfo.get(0).getFileRemitMode()); 
			} else {
				String bankCode = getBankCode();
				clear();
				setBankCode(bankCode);
			}
		}
		setBooBankGenInfo(true);
		setBooBankAddress(false);
		setBooFileAcceptance(false);
	}
	
	/**
	 * This method is responsible to set the validation value from rule engine
	 */
	public void setValidationValue() {

	}
	
	/**
	 * This method will call when OK will clicked from confirm dialogue box 
	 */
	public void welcomeListener() {
	    //System.out.println("Welcome Back");
	}
	
	/**
	 * This method will call when Log Me Out button will press from confirm dialogue box
	 * @throws IOException
	 */
	public void logoutListener() throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		 ec.invalidateSession();
		 //System.out.println(ec.getRequestContextPath()) ....This will print the  "/AlmullaExchange"...Context Name..That's why we store External context in 'ec' variable 
		 ec.redirect(ec.getRequestContextPath() + "/index.jsp");
	}
	
	/**
	 * This method is responsible to supply, behavior of the component,calling from page 
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
	 * This method is responsible to track the page name from viewId and then it will search in page master table, then from there ID will get, and store in session 	
	 */
	private void setPageIdIntoSession(){
	   
		String pageName = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		pageName = pageName.substring(pageName.lastIndexOf('/')+1, pageName.indexOf(".xhtml"));
		
		try{
			BigDecimal pageId = getiGeneralService().getPageId(pageName);
			new SessionStateManage().setSessionValue("pageId", pageId.toString());
		}catch(Exception e){
			System.out.println("Page id not found for pagename :: "+pageName+" :: "+e);
		}
	}
		
	private void prepareBehavior(){
		
		SessionStateManage manage = new SessionStateManage(); 
		//System.out.println("Component parameter ======================= "+manage.getApplicationId()+", "+manage.getCompanyId()+", "+manage.getCompanyId()+", "+manage.getPageId());
		List<String> lstComponentName = Arrays.asList( "Bank Code",
																				"Bank Full Name",
																				"Bank Short Name",
																				"Bank Language",
																				"Bank first address", 
																				"Bank second address",
																				"Country",
																				"State",
																				"District",
																				"City",
																				"zip", 
																				"Telephone Number",
																				"Fax",
																				"Email",
																				"Bank local Full Name", 
																				"Bank local Short Name",
																				"Bank local first address",
																				"Bank local second address",
																				"IFSC Length",
																				"Reuters Bank Name",
																				"File Specific",  
																				"File Branch Wise",
																				"MICR Reuters",
																				"Remmiter Mode"
																			  );
		mapComponentBehavior =  getiGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
		/*for(Entry<String,BussComponentConfDetail> en:mapComponentBehavior.entrySet()){
			System.out.println("Key: "+en.getKey()+", level : "+en.getValue().getFsBusinessComponentConf().getLevelId());
			System.out.println("Object : "+en.getValue().toString());
		}*/
	}
	
	/**
	 * When Next click from first(bankInfoPanel) panel
	 */
	public void bankInfoPanelNext() {
		setBooBankGenInfo(false);
		setBooBankAddress(true);
		setBooFileAcceptance(false);
		
		/*First time we have to make this local panel invisible, at that time Id will be null*/
		if(getCountryId() == null) {
			setBooLocalPanelRender(false);
		} else if(getCountryId()!= null && getCountryId().intValue() != 120) {
			setBooLocalPanelRender(false);
		} else {
			setBooLocalPanelRender(true);
		}
	}
	
	/**
	 * Next button clicked from Address panel
	 */
	public void bankAddressInfoPanelNext() {
		setBooBankGenInfo(false);
		setBooBankAddress(false);
		setBooFileAcceptance(true);
	}
	
	/**
	 * Back button clicked from address panel 
	 */
	public void bankAddressInfoPanelBack() {
		setBooBankGenInfo(true);
		setBooBankAddress(false);
		setBooFileAcceptance(false);
	}
	
	/**
	 * Back button pressed from file acceptance panel
	 */
	public void fileAcceptancePanelBack() {
		setBooBankGenInfo(false);
		setBooBankAddress(true);
		setBooFileAcceptance(false);
	}
	
}
