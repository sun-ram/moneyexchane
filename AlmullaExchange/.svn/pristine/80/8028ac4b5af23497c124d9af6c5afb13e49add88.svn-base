package com.amg.exchange.treasury.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.BankAccount;
import com.amg.exchange.model.BankAccountDetails;
import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.BussComponentConfDetail;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.CountryMasterDesc;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.service.IGeneralService;
import com.amg.exchange.treasury.service.IBankAccountService;
import com.amg.exchange.util.CollectionUtil;
import com.amg.exchange.util.SessionStateManage;

@Component("bankaccount")
@Scope("session")
public class BankAccountBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal bankAccountId = null; // PK
	private BigDecimal bankId = null;
	private BigDecimal branchId = null;
	private String currencyCode = null;
	private String debitAccount = null;
	private BigDecimal countryId = null;

	public BigDecimal getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(BigDecimal bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public BigDecimal getBankId() {
		return bankId;
	}

	public void setBankId(BigDecimal bankId) {
		this.bankId = bankId;
	}

	public BigDecimal getBranchId() {
		return branchId;
	}

	public void setBranchId(BigDecimal branchId) {
		this.branchId = branchId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}

	@Autowired
	IGeneralService<T> generalService;

	@Autowired
	IBankAccountService<T> ibankAccountService;

	public IGeneralService<T> getGeneralService() {
		return generalService;
	}

	public void setGeneralService(IGeneralService<T> generalService) {
		this.generalService = generalService;
	}

	public IBankAccountService<T> getIbankAccountService() {
		return ibankAccountService;
	}

	public void setIbankAccountService(
			IBankAccountService<T> ibankAccountService) {
		this.ibankAccountService = ibankAccountService;
	}

	private List<BankBranch> branchList;

	public List<BankBranch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<BankBranch> branchList) {
		this.branchList = branchList;
	}

	
	private List<BankMaster> bankMasterList;
	
	private List<BankBranch> bankBranchList;
	
	public List<BankMaster> getBankMasterList() {
		return bankMasterList;
	}

	public void setBankMasterList(List<BankMaster> bankMasterList) {
		this.bankMasterList = bankMasterList;
	}

	
	public List<BankBranch> getBankBranchList() {
		return bankBranchList;
	}

	public void setBankBranchList(List<BankBranch> bankBranchList) {
		this.bankBranchList = bankBranchList;
	}

	Map<String, BussComponentConfDetail> mapComponentBehavior = new HashMap<String, BussComponentConfDetail>();

	public String viewBehaviorBean(String componentName, String type) {

		return new CollectionUtil().fetchBehavior(mapComponentBehavior,
				componentName, type);
	}

	@Autowired
	public BankAccountBean(IGeneralService<T> generalService) {

		setGeneralService(generalService);

		setPageIdIntoSession();
		prepareBehavior();
	}

	private void setPageIdIntoSession() {

		String pageName = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		pageName = pageName.substring(pageName.lastIndexOf('/') + 1,
				pageName.indexOf(".xhtml"));

		try {
			BigDecimal pageId = getGeneralService().getPageId(pageName);
			new SessionStateManage().setSessionValue("pageId",
					pageId.toString());
		} catch (Exception e) {
			System.out.println("Page id not found for pagename :: " + pageName
					+ " :: " + e);
		}
	}

	private void prepareBehavior() {

		SessionStateManage manage = new SessionStateManage();
		List<String> lstComponentName = Arrays.asList("Country", "Banks", "Branch",
				"Currency Code", "Debit Account");
		mapComponentBehavior = getGeneralService().getComponentBehavior(lstComponentName, manage.getLevel(), manage.getApplicationId(),manage.getCompanyId(), manage.getCountryId(),
				manage.getPageId());
	}

	/**
	 * Responsible to populate Country
	 * 
	 * @return
	 */
	public List<CountryMasterDesc> getCountryNameList() {
		SessionStateManage sessionStateManage = new SessionStateManage();
		List<CountryMasterDesc> lstCountry = getGeneralService()
				.getCountryList(
						new BigDecimal(sessionStateManage
								.isExists("languageId") ? sessionStateManage
								.getSessionValue("languageId") : "" + 1));
		return lstCountry;
	}

	/**
	 * method is responsible to populate List of Bank from DB
	 * 
	 * @return
	 */

	public List<BankMaster> getBankListFromDB() {
		SessionStateManage sessionStateManage = new SessionStateManage();

		return getGeneralService()
				.getAllBankList(
						new BigDecimal(
								sessionStateManage.isExists("languageId") ? sessionStateManage
										.getSessionValue("languageId") : "1"),
						getCountryId());

	}

	/**
	 * method is responsible to populate List of Bank
	 * 
	 * @return
	 */

	public void popBank(AjaxBehaviorEvent e) {
		bankMasterList = new ArrayList<BankMaster>();
		SessionStateManage sessionStateManage = new SessionStateManage();
		
		bankMasterList.addAll(getGeneralService().getAllBankList(new BigDecimal(sessionStateManage.isExists("languageId")?sessionStateManage.getSessionValue("languageId"):"1"),getCountryId()));
	}
	
	
	public void popBankBranch(AjaxBehaviorEvent e) {
		System.out.println("..................");
		bankBranchList = new ArrayList<BankBranch>();
		bankBranchList.addAll(getGeneralService().getBankBranchList(getCountryId(),getBankId()));
		
	}

	/**
	 * Responsible to save Bank Account details
	 * 
	 * @return
	 */
	public String save() {

		BankAccount bankaccount = new BankAccount();

	
		CountryMaster countryMaster =  new CountryMaster();
		countryMaster.setCountryId(getCountryId());
		bankaccount.setFsCountryMaster(countryMaster);
		
		CompanyMaster companymaster = new CompanyMaster();
		companymaster.setCompanyId(new BigDecimal(1));
		bankaccount.setFsCompanyMaster(companymaster);

		BankMaster bankmaster = new BankMaster();
		bankmaster.setBankId(getBankId());
		bankaccount.setExBankMaster(bankmaster);

		BankBranch bankbranch = new BankBranch();
		bankbranch.setBankBranchId(getBranchId());
		bankaccount.setExBankBranch(bankbranch);

		bankaccount.setBankAccountId(getBankAccountId());
		bankaccount.setCurrencyCode(getCurrencyCode());
		bankaccount.setDebitAcct(getDebitAccount());
	

		if (getBankAccountId() != null && getBankAccountId().intValue() != 0) {

			bankaccount.setModifier("Nazish");
			bankaccount.setUpdateDate(new Date());
			bankaccount.setRecordStatus("U");

		} else {

			bankaccount.setCreator("Nazish");
			bankaccount.setCreateDate(new Date());
			bankaccount.setRecordStatus("A");
		}

		getIbankAccountService().saveBankAccount(bankaccount);

		return "";
	}

	/**
	 * for Clear the field
	 * 
	 */
	public void reset() {
		setCountryId(null);
		setBankId(null);
		setBranchId(null);
		setCurrencyCode("");
		setDebitAccount("");
	}
	
	public void cancel() {
		try{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("../login/login.xhtml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
