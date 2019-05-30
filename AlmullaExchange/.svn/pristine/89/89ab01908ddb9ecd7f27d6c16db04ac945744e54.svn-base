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
 * BussComponentConfDetail  Created by Chennai ODC
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FS_BUSS_COMPONENT_CONF_DETAIL")
public class BussComponentConfDetail implements java.io.Serializable {

	private BigDecimal componentConfDetailId;
	//private BigDecimal componentConfId;
	private BusinessComponentConf fsBusinessComponentConf;
	private String isNumeric;
	private String isAlphabet;
	private String isSpecial;
	private String isRequired;
	private String isReadOnly;
	private String isEnable;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	private String isActive;
	private String createdBy;
	private Date createdTime;
	private String updatedBy;
	private Date updatedTime;

	public BussComponentConfDetail() {
	}

	public BussComponentConfDetail(BigDecimal componentConfDetailId,
			Date createdTime, Date updatedTime) {
		this.componentConfDetailId = componentConfDetailId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public BussComponentConfDetail(BigDecimal componentConfDetailId,
			BigDecimal componentConfId, String isNumeric, String isAlphabet,
			String isSpecial, String isRequired, String isReadOnly,
			String isEnable, BigDecimal minValue, BigDecimal maxValue,
			String isActive, String createdBy, Date createdTime,
			String updatedBy, Date updatedTime, BusinessComponentConf fsBusinessComponentConf) {
		this.componentConfDetailId = componentConfDetailId;
		this.fsBusinessComponentConf = fsBusinessComponentConf;
		this.isNumeric = isNumeric;
		this.isAlphabet = isAlphabet;
		this.isSpecial = isSpecial;
		this.isRequired = isRequired;
		this.isReadOnly = isReadOnly;
		this.isEnable = isEnable;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
	}

	@Id
	@TableGenerator(name="componentConfDetailId",table="fs_componentConfDetailIdpk",pkColumnName="componentConfDetailIdkey",pkColumnValue="componentConfDetailIdvale",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="componentConfDetailId")
	@Column(name = "COMPONENT_CONF_DETAIL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentConfDetailId() {
		return this.componentConfDetailId;
	}

	public void setComponentConfDetailId(BigDecimal componentConfDetailId) {
		this.componentConfDetailId = componentConfDetailId;
	}

/*	@Column(name = "COMPONENT_CONF_ID", precision = 22, scale = 0)
	public BigDecimal getComponentConfId() {
		return this.componentConfId;
	}

	public void setComponentConfId(BigDecimal componentConfId) {
		this.componentConfId = componentConfId;
	}*/

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENT_CONF_ID")
	public BusinessComponentConf getFsBusinessComponentConf() {
		return this.fsBusinessComponentConf;
	}

	public void setFsBusinessComponentConf(
			BusinessComponentConf fsBusinessComponentConf) {
		this.fsBusinessComponentConf = fsBusinessComponentConf;
	}
	@Column(name = "IS_NUMERIC", length = 1)
	public String getIsNumeric() {
		return this.isNumeric;
	}

	public void setIsNumeric(String isNumeric) {
		this.isNumeric = isNumeric;
	}

	@Column(name = "IS_ALPHABET", length = 1)
	public String getIsAlphabet() {
		return this.isAlphabet;
	}

	public void setIsAlphabet(String isAlphabet) {
		this.isAlphabet = isAlphabet;
	}

	@Column(name = "IS_SPECIAL", length = 1)
	public String getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(String isSpecial) {
		this.isSpecial = isSpecial;
	}

	@Column(name = "IS_REQUIRED", length = 1)
	public String getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	@Column(name = "IS_READ_ONLY", length = 1)
	public String getIsReadOnly() {
		return this.isReadOnly;
	}

	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	@Column(name = "IS_ENABLE", length = 1)
	public String getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	@Column(name = "MIN_VALUE", precision = 22, scale = 0)
	public BigDecimal getMinValue() {
		return this.minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	@Column(name = "MAX_VALUE", precision = 22, scale = 0)
	public BigDecimal getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	@Column(name = "IS_ACTIVE", length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

}
