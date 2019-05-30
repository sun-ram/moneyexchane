package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;


public interface IBusinessComponentConfDao<T>  extends IMutualDao{
	
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId);
	public BussComponentConfDetail getBusinessComponent(BigDecimal componentId, BigDecimal applicationId, BigDecimal companyId, BigDecimal countryId, BigDecimal pageId);
	public List<BussComponentComboData> getBusinessComponentDropDownData(BigDecimal componentConfId);
	public void saveOrUpdate(T entity);
	public void delete(T entity);
}
