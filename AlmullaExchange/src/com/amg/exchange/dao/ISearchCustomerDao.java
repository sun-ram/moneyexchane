package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.bean.SearchEntityBean;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.IdentityType;


public interface ISearchCustomerDao<T> extends ICommonDao<T>, IMutualDao {
	
	public List<Customer> getCustomer();
	public List<CustomerIdProof> getCustomerIdProof();
	public List<CustomerIdProof> searchAllCustomer(SearchEntityBean searchEntityBean);
	public List<IdentityType> getIdentityTypes(BigDecimal languageId, BigDecimal customerTypeId);
}
