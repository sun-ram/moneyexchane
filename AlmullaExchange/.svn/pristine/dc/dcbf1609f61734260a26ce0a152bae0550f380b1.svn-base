package com.amg.exchange.treasury.daoimpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.daoimpl.CustomHibernateDaoSupport;
import com.amg.exchange.model.BankApplicability;
import com.amg.exchange.treasury.dao.IBankApplicabilityDao;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
@Repository
public class BankApplicabilityDaoImpl<T> extends CustomHibernateDaoSupport  implements IBankApplicabilityDao<T>,
		ICommonDao<T> {

	@Override
	public void save(T entity) {
		getSession().saveOrUpdate(entity);
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

	@SuppressWarnings("unchecked")
	@Override
	public void saveBankApplicabilityDetails(BankApplicability bankApplicability) {
		save( (T) bankApplicability );
		
	}

}
