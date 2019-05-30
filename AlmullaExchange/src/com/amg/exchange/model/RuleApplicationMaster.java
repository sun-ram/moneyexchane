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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * RuleApplicationMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_RULE_APPLICATION_MASTER")
public class RuleApplicationMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal applicationId;
	private String applicationCode;
	private String applicationName;
	private List<RuleComponent> fsRuleComponents = new ArrayList<RuleComponent>();
	private List<RuleBusinessNature> fsRuleBusinessNatures = new ArrayList<RuleBusinessNature>();
	private List<RulePageMaster> fsRulePageMasters = new ArrayList<RulePageMaster>();
	private List<RuleObjective> fsRuleObjectives = new ArrayList<RuleObjective>();
	private List<SecurityQuestionMaster> fsSecurityQuestionMasters = new ArrayList<SecurityQuestionMaster>();
	private List<RuleApplicationDesc> fsRuleApplicationDescs = new ArrayList<RuleApplicationDesc>();
	private List<BusinessComponentConf> fsBusinessComponentConfs = new ArrayList<BusinessComponentConf>();

	// private List<RuleComponent> fsRuleComboxComponents = new
	// ArrayList<RuleComboxComponent>();

	public RuleApplicationMaster() {
	}

	public RuleApplicationMaster(BigDecimal applicationId) {
		this.applicationId = applicationId;
	}

	public RuleApplicationMaster(BigDecimal applicationId,
			String applicationCode, String applicationName,
			List<RuleComponent> fsRuleComponents,
			List<RuleBusinessNature> fsRuleBusinessNatures,
			List<RulePageMaster> fsRulePageMasters,
			List<RuleObjective> fsRuleObjectives,
			List<SecurityQuestionMaster> fsSecurityQuestionMasters,
			List<RuleApplicationDesc> fsRuleApplicationDescs,
			List<BusinessComponentConf> fsBusinessComponentConfs) {
		this.applicationId = applicationId;
		this.applicationCode = applicationCode;
		this.applicationName = applicationName;
		this.fsRuleComponents = fsRuleComponents;
		this.fsRuleBusinessNatures = fsRuleBusinessNatures;
		this.fsRulePageMasters = fsRulePageMasters;
		this.fsRuleObjectives = fsRuleObjectives;
		this.fsSecurityQuestionMasters = fsSecurityQuestionMasters;
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
	}

	@Id
	@TableGenerator(name = "applicationid", table = "fs_applicationidpk", pkColumnName = "applicationidkey", pkColumnValue = "applicationidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "applicationid")
	@Column(name = "APPLICATION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(BigDecimal applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "APPLICATION_CODE", length = 10)
	public String getApplicationCode() {
		return this.applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	@Column(name = "APPLICATION_NAME", length = 45)
	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<RuleComponent> getFsRuleComponents() {
		return this.fsRuleComponents;
	}

	public void setFsRuleComponents(List<RuleComponent> fsRuleComponents) {
		this.fsRuleComponents = fsRuleComponents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<RuleBusinessNature> getFsRuleBusinessNatures() {
		return this.fsRuleBusinessNatures;
	}

	public void setFsRuleBusinessNatures(
			List<RuleBusinessNature> fsRuleBusinessNatures) {
		this.fsRuleBusinessNatures = fsRuleBusinessNatures;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<RulePageMaster> getFsRulePageMasters() {
		return this.fsRulePageMasters;
	}

	public void setFsRulePageMasters(List<RulePageMaster> fsRulePageMasters) {
		this.fsRulePageMasters = fsRulePageMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<RuleObjective> getFsRuleObjectives() {
		return this.fsRuleObjectives;
	}

	public void setFsRuleObjectives(List<RuleObjective> fsRuleObjectives) {
		this.fsRuleObjectives = fsRuleObjectives;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<SecurityQuestionMaster> getFsSecurityQuestionMasters() {
		return this.fsSecurityQuestionMasters;
	}

	public void setFsSecurityQuestionMasters(
			List<SecurityQuestionMaster> fsSecurityQuestionMasters) {
		this.fsSecurityQuestionMasters = fsSecurityQuestionMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<RuleApplicationDesc> getFsRuleApplicationDescs() {
		return this.fsRuleApplicationDescs;
	}

	public void setFsRuleApplicationDescs(
			List<RuleApplicationDesc> fsRuleApplicationDescs) {
		this.fsRuleApplicationDescs = fsRuleApplicationDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleApplicationMaster")
	public List<BusinessComponentConf> getFsBusinessComponentConfs() {
		return fsBusinessComponentConfs;
	}

	public void setFsBusinessComponentConfs(
			List<BusinessComponentConf> fsBusinessComponentConfs) {
		this.fsBusinessComponentConfs = fsBusinessComponentConfs;
	}

}
