package com.amg.exchange.treasury.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.treasury.dao.IBankMasterDao;
import com.amg.exchange.treasury.service.IBankMasterService;

@Service("bankMasterContactDetailsServiceImpl")
public class BankmasterContactDetailsServiceImpl<T> implements IBankMasterService<T>, ICommonService<T>,  IMutualService<T>{
	
	@Autowired
	IBankMasterDao<T> bankMasterDao;
	public IBankMasterDao<T> getBankMasterDao() {
		return bankMasterDao;
	}
	public void setBankMasterDao(IBankMasterDao<T> bankMasterDao) {
		this.bankMasterDao = bankMasterDao;
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
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Responsible to save Bank Master Information
	 */
	@Transactional
	@Override
	public void saveBankMasterInfo(BankMaster bankMasterinfo) {
		getBankMasterDao().saveBankMasterInfo(bankMasterinfo);
	}
	
	/**
	 * Responsible to fetch all Bank Master data from database depending upon given bank code
	 */
	@Transactional
	@Override
	public List<BankMaster> getBankMasterInfo(String bankCode) {
		return getBankMasterDao().getBankMasterInfo(bankCode);
	}

} 
