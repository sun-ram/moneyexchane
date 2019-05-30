package com.amg.exchange.bean;

/**
 * @author Arul JayaSingh
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.service.ILoginService;
import com.amg.exchange.service.IUserSignUpService;
import com.amg.exchange.util.iCypherSecurity;
import com.amg.exchange.util.impl.CypherSecurityImpl;

@Component("changepassword")
@SessionScoped
public class ChangePassword<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6943727369371894292L;

	public Logger log = Logger.getLogger(ChangePassword.class);
	@Autowired
	ILoginService<T> loginService;
	@Autowired
	IUserSignUpService<T> userSignupService;

	private String oldPassword;
	private String newPassword;
	private String retypePassword;
	private String statusMsg;
	private String passwordMatchMessage;
	private String passewordLengthValidateMsg;
	private String globalmessage;
	private CustomerLogin customerLogin;

	List<CustomerLogin> customerInfo = null;

	public ChangePassword() {

	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return this.oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPass
	 */
	public String getNewPassword() {
		return this.newPassword;
	}

	/**
	 * @param newPass
	 *            the newPass to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the retypePassword
	 */
	public String getRetypePassword() {
		return this.retypePassword;
	}

	/**
	 * @param retypePassword
	 *            the retypePassword to set
	 */
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return this.statusMsg;
	}

	/**
	 * @param statusMsg
	 *            the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	/**
	 * @return the passwordMatchMessage
	 */
	public String getPasswordMatchMessage() {
		return this.passwordMatchMessage;
	}

	/**
	 * @param passwordMatchMessage
	 *            the passwordMatchMessage to set
	 */
	public void setPasswordMatchMessage(String passwordMatchMessage) {
		this.passwordMatchMessage = passwordMatchMessage;
	}

	/**
	 * @return the passewordLengthValidateMsg
	 */
	public String getPassewordLengthValidateMsg() {
		return this.passewordLengthValidateMsg;
	}

	/**
	 * @param passewordLengthValidateMsg
	 *            the passewordLengthValidateMsg to set
	 */
	public void setPassewordLengthValidateMsg(String passewordLengthValidateMsg) {
		this.passewordLengthValidateMsg = passewordLengthValidateMsg;
	}

	/**
	 * @return the userSignupService
	 */
	public IUserSignUpService<T> getUserSignupService() {
		return this.userSignupService;
	}

	/**
	 * @param userSignupService
	 *            the userSignupService to set
	 */
	public void setUserSignupService(IUserSignUpService<T> userSignupService) {
		this.userSignupService = userSignupService;
	}

	/**
	 * @return the globalmessage
	 */
	public String getGlobalmessage() {
		return this.globalmessage;
	}

	/**
	 * @param globalmessage
	 *            the globalmessage to set
	 */
	public void setGlobalmessage(String globalmessage) {
		this.globalmessage = globalmessage;
	}

	/**
	 * @return the loginService
	 */
	public ILoginService<T> getLoginService() {
		return this.loginService;
	}

	/**
	 * @param loginService
	 *            the loginService to set
	 */
	public void setLoginService(ILoginService<T> loginService) {
		this.loginService = loginService;
	}

	/**
	 * @return the customerLogin
	 */
	public CustomerLogin getCustomerLogin() {
		return this.customerLogin;
	}

	/**
	 * @param customerLogin
	 *            the customerLogin to set
	 */
	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}

	public void reset() {
		this.newPassword = null;
		this.oldPassword = null;
		this.retypePassword = null;
		setStatusMsg(null);
		setPassewordLengthValidateMsg(null);
		setPasswordMatchMessage(null);
		}

	public boolean checkPassword() {

		boolean ret = true;
		String userName = (String) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("userName");
		try {
			customerInfo = new ArrayList<CustomerLogin>();
			iCypherSecurity cypherSecurity = new CypherSecurityImpl();
			customerInfo.addAll(getLoginService().getLoginInfoForCustomer(
					userName,
					cypherSecurity.encodePassword(getOldPassword(), userName)));
			log.info("cust size;;;;" + customerInfo.size());
			if (customerInfo.size() == 1) {

				log.info("Password success" + getOldPassword());
			} else {
				ret = false;

				log.info("Enter Correct Password" + getOldPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	public String updatePassword() {
		String userName = (String) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("userName");

		iCypherSecurity cypherSecurity = new CypherSecurityImpl();
		FacesMessage facesMessage = null;
		boolean isAvailable = false;
		try {
			isAvailable = getLoginService().getLoginInfoForCustomer(userName,
					cypherSecurity.encodePassword(getNewPassword(), userName))
					.size() > 0 ? true : false;
		} catch (Exception e) {
			log.info("New Password is not available :: " + e);
		}
		if (!checkPassword()) {
			facesMessage = new FacesMessage("Current password incorrect!");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(
					"changePasswordForm:oldpassword", facesMessage);
		} else if (getOldPassword().equals(getNewPassword())) {
			setPassewordLengthValidateMsg("New password not equal to Current Password");
			facesMessage = new FacesMessage(getPassewordLengthValidateMsg());
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(
					"changePasswordForm:newpassword", facesMessage);
		} else if (isAvailable) {
			setPassewordLengthValidateMsg("New password not equal to Current Password");
			facesMessage = new FacesMessage(getPassewordLengthValidateMsg());
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(
					"changePasswordForm:newpassword", facesMessage);
		} else {
			setPassewordLengthValidateMsg("");
			try {
				setGlobalmessage("Enter password");
				if (userName != null && getOldPassword() != null
						&& getOldPassword() != "") {

					log.info("customerInfo  :"
							+ customerInfo.get(0).getCustLoginId());
					customerInfo.get(0).setPassword(
							cypherSecurity.encodePassword(getNewPassword(),
									userName));
					getUserSignupService().updateChangePassword(
							customerInfo.get(0));
				}
				log.info("Password update sucess");
			} catch (Exception e) {
				setStatusMsg("Please Enter Valid Password");
				e.printStackTrace();
				return "changepassword?faces-redirect=true";
			}

			return "login?faces-redirect=true";
		}

		return null;
	}
}
