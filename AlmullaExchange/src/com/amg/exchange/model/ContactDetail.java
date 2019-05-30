package com.amg.exchange.model;

 

import java.math.BigDecimal;
import java.util.Date;

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
 * FsContactDetail Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CONTACT_DETAIL" )
public class ContactDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal contactDetailId;
	private Customer fsCustomer;
	private LanguageType fsLanguageType;
	private ContactType fsContactType;
	private CountryMaster fsCountryMaster;
	private DistrictMaster fsDistrictMaster;
	private StateMaster fsStateMaster;
	private CityMaster fsCityMaster;
	private String alterEmailId;
	private String area;
	private String block;
	private String street;
	private String flat;
	private String telephone;
	private String mobile;
	private String approved;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private String activeStatus;

	public ContactDetail() {
	}

	public ContactDetail(BigDecimal contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	public ContactDetail(BigDecimal contactDetailId, Customer fsCustomer,
			LanguageType fsLanguageType, ContactType fsContactType,CountryMaster fsCountryMaster,
			DistrictMaster fsDistrictMaster,StateMaster fsStateMaster,
			CityMaster fsCityMaster,
			String alterEmailId, String stateCode, String districtCode,
			String cityCode, String area, String block, String street,
			String flat, String telephone, String mobile, String approved,
			String createdBy, String updatedBy, Date creationDate,String activeStatus,
			Date lastUpdated) {
		this.contactDetailId = contactDetailId;
		this.fsCustomer = fsCustomer;
		this.fsLanguageType = fsLanguageType;
		this.fsContactType = fsContactType;
		this.alterEmailId = alterEmailId;
		this.area = area;
		this.block = block;
		this.street = street;
		this.flat = flat;
		this.telephone = telephone;
		this.mobile = mobile;
		this.approved = approved;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsDistrictMaster=fsDistrictMaster;
		this.fsStateMaster=fsStateMaster;
		this.fsCountryMaster= fsCountryMaster;
		this.fsCityMaster=fsCityMaster;
		this.activeStatus=activeStatus;
	}

	@Id
	@TableGenerator(name="contactdetailid",table="fs_contactdetailidpk",pkColumnName="contactdetailidkey",pkColumnValue="contactdetailidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="contactdetailid")
	@Column(name = "CONTACT_DETAIL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getContactDetailId() {
		return this.contactDetailId;
	}

	public void setContactDetailId(BigDecimal contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getFsCustomer() {
		return this.fsCustomer;
	}

	public void setFsCustomer(Customer fsCustomer) {
		this.fsCustomer = fsCustomer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTACT_TYPE_ID")
	public ContactType getFsContactType() {
		return this.fsContactType;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	public DistrictMaster getFsDistrictMaster() {
		return this.fsDistrictMaster;
	}

	public void setFsDistrictMaster(DistrictMaster fsDistrictMaster) {
		this.fsDistrictMaster = fsDistrictMaster;
	}

	public void setFsContactType(ContactType fsContactType) {
		this.fsContactType = fsContactType;
	}

	@Column(name = "ALTER_EMAIL_ID", length = 200)
	public String getAlterEmailId() {
		return this.alterEmailId;
	}

	public void setAlterEmailId(String alterEmailId) {
		this.alterEmailId = alterEmailId;
	}




	@Column(name = "AREA", length = 100)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "BLOCK", length = 20)
	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	@Column(name = "STREET", length = 100)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "FLAT", length = 100)
	public String getFlat() {
		return this.flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	@Column(name = "TELEPHONE", length = 30)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "MOBILE", length = 30)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "APPROVED", length = 10)
	public String getApproved() {
		return this.approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	@Column(name = "CREATED_BY", length = 200)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY", length = 200)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	public StateMaster getFsStateMaster() {
		return this.fsStateMaster;
	}

	public void setFsStateMaster(StateMaster fsStateMaster) {
		this.fsStateMaster = fsStateMaster;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	public CityMaster getFsCityMaster() {
		return this.fsCityMaster;
	}

	public void setFsCityMaster(CityMaster fsCityMaster) {
		this.fsCityMaster = fsCityMaster;
	}
	
	@Column(name = "ACTIVE_STATUS", nullable = false, length = 1)
	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
