package com.amg.exchange.treasury.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;























import com.amg.exchange.model.BankApplicability;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CompanyMasterDesc;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.treasury.service.IBankApplicabilityService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;
import com.amg.exchange.util.iCypherSecurity;
import com.amg.exchange.util.impl.CypherSecurityImpl;
@Component(value ="bankApplicabilityManagedBean")
@Scope("session")
public class BankApplicabilityManagedBean<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3943860350339577651L;
	
	//TODO 
	private BigDecimal countryId;
	private String timeZone;
	private BigDecimal companyId;
	private BigDecimal bankId;
	private BigDecimal bankBranchId;
	private String exchangeId;
	private String bankTypeId;
	private String userName;
	private String password;
	private String agentId;
	private String agentPin;
	private BigDecimal bankApplicabilityId;
	private List<BankMaster> bankMasterList;
	
	private CountryMaster  countryMaster  = null;
	private CompanyMaster  companyMaster  = null;
	private BankMaster  bankMaster = null;
	private boolean renderWebCredentials = false;
	private boolean renderFirst = true;
	
	 Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String,BussComponentConfDetail>();
	 Map<BigDecimal, String> mapBankType = new LinkedHashMap<BigDecimal, String>();
	 
	public BigDecimal getBankBranchId() {
		return bankBranchId;
	}
	public void setBankBranchId(BigDecimal bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	//TODO
	@Autowired
	IGeneralService<T> generalService;
	@Autowired
	IBankApplicabilityService<T> bankApplicabilityService;
	
    
	public boolean isRenderWebCredentials() {
		return renderWebCredentials;
	}
	public void setRenderWebCredentials(boolean renderWebCredentials) {
		this.renderWebCredentials = renderWebCredentials;
	}
	public boolean isRenderFirst() {
		return renderFirst;
	}
	public void setRenderFirst(boolean renderFirst) {
		this.renderFirst = renderFirst;
	}
	public BigDecimal getBankApplicabilityId() {
		return bankApplicabilityId;
	}
	public void setBankApplicabilityId(BigDecimal bankApplicabilityId) {
		this.bankApplicabilityId = bankApplicabilityId;
	}
	public IBankApplicabilityService<T> getBankApplicabilityService() {
		return bankApplicabilityService;
	}
	public void setBankApplicabilityService(
			IBankApplicabilityService<T> bankApplicabilityService) {
		this.bankApplicabilityService = bankApplicabilityService;
	}
	public BigDecimal getCompanyId() {
		return companyId;
	}
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}
	public BigDecimal getBankId() {
		return bankId;
	}
	public void setBankId(BigDecimal bankId) {
		this.bankId = bankId;
	}
	public IGeneralService<T> getGeneralService() {
		return generalService;
	}
	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}
	public BigDecimal getCountryId() {
		return countryId;
	}
	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
	public String getBankTypeId() {
		return bankTypeId;
	}
	public void setBankTypeId(String bankTypeId) {
		this.bankTypeId = bankTypeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentPin() {
		return agentPin;
	}
	public void setAgentPin(String agentType) {
		this.agentPin = agentType;
	}
	
	SessionStateManage sessionStateManage = new SessionStateManage();
	//TODO
	/**
	 * method is responsible to populate List of countries from DB 
	 * @return
	 */
	public List<CountryMasterDesc> getCountryListFromDB() {
 		return getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));
	}
	/**
	 *  method is responsible to populate List of companies from DB 
	 * @return
	 */
	public List<CompanyMasterDesc> getCompanyListFromDB() {
		
		return getGeneralService().getAllCompanyList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));
	}
	/**
	 *  method is responsible to populate List of companies from DB 
	 * @return
	 */
	public void popBank(AjaxBehaviorEvent e) {
		bankMasterList = new ArrayList<BankMaster>();
		bankMasterList.addAll(getGeneralService().getAllBankList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId()));
	}
	
	public List<BankMaster> getBankListFromDB() {
		return bankMasterList;
	}
	/**
	 *  method is responsible to populate List of companies from DB 
	 * @return
	 */
	/*public List<BussComponentComboData> getBankTypeListFromDB() {
		
		return getGeneralService().getAllBankTypeList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));

	}*/
	/**
	 * method is responsible to save the Bank Applicability Details in db
	 * @return
	 */
	//@SuppressWarnings("rawtypes")
	public String saveBankApplicabilityDetails() {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::");
		try {
			System.out.println("the country id is"+getCountryId());
			System.out.println("the company id is"+getCompanyId());
			System.out.println("the bank id is"+getBankId());
		BankApplicability  bankApplicability  = new BankApplicability();
		companyMaster = new CompanyMaster();
		countryMaster = new CountryMaster();
		bankMaster = new BankMaster();
		String secretKey = getUserName();
		String secretKey1 = getAgentId();
		iCypherSecurity cypherSecurity = new CypherSecurityImpl();
		countryMaster.setCountryId(getCountryId());
		companyMaster.setCompanyId(getCompanyId());
		bankMaster.setBankId(getBankId());
		bankApplicability.setFsCountryMaster(countryMaster);
		bankApplicability.setFsCompanyMaster(companyMaster);
		bankApplicability.setExBankMaster(bankMaster);
		bankApplicability.setTimezone(new BigDecimal(getTimeZone()));
		bankApplicability.setExchangeId(getExchangeId());
		bankApplicability.setBankInd(new BigDecimal(12));
		bankApplicability.setWebsrvUsername(getUserName());
		bankApplicability.setWebsrvPassword(cypherSecurity.encodePassword(getPassword(), secretKey));
		bankApplicability.setWebsrvAgntId(getAgentId());
		bankApplicability.setWebsrvAgntPin(cypherSecurity.encodePassword(getAgentId(), secretKey1));
		bankApplicability.setCreateDate(new Date());
		bankApplicability.setCreator("hakeem");
		bankApplicability.setApplicabilityId(getBankApplicabilityId());
	//	bankApplicability.set
		getBankApplicabilityService().saveBankApplicabilityDetails(bankApplicability);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 
	 * method is responsible to clear the Bank Applicability Details from the screen
	 */
	public void clearBankApplicabilityDetails() {
		System.out.println("inside method cleare");
		setCountryId(null);
		setTimeZone(null);
		setCompanyId(null);
		setBankId(null);
		setExchangeId(null);
		setBankTypeId(null);
		setUserName(null);
		setPassword(null);
		setAgentId(null);
		setAgentPin(null);
		setRenderFirst(true);
		setRenderWebCredentials(false);
	}
	
	/**
	 * method is responsible to cancel the Bank Master
	 * @return
	 */
	public void cancelBankApplicabilityDetails() {
		System.out.println("inside cancel    ");
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../login/login.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * method is responsible to go next panel
	 * @return
	 */
	public void nextBankApplicabilityDetails() {
		System.out.println("the inside next=============================================================");
		setRenderWebCredentials(true);
		setRenderFirst(false);
	}
	/**
	 * method is responsible to go back next page
	 * @return
	 */
	public void backBankApplicabilityDetails() {
		System.out.println("the inside back==============================================================="); 
		setRenderWebCredentials(false);
		setRenderFirst(true);
		
	}
	 public String viewBehaviorBean(String componentName, String type){
	        if(mapComponentBehavior==null || mapComponentBehavior.size()==0){
				setPageIdIntoSession();
				prepareBehavior();
			}
	   		return new CollectionUtil().fetchBehavior(mapComponentBehavior, componentName, type);
	   	}
	   	
	   	@Autowired
	   	 public BankApplicabilityManagedBean(IGeneralService<T> generalService) {
	   		clearBankApplicabilityDetails();
	   		setGeneralService(generalService);
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
	   		String langId =  manage.getSessionValue("laguageId");
            
	   		List<String> lstComponentName = Arrays.asList("Country","Time Zone","Company","Banks","Bank Type","Exchange Id","User Name","Password","Agent Id","Agent Pin");
	   		 mapComponentBehavior =  getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(),manage.getApplicationId(),manage.getCompanyId(),manage.getCountryId(),manage.getPageId());
	   	    /* mapBankType.clear();
		     mapBankType = getGeneralService().getAllComponentComboData(
		     mapComponentBehavior.get("").getFsBusinessComponentConf().getComponentConfId() , new BigDecimal(langId));*/
	   		for(Map.Entry<String, BussComponentConfDetail> entry: mapComponentBehavior.entrySet()) {
	   			System.out.println("the key  is"+entry.getKey()+"the value is"+entry.getValue()+"is required"+entry.getValue().getIsRequired());
	   		}
	   }
		
	

}
