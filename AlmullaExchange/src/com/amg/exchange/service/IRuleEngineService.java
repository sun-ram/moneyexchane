package com.amg.exchange.service;

import java.util.List;

import com.amg.exchange.model.RuleApplicationDesc;
import com.amg.exchange.model.RuleApplicationMaster;
import com.amg.exchange.model.RuleComponent;
import com.amg.exchange.model.RulePageMaster;

public interface IRuleEngineService<T> extends IMutualService<T>, ICommonService<T> {
	
	public List<RulePageMaster> getSavedApplication();
	public void saveRuleComponentDesc(RuleComponent rulecomponent);
	public void saveRuleComponentApplication(RulePageMaster pageMaster);
	public void saveRuleComponentApplicationScreen(RulePageMaster master);
	public void saveRuleComponent(RuleComponent component);
	public List<RuleComponent> getComponentname();
	public List<RuleComponent> getComponentDesc(String compoCode);
	public List<RuleApplicationMaster> getRuleApplicationMaster(String applicationCode);
	public List<RuleApplicationDesc> getRuleApplicationMasterDesc();
	public List<RulePageMaster> getRuleApplicationPage(String pageCode);
}
