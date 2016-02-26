package pe.com.dev.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtil {

//	private final String REGEX_SIMPLE= "^(.+)@(.+)$";
//	private final String REGEX_USERNAME= "^[A-Za-z0-9+_.-]+@(.+)$";
//	private final String REGEX_RFC_5322= "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
//	private final String REGEX_NORMAL= "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	private final String REGEX_ADVANCED= "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	private final Pattern hasUppercase = Pattern.compile("[A-Z]");
	private final Pattern hasLowercase = Pattern.compile("[a-z]");
	private final Pattern hasNumber = Pattern.compile("\\d");
	private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
	
	public static void main(String[] args) {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");
		 
		//Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");
		
		/*
		 * Simplest regex to validate emails
		 * Regex : ^(.+)@(.+)$
		 * This one is simplest and only cares about ‘@’ symbol. Before and after ‘@’ symbol, there can be any number of characters. Let’s see a quick example to see what I mean.
		 * 
		 * Adding Restrictions on User Name part
		 * Regex : ^[A-Za-z0-9+_.-]+@(.+)$
		 * In this regex, we have added some restriction osn username part of email address. Restrictions in above regex are:
		 * 1) A-Z characters allowed
		 * 2) a-z characters allowed
		 * 3) 0-9 numbers allowed
		 * 4) Additionally email may contain only dot(.), dash(-) and underscore(_)
		 * 5) Rest all characters are not allowed
		 * 
		 * Regex allowing email addresses permitted by RFC 5322
		 * Regex : ^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
		 * This regex example uses all the characters permitted by RFC 5322, which governs the email message format. Among the permitted characters are some that present a security risk 
		 * if passed directly from user input to an SQL statement, such as the single quote (‘) and the pipe character (|). You should be sure to escape sensitive characters 
		 * when inserting the email address into a string passed to another program, in order to prevent security holes such as SQL injection attacks.
		 * 
		 * Regex to restrict leading, trailing, or consecutive dots in emails
		 * Regex : ^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$
		 * Both the local part and the domain name can contain one or more dots, but no two dots can appear right next to each other. Furthermore, the first and last characters 
		 * in the local part and in the domain name must not be dots:
		 * 
		 * Recommended : Regex to restrict no. of characters in top level domain
		 * Regex : ^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$
		 * Now lets modify the regex such that domain name must include at least one dot, and that the part of the domain name after the last dot can only consist of letters.
		 * Let’s say domain names are like secondlevel.com or thirdlevel.secondlevel.com. The top-level domain (.com in these examples) must consist of two to six letters only.
		 * 
		 * */
		String regex = "^(.+)@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		
		for(String email : emails){
		    Matcher matcher = pattern.matcher(email);
		    System.out.println(email +" : "+ matcher.matches());
		}
	}
	public boolean emailValidator(String email){
		boolean isvalid = false; 
		Pattern pattern = Pattern.compile(REGEX_ADVANCED);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()){
			isvalid = true;
		}
		return isvalid;
	}
	public String validateNewPass(String pass1, String pass2) {
	    if (pass1 == null || pass2 == null) {
	        return "One or both passwords are null";
	    }
	    StringBuilder retVal = new StringBuilder();

	    if (pass1.isEmpty() || pass2.isEmpty()) {
	        retVal.append("Empty fields <br>");
	    }
	    if (pass1.equals(pass2)) {
	        if (pass1.length() < 11) {
	            retVal.append("Password is too short. Needs to have 11 characters <br>");
	        }
	        if (!hasUppercase.matcher(pass1).find()) {
	            retVal.append("Password needs an upper case <br>");
	        }
	        if (!hasLowercase.matcher(pass1).find()) {
	            retVal.append("Password needs a lowercase <br>");
	        }
	        if (!hasNumber.matcher(pass1).find()) {
	            retVal.append("Password needs a number <br>");
	        }
	        if (!hasSpecialChar.matcher(pass1).find()) {
	            retVal.append("Password needs a special character i.e. !,@,#, etc.  <br>");
	        }
	    } else {
	        retVal.append("Passwords don't match<br>");
	    }
	    if (retVal.length() == 0) {
	        retVal.append("Success");
	    }
	    return retVal.toString();
	}
	public Map<String, String> getNewPassValidation(String pass1, String pass2){
		Map<String, String> messages = null;
		if (pass1 == null || pass2 == null) {
			messages = new HashMap<String, String>();
			messages.put("isNull", "One or both passwords are null");
	        return messages;
	    }
		return messages;
	}

}
