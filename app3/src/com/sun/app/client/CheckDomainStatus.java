package com.sun.app.client;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.regex.*;

public class CheckDomainStatus {
	private static final String  MAIN_SITE = "http://app2-marrysun.rhcloud.com/forward?newdomain=";
	private static final String BASE_DOMAIN = "amazing-grace";
	private static final String SERVER_NAME = "app2";
	
	public static void main(String[] args) {
		jobStart();
	}
	
	public static void jobStart() {
		shutdown();
		String sleepingTime = System.getenv("time");
		String domain = ""+Calendar.getInstance().get(Calendar.DATE);
		String finalDomain = start(domain);
		if (StringUtil.isEmpty(sleepingTime)) {
			sleepingTime = "5";
		}
		Integer sleepInterTime = 5;
		try {
			sleepInterTime = Integer.valueOf(sleepingTime);
		} catch (Exception e) {
		} 
		
		try {
			boolean mainDomain = updateWebSite(finalDomain);
			boolean doingLoop = true;
			while (doingLoop) {
				String webContent = getURLContent(finalDomain + "/"+SERVER_NAME+"/status");
				if (!webContent.equalsIgnoreCase("success")) {
					StringUtil.debug("***ERROR*** Domain : " + finalDomain + ". Server Status: " + webContent);
					//TestMail.send_email();
					shutdown();
					finalDomain = start(domain);
					String content_mail = "<p> Domain server was restarted! Using new domain :  " + finalDomain + "</p>";  
					TestMail.commonMail("164570618@qq.com", "** Note ** App domain was restarted", content_mail, "");
					mainDomain = updateWebSite(finalDomain);
				} 
				if (!mainDomain) {
					mainDomain = updateWebSite(finalDomain);
				}
				StringUtil.debug("Sleeping...");
				Thread.sleep(sleepInterTime * 60 * 1000);
			}
		} catch (Exception e) {
			String content_mail = StringUtil.processException(e);
			StringUtil.debug(content_mail);
			TestMail.commonMail("164570618@qq.com", "** Error ** Exception found, job existed", content_mail, "");
		}
	} 
	
	public static String getDomain (String url_v) {
		String domain = "";
		String pageContent = getURLContent(url_v);
		Pattern pattern = Pattern.compile("\"PublicUrl.*?\"(http://[\\d\\w\\.]*)");
		Matcher matcher = pattern.matcher(pageContent);
		if (matcher.find()) {
			domain = matcher.group(1);
		}
		if (null == domain || domain.trim().length() ==0) domain = "";
		return domain;
	}
	
	public static String getURLContent (String url_v) {
		InputStream contentStream = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		String content ="";
		try {
			URL urlConnection = new URL(url_v);
			URLConnection connection = urlConnection.openConnection();
			contentStream = connection.getInputStream();
			isr = new InputStreamReader(contentStream);
			br = new BufferedReader(isr);
			String lineStr = "";
			while( (lineStr =  br.readLine() ) != null) {
				content += lineStr;
			}
			//StringUtil.debug(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != isr) {
				try {
					isr.close();
					isr = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}
	
	public static boolean updateWebSite (String domain) {
		boolean issuccess = false;
		String feedback = getURLContent(MAIN_SITE + domain);
		if (StringUtil.isEmpty(feedback)) {
			issuccess = false;
		}else {
			issuccess = true;
		}
		StringUtil.debug("Feedback is : " + feedback + " , is success ? " + issuccess);
		return issuccess;
	}
	
	public static void callBat (String cmdpath){
		String cmd = "cmd /c start " + cmdpath;

        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.isAlive();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
	} 
	
	public static void shutdown() {
		callBat("taskkill /f /im ngrok.exe ");
		try {
			Thread.sleep(5000);
			StringUtil.debug("**Shutdown** Domain Server!!!");
		} catch (InterruptedException e) {
		}
	} 
	
	public static String start(String domain) {
		String domain2 = BASE_DOMAIN + "-" + domain ;
		callBat("G:\\OpenShift\\windows_386\\ngrok.exe -config=G:\\OpenShift\\windows_386\\ngrok.cfg -subdomain " + domain2 + " 80 ");
		String finalDomain = "http://" + BASE_DOMAIN + "-" + domain +".tunnel.qydev.com";
		try {
			Thread.sleep(5000);
			StringUtil.debug("**Starting** Domain Server!!!");
		} catch (InterruptedException e) {
		}
		return finalDomain;
	} 
}
