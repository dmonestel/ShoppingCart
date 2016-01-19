package com.cart.data;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cart.data.Constants;
import com.cart.pages.LoginPage;
import com.cart.pages.UI;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.Page;
import com.ts.commons.TestCaseUtil;
import com.ts.commons.Validator;



public class AccountPage extends Page{

	@FindBy(xpath = "//h1[contains(.,'Account')]")
	private WebElement accountLabel;
	
////////////////////////////////////////////////VALIDATIONS////////////////////////////////////		
	public Validator isAccountdisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			  Assert.assertTrue(accountLabel.isDisplayed());
			  
			 
				
			}
			};
		}
	
	@Override
	public Page and() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page then() {
		// TODO Auto-generated method stub
		return null;
	}

}
