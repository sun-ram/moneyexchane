/**
 * author Arul JayaSingh
 */
package com.amg.exchange.treasury.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amg.exchange.daoimpl.CustomHibernateDaoSupport;
import com.amg.exchange.model.BankBranch;
import com.amg.exchange.model.BankMaster;
import com.amg.exchange.model.CityMaster;
import com.amg.exchange.model.CompanyMaster;
import com.amg.exchange.model.CountryMaster;
import com.amg.exchange.model.DistrictMaster;
import com.amg.exchange.model.NationalityMaster;
import com.amg.exchange.model.StateMaster;
import com.amg.exchange.treasury.dao.IBankBranchDetailsDao;

@Repository
public class BankBranchDetailsDaoImpl<T> extends CustomHibernateDaoSupport implements IBankBranchDetailsDao<T> {

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getNationality()
	 */
	@Override
	public List<NationalityMaster> getNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getCity(java.math.BigDecimal)
	 */
	@Override
	public List<CityMaster> getCity(BigDecimal districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getCountry()
	 */
	@Override
	public List<CountryMaster> getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getState()
	 */
	@Override
	public List<StateMaster> getState() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getCompany(java.math.BigDecimal)
	 */
	@Override
	public List<CompanyMaster> getCompany(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getState(java.math.BigDecimal)
	 */
	@Override
	public List<StateMaster> getState(BigDecimal countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.IMutualDao#getDistrict(java.math.BigDecimal)
	 */
	@Override
	public List<DistrictMaster> getDistrict(BigDecimal stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		getSession().save(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#update(java.lang.Object)
	 */
	@Override
	public void update(T entity) {
		getSession().saveOrUpdate(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
	 getSession().delete(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#findByName(java.lang.String)
	 */
	@Override
	public List<T> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#findById(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findById(int id) {
		
		return (List<T>) getSession().get(BankBranch.class, id);
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#findAll()
	 */
	@Override
	public List<T> findAll() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.dao.ICommonDao#findAll(org.hibernate.criterion.DetachedCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return criteria.getExecutableCriteria(getSession()).list();
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#saveBankBaranchDetail(com.amg.exchange.model.BankBranch)
	 */
	public void saveBankBranchDetail(BankBranch bankBranch) {
		try{
			System.out.println("save or update branch..");
		getSession().saveOrUpdate(bankBranch);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#getBankBranchList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BankBranch> getBankBranchList() {
		
		return getSession().createQuery("from BankBranch").list();
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#getBankBranchByBranchCode(java.lang.String)
	 */
	@Override
	public List<BankBranch> getBankBranchByBranchCode(String branchCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankBranch.class,"BankBranch");
		
		detachedCriteria.add(Restrictions.eq("branchCode", branchCode));
		
		detachedCriteria.setFetchMode("BankBranch.fsCountryMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsStateMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsStateMaster", "fsStateMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsDistrictMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsDistrictMaster", "fsDistrictMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsCityMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsCityMaster", "fsCityMaster", CriteriaSpecification.INNER_JOIN);
		
		return (List<BankBranch>)findAll(detachedCriteria);
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#getBankBranchByBranchID(java.lang.String)
	 */
	@Override
	public List<BankBranch> getBankBranchByBranchID(String branchID) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BankBranch.class,"BankBranch");
		
		detachedCriteria.add(Restrictions.eq("branchCode", branchID));
		
		detachedCriteria.setFetchMode("BankBranch.fsCountryMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsCountryMaster", "fsCountryMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsStateMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsStateMaster", "fsStateMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsDistrictMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsDistrictMaster", "fsDistrictMaster", CriteriaSpecification.INNER_JOIN);
		
		detachedCriteria.setFetchMode("BankBranch.fsCityMaster", FetchMode.JOIN);
		detachedCriteria.createAlias("BankBranch.fsCityMaster", "fsCityMaster", CriteriaSpecification.INNER_JOIN);
		
		return (List<BankBranch>)findAll(detachedCriteria);
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#getBankList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BankMaster> getBankList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from BankMaster").list();
	}

	/* (non-Javadoc)
	 * @see com.amg.exchange.treasury.dao.IBankBranchDetailsDao#checkBranchCode(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BankBranch> checkBranchCode(String branchCode) {
	
		return getSession().createQuery("from BankBranch where branchCode="+branchCode).list();
		
	}

	

}
