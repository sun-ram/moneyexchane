package com.amg.exchange.treasury.serviceimpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.model.BankApplicability;
import com.amg.exchange.treasury.dao.IBankApplicabilityDao;
import com.amg.exchange.treasury.service.IBankApplicabilityService;
@SuppressWarnings("serial")
@Service("bankApplicabilityServiceImpl")
public class BankApplicabilityServiceImpl<T> implements
		IBankApplicabilityService<T>,Serializable {
	@Autowired
	IBankApplicabilityDao<T> bankApplicabilityDao;
	
	public IBankApplicabilityDao<T> getBankApplicabilityDao() {
		return bankApplicabilityDao;
	}

	public void setBankApplicabilityDao(
			IBankApplicabilityDao<T> bankApplicabilityDao) {
		this.bankApplicabilityDao = bankApplicabilityDao;
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
	public void saveBankApplicabilityDetails(BankApplicability bankApplicability) {
		getBankApplicabilityDao().saveBankApplicabilityDetails(bankApplicability);
		
	}

}
