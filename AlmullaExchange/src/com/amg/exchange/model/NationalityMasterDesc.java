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
 * FsNationalityMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_NATIONALITY_MASTER_DESC" )
public class NationalityMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal nationalityMasterId;
	private LanguageType fsLanguageType;
	private NationalityMaster fsNationalityMaster;
	private String nationalityName;

	public NationalityMasterDesc() {
	}

	public NationalityMasterDesc(BigDecimal nationalityMasterId) {
		this.nationalityMasterId = nationalityMasterId;
	}

	public NationalityMasterDesc(BigDecimal nationalityMasterId,
			LanguageType fsLanguageType,
			NationalityMaster fsNationalityMaster, String nationalityName) {
		this.nationalityMasterId = nationalityMasterId;
		this.fsLanguageType = fsLanguageType;
		this.fsNationalityMaster = fsNationalityMaster;
		this.nationalityName = nationalityName;
	}
	
	@Id
	@TableGenerator(name="nationalitymasterid",table="fs_nationalitymasteridpk",pkColumnName="nationalitymasteridkey",pkColumnValue="nationalitymasteridvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="nationalitymasterid")
	@Column(name = "NATIONALITY_MASTER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getNationalityMasterId() {
		return this.nationalityMasterId;
	}

	public void setNationalityMasterId(BigDecimal nationalityMasterId) {
		this.nationalityMasterId = nationalityMasterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NATIONALITY_ID")
	public NationalityMaster getFsNationalityMaster() {
		return this.fsNationalityMaster;
	}

	public void setFsNationalityMaster(NationalityMaster fsNationalityMaster) {
		this.fsNationalityMaster = fsNationalityMaster;
	}

	@Column(name = "NATIONALITY_NAME", length = 45)
	public String getNationalityName() {
		return this.nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

}
