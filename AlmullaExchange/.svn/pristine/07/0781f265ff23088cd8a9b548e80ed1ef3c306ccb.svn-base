package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IForgotPasswordDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.model.StateMaster;

@Repository
public class ForgotPasswordDaoImpl <T> extends CustomHibernateDaoSupport implements IForgotPasswordDao<T>, ICommonDao<T>{

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

	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CustomerLogin> getCustomerDetail(String username) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerLogin.class, "customerLogin");
		criteria.add(Restrictions.eq("customerLogin.userName", username).ignoreCase());
		
		return (List<CustomerLogin>)criteria.getExecutableCriteria(getSession()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerLogin> getCustomerDetail(String username, String emailid) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerLogin.class, "customerLogin");
		criteria.add(Restrictions.eq("customerLogin.userName", username).ignoreCase());
		criteria.add(Restrictions.eq("customerLogin.email", emailid).ignoreCase());
		
		return (List<CustomerLogin>)criteria.getExecutableCriteria(getSession()).list();
	}

	@Override
	public void setNewPassword(CustomerLogin customerLogin) {

		getSession().update(customerLogin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityQuestionMaster> getQuestionMasterDescDetail(BigDecimal languageId, List<BigDecimal> questionMasterId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecurityQuestionMaster.class, "securityQuestionMaster");
		
		criteria.setFetchMode("securityQuestionMaster.fsLanguageType", FetchMode.JOIN);
		criteria.createAlias("securityQuestionMaster.fsLanguageType", "fsLanguageType", JoinType.INNER_JOIN);
		
		criteria.add(Restrictions.eq("fsLanguageType.languageId", languageId));

		criteria.add(Restrictions.disjunction().add(Property.forName("securityQuestionMaster.questionId").in(questionMasterId)));
		
		return (List<SecurityQuestionMaster>)criteria.getExecutableCriteria(getSession()).list();
	} 

}
