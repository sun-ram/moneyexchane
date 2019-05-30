package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.RuleComponent;

public interface ICustomerRegistrationBranchDao<T> extends ICommonDao<T>, IMutualDao{
	
	public void saveCustomer(Customer customer);
	public void saveCustomerIdProof(CustomerIdProof proof);
	public void saveImage(DocumentImg document);
	public void saveContactDetails(ContactDetail contactDetail);
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp);
	 public CustomerIdProof getCustomerIdProof(String idNumber);
	
}
