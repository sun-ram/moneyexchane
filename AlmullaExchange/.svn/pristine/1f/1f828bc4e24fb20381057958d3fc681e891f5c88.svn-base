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
 * FsSecurityQuestionMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_SECURITY_QUESTION_MASTER" )
public class SecurityQuestionMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal questionId;
	private RuleApplicationMaster fsRuleApplicationMaster;
	private LanguageType fsLanguageType;
	private String active;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date lastUpdatedDate;
	private String questionDesc;

	public SecurityQuestionMaster() {
	}

	public SecurityQuestionMaster(BigDecimal questionId) {
		this.questionId = questionId;
	}

	public SecurityQuestionMaster(BigDecimal questionId,
			RuleApplicationMaster fsRuleApplicationMaster,
			LanguageType fsLanguageType, String active, String createdBy,
			Date createdDate, String updatedBy,
			Date lastUpdatedDate, String questionDesc) {
		this.questionId = questionId;
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
		this.fsLanguageType = fsLanguageType;
		this.active = active;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.questionDesc = questionDesc;
	}

	@Id
	@TableGenerator(name="questionid",table="fs_questionidpk",pkColumnName="questionidkey",pkColumnValue="questionidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="questionid")
	@Column(name = "QUESTION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(BigDecimal questionId) {
		this.questionId = questionId;
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
	@JoinColumn(name = "LANUGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "ACTIVE", length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
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

	@Column(name = "QUESTION_DESC", length = 200)
	public String getQuestionDesc() {
		return this.questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

}
