package com.amg.exchange.service;

import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.DocumentImg;

public interface ICustomerRegistrationBranchService<T> extends IMutualService<T>, ICommonService<T>{
	
	public void saveCustomer(Customer customer);
	public void saveCustomerIdProof(CustomerIdProof proof);
	public void saveImage(DocumentImg document);
	public void saveContactDetails(ContactDetail contactDetail);
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp);
	 public CustomerIdProof getCustomerIdProof(String idNumber);

}
