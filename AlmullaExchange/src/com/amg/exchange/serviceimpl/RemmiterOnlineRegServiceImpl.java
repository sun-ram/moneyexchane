package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IRemmiterOnlineRegDao;
import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IRemmiterOnlineRegService;

@Service("remmiterOnlineReg")
public class RemmiterOnlineRegServiceImpl<T> implements IRemmiterOnlineRegService<T>,  ICommonService<T>{
	
	@Autowired
	IRemmiterOnlineRegDao<T> iRemOnlineRegDao;

	public IRemmiterOnlineRegDao<T> getiRemOnlineRegDao() {
		return iRemOnlineRegDao;
	}

	public void setiRemOnlineRegDao(IRemmiterOnlineRegDao<T> iRemOnlineRegDao) {
		this.iRemOnlineRegDao = iRemOnlineRegDao;
	}

	@Override
    @Transactional
	public List<CompanyMaster> getCompany(BigDecimal country) {
		return getiRemOnlineRegDao().getCompany(country);
	}

	@Override
	@Transactional
	public List<StateMaster> getState(BigDecimal country) {
		return getiRemOnlineRegDao().getState(country);
	}

	@Override
	@Transactional
	public List<CityMaster> getCity(BigDecimal state) {
		return getiRemOnlineRegDao().getCity(state);
	}

	@Override
	@Transactional
	public List<CountryMaster> getCountry() {
		return getiRemOnlineRegDao().getCountry();
	}

	@Override
	@Transactional
	public List<DistrictMaster> getDistrict(BigDecimal state) {
		return getiRemOnlineRegDao().getDistrict(state);
	}

	@Override
	@Transactional
	public List<StateMaster> getState() {
		return getiRemOnlineRegDao().getState();
	}

	@Override
	@Transactional
	public void save(T entity) {
		
	}

	@Override
	@Transactional
	public void update(T entity) {
		
	}

	@Override
	@Transactional
	public void delete(T entity) {
		
	}

	@Override
	@Transactional
	public List<ContactDetail> getAllEmployees(String id) {
		return getiRemOnlineRegDao().getAllEmployees(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer, String custId) {
		getiRemOnlineRegDao().saveCustomer(customer, custId);
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		getiRemOnlineRegDao().saveCustomer(customer);
	}

	@Override
	@Transactional
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp, String custId) {
		getiRemOnlineRegDao().saveCustomerEmploymentInfo(customerEmp, custId);
	}

	@Override
	@Transactional
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp) {
		getiRemOnlineRegDao().saveCustomerEmploymentInfo(customerEmp);
	}
	
	@Override
	@Transactional
	public void saveCustomerEmploymentProofInfo(CustomerIdProof customerEmployeeProof, String custId) {
		getiRemOnlineRegDao().saveCustomerEmploymentProofInfo(customerEmployeeProof, custId);
	}
	
	@Override
	@Transactional
	public void saveCustomerEmploymentProofInfo(CustomerIdProof proof) {
		getiRemOnlineRegDao().saveCustomerEmploymentProofInfo(proof);
	}

	@Override
	@Transactional
	public List<CustomerIdProof> getCustomerIdProof(String civilId) {
		return getiRemOnlineRegDao().getCustomerIdProof(civilId);
	}

	@Override
	@Transactional
	public List<CustomerLogin> getLoginInfoForCustomer(String userName,	String password) {
		return getiRemOnlineRegDao().getLoginInfoForCustomer(userName, password);
	}

	@Override
	@Transactional
	public List<ContactDetail> getFsContactDetails(BigDecimal customerId) {
		return getiRemOnlineRegDao().getFsContactDetails(customerId);
	}

	@Override
	@Transactional
	public List<Customer> getFsCustomer(BigDecimal cust_id) {
		return getiRemOnlineRegDao().getFsCustomer(cust_id);
	}

	@Override
	@Transactional
	public List<CustomerEmploymentInfo> getFsCustEmpInfo(BigDecimal customerId) {
		return getiRemOnlineRegDao().getFsCustEmpInfo(customerId);
	}

	@Override
	@Transactional
	public List<CustomerIdProof> getFsCustIdProof(BigDecimal cust_id) {
		return getiRemOnlineRegDao().getFsCustIdProof(cust_id);
	}

	@Override
	@Transactional
	public List<Amlstatus> getAMLStatus(String name) {
		return getiRemOnlineRegDao().getAMLStatus(name);
	}

	@Override
	@Transactional
	public List<NationalityMaster> getNationality() {
		return getiRemOnlineRegDao().getNationality();
	}
	
	@Transactional
	@Override
	public void updateCustomer(Customer customer, String custId) {
		getiRemOnlineRegDao().updateCustomer(customer, custId);
		
	}

	@Transactional
	@Override
	public void updateCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp, String custId) {
		getiRemOnlineRegDao().updateCustomerEmploymentInfo(customerEmp, custId);
	}
	
	@Transactional
	@Override
	public void updateCustomerEmploymentProofInfo(CustomerIdProof customerEmployeeProof, String custId) {
		getiRemOnlineRegDao().updateCustomerEmploymentProofInfo(customerEmployeeProof, custId);
	}
	
	@Transactional
	@Override
	public void saveImage(DocumentImg document) {
		getiRemOnlineRegDao().saveImage(document);
	}
	
	@Transactional
	@Override
	public void updateImage(DocumentImg document, BigDecimal custId) {
		getiRemOnlineRegDao().updateImage(document, custId);
	}
	
	@Transactional
	@Override
	public List<CustomerLogin> getLoginInfoForCustomer(String userName) {
		return getiRemOnlineRegDao().getLoginInfoForCustomer(userName);
	}
	
	@Transactional
	@Override
	public List<DocumentImg> getImage(BigDecimal id) {
		return getiRemOnlineRegDao().getImage(id);
	}
	
	@Transactional
	@Override
	public List<Customer> CheckTokenAvailable(String token) {
		return getiRemOnlineRegDao().CheckTokenAvailable(token);
	}
	
	@Transactional
	@Override
	public void updateLoginCustomerId(String userName, BigDecimal customerId) {
		getiRemOnlineRegDao().updateLoginCustomerId(userName, customerId);
		
	}
	
	@Transactional
	@Override
	public void saveContactDetails(ContactDetail contactDetail) {
		getiRemOnlineRegDao().saveContactDetails(contactDetail);
		
	}
}
