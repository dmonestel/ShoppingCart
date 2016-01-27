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
	
	@Override
	public ReviewOrderPage and() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ReviewOrderPage then() {
		// TODO Auto-generated method stub
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
}