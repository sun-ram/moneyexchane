package com.amg.exchange.model;

// Generated Apr 8, 2014 6:20:38 PM by Hibernate Tools 3.4.0.CR1

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
 * SecurityQuestionCompDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_SECURITY_QUESTION_COMP_DESC" )
public class SecurityQuestionCompDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal qustCompDescId;
	private SecurityQuestionMaster securityQuestionMaster;
	private SecurityQuestCompMaster securityQuestCompMaster;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date lastUpdatedDate;

	public SecurityQuestionCompDesc() {
	}

	public SecurityQuestionCompDesc(BigDecimal qustCompDescId) {
		this.qustCompDescId = qustCompDescId;
	}

	public SecurityQuestionCompDesc(BigDecimal qustCompDescId,
			SecurityQuestionMaster securityQuestionMaster,
			SecurityQuestCompMaster securityQuestCompMaster,
			String createdBy, Date createdDate, String updatedBy,
			Date lastUpdatedDate) {
		this.qustCompDescId = qustCompDescId;
		this.securityQuestionMaster = securityQuestionMaster;
		this.securityQuestCompMaster = securityQuestCompMaster;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Id
	@TableGenerator(name="qustcompdescid",table="fs_qustcompdescidpk",pkColumnName="qustcompdescidkey",pkColumnValue="qustcompdescidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="qustcompdescid")
	@Column(name = "QUST_COMP_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getQustCompDescId() {
		return this.qustCompDescId;
	}

	public void setQustCompDescId(BigDecimal qustCompDescId) {
		this.qustCompDescId = qustCompDescId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	public SecurityQuestionMaster getFsSecurityQuestionMaster() {
		return this.securityQuestionMaster;
	}

	public void setFsSecurityQuestionMaster(
			SecurityQuestionMaster securityQuestionMaster) {
		this.securityQuestionMaster = securityQuestionMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUST_COMPONENT_ID")
	public SecurityQuestCompMaster getFsSecurityQuestCompMaster() {
		return this.securityQuestCompMaster;
	}

	public void setFsSecurityQuestCompMaster(
			SecurityQuestCompMaster securityQuestCompMaster) {
		this.securityQuestCompMaster = securityQuestCompMaster;
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
