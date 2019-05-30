package com.amg.exchange.treasury.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BankContactDetails;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;

public interface IBankMasterContactDetailsService<T> extends IMutualService<T>, ICommonService<T>  {
	
	public List<BankMaster> getBankMasterInfo(); 
	
	public void saveBankMasterContactDetails(BankContactDetails bankConatct);
	
	public List<BankContactDetails> getbankContactInfo(BigDecimal bankId); 
	
	public  List<BankMaster> getbankCountryInfo(BigDecimal id); 
}
