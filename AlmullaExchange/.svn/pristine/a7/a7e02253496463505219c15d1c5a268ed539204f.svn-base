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
 * SecurityQuesMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_SECURITY_QUES_MASTER_DESC" )
public class SecurityQuesMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal secuQuestDescId;
	private SecurityQuestionMaster securityQuestionMaster;
	private LanguageType languageType;
	private String questionDescription;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date lastUpdatedDate;

	public SecurityQuesMasterDesc() {
	}

	public SecurityQuesMasterDesc(BigDecimal secuQuestDescId) {
		this.secuQuestDescId = secuQuestDescId;
	}

	public SecurityQuesMasterDesc(BigDecimal secuQuestDescId,
			SecurityQuestionMaster securityQuestionMaster,
			LanguageType languageType, String questionDescription,
			String createdBy, Date createdDate, String updatedBy,
			Date lastUpdatedDate) {
		this.secuQuestDescId = secuQuestDescId;
		this.securityQuestionMaster = securityQuestionMaster;
		this.languageType = languageType;
		this.questionDescription = questionDescription;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Id
	@TableGenerator(name="secuquestdescid",table="fs_secuquestdescidpk",pkColumnName="secuquestdescidkey",pkColumnValue="secuquestdescidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="secuquestdescid")
	@Column(name = "SECU_QUEST_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSecuQuestDescId() {
		return this.secuQuestDescId;
	}

	public void setSecuQuestDescId(BigDecimal secuQuestDescId) {
		this.secuQuestDescId = secuQuestDescId;
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
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.languageType;
	}

	public void setFsLanguageType(LanguageType languageType) {
		this.languageType = languageType;
	}

	@Column(name = "QUESTION_DESCRIPTION", length = 200)
	public String getQuestionDescription() {
		return this.questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
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
