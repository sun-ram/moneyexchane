package com.amg.exchange.model;

 

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Amlstatus Created by Chennai ODC
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AMLSTATUS" )
public class Amlstatus implements java.io.Serializable {

	private BigDecimal amlstatusId;
	private String remName;
	private String remStatus;

	public Amlstatus() {
	}

	public Amlstatus(BigDecimal amlstatusId) {
		this.amlstatusId = amlstatusId;
	}

	public Amlstatus(BigDecimal amlstatusId, String remName, String remStatus) {
		this.amlstatusId = amlstatusId;
		this.remName = remName;
		this.remStatus = remStatus;
	}

	@Id	
	@TableGenerator(name="amlstatusid",table="fs_amlstatusidpk",pkColumnName="amlstatusidkey",pkColumnValue="amlstatusidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="amlstatusid")
	@Column(name = "AMLSTATUS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAmlstatusId() {
		return this.amlstatusId;
	}

	public void setAmlstatusId(BigDecimal amlstatusId) {
		this.amlstatusId = amlstatusId;
	}

	@Column(name = "REM_NAME", length = 50)
	public String getRemName() {
		return this.remName;
	}

	public void setRemName(String remName) {
		this.remName = remName;
	}

	@Column(name = "REM_STATUS", length = 50)
	public String getRemStatus() {
		return this.remStatus;
	}

	public void setRemStatus(String remStatus) {
		this.remStatus = remStatus;
	}

}
