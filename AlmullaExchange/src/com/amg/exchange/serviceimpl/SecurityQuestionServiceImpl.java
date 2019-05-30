package com.amg.exchange.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.dao.ISecurityQuestionsDao;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.service.ISecurityQuestionService;

@Service("securityQuestions")
public class SecurityQuestionServiceImpl implements ISecurityQuestionService<SecurityQuestionMaster>   {

    @Autowired (required=true)
    private ISecurityQuestionsDao<SecurityQuestionMaster> securityQuestionDao;
    
	public ISecurityQuestionsDao<SecurityQuestionMaster> getSecurityQuestionDao() {
		return securityQuestionDao;
	}

	public void setSecurityQuestionDao(ISecurityQuestionsDao<SecurityQuestionMaster> securityQuestionDao) {
		this.securityQuestionDao = securityQuestionDao;
	}

	@Override
	@Transactional
	public void save(SecurityQuestionMaster entity) {
		getSecurityQuestionDao().save(entity);
	}

	@Override
	@Transactional
	public void update(SecurityQuestionMaster entity) {
	   getSecurityQuestionDao().update(entity);
	}

	@Override
	@Transactional
	public void delete(SecurityQuestionMaster entity) {
		getSecurityQuestionDao().delete(entity);
	}
}
