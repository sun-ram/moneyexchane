package com.amg.exchange.model;

 

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
 * FsEmploymentType Created by Chennai ODC
 */
@Entity
@Table(name = "FS_EMPLOYMENT_TYPE" )
public class EmploymentType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal employmentTypeId;
	private LanguageType fsLanguageType;
	private String employmentType;
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();

	public EmploymentType() {
	}

	public EmploymentType(BigDecimal employmentTypeId) {
		this.employmentTypeId = employmentTypeId;
	}

	public EmploymentType(BigDecimal employmentTypeId,
			LanguageType fsLanguageType, String employmentType,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.employmentTypeId = employmentTypeId;
		this.fsLanguageType = fsLanguageType;
		this.employmentType = employmentType;
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

	@Id
	@TableGenerator(name="employmenttypeid",table="fs_employmenttypeidpk",pkColumnName="employmenttypeidkey",pkColumnValue="employmenttypeidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="employmenttypeid")
	@Column(name = "EMPLOYMENT_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getEmploymentTypeId() {
		return this.employmentTypeId;
	}

	public void setEmploymentTypeId(BigDecimal employmentTypeId) {
		this.employmentTypeId = employmentTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "EMPLOYMENT_TYPE", length = 50)
	public String getEmploymentType() {
		return this.employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsEmploymentType")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return this.fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}

}
