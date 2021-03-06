package com.cart.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cart.data.Constants;
import com.ts.commons.Page;
import com.ts.commons.Validator;
import com.ts.commons.RaceConditions.WaitTool;

public class ShoppingCartPage extends Page {



	ConfigurationPage ConfigurationPage;

	
	
	
	/////WebElements///////
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
	
	@FindBy(xpath = "//span[contains(.,'Amsterdam')]")
	private WebElement amsterdam_location;

	@FindBy(xpath = "//span[contains(.,'Hong Kong')]")
	private WebElement Hong_Kong_location;
	
	
	@FindBy(xpath = ".//a[ @class='action--click--edit']")
	private WebElement editLink;
	
	@FindBy(xpath = ".//a[ @class='action--click--remove']")
	private WebElement removeLink;
	
	
	@FindBy(xpath = ".//h4[contains(.,'Are you sure you want to remove this item?')]")
	private WebElement removeWarningLabel;
	
	
	@FindBy(xpath = "//a[@class='action--confirm--remove btn btn--large']")
	private WebElement removeItemButton;
	
	@FindBy(xpath = ".//h3[@class='cart_empty_content--text']")
	private WebElement emptyLabel;
  
	@FindBy(xpath = "//div[@class='col-4of5 action--text--config_description']")
	private WebElement serverNameLabel;
	
	
	
	@FindBy(xpath = "//span[@class='removal_message']")
	private WebElement removeMessage;
	
	
	
////////////////////////////////////////////////Methods////////////////////////////////////	
public AccountPage gotTocheckout (WebDriver driver)
    
    {
	    checkoutButton.click();
		WaitTool.isElementPresentAndDisplay(driver, goToCheckoukLink);
		goToCheckoukLink.click();
		return PageFactory.initElements(driver, AccountPage.class);
    }

public ConfigurationPage gotToConfigurationPage (WebDriver driver)

{
	continueShoppingButton.click();

	return PageFactory.initElements(driver, ConfigurationPage.class);
}


public ConfigurationPage gotToEditOption (WebDriver driver)

{
	editLink.click();

	return PageFactory.initElements(driver, ConfigurationPage.class);
}



public ShoppingCartPage clickRemovelink (WebDriver driver)

{

 
   removeLink.click();
   WaitTool.isElementPresentAndDisplay(driver,removeWarningLabel);
   removeItemButton.click();
   
    
	return this;
}

	




public boolean elementIsPresent (String xpath, WebDriver driver)

{
	try {
		driver.findElement(By.xpath(xpath));
		return true;
	} catch (Exception e) {
		return false;
	}
}




	
////////////////////////////////////////////////VALIDATIONS////////////////////////////////////	
	

	public Validator isShoppingCartdisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			    WaitTool.waitForElementPresentAndVisible(driver, shoppingCartLabel);
				WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
			 
			  
			  int totalCaracteres=totalMonthly_label.getText().length();
			  int total =Integer.valueOf(totalMonthly_label.getText().substring(1,(totalCaracteres-3)));
			 
			  Assert.assertEquals(Constants.TOTALMES,total);
				
			}
		};
	}
	


	public Validator isLocationsDisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
			 
			  
			  int totalCaracteres=totalMonthly_label.getText().length();
			  int total =Integer.valueOf(totalMonthly_label.getText().substring(1,(totalCaracteres-3)));
			 
			  Assert.assertTrue(Hong_Kong_location.isDisplayed());
			  Assert.assertTrue(amsterdam_location.isDisplayed());
			  Assert.assertEquals(Constants.TOTALMES,total);
				
			}
		};
	}
	
	public Validator isEditItem(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
			 
			  
			  int totalCaracteres=totalMonthly_label.getText().length();
			  int total =Integer.valueOf(totalMonthly_label.getText().substring(1,(totalCaracteres-3)));
			  Assert.assertTrue(amsterdam_location.isDisplayed());
			  Assert.assertEquals(Constants.TOTALMES,total);
			 
			  
			  
			  Assert.assertEquals(elementIsPresent("//span[contains(.,'Edit"+Constants.hostname+"')]", driver),true);
				
			}
		};
	}

	
	
	public Validator isItemDeleted(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				    
				
				   WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
				   WaitTool.isElementPresentAndDisplay(driver, removeMessage);
				   WaitTool.isElementPresentAndDisplay(driver, emptyLabel);
				   
				
				   Assert.assertFalse(checkoutButton.isDisplayed());
				   
				
			}
			
		};
	}
	
	
	
	public Validator isOnlyanItemDeleted(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				    
				
				   WaitTool.isElementPresentAndDisplay(driver, shoppingCartLabel);
				   WaitTool.isElementPresentAndDisplay(driver, removeMessage);
				   WaitTool.isElementPresentAndDisplay(driver, emptyLabel);
				   
				   Assert.assertTrue(checkoutButton.isDisplayed());
				   Assert.assertFalse(emptyLabel.isDisplayed());
				   
				
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



