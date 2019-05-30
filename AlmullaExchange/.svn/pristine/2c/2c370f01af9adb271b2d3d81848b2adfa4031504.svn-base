package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DocumentImg;

public interface IRemmiterOnlineRegService<T> extends IMutualService<T> {
	
	public List<ContactDetail> getAllEmployees(String id);

	public void saveCustomer(Customer customer, String custId);
	public void saveCustomer(Customer customer);

	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp, String custId);
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp);

	public void saveCustomerEmploymentProofInfo(CustomerIdProof customerEmployeeProof, String custId);
	public void  saveCustomerEmploymentProofInfo(CustomerIdProof proof);
	public void updateLoginCustomerId(String userName, BigDecimal customerId);
	public List<CustomerIdProof> getCustomerIdProof(String civilId);
	public List<CustomerLogin> getLoginInfoForCustomer(String userName, String password);
	public List<ContactDetail> getFsContactDetails(BigDecimal cust_id);
	public void saveContactDetails(ContactDetail contactDetail);
	public List<Customer> getFsCustomer(BigDecimal cust_id);
	public List<CustomerEmploymentInfo> getFsCustEmpInfo(BigDecimal customerId);
	public List<CustomerIdProof> getFsCustIdProof(BigDecimal cust_id);
	public List<Amlstatus> getAMLStatus(String name);
	public void updateCustomer(Customer customer, String custId);
	public void updateCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp, String custId);
	public void updateCustomerEmploymentProofInfo(CustomerIdProof customerEmployeeProof, String custId);
	public void saveImage(DocumentImg document);
	public void updateImage(DocumentImg document, BigDecimal custId);
	public List<CustomerLogin> getLoginInfoForCustomer(String userName);
	
	public List<DocumentImg> getImage(BigDecimal id);
	public List<Customer> CheckTokenAvailable(String token);
	
}
