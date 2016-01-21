package com.cart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ts.commons.Page;


public class LoginPage extends Page{

	
	public LoginPage then(){
		return this;
	}
	
	public LoginPage and(){
		return this;
	}
	
	public boolean isElementDisplayed(WebDriver driver, By selector)
	{
		try
		{
			driver.findElement(selector);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	/*----------------------------------VALIDATIONS----------------------------------*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}