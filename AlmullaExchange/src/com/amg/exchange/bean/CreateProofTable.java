package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

import org.primefaces.model.StreamedContent;

public class CreateProofTable implements Serializable {
		 
    private static final long serialVersionUID = 1L;
    
    private String id_for;
    private String id_type;
    private String id_number;
    private String date_expiary;
    private Boolean checked = false;
    
    private String idFor; 
    private String idType;
    
    private String saveOrUpdate;
    private int pk;
    
    private Blob downloadFile;
    private BigDecimal imageId;
    private BigDecimal customerIdProofId = null;
    
    public CreateProofTable (String id_for, String id_type, String id_number, String date_exp, String saveOrUpdate, int primaryKey, 
    						String idFor, String idType, BigDecimal imageId) {
        this.id_for = id_for;
        this.id_type = id_type;
        this.id_number = id_number;
        this.date_expiary = date_exp;
        this.saveOrUpdate = saveOrUpdate;
        this.pk = primaryKey;
        this.idFor = idFor;
        this.idType = idType;
        this.imageId = imageId;
    }

	public CreateProofTable() {
	}

	public String getId_for() {
		return id_for;
	}

	public void setId_for(String id_for) {
		this.id_for = id_for;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getDate_expiary() {
		return date_expiary;
	}

	public void setDate_expiary(String date_expiary) {
		this.date_expiary = date_expiary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+checked);
		this.checked = checked;
	}

	public String getSaveOrUpdate() {
		return saveOrUpdate;
	}

	public void setSaveOrUpdate(String saveOrUpdate) {
		this.saveOrUpdate = saveOrUpdate;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdFor() {
		return idFor;
	}

	public void setIdFor(String idFor) {
		this.idFor = idFor;
	}

	public Blob getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(Blob downloadFile) {
		this.downloadFile = downloadFile;
	}

	public BigDecimal getImageId() {
		return imageId;
	}

	public void setImageId(BigDecimal imageId) {
		this.imageId = imageId;
	}

	public BigDecimal getCustomerIdProofId() {
		return customerIdProofId;
	}

	public void setCustomerIdProofId(BigDecimal customerIdProofId) {
		this.customerIdProofId = customerIdProofId;
	}
}
