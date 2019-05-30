package com.amg.exchange.treasury.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amg.exchange.daoimpl.CustomHibernateDaoSupport;
import com.amg.exchange.model.BankContactDetails;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.treasury.dao.IBankMasterContactDetailsDao;

@Repository
public class BankMasterContactDetailsDaoImpl<T>  extends CustomHibernateDaoSupport implements IBankMasterContactDetailsDao<T> {

	@Override
	public void save(T entity) {
		getSession().save(entity);

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

	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<BankMaster> getBankMasterInfo() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankMaster.class,"bankmaster");
		return (List<BankMaster>)findAll(detachedCriteria);
	}

	@Override
	public void saveBankMasterContactDetails(BankContactDetails bankContact) {
		getSession().saveOrUpdate(bankContact);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<BankContactDetails> getbankContactInfo(BigDecimal bankId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankContactDetails.class,"bankmasterContactInfo");
		
		detachedCriteria.add(Restrictions.eq("bankmasterContactInfo.recordStatus", "1"));
		
		detachedCriteria.setFetchMode("bankmasterContactInfo.exBankMaster",  FetchMode.JOIN);
		detachedCriteria.createAlias("bankmasterContactInfo.exBankMaster", "exBankMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.add(Restrictions.eq("exBankMaster.bankId", bankId));
		
		return (List<BankContactDetails>)findAll(detachedCriteria);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<BankMaster> getbankCountryInfo(BigDecimal bankId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankMaster.class,"bankmaster");
		
		detachedCriteria.add(Restrictions.eq("bankmaster.bankId", bankId));
		
		detachedCriteria.setFetchMode("bankmaster.fsCountryMaster",  FetchMode.JOIN);
		detachedCriteria.createAlias("bankmaster.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		
		return (List<BankMaster>)findAll(detachedCriteria);
	}
	
}
