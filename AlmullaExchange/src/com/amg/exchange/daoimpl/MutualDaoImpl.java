package com.amg.exchange.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;

public class MutualDaoImpl implements IMutualDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<CountryMaster> getCountry() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from CountryMaster").list();
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
/*
	@Override
	public List<CompanyMaster> getCompany(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMaster> getState(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictMaster> getDistrict(String state) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
