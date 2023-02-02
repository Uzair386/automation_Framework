package com.kblive.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	//pro is an object of property
	Properties pro;
	
	public ReadConfig() {
		
		//src is a variable which have path of config.properties file
		File src = new File("./Configuration/config.properties");
		try {
		
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			// use to load the config.properties file
			pro.load(fis);
			
		}catch(Exception e){
			System.out.println("Exception is" + e.getMessage());
		}
	}

	//Method to read baseURL value from config.properties file
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	//Method to read user-name value from config.properties file
	public String getUsermame() {
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getEventtitle() {
		String eventTitle = pro.getProperty("eventTitle");
		return eventTitle;
	}
	
	public String getCatgeory() {
		String catgeory = pro.getProperty("category");
		return catgeory;
	}
	
	public String getCreateEventExpectedUrl() {
		String createEventExpectedUrl = pro.getProperty("createEventExpectedUrl");
		return createEventExpectedUrl;
	}
	
	public String getDetail() {
		String detail = pro.getProperty("detail");
		return detail;
	}
	
	public String getPrimaryHost() {
		String primaryHost = pro.getProperty("primaryHost");
		return primaryHost;
	}
	
	public String getHost2() {
		String host2 = pro.getProperty("host2");
		return host2;
	}
	
	public String getHost3() {
		String host3 = pro.getProperty("host3");
		return host3;
	}
	
	public String getHost4() {
		String host4 = pro.getProperty("host4");
		return host4;
	}
	
	//Method to read password value from config.properties file
	public String getPassword() {
		String url = pro.getProperty("password");
		return url;
	}
	
	//Method to read chrome-driver path from config.properties file
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	//Method to read IEDriverServer path from config.properties file
	public String getIEPath() {
		String url = pro.getProperty("iepath");
		return url;
	}
	
	//Method to read fire-fox path  from config.properties file 
	public String getFirefoxPath() {
		String url = pro.getProperty("firefoxpath");
		return url;
	}
	
	// if i added few more variable in cofig.properties file so we add method right here also
	
	
	
}

