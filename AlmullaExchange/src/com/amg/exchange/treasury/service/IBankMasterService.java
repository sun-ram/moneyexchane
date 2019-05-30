package com.amg.exchange.treasury.service;

import java.util.List;

import com.amg.exchange.model.BankMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;

public interface IBankMasterService<T> extends IMutualService<T>, ICommonService<T>  {
	
	public void saveBankMasterInfo(BankMaster bankMasterinfo);
	
	public List<BankMaster> getBankMasterInfo(String bankCode); 
}
