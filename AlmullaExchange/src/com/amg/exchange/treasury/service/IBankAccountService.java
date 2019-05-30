package com.amg.exchange.treasury.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BankAccount;
import com.amg.exchange.model.BankBranch;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;

public interface IBankAccountService<T> extends IMutualService<T>, ICommonService<T> {

	public void saveBankAccount(BankAccount bankaccount);
	public List<BankBranch> getBankBranchList(BigDecimal bankId);

}
