/**
 * "@author Arul JayaSingh
 */
package com.amg.exchange.treasury.service;

import java.util.List;

import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;


/**
 * @author exim07
 *
 */
public interface IBankBranchDetailsService<T> extends IMutualService<T>, ICommonService<T> {
	public void saveBankBranchDetail(BankBranch bankBranch);
	public List<BankBranch> getBankBranchList();
	public List<BankBranch> getBankBranchByBranchCode(String branchCode);
	public List<BankBranch> getBankBranchByBranchID(String branchID);
	public List<BankMaster> getBankList();
	public List<BankBranch> checkBranchCode(String branchCode);
}
