package com.cart.pages;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.ts.commons.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import com.cart.data.AccountPage;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.google.common.base.FinalizablePhantomReference;
import com.ts.commons.Page;
import com.ts.commons.TSJavaScriptExecutor;
import com.ts.commons.TsDriver;
import com.ts.commons.Validator;
import com.ts.commons.RaceConditions.WaitTool;

public class ShoppingCartPage extends Page {

	

	configurationPage configurationPage;
	
	@FindBy(xpath = "//h1[contains(.,'Your Shopping Cart')]")
	private WebElement shoppingCartLabel;
	
	
	@FindBy(xpath = ".//span[@class='price']/span[2]")
	private WebElement totalMonthly_label;
	
	
	@FindBy(xpath = ".//a[@class='btn btn--block btn--large btn--arrow-right action--click--checkout']")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//button[@class='action--click--cross_selling_checkout btn btn--link']")
	private WebElement goToCheckoukLink;
	
	@FindBy(xpath = "//a[@class='btn btn--block btn--alt action--click--continue_shopping']")
	private WebElement continueShoppingButton;
	
	
////////////////////////////////////////////////Methods////////////////////////////////////	
public AccountPage gotTocheckout (WebDriver driver)
    
    {
	    checkoutButton.click();
		WaitTool.isElementPresentAndDisplay(driver, goToCheckoukLink);
		
	    goToCheckoukLink.click();
		return PageFactory.initElements(driver, AccountPage.class);
    }

public configurationPage gotToConfigurationPage (WebDriver driver)

{
	continueShoppingButton.click();

	return PageFactory.initElements(driver, configurationPage.class);
}





	
////////////////////////////////////////////////VALIDATIONS////////////////////////////////////	
	

	
	
	public Validator isShoppingCartdisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
			 
			  
			  int totalCaracteres=totalMonthly_label.getText().length();
			  int total =Integer.valueOf(totalMonthly_label.getText().substring(1,(totalCaracteres-3)));
			 
			  Assert.assertEquals(Constants.TOTALMES,total);
				
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
