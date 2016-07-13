package pe.com.dev.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	
//	private final String REGEX_SIMPLE= "^(.+)@(.+)$";
//	private final String REGEX_USERNAME= "^[A-Za-z0-9+_.-]+@(.+)$";
//	private final String REGEX_RFC_5322= "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
//	private final String REGEX_NORMAL= "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	private final String REGEX_ADVANCED= "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	private final Pattern hasUppercase = Pattern.compile("[A-Z]");
	private final Pattern hasLowercase = Pattern.compile("[a-z]");
	private final Pattern hasNumber = Pattern.compile("\\d");
	private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
	
	private final String MSG_PASS_VAL_NULL_VALUE="One or both passwords are null";
	private final String MSG_PASS_VAL_EMPTY_VALUE="Empty fields";
	private final String MSG_PASS_VAL_SHORT_VALUE="Password is too short. Needs to have 11 characters";
	private final String MSG_PASS_VAL_UPPER_VALUE="Password needs an upper case";
	private final String MSG_PASS_VAL_LOWER_VALUE="Password needs a lowercase";
	private final String MSG_PASS_VAL_NUMBER_VALUE="Password needs a number";
	private final String MSG_PASS_VAL_SPECIAL_VALUE="Password needs a special character i.e. !,@,#, etc.";
	private final String MSG_PASS_VAL_NOMATCH_VALUE="Passwords don't match";
	private final String MSG_PASS_VAL_SUCCESS_VALUE="Success";
	
	
	public boolean emailValidator(String email){
		boolean isvalid = false; 
		if(email!=null && !email.isEmpty()){
			Pattern pattern = Pattern.compile(REGEX_ADVANCED);
			Matcher matcher = pattern.matcher(email);
			if(matcher.matches()){
				isvalid = true;
			}
		}
		return isvalid;
	}
	public String[] getNewPassValidation(String pass1, String pass2){
		String[] messages = new String[9];;
		if (pass1 == null || pass2 == null) {
			messages[0] = MSG_PASS_VAL_NULL_VALUE;
	        return messages;
	    }
		if (pass1.isEmpty() || pass2.isEmpty()) {
			messages[1] = MSG_PASS_VAL_EMPTY_VALUE;
	    }
		
		if (pass1.equals(pass2)) {
	        if (pass1.length() < 11) {
	        	messages[2] = MSG_PASS_VAL_SHORT_VALUE;
	        }
	        if (!hasUppercase.matcher(pass1).find()) {
	        	messages[3] = MSG_PASS_VAL_UPPER_VALUE;	
	        }
	        if (!hasLowercase.matcher(pass1).find()) {
	        	messages[4] = MSG_PASS_VAL_LOWER_VALUE;
	        }
	        if (!hasNumber.matcher(pass1).find()) {
	        	messages[5] = MSG_PASS_VAL_NUMBER_VALUE;
	        }
	        if (!hasSpecialChar.matcher(pass1).find()) {
	        	messages[6] = MSG_PASS_VAL_SPECIAL_VALUE;
	        }
	    } else {
	    	messages[7] = MSG_PASS_VAL_NOMATCH_VALUE;
	    }
	    if (messages.length == 0) {
	    	messages[8] = MSG_PASS_VAL_SUCCESS_VALUE;
	    }
	    
		return messages;
	}
	
}
