package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;

public interface IMutualService<T>  {
	
	/*public List<NationalityMaster> getNationality();
	public List<CompanyMaster> getCompany(BigDecimal countryId);
	public List<StateMaster> getState(BigDecimal countryId);
	public List<CityMaster> getCity(BigDecimal stateId);
    public List<CountryMaster> getCountry();
    public List<DistrictMaster> getDistrict(BigDecimal stateId);
	public List<StateMaster> getState();*/
	
	//public List<NationalityMaster> getData();
	/*public List<RuleComponentApplication> getApplication();
	public List<RuleComponentScreen> getScreen();*/
	
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
