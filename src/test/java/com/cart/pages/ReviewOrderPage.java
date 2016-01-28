package com.cart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;
import com.ts.commons.RaceConditions.WaitTool;

public class ReviewOrderPage extends Page {
	
	@FindBy(xpath = "//span[@class='cc-number']")
	private WebElement credit_Card_Number_Label;
	
	@FindBy(xpath = "//div[@class='billing-address-street']")
	private WebElement billing_address_Label;
	
	@FindBy(xpath = "//div[@class='billing-address-city']")
	private WebElement billing_city_Label;
	
	@FindBy(xpath = "//div[@class='billing-address-country']")
	private WebElement billing_country_Label;
	
	
	@Override
	public ReviewOrderPage and() {
		return this;
	}

	@Override
	public ReviewOrderPage then() {
		return this;
	}

	
	public Validator isEqualTheCreditCardNumber(final String creditCardNumber, final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver, credit_Card_Number_Label);
			  String displayedCard = credit_Card_Number_Label.getText();
			  String lastFourDigits = creditCardNumber.substring(creditCardNumber.length()-4);
			  String lastFourDigitsDisplayed = displayedCard.substring(displayedCard.length()-4);
			  
			  boolean isEqual = lastFourDigits.equals(lastFourDigitsDisplayed);
			  Assert.assertTrue(isEqual, "The selected credit card  does not match on Payment section.");
			  	
			}
			};
	}
	
	
	public Validator isEqualTheBillingAddress(final String checkNewAddress, final String billing_address, final String billing_city, final String billing_state, final String billing_postalCode, final String billing_country, final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
			
			 if(checkNewAddress.equalsIgnoreCase("YES")){	
				
			  WaitTool.waitForElementPresentAndVisible(driver, billing_address_Label);	
				
			  String city = billing_city + ", " + billing_state + " " + billing_postalCode;
			
			  String displayedAdress  =  billing_address_Label.getText();
			  String displayedCity    =  billing_city_Label.getText();
			  String displayedCountry =  billing_country_Label.getText();
  
			  boolean isEqual;
			  
			  isEqual = billing_address.equals(displayedAdress);
			  Assert.assertTrue(isEqual, "The billing addresss is not equal.");
			  
			  isEqual = city.equals(displayedCity);
			  Assert.assertTrue(isEqual, "The billing city is not equal.");
			
			  isEqual = billing_country.equals(displayedCountry);
			  Assert.assertTrue(isEqual, "The billing country is not equal.");
			  	
			} else
				{
				Assert.assertTrue(true);	
				}
			}
				
			};
	}
}