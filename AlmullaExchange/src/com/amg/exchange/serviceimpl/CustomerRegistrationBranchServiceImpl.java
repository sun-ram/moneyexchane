package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.ICustomerRegistrationBranchDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerEmploymentInfo;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.ICustomerRegistrationBranchService;
import com.amg.exchange.service.IMutualService;

@Service("customerRegistrationServiceImpl")
public class CustomerRegistrationBranchServiceImpl<T> implements ICustomerRegistrationBranchService<T>,ICommonService<T>, IMutualService<T>{

	@Autowired
	ICustomerRegistrationBranchDao<T> customerRegistrationBranchDao;
	
	
	public ICustomerRegistrationBranchDao<T> getCustomerRegistrationBranchDao() {
		return customerRegistrationBranchDao;
	}

	public void setCustomerRegistrationBranchDao(
			ICustomerRegistrationBranchDao<T> customerRegistrationBranchDao) {
		this.customerRegistrationBranchDao = customerRegistrationBranchDao;
	}

	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityMaster> getCity(BigDecimal districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryMaster> getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyMaster> getCompany(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictMaster> getDistrict(BigDecimal stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		getCustomerRegistrationBranchDao().saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public void saveCustomerIdProof(CustomerIdProof proof) {
		getCustomerRegistrationBranchDao().saveCustomerIdProof(proof);
	}

	@Override
	@Transactional
	public void saveImage(DocumentImg document) {
		getCustomerRegistrationBranchDao().saveImage(document);
		
	}

	@Override
	@Transactional
	public void saveContactDetails(ContactDetail contactDetail) {
	getCustomerRegistrationBranchDao().saveContactDetails(contactDetail);
		
	}

	@Override
	@Transactional
	public void saveCustomerEmploymentInfo(CustomerEmploymentInfo customerEmp) {
getCustomerRegistrationBranchDao().saveCustomerEmploymentInfo(customerEmp);
		
	}

	@Override
	@Transactional
	public CustomerIdProof getCustomerIdProof(String idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
