package com.cart.data;

public class Constants {
	public static int TIME_OUT;
	public static String DOMAIN;
	public static String LOGOUT_URL;
	public static String hostname ;
	public static int TOTALMES ;
	public static String username;
	public static String password;
	public static String email;
	public static String wrong_password;
	public static String wrong_email;
	public static String wrong_username;
	public static void setTIME_OUT(int time_out) {
		TIME_OUT = time_out;
	}
	
	public static void setDomain(String domain) {
		DOMAIN = domain;
	}
	
	public static void setLOGOUT_URL(String logout_url) {
		LOGOUT_URL = logout_url;
	}
	
	public static void setHostname(String hostname) {
        Constants.hostname = hostname;
	}
	public static void setWrong_username(String wrong_username) {
        Constants.wrong_username = wrong_username;
	}
	public static void setWrong_email(String wrong_email) {
        Constants.wrong_email = wrong_email;
	}
	public static void setWrong_password(String wrong_password) {
        Constants.wrong_password = wrong_password;
	}
	public static void setEmail(String email) {
        Constants.email = email;
	}
	
	public static void setTotalMes(int TotalMes) {
        Constants.TOTALMES = TotalMes;

	}

	public static void setUsername(String username) {
        Constants.username = username;
	}
    public static void setPassword(String password) {
            Constants.password = password;     
	}

	
}