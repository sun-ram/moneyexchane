package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.bean.SearchEntityBean;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.IdentityType;




public interface ISearchCustomerService<T> {
	
	public List<Customer> getCustomer();
	public List<CustomerIdProof> getCustomerIdProof();
	public List<CustomerIdProof> searchAllCustomer(SearchEntityBean searchEntityBean);
	public List<IdentityType> getIdentityTypes(BigDecimal languageId, BigDecimal customerTypeId);
}
