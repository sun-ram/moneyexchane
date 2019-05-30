package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.RuleApplicationDesc;
import com.amg.exchange.model.RuleApplicationMaster;
import com.amg.exchange.model.RuleComponent;
import com.amg.exchange.model.RulePageMaster;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.service.IRuleEngineService;
import com.amg.exchange.util.BooleanManager;

@Component("ruleEngineManageBean")
@Scope("session")
public class RuleEngineManageBean<T> implements Serializable { 
	
	private static final long serialVersionUID = 4279762450612376198L;
	private String countryCode;
	private String countryName;
	private String companyCode;
	private String companyName;
	private String applicationCode;
	private String applicationName;
	private String screenCode;
	private String screenName;
	private String componentCode;
	private String componentName;
	
	/**
	 * These boolean will decide wheather data need to save or update
	 */
	private Boolean applicationMasterSave = true;
	private Boolean applicationDescSave = true;
	private Boolean applicationPageSave = true;
	
	private Boolean ruleFirstPage = true;
	private Boolean ruleCompoDesc = true;
	
	private String sequrityQuestionOption;
	private String sequrityQuestion;
	
	private String country;
	private String company;
	private String applicationNameBusinessRule;
	private String documentsFor;
	private String documents;
	private String validity;
	private String maxTransac;
	private String minTransac;
	
	public String getMinTransac() {
		return minTransac;
	}

	public void setMinTransac(String minTransac) {
		this.minTransac = minTransac;
	}

	private String notification;
	private BooleanManager manager = new BooleanManager();

	@Autowired
	IRuleEngineService<T> ruleEngineService;
	public IRuleEngineService<T> getRuleEngineService() {
		return ruleEngineService;
	}

	public void setRuleEngineService(IRuleEngineService<T> ruleEngineService) {
		this.ruleEngineService = ruleEngineService;
	}
	
	@Autowired
	IGeneralService<T> iGenService;
	
	public IGeneralService<T> getiGenService() {
		return iGenService;
	}

