package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BusinessComponent;
import com.amg.exchange.model.BusinessComponentConf;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CompanyMasterDesc;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.RuleApplicationMaster;
import com.amg.exchange.model.RulePageMaster;
import com.amg.exchange.service.IBusinessComponentConfService;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.util.SessionStateManage;

@Component("businesscomponentconf")
@Scope("session")
public class BusinessComponentConfBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO : Variables and object declaration

	private String businessComponentName;
	private BigDecimal businessComponentTypeId;
	private boolean globalgridstatus;
	private String globalmessage;  
	private String isMultiple;
	private int minValue;
	private int maxValue;
	private String isNumeric;
	private String isAlphabet;
	private String isSpecial;
	private String isRequired;
	private String isReadOnly;
	private String isEnable;
	private String componentComboData;
	private boolean isMultipleStatus;
	private String combComponentErrMsg;
	private boolean bcdatagridStatus;
	private String createdBy;
	private BusinessComponent businessComponent;
	private BusinessComponentConf businessComponentConf;
	private BussComponentConfDetail bussComponentConfDetail;
	private BussComponentComboData bussComponentComboData;
	private Date currentTime;
	private List<BusnessComponentCompBean> lstCompData = new ArrayList<BusnessComponentCompBean>();
	
	private BigDecimal componentId;
	private BigDecimal applicationId;
	private BigDecimal companyId;
	private BigDecimal countryId;
	private BigDecimal pageId;
	
	private List<BusinessComponent> lstComponent = new ArrayList<BusinessComponent>();
	private List<RuleApplicationMaster> lstApplication = new ArrayList<RuleApplicationMaster>();
	private List<CompanyMasterDesc> lstCompany= new ArrayList<CompanyMasterDesc>();
	private List<CountryMasterDesc> lstCountry = new ArrayList<CountryMasterDesc>();
	private List<RulePageMaster> lstPage = new ArrayList<RulePageMaster>();
	private DualListModel<String> dualCompData = new DualListModel<String>();
	private Map<String,BusnessComponentCompBean> mapCompData = new HashMap<String,BusnessComponentCompBean>();
	private Map<String,BusnessComponentCompBean> mapDefaultCompData = new HashMap<String,BusnessComponentCompBean>();
	private List<String> lstDefaultCompData = new ArrayList<String>();

	//TODO : Auto wired service declaration
	@Autowired
	IBusinessComponentConfService<T> businessComponentConfService;

	@Autowired
	IGeneralService<T> generalService;

	
	//TODO : Getter And Setter Methods
	
	public String getBusinessComponentName() {
		return businessComponentName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Map<String, BusnessComponentCompBean> getMapCompData() {
		return mapCompData;
	}

	public void setMapCompData(Map<String, BusnessComponentCompBean> mapCompData) {
		this.mapCompData = mapCompData;
	}

	public Map<String, BusnessComponentCompBean> getMapDefaultCompData() {
		return mapDefaultCompData;
	}

	public void setMapDefaultCompData(
			Map<String, BusnessComponentCompBean> mapDefaultCompData) {
		this.mapDefaultCompData = mapDefaultCompData;
	}

	public List<String> getLstDefaultCompData() {
		return lstDefaultCompData;
	}

	public void setLstDefaultCompData(List<String> lstDefaultCompData) {
		this.lstDefaultCompData = lstDefaultCompData;
	}

	public BusinessComponent getBusinessComponent() {
		return businessComponent;
	}

	public void setBusinessComponent(BusinessComponent businessComponent) {
		this.businessComponent = businessComponent;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public boolean getBcdatagridStatus() {
		return bcdatagridStatus;
	}

	public void setBcdatagridStatus(boolean bcdatagridStatus) {
		this.bcdatagridStatus = bcdatagridStatus;
	}

	public String getCombComponentErrMsg() {
		return combComponentErrMsg;
	}

	public void setCombComponentErrMsg(String combComponentErrMsg) {
		this.combComponentErrMsg = combComponentErrMsg;
	}

	public String getComponentComboData() {
		return componentComboData;
	}

	public void setComponentComboData(String componentComboData) {
		this.componentComboData = componentComboData;
	}

	public boolean isMultipleStatus() {
		return isMultipleStatus;
	}

	public void setMultipleStatus(boolean isMultipleStatus) {
		this.isMultipleStatus = isMultipleStatus;
	}

	public List<BusnessComponentCompBean> getLstCompData() {
		return lstCompData;
	}

	public void setLstCompData(List<BusnessComponentCompBean> lstCompData) {
		this.lstCompData = lstCompData;
	}

	public String getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(String isMultiple) {
		this.isMultiple = isMultiple;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public String getIsNumeric() {
		return isNumeric;
	}

	public void setIsNumeric(String isNumeric) {
		this.isNumeric = isNumeric;
	}

	public String getIsAlphabet() {
		return isAlphabet;
	}

	public void setIsAlphabet(String isAlphabet) {
		this.isAlphabet = isAlphabet;
	}

	public String getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(String isSpecial) {
		this.isSpecial = isSpecial;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public void setBusinessComponentName(String businessComponentName) {
		this.businessComponentName = businessComponentName;
	}

	public BigDecimal getBusinessComponentTypeId() {
		return businessComponentTypeId;
	}

	public void setBusinessComponentTypeId(BigDecimal businessComponentTypeId) {
		this.businessComponentTypeId = businessComponentTypeId;
	}

	public boolean isGlobalgridstatus() {
		return globalgridstatus;
	}

	public void setGlobalgridstatus(boolean globalgridstatus) {
		this.globalgridstatus = globalgridstatus;
	}

	public String getGlobalmessage() {
		return globalmessage;
	}

	public void setGlobalmessage(String globalmessage) {
		this.globalmessage = globalmessage;
	}

	public IBusinessComponentConfService<T> getBusinessComponentConfService() {
		return businessComponentConfService;
	}

	public void setBusinessComponentConfService(
			IBusinessComponentConfService<T> businessComponentConfService) {
		this.businessComponentConfService = businessComponentConfService;
	}

	public BusinessComponentConf getBusinessComponentConf() {
		return businessComponentConf;
	}

	public void setBusinessComponentConf(BusinessComponentConf businessComponentConf) {
		this.businessComponentConf = businessComponentConf;
	}

	public BussComponentConfDetail getBussComponentConfDetail() {
		return bussComponentConfDetail;
	}

	public void setBussComponentConfDetail(
			BussComponentConfDetail bussComponentConfDetail) {
		this.bussComponentConfDetail = bussComponentConfDetail;
	}

	public BussComponentComboData getBussComponentComboData() {
		return bussComponentComboData;
	}

	public void setBussComponentComboData(
			BussComponentComboData bussComponentComboData) {
		this.bussComponentComboData = bussComponentComboData;
	}

	public BigDecimal getComponentId() {
		return componentId;
	}

	public void setComponentId(BigDecimal componentId) {
		this.componentId = componentId;
	}

	public BigDecimal getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(BigDecimal applicationId) {
		this.applicationId = applicationId;
	}

	public BigDecimal getCompanyId() {
		return companyId;
	}

	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}

	public BigDecimal getPageId() {
		return pageId;
	}

	public void setPageId(BigDecimal pageId) {
		this.pageId = pageId;
	}

	public List<BusinessComponent> getLstComponent() {
		return lstComponent;
	}

	public void setLstComponent(List<BusinessComponent> lstComponent) {
		this.lstComponent = lstComponent;
	}

	public List<RuleApplicationMaster> getLstApplication() {
		return lstApplication;
	}

	public void setLstApplication(List<RuleApplicationMaster> lstApplication) {
		this.lstApplication = lstApplication;
	}

	public List<CompanyMasterDesc> getLstCompany() {
		return lstCompany;
	}

	public void setLstCompany(List<CompanyMasterDesc> lstCompany) {
		this.lstCompany = lstCompany;
	}

	public List<CountryMasterDesc> getLstCountry() {
		return lstCountry;
	}

	public DualListModel<String> getDualCompData() {
		return dualCompData;
	}

	public void setDualCompData(DualListModel<String> dualCompData) {
		this.dualCompData = dualCompData;
	}

	public void setLstCountry(List<CountryMasterDesc> lstCountry) {
		this.lstCountry = lstCountry;
	}

	public List<RulePageMaster> getLstPage() {
		return lstPage;
	}

	public void setLstPage(List<RulePageMaster> lstPage) {
		this.lstPage = lstPage;
	}

	public IGeneralService<T> getGeneralService() {
		return generalService;
	}

	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}

	//TODO : Bean Methods
	
	//Get All Business component list
	public List<BusinessComponent> getAllBusinessComponent(){
		
		setLstComponent(getGeneralService().getAllComponentList());
		return getLstComponent();
	}

	//Get All Application list
	public List<RuleApplicationMaster> getAllApplicationList(){
		
		setLstApplication(getGeneralService().getAllApplicationList());
		return getLstApplication();
	}

	//Get All Company list
	public List<CompanyMasterDesc> getAllCompanyList(){
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		setLstCompany(getGeneralService().getAllCompanyList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1")));
		return getLstCompany();
	}

	//Get All Country list
	public List<CountryMasterDesc> getAllCountryList(){
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		setLstCountry(getGeneralService().getCountryList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1")));
		return getLstCountry();
	}
	
	//Get All Page list
	public List<RulePageMaster> getAllPageList(){
		
		setLstPage(getGeneralService().getAllPageList());
		return getLstPage();
	}
	
	//Load default drop down list for selected component
	private void loadDefaultDropDownList(){
	
		//Reset collection objects
		List<BussComponentComboData> lstBussComponentComboData = null;
		mapDefaultCompData = new HashMap<String, BusnessComponentCompBean>();
		lstDefaultCompData = new ArrayList<String>();
		BusnessComponentCompBean busnessComponentCompBean = new BusnessComponentCompBean();
		
		//Load default drop down list
		try{
			//Fetch drop down from business component combo data by component configuration id
			lstBussComponentComboData = getBusinessComponentConfService().getBusinessComponentDropDownData(getBusinessComponentConfService().getBusinessComponent(getComponentId()).getFsBusinessComponentConf().getComponentConfId());
			for(BussComponentComboData bean:lstBussComponentComboData){
				busnessComponentCompBean = new BusnessComponentCompBean();
				busnessComponentCompBean.setBussComponentComboDataId(bean.getComponentComboDataId());
				busnessComponentCompBean.setComponentData(bean.getComponentData());
				busnessComponentCompBean.setComponentid(bean.getComponentComboDataId().toString());
				busnessComponentCompBean.setCreatedBy(bean.getCreatedBy());
				busnessComponentCompBean.setCreatedTime(bean.getCreatedTime());
				
				lstDefaultCompData.add(bean.getComponentData());
				mapDefaultCompData.put(bean.getComponentData(), busnessComponentCompBean);
			}
		}catch(Exception e){}
	}
	
	//Fetch business component detail by component name which is entered by user (For Modification purpose)
	public void getBusinessComponentDetail(){
		
		//Check if it is exist or not
		boolean isAvailable = false;
		BussComponentConfDetail bussComponentConfDetail = new BussComponentConfDetail();
		try{
			//Component behavior available by selection
			bussComponentConfDetail = getBusinessComponentConfService().getBusinessComponent(getComponentId(), getApplicationId(), getCompanyId(), getCountryId(), getPageId());
			isAvailable = true;
		}catch(Exception e){
			try{
				//Component default behavior availability 
				bussComponentConfDetail = getBusinessComponentConfService().getBusinessComponent(getComponentId());
				isAvailable = true;
			}catch(Exception e1){
				e1.printStackTrace();
				isAvailable = false;
			}
		}
		
		//If data is available then
		if(isAvailable){
			
			//Set Business Component Data
			setBusinessComponent(bussComponentConfDetail.getFsBusinessComponentConf().getFsBusinessComponent());
			setBusinessComponentTypeId(getBusinessComponent().getFsComponentType().getComponentTypeId());
			setIsMultiple(getBusinessComponent().getIsMultiple());
			
			//Set Business Component conf detail
			setIsNumeric(bussComponentConfDetail.getIsNumeric());
			setIsAlphabet(bussComponentConfDetail.getIsAlphabet());
			setIsSpecial(bussComponentConfDetail.getIsSpecial());
			setIsRequired(bussComponentConfDetail.getIsRequired());
			setIsReadOnly(bussComponentConfDetail.getIsReadOnly());
			setIsEnable(bussComponentConfDetail.getIsEnable());
			setMinValue(bussComponentConfDetail.getMinValue().intValue());
			setMaxValue(bussComponentConfDetail.getMaxValue().intValue());
			
			//Assign fetched object into bean object
			this.businessComponentConf = bussComponentConfDetail.getFsBusinessComponentConf();
			this.bussComponentConfDetail = bussComponentConfDetail;
		}else{
			
			//If data not exist set all model object as null
			setBusinessComponent(null);
			this.businessComponentConf = null;
			this.bussComponentConfDetail = null;
		}
		
		//Check drop down data list 
		if(isAvailable && getIsMultiple().equalsIgnoreCase("Y")){
			loadDefaultDropDownList();
			List<BussComponentComboData> lstBussComponentComboData = null;
			try{
				//Fetch drop down list by business component conf id
				lstBussComponentComboData = getBusinessComponentConfService().getBusinessComponentDropDownData(bussComponentConfDetail.getFsBusinessComponentConf().getComponentConfId());
				if(lstBussComponentComboData.size()>0){
					
					setBcdatagridStatus(true);
					setComponentComboData("");
					setCombComponentErrMsg("");
					lstCompData.clear();
					dualCompData.setSource(null);
					dualCompData.setTarget(null);
					List<String> tempList = new ArrayList<String>();
					//Append fetched values into BusnessComponentCompBean for prepare data table
					BusnessComponentCompBean busnessComponentCompBean;
					for(BussComponentComboData bussComponentComboData : lstBussComponentComboData){
						busnessComponentCompBean = new BusnessComponentCompBean(new BigDecimal(lstCompData.size()+1),bussComponentComboData.getComponentComboDataId(),bussComponentComboData.getComponentData());
						busnessComponentCompBean.setCreatedBy(bussComponentComboData.getCreatedBy());
						busnessComponentCompBean.setCreatedTime(bussComponentComboData.getCreatedTime());
						busnessComponentCompBean.setComponentid(busnessComponentCompBean.getBussComponentComboDataId().toPlainString());
						lstCompData.add(busnessComponentCompBean);
						mapCompData.put(busnessComponentCompBean.getComponentData(), busnessComponentCompBean);
						tempList.add(busnessComponentCompBean.getComponentData());
					}
					List<String> srcList = new ArrayList<String>();
					srcList.addAll(lstDefaultCompData);
					srcList.removeAll(tempList);
					dualCompData = new DualListModel<String>(srcList, tempList);
				}
			}catch(Exception e){}
		}else{
			
			//If drop down not exist reset displayed value
			setBcdatagridStatus(false);
			setComponentComboData("");
			setCombComponentErrMsg("");
			lstCompData.clear(); 
			dualCompData.setSource(null);
			dualCompData.setTarget(null);
			mapDefaultCompData = new HashMap<String, BusnessComponentCompBean>();
			lstDefaultCompData = new ArrayList<String>();
			dualCompData = new DualListModel<String>(new ArrayList<String>(), new ArrayList<String>());
		}
	}
	
	
	//Drop down component list visibility control
	public void showComponentData(){
		
		lstCompData.clear();
		setComponentComboData("");
		setCombComponentErrMsg("");
		if(getIsMultiple().equals("Y")){
			setBcdatagridStatus(true);
		}else{
			setBcdatagridStatus(false);
		}
	}
	
	//Save or update 
	public void saveData(){
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		//Fetch user name from session 
		if(sessionStateManage.isExists("username")){
			setCreatedBy(sessionStateManage.getSessionValue("username"));
		}else{
			setCreatedBy("ROOT");
		}
		
		if(getComponentId()==null){
			FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select Component", ""));
			
		}else if(getApplicationId()==null && getCompanyId()==null && getCountryId()==null && getPageId()==null){
			FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select Application/Company/Country/Page", ""));
		}else{
			
		}
		
		//Prepare current time
		setCurrentTime(new Date());
		
		//Save business component configuration
		saveComponentConf();
		
		//Save business component configuration detail
		saveComponentConfDetail();
		
		//Is multiple value then store data table data into component combo detail
		if(getIsMultiple().equalsIgnoreCase("Y")){
			saveComponentComboDetail();
		}
		
	}
	
	//Save or update component conf information
	@SuppressWarnings("unchecked")
	private void saveComponentConf(){
		
		//Check data exist or not in configuration table
		boolean isExists = true;
		
		try{
			bussComponentConfDetail = getBusinessComponentConfService().getBusinessComponent(getComponentId(), getApplicationId(), getCompanyId(), getCountryId(), getPageId());
			businessComponentConf = bussComponentConfDetail.getFsBusinessComponentConf();
			businessComponent = businessComponentConf.getFsBusinessComponent();
			isExists = true;
		}catch(Exception e){
			businessComponentConf = new BusinessComponentConf();
			bussComponentConfDetail = null;
			isExists = false;
		}
		businessComponentConf.setFsBusinessComponent(businessComponent);
		if(getApplicationId()!=null && getApplicationId().intValue()!=0){
			RuleApplicationMaster ruleApplicationMaster = new RuleApplicationMaster();
			ruleApplicationMaster.setApplicationId(getApplicationId());
			businessComponentConf.setFsRuleApplicationMaster(ruleApplicationMaster);
		}else{
			businessComponentConf.setFsRuleApplicationMaster(null);
		}
		if(getCompanyId()!=null && getCompanyId().intValue()!=0){
			CompanyMaster companyMaster = new CompanyMaster();
			companyMaster.setCompanyId(getCompanyId());
			businessComponentConf.setFsCompanyMaster(companyMaster);
		}else{
			businessComponentConf.setFsCompanyMaster(null);
		}
		if(getCountryId()!=null && getCountryId().intValue()!=0){
			CountryMaster countryMaster = new CountryMaster();
			countryMaster.setCountryId(getCountryId());
			businessComponentConf.setFsCountryMaster(countryMaster);
		}else{
			businessComponentConf.setFsCountryMaster(null);
		}
		if(getPageId()!=null && getPageId().intValue()!=0){
			RulePageMaster rulePageMaster = new RulePageMaster();
			rulePageMaster.setPageId(getPageId());
			businessComponentConf.setFsRulePageMaster(rulePageMaster);
		}else{
			businessComponentConf.setFsRulePageMaster(null);
		}
		businessComponentConf.setLevelId(prepareLevelId());
		
		//If it is update not required
		if(!isExists){
			businessComponentConf.setCreatedBy(getCreatedBy());
			businessComponentConf.setCreatedTime(getCurrentTime());
		}
		businessComponentConf.setUpdatedBy(getCreatedBy());
		businessComponentConf.setUpdatedTime(getCurrentTime());
	
		
		getBusinessComponentConfService().saveOrUpdate((T)businessComponentConf);
	}
	
	//Prepare level id
	private BigDecimal prepareLevelId(){
		BigDecimal ret = null;
		StringBuffer sbf = new StringBuffer();
		sbf.append(getApplicationId()==null || getApplicationId().intValue()==0 ?0:1);
		sbf.append(getCompanyId()==null || getCompanyId().intValue()==0 ?0:1);
		sbf.append(getCountryId()==null || getCountryId().intValue()==0 ?0:1);
		sbf.append(getPageId()==null || getPageId().intValue()==0 ?0:1);
		ret = new BigDecimal(Integer.parseInt(sbf.toString(), 2));
		return ret;
	}
	
	//Save or update component conf detail info
	@SuppressWarnings("unchecked")
	private void saveComponentConfDetail(){
		
		//Check data exists
		boolean isExists = true;
		if(bussComponentConfDetail==null){
			bussComponentConfDetail = new BussComponentConfDetail();
			isExists = false;
		}
		bussComponentConfDetail.setFsBusinessComponentConf(businessComponentConf);
		bussComponentConfDetail.setIsNumeric(getIsNumeric());
		bussComponentConfDetail.setIsAlphabet(getIsAlphabet());
		bussComponentConfDetail.setIsSpecial(getIsSpecial());
		bussComponentConfDetail.setIsRequired(getIsRequired());
		bussComponentConfDetail.setIsReadOnly(getIsReadOnly());
		bussComponentConfDetail.setIsEnable(getIsEnable());
		bussComponentConfDetail.setMinValue(new BigDecimal(getMinValue()));
		bussComponentConfDetail.setMaxValue(new BigDecimal(getMaxValue()));
		
		bussComponentConfDetail.setIsActive("Y");
		
		//If it is update not required
		if(!isExists){
			bussComponentConfDetail.setCreatedBy(getCreatedBy());
			bussComponentConfDetail.setCreatedTime(getCurrentTime());
		}
		bussComponentConfDetail.setUpdatedBy(getCreatedBy());
		bussComponentConfDetail.setUpdatedTime(getCurrentTime());
		
		getBusinessComponentConfService().saveOrUpdate((T)bussComponentConfDetail);
	}
	
	//Save or update drop down list
	@SuppressWarnings("unchecked")
	private void saveComponentComboDetail(){
		
		//get data from BusnessComponentCompBean (Data table bean) and set to Business component combo data model
		
		Map<String,BussComponentComboData> mapFinalList = new HashMap<String, BussComponentComboData>();
		
		List<String> target = dualCompData.getTarget();
		try{
			for(BussComponentComboData bean:getBusinessComponentConfService().getBusinessComponentDropDownData(businessComponentConf.getComponentConfId())){
				mapFinalList.put(bean.getComponentData(), bean);
			}
		}catch(Exception e){}
		
		for(String strTarget:target){
			
			if(mapFinalList.containsKey(strTarget)){
				bussComponentComboData = mapFinalList.get(strTarget);
				bussComponentComboData.setComponentData(strTarget);
			}else{
				bussComponentComboData = new BussComponentComboData();
				bussComponentComboData.setComponentData(strTarget);
				bussComponentComboData.setFsBusinessComponentConf(businessComponentConf);
				bussComponentComboData.setCreatedBy(getCreatedBy());
				bussComponentComboData.setCreatedTime(getCurrentTime());
			}
			bussComponentComboData.setUpdatedBy(getCreatedBy());
			bussComponentComboData.setUpdatedTime(getCurrentTime());
			
			getBusinessComponentConfService().saveOrUpdate((T)bussComponentComboData);
			
			if(mapFinalList.containsKey(strTarget)){
				mapFinalList.remove(strTarget);
			}
		}
		for(String key:mapFinalList.keySet()){
			
			getBusinessComponentConfService().delete((T)mapFinalList.get(key));
		}
	}
	
}
