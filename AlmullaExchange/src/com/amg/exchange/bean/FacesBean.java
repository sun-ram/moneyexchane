package com.amg.exchange.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.amg.exchange.util.SessionStateManage;

@ManagedBean(name="facesBean")
@SessionScoped
public class FacesBean implements Serializable {
	    private static final long serialVersionUID = 1L;
	    private String align="ltr"  ; 
	    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	    private String header="../common/header.xhtml"; 
	    private String footer = "../common/footer.xhtml"; 
	    private String menu = "../common/menu.xhtml"; 
	    private String stylemenu="";
	    public FacesBean(){
	    	new SessionStateManage().setSessionValue("applicationId", "25");
	    }

	    public String getDirection() {
          if (getLanguage() == "ar") {
        	  align = "rtl";
          } else {
        	  align = "ltr";
          }
          return align;
	    }
	    
	    public String getHeader(){
	    	if (getLanguage() == "ar") {
	        	  header = "../common/arabicheader.xhtml";
	          } else {
	        	  header = "../common/header.xhtml";
	          }
	    	return header;
	    }
	    
	    public String getFooter(){
	    	if (getLanguage() == "ar") {
	        	  footer = "../common/arabicfooter.xhtml";
	          } else {
	        	  footer = "../common/footer.xhtml";
	          }
	    	return footer;
	    }
	    
	    public String getMenu(){
	    	if (getLanguage() == "ar") {
	        	  menu = "../common/arabicmenu.xhtml";
	          } else {
	        	  menu = "../common/menu.xhtml";
	          }
	    	return menu;
	    }
	    
	    public void setLocale(Locale locale) {
			this.locale = locale;
		}

		public String getDirectionArabic(ActionEvent e){
	    	
	    	  setLanguage("ar");
	    	  
	    	  // Added by Justin Vincent , For -> Add language code into session , Date -> 2014-apr-16
	    	  SessionStateManage sessionStateManage = new SessionStateManage();
	    	  sessionStateManage.setSessionValue("languageCode", "ar");
	    	  sessionStateManage.setSessionValue("languageId", "2");
	       	  align = "rtl";
	          return align;
	    }
	    
	    public String getDirectionEnglish(ActionEvent e){
	    	  setLanguage("en"); 
	    	  
	    	  // Added by Justin Vincent , For -> Add language code into session , Date -> 2014-apr-16
	    	  SessionStateManage sessionStateManage = new SessionStateManage();
	    	  sessionStateManage.setSessionValue("languageCode", "en");
	    	  sessionStateManage.setSessionValue("languageId", "1");
	       	  align = "ltr";
	          return align;
	    }
	   
	    public Locale getLocale() {
	        return locale;
	    }

	    public String getLanguage() {
	        return locale.getLanguage();
	    }

	    public void setLanguage(String language) {
	        this.locale = new Locale(language);
	    }

		public String getStylemenu() {
			
			return stylemenu;
		}

		public void setStylemenu(String stylemenu) {
			if(align.equals("rtl"))
			{
				stylemenu ="<style type=\"text/css/\"> " +
						   ".ui-menubar{      float: right !important;     margin-left: 0px !important; }.ui-menu-list {  right: 0; } .ui-menuitem-text {   float: right !important; }</style>";
			}
			else
			{
				stylemenu ="<style type=\"text/css/\"> " +
						   ".ui-menubar{      float: left !important;     margin-left: 0px !important; }.ui-menu-list {  left: 0; } .ui-menuitem-text {   float: left !important; }</style>";
			}
			this.stylemenu = stylemenu;
		}
}
