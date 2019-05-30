package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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

@Repository
public class RuleEngineDaoImpl<T>  extends CustomHibernateDaoSupport implements IRuleEngineDao<T> {

	@Override
	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(getSession()).list();
	}

	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyMaster> getCompany(BigDecimal country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState(BigDecimal country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityMaster> getCity(BigDecimal state) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CountryMaster> getCountry() {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(CountryMaster.class);
		return (List<CountryMaster>) findAll(dCriteria);
	}

	@Override
	public List<DistrictMaster> getDistrict(BigDecimal state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RulePageMaster> getSavedApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public  void saveRuleComponentDesc(RuleComponent rulecomponent){
		update((T)rulecomponent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveRuleComponentApplication(RulePageMaster pageMaster) {
		save((T) pageMaster);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveRuleComponentApplicationScreen(RulePageMaster master) {
		save((T) master);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveRuleComponent(RuleComponent component) {
		save((T) component);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleComponent> getComponentname() {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(RuleComponent.class);
		return (List<RuleComponent>) findAll(dCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleComponent> getComponentDesc(String compoCode) {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(RuleComponent.class);
		dCriteria.add(Restrictions.eq("componentCode",compoCode));
		return (List<RuleComponent>) findAll(dCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleApplicationMaster> getRuleApplicationMaster(String applicationCode) {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(RuleApplicationMaster.class);
		dCriteria.add(Restrictions.eq("applicationCode",applicationCode));
		return (List<RuleApplicationMaster>) findAll(dCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleApplicationDesc> getRuleApplicationMasterDesc() {
		
		List<RuleApplicationDesc> masterdesc =  (List<RuleApplicationDesc>) getSession().createQuery("from RuleApplicationDesc").list();
		for (RuleApplicationDesc ruleApplicationDesc : masterdesc) {
			/*System.out.println("Application ID  : "+ruleApplicationDesc.getFsRuleApplicationMaster().getApplicationId()+" - "+ruleApplicationDesc.getFsCompanyMaster().getCompanyId()+
					"-"+ruleApplicationDesc.getFsCompanyMaster().getCompanyId());*/
		}
		return masterdesc;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RulePageMaster> getRuleApplicationPage(String pageCode) {
		
		List<RulePageMaster> masterPage =  (List<RulePageMaster>) getSession().createQuery("from RulePageMaster where pageCode = '"+pageCode+"'").list();
		return masterPage;
	}

}
