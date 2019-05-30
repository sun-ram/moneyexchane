package com.amg.exchange.model;

 

import java.math.BigDecimal;
import java.util.ArrayList;
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
 * FsContactType Created by Chennai ODC
 */
@Entity
@Table(name = "FS_CONTACT_TYPE" )
public class ContactType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal contactTypeId;
	private LanguageType fsLanguageType;
	private String contactType;
	private List<ContactDetail> fsContactDetails = new ArrayList<ContactDetail>();

	public ContactType() {
	}

	public ContactType(BigDecimal contactTypeId, String contactType) {
		this.contactTypeId = contactTypeId;
		this.contactType = contactType;
	}

	public ContactType(BigDecimal contactTypeId,
			LanguageType fsLanguageType, String contactType,
			List<ContactDetail> fsContactDetails) {
		this.contactTypeId = contactTypeId;
		this.fsLanguageType = fsLanguageType;
		this.contactType = contactType;
		this.fsContactDetails = fsContactDetails;
	}

	@Id
	@TableGenerator(name="contacttypeid",table="fs_contacttypeidpk",pkColumnName="contacttypeidkey",pkColumnValue="contacttypeidvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="contacttypeid")
	@Column(name = "CONTACT_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getContactTypeId() {
		return this.contactTypeId;
	}

	public void setContactTypeId(BigDecimal contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public LanguageType getFsLanguageType() {
		return this.fsLanguageType;
	}

	public void setFsLanguageType(LanguageType fsLanguageType) {
		this.fsLanguageType = fsLanguageType;
	}

	@Column(name = "CONTACT_TYPE", nullable = false, length = 50)
	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsContactType")
	public List<ContactDetail> getFsContactDetails() {
		return this.fsContactDetails;
	}

	public void setFsContactDetails(List<ContactDetail> fsContactDetails) {
		this.fsContactDetails = fsContactDetails;
	}

}
