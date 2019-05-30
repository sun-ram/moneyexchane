package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.IBusinessComponentDao;
import com.amg.exchange.dao.ICommonDao;
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

@Repository
public class BusinessComponentDaoImpl <T> extends CustomHibernateDaoSupport implements IBusinessComponentDao<T>, ICommonDao<T>{

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
	public List<ComponentType> getComponentType() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ComponentType.class, "componentType");
		criteria.add(Restrictions.eq("componentType.isActive", "Y"));
		
		return (List<ComponentType>)criteria.getExecutableCriteria(getSession()).list();
	}

	@Override
	public void saveOrUpdate(T entity) {
		 
		getSession().saveOrUpdate(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BusinessComponent> getAllBusinessComponent() { 

		DetachedCriteria criteria = DetachedCriteria.forClass(BusinessComponent.class, "businessComponent");
		
		return (List<BusinessComponent>)findAll(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BussComponentConfDetail getBusinessComponent(String componentName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(BussComponentConfDetail.class, "bussComponentConfDetail");
		
		criteria.setFetchMode("bussComponentConfDetail.fsBusinessComponentConf", FetchMode.JOIN);
		criteria.createAlias("bussComponentConfDetail.fsBusinessComponentConf", "fsBusinessComponentConf", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponentConf.levelId", new BigDecimal(0)));

		criteria.setFetchMode("fsBusinessComponentConf.fsBusinessComponent", FetchMode.JOIN);
		criteria.createAlias("fsBusinessComponentConf.fsBusinessComponent", "fsBusinessComponent", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponent.componentName", componentName).ignoreCase());
		
		criteria.setFetchMode("fsBusinessComponent.fsComponentType", FetchMode.JOIN); 
		criteria.createAlias("fsBusinessComponent.fsComponentType", "fsComponentType", JoinType.INNER_JOIN);

		return ((List<BussComponentConfDetail>)findAll(criteria)).get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BussComponentComboData> getBusinessComponentDropDownData(BigDecimal componentConfId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(BussComponentComboData.class, "bussComponentComboData");
		
		criteria.setFetchMode("bussComponentComboData.fsBusinessComponentConf", FetchMode.JOIN);
		criteria.createAlias("bussComponentComboData.fsBusinessComponentConf", "fsBusinessComponentConf", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("fsBusinessComponentConf.componentConfId", componentConfId));
		
		return (List<BussComponentComboData>)findAll(criteria);
	} 
}