	public void setiGenService(IGeneralService<T> iGenService) {
		this.iGenService = iGenService;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getScreenCode() {
		return screenCode;
	}
	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	public Boolean getRuleFirstPage() {
		return ruleFirstPage;
	}

	public void setRuleFirstPage(Boolean ruleFirstPage) {
		this.ruleFirstPage = ruleFirstPage;
	}
	
	public Boolean getRuleCompoDesc() {
		return ruleCompoDesc;
	}

	public void setRuleCompoDesc(Boolean ruleCompoDesc) {
		this.ruleCompoDesc = ruleCompoDesc;
	}
	
	public String getSequrityQuestionOption() {
		return sequrityQuestionOption;
	}

	public void setSequrityQuestionOption(String sequrityQuestionOption) {
		this.sequrityQuestionOption = sequrityQuestionOption;
	}

	public String getSequrityQuestion() {
		return sequrityQuestion;
	}

	public void setSequrityQuestion(String sequrityQuestion) {
		this.sequrityQuestion = sequrityQuestion;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getApplicationNameBusinessRule() {
		return applicationNameBusinessRule;
	}

	public void setApplicationNameBusinessRule(String applicationNameBusinessRule) {
		this.applicationNameBusinessRule = applicationNameBusinessRule;
	}

	public String getDocumentsFor() {
		return documentsFor;
	}

	public void setDocumentsFor(String documentsFor) {
		this.documentsFor = documentsFor;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getMaxTransac() {
		return maxTransac;
	}

	public void setMaxTransac(String maxTransac) {
		this.maxTransac = maxTransac;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	public Boolean getApplicationMasterSave() {
		return applicationMasterSave;
	}

	public void setApplicationMasterSave(Boolean applicationMasterSave) {
		this.applicationMasterSave = applicationMasterSave;
	}

	public Boolean getApplicationDescSave() {
		return applicationDescSave;
	}

	public void setApplicationDescSave(Boolean applicationDescSave) {
		this.applicationDescSave = applicationDescSave;
	}

	public Boolean getApplicationPageSave() {
		return applicationPageSave;
	}

	public void setApplicationPageSave(Boolean applicationPageSave) {
		this.applicationPageSave = applicationPageSave;
	}
	private List<AddRowsInComponent> lstTable = new ArrayList<AddRowsInComponent>();
	public List<AddRowsInComponent> getLstTable() {
		return lstTable;
	}
	
	private List<AddCompoDesc> lstRuleCompoDesc = new ArrayList<AddCompoDesc>();
	public List<AddCompoDesc> getLstRuleCompoDesc() {
		return lstRuleCompoDesc;
	}
	
	public void addIdProofData() {
		AddRowsInComponent createComponentTable = new AddRowsInComponent(getCompanyCode(), getApplicationName(), getScreenName(), getComponentCode(), getComponentName());
		lstTable.add(createComponentTable);
	}
	
	private List<CountryMasterDesc> lstCountry;
	List<CountryBean> countrybean = new ArrayList<CountryBean>();
	public List<CountryBean> getCountryFromDB() {
		
		int languageID = 1;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("languageCode")){
			languageID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("languageCode").toString().equalsIgnoreCase("ar")?2:1;
		}
		
		countrybean.clear();
		lstCountry = new ArrayList<CountryMasterDesc>();
		lstCountry.addAll(getiGenService().getCountryList(new BigDecimal(languageID)));
		
		for(CountryMasterDesc country: lstCountry) {
				countrybean.add( new CountryBean(country.getCountryMasterId(), country.getCountryName()));
		}
		
		/**
		 * This section is to populate all saved component, we can change from that, and we can change also condition 
		 */
		List<RuleComponent> componentDesc = new ArrayList<RuleComponent>();
		componentDesc.addAll(getRuleEngineService().getComponentname());
		
		lstRuleCompoDesc.clear();
		if(componentDesc.size() == 0){
			for (AddRowsInComponent element : lstTable) {
					AddCompoDesc compoDesc = new AddCompoDesc(element.getCOMPONENT_NAME(), "", "",
													"", "", "", element.getCOMPONENT_CODE());
					lstRuleCompoDesc.add(compoDesc);
			}
		} else {
			for(RuleComponent compo: componentDesc){
				
				/**
				 * This is needed, because, first time all will null, then at the time of type casting it will throw exception
				 */
				String minValue = null;
				String maxValue = null;
				String mandatory = null;
				String isNumeric = null;
				String visibility = null;
				
				try{
					minValue = compo.getMinValue().toPlainString(); 
				} catch(Exception e){
					minValue = "";
				}
				
				try{
					maxValue = compo.getMaxValue().toPlainString(); 
				} catch(Exception e){
					maxValue = "";
				}
				
				try{
					mandatory = manager.reverseBooleanMaker(compo.getMandatory()); 
				} catch(Exception e){
					mandatory = "";
				}
				
				try{
					isNumeric = manager.reverseBooleanMaker(compo.getIsnumberic()); 
				} catch(Exception e){
					isNumeric = "";
				}
				
				try{
					visibility = manager.reverseBooleanMaker(compo.getVisibility()); 
				} catch(Exception e){
					visibility = "";
				}
				
				AddCompoDesc compoDesc = new AddCompoDesc(compo.getComponentName(), minValue, maxValue,
						mandatory, isNumeric,	visibility, compo.getComponentCode());
				lstRuleCompoDesc.add(compoDesc);
			}
		}
		return countrybean;
	}
	
	public List<RulePageMaster> lstSavedApplication;
	public List<RulePageMaster> getScreenForRule() {
		lstSavedApplication = new ArrayList<RulePageMaster>();
		lstSavedApplication.addAll(getRuleEngineService().getSavedApplication());
		return lstSavedApplication;
	}
	
	RuleApplicationMaster ruleApplicationMaster = null;
	RuleApplicationDesc ruleApplicationDesc = null;
	RulePageMaster rulepagemaster = null;
	RuleComponent ruleComponent = null;
	CountryMaster countryMaster= null;
	CompanyMaster companyMaster = null;
	
	@SuppressWarnings("unchecked")
	public void saveComponentInfo() {
		
		countryMaster= new CountryMaster();
		countryMaster.setCountryId(new BigDecimal(getCountryCode()));
		
		companyMaster = new CompanyMaster();
		companyMaster.setCompanyId(new BigDecimal(getCompanyCode()));
		
		try{
			ruleApplicationMaster = getRuleEngineService().getRuleApplicationMaster(getApplicationCode()).get(0);
			setApplicationMasterSave(false);
		}catch(Exception e) {
			ruleApplicationMaster = new RuleApplicationMaster();
		    ruleApplicationMaster.setApplicationCode(getApplicationCode());
		    ruleApplicationMaster.setApplicationName(getApplicationName());
		    setApplicationMasterSave(true);
		}
		if(getApplicationMasterSave()){
		   	getRuleEngineService().save((T) ruleApplicationMaster);
		}
		
		String application_id = ruleApplicationMaster.getApplicationId().toPlainString();
		
		List<RuleApplicationDesc> lstData =  getRuleEngineService().getRuleApplicationMasterDesc();
		for (RuleApplicationDesc ruleApplicationDesc : lstData) {
			if(ruleApplicationDesc.getFsRuleApplicationMaster().getApplicationId().toPlainString().equalsIgnoreCase(application_id) &&
					ruleApplicationDesc.getFsCountryMaster().getCountryId().toString().equalsIgnoreCase(getCountryCode()) &&
					ruleApplicationDesc.getFsCompanyMaster().getCompanyId().toPlainString().equalsIgnoreCase(getCompanyCode())){
			
				setRuleCompoDesc(false);
				break;
			}	
		}
		
		if(getRuleCompoDesc()) {
			ruleApplicationDesc = new RuleApplicationDesc();
		    ruleApplicationDesc.setFsRuleApplicationMaster(ruleApplicationMaster);
		    ruleApplicationDesc.setFsCountryMaster(countryMaster);
		    ruleApplicationDesc.setFsCompanyMaster(companyMaster);
		    setRuleCompoDesc(true);
		}
		
		List<RulePageMaster> lstPageMaster = getRuleEngineService().getRuleApplicationPage(getScreenCode());
		for (RulePageMaster rulePageMaster : lstPageMaster) {
			if(rulePageMaster.getFsRuleApplicationMaster().getApplicationId().toPlainString().equalsIgnoreCase(application_id)){
				setApplicationPageSave(false);
				break;
			}
		}
		
		if(getApplicationPageSave()){
			rulepagemaster = new RulePageMaster();
		    rulepagemaster.setFsRuleApplicationMaster(ruleApplicationMaster);
		    rulepagemaster.setPageActive("1");
		    rulepagemaster.setPageName(getScreenName());
		    rulepagemaster.setPageCode(getScreenCode());
		    setApplicationPageSave(true);
		}
		
	    ruleComponent = new RuleComponent();
	    ruleComponent.setFsRuleApplicationMaster(ruleApplicationMaster);
	    ruleComponent.setFsRulePageMaster(rulepagemaster);
	    ruleComponent.setComponentCode(getComponentCode());
	    ruleComponent.setComponentName(getComponentName());
	    
	    if(getRuleCompoDesc()){
	    	getRuleEngineService().save((T) ruleApplicationDesc);
	    }
	    
	    if(getApplicationPageSave()){
	    	getRuleEngineService().save((T) rulepagemaster);
	    }
	    
	    getRuleEngineService().save((T) ruleComponent);
	    
	    setRuleFirstPage(false);
		setRuleCompoDesc(true);
		
		List<RuleComponent> componentDesc = new ArrayList<RuleComponent>();
		componentDesc.addAll(getRuleEngineService().getComponentname());
		lstRuleCompoDesc.clear();
		if(componentDesc.size() == 0){
			for (AddRowsInComponent element : lstTable) {
					AddCompoDesc compoDesc = new AddCompoDesc(element.getCOMPONENT_NAME(), "", "",
													"", "", "", element.getCOMPONENT_CODE());
					lstRuleCompoDesc.add(compoDesc);
			}
		} else {
			for(RuleComponent compo: componentDesc){
				
				/**
				 * This is needed, because, first time all will null, then at the time of type casting it will throw exception
				 */
				String minValue = null;
				String maxValue = null;
				String mandatory = null;
				String isNumeric = null;
				String visibility = null;
				
				try{
					minValue = compo.getMinValue().toPlainString(); 
				} catch(Exception e){
					minValue = "";
				}
				
				try{
					maxValue = compo.getMaxValue().toPlainString(); 
				} catch(Exception e){
					maxValue = "";
				}
				
				try{
					mandatory = manager.reverseBooleanMaker(compo.getMandatory()); 
				} catch(Exception e){
					mandatory = "";
				}
				
				try{
					isNumeric = manager.reverseBooleanMaker(compo.getIsnumberic()); 
				} catch(Exception e){
					isNumeric = "";
				}
				
				try{
					visibility = manager.reverseBooleanMaker(compo.getVisibility()); 
				} catch(Exception e){
					visibility = "";
				}
				
				AddCompoDesc compoDesc = new AddCompoDesc(compo.getComponentName(), minValue, maxValue,
						mandatory, isNumeric,	visibility, compo.getComponentCode());
				lstRuleCompoDesc.add(compoDesc);
			}
		}
	}
	
	public void saveComponentDescription() {
		for (AddCompoDesc element : lstRuleCompoDesc) {
			
			RuleComponent rulecomponentDesc =  getRuleEngineService().getComponentDesc(element.getComponentCode()).get(0);
		
			rulecomponentDesc.setMinValue(new BigDecimal(element.getMin()));
			rulecomponentDesc.setMaxValue(new BigDecimal(element.getMax()));
			rulecomponentDesc.setMandatory(manager.BooleanChecker(element.getMandatory()));
			rulecomponentDesc.setIsnumberic(manager.BooleanChecker(element.getNumeric()));
			rulecomponentDesc.setVisibility(manager.BooleanChecker(element.getVisible()));
			
			rulecomponentDesc.setCreatedBy("xxx");
			rulecomponentDesc.setCreatedDate(new Date());;
			
			getRuleEngineService().saveRuleComponentDesc(rulecomponentDesc);
		}
	}
}
