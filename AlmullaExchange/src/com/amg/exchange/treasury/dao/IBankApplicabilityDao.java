package com.amg.exchange.treasury.dao;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.model.BankApplicability;

public interface IBankApplicabilityDao<T> extends ICommonDao<T> {

public	void saveBankApplicabilityDetails(BankApplicability bankApplicability);

}
