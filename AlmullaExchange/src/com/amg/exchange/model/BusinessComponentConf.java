package com.amg.exchange.model;

// Generated May 9, 2014 1:16:42 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * FsBusinessComponentConf  Created by Chennai ODC
 */

@Entity
@Table(name = "FS_BUSINESS_COMPONENT_CONF")
public class BusinessComponentConf implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BigDecimal componentConfId;
	private BusinessComponent fsBusinessComponent;
	private RuleApplicationMaster fsRuleApplicationMaster;
	private RulePageMaster fsRulePageMaster;
	private CompanyMaster fsCompanyMaster;
	private CountryMaster fsCountryMaster;
	private BigDecimal levelId;
	private String createdBy;
	private Date createdTime;
	private String updatedBy;
	private Date updatedTime;
	private List<BussComponentConfDetail> fsBussComponentConfDetails = new ArrayList<BussComponentConfDetail>();
	private List<BussComponentComboData> fsBussComponentComboDatas = new ArrayList<BussComponentComboData>();

	public BusinessComponentConf() {
	}

	public BusinessComponentConf(BigDecimal componentConfId,
			Date createdTime, Date updatedTime) {
		this.componentConfId = componentConfId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public BusinessComponentConf(BigDecimal componentConfId,
			BusinessComponent fsBusinessComponent,
			RuleApplicationMaster fsRuleApplicationMaster,
			RulePageMaster fsRulePageMaster, CompanyMaster fsCompanyMaster,
			CountryMaster fsCountryMaster, BigDecimal levelId,
			String createdBy, Date createdTime, String updatedBy,
			Date updatedTime, List<BussComponentConfDetail> fsBussComponentConfDetails,
			List<BussComponentComboData> fsBussComponentComboDatas) {
		this.componentConfId = componentConfId;
		this.fsBusinessComponent = fsBusinessComponent;
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
		this.fsRulePageMaster = fsRulePageMaster;
		this.fsCompanyMaster = fsCompanyMaster;
		this.fsCountryMaster = fsCountryMaster;
		this.levelId = levelId;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.fsBussComponentConfDetails = fsBussComponentConfDetails;
		this.fsBussComponentComboDatas = fsBussComponentComboDatas;
	}

	@Id
	@TableGenerator(name="componentconfid",table="fs_componentconfidpk",pkColumnName="componentconfidkey",pkColumnValue="componentconfidvale",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="componentconfid")
	@Column(name = "COMPONENT_CONF_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentConfId() {
		return this.componentConfId;
	}

	public void setComponentConfId(BigDecimal componentConfId) {
		this.componentConfId = componentConfId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENT_ID")
	public BusinessComponent getFsBusinessComponent() {
		return this.fsBusinessComponent;
	}

	public void setFsBusinessComponent(BusinessComponent fsBusinessComponent) {
		this.fsBusinessComponent = fsBusinessComponent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID")
	public RuleApplicationMaster getFsRuleApplicationMaster() {
		return this.fsRuleApplicationMaster;
	}

	public void setFsRuleApplicationMaster(
			RuleApplicationMaster fsRuleApplicationMaster) {
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID")
	public RulePageMaster getFsRulePageMaster() {
		return this.fsRulePageMaster;
	}

	public void setFsRulePageMaster(RulePageMaster fsRulePageMaster) {
		this.fsRulePageMaster = fsRulePageMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return this.fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@Column(name = "LEVEL_ID", precision = 22, scale = 0)
	public BigDecimal getLevelId() {
		return this.levelId;
	}

	public void setLevelId(BigDecimal levelId) {
		this.levelId = levelId;
	}

	@Column(name = "CREATED_BY", length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_TIME", nullable = false)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Column(name = "UPDATED_BY", length = 30)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_TIME", nullable = false)
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsBusinessComponentConf")
	public List<BussComponentConfDetail> getFsBussComponentConfDetails() {
		return fsBussComponentConfDetails;
	}

	public void setFsBussComponentConfDetails(
			List<BussComponentConfDetail> fsBussComponentConfDetails) {
		this.fsBussComponentConfDetails = fsBussComponentConfDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsBusinessComponentConf")
	public List<BussComponentComboData> getFsBussComponentComboDatas() {
		return fsBussComponentComboDatas;
	}

	public void setFsBussComponentComboDatas(
			List<BussComponentComboData> fsBussComponentComboDatas) {
		this.fsBussComponentComboDatas = fsBussComponentComboDatas;
	}



	
}
