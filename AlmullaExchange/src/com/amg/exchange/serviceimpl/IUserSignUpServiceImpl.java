package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IUserSignUpDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IUserSignUpService;

@Service("userSignUpServiceImpl")
public class IUserSignUpServiceImpl <T> implements IUserSignUpService<T>, ICommonService<T> {
	
	@Autowired
	IUserSignUpDao<T> iUserSignDao;

	public IUserSignUpDao<T> getiUserSignDao() {
		return iUserSignDao;
	}

	public void setiUserSignDao(IUserSignUpDao<T> iUserSignDao) {
		this.iUserSignDao = iUserSignDao;
	}

	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CityMaster> getCity(BigDecimal state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<CountryMaster> getCountry() {
		return getiUserSignDao().getCountry();
	}


	@Override
	public List<StateMaster> getState() {
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
	public List<CustomerLogin> searchUser(String userName) {
		// TODO Auto-generated method stub
		//return getiUserSignDao().searchUser(userName);
		return getiUserSignDao().searchUser(userName);
	}

	@Transactional
	@Override
	public void saveOnlineUsrData(CustomerLogin signup) {
		getiUserSignDao().saveOnlineUsrData(signup);
		
	}
	
	@Transactional
	@Override
	public List<SecurityQuestionMaster> getQuestions() {
		return getiUserSignDao().getQuestions();
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

	@Transactional
	@Override
	public void updateChangePassword(CustomerLogin customerLogin) {
		getiUserSignDao().updateChangePassword(customerLogin);
		
	}
}
