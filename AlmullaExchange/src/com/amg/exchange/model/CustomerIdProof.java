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
 * FsCustomerIdProof Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CUSTOMER_ID_PROOF" )
public class CustomerIdProof implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal custProofId;
	private CustomerType fsCustomerType;
	private Customer fsCustomer;
	private IdentityType fsIdentityType;
	private LanguageType fsLanguageType;
	private DocumentImg fsDocumentImg;
	private String name;
	private String identityFor;
	private String identityInt;
	private Date identityExpiryDate;
	private Date identityEffDate;
	private Date identityEndDate;
	private String approvedBy;
	private Date approvedDate;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date lastUpdatedDate;
	private String identityStatus;

	public CustomerIdProof() {
	}

	public CustomerIdProof(BigDecimal custProofId) {
		this.custProofId = custProofId;
	}

	public CustomerIdProof(BigDecimal custProofId,
			CustomerType fsCustomerType, Customer fsCustomer,
			IdentityType fsIdentityType, LanguageType fsLanguageType,DocumentImg fsDocumentImg,
			String name, String identityFor, String identityInt,
			Date identityExpiryDate,
			Date identityEffDate, Date identityEndDate,
			String approvedBy, Date approvedDate, String createdBy,
			String updatedBy, Date creationDate,
			Date lastUpdatedDate, String identityStatus) {
		this.custProofId = custProofId;
		this.fsCustomerType = fsCustomerType;
		this.fsCustomer = fsCustomer;
		this.fsIdentityType = fsIdentityType;
		this.fsLanguageType = fsLanguageType;
		this.fsDocumentImg=fsDocumentImg;
		this.name = name;
		this.identityFor = identityFor;
		this.identityInt = identityInt;
		this.identityExpiryDate = identityExpiryDate;
		this.identityEffDate = identityEffDate;
		this.identityEndDate = identityEndDate;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.identityStatus=identityStatus;
	}

	@Id
	@TableGenerator(name="custproofid",table="fs_custproofidpk",pkColumnName="custproofidkey",pkColumnValue="custproofidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="custproofid")
	@Column(name = "CUST_PROOF_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustProofId() {
		return this.custProofId;
	}

	public void setCustProofId(BigDecimal custProofId) {
		this.custProofId = custProofId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_TYPE_ID")
	public CustomerType getFsCustomerType() {
		return this.fsCustomerType;
	}

	public void setFsCustomerType(CustomerType fsCustomerType) {
		this.fsCustomerType = fsCustomerType;
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
	@JoinColumn(name = "IDENTITY_TYPE_ID")
	public IdentityType getFsIdentityType() {
		return this.fsIdentityType;
	}

	public void setFsIdentityType(IdentityType fsIdentityType) {
		this.fsIdentityType = fsIdentityType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IDENTITY_FOR", length = 20)
	public String getIdentityFor() {
		return this.identityFor;
	}

	public void setIdentityFor(String identityFor) {
		this.identityFor = identityFor;
	}

	@Column(name = "IDENTITY_INT", length = 15)
	public String getIdentityInt() {
		return this.identityInt;
	}

	public void setIdentityInt(String identityInt) {
		this.identityInt = identityInt;
	}

	/*@Column(name = "IDENTITY_IMG", length = 400)
	public String getIdentityImg() {
		return this.identityImg;
	}

	public void setIdentityImg(String identityImg) {
		this.identityImg = identityImg;
	}*/

	@Column(name = "IDENTITY_EXPIRY_DATE")
	public Date getIdentityExpiryDate() {
		return this.identityExpiryDate;
	}

	public void setIdentityExpiryDate(Date identityExpiryDate) {
		this.identityExpiryDate = identityExpiryDate;
	}

	@Column(name = "IDENTITY_EFF_DATE")
	public Date getIdentityEffDate() {
		return this.identityEffDate;
	}

	public void setIdentityEffDate(Date identityEffDate) {
		this.identityEffDate = identityEffDate;
	}

	@Column(name = "IDENTITY_END_DATE")
	public Date getIdentityEndDate() {
		return this.identityEndDate;
	}

	public void setIdentityEndDate(Date identityEndDate) {
		this.identityEndDate = identityEndDate;
	}

	@Column(name = "APPROVED_BY", length = 20)
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Column(name = "APPROVED_DATE")
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
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

	@Column(name = "LAST_UPDATED_DATE")
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IMG_ID")
	public DocumentImg getFsDocumentImg() {
		return fsDocumentImg;
	}

	public void setFsDocumentImg(DocumentImg fsDocumentImg) {
		this.fsDocumentImg = fsDocumentImg;
	}

	@Column(name = "IDENTITY_STATUS", length = 1)
	public String getIdentityStatus() {
		return this.identityStatus;
	}

	public void setIdentityStatus(String identityStatus) {
		this.identityStatus = identityStatus;
	}
}
