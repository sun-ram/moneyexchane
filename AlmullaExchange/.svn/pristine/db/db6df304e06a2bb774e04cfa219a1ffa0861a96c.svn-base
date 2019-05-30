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
 * FsRuleObjective Created by Chennai ODC
 */
@Entity
@Table(name = "FS_RULE_OBJECTIVE" )
public class RuleObjective implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal objectiveId;
	private RuleApplicationMaster fsRuleApplicationMaster;
	private LanguageType fsLanguageType;
	private String objectiveDesc;
	private List<CustCorporateAddlDetail> fsCustCorporateAddlDetails = new ArrayList<CustCorporateAddlDetail>();
	private List<Customer> fsCustomers = new ArrayList<Customer>();
	//private List<CorporateBusinessNature> fsCorporateBusinessNatures = new ArrayList<CorporateBusinessNature>();

	public RuleObjective() {
	}

	public RuleObjective(BigDecimal objectiveId) {
		this.objectiveId = objectiveId;
	}

	public RuleObjective(BigDecimal objectiveId,
			RuleApplicationMaster fsRuleApplicationMaster,
			LanguageType fsLanguageType, String objectiveDesc,
			List<CustCorporateAddlDetail> fsCustCorporateAddlDetails, List<Customer> fsCustomers) {
		this.objectiveId = objectiveId;
		this.fsRuleApplicationMaster = fsRuleApplicationMaster;
		this.fsLanguageType = fsLanguageType;
		this.objectiveDesc = objectiveDesc;
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
		this.fsCustomers = fsCustomers;
		//this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
	}

	@Id
	@TableGenerator(name="objectiveid",table="fs_objectiveidpk",pkColumnName="objectiveidkey",pkColumnValue="objectiveidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="objectiveid")
	@Column(name = "OBJECTIVE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getObjectiveId() {
		return this.objectiveId;
	}

	public void setObjectiveId(BigDecimal objectiveId) {
		this.objectiveId = objectiveId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "OBJECTIVE_DESC", length = 100)
	public String getObjectiveDesc() {
		return this.objectiveDesc;
	}

	public void setObjectiveDesc(String objectiveDesc) {
		this.objectiveDesc = objectiveDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleObjective")
	public List<CustCorporateAddlDetail> getFsCustCorporateAddlDetails() {
		return this.fsCustCorporateAddlDetails;
	}

	public void setFsCustCorporateAddlDetails(List<CustCorporateAddlDetail> fsCustCorporateAddlDetails) {
		this.fsCustCorporateAddlDetails = fsCustCorporateAddlDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleObjective")
	public List<Customer> getFsCustomers() {
		return this.fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsRuleObjective")
	public List<CorporateBusinessNature> getFsCorporateBusinessNatures() {
		return this.fsCorporateBusinessNatures;
	}

	public void setFsCorporateBusinessNatures(List<CorporateBusinessNature> fsCorporateBusinessNatures) {
		this.fsCorporateBusinessNatures = fsCorporateBusinessNatures;
	}*/

}
