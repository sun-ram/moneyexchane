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

/*******************************************************************************************************************

		 File		: BizComponentDataDesc.java
 
		 Project	: AlmullaExchange

		 Package	: com.amg.exchange.model
 
		 Created	:	
 						Date	: 29-May-2014 3:38:47 pm
		 				By		: Justin Vincent
 						Revision:
 
 		 Last Change:
 						Date	: 29-May-2014 3:38:47 pm
 						By		: Justin Vincent
		 				Revision:

		 Description: TODO 

********************************************************************************************************************/
@SuppressWarnings("serial")
@Entity
@Table(name = "FS_BIZ_COMPONENT_DATA_DESC")
public class BizComponentDataDesc implements java.io.Serializable {

	private BigDecimal componentDataDescId;
	private BizComponentData fsBizComponentData;
	private LanguageType fsLanguageType;
	private String dataDesc;

	public BizComponentDataDesc() {
	}

	public BizComponentDataDesc(BigDecimal componentDataDescId) {
		this.componentDataDescId = componentDataDescId;
	}

	public BizComponentDataDesc(BigDecimal componentDataDescId,
			BizComponentData fsBizComponentData,
			LanguageType fsLanguageType, String dataDesc) {
		this.componentDataDescId = componentDataDescId;
		this.fsBizComponentData = fsBizComponentData;
		this.fsLanguageType = fsLanguageType;
		this.dataDesc = dataDesc;
	}

	@Id
	@TableGenerator(name="componentDataDescId",table="fs_componentDataDescIdpk",pkColumnName="componentDataDescIdkey",pkColumnValue="componentDataDescIdValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="componentDataDescId")
	@Column(name = "COMPONENT_DATA_DESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComponentDataDescId() {
		return this.componentDataDescId;
	}

	public void setComponentDataDescId(BigDecimal componentDataDescId) {
		this.componentDataDescId = componentDataDescId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENT_DATA_ID")
	public BizComponentData getFsBizComponentData() {
		return this.fsBizComponentData;
	}

	public void setFsBizComponentData(BizComponentData fsBizComponentData) {
		this.fsBizComponentData = fsBizComponentData;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "DATA_DESC", length = 200)
	public String getDataDesc() {
		return this.dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}
}
