/**
 * "@author Arul JayaSingh
 */
package com.amg.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import com.amg.exchange.bean.NomineeBean;
import com.amg.exchange.model.Customer;
import com.amg.exchange.model.Nominee;

/**
 * @author exim07
 * @param <T>
 *
 */
public interface INomineeService<T> extends  IMutualService<T> {
	public List<Customer> getNomineeDetail(String civilID);
	public void saveNomineeDetail(Nominee nominee);
	public List<Nominee> getNomineeList(BigDecimal nominatorId);
	public void deleteNominee(NomineeBean nominee);

}
