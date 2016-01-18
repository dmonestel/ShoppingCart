package com.cart.pages;

import org.testng.Assert;

import com.ts.commons.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cart.data.Constants;
import com.ts.commons.Page;
import com.ts.commons.TSJavaScriptExecutor;
import com.ts.commons.TsDriver;
import com.ts.commons.Validator;
import com.ts.commons.RaceConditions.WaitTool;

public class LoginPage extends Page{

	
	public LoginPage then(){
		return this;
	}
	
	public LoginPage and(){
		return this;
	}
	
	private boolean isElementDisplayed(WebDriver driver, By selector)
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