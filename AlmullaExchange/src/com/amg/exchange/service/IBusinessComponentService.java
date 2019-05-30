package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.BusinessComponent;
import com.amg.exchange.model.BussComponentComboData;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.ComponentType;


public interface IBusinessComponentService<T>  extends IMutualService<T>{
	
	public List<ComponentType> getComponentType();
	public void saveOrUpdate(T entity);
	public List<BusinessComponent> getAllBusinessComponent();
	public BussComponentConfDetail getBusinessComponent(String componentName);
	public List<BussComponentComboData> getBusinessComponentDropDownData(BigDecimal componentConfId);
}
