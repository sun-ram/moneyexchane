package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IBusinessComponentDao;
import com.amg.exchange.model.BusinessComponent;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.ComponentType;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.IBusinessComponentService;
import com.amg.exchange.service.ICommonService;

@Service("businessComponentServiceImpl")
public class BusinessComponentServiceImpl <T> implements IBusinessComponentService<T>, ICommonService<T> {
	
	@Autowired
	IBusinessComponentDao<T> businessComponentDao;

	public IBusinessComponentDao<T> getBusinessComponentDao() {
		return businessComponentDao;
	}

	public void setBusinessComponentDao(
			IBusinessComponentDao<T> businessComponentDao) {
		this.businessComponentDao = businessComponentDao;
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
	public List<ComponentType> getComponentType() {
	
		return getBusinessComponentDao().getComponentType();
	}

	@Override
	@Transactional
	public void saveOrUpdate(T entity) {   
		
		getBusinessComponentDao().saveOrUpdate(entity);
	}

	@Override
	@Transactional 
	public List<BusinessComponent> getAllBusinessComponent() {

		return getBusinessComponentDao().getAllBusinessComponent();
	}

	@Override
	@Transactional
	public BussComponentConfDetail getBusinessComponent(String componentName) {

		return getBusinessComponentDao().getBusinessComponent(componentName);
	}

	@Override
	@Transactional
	public List<BussComponentComboData> getBusinessComponentDropDownData( BigDecimal componentConfId) {
		
		return getBusinessComponentDao().getBusinessComponentDropDownData(componentConfId);
	}	 
}
