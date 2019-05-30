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
 * FsCustCorporateAddlDetail Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUST_CORPORATE_ADDL_DETAIL" )
public class CustCorporateAddlDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal corpAddlId;
	private RuleObjective fsRuleObjective;
	private LanguageType fsLanguageType;
	private Customer fsCustomer;
	//private BigDecimal customerId;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private String addlStatus;

	public CustCorporateAddlDetail() {
	}

	public CustCorporateAddlDetail(BigDecimal corpAddlId) {
		this.corpAddlId = corpAddlId;
	}

	public CustCorporateAddlDetail(BigDecimal corpAddlId,
			RuleObjective fsRuleObjective, LanguageType fsLanguageType, Customer fsCustomer,
			/*BigDecimal customerId,*/ String createdBy, String updatedBy,
			Date creationDate, Date lastUpdated,String addlStatus) {
		this.corpAddlId = corpAddlId;
		this.fsRuleObjective = fsRuleObjective;
		this.fsLanguageType = fsLanguageType;
		//this.customerId = customerId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this. fsCustomer =fsCustomer;
		this.addlStatus=addlStatus;
	}

	@Id
	@TableGenerator(name="corpaddlid",table="fs_corpaddlidpk",pkColumnName="corpaddlidkey",pkColumnValue="corpaddlidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="corpaddlid")
	@Column(name = "CORP_ADDL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCorpAddlId() {
		return this.corpAddlId;
	}

	public void setCorpAddlId(BigDecimal corpAddlId) {
		this.corpAddlId = corpAddlId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTIVE_ID")
	public RuleObjective getFsRuleObjective() {
		return this.fsRuleObjective;
	}

	public void setFsRuleObjective(RuleObjective fsRuleObjective) {
		this.fsRuleObjective = fsRuleObjective;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	/*@Column(name = "CUSTOMER_ID", precision = 22, scale = 0)
	public BigDecimal getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getFsCustomer() {
		return fsCustomer;
	}

	public void setFsCustomer(Customer fsCustomer) {
		this.fsCustomer = fsCustomer;
	}

	@Column(name = "ADDL_STATUS", length = 1)
	public String getAddlStatus() {
		return this.addlStatus;
	}

	public void setAddlStatus(String addlStatus) {
		this.addlStatus = addlStatus;
	}
}
