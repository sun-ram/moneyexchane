package com.amg.exchange.dao;

import java.util.List;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.SecurityQuestionMaster;

public interface IUserSignUpDao<T>  extends IMutualDao{
	
	public List<SecurityQuestionMaster> getQuestions();
	public List<CustomerLogin>  searchUser(String userName);
	public void saveOnlineUsrData(CustomerLogin signup);
	public List<SecurityQuestionMaster> getQuestionsComponentId();
	public void updateChangePassword(CustomerLogin customerLogin);
}
