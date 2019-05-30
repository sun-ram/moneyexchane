package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.bean.SearchEntityBean;
import com.amg.exchange.dao.ISearchCustomerDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.service.ISearchCustomerService;

@Service("isearchCustomerService")
public class SearchCustomerServiceImpl<T>  implements ISearchCustomerService<T>,ICommonService<T>, IMutualService<T> {
	
	@Autowired
	ISearchCustomerDao<T> iSearchCustomerDao;
	

	public ISearchCustomerDao<T> getiSearchCustomerDao() {
		return iSearchCustomerDao;
	}

	public void setiSearchCustomerDao(ISearchCustomerDao<T> iSearchCustomerDao) {
		this.iSearchCustomerDao = iSearchCustomerDao;
	}

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return getiSearchCustomerDao().getCustomer();
	}
	 
	@Override
	@Transactional
	public List<CustomerIdProof> getCustomerIdProof() {
		return getiSearchCustomerDao().getCustomerIdProof();
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
	@Transactional
	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return getiSearchCustomerDao().getNationality();
	}
	
	@Transactional
	@Override
	public List<CustomerIdProof> searchAllCustomer(SearchEntityBean searchEntityBean) {

		return getiSearchCustomerDao().searchAllCustomer(searchEntityBean);
	}
	@Transactional
	@Override
	public List<IdentityType> getIdentityTypes(BigDecimal languageId, BigDecimal customerTypeId){
		return getiSearchCustomerDao().getIdentityTypes(languageId, customerTypeId);
	}
}



