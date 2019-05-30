/**
 * @author Arul JayaSingh
 */
package com.amg.exchange.treasury.dao;

import java.util.List;

import com.amg.exchange.dao.ICommonDao;
import com.amg.exchange.dao.IMutualDao;
import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.BankMaster;



public interface IBankBranchDetailsDao<T> extends IMutualDao,ICommonDao<T> {
	public void saveBankBranchDetail(BankBranch bankBranch);
	public List<BankBranch> getBankBranchList();
	public List<BankBranch> getBankBranchByBranchCode(String branchCode);
	public List<BankBranch> getBankBranchByBranchID(String branchID);
	public List<BankMaster> getBankList();
	public List<BankBranch> checkBranchCode(String branchCode);
}
