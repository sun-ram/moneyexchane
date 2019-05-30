package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IForgotPasswordDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IForgotPasswordService;

@Service("forgotPasswordServiceImpl")
public class ForgotPasswordServiceImpl <T> implements IForgotPasswordService<T>, ICommonService<T> {
	
	@Autowired
	IForgotPasswordDao<T> forgotPasswordDao;

	public IForgotPasswordDao<T> getForgotPasswordDao() {
		return forgotPasswordDao;
	}

	public void setForgotPasswordDao(IForgotPasswordDao<T> forgotPasswordDao) {
		this.forgotPasswordDao = forgotPasswordDao;
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
	public List<CustomerLogin> getCustomerDetail(String username) {

		return getForgotPasswordDao().getCustomerDetail(username);
	}

	@Override
	@Transactional
	public List<CustomerLogin> getCustomerDetail(String username, String emailid) {

		return getForgotPasswordDao().getCustomerDetail(username, emailid);
	}

	@Override
	@Transactional
	public void setNewPassword(CustomerLogin customerLogin) {

		getForgotPasswordDao().setNewPassword(customerLogin); 
	}

	@Override
	@Transactional
	public List<SecurityQuestionMaster> getQuestionMasterDescDetail(BigDecimal languageId, List<BigDecimal> questionMasterId) {

		return getForgotPasswordDao().getQuestionMasterDescDetail(languageId, questionMasterId);
	}
}
