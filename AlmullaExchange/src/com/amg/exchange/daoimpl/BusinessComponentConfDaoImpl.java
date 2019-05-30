package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.IBusinessComponentConfDao;
import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;

@Repository
public class BusinessComponentConfDaoImpl <T> extends CustomHibernateDaoSupport implements IBusinessComponentConfDao<T>, ICommonDao<T>{

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
		
		getSession().delete(entity);
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

	@SuppressWarnings("unchecked")
	@Override
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(BussComponentConfDetail.class, "bussComponentConfDetail");
		
		criteria.setFetchMode("bussComponentConfDetail.fsBusinessComponentConf", FetchMode.JOIN);
		criteria.createAlias("bussComponentConfDetail.fsBusinessComponentConf", "fsBusinessComponentConf", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponentConf.levelId", new BigDecimal(0)));

		criteria.setFetchMode("fsBusinessComponentConf.fsBusinessComponent", FetchMode.JOIN);
		criteria.createAlias("fsBusinessComponentConf.fsBusinessComponent", "fsBusinessComponent", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponent.componentId", componentId));
		
		criteria.setFetchMode("fsBusinessComponent.fsComponentType", FetchMode.JOIN); 
		criteria.createAlias("fsBusinessComponent.fsComponentType", "fsComponentType", JoinType.INNER_JOIN);

		return ((List<BussComponentConfDetail>)findAll(criteria)).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId,
			BigDecimal applicationId, BigDecimal companyId,
			BigDecimal countryId, BigDecimal pageId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(BussComponentConfDetail.class, "bussComponentConfDetail");
		
		criteria.setFetchMode("bussComponentConfDetail.fsBusinessComponentConf", FetchMode.JOIN);
		criteria.createAlias("bussComponentConfDetail.fsBusinessComponentConf", "fsBusinessComponentConf", JoinType.INNER_JOIN);
		
		criteria.setFetchMode("fsBusinessComponentConf.fsBusinessComponent", FetchMode.JOIN);
		criteria.createAlias("fsBusinessComponentConf.fsBusinessComponent", "fsBusinessComponent", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponent.componentId", componentId));
		
		criteria.setFetchMode("fsBusinessComponent.fsComponentType", FetchMode.JOIN); 
		criteria.createAlias("fsBusinessComponent.fsComponentType", "fsComponentType", JoinType.INNER_JOIN);
		
		if(applicationId!=null && applicationId.intValue()!=0){
			criteria.setFetchMode("fsBusinessComponentConf.fsRuleApplicationMaster", FetchMode.JOIN); 
			criteria.createAlias("fsBusinessComponentConf.fsRuleApplicationMaster", "fsRuleApplicationMaster", JoinType.INNER_JOIN);
			criteria.add(Restrictions.eq("fsRuleApplicationMaster.applicationId", applicationId));
		}
		
		if(companyId!=null && companyId.intValue()!=0){
			criteria.setFetchMode("fsBusinessComponentConf.fsCompanyMaster", FetchMode.JOIN); 
			criteria.createAlias("fsBusinessComponentConf.fsCompanyMaster", "fsCompanyMaster", JoinType.INNER_JOIN);
			criteria.add(Restrictions.eq("fsCompanyMaster.companyId", companyId));
		}

		if(countryId!=null && countryId.intValue()!=0){
			criteria.setFetchMode("fsBusinessComponentConf.fsCountryMaster", FetchMode.JOIN); 
			criteria.createAlias("fsBusinessComponentConf.fsCountryMaster", "fsCountryMaster", JoinType.INNER_JOIN);
			criteria.add(Restrictions.eq("fsCountryMaster.countryId", countryId));
		}
		
		if(pageId!=null && pageId.intValue()!=0){
			criteria.setFetchMode("fsBusinessComponentConf.fsRulePageMaster", FetchMode.JOIN); 
			criteria.createAlias("fsBusinessComponentConf.fsRulePageMaster", "fsRulePageMaster", JoinType.INNER_JOIN);
			criteria.add(Restrictions.eq("fsRulePageMaster.pageId", pageId));
		}

		return ((List<BussComponentConfDetail>)findAll(criteria)).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BussComponentComboData> getBusinessComponentDropDownData(
			BigDecimal componentConfId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(BussComponentComboData.class, "bussComponentComboData");
		
		criteria.setFetchMode("bussComponentComboData.fsBusinessComponentConf", FetchMode.JOIN);
		criteria.createAlias("bussComponentComboData.fsBusinessComponentConf", "fsBusinessComponentConf", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponentConf.componentConfId", componentConfId));
		
		return (List<BussComponentComboData>)findAll(criteria);
	}

	@Override
	public void saveOrUpdate(T entity) {
		
		getSession().saveOrUpdate(entity);
	} 
	 
}
