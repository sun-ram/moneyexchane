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
 * FsDistrictMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_DISTRICT_MASTER_DESC" )
public class DistrictMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal districtDescId;
	private DistrictMaster fsDistrictMaster;
	private LanguageType fsLanguageType;
	private String district;

	public DistrictMasterDesc() {
	}

	public DistrictMasterDesc(BigDecimal districtDescId) {
		this.districtDescId = districtDescId;
	}

	public DistrictMasterDesc(BigDecimal districtDescId,
			DistrictMaster fsDistrictMaster, LanguageType fsLanguageType,
			String district) {
		this.districtDescId = districtDescId;
		this.fsDistrictMaster = fsDistrictMaster;
		this.fsLanguageType = fsLanguageType;
		this.district = district;
	}

	@Id
	@TableGenerator(name="districtdescid",table="fs_districtdescidpk",pkColumnName="districtdescidkey",pkColumnValue="districtdescidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="districtdescid")
	@Column(name = "DISTRICT_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDistrictDescId() {
		return this.districtDescId;
	}

	public void setDistrictDescId(BigDecimal districtDescId) {
		this.districtDescId = districtDescId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	public DistrictMaster getFsDistrictMaster() {
		return this.fsDistrictMaster;
	}

	public void setFsDistrictMaster(DistrictMaster fsDistrictMaster) {
		this.fsDistrictMaster = fsDistrictMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "DISTRICT", length = 100)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
