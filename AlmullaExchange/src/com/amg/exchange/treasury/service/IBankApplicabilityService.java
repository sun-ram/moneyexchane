package com.amg.exchange.treasury.service;

import com.amg.exchange.model.BankApplicability;
import com.amg.exchange.service.ICommonService;

public interface IBankApplicabilityService<T> extends ICommonService<T> {

public 	void saveBankApplicabilityDetails(BankApplicability bankApplicability);

}
