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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BankContactDetails;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.treasury.service.IBankMasterContactDetailsService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@Component("bankMasterContactDetails")
@Scope("session")
public class BankMasterContactDetailsBean<T> implements Serializable {
	
	/**
	 * @author 
	 */
	private static final long serialVersionUID = -8824991218131457383L;
	
	private BigDecimal contactIdInternal= null;
	private BigDecimal contactBankId = null;
	private String bankName=null;
	private String contactZone = null;
	private String contactPerson = null;
	private String contactDep = null;
	private String contactDesignation = null;
	private String contactMobile = null;
	private String localContactPerson = null;
	private String localContactDepartment = null;
	private String localContactDesignation = null;
	private Map<BigDecimal, String> bankInfo = new HashMap<BigDecimal, String>(); 
	private List<BankMasterContactDetails> lstBankMasterContactDetails = new ArrayList<BankMasterContactDetails>();
	private List<BankMasterContactDetails> lstBankMasterDeletedContactDetails = new ArrayList<BankMasterContactDetails>();
	private List<BankContactDetails> contactDetails = new ArrayList<BankContactDetails>();
	private Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	private Boolean booLocal = true;
	
	public BigDecimal getContactIdInternal() {
		return contactIdInternal;
	}
	public void setContactIdInternal(BigDecimal contactIdInternal) {
		this.contactIdInternal = contactIdInternal;
	}
	
	public BigDecimal getContactBankId() {
		return contactBankId;
	}
	public void setContactBankId(BigDecimal contactBankId) {
		this.contactBankId = contactBankId;
	}
	
