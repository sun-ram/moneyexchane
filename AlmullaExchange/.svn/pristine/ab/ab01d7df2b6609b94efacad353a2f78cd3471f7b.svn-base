/**
 * "@author Arul JayaSingh
 */
package com.amg.exchange.treasury.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;









import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.service.ICommonService;
import com.amg.exchange.service.IMutualService;
import com.amg.exchange.treasury.dao.IBankBranchDetailsDao;
import com.amg.exchange.treasury.service.IBankBranchDetailsService;


/**
 * @author exim07
 *
 */
@Service("bankBranchDetailsServiceImpl")
public class BankBranchDetailsServiceImpl<T> implements IBankBranchDetailsService<T>,ICommonService<T>,IMutualService<T> {

	
	@Autowired
	IBankBranchDetailsDao<T> iBankBranchDetailsDao;
	
	
	
	/**
	 * @return the iBankBranchDetailsDao
	 */
	public IBankBranchDetailsDao<T> getiBankBranchDetailsDao() {
		return this.iBankBranchDetailsDao;
	}

	/**
	 * @param iBankBranchDetailsDao the iBankBranchDetailsDao to set
	 */
	public void setiBankBranchDetailsDao(
			IBankBranchDetailsDao<T> iBankBranchDetailsDao) {
		this.iBankBranchDetailsDao = iBankBranchDetailsDao;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getNationality()
	 */
	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getCity(java.math.BigDecimal)
	 */
	@Override
	public List<CityMaster> getCity(BigDecimal districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getCountry()
	 */
	@Override
	public List<CountryMaster> getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getState()
	 */
	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getCompany(java.math.BigDecimal)
	 */
	@Override
	public List<CompanyMaster> getCompany(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getState(java.math.BigDecimal)
	 */
	@Override
	public List<StateMaster> getState(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.IMutualService#getDistrict(java.math.BigDecimal)
	 */
	@Override
	public List<DistrictMaster> getDistrict(BigDecimal stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.ICommonService#save(java.lang.Object)
	 */
	@Transactional
	@Override
	public void save(T entity) {
		getiBankBranchDetailsDao().save(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.ICommonService#update(java.lang.Object)
	 */
	@Transactional
	@Override
	public void update(T entity) {
		getiBankBranchDetailsDao().update(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.service.ICommonService#delete(java.lang.Object)
	 */
	@Transactional
	@Override
	public void delete(T entity) {
		getiBankBranchDetailsDao().delete(entity);
		
	}

	
	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#saveBankBaranchDetail(com.amg.exchange.model.BankBranch)
	 */
	@Transactional
	public void saveBankBranchDetail(BankBranch bankBranch) {
		try{
			System.out.println("saveBankBranchDetail  :");
		getiBankBranchDetailsDao().saveBankBranchDetail(bankBranch);
		System.out.println(".....");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.service.IBankBranchDetailsService#getBankBranchList()
	 */
	@Transactional
	@Override
	public List<BankBranch> getBankBranchList() {
		
		return getiBankBranchDetailsDao().getBankBranchList();
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.service.IBankBranchDetailsService#getBankBranchByBranchCode(java.lang.String)
	 */
	@Transactional
	public List<BankBranch> getBankBranchByBranchCode(String branchCode) {
		
		return getiBankBranchDetailsDao().getBankBranchByBranchCode(branchCode);
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.service.IBankBranchDetailsService#getBankBranchByBranchID(java.lang.String)
	 */
	@Transactional
	@Override
	public List<BankBranch> getBankBranchByBranchID(String branchID) {
		return getiBankBranchDetailsDao().getBankBranchByBranchID(branchID);
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.service.IBankBranchDetailsService#getBankList()
	 */
	@Transactional
	public List<BankMaster> getBankList() {
		return getiBankBranchDetailsDao().getBankList();
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.service.IBankBranchDetailsService#checkBranchCode(java.lang.String)
	 */
	@Transactional
	@Override
	public List<BankBranch> checkBranchCode(String BranchCode) {
		return getiBankBranchDetailsDao().checkBranchCode(BranchCode);
	}

	



}
