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
 * FsCustomerLogin Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUSTOMER_LOGIN" )
public class CustomerLogin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal custLoginId;
	private Customer fsCustomer;
	private LanguageType fsLanguageType;
	private CountryMaster fsCountryMaster;
	private CompanyMaster fsCompanyMaster;
	private String userName;
	private String password;
	private String secondaryPassword;
	private BigDecimal securityQuestion1;
	private BigDecimal securityQuestion2;
	private BigDecimal securityQuestion3;
	private BigDecimal securityQuestion4;
	private BigDecimal securityQuestion5;
	private String securityAnswer1;
	private String securityAnswer2;
	private String securityAnswer3;
	private String securityAnswer4;
	private String securityAnswer5;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdated;
	private String userType;
	private String email;

	public CustomerLogin() {
	}

	public CustomerLogin(BigDecimal custLoginId, String password) {
		this.custLoginId = custLoginId;
		this.password = password;
	}

	public CustomerLogin(BigDecimal custLoginId, Customer fsCustomer,
			LanguageType fsLanguageType, CountryMaster fsCountryMaster,
			CompanyMaster fsCompanyMaster, String userName, String password,
			String secondaryPassword, BigDecimal securityQuestion1,
			BigDecimal securityQuestion2, BigDecimal securityQuestion3,
			BigDecimal securityQuestion4, BigDecimal securityQuestion5,
			String securityAnswer1, String securityAnswer2,
			String securityAnswer3, String securityAnswer4,
			String securityAnswer5, String createdBy, String updatedBy,
			Date creationDate, Date lastUpdated,
			String userType, String email) {
		this.custLoginId = custLoginId;
		this.fsCustomer = fsCustomer;
		this.fsLanguageType = fsLanguageType;
		this.fsCountryMaster = fsCountryMaster;
		this.fsCompanyMaster = fsCompanyMaster;
		this.userName = userName;
		this.password = password;
		this.secondaryPassword = secondaryPassword;
		this.securityQuestion1 = securityQuestion1;
		this.securityQuestion2 = securityQuestion2;
		this.securityQuestion3 = securityQuestion3;
		this.securityQuestion4 = securityQuestion4;
		this.securityQuestion5 = securityQuestion5;
		this.securityAnswer1 = securityAnswer1;
		this.securityAnswer2 = securityAnswer2;
		this.securityAnswer3 = securityAnswer3;
		this.securityAnswer4 = securityAnswer4;
		this.securityAnswer5 = securityAnswer5;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.userType = userType;
		this.email = email;
	}

	@Id
	@TableGenerator(name="custloginid",table="fs_custloginidpk",pkColumnName="custloginidkey",pkColumnValue="custloginidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="custloginid")
	@Column(name = "CUST_LOGIN_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustLoginId() {
		return this.custLoginId;
	}

	public void setCustLoginId(BigDecimal custLoginId) {
		this.custLoginId = custLoginId;
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
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	/*@Column(name = "COMPANY_ID", precision = 22, scale = 0)
	public CompanyMaster getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(CompanyMaster companyId) {
		this.companyId = companyId;
	}*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}
	
	@Column(name = "USER_NAME", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "SECONDARY_PASSWORD", length = 100)
	public String getSecondaryPassword() {
		return this.secondaryPassword;
	}

	public void setSecondaryPassword(String secondaryPassword) {
		this.secondaryPassword = secondaryPassword;
	}

	@Column(name = "SECURITY_QUESTION1", precision = 22, scale = 0)
	public BigDecimal getSecurityQuestion1() {
		return this.securityQuestion1;
	}

	public void setSecurityQuestion1(BigDecimal securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	@Column(name = "SECURITY_QUESTION2", precision = 22, scale = 0)
	public BigDecimal getSecurityQuestion2() {
		return this.securityQuestion2;
	}

	public void setSecurityQuestion2(BigDecimal securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

	@Column(name = "SECURITY_QUESTION3", precision = 22, scale = 0)
	public BigDecimal getSecurityQuestion3() {
		return this.securityQuestion3;
	}

	public void setSecurityQuestion3(BigDecimal securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}

	@Column(name = "SECURITY_QUESTION4", precision = 22, scale = 0)
	public BigDecimal getSecurityQuestion4() {
		return this.securityQuestion4;
	}

	public void setSecurityQuestion4(BigDecimal securityQuestion4) {
		this.securityQuestion4 = securityQuestion4;
	}

	@Column(name = "SECURITY_QUESTION5", precision = 22, scale = 0)
	public BigDecimal getSecurityQuestion5() {
		return this.securityQuestion5;
	}

	public void setSecurityQuestion5(BigDecimal securityQuestion5) {
		this.securityQuestion5 = securityQuestion5;
	}

	@Column(name = "SECURITY_ANSWER1", length = 200)
	public String getSecurityAnswer1() {
		return this.securityAnswer1;
	}

	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}

	@Column(name = "SECURITY_ANSWER2", length = 200)
	public String getSecurityAnswer2() {
		return this.securityAnswer2;
	}

	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}

	@Column(name = "SECURITY_ANSWER3", length = 200)
	public String getSecurityAnswer3() {
		return this.securityAnswer3;
	}

	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}

	@Column(name = "SECURITY_ANSWER4", length = 200)
	public String getSecurityAnswer4() {
		return this.securityAnswer4;
	}

	public void setSecurityAnswer4(String securityAnswer4) {
		this.securityAnswer4 = securityAnswer4;
	}

	@Column(name = "SECURITY_ANSWER5", length = 200)
	public String getSecurityAnswer5() {
		return this.securityAnswer5;
	}

	public void setSecurityAnswer5(String securityAnswer5) {
		this.securityAnswer5 = securityAnswer5;
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

	@Column(name = "USER_TYPE", length = 30)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "EMAIL", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
