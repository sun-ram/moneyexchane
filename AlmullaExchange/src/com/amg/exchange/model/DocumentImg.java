package com.amg.exchange.model;

// default package
// Generated Apr 22, 2014 1:49:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.sql.Blob;
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
 * DocumentImg Created by Chennai ODC
 */
@Entity
@Table(name = "FS_DOCUMENT_IMG" )
public class DocumentImg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal imgId;
	//private byte[] image;
	private Blob image;
	
	private String imageName;
	private Date uploadDate;
	private String imgStatus;
	
	List<CustomerIdProof> fsCustomerIdProofs = new ArrayList<CustomerIdProof>();

	public DocumentImg() {
	}

	public DocumentImg(BigDecimal imgId) {
		this.imgId = imgId;
	}

	public DocumentImg(BigDecimal imgId, /*byte[]*/ Blob image, String imageName,
			Date uploadDate, List<CustomerIdProof> fsCustomerIdProofs) {
		this.imgId = imgId;
		this.image = image;
		this.imageName = imageName;
		this.uploadDate = uploadDate;
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	@Id
	@TableGenerator(name = "imgId", table = "fs_imgIdpk", pkColumnName = "imgIdkey", pkColumnValue = "imgIdidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "imgId")
	@Column(name = "IMG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getImgId() {
		return this.imgId;
	}

	public void setImgId(BigDecimal imgId) {
		this.imgId = imgId;
	}

	@Column(name = "IMAGE", nullable = true,  length = 10485760 )
	public /*byte[]*/ Blob getImage() {
		return this.image;
	}

	public void setImage(/*byte[] */Blob image) {
		this.image = image;
	}

	@Column(name = "IMAGE_NAME", length = 50)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "UPLOAD_DATE")
	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsDocumentImg")
	public List<CustomerIdProof> getFsCustomerIdProofs() {
		return fsCustomerIdProofs;
	}

	public void setFsCustomerIdProofs(List<CustomerIdProof> fsCustomerIdProofs) {
		this.fsCustomerIdProofs = fsCustomerIdProofs;
	}

	 @Column(name = "IMG_STATUS", length = 1)
	 public String getImgStatus() {
	  return imgStatus;
	 }

	 public void setImgStatus(String imgStatus) {
	  this.imgStatus = imgStatus;
	 }
}
