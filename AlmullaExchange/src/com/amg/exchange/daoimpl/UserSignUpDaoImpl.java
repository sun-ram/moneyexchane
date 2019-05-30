package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IUserSignUpDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.model.StateMaster;

@Repository
public class UserSignUpDaoImpl <T> extends CustomHibernateDaoSupport implements IUserSignUpDao<T>, ICommonDao<T>{

	@Override
	public void save(T entity) {
		getSession().save(entity);
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
	public List<SecurityQuestionMaster> getQuestions() {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(SecurityQuestionMaster.class);
		return (List<SecurityQuestionMaster>)findAll(dCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override 
	public List<CustomerLogin> searchUser(String userName) {

		DetachedCriteria dCriteria = DetachedCriteria.forClass(CustomerLogin.class);
		dCriteria.add(Restrictions.eq("userName", userName).ignoreCase() );
		return (List<CustomerLogin>)findAll(dCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOnlineUsrData(CustomerLogin signup) {
		save((T) signup );
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateChangePassword(CustomerLogin customerLogin) {
		try{
		update((T) customerLogin );
		}catch(Exception e){
			e.printStackTrace();
		}
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
	}*/

/*	@Override
	public List<StateMaster> getState(String country) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<CityMaster> getCity(BigDecimal state) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CountryMaster> getCountry() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CountryMaster.class);
		return (List<CountryMaster>) findAll(criteria);
	}

	/*@Override
	public List<DistrictMaster> getDistrict(String state) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityQuestionMaster> getQuestionsComponentId() {
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
}
