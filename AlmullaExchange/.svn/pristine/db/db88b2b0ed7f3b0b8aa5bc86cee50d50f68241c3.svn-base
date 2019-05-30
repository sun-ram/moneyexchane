package com.amg.exchange.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * FsStateMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_STATE_MASTER")
public class StateMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal stateId;
	private Short stateCode;
	private CountryMaster fsCountryMaster;
	private String stateActive;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private List<StateMasterDesc> fsStateMasterDescs = new ArrayList<StateMasterDesc>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<DistrictMaster> fsDistrictMasters = new ArrayList<DistrictMaster>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<BankBranch> exBankBranches = new ArrayList<BankBranch>();
	private List<BankDdPrintLoc> exBankDdPrintLocs = new ArrayList<BankDdPrintLoc>();
	private List<BankMaster> exBankMasters = new ArrayList<BankMaster>();

	/*
	 * private Set exBankDdPrintLocs = new HashSet(0); private Set
	 * exBankBranches = new HashSet(0); private Set exBankMasters = new
	 * HashSet(0);
	 */

	public StateMaster() {
	}

	public StateMaster(BigDecimal stateId) {
		this.stateId = stateId;
	}

	public StateMaster(BigDecimal stateId, Short stateCode,
			CountryMaster fsCountryMaster, String stateActive,
			String createdBy, String updatedBy, Date creationDate,
			List<ContactDetail> fsContactDetails, Date lastUpdated,
			List<StateMasterDesc> fsStateMasterDescs,
			List<DistrictMaster> fsDistrictMasters,
			List<BankBranch> exBankBranches,
			List<BankDdPrintLoc> exBankDdPrintLocs,
			List<BankMaster> exBankMasters,List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.stateId = stateId;
		this.stateCode = stateCode;
		this.stateActive = stateActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsStateMasterDescs = fsStateMasterDescs;
		this.fsContactDetails = fsContactDetails;
		this.fsDistrictMasters = fsDistrictMasters;
		this.fsCountryMaster = fsCountryMaster;
		this.exBankBranches = exBankBranches;
		this.exBankDdPrintLocs = exBankDdPrintLocs;
		this.exBankMasters = exBankMasters;
		this.fsCustomerEmploymentInfos=fsCustomerEmploymentInfos;
	}

	@Id
	@TableGenerator(name = "stateid", table = "fs_stateidpk", pkColumnName = "stateidkey", pkColumnValue = "stateidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "stateid")
	@Column(name = "STATE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getStateId() {
		return this.stateId;
	}

	public void setStateId(BigDecimal stateId) {
		this.stateId = stateId;
	}

	@Column(name = "STATE_CODE", precision = 3, scale = 0)
	public Short getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(Short stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "STATE_ACTIVE", length = 1)
	public String getStateActive() {
		return this.stateActive;
	}

	public void setStateActive(String stateActive) {
		this.stateActive = stateActive;
	}

	@Column(name = "CREATED_BY", length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY", length = 30)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "CREATION_DATE")
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "LAST_UPDATED")
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<StateMasterDesc> getFsStateMasterDescs() {
		return this.fsStateMasterDescs;
	}

	public void setFsStateMasterDescs(List<StateMasterDesc> fsStateMasterDescs) {
		this.fsStateMasterDescs = fsStateMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<DistrictMaster> getFsDistrictMasters() {
		return fsDistrictMasters;
	}

	public void setFsDistrictMasters(List<DistrictMaster> fsDistrictMasters) {
		this.fsDistrictMasters = fsDistrictMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<ContactDetail> getFsContactDetails() {
		return fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<BankBranch> getExBankBranches() {
		return exBankBranches;
	}

	public void setExBankBranches(List<BankBranch> exBankBranches) {
		this.exBankBranches = exBankBranches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<BankDdPrintLoc> getExBankDdPrintLocs() {
		return exBankDdPrintLocs;
	}

	public void setExBankDdPrintLocs(List<BankDdPrintLoc> exBankDdPrintLocs) {
		this.exBankDdPrintLocs = exBankDdPrintLocs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<BankMaster> getExBankMasters() {
		return exBankMasters;
	}

	public void setExBankMasters(List<BankMaster> exBankMasters) {
		this.exBankMasters = exBankMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsStateMaster")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}
	
}
