package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.amg.exchange.model.RuleObjective;

public class AddSecondaryObjectiveBean implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private String seconObj;
	
	private BigDecimal secondaryObjectId;
	
    private boolean modified;
	
	private boolean objStatus;
	
	private BigDecimal corporateAddentionalDetailId;
	
   private List<RuleObjective>  lstSecoundryObjective = new ArrayList<RuleObjective>();

	public AddSecondaryObjectiveBean() {
	}

	public String getSeconObj() {
		return seconObj;
	}

	public void setSeconObj(String seconObj) {
		this.seconObj = seconObj;
	}
	public AddSecondaryObjectiveBean(String seconObj,boolean modified,boolean objStatus,BigDecimal pK ){
		this.seconObj = seconObj;
		this.modified = modified;
		this.objStatus = objStatus;
		this.secondaryObjectId = pK;

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

	public BigDecimal getSecondaryObjectId() {
		return secondaryObjectId;
	}

	public void setSecondaryObjectId(BigDecimal secondaryObjectId) {
		this.secondaryObjectId = secondaryObjectId;
	}

	public BigDecimal getCorporateAddentionalDetailId() {
		return corporateAddentionalDetailId;
	}

	public void setCorporateAddentionalDetailId(
			BigDecimal corporateAddentionalDetailId) {
		this.corporateAddentionalDetailId = corporateAddentionalDetailId;
	}

	public List<RuleObjective> getLstSecoundryObjective() {
		return lstSecoundryObjective;
	}

	public void setLstSecoundryObjective(List<RuleObjective> lstSecoundryObjective) {
		this.lstSecoundryObjective = lstSecoundryObjective;
	}
}
