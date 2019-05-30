package com.amg.exchange.treasury.service;

import java.util.List;

import com.amg.exchange.model.BankAccountDetails;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;

public interface IBankAccountDetailsService<T> extends IMutualService<T>, ICommonService<T> {
	public void saveBankAccountDetails(BankAccountDetails bankaccdetails);
	public List<BankAccountDetails> getBankAccountDetails(String bankAcctNo); 

}
