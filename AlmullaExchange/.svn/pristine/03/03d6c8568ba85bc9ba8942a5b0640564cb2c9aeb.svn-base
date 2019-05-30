package com.amg.exchange.treasury.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.model.BankAccount;
import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.treasury.dao.IBankAccountDao;
import com.amg.exchange.treasury.service.IBankAccountService;
@Service("bankAccountServiceImpl")
public class BankAccountServiceImpl<T> implements IBankAccountService<T>, ICommonService<T>,  IMutualService<T> {

	@Autowired
	IBankAccountDao<T> bankAccountDao;
	
	
	public IBankAccountDao<T> getBankAccountDao() {
		return bankAccountDao;
	}

	public void setBankAccountDao(IBankAccountDao<T> bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
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
	
	@Transactional
	@Override
	public void saveBankAccount(BankAccount bankaccount) {
		getBankAccountDao().saveBankAccount(bankaccount);
		
	}
	
	@Transactional
	@Override
	public List<BankBranch> getBankBranchList(BigDecimal bankId) {
		return getBankAccountDao().getBankBranchList(bankId);
	}

}
