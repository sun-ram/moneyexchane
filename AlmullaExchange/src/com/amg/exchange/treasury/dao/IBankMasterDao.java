package com.amg.exchange.treasury.dao;

import java.util.List;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.BankMaster;

public interface IBankMasterDao<T> extends ICommonDao<T>, IMutualDao {

	public void saveBankMasterInfo(BankMaster bankMasterinfo);
	
	public List<BankMaster> getBankMasterInfo(String bankCode); 
	
}
