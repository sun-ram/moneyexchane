package com.amg.exchange.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.ILoginDao;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.Employee;
import com.amg.exchange.model.RuleComponent;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.ILoginService;

@SuppressWarnings("serial")
@Service("loginServiceImpl")
public class LoginServiceImpl<T> implements ILoginService<T>, ICommonService<T>,Serializable{
	
	@Autowired
	ILoginDao<T> loginDao;
	
	public ILoginDao<T> getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao<T> loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public void save(T entity) {

	}

	@Override
	public void update(T entity) {
		
	}

	@Override
	public void delete(T entity) {
		
	}

	@Override
	@Transactional
	public List<CustomerLogin> getLoginInfoForCustomer(String userName, String password) {
		return getLoginDao().getLoginInfoForCustomer(userName, password);
	}

	@Override
	@Transactional
	public List<Employee> getLoginInfoForEmployee(String userName, String password) {
		return getLoginDao().getLoginInfoForEmployee(userName, password);
	}
 
	@Override
	@Transactional
	public List<RuleComponent> getComponentInfo(String screenName) {
		return getLoginDao().getComponentInfo(screenName);
	}
}
