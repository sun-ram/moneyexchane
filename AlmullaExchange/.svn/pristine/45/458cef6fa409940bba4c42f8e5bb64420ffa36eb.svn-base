package com.amg.exchange.treasury.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.BankAccount;
import com.amg.exchange.model.BankBranch;

public interface IBankAccountDao<T> extends ICommonDao<T>,  IMutualDao {
	
	public void saveBankAccount(BankAccount bankaccount);
	public List<BankBranch> getBankBranchList(BigDecimal bankId);

}
