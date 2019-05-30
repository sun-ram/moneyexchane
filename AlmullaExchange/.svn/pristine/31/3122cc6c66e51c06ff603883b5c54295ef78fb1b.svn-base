package com.amg.exchange.service;

import java.util.List;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.SecurityQuestionMaster;

public interface IUserSignUpService<T>  extends IMutualService<T>{
	
	public List<CustomerLogin>  searchUser(String userName);
	public void saveOnlineUsrData(CustomerLogin signup);
	public List<SecurityQuestionMaster> getQuestions();
	public void updateChangePassword(CustomerLogin customerLogin);
}
