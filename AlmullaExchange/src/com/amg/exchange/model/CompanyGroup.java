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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * FsCompanyGroup Created by Chennai ODC
 */
@Entity
@Table(name = "FS_COMPANY_GROUP" )
public class CompanyGroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal groupId;
	private Short groupCode;
	private String groupActive;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private List<CompanyGroupDesc> fsCompanyGroupDescs = new ArrayList<CompanyGroupDesc>();
	private List<Customer> fsCustomers = new ArrayList<Customer>();

	public CompanyGroup() {
	}

	public CompanyGroup(BigDecimal groupId) {
		this.groupId = groupId;
	}

	public CompanyGroup(BigDecimal groupId, Short groupCode,
			String groupActive, String createdBy, String updatedBy,
			Date creationDate, Date lastUpdated,
			List<CompanyGroupDesc> fsCompanyGroupDescs, List<Customer> fsCustomers) {
		this.groupId = groupId;
		this.groupCode = groupCode;
		this.groupActive = groupActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsCompanyGroupDescs = fsCompanyGroupDescs;
		this.fsCustomers = fsCustomers;
	}

	@Id
	@TableGenerator(name="groupid",table="fs_groupidpk",pkColumnName="groupidkey",pkColumnValue="groupidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="groupid")
	@Column(name = "GROUP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getGroupId() {
		return this.groupId;
	}

	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	@Column(name = "GROUP_CODE", precision = 3, scale = 0)
	public Short getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(Short groupCode) {
		this.groupCode = groupCode;
	}

	@Column(name = "GROUP_ACTIVE", length = 1)
	public String getGroupActive() {
		return this.groupActive;
	}

	public void setGroupActive(String groupActive) {
		this.groupActive = groupActive;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyGroup")
	public List<CompanyGroupDesc> getFsCompanyGroupDescs() {
		return this.fsCompanyGroupDescs;
	}

	public void setFsCompanyGroupDescs(List<CompanyGroupDesc> fsCompanyGroupDescs) {
		this.fsCompanyGroupDescs = fsCompanyGroupDescs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsCompanyGroup")
	public List<Customer> getFsCustomers() {
		return this.fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

}
