package com.amg.exchange.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amg.exchange.common.TokenGeneration;
import com.amg.exchange.mail.ApplicationMailer;
import com.amg.exchange.model.CustomerLogin;
import com.amg.exchange.model.SecurityQuestionMaster;
import com.amg.exchange.service.IForgotPasswordService;
import com.amg.exchange.util.SessionStateManage;
import com.amg.exchange.util.iCypherSecurity;
import com.amg.exchange.util.impl.CypherSecurityImpl;

@Component("forgotpassword")
@ViewScoped
public class ForgotPasswordBean<T> implements Serializable {

	//TODO : Variables and object declaration
	private static final long serialVersionUID = 6965017961255250321L;

	private BigDecimal languageId;

	private String username;
	private String questionUsername;
	private String emailid;
	private boolean userAvailableStatus;
	private String userAvailableStatusMsg;
	private boolean quesUserAvailableStatus;
	private String quesUserAvailableStatusMsg;
	private String globalmessage;
	private String panelQuestion = "";
	private String panelQuestionAnswer = "";

	private int forgotoptions;
	private int rightAnswerCount = 2;
	private boolean optiongridstatus = true;
	private boolean usergridstatus = false;
	private boolean questiongridstatus = false;
	private boolean globalgridstatus = false;
	private boolean questionUsernameVisibility = false;
	private boolean questionUsernameavailablity = false;

	private int currentDisplayId = -1;

	private List<BigDecimal> lstQuestionId = new ArrayList<BigDecimal>();
	private List<ForgotPasswordQuestionBean> lstQuestionList = new ArrayList<ForgotPasswordQuestionBean>();
	private List<SecurityQuestionMaster> lstSecurityQuestionMaster = new ArrayList<SecurityQuestionMaster>();
	private CustomerLogin customerLogin;

	//TODO : Auto wired service declaration
	@Autowired
	IForgotPasswordService<T> forgotPasswordService;

	@Autowired
	ApplicationMailer mailService;

	//TODO : Getter And Setter Methods

