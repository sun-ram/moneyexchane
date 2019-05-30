package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;



public interface IBusinessComponentConfService<T>  extends IMutualService<T>{
	
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId);
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId, BigDecimal applicationId, BigDecimal companyId, BigDecimal countryId, BigDecimal pageId);
	public List<BussComponentComboData> getBusinessComponentDropDownData(BigDecimal componentConfId);
	public void saveOrUpdate(T entity);
	public void delete(T entity);
}
