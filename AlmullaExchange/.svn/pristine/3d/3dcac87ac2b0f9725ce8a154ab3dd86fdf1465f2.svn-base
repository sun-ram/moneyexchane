package com.amg.exchange.treasury.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amg.exchange.daoimpl.CustomHibernateDaoSupport;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.treasury.dao.IBankMasterDao;

@Repository
public class BankMasterDaoImpl<T>  extends CustomHibernateDaoSupport implements IBankMasterDao<T> {

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

	@Override
	public void saveBankMasterInfo(BankMaster bankMasterinfo) {
		getSession().saveOrUpdate(bankMasterinfo);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<BankMaster> getBankMasterInfo(String bankCode) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankMaster.class,"bankmaster");
		
		detachedCriteria.add(Restrictions.eq("bankCode", bankCode));
		
		detachedCriteria.setFetchMode("bankmaster.fsCountryMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankmaster.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("bankmaster.fsStateMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankmaster.fsStateMaster", "fsStateMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("bankmaster.fsDistrictMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankmaster.fsDistrictMaster", "fsDistrictMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("bankmaster.fsCityMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("bankmaster.fsCityMaster", "fsCityMaster", CriteriaSpecification.INNER_JOIN);
		
		return (List<BankMaster>)findAll(detachedCriteria);
	}
	
}
