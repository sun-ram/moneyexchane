package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.Nominee;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.service.INomineeService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

@Component("nomineeRegistration")
@Scope("session")
public class NomineeRegistration implements Serializable{

	@SuppressWarnings("rawtypes")
	@Autowired
	INomineeService nomineeService;
	
	/**
	 * @return the nomineeService
	 */
	@SuppressWarnings("rawtypes")
	public INomineeService getNomineeService() {
		return this.nomineeService;
	}
	/**
	 * @param nomineeService the nomineeService to set
	 */
	public void setNomineeService(INomineeService nomineeService) {
		this.nomineeService = nomineeService;
	}
	@Autowired
	IGeneralService generalService;
	
	
	/**
	 * @return the generalService
	 */
	public IGeneralService getGeneralService() {
		return this.generalService;
	}
	/**
	 * @param generalService the generalService to set
	 */
	public void setGeneralService(IGeneralService generalService) {
		this.generalService = generalService;
	}
	NomineeRegistration(){
		
	}

	/**
	 *  Variables 
	 */
	private static final long serialVersionUID = 1L;
	private String civilID;
	private String tittle;
	private String firstName;
	private String middleName;
	private String lastName;
	private String shortName;
	private String firstNameLocal;
	private String middleNameLocal;
	private String lastNameLocal;
	private String shortNameLocal;
	private BigDecimal nationality;
	private String gender;
	private String mobileNo;
	private Date dob;
	private String email;
	private Date effectiveDate;
	private Date endDate;
	private String status;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	
	private BigDecimal CountryID;
	private BigDecimal nomineeID;
	private BigDecimal customerID;
	private String DATE_FORMAT = "dd/MM/yyyy";
	//Customer detail List
	private List<Customer> customerDetail=null;
	private List<Nominee> nomineeList = new ArrayList<Nominee>();
	private List<NomineeBean> lstNomineeBean = new ArrayList<NomineeBean>();
	private Nominee selectedNominee;
	private NomineeBean nomineeBean = null;
	Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String, BussComponentConfDetail>();
	
	private Nominee nominee;
	private Customer customer;
	private BigDecimal nominatorId;
	
	/*This is responsible to set the list of Nominator Id from branch Bean*/
	@SuppressWarnings("unchecked")
	public void setNominatorId(BigDecimal nominatorIdFromBranch) {
		nominatorId = nominatorIdFromBranch;
		System.out.println("IN NOMINEE PAGE: "+nominatorId);
		nomineeList = getNomineeService().getNomineeList(nominatorIdFromBranch);
		
		for (Nominee beanElement: nomineeList) {
			nomineeBean = new NomineeBean(beanElement.getFsCustomerByNomineeCustId().getFirstName(), 
															new SimpleDateFormat(DATE_FORMAT).format(beanElement.getEffectiveDate()),
															new SimpleDateFormat(DATE_FORMAT).format(beanElement.getEndDate()),
															beanElement.getFsCustomerByNominatorCustId().getCustomerId(),
															beanElement.getFsCustomerByNomineeCustId().getCustomerId(),
															beanElement.getNomineeId());
			lstNomineeBean.add(nomineeBean);
		}
		System.out.println("Fetched  : "+lstNomineeBean.size());
		
	}
	
