package com.amg.exchange.treasury.serviceimpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.model.BankDdPrintLoc;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.treasury.dao.IBankDDPrintLocationDao;
import com.amg.exchange.treasury.service.IBankDDPrintLocationService;
@SuppressWarnings("serial")
@Service("bankDDPrintLocationServiceImpl")
public class BankDDPrintLocationServiceImpl<T> implements
		ICommonService<T>, Serializable, IBankDDPrintLocationService<T> {
	@SuppressWarnings("rawtypes")
	@Autowired
	IBankDDPrintLocationDao bankDDPrintLocationDao;
    
	
	@SuppressWarnings("rawtypes")
	public IBankDDPrintLocationDao getBankDDPrintLocationDao() {
		return bankDDPrintLocationDao;
	}

	@SuppressWarnings("rawtypes")
	public void setBankDDPrintLocationDao(
			IBankDDPrintLocationDao bankDDPrintLocationDao) {
		this.bankDDPrintLocationDao = bankDDPrintLocationDao;
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
	public void saveOrUpdateBankDdPrintLoc(BankDdPrintLoc bankDdPrintLoc) {
       getBankDDPrintLocationDao().saveOrUpdateBankDdPrintLoc(bankDdPrintLoc);
		
	}

}
