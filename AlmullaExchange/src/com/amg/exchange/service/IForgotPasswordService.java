package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.SecurityQuestionMaster;


public interface IForgotPasswordService<T>  extends IMutualService<T>{
	
	public List<CustomerLogin> getCustomerDetail(String username);
	public List<CustomerLogin> getCustomerDetail(String username, String emailid);
	public void setNewPassword(CustomerLogin customerLogin);
	public List<SecurityQuestionMaster> getQuestionMasterDescDetail(BigDecimal languageId, List<BigDecimal> questionMasterId);
}
