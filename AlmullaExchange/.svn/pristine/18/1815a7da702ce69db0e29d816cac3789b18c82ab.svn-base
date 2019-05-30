package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.amg.exchange.model.IdentityType;

public class AddPartnerDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pidno;

	private  String pidtype;

	private String pidExpDate;

	private String partName;

	private Boolean checked;
	
	private boolean modified;
	
	private boolean objStatus;
	
	private BigDecimal pIdTypeId;
	
	private BigDecimal customerIdProofId;
	
	private List<IdentityType> lstPartnerIdentityList = new ArrayList<IdentityType>();
	private BigDecimal imageId;
	private List<String> images = new ArrayList<String>();
	private StreamedContent downloadFile;

	private UploadedFile file;
	
	public BigDecimal getCustomerIdProofId() {
		return customerIdProofId;
	}

	public void setCustomerIdProofId(BigDecimal customerIdProofId) {
		this.customerIdProofId = customerIdProofId;
	}

	public AddPartnerDetailBean() {
		
	}

	public String getPidno() {
		return pidno;
	}

	public void setPidno(String pidno) {
		this.pidno = pidno;
	}

	public String getPidtype() {
		return pidtype;
	}

	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	public String getPidExpDate() {
		return pidExpDate;
	}

	public void setPidExpDate(String pidExpDate) {
		this.pidExpDate = pidExpDate;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public AddPartnerDetailBean(String partName, String pidno, String pIdType,
			String pidExpDate,boolean modified, boolean objStatus, BigDecimal pIdTypeId,BigDecimal imageId) {

		this.partName = partName;
		this.pidno = pidno;
		this.pidtype = pIdType;
		this.pidExpDate = pidExpDate;
        this.modified  = modified;
        this.objStatus = objStatus;
        this.pIdTypeId = pIdTypeId;
        this.imageId=imageId;
       
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public boolean isObjStatus() {
		return objStatus;
	}

	public void setObjStatus(boolean objStatus) {
		this.objStatus = objStatus;
	}

	public BigDecimal getpIdTypeId() {
		return pIdTypeId;
	}

	public void setpIdTypeId(BigDecimal pIdTypeId) {
		this.pIdTypeId = pIdTypeId;
	}

	public List<IdentityType> getLstPartnerIdentityList() {
		return lstPartnerIdentityList;
	}

	public void setLstPartnerIdentityList(List<IdentityType> lstPartnerIdentityList) {
		this.lstPartnerIdentityList = lstPartnerIdentityList;
	}
	//image upload

	public BigDecimal getImageId() {
		return imageId;
	}

	public void setImageId(BigDecimal imageId) {
		this.imageId = imageId;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public StreamedContent getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(StreamedContent downloadFile) {
		this.downloadFile = downloadFile;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
}
