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
 * FsNationalityMaster Created by Chennai ODC
 */
@Entity
@Table(name = "FS_NATIONALITY_MASTER" )
public class NationalityMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal nationalityId;
	private Short nationalityCode;
	private String nationalityActive;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private List<NationalityMasterDesc> fsNationalityMasterDescs = new ArrayList<NationalityMasterDesc>();

	public NationalityMaster() {
	}

	public NationalityMaster(BigDecimal nationalityId) {
		this.nationalityId = nationalityId;
	}

	public NationalityMaster(BigDecimal nationalityId, Short nationalityCode,
			String nationalityActive, String createdBy, String updatedBy,
			Date creationDate, Date lastUpdated,
			List<NationalityMasterDesc> fsNationalityMasterDescs) {
		this.nationalityId = nationalityId;
		this.nationalityCode = nationalityCode;
		this.nationalityActive = nationalityActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsNationalityMasterDescs = fsNationalityMasterDescs;
	}

	@Id
	@TableGenerator(name="nationalityid",table="fs_nationalityidpk",pkColumnName="nationalityidkey",pkColumnValue="nationalityidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="nationalityid")
	@Column(name = "NATIONALITY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getNationalityId() {
		return this.nationalityId;
	}

	public void setNationalityId(BigDecimal nationalityId) {
		this.nationalityId = nationalityId;
	}

	@Column(name = "NATIONALITY_CODE", precision = 3, scale = 0)
	public Short getNationalityCode() {
		return this.nationalityCode;
	}

	public void setNationalityCode(Short nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	@Column(name = "NATIONALITY_ACTIVE", length = 1)
	public String getNationalityActive() {
		return this.nationalityActive;
	}

	public void setNationalityActive(String nationalityActive) {
		this.nationalityActive = nationalityActive;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsNationalityMaster")
	public List<NationalityMasterDesc> getFsNationalityMasterDescs() {
		return this.fsNationalityMasterDescs;
	}

	public void setFsNationalityMasterDescs(List<NationalityMasterDesc> fsNationalityMasterDescs) {
		this.fsNationalityMasterDescs = fsNationalityMasterDescs;
	}

}
