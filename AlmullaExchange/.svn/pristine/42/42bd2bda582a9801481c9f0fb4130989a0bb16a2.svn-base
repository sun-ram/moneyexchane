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
 * FsRuleBusinessNature Created by Chennai ODC
 */
@Entity
@Table(name = "FS_RULE_BUSINESS_NATURE" )
public class RuleBusinessNature implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal natureOfBusinessId;
	private RuleApplicationMaster fsRuleApplicationMaster;
	private String natureOfBusinessDesc;
	private List<CorporateBusinessNature> fsCorporateBusinessNatures = new ArrayList<CorporateBusinessNature>();

	public RuleBusinessNature() {
	}

	public RuleBusinessNature(BigDecimal natureOfBusinessId) {
		this.natureOfBusinessId = natureOfBusinessId;
	}

	public RuleBusinessNature(BigDecimal natureOfBusinessId,
			RuleApplicationMaster fsRuleApplicationMaster,
			String natureOfBusinessDesc, List<CorporateBusinessNature> fsCorporateBusinessNatures) {
		this.natureOfBusinessId = natureOfBusinessId;
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
		this.natureOfBusinessDesc = natureOfBusinessDesc;
		this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
	}

	@Id
	@TableGenerator(name="natureofbusinessid",table="fs_natureofbusinessidpk",pkColumnName="natureofbusinessidkey",pkColumnValue="natureofbusinessidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="natureofbusinessid")
	@Column(name = "NATURE_OF_BUSINESS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getNatureOfBusinessId() {
		return this.natureOfBusinessId;
	}

	public void setNatureOfBusinessId(BigDecimal natureOfBusinessId) {
		this.natureOfBusinessId = natureOfBusinessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID")
	public RuleApplicationMaster getFsRuleApplicationMaster() {
		return this.fsRuleApplicationMaster;
	}

	public void setFsRuleApplicationMaster(
			RuleApplicationMaster fsRuleApplicationMaster) {
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
	}

	@Column(name = "NATURE_OF_BUSINESS_DESC", length = 100)
	public String getNatureOfBusinessDesc() {
		return this.natureOfBusinessDesc;
	}

	public void setNatureOfBusinessDesc(String natureOfBusinessDesc) {
		this.natureOfBusinessDesc = natureOfBusinessDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleBusinessNature")
	public List<CorporateBusinessNature> getFsCorporateBusinessNatures() {
		return this.fsCorporateBusinessNatures;
	}

	public void setFsCorporateBusinessNatures(List<CorporateBusinessNature> fsCorporateBusinessNatures) {
		this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
	}

}
