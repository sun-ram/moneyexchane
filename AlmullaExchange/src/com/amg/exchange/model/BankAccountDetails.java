package com.amg.exchange.model;

// default package
// Generated May 23, 2014 5:18:25 PM by  Chennai ODC

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
 * BankAccountDetails generated by Chennai ODC
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "EX_BANK_ACCOUNT_DETAILS")
public class BankAccountDetails implements java.io.Serializable {

	private BigDecimal bankAcctDetId;
	private BankMaster bankMaster;
	private CompanyMaster fsCompanyMaster;
	private CountryMaster fsCountryMaster;
	private String bankAcctNo;
	private String acctType;
	private String currencyCode;
	private BigDecimal minBal;
	private BigDecimal odlmt;
	private String glno;
	private String recordStatus;
	private String telephoneNo;
	private String faxno;
	private String email;
	private String contactPersonAr;
	private String contactDesgAr;
	private String contactDeptAr;
	private String fundGlno;
	private BigDecimal intMinbal;
	private Date createDate;
	private Date updateDate;
	private String creator;
	private String modifier;
	private String contactPerson;
	private String contactDesg;
	private String contactDept;
	private String mobile;

	public BankAccountDetails() {
	}

	public BankAccountDetails(BigDecimal bankAcctDetId) {
		this.bankAcctDetId = bankAcctDetId;
	}

	public BankAccountDetails(BigDecimal bankAcctDetId, BankMaster bankMaster,
			CompanyMaster fsCompanyMaster, CountryMaster fsCountryMaster,
			String bankAcctNo, String acctType, String currencyCode, BigDecimal minBal, BigDecimal odlmt,
			String glno, String recordStatus, String telephoneNo, String faxno,
			String email, String contactPersonAr, String contactDesgAr,
			String contactDeptAr, String fundGlno, BigDecimal intMinbal,
			Date createDate, Date updateDate, String creator, String modifier,
			String contactPerson, String contactDesg, String contactDept, String mobile) {
		this.bankAcctDetId = bankAcctDetId;
		this.bankMaster = bankMaster;
		this.fsCompanyMaster = fsCompanyMaster;
		this.fsCountryMaster = fsCountryMaster;
		this.bankAcctNo = bankAcctNo;
		this.acctType = acctType;
		this.currencyCode = currencyCode;
		this.minBal = minBal;
		this.odlmt = odlmt;
		this.glno = glno;
		this.recordStatus = recordStatus;
		this.telephoneNo = telephoneNo;
		this.faxno = faxno;
		this.email = email;
		this.contactPersonAr = contactPersonAr;
		this.contactDesgAr = contactDesgAr;
		this.contactDeptAr = contactDeptAr;
		this.fundGlno = fundGlno;
		this.intMinbal = intMinbal;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.creator = creator;
		this.modifier = modifier;
		this.contactPerson = contactPerson;
		this.contactDesg = contactDesg;
		this.contactDept = contactDept;
		this.mobile = mobile;

	}

	@Id
	@TableGenerator(name = "bankacctdetid", table = "ex_bankacctdetidpk", pkColumnName = "bankacctdetidkey", pkColumnValue = "bankacctdetidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "bankacctdetid")
	@Column(name = "BANK_ACCT_DET_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getBankAcctDetId() {
		return this.bankAcctDetId;
	}

	public void setBankAcctDetId(BigDecimal bankAcctDetId) {
		this.bankAcctDetId = bankAcctDetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_ID")
	public BankMaster getExBankMaster() {
		return this.bankMaster;
	}

	public void setExBankMaster(BankMaster bankMaster) {
		this.bankMaster = bankMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public CompanyMaster getFsCompanyMaster() {
		return this.fsCompanyMaster;
	}

	public void setFsCompanyMaster(CompanyMaster fsCompanyMaster) {
		this.fsCompanyMaster = fsCompanyMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public CountryMaster getFsCountryMaster() {
		return this.fsCountryMaster;
	}

	public void setFsCountryMaster(CountryMaster fsCountryMaster) {
		this.fsCountryMaster = fsCountryMaster;
	}

	@Column(name = "BANK_ACCT_NO", length = 20)
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}

	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}

	@Column(name = "ACCT_TYPE", length = 1)
	public String getAcctType() {
		return this.acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@Column(name = "CURRENCY_CODE", length = 3)
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	@Column(name = "MIN_BAL", precision = 18, scale = 3)
	public BigDecimal getMinBal() {
		return this.minBal;
	}

	public void setMinBal(BigDecimal minBal) {
		this.minBal = minBal;
	}

	@Column(name = "ODLMT", precision = 18, scale = 3)
	public BigDecimal getOdlmt() {
		return this.odlmt;
	}

	public void setOdlmt(BigDecimal odlmt) {
		this.odlmt = odlmt;
	}

	@Column(name = "GLNO", length = 33)
	public String getGlno() {
		return this.glno;
	}

	public void setGlno(String glno) {
		this.glno = glno;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "TELEPHONE_NO", length = 30)
	public String getTelephoneNo() {
		return this.telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	@Column(name = "FAXNO", length = 30)
	public String getFaxno() {
		return this.faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	@Column(name = "EMAIL", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CONTACT_PERSON_AR", length = 60)
	public String getContactPersonAr() {
		return this.contactPersonAr;
	}

	public void setContactPersonAr(String contactPersonAr) {
		this.contactPersonAr = contactPersonAr;
	}

	@Column(name = "CONTACT_DESG_AR", length = 120)
	public String getContactDesgAr() {
		return this.contactDesgAr;
	}

	public void setContactDesgAr(String contactDesgAr) {
		this.contactDesgAr = contactDesgAr;
	}

	@Column(name = "CONTACT_DEPT_AR", length = 60)
	public String getContactDeptAr() {
		return this.contactDeptAr;
	}

	public void setContactDeptAr(String contactDeptAr) {
		this.contactDeptAr = contactDeptAr;
	}

	@Column(name = "FUND_GLNO", length = 33)
	public String getFundGlno() {
		return this.fundGlno;
	}

	public void setFundGlno(String fundGlno) {
		this.fundGlno = fundGlno;
	}

	@Column(name = "INT_MINBAL", precision = 18, scale = 3)
	public BigDecimal getIntMinbal() {
		return this.intMinbal;
	}

	public void setIntMinbal(BigDecimal intMinbal) {
		this.intMinbal = intMinbal;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "CREATOR", length = 15)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "MODIFIER", length = 15)
	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Column(name = "CONTACT_PERSON", length = 60)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "CONTACT_DESG", length = 60)
	public String getContactDesg() {
		return this.contactDesg;
	}

	public void setContactDesg(String contactDesg) {
		this.contactDesg = contactDesg;
	}

	@Column(name = "CONTACT_DEPT", length = 60)
	public String getContactDept() {
		return this.contactDept;
	}

	public void setContactDept(String contactDept) {
		this.contactDept = contactDept;
	}

	@Column(name = "MOBILE", length = 30)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}