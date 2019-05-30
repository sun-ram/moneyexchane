package com.amg.exchange.treasury.bean;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BankAccountDetails;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.treasury.service.IBankAccountDetailsService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@Component("bankaccountdetails")
@Scope("session")
public class BankAccountDetailsBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal bankAccountDetId = null;//PK
	private BigDecimal bankId = null;
	private String accountNo = null;
	private String accountType = null;
	private String accountDesc = null;
	private String currency = null;
	private BigDecimal minBalance = null;
	private BigDecimal odLimit = null;
	private String glNo = null;
	private BigDecimal countryId = null;
	private String telephone = null;
	private String fax = null;
	private String email = null;
	private String contactPerson = null;
	private String department = null;
	private String designation = null;
	private String mobile = null;
	private String contPersonLocal = null;
	private String departmentLocal = null;
	private String designationLocal = null;
	private String fundGlNo = null;
	private BigDecimal internalMinBalance = null;
	private Boolean accountdetail = true;
	private Boolean contactdetail = false;
	private Boolean contactdetaillocal = false;
	
	private List<BankMaster> bankMasterList;
	
	/*private List<StateMasterDesc> lstStateList = new ArrayList<StateMasterDesc>();
	private List<DistrictMasterDesc> lstDistrictList = new ArrayList<DistrictMasterDesc>();
	private List<CityMasterDesc> lstCityList = new ArrayList<CityMasterDesc>();
	*/
	
	@Autowired
	IGeneralService<T> generalService;
	@Autowired
	IBankAccountDetailsService<T> iBankAccountDetService;
	
	
	public BigDecimal getBankAccountDetId() {
		return bankAccountDetId;
	}
	public void setBankAccountDetId(BigDecimal bankAccountDetId) {
		this.bankAccountDetId = bankAccountDetId;
	}
	
	
	public BigDecimal getBankId() {
		return bankId;
	}
	public void setBankId(BigDecimal bankId) {
		this.bankId = bankId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountDesc() {
		return accountDesc;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getGlNo() {
		return glNo;
	}
	public void setGlNo(String glNo) {
		this.glNo = glNo;
	}
	
	/*public String getAddress1() {
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
	}*/
	public BigDecimal getCountryId() {
		return countryId;
	}
	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContPersonLocal() {
		return contPersonLocal;
	}
	public void setContPersonLocal(String contPersonLocal) {
		this.contPersonLocal = contPersonLocal;
	}
	public String getDepartmentLocal() {
		return departmentLocal;
	}
	public void setDepartmentLocal(String departmentLocal) {
		this.departmentLocal = departmentLocal;
	}
	public String getDesignationLocal() {
		return designationLocal;
	}
	public void setDesignationLocal(String designationLocal) {
		this.designationLocal = designationLocal;
	}
	public String getFundGlNo() {
		return fundGlNo;
	}
	public void setFundGlNo(String fundGlNo) {
		this.fundGlNo = fundGlNo;
	}
	
public BigDecimal getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(BigDecimal minBalance) {
		this.minBalance = minBalance;
	}
	public BigDecimal getOdLimit() {
		return odLimit;
	}
	public void setOdLimit(BigDecimal odLimit) {
		this.odLimit = odLimit;
	}
	public BigDecimal getInternalMinBalance() {
		return internalMinBalance;
	}
	public void setInternalMinBalance(BigDecimal internalMinBalance) {
		this.internalMinBalance = internalMinBalance;
	}

public IGeneralService<T> getGeneralService() {
		return generalService;
	}
	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}


	public IBankAccountDetailsService<T> getiBankAccountDetService() {
		return iBankAccountDetService;
	}
	public void setiBankAccountDetService(
			IBankAccountDetailsService<T> iBankAccountDetService) {
		this.iBankAccountDetService = iBankAccountDetService;
	}


	public List<BankMaster> getBankMasterList() {
		return bankMasterList;
	}
	public void setBankMasterList(List<BankMaster> bankMasterList) {
		this.bankMasterList = bankMasterList;
	}

/*
	private String userName=FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap().get("userName")
			.toString();
*/
/*public List<CountryMasterDesc> getCountryNameList() {

	
	SessionStateManage sessionStateManage = new SessionStateManage();
		return getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));
}*/


/**
 * Responsible to populate Country
 * @return
 */
public List<CountryMasterDesc> getCountryNameList() {
	SessionStateManage sessionStateManage = new SessionStateManage();
	List<CountryMasterDesc> lstCountry = getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):""+1));
	return lstCountry;
}


