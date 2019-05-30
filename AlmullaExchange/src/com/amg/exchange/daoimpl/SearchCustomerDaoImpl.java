package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amg.exchange.bean.SearchEntityBean;
import com.amg.exchange.dao.ISearchCustomerDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;




@Repository
public class SearchCustomerDaoImpl<T> extends CustomHibernateDaoSupport implements ISearchCustomerDao<T> {

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomer() {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		
		
		return (List<Customer>)findAll(dCriteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerIdProof> getCustomerIdProof() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerIdProof.class);
		return (List<CustomerIdProof>)findAll(criteria);
	}
	
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(getSession()).list();
	}

	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityMaster> getCity(BigDecimal districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryMaster> getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyMaster> getCompany(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictMaster> getDistrict(BigDecimal stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<CustomerIdProof> searchAllCustomer(SearchEntityBean searchEntityBean) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerIdProof.class, "customerIdProof");

		// Join Customer Table
		criteria.setFetchMode("customerIdProof.fsCustomer", FetchMode.JOIN);
		criteria.createAlias("customerIdProof.fsCustomer", "customer", CriteriaSpecification.INNER_JOIN);

		// Join Customer Identity Type Table
		criteria.setFetchMode("customerIdProof.fsIdentityType", FetchMode.JOIN);
		criteria.createAlias("customerIdProof.fsIdentityType", "fsIdentityType", CriteriaSpecification.INNER_JOIN);

		//Restriction for identity type
		criteria.add(Restrictions.eq("fsIdentityType.identityTypeId", searchEntityBean.getIdType()));

		//Identity Number checking
		if(searchEntityBean.getIdNumber() !=null && searchEntityBean.getIdNumber().intValue()!=0){
			criteria.add(Restrictions.eq("customerIdProof.identityInt", searchEntityBean.getIdNumber().toPlainString()));
		}
		
		//Date of birth checking
		if(searchEntityBean.getDob() !=null){
			criteria.add(Restrictions.eq("customer.dateOfBirth", searchEntityBean.getDob()));
		}
		
		//Mobile Number checking
		if(searchEntityBean.getMobileNumber() !=null && !searchEntityBean.getMobileNumber().trim().equals("")){
			criteria.add(Restrictions.eq("customer.mobile", searchEntityBean.getMobileNumber()));
		}
		
		//Customer first name matching
		if(searchEntityBean.getFirstName()!=null && !searchEntityBean.getFirstName().trim().equals("")){
			//criteria.add(Restrictions.like("customer.firstName", searchEntityBean.getFirstName(), MatchMode.START));
			criteria.add(Restrictions.like("customer.firstName", searchEntityBean.getFirstName()).ignoreCase());
		}

		//Customer last name matching
		if(searchEntityBean.getLastName()!=null && !searchEntityBean.getLastName().trim().equals("")){
			criteria.add(Restrictions.like("customer.lastName", searchEntityBean.getLastName()).ignoreCase());
		} 
		
		//Join Country Master Table
		criteria.setFetchMode("customer.fsCountryMasterByNationality", FetchMode.JOIN);
		criteria.createAlias("customer.fsCountryMasterByNationality", "fsCountryMasterByNationality", CriteriaSpecification.INNER_JOIN);		
		
		criteria.add(Restrictions.eq("fsCountryMasterByNationality.countryId", searchEntityBean.getNationalityId()));

		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		return (List<CustomerIdProof>)findAll(criteria);
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	 @Override
	public List<IdentityType> getIdentityTypes(BigDecimal languageId, BigDecimal customerTypeId)
	{
		
		  DetachedCriteria criteria = DetachedCriteria.forClass(IdentityType.class, "identityType");
		  
		  criteria.setFetchMode("identityType.fsLanguageType", FetchMode.JOIN);
		  criteria.createAlias("identityType.fsLanguageType", "fsLanguageType", CriteriaSpecification.INNER_JOIN);
		  criteria.add(Restrictions.eq("fsLanguageType.languageId", languageId));
		    
		  criteria.setFetchMode("identityType.fsCustomerType", FetchMode.JOIN);
		  criteria.createAlias("identityType.fsCustomerType", "fsCustomerType", CriteriaSpecification.INNER_JOIN);
		  criteria.add(Restrictions.eq("fsCustomerType.customerTypeId", customerTypeId));
		  
		  criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		  
		  
		  return (List<IdentityType>)findAll(criteria);
	}
	
}
