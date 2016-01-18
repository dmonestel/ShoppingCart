package com.cart.pages;

import com.ts.commons.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UI {
	
	private FirefoxDriver driver = null;
	
	public FirefoxDriver getFirefoxDriver(){
		if(driver == null)
		   driver = new FirefoxDriver();
		
		return driver;
	} 

	public LoginPage getLandingPage(){
		return PageFactory.initElements(getFirefoxDriver(), LoginPage.class);
	} 
}