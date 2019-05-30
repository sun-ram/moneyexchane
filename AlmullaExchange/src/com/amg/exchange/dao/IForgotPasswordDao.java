package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.SecurityQuestionMaster;


public interface IForgotPasswordDao<T>  extends IMutualDao{
	
	public List<CustomerLogin> getCustomerDetail(String username);
	public List<CustomerLogin> getCustomerDetail(String username, String emailid);
	public void setNewPassword(CustomerLogin customerLogin);
	public List<SecurityQuestionMaster> getQuestionMasterDescDetail(BigDecimal languageId, List<BigDecimal> questionMasterId);
}
