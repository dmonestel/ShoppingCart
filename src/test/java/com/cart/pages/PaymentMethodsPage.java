package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cart.data.CreditCardData;
import com.ts.commons.Page;
import com.cart.data.PageUtils;

import org.openqa.selenium.Keys;
import org.testng.Assert;

public class PaymentMethodsPage extends Page {

 @FindBy(xpath = "//a[@class='btn btn--arrow-right btn--block btn--large action--click--nextStep']")
 private WebElement review_order_button;
 
 @FindBy(xpath = "//label[@class='action--text--new_credit_card_text label--new_credit_card_text field-label']")
 private WebElement use_new_credit_cart_radiobutton;
 
 @FindBy(xpath = "//div[@class='action--render--card_first_name']/input")
 private WebElement first_name_input;
 
 @FindBy(xpath = "//div[@class='action--render--card_last_name']/input")
 private WebElement last_name_input;
 
 @FindBy(xpath = "//div[@class='action--render--card_number']/input")
 private WebElement card_number_input;
 
 @FindBy(xpath = "//div[contains(@class, 'action--render--card_cvv')]/input")
 private WebElement security_code_input;
 
 @FindBy(xpath = "//label[@class='field-label black']")
 private WebElement default_checkbox;
 
 @FindBy(xpath = "//input[@class='action--radio--contact_address']")
 private WebElement use_contact_address_radiobutton;
 
 @FindBy(xpath = "//input[@class='action--radio--new_address']/..//strong")
 private WebElement use_new_address_radiobutton;
 
 @FindBy(xpath = "//div[contains(@class, 'action--render--address')]/input")
 private WebElement address_input;
 
 @FindBy(xpath = "//div[@class='selectbox action--render--countries']//span")
 private WebElement country_dropdown;
 
 @FindBy(xpath = "//div[@class='selectbox action--render--countries']//input")
 private WebElement country_search_fill;

 @FindBy(xpath = "//div[@class='selectbox action--render--state']//span")
 private WebElement state_dropdown;
 
  @FindBy(xpath = "//div[@class='selectbox action--render--state']//input")
 private WebElement state_search_fill;
 
 @FindBy(xpath = "//div[contains(@class, 'action--render--city')]/input")
 private WebElement city_input;
 
 @FindBy(xpath = "//div[contains(@class, 'action--render--postal_code')]/input")
 private WebElement postal_code_input;
 
 @FindBy(xpath = "//div[@class='action--render--error field-error']")
 private WebElement error_label;
 
 @FindBy(xpath = "//div[@class='field--radio field cc-list-item']")
 private WebElement cc_list;

 @FindBy(xpath = "//h1[text()='Order Review']")
 private WebElement nextPageTitle;
 
	public ReviewOrderPage selectACreditCard(String creditCardNumber, WebDriver driver) {
		
		String lastFourDigits = creditCardNumber.substring(creditCardNumber.length()-4);
		String xpath = "//span[contains(.,'"+lastFourDigits+"')]/../../input";
		driver.findElement(By.xpath(xpath)).click();
		this.review_order_button.click();
		
		return PageFactory.initElements(driver, ReviewOrderPage.class);
	}
	
	public ReviewOrderPage useNewCreditCard(CreditCardData data, String useNewAddress, WebDriver driver) {
		
		
		boolean areThereCards = PageUtils.iselementPresent(cc_list);
		
		
		if(areThereCards){
			this.use_new_credit_cart_radiobutton.click();
		}
		
		this.first_name_input.sendKeys(data.getFirstName());
		this.last_name_input.sendKeys(data.getLastName());
		this.card_number_input.sendKeys(data.getCardNumber());
	
		driver.findElement(By.xpath("//div[@class='selectbox action--render--card_expire_month card_expire_month']//span")).click();	
		driver.findElement(By.xpath("//div[@class='selectbox action--render--card_expire_month card_expire_month']//li[text()='"+data.getExpirationMonth()+"']")).click();	
		
		driver.findElement(By.xpath("//div[@class='selectbox action--render--card_expire_year card_expire_year']//span")).click();	
		driver.findElement(By.xpath("//div[@class='selectbox action--render--card_expire_year card_expire_year']//li[text()='"+data.getExpirationYear()+"']")).click();	
		
		this.security_code_input.sendKeys(data.getSecurityCode());
		
		boolean isDefaultCard = data.getDefaultCard().equalsIgnoreCase("Yes");
		
		if(areThereCards && !isDefaultCard){
			this.default_checkbox.click();
		}
		
		if(useNewAddress.equalsIgnoreCase("YES") ){
			this.use_new_address_radiobutton.click();
			this.address_input.sendKeys(data.getAddress());
			
			country_dropdown.click();
			country_search_fill.sendKeys(data.getCountry());
			country_search_fill.sendKeys(Keys.ENTER);
			
			state_dropdown.click();
			state_search_fill.sendKeys(data.getState());
			state_search_fill.sendKeys(Keys.ENTER);
			
			this.city_input.sendKeys(data.getCity());
			this.postal_code_input.sendKeys(data.getPostalCode());
		}
		
		this.review_order_button.click();
		
		boolean nextPageIsVisible = PageUtils.iselementPresent(nextPageTitle);
		
		if(!nextPageIsVisible){
			String  errorMessage = error_label.getText();
			Assert.assertFalse(true, "An error is displayed: " + errorMessage);
		}
	
		return PageFactory.initElements(driver, ReviewOrderPage.class);
	}

	@Override
	public PaymentMethodsPage and() {
		return this;
	}

	@Override
	public PaymentMethodsPage then() {
		return this;
	}
}