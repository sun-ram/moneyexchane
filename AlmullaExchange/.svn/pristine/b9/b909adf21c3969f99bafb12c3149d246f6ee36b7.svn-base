package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BusinessComponent;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.ComponentType;

public interface IBusinessComponentDao<T>  extends IMutualDao{
	
	public List<ComponentType> getComponentType();
	public void saveOrUpdate(T entity);
	public List<BusinessComponent> getAllBusinessComponent();
	public BussComponentConfDetail getBusinessComponent(String componentName);
	public List<BussComponentComboData> getBusinessComponentDropDownData(BigDecimal componentConfId);
}