	public String getContactZone() {
		return contactZone;
	}
	public void setContactZone(String contactZone) {
		this.contactZone = contactZone;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getContactDep() {
		return contactDep;
	}
	public void setContactDep(String contactDep) {
		this.contactDep = contactDep;
	}
	
	public String getContactDesignation() {
		return contactDesignation;
	}
	public void setContactDesignation(String contactDesignation) {
		this.contactDesignation = contactDesignation;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	
	public String getLocalContactPerson() {
		return localContactPerson;
	}
	public void setLocalContactPerson(String localContactPerson) {
		this.localContactPerson = localContactPerson;
	}
	
	public String getLocalContactDepartment() {
		return localContactDepartment;
	}
	public void setLocalContactDepartment(String localContactDepartment) {
		this.localContactDepartment = localContactDepartment;
	}
	
	public String getLocalContactDesignation() {
		return localContactDesignation;
	}
	public void setLocalContactDesignation(String localContactDesignation) {
		this.localContactDesignation = localContactDesignation;
	}
	
	public List<BankMasterContactDetails> getLstBankMasterContactDetails() {
		return lstBankMasterContactDetails;
	}
	
	public List<BankMasterContactDetails> getLstBankMasterDeletedContactDetails() {
		return lstBankMasterDeletedContactDetails;
	}
	
	public List<BankContactDetails> getContactDetails() {
		return contactDetails;
	}
	
	public Boolean getBooLocal() {
		return booLocal;
	}
	public void setBooLocal(Boolean booLocal) {
		this.booLocal = booLocal;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Autowired
	IBankMasterContactDetailsService<T> bankMasterContactDetailsService; 
	public IBankMasterContactDetailsService<T> getBankMasterContactDetailsService() {
		return bankMasterContactDetailsService;
	}
	public void setBankMasterContactDetailsService(IBankMasterContactDetailsService<T> bankMasterContactDetailsService) {
		this.bankMasterContactDetailsService = bankMasterContactDetailsService;
	}
	
	@Autowired
	IGeneralService<T> iGeneralService;
	public IGeneralService<T> getiGeneralService() {
		return iGeneralService;
	}
	public void setiGeneralService(IGeneralService<T> iGeneralService) {
		this.iGeneralService = iGeneralService;
	}
	
	/**
	 * Responsible to populate Bank name what is already saved from bank master page 
	 * @return
	 */
	public List<BankMaster> getBankDetails() {
		List<BankMaster> lstCountry = getBankMasterContactDetailsService().getBankMasterInfo();
		for (BankMaster bankMaster : lstCountry) {
			bankInfo.put(bankMaster.getBankId(), bankMaster.getBankFullName());
		}
		return lstCountry;
	}
	
	/**
	 * This method is responsible to ass data in datatable
	 */
	public void addBankMasterContactList() {
		BankMasterContactDetails contactDetails = new BankMasterContactDetails(bankInfo.get(getContactBankId()), getContactBankId(), getContactZone(), 
																														getContactPerson(),  getContactDep(), getContactDesignation(), 
																														getContactMobile(), getLocalContactPerson(), getLocalContactDepartment(), 
																														getLocalContactDesignation(), new BigDecimal(0));
		
		lstBankMasterContactDetails.add(contactDetails);
		clear();
		
	}
	
	/**
	 * This method is responsible to fetch data according to bank selection 
	 */
	public void fetchBankContactInfo() {
		lstBankMasterContactDetails.clear();
		clear();
		if(getContactBankId()!=null) {
			setBankName(bankInfo.get(getContactBankId()));
			//Responsible to local panel on off
			List<BankMaster> countryOfBank = getBankMasterContactDetailsService().getbankCountryInfo(getContactBankId());
			if(countryOfBank.get(0).getFsCountryMaster().getCountryId().intValue() != 120) {
				setBooLocal(false);
			} else {
				setBooLocal(true);
			}
			
			//Responsible to fetch contact details 
			contactDetails = getBankMasterContactDetailsService().getbankContactInfo(getContactBankId());
			if(contactDetails!=null && contactDetails.size() > 0){
				for (BankContactDetails element : contactDetails) {
					BankMasterContactDetails  contactDetails = new BankMasterContactDetails(bankInfo.get(element.getExBankMaster().getBankId()), 
																												element.getExBankMaster().getBankId(), element.getRegion(), 
																												element.getContactPerson(), element.getContactDept(), 
																												element.getContactDesg(), element.getMobile(), 
																												element.getContactPersonAr(), element.getContactDeptAr(),
																												element.getContactDesgAr(), element.getBankContactId());
					lstBankMasterContactDetails.add(contactDetails);
				}
			}
		}
	}
	
	/**
	 * This method is responsible to manage deleted objects
	 * @param contactDetails
	 */
	public void remove(BankMasterContactDetails contactDetails){
		lstBankMasterContactDetails.remove(contactDetails);
		lstBankMasterDeletedContactDetails.add(contactDetails);
	}
	
	/**
	 * This method is responsible to save the data 
	 */
	public void save() {
		System.out.println(".........................................");
		BankContactDetails contactDetails;
		BankMaster bankMaster;
		
		//Responsible to add active objects from contact details
		for (BankMasterContactDetails element : lstBankMasterContactDetails) {
			contactDetails = new BankContactDetails();
			contactDetails.setRegion(element.getZone());
			contactDetails.setContactPerson(element.getContactPerson());
			contactDetails.setContactDept(element.getContactDep());
			contactDetails.setContactDesg(element.getContactDesignation());
			contactDetails.setContactPersonAr(element.getLocalContactPerson());
			contactDetails.setContactDeptAr(element.getLocalContactDepartment());
			contactDetails.setContactDesgAr(element.getLocalContactDesignation());
			contactDetails.setMobile(element.getMobile());
			contactDetails.setRecordStatus("1");
			
			bankMaster = new BankMaster();
			bankMaster.setBankId(element.getBankId());
			
			//if condition Going to update, else section going to insert
			if(element.getInternalContactId().intValue() != 0) {
				contactDetails.setBankContactId(element.getInternalContactId());
				contactDetails.setModifier("Tanumoy");
				contactDetails.setUpdateDate(new Date());
			} else {
				contactDetails.setCreateDate(new Date());
				contactDetails.setCreator("Tanumoy");
			}
			
			contactDetails.setExBankMaster(bankMaster);
			contactDetails.setBankContactId(contactDetails.getBankContactId());
			getBankMasterContactDetailsService().saveBankMasterContactDetails(contactDetails);
			/*After Add we need to store the primary key, unless this if user press add multiple time, it will insert multiple times in database, but if we save
			primary key, it will update*/
			element.setInternalContactId(contactDetails.getBankContactId());
		}
		
		//Responsible to add inactive objects from contact details
		for (BankMasterContactDetails element : lstBankMasterDeletedContactDetails) {
			contactDetails = new BankContactDetails();
			contactDetails.setRegion(element.getZone());
			contactDetails.setContactPerson(element.getContactPerson());
			contactDetails.setContactDept(element.getContactDep());
			contactDetails.setContactDesg(element.getContactDesignation());
			contactDetails.setContactPersonAr(element.getLocalContactPerson());
			contactDetails.setContactDeptAr(element.getLocalContactDepartment());
			contactDetails.setContactDesgAr(element.getLocalContactDesignation());
			contactDetails.setMobile(element.getMobile());
			contactDetails.setRecordStatus("0");
			
			bankMaster = new BankMaster();
			bankMaster.setBankId(element.getBankId());
			
			//if condition Going to update, else section going to insert
			if(element.getInternalContactId().intValue() != 0) {
				contactDetails.setBankContactId(element.getInternalContactId());
				contactDetails.setModifier("Tanumoy");
				contactDetails.setUpdateDate(new Date());
			} else {
				contactDetails.setCreateDate(new Date());
				contactDetails.setCreator("Tanumoy");
			}
			
			contactDetails.setExBankMaster(bankMaster);
			getBankMasterContactDetailsService().saveBankMasterContactDetails(contactDetails);
		}
		
		clear();
	}
	
	/**
	 * This method is responsible to clear the page
	 */
	public void clear() {
		//setContactBankId(null);
		setContactZone("");
		setContactPerson("");
		setContactDep("");
		setContactDesignation("");
		setContactMobile("");
		setLocalContactPerson("");
		setLocalContactDepartment("");
		setLocalContactDesignation("");
	}
	
	/**
	 * This method is responsible when cancel button is pressed
	 */
	public void cancel() {
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../login/login.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
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
		List<String> lstComponentName = Arrays.asList( "Bank Id", 
																				"Zone",
																				"Contact Person",
																				"Contact Dep",
																				"Contact Designation",
																				"Mobile",
																				
																				"Local Contact Person",
																				"Local Contact Dep",
																				"Local Contact Des");
		mapComponentBehavior =  getiGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
	}
	
	/**
	 * This method is calling from Go button of Dialogue Box, Box will appear after clicking Add button(for datatable ADD)    
	 */
	public void goFromPopUp() {
		addBankMasterContactList();
	}
	
	/**
	 * This method will call from cancel button of Dialogue box, Box will appear after clicking Cancel button (for datatable ADD)
	 */
	public void cancelFromPopUp() {
		clear();
	}
}
