package com.amg.exchange.treasury.dao;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.model.BankDdPrintLoc;

public interface IBankDDPrintLocationDao<T> extends ICommonDao<T> {

   public void saveOrUpdateBankDdPrintLoc(BankDdPrintLoc bankDdPrintLoc);

}
