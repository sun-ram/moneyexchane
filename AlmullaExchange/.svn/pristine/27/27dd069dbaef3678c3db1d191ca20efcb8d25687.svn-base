package com.amg.exchange.treasury.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amg.exchange.daoimpl.CustomHibernateDaoSupport;
import com.amg.exchange.model.BankAccountDetails;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.treasury.dao.IBankAccountDetailsDao;

@Repository
public class BankAccountDetailsDaoImpl<T> extends CustomHibernateDaoSupport implements IBankAccountDetailsDao<T> {

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
	@SuppressWarnings("unchecked")
	@Override
	public void saveBankAccountDetails(BankAccountDetails bankaccdetails) {
			save((T) bankaccdetails );
		}
	
	/*@Override
	public void saveBankAccountDetails(BankAccountDetails bankaccdetails) {
		getSession().saveOrUpdate(bankaccdetails);
		}
*/

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<BankAccountDetails> getBankAccountDetails(String bankAcctNo) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankAccountDetails.class,"bankaccountdetails");
		
		//detachedCriteria.add(Restrictions.eq("bankAcctNo", bankAcctNo));
		
		detachedCriteria.setFetchMode("bankaccountdetails.fsCountryMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankaccountdetails.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		/*
		detachedCriteria.setFetchMode("bankaccountdetails.bankMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankaccountdetails.bankMaster", "bankMaster", CriteriaSpecification.INNER_JOIN);*/
	
		return (List<BankAccountDetails>)findAll(detachedCriteria);
	}
	}


