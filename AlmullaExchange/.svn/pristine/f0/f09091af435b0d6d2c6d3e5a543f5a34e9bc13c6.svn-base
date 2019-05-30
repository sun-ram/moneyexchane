package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;

public interface IMutualDao {
	
	public List<NationalityMaster> getNationality();
	//public List<CompanyMaster> getCompany(String country);
	//public List<StateMaster> getState(String country);
	public List<CityMaster> getCity(BigDecimal districtId);
    public List<CountryMaster> getCountry();
   // public List<DistrictMaster> getDistrict(String state);
	public List<StateMaster> getState();
	public List<CompanyMaster> getCompany(BigDecimal countryId);
	public List<StateMaster> getState(BigDecimal countryId);
	public List<DistrictMaster> getDistrict(BigDecimal stateId);
}
