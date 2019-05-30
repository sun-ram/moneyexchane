package com.amg.exchange.treasury.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.model.BankContactDetails;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.treasury.dao.IBankMasterContactDetailsDao;
import com.amg.exchange.treasury.service.IBankMasterContactDetailsService;

@Service("bankMasterServiceImpl")
public class BankmasterServiceImpl<T> implements IBankMasterContactDetailsService<T>, ICommonService<T>,  IMutualService<T>{
	
	@Autowired
	IBankMasterContactDetailsDao<T> bankMasterContactDetailsDao;
	public IBankMasterContactDetailsDao<T> getBankMasterContactDetailsDao() {
		return bankMasterContactDetailsDao;
	}
	public void setBankMasterContactDetailsDao(
			IBankMasterContactDetailsDao<T> bankMasterContactDetailsDao) {
		this.bankMasterContactDetailsDao = bankMasterContactDetailsDao;
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
	
	@Override
	@Transactional
	public List<BankMaster> getBankMasterInfo() {
		return getBankMasterContactDetailsDao().getBankMasterInfo();
	}
	
	@Transactional
	@Override
	public void saveBankMasterContactDetails(BankContactDetails bankContact) {
		getBankMasterContactDetailsDao().saveBankMasterContactDetails(bankContact);
		
	}
	
	@Transactional
	@Override
	public List<BankContactDetails> getbankContactInfo(BigDecimal bankId) {
		return getBankMasterContactDetailsDao().getbankContactInfo(bankId);
	}
	
	@Transactional
	@Override
	public List<BankMaster> getbankCountryInfo(BigDecimal bankId) {
		return getBankMasterContactDetailsDao().getbankCountryInfo(bankId);
	}

} 
