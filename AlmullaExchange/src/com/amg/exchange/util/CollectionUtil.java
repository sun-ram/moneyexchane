package com.amg.exchange.util;

import java.util.Map;
import java.util.logging.Level;

import com.amg.exchange.common.DeclareConstants;
import com.amg.exchange.model.BussComponentConfDetail;
import com.sun.istack.internal.logging.Logger;

/*******************************************************************************************************************

		 File		: CollectionUtil.java
 
		 Project	: AlmullaExchange

		 Package	: com.amg.exchange.util
 
		 Created	:	
 						Date	: 14-May-2014 9:22:43 am
		 				By		: Justin Vincent
 						Revision:
 
 		 Last Change:
 						Date	: 14-May-2014 9:22:43 am
 						By		: Justin Vincent
		 				Revision:

		 Description: TODO 

********************************************************************************************************************/
public class CollectionUtil {
	
	
	public String fetchBehavior(Map<String, BussComponentConfDetail> mapComponentBehavior, String componentName, String propertyName){
		
		String ret = "";
		if(mapComponentBehavior!=null && mapComponentBehavior.containsKey(componentName)){
			switch(propertyName){
			
				case "MIN_VALUE":
					ret = mapComponentBehavior.get(componentName).getMinValue().toString();
					break;
					
				case "MAX_VALUE":
					ret = mapComponentBehavior.get(componentName).getMaxValue().toString();
					break;
					
				case "NUMERIC":
					ret = mapComponentBehavior.get(componentName).getIsNumeric().equals("Y")?"^[0-9]*":"";
					break;
					
				case "ALPHABET":
					ret = mapComponentBehavior.get(componentName).getIsAlphabet().equals("Y")?"[a-zA-Z]":"";
					break;
					
				case "SPECIAL":
					ret = mapComponentBehavior.get(componentName).getIsSpecial().equals("Y")?"[$&+,:;=?@#|'<>.^*()%!-/]":"";
					break;
					
				case "REQUIRED":
					ret = mapComponentBehavior.get(componentName).getIsRequired().equals("Y")?"true":"false";
					break;
					
				case "READ_ONLY":
					ret = mapComponentBehavior.get(componentName).getIsReadOnly().equals("Y")?"true":"false";
					break;
					
				case "ENABLE":
					ret = mapComponentBehavior.get(componentName).getIsEnable().equals("Y")?"false":"true";
					break;
					
				case "MANDATORY":
					ret = mapComponentBehavior.get(componentName).getIsRequired().equals("Y")?"*":"";
					break;
					
				case "VAL_MSG":
					ret = getValidationMessage(
							mapComponentBehavior.get(componentName).getIsNumeric().equals("Y"),
							mapComponentBehavior.get(componentName).getIsAlphabet().equals("Y"),
							mapComponentBehavior.get(componentName).getIsSpecial().equals("Y")
							);
					break;
					
				case "PATTERN":
					ret = getPattern(
							mapComponentBehavior.get(componentName).getIsNumeric().equals("Y"),
							mapComponentBehavior.get(componentName).getIsAlphabet().equals("Y"),
							mapComponentBehavior.get(componentName).getIsSpecial().equals("Y")
							);
					break;
				default:
					ret = "";
					break;
			}
		}
		Logger.getLogger(this.getClass()).log( Level.INFO, "Component Name : "+componentName+", Property Name : "+propertyName+", Property Value: "+ret);
		return ret;
	}
	
	private String getPattern(boolean isNumeric, boolean isAlphabet, boolean isSpecial){
		
		String special = DeclareConstants.REGEX_SPECIAL;
		String numeric = DeclareConstants.REGEX_NUMERIC;
		String alpha = DeclareConstants.REGEX_ALPHA;
		
		if(!isNumeric && !isAlphabet && !isSpecial){
			return "";
		}else{
			return "^["+(isAlphabet?alpha:"")+(isNumeric?numeric:"")+(isSpecial?special:"")+"]*$";
		}
	}
	
	private String getValidationMessage(boolean isNumeric, boolean isAlphabet, boolean isSpecial){
		
		SessionStateManage sessionStateManage = new SessionStateManage();
		if(sessionStateManage.isExists("languageCode")){
			setLanguageCode(sessionStateManage.getSessionValue("languageCode").toUpperCase());
		}else{
			setLanguageCode("EN");
		}
		
		String special = DeclareConstants.REGEX_SPECIAL_LABEL.get(getLanguageCode());
		String numeric = DeclareConstants.REGEX_NUMERIC_LABEL.get(getLanguageCode());
		String alpha = DeclareConstants.REGEX_ALPHA_LABEL.get(getLanguageCode());
		
		int trueCount = (isNumeric?1:0)+(isAlphabet?1:0)+(isSpecial?1:0);
		
		String str = "";
		
		if(!isNumeric && !isAlphabet && !isSpecial){
			str = ""+(alpha)+","+(numeric)+" "+DeclareConstants.REGEX_AND_LABEL.get(getLanguageCode())+(special)+" "+DeclareConstants.REGEX_NOT_ALLOW_LABEL.get(getLanguageCode());
		}else{
			String join1 = "";
			String join2 = "";
			if(isNumeric && trueCount==3){
				join1 = ",";
			}else if(isNumeric && trueCount==2){
				join1 = " "+DeclareConstants.REGEX_AND_LABEL.get(getLanguageCode());
			}
			
			if(isAlphabet && trueCount==3){
				join2 = " "+DeclareConstants.REGEX_AND_LABEL.get(getLanguageCode());
			}else if(isAlphabet && trueCount==2 && isSpecial){
				join2 = " "+DeclareConstants.REGEX_AND_LABEL.get(getLanguageCode());
			}
			
			str =  DeclareConstants.REGEX_ALLOW_LABEL.get(getLanguageCode())+" "+(trueCount==1?" "+DeclareConstants.REGEX_ONLY_LABEL.get(getLanguageCode()):"")+(isNumeric?numeric:"")+(join1)+(isAlphabet?alpha:"")+(join2)+(isSpecial?special:"")+"";
		}
		return str;
	}
	
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	private String languageCode;
}
