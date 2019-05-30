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
 * FsCorporateBusinessNature Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CORPORATE_BUSINESS_NATURE" )
public class CorporateBusinessNature implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal corporateBusinessId;
	private RuleBusinessNature fsRuleBusinessNature;
	private Customer fsCustomer;
	//private RuleObjective fsRuleObjective;
	private String objectiveType;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private String businessStatus;

	public CorporateBusinessNature() {
	}

	public CorporateBusinessNature(BigDecimal corporateBusinessId) {
		this.corporateBusinessId = corporateBusinessId;
	}

	public CorporateBusinessNature(BigDecimal corporateBusinessId,
			RuleBusinessNature fsRuleBusinessNature, Customer fsCustomer,
			 String createdBy,
			String updatedBy, Date creationDate,
			Date lastUpdated,String businessStatus) {
		this.corporateBusinessId = corporateBusinessId;
		this.fsRuleBusinessNature = fsRuleBusinessNature;
		this.fsCustomer = fsCustomer;
		//this.fsRuleObjective = fsRuleObjective;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.businessStatus=businessStatus;
	}

	@Id
	@TableGenerator(name="corporatebusinessid",table="fs_corporatebusinessidpk",pkColumnName="corporatebusinessidkey",pkColumnValue="corporatebusinessidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="corporatebusinessid")
	@Column(name = "CORPORATE_BUSINESS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCorporateBusinessId() {
		return this.corporateBusinessId;
	}

	public void setCorporateBusinessId(BigDecimal corporateBusinessId) {
		this.corporateBusinessId = corporateBusinessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NATURE_OF_BUSINESS_ID")
	public RuleBusinessNature getFsRuleBusinessNature() {
		return this.fsRuleBusinessNature;
	}

	public void setFsRuleBusinessNature(
			RuleBusinessNature fsRuleBusinessNature) {
		this.fsRuleBusinessNature = fsRuleBusinessNature;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getFsCustomer() {
		return this.fsCustomer;
	}

	public void setFsCustomer(Customer fsCustomer) {
		this.fsCustomer = fsCustomer;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTIVE_ID")
	public RuleObjective getFsRuleObjective() {
		return this.fsRuleObjective;
	}

	public void setFsRuleObjective(RuleObjective fsRuleObjective) {
		this.fsRuleObjective = fsRuleObjective;
	}*/

	@Column(name = "CREATED_BY", length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY", length = 30)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "CREATION_DATE")
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "LAST_UPDATED")
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "OBJECTIVE_TYPE", length = 50)
	public String getObjectiveType() {
		return objectiveType;
	}

	public void setObjectiveType(String objectiveType) {
		this.objectiveType = objectiveType;
	}
	@Column(name = "BUSINESS_STATUS", length = 1)
	public String getBusinessStatus() {
		return this.businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}
	

}
