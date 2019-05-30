package com.amg.exchange.model;

 

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * FsRuleComponent Created by Chennai ODC
 */
@Entity
@Table(name = "FS_RULE_COMPONENT" )
public class RuleComponent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal componentId;
	private RuleApplicationMaster fsRuleApplicationMaster;
	private RulePageMaster fsRulePageMaster;
	private String componentCode;
	private String componentName;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	private String mandatory;
	private String isnumberic;
	private String isalpha;
	private String visibility;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date lastUpdatedDate;

	public RuleComponent() {
	}

	public RuleComponent(BigDecimal componentId) {
		this.componentId = componentId;
	}

	public RuleComponent(BigDecimal componentId,
			RuleApplicationMaster fsRuleApplicationMaster,
			RulePageMaster fsRulePageMaster, String componentCode,
			String componentName, BigDecimal minValue, BigDecimal maxValue,
			String mandatory, String isnumberic, String isalpha,
			String visibility, String createdBy, Date createdDate,
			String updatedBy, Date lastUpdatedDate) {
		this.componentId = componentId;
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
		this.fsRulePageMaster = fsRulePageMaster;
		this.componentCode = componentCode;
		this.componentName = componentName;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.mandatory = mandatory;
		this.isnumberic = isnumberic;
		this.isalpha = isalpha;
		this.visibility = visibility;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Id
	@TableGenerator(name="componentid",table="fs_componentidpk",pkColumnName="componentidkey",pkColumnValue="componentidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="componentid")
	@Column(name = "COMPONENT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentId() {
		return this.componentId;
	}

	public void setComponentId(BigDecimal componentId) {
		this.componentId = componentId;
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

	@Column(name = "COMPONENT_CODE", length = 20)
	public String getComponentCode() {
		return this.componentCode;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	@Column(name = "COMPONENT_NAME", length = 45)
	public String getComponentName() {
		return this.componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@Column(name = "MIN_VALUE", precision = 22, scale = 0)
	public BigDecimal getMinValue() {
		return this.minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	@Column(name = "MAX_VALUE", precision = 22, scale = 0)
	public BigDecimal getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	@Column(name = "MANDATORY", length = 1)
	public String getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	@Column(name = "ISNUMBERIC", length = 1)
	public String getIsnumberic() {
		return this.isnumberic;
	}

	public void setIsnumberic(String isnumberic) {
		this.isnumberic = isnumberic;
	}

	@Column(name = "ISALPHA", length = 1)
	public String getIsalpha() {
		return this.isalpha;
	}

	public void setIsalpha(String isalpha) {
		this.isalpha = isalpha;
	}

	@Column(name = "VISIBILITY", length = 1)
	public String getVisibility() {
		return this.visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@Column(name = "CREATED_BY", length = 45)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY", length = 45)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "LAST_UPDATED_DATE")
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
