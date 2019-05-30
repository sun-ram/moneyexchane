package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BusinessComponent;
import com.amg.exchange.model.BusinessComponentConf;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.ComponentType;
import com.amg.exchange.service.IBusinessComponentService;
import com.amg.exchange.util.SessionStateManage;

@Component("businesscomponent")
@RequestScoped
public class BusinessComponentBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO : Variables and object declaration

	private String businessComponentName;
	private BigDecimal businessComponentTypeId;
	private boolean globalgridstatus;
	private String globalmessage;  
	private String isMultiple = "N";
	private int minValue;
	private int maxValue;
	private String isNumeric = "N";
	private String isAlphabet = "Y";
	private String isSpecial = "N";
	private String isRequired = "N";
	private String isReadOnly = "N";
	private String isEnable = "Y";
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

	//TODO : Auto wired service declaration
	@Autowired
	IBusinessComponentService<T> businessComponentService;

	
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

	public boolean isBcdatagridStatus() {
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

	public boolean getMultipleStatus() {
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

	public IBusinessComponentService<T> getBusinessComponentService() {
		return businessComponentService;
	}

	public void setBusinessComponentService(
			IBusinessComponentService<T> businessComponentService) {
		this.businessComponentService = businessComponentService;
	}


	//TODO : Bean Methods
	
	//Get All component type list
	public List<ComponentType> getComponentType(){
		
		return getBusinessComponentService().getComponentType();
	}
	
	//Fetch business component detail by component name which is entered by user (For Modification purpose)
	public void getBusinessComponentDetail(){
		
		//Check if it is exist or not
		boolean isAvailable = false;
		BussComponentConfDetail bussComponentConfDetail = new BussComponentConfDetail();
		try{
			bussComponentConfDetail = getBusinessComponentService().getBusinessComponent(getBusinessComponentName());
			isAvailable = true;
		}catch(Exception e){
			isAvailable = false;
		}
		
		if(isAvailable){
			
			//Set Business Component Data
			setBusinessComponent(bussComponentConfDetail.getFsBusinessComponentConf().getFsBusinessComponent());
			setBusinessComponentTypeId(getBusinessComponent().getFsComponentType().getComponentTypeId());
			setIsMultiple(getBusinessComponent().getIsMultiple());
			
			setBusinessComponentName(getBusinessComponent().getComponentName());
			
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
			List<BussComponentComboData> lstBussComponentComboData = null;
			try{
				//Fetch drop down list by business component conf id
				lstBussComponentComboData = getBusinessComponentService().getBusinessComponentDropDownData(bussComponentConfDetail.getFsBusinessComponentConf().getComponentConfId());
				if(lstBussComponentComboData.size()>0){
					
					setBcdatagridStatus(true);
					setComponentComboData("");
					setCombComponentErrMsg("");
					lstCompData.clear();
					
					//Append fetched values into BusnessComponentCompBean for prepare data table
					BusnessComponentCompBean busnessComponentCompBean;
					for(BussComponentComboData bussComponentComboData : lstBussComponentComboData){
						busnessComponentCompBean = new BusnessComponentCompBean(new BigDecimal(lstCompData.size()+1),bussComponentComboData.getComponentComboDataId(),bussComponentComboData.getComponentData());
						busnessComponentCompBean.setCreatedBy(bussComponentComboData.getCreatedBy());
						busnessComponentCompBean.setCreatedTime(bussComponentComboData.getCreatedTime());
						lstCompData.add(busnessComponentCompBean);
					}
				}
			}catch(Exception e){}
		}else{
			
			//If drop down not exist reset displayed value
			setBcdatagridStatus(false);
			setComponentComboData("");
			setCombComponentErrMsg("");
			lstCompData.clear();   
		}
	}
	
	//Add component drop down data which is entered in a text box
	public void addComponentData(){
		
		boolean aviStatus = false;

		//check text box is empty
		if(getComponentComboData()==null || getComponentComboData().trim().equals("")){
			setCombComponentErrMsg("Component Data Required");
		}else{
			setCombComponentErrMsg("");
			
			//check same data already exist
			for(BusnessComponentCompBean ety:lstCompData){
				if(ety.getComponentData().trim().equals(getComponentComboData().trim())){
					aviStatus = true;
				}
			}
			
			//Data not exist then add data into data table list
			if(!aviStatus){
				lstCompData.add(new BusnessComponentCompBean(new BigDecimal(lstCompData.size()+1), null, getComponentComboData()));
				setComponentComboData("");
			}else{
				setCombComponentErrMsg("Same data already exist!");
				setComponentComboData("");
			}
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
		
		//Prepare current time
		setCurrentTime(new Date());
		
		//Save business component 
		saveComponentType();
		
		//Save business component configuration
		saveComponentConf();
		
		//Save business component configuration detail
		saveComponentConfDetail();
		
		//Is multiple value then store data table data into component combo detail
		if(getIsMultiple().equalsIgnoreCase("Y")){
			saveComponentComboDetail();
		}
		
	}
	
	//Save or update component Data
	@SuppressWarnings("unchecked")
	private void saveComponentType(){
		
		//Check component id exist or not
		boolean isExists = true;
		if(businessComponent==null){
			businessComponent = new BusinessComponent();
			isExists = false;
		}
		ComponentType bcType = new ComponentType();
		bcType.setComponentTypeId(getBusinessComponentTypeId());
		
		businessComponent.setComponentName(getBusinessComponentName());
		businessComponent.setFsComponentType(bcType);
		businessComponent.setIsMultiple(getIsMultiple());
		
		businessComponent.setIsActive("Y");
		
		//If component data exits then no need to update created by and created time info
		if(!isExists){
			businessComponent.setCreatedBy(getCreatedBy());
			businessComponent.setCreatedTime(getCurrentTime());
		}
		businessComponent.setUpdatedBy(getCreatedBy());
		businessComponent.setUpdatedTime(getCurrentTime());
		
		getBusinessComponentService().saveOrUpdate((T)businessComponent);
	}
	
	//Save or update component conf information
	@SuppressWarnings("unchecked")
	private void saveComponentConf(){
		
		//Check data exist or not in configuration table
		boolean isExists = true;
		if(businessComponentConf==null){
			businessComponentConf = new BusinessComponentConf();
			isExists = false;
		}
		businessComponentConf.setFsBusinessComponent(businessComponent);
		businessComponentConf.setFsRuleApplicationMaster(null);
		businessComponentConf.setFsCompanyMaster(null);
		businessComponentConf.setFsCountryMaster(null);
		businessComponentConf.setFsRulePageMaster(null);
		businessComponentConf.setLevelId(new BigDecimal(0));
		
		//If it is update not required
		if(!isExists){
			businessComponentConf.setCreatedBy(getCreatedBy());
			businessComponentConf.setCreatedTime(getCurrentTime());
		}
		businessComponentConf.setUpdatedBy(getCreatedBy());
		businessComponentConf.setUpdatedTime(getCurrentTime());
		
		getBusinessComponentService().saveOrUpdate((T)businessComponentConf);
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
		
		getBusinessComponentService().saveOrUpdate((T)bussComponentConfDetail);
	}
	
	//Save or update drop down list
	@SuppressWarnings("unchecked")
	private void saveComponentComboDetail(){
		
		//get data from BusnessComponentCompBean (Data table bean) and set to Business component combo data model
		bussComponentComboData = new BussComponentComboData();
		for(BusnessComponentCompBean entity:lstCompData){
			
			bussComponentComboData = new BussComponentComboData();
			if(entity.getBussComponentComboDataId()!=null){
				bussComponentComboData.setComponentComboDataId(entity.getBussComponentComboDataId());
			}
			bussComponentComboData.setFsBusinessComponentConf(businessComponentConf);
			bussComponentComboData.setComponentData(entity.getComponentData());
			if(entity.getBussComponentComboDataId()==null){
				bussComponentComboData.setCreatedBy(getCreatedBy());
				bussComponentComboData.setCreatedTime(getCurrentTime());
			}else{
				bussComponentComboData.setCreatedBy(entity.getCreatedBy());
				bussComponentComboData.setCreatedTime(entity.getCreatedTime());
			}
			bussComponentComboData.setUpdatedBy(getCreatedBy());
			bussComponentComboData.setUpdatedTime(getCurrentTime());
			
			getBusinessComponentService().saveOrUpdate((T)bussComponentComboData);
		}
	}
	
}
