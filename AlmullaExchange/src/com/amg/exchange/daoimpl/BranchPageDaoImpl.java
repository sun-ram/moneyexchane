package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.IBranchPageDao;
import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.ArticleDetails;
import com.amg.exchange.model.ArticleMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.RuleComponent;
import com.amg.exchange.model.StateMaster;

@Repository
public class BranchPageDaoImpl<T>  extends CustomHibernateDaoSupport implements IBranchPageDao<T> {

	@SuppressWarnings("rawtypes")
	protected Class genericClassName;
	
	
	@SuppressWarnings("rawtypes")
	public Class getGenericClassName() {
		return genericClassName;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericClassName(Class genericClassName) {
		this.genericClassName = genericClassName;
	}

	@Override
	public void save(T entity) {

		getSession().save(entity);
	}

	@Override
	public void update(T entity) {

		getSession().update(entity);
		
	}

	@Override
	public void delete(T entity) {

		getSession().delete(entity);
	}

	@Override
	public List<T> findByName(String name) {
		return null;
	}

	@Override
	public List<T> findById(int id) {
		
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findByIdTest(T t,int id) {
		
		return (T)getSession().get( (Class)t, id);
	}

	@Override
	public List<T> findAll() {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(DetachedCriteria criteria) {

		return criteria.getExecutableCriteria(getSession()).list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NationalityMaster> getNationality() {
		DetachedCriteria criteria = DetachedCriteria.forClass(NationalityMaster.class);
		return (List<NationalityMaster>)findAll(criteria);
	}

	@Override
	public List<CityMaster> getCity(BigDecimal state) {
		return null;
	}

	@Override
	public List<CountryMaster> getCountry() {
		return null;
	}

	@Override
	public List<StateMaster> getState() {
		return null;
	}

	@Override
	public List<CustomerIdProof> popUploadedData(String id) {
		return null; 
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo custEmp, BigDecimal customerid) {
		if(customerid.intValue()==0){
			save((T)custEmp);
		}else{
			DetachedCriteria dCriteria = DetachedCriteria.forClass(CustomerEmploymentInfo.class, "custEmpInfo");
			
			dCriteria.setFetchMode("custEmpInfo.fsCustomer",  FetchMode.JOIN);
			dCriteria.createAlias("custEmpInfo.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
			
			dCriteria.add(Restrictions.eq("fsCustomer.customerId", customerid));
			
			List<CustomerEmploymentInfo> lstData = (List<CustomerEmploymentInfo>) findAll(dCriteria) ;
			
			lstData.get(0).setFsCustomer(custEmp.getFsCustomer());
			lstData.get(0).setFsLanguageType(custEmp.getFsLanguageType());
			lstData.get(0).setFsCountryMaster(custEmp.getFsCountryMaster());
			lstData.get(0).setFsCompanyMaster(custEmp.getFsCompanyMaster());
			lstData.get(0).setOccupation(custEmp.getOccupation());
			lstData.get(0).setEmployerName(custEmp.getEmployerName());
			lstData.get(0).setFsEmploymentType(custEmp.getFsEmploymentType());
			//lstData.get(0).setDepartment(custEmp.getEmpcategory());
			/*lstData.get(0).setStateId(custEmp.getStateId());
			lstData.get(0).setDistrictId(custEmp.getDistrictId());
			lstData.get(0).setCityId(custEmp.getCityId());*/
			lstData.get(0).setArea(custEmp.getArea());
			lstData.get(0).setBlock(custEmp.getBlock());
			lstData.get(0).setStreet(custEmp.getStreet());
			lstData.get(0).setOfficeTelephone(custEmp.getOfficeTelephone());
			lstData.get(0).setPostal(custEmp.getPostal());
			lstData.get(0).setUpdatedBy(custEmp.getUpdatedBy());
			lstData.get(0).setLastUpdated(new Date());
			update((T)lstData.get(0));
		}
	}

	@Override
	public void saveApprove(BigDecimal customerId) {
		
	
	}

	@Override
	public void removeIdDetails(BigDecimal customerId) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveCustomerEmploymentProofInfo(CustomerIdProof customerIdProof, BigDecimal customerId) {
		if(customerId.intValue()==0){
			save((T)customerIdProof);
		}else{
			CustomerIdProof idProof = (CustomerIdProof) getSession().get(CustomerIdProof.class, customerId);
			idProof.setFsCustomer(customerIdProof.getFsCustomer());
			idProof.setFsLanguageType(customerIdProof.getFsLanguageType());
			idProof.setFsCustomerType(customerIdProof.getFsCustomerType());
			idProof.setFsIdentityType(customerIdProof.getFsIdentityType());
			idProof.setIdentityFor(customerIdProof.getIdentityFor());
			idProof.setIdentityInt(customerIdProof.getIdentityInt());
			idProof.setApprovedBy(customerIdProof.getApprovedBy());
			idProof.setApprovedDate(customerIdProof.getApprovedDate());
			idProof.setIdentityExpiryDate(customerIdProof.getIdentityExpiryDate());
			idProof.setIdentityStatus(customerIdProof.getIdentityStatus());
			idProof.setUpdatedBy(customerIdProof.getUpdatedBy()); 
			idProof.setLastUpdatedDate(new Date());
			update((T)idProof);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveCustomer(Customer customer, BigDecimal customerId) {
		
		if(customerId.intValue()==0){
			save((T)customer);
		}else{
			Customer customerFromDb = (Customer)getSession().get(Customer.class, customerId); 
			customerFromDb.setFsCountryMasterByCountryId(customer.getFsCountryMasterByCountryId());
			customerFromDb.setFsCompanyMaster(customer.getFsCompanyMaster());
			customerFromDb.setFsLanguageType(customer.getFsLanguageType());
			customerFromDb.setShortName(customer.getShortName());
			customerFromDb.setShortNameLocal(customer.getShortNameLocal());
			customerFromDb.setAmlStatus(customer.getAmlStatus());
			customerFromDb.setTitle(customer.getTitle());
			customerFromDb.setFirstName(customer.getFirstName());
			customerFromDb.setMiddleName(customer.getMiddleName());
			customerFromDb.setLastName(customer.getLastName());
			customerFromDb.setTitleLocal(customer.getTitleLocal());
			customerFromDb.setFirstNameLocal(customer.getFirstNameLocal());
			//customerFromDb.setTokenKey(customer.getTokenKey());
			customerFromDb.setMiddleNameLocal(customer.getMiddleNameLocal());
			customerFromDb.setLastNameLocal(customer.getLastNameLocal());
			customerFromDb.setGender(customer.getGender());
			customerFromDb.setDateOfBirth(customer.getDateOfBirth());
			customerFromDb.setFsCountryMasterByNationality(customer.getFsCountryMasterByNationality());
			customerFromDb.setAlterEmailId(customer.getAlterEmailId());
			customerFromDb.setMobile(customer.getMobile());
			customerFromDb.setEmail(customer.getEmail());
			customerFromDb.setUpdatedBy(customer.getCreatedBy());
			customerFromDb.setLastUpdated(new Date());
			customerFromDb.setActivatedInd(customer.getActivatedInd());
			if(customer.getAmlStatus().equalsIgnoreCase("Pending")) {
				customerFromDb.setPlaceOfBirth(customer.getPlaceOfBirth());
				customerFromDb.setFatherName(customer.getFatherName());
				customerFromDb.setCountryOfBirth(customer.getCountryOfBirth());
			}
			update((T)customerFromDb);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveAdditionalInfo(Customer customer, BigDecimal customerId) {
		
		if(customerId.intValue()==0){
			save((T)customer);
		}else{
			customer.setCustomerId(customerId);
			update((T)customer);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveCustomerIndividual(Customer customer, BigDecimal customerId) {
		
		if(customerId.intValue()==0){
			save((T)customer);
		}else{
			customer.setCustomerId(customerId);
			update((T)customer);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addContactDetails(ContactDetail contactDetail, BigDecimal customerId) {
		
		if(customerId.intValue()==0){
			save((T)contactDetail);
		}else{
			//Here customerId is atually contact Details table primary key
			ContactDetail contactDetailsFromDb = (ContactDetail)getSession().get(ContactDetail.class, customerId); 
			contactDetailsFromDb.setFsContactType(contactDetail.getFsContactType());
			contactDetailsFromDb.setFsCustomer(contactDetail.getFsCustomer());
			contactDetailsFromDb.setFsCountryMaster(contactDetail.getFsCountryMaster());
			contactDetailsFromDb.setFsLanguageType(contactDetail.getFsLanguageType());
			contactDetailsFromDb.setFsStateMaster(contactDetail.getFsStateMaster());
			contactDetailsFromDb.setFsDistrictMaster(contactDetail.getFsDistrictMaster());
			contactDetailsFromDb.setArea(contactDetail.getArea());
			contactDetailsFromDb.setBlock(contactDetail.getBlock());
			contactDetailsFromDb.setFlat(contactDetail.getFlat());
			contactDetailsFromDb.setStreet(contactDetail.getStreet());
			contactDetailsFromDb.setTelephone(contactDetail.getTelephone());
			contactDetailsFromDb.setActiveStatus(contactDetail.getActiveStatus());
			contactDetailsFromDb.setUpdatedBy(contactDetail.getUpdatedBy());
			contactDetailsFromDb.setLastUpdated(new Date());
			update((T)contactDetailsFromDb);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteContactDetails(BigDecimal customerId) {
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		delete((T)customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Amlstatus> getAmlStatus(String name) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Amlstatus.class);
		detachedCriteria.add(Restrictions.eq("remName", name));
		return (List<Amlstatus>)findAll(detachedCriteria);
	}

	@Override
	public List<CompanyMaster> getCompany(BigDecimal countryId) {
		return null;
	}

	@Override
	public List<StateMaster> getState(BigDecimal countryId) {
		return null;
	}

	@Override
	public List<DistrictMaster> getDistrict(BigDecimal stateId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleComponent> getComponentInfo(BigDecimal pageId) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Amlstatus.class);
		detachedCriteria.add(Restrictions.eq("fsRulePageMaster", pageId));
		return (List<RuleComponent>)findAll(detachedCriteria);
	} 

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<CountryMasterDesc> getCountryList(BigDecimal languageId) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CountryMasterDesc.class,"countryMasterDesc");
		
		// Join Language Type table
		detachedCriteria.setFetchMode("countryMasterDesc.fsLanguageType", FetchMode.JOIN);
		detachedCriteria.createAlias("countryMasterDesc.fsLanguageType", "fsLanguageType", CriteriaSpecification.INNER_JOIN);
		
		// Add Language Condition
		detachedCriteria.add(Restrictions.eq("fsLanguageType.languageId", languageId));
		
		// Join Country Master Table
		detachedCriteria.setFetchMode("countryMasterDesc.fsCountryMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("countryMasterDesc.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		
		// Join Rule Application Description Table
		detachedCriteria.setFetchMode("fsCountryMaster.fsRuleApplicationDescs", FetchMode.JOIN);
		detachedCriteria.createAlias("fsCountryMaster.fsRuleApplicationDescs", "fsRuleApplicationDescs", CriteriaSpecification.INNER_JOIN);
		//detachedCriteria.setProjection(Projections.distinct(Projections.property("countryMasterDesc.countryName")));
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		return (List<CountryMasterDesc>)findAll(detachedCriteria);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<CustomerIdProof> getCustomerIdProof(String idNumber) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomerIdProof.class, "customerIdProof");
		
		detachedCriteria.add(Restrictions.eq("customerIdProof.identityInt", idNumber));
		
		detachedCriteria.setFetchMode("customerIdProof.fsCustomer", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsCustomer", "fsCustomer", CriteriaSpecification.LEFT_JOIN);
		
		return ((List<CustomerIdProof>)findAll(detachedCriteria));
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CustomerIdProof> getCustomerIdProofList(BigDecimal customerId) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomerIdProof.class,"customerIdProof");
		
		// Join FS_CUSTOMER table
		detachedCriteria.setFetchMode("customerIdProof.fsCustomer", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		// Add Restriction by Customer
		detachedCriteria.add(Restrictions.eq("fsCustomer.customerId", customerId));
		
		detachedCriteria.add(Restrictions.eq("customerIdProof.identityStatus", "1"));
		
		// Join FS_CUSTOMER_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsCustomerType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsCustomerType", "fsCustomerType", CriteriaSpecification.INNER_JOIN);
		
		// Join FS_IDENTITY_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsIdentityType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsIdentityType", "fsIdentityType", CriteriaSpecification.INNER_JOIN);

		// Join FS_IDENTITY_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsLanguageType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsLanguageType", "fsLanguageType", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("customerIdProof.fsDocumentImg", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsDocumentImg", "fsDocumentImg", CriteriaSpecification.INNER_JOIN);
		
		return (List<CustomerIdProof>)findAll(detachedCriteria);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CustomerIdProof> getCustomerIdProofListAll() {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomerIdProof.class,"customerIdProof");
		
		// Join FS_CUSTOMER table
		detachedCriteria.setFetchMode("customerIdProof.fsCustomer", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		// Add Restriction by Customer
		
		detachedCriteria.add(Restrictions.eq("customerIdProof.identityStatus", "1"));
		
		// Join FS_CUSTOMER_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsCustomerType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsCustomerType", "fsCustomerType", CriteriaSpecification.INNER_JOIN);
		
		// Join FS_IDENTITY_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsIdentityType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsIdentityType", "fsIdentityType", CriteriaSpecification.INNER_JOIN);

		// Join FS_IDENTITY_TYPE Table
		detachedCriteria.setFetchMode("customerIdProof.fsLanguageType", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsLanguageType", "fsLanguageType", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("customerIdProof.fsDocumentImg", FetchMode.JOIN);
		detachedCriteria.createAlias("customerIdProof.fsDocumentImg", "fsDocumentImg", CriteriaSpecification.INNER_JOIN);
		
		return (List<CustomerIdProof>)findAll(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerInfo(BigDecimal customerId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return (List<Customer>)findAll(criteria);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<ContactDetail> getCustomerContactDetails(BigDecimal customerId) { 
		

		/*DetachedCriteria criteria = DetachedCriteria.forClass(ContactDetail.class, "contactDetail");
		
		// Join FS_CUSTOMER table
		criteria.setFetchMode("contactDetail.fsCustomer", FetchMode.JOIN);
		criteria.createAlias("contactDetail.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		// Filter By Customer ID
		criteria.add(Restrictions.eq("fsCustomer.customerId", customerId));
		
		return (List<ContactDetail>)findAll(criteria);*/
		
		DetachedCriteria creteria = DetachedCriteria.forClass(ContactDetail.class, "contactDetail");
		
		creteria.setFetchMode("contactDetail.fsCustomer", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		creteria.add(Restrictions.eq("fsCustomer.customerId", customerId));
		creteria.add(Restrictions.eq("contactDetail.activeStatus", "1"));
		
		creteria.setFetchMode("contactDetail.fsContactType", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsContactType", "fsContactType", CriteriaSpecification.LEFT_JOIN);

		creteria.setFetchMode("contactDetail.fsCountryMaster", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.LEFT_JOIN);

		creteria.setFetchMode("contactDetail.fsStateMaster", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsStateMaster", "fsStateMaster", CriteriaSpecification.LEFT_JOIN);

		creteria.setFetchMode("contactDetail.fsDistrictMaster", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsDistrictMaster", "fsDistrictMaster", CriteriaSpecification.LEFT_JOIN);

		creteria.setFetchMode("contactDetail.fsCityMaster", FetchMode.JOIN);
		creteria.createAlias("contactDetail.fsCityMaster", "fsCityMaster", CriteriaSpecification.LEFT_JOIN);
		
		creteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		
		return (List<ContactDetail>) findAll(creteria);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CustomerEmploymentInfo> getCustomerEmploymentInfo(BigDecimal customerId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerEmploymentInfo.class, "customerEmploymentInfo");
		
		criteria.setFetchMode("customerEmploymentInfo.fsEmploymentType", FetchMode.JOIN);
		criteria.createAlias("customerEmploymentInfo.fsEmploymentType", "fsEmploymentType", CriteriaSpecification.INNER_JOIN);
		
		
		// Join FS_CUSTOMER table
		criteria.setFetchMode("customerEmploymentInfo.fsCustomer", FetchMode.JOIN);
		criteria.createAlias("customerEmploymentInfo.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		// Filter By Customer ID
		criteria.add(Restrictions.eq("fsCustomer.customerId", customerId));
		return (List<CustomerEmploymentInfo>)findAll(criteria);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CustomerLogin> getLoginInfoForCustomer(BigDecimal customerId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerLogin.class, "customerLogin");
		
		// Join FS_CUSTOMER table
		criteria.setFetchMode("customerLogin.fsCustomer", FetchMode.JOIN);
		criteria.createAlias("customerLogin.fsCustomer", "fsCustomer", CriteriaSpecification.INNER_JOIN);
		
		// Filter By Customer ID
		criteria.add(Restrictions.eq("fsCustomer.customerId", customerId));
		return (List<CustomerLogin>)findAll(criteria);
	}
	
	//Save Image 
	@SuppressWarnings("unchecked")
	@Override
	public void saveImage(DocumentImg document) {
		save((T)document);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentImg> getImage(BigDecimal imageId) {
		/*DetachedCriteria dCriteria = DetachedCriteria.forClass(DocumentImg.class, "docImage");
		dCriteria.add(Restrictions.eq("docImage.imgId", imageId));
		return (List<DocumentImg>) findAll(dCriteria);*/System.out.println("Dao ImageId"+imageId);
		return  (List<DocumentImg>) getSession().createQuery("from DocumentImg where imgId="+imageId).list();
	}

	@Override
	public void saveOrUpdateVerifiedCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		
	}

	@Override
	public void saveOrUpdateEmpInfo(CustomerEmploymentInfo custEmp) {
		getSession().saveOrUpdate(custEmp);
		
	}

	@Override
	public void saveOrUpdateCustomerIdProof(CustomerIdProof custProof) {
		getSession().saveOrUpdate(custProof);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ArticleDetails> getLevelData(BigDecimal Id) {
		System.out.println("ID : "+Id);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ArticleDetails.class, "articleDetails");
		
		criteria.setFetchMode("articleDetails.fsArticleMaster", FetchMode.JOIN);
		criteria.createAlias("articleDetails.fsArticleMaster", "fsArticleMaster", JoinType.INNER_JOIN);
		
		criteria.add(Restrictions.eq("fsArticleMaster.articleId", Id));
		
		return (List<ArticleDetails>)findAll(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleMaster> getArtilces() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ArticleMaster.class, "articleMaster");
		
		List<ArticleMaster> data = (List<ArticleMaster>) findAll(criteria);
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerInfoWithToken(BigDecimal customerId,String tokenNumber) {
		System.out.println("the custome id inside daoimpl is"+customerId+"the token number inside daoimpl"+tokenNumber);
		 DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class,"customerId");
		 dCriteria.add(Restrictions.eq("customerId", customerId));
		 dCriteria.add(Restrictions.eq("tokenKey",tokenNumber ));
		return (List<Customer>)findAll(dCriteria); 
	}
}