	public ApplicationMailer getMailService() {
		return mailService;
	}

	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}

	public int getRightAnswerCount() {
		return rightAnswerCount;
	}

	public void setRightAnswerCount(int rightAnswerCount) {
		this.rightAnswerCount = rightAnswerCount;
	}

	public String getPanelQuestionAnswer() {
		return panelQuestionAnswer;
	}

	public void setPanelQuestionAnswer(String panelQuestionAnswer) {
		this.panelQuestionAnswer = panelQuestionAnswer;
	}

	public String getPanelQuestion() {
		return panelQuestion;
	}

	public void setPanelQuestion(String panelQuestion) {
		this.panelQuestion = panelQuestion;
	}

	public boolean isQuestionUsernameavailablity() {
		return questionUsernameavailablity;
	}

	public void setQuestionUsernameavailablity(boolean questionUsernameavailablity) {
		this.questionUsernameavailablity = questionUsernameavailablity;
	}

	public boolean isQuestionUsernameVisibility() {
		return questionUsernameVisibility;
	}

	public void setQuestionUsernameVisibility(boolean questionUsernameVisibility) {
		this.questionUsernameVisibility = questionUsernameVisibility;
	}

	public int getCurrentDisplayId() {
		return currentDisplayId;
	}

	public void setCurrentDisplayId(int currentDisplayId) {
		this.currentDisplayId = currentDisplayId;
	}

	public List<ForgotPasswordQuestionBean> getLstQuestionList() {
		return lstQuestionList;
	}

	public void setLstQuestionList(List<ForgotPasswordQuestionBean> lstQuestionList) {
		this.lstQuestionList = lstQuestionList;
	}

	public List<BigDecimal> getLstQuestionId() {
		return lstQuestionId;
	}

	public void setLstQuestionId(List<BigDecimal> lstQuestionId) {
		this.lstQuestionId = lstQuestionId;
	}

	public List<SecurityQuestionMaster> getLstSecurityQuestionMaster() {
		return lstSecurityQuestionMaster;
	}

	public void setLstSecurityQuestionMaster(List<SecurityQuestionMaster> lstSecurityQuestionMaster) {
		this.lstSecurityQuestionMaster = lstSecurityQuestionMaster;
	}

	public void setMailService(ApplicationMailer mailService) {
		this.mailService = mailService;
	}

	public BigDecimal getLanguageId() {
		return languageId;
	}

	public boolean isQuesUserAvailableStatus() {
		return quesUserAvailableStatus;
	}

	public void setQuesUserAvailableStatus(boolean quesUserAvailableStatus) {
		this.quesUserAvailableStatus = quesUserAvailableStatus;
	}

	public String getQuesUserAvailableStatusMsg() {
		return quesUserAvailableStatusMsg;
	}

	public void setQuesUserAvailableStatusMsg(String quesUserAvailableStatusMsg) {
		this.quesUserAvailableStatusMsg = quesUserAvailableStatusMsg;
	}

	public boolean isOptiongridstatus() {
		return optiongridstatus;
	}

	public void setOptiongridstatus(boolean optiongridstatus) {
		this.optiongridstatus = optiongridstatus;
	}

	public boolean isUsergridstatus() {
		return usergridstatus;
	}

	public void setUsergridstatus(boolean usergridstatus) {
		this.usergridstatus = usergridstatus;
	}

	public boolean isQuestiongridstatus() {
		return questiongridstatus;
	}

	public void setQuestiongridstatus(boolean questiongridstatus) {
		this.questiongridstatus = questiongridstatus;
	}

	public String getQuestionUsername() {
		return questionUsername;
	}

	public void setQuestionUsername(String questionUsername) {
		this.questionUsername = questionUsername;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getGlobalmessage() {
		return globalmessage;
	}

	public void setGlobalmessage(String globalmessage) {
		this.globalmessage = globalmessage;
	}

	public boolean isGlobalgridstatus() {
		return globalgridstatus;
	}

	public void setGlobalgridstatus(boolean globalgridstatus) {
		this.globalgridstatus = globalgridstatus;
	}

	public boolean isUserAvailableStatus() {
		return userAvailableStatus;
	}

	public void setUserAvailableStatus(boolean userAvailableStatus) {
		this.userAvailableStatus = userAvailableStatus;
	}

	public String getUserAvailableStatusMsg() {
		return userAvailableStatusMsg;
	}

	public void setUserAvailableStatusMsg(String userAvailableStatusMsg) {
		this.userAvailableStatusMsg = userAvailableStatusMsg;
	}

	public int getForgotoptions() {
		return forgotoptions;
	}

	public void setForgotoptions(int forgotoptions) {
		this.forgotoptions = forgotoptions;
	}

	public IForgotPasswordService<T> getForgotPasswordService() {
		return forgotPasswordService;
	}

	public void setForgotPasswordService(IForgotPasswordService<T> forgotPasswordService) {
		this.forgotPasswordService = forgotPasswordService;
	}

	//TODO : Bean Methods

	//check username is exists or not
	public void checkUsername(AjaxBehaviorEvent event) {

		try {
			if (getForgotPasswordService().getCustomerDetail(getUsername()).size() > 0) {
				setUserAvailableStatus(true);
				setUserAvailableStatusMsg("");
			} else {
				setUserAvailableStatus(false);
				setUserAvailableStatusMsg("Invalid Username");
			}
		} catch (Exception e) {
			setUserAvailableStatus(false);
			setUserAvailableStatusMsg("Invalid Username");
		}
	}

	//check username (Question based) is exists or not
	public void checkUsernameQuestionBased(AjaxBehaviorEvent event) {

		try {
			
			//Get customer login list based on user entered user name
			List<CustomerLogin> lstCustomerLogin = getForgotPasswordService().getCustomerDetail(getQuestionUsername());
			
			//Check user exist or not
			if (lstCustomerLogin.size() > 0) {
				setQuestionUsernameavailablity(true);
			} else {
				setQuestionUsernameavailablity(false);
			}

			//Get language id from session
			SessionStateManage sessionStateManage = new SessionStateManage();
			setLanguageId(new BigDecimal(sessionStateManage.isExists("languageId") ? sessionStateManage.getSessionValue("languageId") : "1"));

			//Clear list objects
			lstQuestionId.clear();
			lstQuestionList.clear();
			
			//Prepare security question and and answer bean
			for (CustomerLogin customerLogin : lstCustomerLogin) {

				setCustomerLogin(customerLogin);

				//Prepare security question id list
				lstQuestionId.add(customerLogin.getSecurityQuestion1());
				lstQuestionId.add(customerLogin.getSecurityQuestion2());
				lstQuestionId.add(customerLogin.getSecurityQuestion3());
				lstQuestionId.add(customerLogin.getSecurityQuestion4());
				lstQuestionId.add(customerLogin.getSecurityQuestion5());
				
				//Get security question detail from database which is related to user question 
				setLstSecurityQuestionMaster(getForgotPasswordService().getQuestionMasterDescDetail(getLanguageId(), lstQuestionId));
				
				int position = 0;
				
				ForgotPasswordQuestionBean forgotPasswordQuestionBean = new ForgotPasswordQuestionBean();
				
				//Prepare bean for verification
				for (SecurityQuestionMaster securityQuestionMaster : getLstSecurityQuestionMaster()) {

					forgotPasswordQuestionBean = new ForgotPasswordQuestionBean(position, securityQuestionMaster.getQuestionId(), securityQuestionMaster.getQuestionDesc(), "", "");

					//Set security question actual answer which is entered by user at the time of user registration
					if (securityQuestionMaster.getQuestionId().equals(customerLogin.getSecurityQuestion1())) {
						forgotPasswordQuestionBean.setQuestionactualanswer(customerLogin.getSecurityAnswer1());
					} else if (securityQuestionMaster.getQuestionId().equals(customerLogin.getSecurityQuestion2())) {
						forgotPasswordQuestionBean.setQuestionactualanswer(customerLogin.getSecurityAnswer2());
					} else if (securityQuestionMaster.getQuestionId().equals(customerLogin.getSecurityQuestion3())) {
						forgotPasswordQuestionBean.setQuestionactualanswer(customerLogin.getSecurityAnswer3());
					} else if (securityQuestionMaster.getQuestionId().equals(customerLogin.getSecurityQuestion4())) {
						forgotPasswordQuestionBean.setQuestionactualanswer(customerLogin.getSecurityAnswer4());
					} else if (securityQuestionMaster.getQuestionId().equals(customerLogin.getSecurityQuestion5())) {
						forgotPasswordQuestionBean.setQuestionactualanswer(customerLogin.getSecurityAnswer5());
					}

					lstQuestionList.add(forgotPasswordQuestionBean);
					position++;
				}
			}
			
			//Prepare user availability message
			if (lstCustomerLogin.size() > 0) {
				setQuesUserAvailableStatus(true);
				setQuesUserAvailableStatusMsg("");
			} else {
				setQuesUserAvailableStatus(true);
				setQuesUserAvailableStatusMsg("Invalid username");
			}
		} catch (Exception e) {
			setQuesUserAvailableStatus(true);
			setQuesUserAvailableStatusMsg("Invalid username");
		}
	}

	//Show display depends on selection
	public void showPanel(AjaxBehaviorEvent event) {
		if (getForgotoptions() == 1) {
			falseAll();
			setUsergridstatus(true);
		} else if (getForgotoptions() == 2) {
			falseAll();
			setQuestiongridstatus(true);
			setQuestionUsernameVisibility(true);
		} else {

		}
	}

	//Reset password when user knows their user name and email id
	public void resetPassword() {
		try {
			
			//Check user name and email combination is available or not
			try {
				setCustomerLogin(getForgotPasswordService().getCustomerDetail(getUsername(), getEmailid()).get(0));
			} catch (Exception e) {
				setGlobalmessage("Invalid combination of username and email id");
				throw e;
			}

			//Call password reset method
			resettingPassword();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		String message = getGlobalmessage();
		falseAll();
		resetFields();
		setGlobalmessage(message);
		setGlobalgridstatus(true);
	}

	

	//When user click next button 
	public void nextQuestion() {

		boolean isLast = false;
		boolean rightAttempt = false;
		
		//Check user name availability. if exists then continue the process otherwise it will ask proper user name
		if (isQuestionUsernameavailablity()) {

			if (isQuestionUsernameVisibility()) {
				setQuestionUsernameVisibility(false);
			} else {
			}
			
			//For display next security question
			nextPosition();
			
			
			if (getCurrentDisplayId() < lstQuestionList.size()) {
				if (lstQuestionList.size() > 0 && getCurrentDisplayId() < lstQuestionList.size() && getCurrentDisplayId() >= 0) {
					setPanelQuestion(lstQuestionList.get(getCurrentDisplayId()).getQuestiondesc());
				}
				if (getCurrentDisplayId() > 0) {
					lstQuestionList.get(getCurrentDisplayId() - 1).setQuestionanswer(getPanelQuestionAnswer());
					setPanelQuestionAnswer("");
				}

			} else {//when cursor move to last question
				lstQuestionList.get(getCurrentDisplayId() - 1).setQuestionanswer(getPanelQuestionAnswer());
				setPanelQuestionAnswer("");
				isLast = true;
			}

			int tempCount = 0;
			iCypherSecurity cypherSecurity = new CypherSecurityImpl();
			for (ForgotPasswordQuestionBean forgotPasswordQuestionBean : lstQuestionList) {
				
				//Check the answer is correct or not
				if (cypherSecurity.isValidSecret(forgotPasswordQuestionBean.getQuestionactualanswer(), forgotPasswordQuestionBean.getQuestionanswer(), getCustomerLogin().getUserName())) {
					tempCount++;
				}
				
				//Check how many correct answer's . this count cross get right answer count system automatically reset user password
				if (getRightAnswerCount() == tempCount) {

					resettingPassword();

					String message = getGlobalmessage();
					falseAll();
					resetFields();
					setGlobalmessage(message);
					setGlobalgridstatus(true);
					rightAttempt = true;
					break;
				}
			}

			//If all answers are failed then following block will execute
			if (isLast && !rightAttempt) {
				setGlobalmessage("Unable to reset your password, Your security question answers are not matched !");
				String message = getGlobalmessage();
				falseAll();
				resetFields();
				setGlobalmessage(message);
				setGlobalgridstatus(true);
			}
		}

	}


	//Make screen look like initial screen
	public void resetForgotPassword() {

		falseAll();
		resetFields();
		setOptiongridstatus(true);
	}
	
	//Reset password and send mail to user with reseted password
	private void resettingPassword() {
		try {
			
			//Get random password
			String resetKey = new TokenGeneration().getRandomIdentifier(6);
			iCypherSecurity cypherSecurity = new CypherSecurityImpl();
			
			//Update model bean password attribute value
			try {
				customerLogin.setPassword(cypherSecurity.encodePassword(resetKey, getCustomerLogin().getUserName()));
			} catch (Exception e) {
				setGlobalmessage("Unable to generate your random password, Please try again");
				throw e;
			}
			
			//Update random password into customer login table
			try {
				getForgotPasswordService().setNewPassword(customerLogin);
			} catch (Exception e) {
				setGlobalmessage("Unable to reset your password");
				throw e;
			}
			
			//Prepare mail content
			StringBuffer mailContent = new StringBuffer("Dear ").append(customerLogin.getUserName()).append("\n").append("your password reset success !\n").append("New Password : ").append(resetKey);
			
			//Send email with random password
			try {
				getMailService().sendMail(getCustomerLogin().getEmail(), "Reg. Password reset :: Almulla account", mailContent.toString());
			} catch (Exception e) {
				setGlobalmessage("Unable to complete your request due to our mail server problem");
				throw e;
			}

			setGlobalmessage("Your password reset success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Get Next position of display id [display id - for display the security question one by one]
	private void nextPosition() {
		
		setCurrentDisplayId(getCurrentDisplayId() + 1);
	}

	//Make all boolean object value as false
	private void falseAll() {
		setOptiongridstatus(false);
		setUsergridstatus(false);
		setQuestiongridstatus(false);
		setGlobalgridstatus(false);
	}

	// Reset component values
	private void resetFields() {

		setUsername(null);
		setQuestionUsername(null);
		setEmailid(null);
		setUserAvailableStatusMsg(null);
		setGlobalmessage(null);
		setQuesUserAvailableStatusMsg(null);
		setForgotoptions(0);
		setCurrentDisplayId(-1);
		setPanelQuestion("");
		setPanelQuestionAnswer("");

		setUserAvailableStatus(false);
		setOptiongridstatus(false);
		setUsergridstatus(false);
		setQuestiongridstatus(false);
		setGlobalgridstatus(false);
		setQuesUserAvailableStatus(false);
		setQuestionUsernameVisibility(false);
		setQuestionUsernameavailablity(false);
	}

}