public Boolean getAccountdetail() {
	return accountdetail;
}
public void setAccountdetail(Boolean accountdetail) {
	this.accountdetail = accountdetail;
}
public Boolean getContactdetail() {
	return contactdetail;
}
public void setContactdetail(Boolean contactdetail) {
	this.contactdetail = contactdetail;
}

public Boolean getContactdetaillocal() {
	return contactdetaillocal;
}
public void setContactdetaillocal(Boolean contactdetaillocal) {
	this.contactdetaillocal = contactdetaillocal;
}
public void nextAccountDetails(){
	setAccountdetail(false);
	setContactdetail(true);
	if(getCountryId()!= null && getCountryId().intValue() != 120) {
		setContactdetaillocal(false);
	} else {
		setContactdetaillocal(true);
	}
}


public void backAccountDetails(){
	
	setAccountdetail(true);
	setContactdetail(false);
	
	
}


/**
 *  method is responsible to populate List of Bank from DB 
 * @return
 */

public void popBank(AjaxBehaviorEvent e) {
	
	bankMasterList = new ArrayList<BankMaster>();
	SessionStateManage sessionStateManage = new SessionStateManage();
	
	bankMasterList.addAll(getGeneralService().getAllBankList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId()));
}

/**
 * Responsible to save Bank Account details 
 * @return
 */
public String save() {

	BankAccountDetails accountdetails = new BankAccountDetails();
	
	CountryMaster countryMaster =  new CountryMaster();
	countryMaster.setCountryId(getCountryId());
	accountdetails.setFsCountryMaster(countryMaster);
	
	CompanyMaster companymaster = new CompanyMaster();
	companymaster.setCompanyId(new BigDecimal(1));
	accountdetails.setFsCompanyMaster(companymaster);
	
	BankMaster bankmaster = new BankMaster();
	bankmaster.setBankId(getBankId());
	accountdetails.setExBankMaster(bankmaster);

	accountdetails.setBankAcctNo(getAccountNo());
	accountdetails.setAcctType(getAccountType());
	accountdetails.setCurrencyCode(getCurrency());
	accountdetails.setMinBal(getMinBalance());
	accountdetails.setOdlmt(getOdLimit());
	accountdetails.setGlno(getGlNo());
	accountdetails.setTelephoneNo(getTelephone());
	accountdetails.setFaxno(getFax());
	accountdetails.setEmail(getEmail());
	accountdetails.setContactPerson(getContactPerson());
	accountdetails.setContactDept(getDepartment());
	accountdetails.setContactDesg(getDesignation());
	accountdetails.setMobile(getMobile());
	accountdetails.setContactPersonAr(getContPersonLocal());
	accountdetails.setContactDeptAr(getDepartmentLocal());
	accountdetails.setContactDesgAr(getDesignationLocal());
	accountdetails.setBankAcctDetId(new BigDecimal(0));
	accountdetails.setFundGlno(getFundGlNo());
	accountdetails.setIntMinbal(getInternalMinBalance());
	setBankAccountDetId(accountdetails.getBankAcctDetId());
	if(getBankAccountDetId() != null && getBankAccountDetId().intValue() != 0){
		accountdetails.setRecordStatus("U");
		accountdetails.setModifier("Hashmi");
		accountdetails.setUpdateDate(new Date());
		
	} else {
		
		accountdetails.setRecordStatus("A");
		accountdetails.setCreateDate(new Date());
		accountdetails.setCreator("Nazish");
	}
	getiBankAccountDetService().saveBankAccountDetails(accountdetails);
	return "";
}

/**
 *for fetching the records if Account No Already Exists
 *
 */

