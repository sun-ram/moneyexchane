package com.amg.exchange.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.Employee;
import com.amg.exchange.service.ILoginService;
import com.amg.exchange.service.IUserSignUpService;
import com.amg.exchange.util.iCypherSecurity;
import com.amg.exchange.util.impl.CypherSecurityImpl;

@Component("loginBean")
@Scope("session")
public class LoginBean<T> implements Serializable {

	private static final long serialVersionUID = 8707881109236830864L;

	private String username;
	private String password;
	private String forReg = "Customer";

	private Boolean isValidate = false;

	@Autowired
	ILoginService<T> loginService;
	public ILoginService<T> getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService<T> loginService) {
		this.loginService = loginService;
	}
	
	@Autowired
	IUserSignUpService<T> userSignUpService;

	@Autowired
	RemmiterInfoManageBean<T> remInfo;

	public RemmiterInfoManageBean<T> getRemInfo() {
		return remInfo;
	}

	public void setRemInfo(RemmiterInfoManageBean<T> remInfo) {
		this.remInfo = remInfo;
	}

	

	public String getUsername() {
		return username;
	}
	
	/**
	 * @return the userSignUpService
	 */
	public IUserSignUpService<T> getUserSignUpService() {
		return this.userSignUpService;
	}

	/**
	 * @param userSignUpService the userSignUpService to set
	 */
	public void setUserSignUpService(IUserSignUpService<T> userSignUpService) {
		this.userSignUpService = userSignUpService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getForReg() {
		return forReg;
	}

	public void setForReg(String forReg) {
		this.forReg = forReg;
	}

	/**
	 * @return the isValidate
	 */
	public Boolean getIsValidate() {
		return this.isValidate;
	}

	/**
	 * @param isValidate
	 *            the isValidate to set
	 */
	public void setIsValidate(Boolean isValidate) {
		this.isValidate = isValidate;
	}

	List<CustomerLogin> lstLoginInfo;
	List<Employee> lstEmpLogin;

	public String login() {
		lstLoginInfo = new ArrayList<CustomerLogin>();
		
		String page = null;
		String userName=getUsername().trim();
		String password=getPassword();
		iCypherSecurity cypherSecurity = new CypherSecurityImpl();
		if (forReg.equalsIgnoreCase("Customer")) {
			
			try{
				CustomerLogin customerLogin = getUserSignUpService().searchUser(userName).get(0);
				userName = customerLogin.getUserName();
				
				lstLoginInfo.addAll(getLoginService().getLoginInfoForCustomer(userName,cypherSecurity.encodePassword(password,userName)));
				if (lstLoginInfo.size() == 1) {
					
					setIsValidate(false);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName", userName);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("countryId", lstLoginInfo.get(0).getFsCountryMaster().getCountryId());
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("companyId", "1");
					
					String customerId = lstLoginInfo.get(0).getFsCustomer() ==null? "empty": lstLoginInfo.get(0).getFsCustomer().getCustomerId().toPlainString();
					page = getRemInfo().view(getUsername(), customerId, lstLoginInfo.get(0).getEmail());
				} else {
					// setBooValidate(true);
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Invalid Login!", "Please Try Again!"));
					page = "";
				}
			} catch(Exception e){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Invalid Login!", "Please Try Again!"));
				page = "";
			}

		} else {
			
			lstEmpLogin = new ArrayList<Employee>();

			lstEmpLogin.addAll(getLoginService().getLoginInfoForEmployee(userName,password));
			
			
			System.out.println("Size of Login : "+lstEmpLogin.size());
			
			if (lstEmpLogin.size() == 1) {
				page = "branchHome";
				setIsValidate(false);
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName", userName);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("countryId", 120);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("companyId", "1");
			} else {
				setIsValidate(true);
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));

				page = "";
			}
		}
		System.out.println("Returning : "+page);
		return page;
	}

	public String newUser() {
		return "usersignup";
	}

	//Create a link for forgot password
	public String goForgotPasword(){
		return "forgotpassword";
	}
		
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "login";
	}
}
