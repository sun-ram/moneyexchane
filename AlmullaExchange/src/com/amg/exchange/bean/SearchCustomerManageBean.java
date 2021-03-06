package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.service.ISearchCustomerService;
import com.amg.exchange.util.SessionStateManage;
import com.sun.istack.internal.FinalArrayList;


@Component("searchCustomer")
@Scope("session")
public class SearchCustomerManageBean <T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String middleName;
	private String idNumber;
	private String lastName;
	private BigDecimal nationality;
	private BigDecimal idType;
	private String mob;
	private Date dob;
	private String cust_id;
	private BigDecimal countryId;
	private Boolean booPass = false;
	List<CustomerIdProof> lstCustomer = new ArrayList<CustomerIdProof>();
	Map<BigDecimal,String> mapNationalityList = new HashMap<BigDecimal, String>();
	
	@Autowired
	ISearchCustomerService<T> isearchCustomerService;

	@Autowired
	IGeneralService<T> igeneralService;
	
	@Autowired
	CustomerRegistrationBranchBean customerRegistrationBranchBean;
	
	public Map<BigDecimal, String> getMapNationalityList() {
		return mapNationalityList;
	}

	public void setMapNationalityList(Map<BigDecimal, String> mapNationalityList) {
		this.mapNationalityList = mapNationalityList;
	}

	public List<CustomerIdProof> getLstCustomer() {
		return lstCustomer;
	}

	public void setLstCustomer(List<CustomerIdProof> lstCustomer) {
		this.lstCustomer = lstCustomer;
	}

	public ISearchCustomerService<T> getIsearchCustomerService() {
		return isearchCustomerService;
	}

	public void setIsearchCustomerService(
			ISearchCustomerService<T> isearchCustomerService) {
		this.isearchCustomerService = isearchCustomerService;
	}

	public IGeneralService<T> getIgeneralService() {
		return igeneralService;
	}


	
	


	public CustomerRegistrationBranchBean getCustomerRegistrationBranchBean() {
		return customerRegistrationBranchBean;
	}

	public void setCustomerRegistrationBranchBean(
			CustomerRegistrationBranchBean customerRegistrationBranchBean) {
		this.customerRegistrationBranchBean = customerRegistrationBranchBean;
	}






	private List<IdentityType> idList;
	
	
	
	
	public List<IdentityType> getIdList() {
		return idList;
	}

	public void setIdList(List<IdentityType> idList) {
		this.idList = idList;
	}

	

	public BigDecimal getIdType() {
		return idType;
	}
	public void setIdType(BigDecimal idType) {
		this.idType = idType;
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigDecimal getNationality() {
		return nationality;
	}
	public void setNationality(BigDecimal nationality) {
		this.nationality = nationality;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}


	
	

	public BigDecimal getCountryId() {
		return countryId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}
	

	public Boolean getBooPass() {
		return booPass;
	}

	public void setBooPass(Boolean booPass) {
		this.booPass = booPass;
	}



	private List<CreateSearchTable> finalData;
	private BigDecimal individualIdType = new BigDecimal(1);
    
	public List<CountryMasterDesc> getNationalityNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		return getIgeneralService().getNationalityList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"));
	}

		
	public void popIdType(AjaxBehaviorEvent e) {
		{

			idList = new ArrayList<IdentityType>();

			SessionStateManage sessionStateManage = new SessionStateManage();
			setIdList(getIsearchCustomerService()
					.getIdentityTypes(
							new BigDecimal(
									sessionStateManage.isExists("languageId") ? sessionStateManage
											.getSessionValue("languageId")
											: "" + 1),
							 individualIdType));

		}
		
		this.idType = null;
		finalData = new FinalArrayList<CreateSearchTable>();
		setBooPass(true);
	}


	
	public void setNationalityListMap(){
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		if(mapNationalityList.size()==0){
			List<CountryMasterDesc> lstCountryMasterDesc = getIgeneralService().getNationalityList(
					new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("lanaguageId"):"1")
					);
			for(CountryMasterDesc countryMasterDesc: lstCountryMasterDesc){
				mapNationalityList.put(countryMasterDesc.getFsCountryMaster().getCountryId(), countryMasterDesc.getNationality());
			}
		}
	}
	
	public List<CreateSearchTable> getDataForAllCustomer() {

		setNationalityListMap();
		SearchEntityBean searchEntityBean = new SearchEntityBean();
		searchEntityBean.setNationalityId(getNationality());
		searchEntityBean.setIdType(getIdType());
		try{
		searchEntityBean.setIdNumber(new BigDecimal(getIdNumber()));
		}catch(Exception e){}
		searchEntityBean.setFirstName(getFirstName());
		searchEntityBean.setLastName(getLastName());
		searchEntityBean.setDob(getDob());
		searchEntityBean.setMobileNumber(getMob());
		
		finalData = new ArrayList<CreateSearchTable>();
		
		lstCustomer = new ArrayList<CustomerIdProof>();
		lstCustomer =  getIsearchCustomerService().searchAllCustomer(searchEntityBean);
		CreateSearchTable createSearchTable = new CreateSearchTable();
		
		for(CustomerIdProof customerIdProof: lstCustomer){
			
			createSearchTable = new CreateSearchTable();
			createSearchTable.setIdNumber(customerIdProof.getIdentityInt());
			createSearchTable.setIdType(customerIdProof.getFsIdentityType().getIdentityType());
			createSearchTable.setFirstName(customerIdProof.getFsCustomer().getFirstName());
			createSearchTable.setLastName(customerIdProof.getFsCustomer().getLastName());
			createSearchTable.setNationality(mapNationalityList.get(customerIdProof.getFsCustomer().getFsCountryMasterByNationality().getCountryId()));
			try{
				createSearchTable.setDob(new SimpleDateFormat("dd-MM-yyyy").format(customerIdProof.getFsCustomer().getDateOfBirth()));
			}catch(Exception e){}
			createSearchTable.setMob(customerIdProof.getFsCustomer().getMobile());
			finalData.add(createSearchTable);
		}
		
		return finalData;
	}
	

   public String showData(CreateSearchTable obj) {
	   getCustomerRegistrationBranchBean().ShowFromSearchPage(obj.getIdNumber(), obj.getIdType());
		return "branchPage";
	}
   public void resetValue() {  
	   this.nationality = null ;
	   this.idType = null;
       this.idNumber = null;  
       this.firstName = null;  
       this.lastName = null;
       this.mob = null;
       this.dob = null;
  
   }  
   
}

