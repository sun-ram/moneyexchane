package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IBusinessComponentConfDao;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.IBusinessComponentConfService;
import com.amg.exchange.service.ICommonService;

@Service("businessComponentConfServiceImpl")
public class BusinessComponentConfServiceImpl <T> implements IBusinessComponentConfService<T>, ICommonService<T> {
	
	@Autowired
	IBusinessComponentConfDao<T> businessComponentConfDao; 

	public IBusinessComponentConfDao<T> getBusinessComponentConfDao() {
		return businessComponentConfDao;
	}

	public void setBusinessComponentConfDao(
			IBusinessComponentConfDao<T> businessComponentConfDao) {
		this.businessComponentConfDao = businessComponentConfDao;
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
	@Transactional
	public void delete(T entity) {

		getBusinessComponentConfDao().delete(entity);
	}

	@Override
	@Transactional
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId) {
		
		return getBusinessComponentConfDao().getBusinessComponent(componentId);
	}

	@Override
	@Transactional
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId,
			BigDecimal applicationId, BigDecimal companyId, 
			BigDecimal countryId, BigDecimal pageId) { 
		
		return getBusinessComponentConfDao().getBusinessComponent(componentId, applicationId, companyId, countryId, pageId);
	}

	@Override
	@Transactional
	public List<BussComponentComboData> getBusinessComponentDropDownData(
			BigDecimal componentConfId) {
		
		return getBusinessComponentConfDao().getBusinessComponentDropDownData(componentConfId);
	}

	@Override
	@Transactional
	public void saveOrUpdate(T entity) {  
		  
		getBusinessComponentConfDao().saveOrUpdate(entity);
	}

	
		 
}
