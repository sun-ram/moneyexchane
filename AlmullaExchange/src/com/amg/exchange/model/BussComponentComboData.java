package com.amg.exchange.model;

// Generated May 8, 2014 7:33:34 PM by Hibernate Tools 3.4.0.CR1

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
 * BussComponentComboData  Created by Chennai ODC
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "FS_BUSS_COMPONENT_COMBO_DATA")
public class BussComponentComboData implements java.io.Serializable {

	
	
	private BigDecimal componentComboDataId;
	private BusinessComponentConf fsBusinessComponentConf;
	private String componentData;
	private String createdBy;
	private Date createdTime;
	private String updatedBy;
	private Date updatedTime;
	private String active;
	private LanguageType fsLanguageType;

	public BussComponentComboData() {
	}

	public BussComponentComboData(BigDecimal componentComboDataId,
			BigDecimal componentConfId, Date createdTime,
			Date updatedTime) {
		this.componentComboDataId = componentComboDataId;
		
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		
	}

	public BussComponentComboData(BigDecimal componentComboDataId,
			BigDecimal componentConfId, String componentData, String createdBy,
			Date createdTime, String updatedBy, Date updatedTime,BusinessComponentConf fsBusinessComponentConf,String active, LanguageType fsLanguageType ) {
		this.componentComboDataId = componentComboDataId;
		this.fsBusinessComponentConf = fsBusinessComponentConf;
		this.componentData = componentData;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.active=active;
		this.fsLanguageType=fsLanguageType;
	}

	@Id
	@TableGenerator(name="componentcombodataid",table="fs_componentcombodataidpk",pkColumnName="componentcombodataidkey",pkColumnValue="componentcombodataidvale",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="componentcombodataid")
	@Column(name = "COMPONENT_COMBO_DATA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentComboDataId() {
		return this.componentComboDataId;
	}

	public void setComponentComboDataId(BigDecimal componentComboDataId) {
		this.componentComboDataId = componentComboDataId;
	}

/*	@Column(name = "COMPONENT_CONF_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentConfId() {
		return this.componentConfId;
	}

	public void setComponentConfId(BigDecimal componentConfId) {
		this.componentConfId = componentConfId;
	}*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENT_CONF_ID", nullable = false)
	public BusinessComponentConf getFsBusinessComponentConf() {
		return this.fsBusinessComponentConf;
	}

	public void setFsBusinessComponentConf(
			BusinessComponentConf fsBusinessComponentConf) {
		this.fsBusinessComponentConf = fsBusinessComponentConf;
	}
	@Column(name = "COMPONENT_DATA", length = 50)
	public String getComponentData() {
		return this.componentData;
	}

	public void setComponentData(String componentData) {
		this.componentData = componentData;
	}

	@Column(name = "CREATED_BY", length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_TIME", nullable = false)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Column(name = "UPDATED_BY", length = 30)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_TIME", nullable = false)
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	@Column(name = "ACTIVE", length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

}
