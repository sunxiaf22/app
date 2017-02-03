package org.church.our.loving.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParsePosition;

public class StringUtil {
	private static final Logger logger = Logger.getLogger(StringUtil.class); 
    public static final String DATE_FORMAT_FULL_MONTH = "dd MMMMM yyyy";
    public static final String DATE_FORMAT_SLASH = "dd/MM/yyyy";
    public static final String DATE_FORMAT_SESCOND = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    

    /**
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if ((str == null) || (str.trim().length() == 0)) {
            return true;
        }

        return false;
    }

    /**
     * 
     * @param str
     * @return
     */
    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formateDateToString(Date date, String format) {
        String rv = null;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            rv = sdf.format(date);
        }
        return rv;
    }

    /**
     * 
     * @param str
     * @return
     */
    public static String deNull(String str) {
        if (str == null) {
            return "";
        }

        return str;
    }

    public static Date toDate(String strDateTime, String dateTimeFormat) {
        if ((strDateTime == null) || (strDateTime.length() == 0)
                || (dateTimeFormat == null) || (dateTimeFormat.length() == 0)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
        Date date = dateFormat.parse(strDateTime, new ParsePosition(0));

        if (date == null) {
            return null;
        }

        return date;
    }

    /**
     * Check the input string whether it is a number or not.
     * 
     * @param inputStr
     *            , The string to be checked.
     * @return boolean value ,If the input string is a number then return true
     *         else return false.
     */
    public static boolean isNumeric(String inputStr) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(inputStr);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    
	 public static boolean isANumber(String inputStr) {
	        boolean isNumber =false;
	        try {
				Double.parseDouble(inputStr);
				isNumber = true;
			} catch (Exception e) {
				isNumber = false;
			}
	        return isNumber;
	    }
	 
	 public static String getRootDir () {
		 return System.getProperty("user.dir");
	 }
	 
	 public static String processException (Exception e) {
		 StringWriter sw = new StringWriter();
		 PrintWriter printWriter = new PrintWriter(sw);
		 e.printStackTrace(printWriter);
		 return sw.toString();
	 }
	 
	 public static void debug(String obj, HttpServletRequest request, String mesg ) {
		 String message = "";
		 String username = (String)request.getSession().getAttribute("username") ;
		 if (isEmpty(username)) {
			 username = "";
		 } else {
			 username = " ##[ USERID: " + username + " ]## ";
		 }
		 username += " ##[ CALLER: " + obj + " ]## ";
		 message = username + " -- " + mesg;
		 logger.debug(message);
	 }
	 
	 public static void info(Object obj, HttpServletRequest request, String mesg ) {
		 String message = "";
		 String username = (String)request.getSession().getAttribute("username") ;
		 if (isEmpty(username)) {
			 username = "";
		 } else {
			 username = " ##[ USERID: " + username + " ]## ";
		 }
		 username += " ##[ CALLER: " + obj.getClass().getName() + " ]## ";
		 message = username + " -- " + mesg;
		 logger.info(message);
	 }
	 
	 public static void error(Object obj, HttpServletRequest request, String mesg, Exception e) {
		 String message = "";
		 String username = (String)request.getSession().getAttribute("username") ;
		 if (isEmpty(username)) {
			 username = "";
		 } else {
			 username = " ##[ USERID: " + username + " ]## ";
		 }
		 username += " ##[ CALLER: " + obj.getClass().getName() + " ]## ";
		 message = username + " -- " + mesg;
		 logger.error(message, e);
	 }
}
