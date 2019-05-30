package com.amg.exchange.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.ILoginDao;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.Employee;
import com.amg.exchange.model.RuleComponent;

@Repository
public class LoginDaoImpl<T> extends CustomHibernateDaoSupport implements ILoginDao<T>, ICommonDao<T>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void save(T entity) {
		getSession().save(entity);
		
	}

	@Override
	public void update(T entity) {
		getSession().saveOrUpdate(entity);
		
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

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<CustomerLogin> getLoginInfoForCustomer(String userName,	String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerLogin.class, "customerLogin");
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		
		criteria.setFetchMode("customerLogin.fsCountryMaster",  FetchMode.JOIN);
		criteria.createAlias("customerLogin.fsCountryMaster", "fsCountryMaster", JoinType.INNER_JOIN);
		
		criteria.setFetchMode("customerLogin.fsCustomer",  FetchMode.JOIN);
		criteria.createAlias("customerLogin.fsCustomer", "fsCustomer", JoinType.LEFT_OUTER_JOIN);
		
		return (List<CustomerLogin>)findAll(criteria);
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Employee> getLoginInfoForEmployee(String userName,	String password) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RuleComponent> getComponentInfo(String screenName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RuleComponent.class);
		return(List<RuleComponent>) findAll(criteria);
	}

}
