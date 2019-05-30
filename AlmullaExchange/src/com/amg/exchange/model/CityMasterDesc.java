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
 * FsCityMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CITY_MASTER_DESC" )
public class CityMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal cityMasterId;
	private LanguageType fsLanguageType;
	private CityMaster fsCityMaster;
	private String cityName;

	public CityMasterDesc() {
	}

	public CityMasterDesc(BigDecimal cityMasterId) {
		this.cityMasterId = cityMasterId;
	}

	public CityMasterDesc(BigDecimal cityMasterId,
			LanguageType fsLanguageType, CityMaster fsCityMaster,
			String cityName) {
		this.cityMasterId = cityMasterId;
		this.fsLanguageType = fsLanguageType;
		this.fsCityMaster = fsCityMaster;
		this.cityName = cityName;
	}

	@Id
	@TableGenerator(name="citymasterid",table="fs_citymasteridpk",pkColumnName="citymasteridkey",pkColumnValue="citymasteridvale",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="citymasterid")
	@Column(name = "CITY_MASTER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCityMasterId() {
		return this.cityMasterId;
	}

	public void setCityMasterId(BigDecimal cityMasterId) {
		this.cityMasterId = cityMasterId;
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
	@JoinColumn(name = "CITY_ID")
	public CityMaster getFsCityMaster() {
		return this.fsCityMaster;
	}

	public void setFsCityMaster(CityMaster fsCityMaster) {
		this.fsCityMaster = fsCityMaster;
	}

	@Column(name = "CITY_NAME", length = 45)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}