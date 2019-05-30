package com.amg.exchange.treasury.dao;

import java.util.List;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.BankAccountDetails;
import com.amg.exchange.model.BankMaster;

public interface IBankAccountDetailsDao<T> extends ICommonDao<T>,  IMutualDao {
	
	public void saveBankAccountDetails(BankAccountDetails bankaccdetails);
	public List<BankAccountDetails> getBankAccountDetails(String bankAcctNo); 

}
