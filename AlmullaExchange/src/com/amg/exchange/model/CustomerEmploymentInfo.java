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
 * FsCustomerEmploymentInfo Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUSTOMER_EMPLOYMENT_INFO" )
public class CustomerEmploymentInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal custEmpInfoId;
	private Customer fsCustomer;
	private CountryMaster fsCountryMaster;
	private CompanyMaster fsCompanyMaster;
	private LanguageType fsLanguageType;
	private EmploymentType fsEmploymentType;
	//private String countryCode;
	
	

	private DistrictMaster fsDistrictMaster;
	private StateMaster fsStateMaster;
	private CityMaster fsCityMaster;
	//private String companyCode;
	private String occupation;
	private String employerName;
	private String department;
	/*private BigDecimal stateId;
	private BigDecimal districtId;
	private BigDecimal cityId;*/
	private String area;
	private String block;
	private String street;
	private String postal;
	private String officeTelephone;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;

	public CustomerEmploymentInfo() {
	}

	public CustomerEmploymentInfo(BigDecimal custEmpInfoId) {
		this.custEmpInfoId = custEmpInfoId;
	}

	public CustomerEmploymentInfo(BigDecimal custEmpInfoId,
			Customer fsCustomer, LanguageType fsLanguageType,CountryMaster fsCountryMaster,
			EmploymentType fsEmploymentType,
			CompanyMaster fsCompanyMaster,/*String countryCode,			
			String companyCode,*/
			DistrictMaster fsDistrictMaster,
			StateMaster fsStateMaster,
			CityMaster fsCityMaster,
			String occupation, String employerName,
			String department, String area, String block, String street,
			String postal, String officeTelephone, String createdBy,
			String updatedBy, Date creationDate,
			Date lastUpdated) {
		this.custEmpInfoId = custEmpInfoId;
		this.fsCustomer = fsCustomer;
		this.fsLanguageType = fsLanguageType;
		this.fsEmploymentType = fsEmploymentType;
		//this.countryCode = countryCode;
		//this.companyCode = companyCode;
		this.occupation = occupation;
		this.employerName = employerName;
		this.department = department;
		
		this.area = area;
		this.block = block;
		this.street = street;
		this.postal = postal;
		this.officeTelephone = officeTelephone;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.fsCountryMaster= fsCountryMaster;
		this.fsDistrictMaster=fsDistrictMaster;
		this.fsStateMaster=fsStateMaster;
		this.fsCityMaster=fsCityMaster;
	}

	@Id
	@TableGenerator(name="custempinfoid",table="fs_custempinfoidpk",pkColumnName="custempinfoidkey",pkColumnValue="custempinfoidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="custempinfoid")
	@Column(name = "CUST_EMP_INFO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustEmpInfoId() {
		return this.custEmpInfoId;
	}

	public void setCustEmpInfoId(BigDecimal custEmpInfoId) {
		this.custEmpInfoId = custEmpInfoId;
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
	@JoinColumn(name = "EMPLOYMENT_TYPE_ID")
	public EmploymentType getFsEmploymentType() {
		return this.fsEmploymentType;
	}

	public void setFsEmploymentType(EmploymentType fsEmploymentType) {
		this.fsEmploymentType = fsEmploymentType;
	}

/*	@Column(name = "COUNTRY_CODE", length = 4)
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}*/
/*
	@Column(name = "COMPANY_CODE", length = 2)
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}*/

	@Column(name = "OCCUPATION", length = 50)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "EMPLOYER_NAME", length = 200)
	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	@Column(name = "DEPARTMENT", length = 200)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Column(name = "AREA", length = 100)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "BLOCK", length = 100)
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

	@Column(name = "POSTAL", length = 100)
	public String getPostal() {
		return this.postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	@Column(name = "OFFICE_TELEPHONE", length = 20)
	public String getOfficeTelephone() {
		return this.officeTelephone;
	}

	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
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
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	public DistrictMaster getFsDistrictMaster() {
		return this.fsDistrictMaster;
	}

	public void setFsDistrictMaster(DistrictMaster fsDistrictMaster) {
		this.fsDistrictMaster = fsDistrictMaster;
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
	@JoinColumn(name = "CITY_ID")
	public CityMaster getFsCityMaster() {
		return this.fsCityMaster;
	}

	public void setFsCityMaster(CityMaster fsCityMaster) {
		this.fsCityMaster = fsCityMaster;
	}
	
}
