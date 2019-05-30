package com.amg.exchange.model;

 

import java.math.BigDecimal;

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
 * FsCompanyGroupDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_COMPANY_GROUP_DESC" )
public class CompanyGroupDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal groupDescId;
	private CompanyGroup fsCompanyGroup;
	private LanguageType fsLanguageType;
	private String groupName;

	public CompanyGroupDesc() {
	}

	public CompanyGroupDesc(BigDecimal groupDescId) {
		this.groupDescId = groupDescId;
	}

	public CompanyGroupDesc(BigDecimal groupDescId,
			CompanyGroup fsCompanyGroup, LanguageType fsLanguageType,
			String groupName) {
		this.groupDescId = groupDescId;
		this.fsCompanyGroup = fsCompanyGroup;
		this.fsLanguageType = fsLanguageType;
		this.groupName = groupName;
	}

	@Id
	@TableGenerator(name="groupdescid",table="fs_groupdescidpk",pkColumnName="groupdescidkey",pkColumnValue="groupdescidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="groupdescid")
	@Column(name = "GROUP_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getGroupDescId() {
		return this.groupDescId;
	}

	public void setGroupDescId(BigDecimal groupDescId) {
		this.groupDescId = groupDescId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public CompanyGroup getFsCompanyGroup() {
		return this.fsCompanyGroup;
	}

	public void setFsCompanyGroup(CompanyGroup fsCompanyGroup) {
		this.fsCompanyGroup = fsCompanyGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "GROUP_NAME", length = 50)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