	/**
	 * @return the selectedNominee
	 */
	public Nominee getSelectedNominee() {
		return this.selectedNominee;
	}
	/**
	 * @param selectedNominee the selectedNominee to set
	 */
	public void setSelectedNominee(Nominee selectedNominee) {
		this.selectedNominee = selectedNominee;
	}
	/**
	 * @return the civilID
	 */
	public String getCivilID() {
		return this.civilID;
	}
	/**
	 * @param civilID the civilID to set
	 */
	public void setCivilID(String civilID) {
		this.civilID = civilID;
	}
	/**
	 * @return the tittle
	 */
	public String getTittle() {
		return this.tittle;
	}
	/**
	 * @param tittle the tittle to set
	 */
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return this.shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @return the nationality
	 */
	public BigDecimal getNationality() {
		return this.nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(BigDecimal nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return this.mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return this.dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return this.endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return this.updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return this.lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	/**
	 * @return the firstNameLocal
	 */
	public String getFirstNameLocal() {
		return this.firstNameLocal;
	}
	/**
	 * @param firstNameLocal the firstNameLocal to set
	 */
	public void setFirstNameLocal(String firstNameLocal) {
		this.firstNameLocal = firstNameLocal;
	}
	/**
	 * @return the middleNameLocal
	 */
	public String getMiddleNameLocal() {
		return this.middleNameLocal;
	}
	/**
	 * @param middleNameLocal the middleNameLocal to set
	 */
	public void setMiddleNameLocal(String middleNameLocal) {
		this.middleNameLocal = middleNameLocal;
	}
	/**
	 * @return the lastNameLocal
	 */
	public String getLastNameLocal() {
		return this.lastNameLocal;
	}
	/**
	 * @param lastNameLocal the lastNameLocal to set
	 */
	public void setLastNameLocal(String lastNameLocal) {
		this.lastNameLocal = lastNameLocal;
	}
	/**
	 * @return the shortNameLocal
	 */
	public String getShortNameLocal() {
		return this.shortNameLocal;
	}
	/**
	 * @param shortNameLocal the shortNameLocal to set
	 */
	public void setShortNameLocal(String shortNameLocal) {
		this.shortNameLocal = shortNameLocal;
	}
	
	/**
	 * @return the countryID
	 */
	public BigDecimal getCountryID() {
		return this.CountryID;
	}
	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(BigDecimal countryID) {
		this.CountryID = countryID;
	}
	
	/**
	 * @return the customerID
	 */
	public BigDecimal getCustomerID() {
		return this.customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(BigDecimal customerID) {
		this.customerID = customerID;
	}
	/**
	 * @return the customerDetail
	 */
	public List<Customer> getCustomerDetail() {
		return this.customerDetail;
	}
	/**
	 * @param customerDetail the customerDetail to set
	 */
	public void setCustomerDetail(List<Customer> customerDetail) {
		this.customerDetail = customerDetail;
	}
	
	public List<NomineeBean> getLstNomineeBean() {
		return lstNomineeBean;
	}
	
	/**
	 * Responsible to populate Country
	 * 
	 * @return
	 */
	public List<CountryMasterDesc> getCountryNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		@SuppressWarnings("unchecked")
		List<CountryMasterDesc> lstCountry = getGeneralService().getCountryList(new BigDecimal(sessionStateManage	.isExists("languageId") ? sessionStateManage
																																				.getSessionValue("languageId") : "" + 1));
		return lstCountry;
	}
	
	/**
	 * Get Customer information from CivilID
	 */
	@SuppressWarnings("unchecked")
	public void getCustomerDetails(AjaxBehaviorEvent event){
		customerDetail = getNomineeService().getNomineeDetail(getCivilID());
		if(customerDetail.size() > 0) {
				setCustomerID(customerDetail.get(0).getCustomerId());
				setFirstName(customerDetail.get(0).getFirstName());
				setFirstNameLocal(customerDetail.get(0).getFirstNameLocal());
				setNationality(customerDetail.get(0).getFsCountryMasterByCountryId().getCountryId());
			
			/*for(Customer customer:customerDetail){
			//setTittle(customerList.getTitle());
			//setLastName(customerList.getLastName());
			//setMiddleName(customerList.getMiddleName());
			//setShortName(customerList.getShortName());
			//setLastNameLocal(customerList.getShortNameLocal());
			//setMiddleNameLocal(customerList.getMiddleNameLocal());
			//setShortNameLocal(customerList.getShortNameLocal());
			//setGender(customerList.getGender());
			//setDob(customerList.getDateOfBirth());
			//setMobileNo(customerList.getMobile());
			//setEmail(customerList.getEmail());
		   //System.out.println("loop  :"+customerList.getTitle()+customerList.getFirstName()+customerList.getLastName());
		}*/
			
		}else{
			FacesContext.getCurrentInstance().addMessage("nomineeregistrationfrm:mainPanel", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ID is not Registered"));
		}
	}
	/**
	 * Get Nominee List
	 * 
	 */
	/*@SuppressWarnings("unchecked")
	public List<Nominee> getNomineeList(){
		return getNomineeService().getNomineeList(getCivilID());
	}*/
	
	
	public void saveNomineeDetail(){
		try{
			nominee = new Nominee();
			
			System.out.println("Nominator : "+nominatorId);
			System.out.println("Nomiee"+getCustomerID());
			
			nominee.setEffectiveDate(getEffectiveDate());
			nominee.setEndDate(getEndDate());
			
			customer = new Customer();
			customer.setCustomerId(getCustomerID());
			nominee.setFsCustomerByNomineeCustId(customer);
			
			customer = new Customer();
			customer.setCustomerId(nominatorId); 
			nominee.setFsCustomerByNominatorCustId(customer);
			
			nominee.setStatus("Y");
			
			getNomineeService().saveNomineeDetail(nominee);
			resetNominee();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("nomineeregistrationfrm:mainPanel", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Nominee ID And Nominator ID should not same"));
		}
		System.out.println("save end .");
		FacesContext.getCurrentInstance().addMessage("nomineeregistrationfrm:mainPanel", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Nominee Saved "));
		
	}
	/**
	 * Reset nominee
	 */
	
	public void resetNominee(){
		setCivilID("");
		//setTittle("");
		setFirstName("");
		setFirstNameLocal("");
		//setMiddleName("");
		//setMiddleNameLocal("");
		//setShortName("");
		//setShortNameLocal("");
		//setNationality(null);
		//setGender("");
		//setMobileNo("");
		//setDob(null);
		//setEmail("");
		setStatus("");
		setEffectiveDate(null);
		setEndDate(null);
		//setLastName("");
		//setLastNameLocal("");
	}
	
	public void deleteNominee(NomineeBean nominee){
		getNomineeService().deleteNominee(nominee);
		lstNomineeBean.remove(nominee);
	}
	
	/**
	 * cancelBranchDetail
	 * @return
	 */
	public void cancelNomineeDetail() {
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../login/nomineeregistration.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is responsible to supply, behavior of the component,calling
	 * from page
	 * 
	 * @param componentName
	 * @param type
	 * @return
	 */
	public String viewBehaviorBean(String componentName, String type) {

		if (mapComponentBehavior == null || mapComponentBehavior.size() == 0) {
			setPageIdIntoSession();
			prepareBehavior();
		}
		return new CollectionUtil().fetchBehavior(mapComponentBehavior,
				componentName, type);
	}

	/**
	 * This method is responsible to track the page name from viewId and then it
	 * will search in page master table, then from there ID will get, and store
	 * in session
	 */
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
			System.out.println("Page id not found for pagename :: " + pageName
					+ " :: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	private void prepareBehavior() {

		SessionStateManage manage = new SessionStateManage();
	//	System.out.println("Component parameter ======================= "+manage.getApplicationId()+", "+manage.getCompanyId()+", "+manage.getCompanyId()+", "+manage.getPageId());
		List<String> lstComponentName = Arrays.asList("Civil ID", "First Name", "Last Name",
				"Middle Name", "Short Name", "Local First Name", "Local Last Name", "Local Middle Name",
				"Local Short Name", "Nationality", "Mobile Number", "Fax", "Email","Gender",
				"Date of Birth", "Effective Date", "End Date");
		mapComponentBehavior = getGeneralService().getComponentBehavior(
				lstComponentName, manage.getLevel(), manage.getApplicationId(),
				manage.getCompanyId(), manage.getCountryId(),
				manage.getPageId());
		
		
	}
	
	


}
