package com.amg.exchange.dao;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.model.Amlstatus;
import com.amg.exchange.model.ContactDetail;
import com.amg.exchange.model.ContactType;
import com.amg.exchange.model.CorporateBusinessNature;
import com.amg.exchange.model.CustCorporateAddlDetail;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.CustomerIdProof;
import com.amg.exchange.model.DocumentImg;
import com.amg.exchange.model.IdentityType;
import com.amg.exchange.model.RuleBusinessNature;
import com.amg.exchange.model.RuleObjective;

public interface ICorporateRegDao<T> extends ICommonDao<T>, IMutualDao {

	public List<Amlstatus> getAMLStatusList(String compName);
	public List<IdentityType> getIdentitiesTypeList();
	public void saveCorporateCustomer(Customer cust);
	public void saveCorporateContDtl(ContactDetail contdetail);
	public void saveCoIdentityDoc(CustomerIdProof custmrIdProof);
	public void savePartnerDtl(CustomerIdProof custmrIdProof);
	public void saveAuthouSigDoc(CustomerIdProof custmrIdProof);
	public List<RuleObjective> getObjectiveList();
	public List<RuleBusinessNature> getCorpBussinessNature();
	public List<ContactType> getContactTypeListFromDB();
	
	public void saveBussnessNature(CorporateBusinessNature corpBussnsNature);
	public List<Customer> getCompanyRegistrationStatus(String crno);
	public List<ContactDetail> getContactDetail(BigDecimal customerId);
	
	public List<CustomerIdProof> getCustomerIdProof(BigDecimal languageId, BigDecimal customerId, BigDecimal customerTypeId);
	public List<CustCorporateAddlDetail> getCustomerCorporateAdditionalDetail(BigDecimal languageId, BigDecimal customerId);
	public List<CorporateBusinessNature> getCorporateBusinessNatureDetails(BigDecimal customerId);
	public void updateCorpCustomer(Customer corprateCustomer);
	public void updateContact(ContactDetail contdetail, BigDecimal customerId);
	public void updateCompanyIdentityDocument(CustomerIdProof custmrIdProof,BigDecimal customerId);
	public void updateBussnessNature(CorporateBusinessNature corpBussnsNature,BigDecimal customerId);
	public void updatePartnerDetail(CustomerIdProof custmrIdProof,BigDecimal customerId);
	public void updateAutourSignatoriesDetail(CustomerIdProof custmrIdProof,BigDecimal customerId);
	public void updateSecondaryObjective(CustCorporateAddlDetail custCorpAddDetail, BigDecimal customerId);
	public List<IdentityType> getIdentityTypes(BigDecimal languageId,
			BigDecimal bdCompanyIdType);
	public List<CustomerIdProof> getIdNoAvailabilityStatus(String idno,
			BigDecimal bdCompanyIdType); 

	//for image upload
	public void saveImage(DocumentImg document);
	public void updateImage(DocumentImg document, BigDecimal custId);
	public List<DocumentImg> getImage(BigDecimal imageId);
	public void commonSaveOrUpdateIdProof(CustomerIdProof custmrIdProof);
	public void saveOrUpdateSecondaryObjective(CustCorporateAddlDetail custCorpAddDetail);
	public List<CustomerIdProof> getRegisterId(String registerId);
	public List<Customer> getCustomerNameFromCustomer(BigDecimal customerIdLocal);
}
