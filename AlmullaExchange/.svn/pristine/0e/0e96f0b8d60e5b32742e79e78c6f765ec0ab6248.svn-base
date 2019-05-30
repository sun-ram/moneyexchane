package com.amg.exchange.model;

// Generated Apr 8, 2014 6:20:38 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * SecurityQuestCompMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_SECURITY_QUEST_COMP_MASTER" )
public class SecurityQuestCompMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal qustComponentId;
	private RuleApplicationMaster ruleApplicationMaster;
	private RulePageMaster rulePageMaster;
	private String componentName;
	private List<SecurityQuestionCompDesc> fsSecurityQuestionCompDescs = new ArrayList<SecurityQuestionCompDesc>();

	public SecurityQuestCompMaster() {
	}

	public SecurityQuestCompMaster(BigDecimal qustComponentId) {
		this.qustComponentId = qustComponentId;
	}

	public SecurityQuestCompMaster(BigDecimal qustComponentId,
			RuleApplicationMaster ruleApplicationMaster,
			RulePageMaster rulePageMaster, String componentName,
			List<SecurityQuestionCompDesc> fsSecurityQuestionCompDescs) {
		this.qustComponentId = qustComponentId;
		this.ruleApplicationMaster = ruleApplicationMaster;
		this.rulePageMaster = rulePageMaster;
		this.componentName = componentName;
		this.fsSecurityQuestionCompDescs = fsSecurityQuestionCompDescs;
	}

	@Id
	@TableGenerator(name="qustcomponentid",table="fs_qustcomponentidpk",pkColumnName="qustcomponentidkey",pkColumnValue="qustcomponentidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="qustcomponentid")
	@Column(name = "QUST_COMPONENT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getQustComponentId() {
		return this.qustComponentId;
	}

	public void setQustComponentId(BigDecimal qustComponentId) {
		this.qustComponentId = qustComponentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID")
	public RuleApplicationMaster getFsRuleApplicationMaster() {
		return this.ruleApplicationMaster;
	}

	public void setFsRuleApplicationMaster(
			RuleApplicationMaster ruleApplicationMaster) {
		this.ruleApplicationMaster = ruleApplicationMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID")
	public RulePageMaster getFsRulePageMaster() {
		return this.rulePageMaster;
	}

	public void setFsRulePageMaster(RulePageMaster rulePageMaster) {
		this.rulePageMaster = rulePageMaster;
	}

	@Column(name = "COMPONENT_NAME", length = 45)
	public String getComponentName() {
		return this.componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsSecurityQuestCompMaster")
	public List<SecurityQuestionCompDesc> getFsSecurityQuestionCompDescs() {
		return this.fsSecurityQuestionCompDescs;
	}

	public void setFsSecurityQuestionCompDescs(List<SecurityQuestionCompDesc> fsSecurityQuestionCompDescs) {
		this.fsSecurityQuestionCompDescs = fsSecurityQuestionCompDescs;
	}

}
