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
 * FsDistrictMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_DISTRICT_MASTER")
public class DistrictMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal districtId;
	private StateMaster fsStateMaster;
	private Short districtCode;
	private String districtActive;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private List<DistrictMasterDesc> fsDistrictMasterDescs = new ArrayList<DistrictMasterDesc>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<CityMaster> fsCityMasters = new ArrayList<CityMaster>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();
	private List<BankDdPrintLoc> exBankDdPrintLocs = new ArrayList<BankDdPrintLoc>();
	private List<BankMaster> exBankMasters = new ArrayList<BankMaster>();
	private List<BankBranch> exBankBranches = new ArrayList<BankBranch>();

	public DistrictMaster() {
	}

	public DistrictMaster(BigDecimal districtId) {
		this.districtId = districtId;
	}

	public DistrictMaster(BigDecimal districtId, Short districtCode,
			StateMaster fsStateMaster, String districtActive, String createdBy,
			String updatedBy, Date creationDate, Date lastUpdated,
			List<DistrictMasterDesc> fsDistrictMasterDescs,
			List<ContactDetail> fsContactDetails,
			List<CityMaster> fsCityMasters, List<BankBranch> exBankBranches,
			List<BankDdPrintLoc> exBankDdPrintLocs,
			List<BankMaster> exBankMasters,List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.districtId = districtId;
		this.districtCode = districtCode;
		this.districtActive = districtActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsDistrictMasterDescs = fsDistrictMasterDescs;
		this.fsContactDetails = fsContactDetails;
		this.fsCityMasters = fsCityMasters;
		this.fsStateMaster = fsStateMaster;
		this.exBankBranches = exBankBranches;
		this.exBankDdPrintLocs = exBankDdPrintLocs;
		this.exBankMasters = exBankMasters;
		this.fsCustomerEmploymentInfos=fsCustomerEmploymentInfos;
	}

	@Id
	@TableGenerator(name = "districtid", table = "fs_districtidpk", pkColumnName = "districtidkey", pkColumnValue = "districtidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "districtid")
	@Column(name = "DISTRICT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(BigDecimal districtId) {
		this.districtId = districtId;
	}

	@Column(name = "DISTRICT_CODE", precision = 3, scale = 0)
	public Short getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(Short districtCode) {
		this.districtCode = districtCode;
	}

	@Column(name = "DISTRICT_ACTIVE", length = 1)
	public String getDistrictActive() {
		return this.districtActive;
	}

	public void setDistrictActive(String districtActive) {
		this.districtActive = districtActive;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<DistrictMasterDesc> getFsDistrictMasterDescs() {
		return this.fsDistrictMasterDescs;
	}

	public void setFsDistrictMasterDescs(
			List<DistrictMasterDesc> fsDistrictMasterDescs) {
		this.fsDistrictMasterDescs = fsDistrictMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<ContactDetail> getFsContactDetails() {
		return fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<CityMaster> getFsCityMasters() {
		return fsCityMasters;
	}

	public void setFsCityMasters(List<CityMaster> fsCityMasters) {
		this.fsCityMasters = fsCityMasters;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	public StateMaster getFsStateMaster() {
		return fsStateMaster;
	}

	public void setFsStateMaster(StateMaster fsStateMaster) {
		this.fsStateMaster = fsStateMaster;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<BankDdPrintLoc> getExBankDdPrintLocs() {
		return exBankDdPrintLocs;
	}

	public void setExBankDdPrintLocs(List<BankDdPrintLoc> exBankDdPrintLocs) {
		this.exBankDdPrintLocs = exBankDdPrintLocs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<BankMaster> getExBankMasters() {
		return exBankMasters;
	}

	public void setExBankMasters(List<BankMaster> exBankMasters) {
		this.exBankMasters = exBankMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<BankBranch> getExBankBranches() {
		return exBankBranches;
	}

	public void setExBankBranches(List<BankBranch> exBankBranches) {
		this.exBankBranches = exBankBranches;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDistrictMaster")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}
	

}
