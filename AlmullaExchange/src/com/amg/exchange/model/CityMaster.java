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
 * FsCityMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CITY_MASTER")
public class CityMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal cityId;
	private Short cityCode;
	private DistrictMaster fsDistrictMaster;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private List<CityMasterDesc> fsCityMasterDescs = new ArrayList<CityMasterDesc>();
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();
	private List<BankBranch> exBankBranches = new ArrayList<BankBranch>();
	private List<BankDdPrintLoc> exBankDdPrintLocs = new ArrayList<BankDdPrintLoc>();
	private List<BankMaster> exBankMasters = new ArrayList<BankMaster>();
	private List<CustomerEmploymentInfo> fsCustomerEmploymentInfos = new ArrayList<CustomerEmploymentInfo>();

	public CityMaster() {
	}

	public CityMaster(BigDecimal cityId) {
		this.cityId = cityId;
	}

	public CityMaster(BigDecimal cityId, Short cityCode, String createdBy,
			String updatedBy, Date creationDate, Date lastUpdated,
			List<CityMasterDesc> fsCityMasterDescs,
			List<ContactDetail> fsContactDetails,
			DistrictMaster fsDistrictMaster, List<BankBranch> exBankBranches,
			List<BankDdPrintLoc> exBankDdPrintLocs,
			List<BankMaster> exBankMasters,
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.cityId = cityId;
		this.cityCode = cityCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsCityMasterDescs = fsCityMasterDescs;
		this.fsContactDetails = fsContactDetails;
		this.fsDistrictMaster = fsDistrictMaster;
		this.exBankBranches = exBankBranches;
		this.exBankDdPrintLocs = exBankDdPrintLocs;
		this.exBankMasters = exBankMasters;
		this.fsCustomerEmploymentInfos=fsCustomerEmploymentInfos;
	}

	@Id
	@TableGenerator(name = "cityid", table = "fs_cityidpk", pkColumnName = "cityidkey", pkColumnValue = "cityidvale", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cityid")
	@Column(name = "CITY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCityId() {
		return this.cityId;
	}

	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
	}

	@Column(name = "CITY_CODE", precision = 3, scale = 0)
	public Short getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(Short cityCode) {
		this.cityCode = cityCode;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<CityMasterDesc> getFsCityMasterDescs() {
		return this.fsCityMasterDescs;
	}

	public void setFsCityMasterDescs(List<CityMasterDesc> fsCityMasterDescs) {
		this.fsCityMasterDescs = fsCityMasterDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<ContactDetail> getFsContactDetails() {
		return fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	public DistrictMaster getFsDistrictMaster() {
		return this.fsDistrictMaster;
	}

	public void setFsDistrictMaster(DistrictMaster fsDistrictMaster) {
		this.fsDistrictMaster = fsDistrictMaster;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<BankBranch> getExBankBranches() {
		return exBankBranches;
	}

	public void setExBankBranches(List<BankBranch> exBankBranches) {
		this.exBankBranches = exBankBranches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<BankDdPrintLoc> getExBankDdPrintLocs() {
		return exBankDdPrintLocs;
	}

	public void setExBankDdPrintLocs(List<BankDdPrintLoc> exBankDdPrintLocs) {
		this.exBankDdPrintLocs = exBankDdPrintLocs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<BankMaster> getExBankMasters() {
		return exBankMasters;
	}

	public void setExBankMasters(List<BankMaster> exBankMasters) {
		this.exBankMasters = exBankMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCityMaster")
	public List<CustomerEmploymentInfo> getFsCustomerEmploymentInfos() {
		return fsCustomerEmploymentInfos;
	}

	public void setFsCustomerEmploymentInfos(
			List<CustomerEmploymentInfo> fsCustomerEmploymentInfos) {
		this.fsCustomerEmploymentInfos = fsCustomerEmploymentInfos;
	}
	
	

}
