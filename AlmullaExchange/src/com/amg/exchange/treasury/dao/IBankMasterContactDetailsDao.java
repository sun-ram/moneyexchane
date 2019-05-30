package com.amg.exchange.treasury.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.BankContactDetails;
import com.amg.exchange.model.BankMaster;

public interface IBankMasterContactDetailsDao<T> extends ICommonDao<T>, IMutualDao {

	public List<BankMaster> getBankMasterInfo(); 
	
	public void saveBankMasterContactDetails(BankContactDetails bankContact);
	
	public List<BankContactDetails> getbankContactInfo(BigDecimal bankId);
	
	public List<BankMaster> getbankCountryInfo(BigDecimal bankId);
	
}