public void fetchBankAccountDetails() {
	List<BankAccountDetails> bankaccountdetailslist = new ArrayList<BankAccountDetails>();	
	if(getAccountNo() != null && getAccountNo().length()>0){
		System.out.println("================="+getAccountNo());
		bankaccountdetailslist = getiBankAccountDetService().getBankAccountDetails(getAccountNo());	
		System.out.println("====Bank Account List======"+bankaccountdetailslist);
		System.out.println("------------------------------"+getiBankAccountDetService().getBankAccountDetails(getAccountNo()));
		if(bankaccountdetailslist != null && bankaccountdetailslist.size() > 0){
			
			setBankAccountDetId(bankaccountdetailslist.get(0).getBankAcctDetId());
			setCountryId(bankaccountdetailslist.get(0).getFsCountryMaster().getCountryId());
			setBankId(bankaccountdetailslist.get(0).getExBankMaster().getBankId());
			setAccountNo(bankaccountdetailslist.get(0).getBankAcctNo());
			setAccountType(bankaccountdetailslist.get(0).getAcctType());
			setCurrency(bankaccountdetailslist.get(0).getCurrencyCode());
			setMinBalance(bankaccountdetailslist.get(0).getMinBal());
			setOdLimit(bankaccountdetailslist.get(0).getOdlmt());
			setGlNo(bankaccountdetailslist.get(0).getGlno());
			setTelephone(bankaccountdetailslist.get(0).getTelephoneNo());
			setFax(bankaccountdetailslist.get(0).getFaxno());
			setEmail(bankaccountdetailslist.get(0).getEmail());
			setContactPerson(bankaccountdetailslist.get(0).getContactPerson());
			setDepartment(bankaccountdetailslist.get(0).getContactDept());
			setDesignation(bankaccountdetailslist.get(0).getContactDesg());
			setContPersonLocal(bankaccountdetailslist.get(0).getContactPersonAr());
			setDepartmentLocal(bankaccountdetailslist.get(0).getContactDeptAr());
			setDesignationLocal(bankaccountdetailslist.get(0).getContactDesgAr());
			setFundGlNo(bankaccountdetailslist.get(0).getFundGlno());
			setInternalMinBalance(bankaccountdetailslist.get(0).getIntMinbal());
		} else {
			String accountno = getAccountNo();
			reset();
			setAccountNo(accountno);
		}
	}
		
	
}

/**
 *for Clear the field
 *
 */
public void reset() { 
	setBankId(null);
	setAccountType("");
	setAccountNo("");
	setAccountDesc("");
	setCurrency("");
	setMinBalance(null);
	setOdLimit(null);
	setGlNo("");
	//setAddress1("");
	//setAddress2("");
	setCountryId(null);
	setTelephone("");
	setFax("");
	setMobile("");
	setEmail("");
	setContactPerson("");
	setDepartment("");
	setDesignation("");
	setContPersonLocal("");
	setDepartmentLocal("");
	setDesignationLocal("");
	setFundGlNo("");
	setInternalMinBalance(null);
	setAccountdetail(true);
	setContactdetail(false);
	setContactdetaillocal(false);
}
/**
 * method is responsible to cancel 
 * @return
 */
public void cancel() {
	try{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
		context.redirect("../login/login.xhtml");
	} catch(Exception e) {
		e.printStackTrace();
	}
}

Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();

public String viewBehaviorBean(String componentName, String type){

	return new CollectionUtil().fetchBehavior(mapComponentBehavior, componentName, type);
}

@Autowired
public BankAccountDetailsBean(IGeneralService<T> generalService){

	setGeneralService(generalService);

	setPageIdIntoSession();
	prepareBehavior();
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
	List<String> lstComponentName = Arrays.asList("Country","Banks","Account No","Account Type","Currency","Minimum Balance","OD Limit","GL No","Telephone Number","Mobile No", "Fax","Email","Contact Person","Department","Designation","Contact Person Local","Department Local","Designation Local","Fund GL No","Internal Minimum Balance");
	mapComponentBehavior =  getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
}

}
