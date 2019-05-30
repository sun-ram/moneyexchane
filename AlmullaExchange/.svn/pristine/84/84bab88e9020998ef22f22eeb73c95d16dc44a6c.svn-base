package com.amg.exchange.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.IRuleEngineDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.RuleApplicationDesc;
import com.amg.exchange.model.RuleApplicationMaster;
import com.amg.exchange.model.RuleComponent;
import com.amg.exchange.model.RulePageMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.service.IRuleEngineService;

@Service("ruleEngineService")
public class RuleEngineServiceImpl<T> implements IRuleEngineService<T>,ICommonService<T>, IMutualService<T> {

	@Autowired
	IRuleEngineDao<T> ruleEngineDao;
	
	public IRuleEngineDao<T> getRuleEngineDao() {
		return ruleEngineDao;
	}

	public void setRuleEngineDao(IRuleEngineDao<T> ruleEngineDao) {
		this.ruleEngineDao = ruleEngineDao;
	}
	
	@Transactional
	@Override
	public void save(T entity) {
		getRuleEngineDao().save(entity);
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
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<CompanyMaster> getCompany(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState(String country) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<CityMaster> getCity(BigDecimal state) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<CountryMaster> getCountry() {
		return getRuleEngineDao().getCountry();
	}

	/*@Override
	public List<DistrictMaster> getDistrict(String state) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<RulePageMaster> getSavedApplication() {
		return getRuleEngineDao().getSavedApplication();
	}
	
	@Override
	@Transactional
	public  void saveRuleComponentDesc(RuleComponent rulecomponent) {
     getRuleEngineDao().saveRuleComponentDesc(rulecomponent);
	}

	@Override
	public void saveRuleComponentApplication(RulePageMaster pageMaster) {
		getRuleEngineDao().saveRuleComponentApplication(pageMaster);
		
	}

	@Override
	public void saveRuleComponentApplicationScreen(RulePageMaster master) {
		getRuleEngineDao().saveRuleComponentApplicationScreen(master);
		
	}

	@Override
	public void saveRuleComponent(RuleComponent component) {
		getRuleEngineDao().saveRuleComponent(component);
	}
	
	@Transactional
	@Override
	public List<RuleComponent> getComponentname() {
		return getRuleEngineDao().getComponentname();
	}
	
	@Transactional
	@Override
	public List<RuleComponent> getComponentDesc(String compoCode) {
		return getRuleEngineDao().getComponentDesc(compoCode);
	}
	
	@Transactional
	@Override
	public List<RuleApplicationMaster> getRuleApplicationMaster(String applicationCode) {
		return getRuleEngineDao().getRuleApplicationMaster(applicationCode);
	}
	
	@Transactional
	@Override
	public List<RuleApplicationDesc> getRuleApplicationMasterDesc() {
		return getRuleEngineDao().getRuleApplicationMasterDesc();
	}
	
	@Transactional
	@Override
	public List<RulePageMaster> getRuleApplicationPage(String pageCode) {
		return getRuleEngineDao().getRuleApplicationPage(pageCode);
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

}
