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
 * FsStateMasterDesc Created by Chennai ODC
 */
@Entity
@Table(name = "FS_STATE_MASTER_DESC" )
public class StateMasterDesc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal stateDescId;
	private StateMaster fsStateMaster;
	private LanguageType fsLanguageType;
	private String stateName;

	public StateMasterDesc() {
	}

	public StateMasterDesc(BigDecimal stateDescId) {
		this.stateDescId = stateDescId;
	}

	public StateMasterDesc(BigDecimal stateDescId,
			StateMaster fsStateMaster, LanguageType fsLanguageType,
			String stateName) {
		this.stateDescId = stateDescId;
		this.fsStateMaster = fsStateMaster;
		this.fsLanguageType = fsLanguageType;
		this.stateName = stateName;
	}

	@Id
	@TableGenerator(name="statedescid",table="fs_statedescidpk",pkColumnName="statedescidkey",pkColumnValue="statedescidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="statedescid")
	@Column(name = "STATE_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getStateDescId() {
		return this.stateDescId;
	}

	public void setStateDescId(BigDecimal stateDescId) {
		this.stateDescId = stateDescId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	public StateMaster getFsStateMaster() {
		return this.fsStateMaster;
	}

	public void setFsStateMaster(StateMaster fsStateMaster) {
		this.fsStateMaster = fsStateMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "STATE_NAME", length = 45)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
