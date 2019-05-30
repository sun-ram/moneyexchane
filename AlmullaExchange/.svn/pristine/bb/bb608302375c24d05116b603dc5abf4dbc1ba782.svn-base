package com.amg.exchange.model;

// Generated Apr 8, 2014 6:20:38 PM by Hibernate Tools 3.4.0.CR1

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
 * CountryMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_COUNTRY_MASTER_DESC" )
public class CountryMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal countryMasterId;
	private LanguageType fsLanguageType;
	private CountryMaster fsCountryMaster;
	private String countryName;
	private String nationality;

	public CountryMasterDesc() {
	}

	public CountryMasterDesc(BigDecimal countryMasterId) {
		this.countryMasterId = countryMasterId;
	}

	public CountryMasterDesc(BigDecimal countryMasterId,
			LanguageType fsLanguageType, CountryMaster fsCountryMaster,
			String countryName, String nationality) {
		this.countryMasterId = countryMasterId;
		this.fsLanguageType = fsLanguageType;
		this.fsCountryMaster = fsCountryMaster;
		this.countryName = countryName;
		this.nationality = nationality;
	}

	@Id
	@TableGenerator(name = "countrymasterid", table = "fs_countrymasteridpk", pkColumnName = "countrymasteridkey", pkColumnValue = "countrymasteridvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "countrymasterid")
	@Column(name = "COUNTRY_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCountryMasterId() {
		return this.countryMasterId;
	}

	public void setCountryMasterId(BigDecimal countryMasterId) {
		this.countryMasterId = countryMasterId;
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
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@Column(name = "COUNTRY_NAME", length = 45)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Column(name = "NATIONALITY", length = 50)
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
