package com.cart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cart.data.AccountData;
import com.cart.data.NewUserInfo;
import com.ts.commons.Page;
import com.ts.commons.Validator;
import com.ts.commons.RaceConditions.WaitTool;

import org.openqa.selenium.Keys;

import com.cart.data.PageUtils;

public class AccountPage extends Page{

	@FindBy(xpath = "//h1[contains(.,'Account')]")
	private WebElement accountLabel;
	
	@FindBy(xpath = "//input[@id='username-3']")
	private WebElement username_input;
	
	@FindBy(xpath = "//input[@id='password-3']")
	private WebElement password_input;
	
	@FindBy(xpath = "//button[@class='btn btn--large btn--arrow-right action--click--login']")
	private WebElement login_button;
	
	@FindBy(xpath = "//button[@class='btn btn--large btn--arrow-right action--click--new_customer']")
	private WebElement create_account_button;
	
	@FindBy(xpath = "//input[@id='email-2']")
	private WebElement email_input;
	
	@FindBy(xpath = "//a[@class='action--forgot--password']")
	private WebElement forgot_password_link;
	
	@FindBy(xpath = "//h1[contains(.,'Payment Methods')]")
	private WebElement payment_methods_label;
                 //New Account//
	@FindBy(xpath = "//h1[@class='page--title']")
	private WebElement account_registration_label;

	@FindBy(xpath = "//div[@class='action--render--first_name']/input")
	private WebElement first_name_input;
	
	@FindBy(xpath = "//div[@class='action--render--last_name']/input")
	private WebElement last_name_input;
	
	@FindBy(xpath = "//div[@class='action--render--company']/input")
	private WebElement company_input;	
	
	@FindBy(xpath = "//div[@class='action--render--address']/input")
	private WebElement address_input;
	
	@FindBy(xpath = "//div[@class='action--render--city']/input")
	private WebElement city_input;
	
	@FindBy(xpath = "//div[@class='action--render--postal_code field--postal_code col-4of5']/input")
	private WebElement postal_code_input;
	
	@FindBy(xpath = "//div[@class='action--render--phone']/input")
	private WebElement phone_input;
	
	@FindBy(xpath = "//div[@class='action--render--username']//input")
	private WebElement username2_input;
	
	@FindBy(xpath = "//div[@class='action--render--password']/input")
	private WebElement password2_input;
	
	@FindBy(xpath = "//div[@class='action--render--confirm_password']/input")
	private WebElement confirm_password_input;
	
	@FindBy(xpath = "//div[@class='action--render--signature field--signature']/input")
	private WebElement signature_input;
	
	@FindBy(xpath = "//div[@class='action--render--state']//span")
	private WebElement state_dropdown;
	
	@FindBy(xpath = "//div[@class='action--render--state']//input")
	private WebElement state_search_fill;
	//
	@FindBy(xpath = "//div[@class='action--render--countries']//span")
	private WebElement country_dropdown;
	@FindBy(xpath = "//div[@class='action--render--countries']//input")
	private WebElement country_search_fill;
	//
	@FindBy(xpath = "//span[contains(.,'I am authorized to, and do duly, sign this Service Order and Master Services Agreement')]")
	private WebElement MSA_check;
	
	@FindBy(xpath = "//button[@class='btn btn--arrow-right btn--large action--click--signup']")
	private WebElement create_account_and_continue_button;
	
	 @FindBy(xpath = "//input[@class='action--radio--new_credit_card']")
	 private WebElement use_new_credit_cart_radiobutton;
	 
	 @FindBy(xpath = " (//span[@class='validation-message--invalid field-error'])[16]")
	 private WebElement Same_Password_validation;
	
	 @FindBy(xpath = "(//div[@class='action--render--email'])[2]/input")
	 private WebElement email_input2;
	 @FindBy(xpath = "(//div[@class='action--render--email is-invalid']//input[@class='invalid'])[2]")
	 private WebElement email__with_invalid_input;
	 
	 
	 @FindBy(xpath = "(//span[@class='validation-message--invalid field-error'])[12]")
	 private WebElement email_validation;
	 
	 @FindBy(xpath = "//span[@class='validation-message--invalid field-error'][contains(.,'Username should have at least 8 characters')]")
	 private WebElement username_validation;
	 
	 @FindBy(xpath = "//span[@class='validation-message--invalid field-error'][contains(.,'Please confirm that you are authorized to sign this')]")
	 private WebElement MSA_check_validation;
	 @FindBy(xpath = "//div[@class='action--render--authorization field--checkbox__wrap']")
	 private WebElement MSA_checked;
	
	 @FindBy(xpath = "//input[@id='forgot-password-input']")
	 private WebElement forgot_password_input;
	
	 @FindBy(xpath = "//a[@class='action--reset--password btn btn--large']")
	 private WebElement reset_password_button;
	 
	 @FindBy(xpath = "//a[@class='action--reset--password_confirm btn btn--large']")
	 private WebElement reset_password_confirm_button;
	
	
////////////////////////////////////////////////METHODS///////////////////////////////////////	
public AccountPage login_fill (WebDriver driver,AccountData data)   
    {
	 username_input.sendKeys(data.getUsername());	
	 password_input.sendKeys(data.getPassword());
	 login_button.click();
	 return PageFactory.initElements(driver, AccountPage.class);
    }
public AccountPage reset_password_fill (WebDriver driver,AccountData data)   
{
  forgot_password_link.click();
   WaitTool.waitForElementPresentAndVisible(driver, forgot_password_link);
   forgot_password_input.sendKeys(data.getUsername());
   reset_password_button.click();
   WaitTool.waitForElementPresentAndVisible(driver, reset_password_confirm_button);
   reset_password_confirm_button.click();
   forgot_password_link.click();
 return PageFactory.initElements(driver, AccountPage.class);
}
public AccountPage email_address_fill (WebDriver driver,AccountData data)
{
	email_input.sendKeys(data.getEmail());
	create_account_button.click();
    return PageFactory.initElements(driver, AccountPage.class);
}
public AccountPage setFirstName(String firstname, WebDriver driver)
{	
	first_name_input.sendKeys(firstname);
	return this;
}
public AccountPage setCompany(String company, WebDriver driver)
{	
	company_input.sendKeys(company);
	return this;
}
public AccountPage setAddress(String address, WebDriver driver)
{	
	address_input.sendKeys(address);
	return this;
}
public AccountPage setCity(String city, WebDriver driver)
{	
	city_input.sendKeys(city);
	return this;
}
public AccountPage setLastname(String lastname, WebDriver driver)
{	
	last_name_input.sendKeys(lastname);
	return this;
}
public AccountPage setPostal_code(String postal_code, WebDriver driver)
{	
	postal_code_input.sendKeys(postal_code);
	return this;
}
public AccountPage setPhone(String phone, WebDriver driver)
{	
	phone_input.sendKeys(phone);
	return this;
}
public AccountPage setUsername(String username, WebDriver driver)
{	
	username2_input.sendKeys(username);
	return this;
}
public AccountPage setPassword(String password, WebDriver driver)
{	
	password2_input.sendKeys(password);
	return this;
}
public AccountPage setConfirm_Pass(String confirm_password, WebDriver driver)
{	
	confirm_password_input.sendKeys(confirm_password);
	return this;
}
public AccountPage setSignature(String signature, WebDriver driver)
{	
	signature_input.sendKeys(signature);
	return this;
}
public AccountPage setCountry(String country, WebDriver driver)
{	
	
	country_dropdown.click();
	country_search_fill.sendKeys(country);
	country_search_fill.sendKeys(Keys.ENTER);
	
	return this;
}
public AccountPage setState(String state, WebDriver driver)
{	
	state_dropdown.click();
	state_search_fill.sendKeys(state);
	state_search_fill.sendKeys(Keys.ENTER);
	return this;
	     
}
public <T> AccountPage fillContactDataFullParam(NewUserInfo contact, WebDriver driver, Class<T> expectedPage) {
	
	WaitTool.waitForElementPresentAndVisible(driver, account_registration_label);
	setFirstName(contact.getFirst_name(), driver);
	setLastname(contact.getLast_name(), driver);
	setCompany(contact.getCompany(), driver);
	setCountry(contact.getCountry(), driver);
	setAddress(contact.getAddress(), driver);
	setCity(contact.getCity(), driver);
	setState(contact.getState(), driver);
	setPostal_code(contact.getPostal_code(), driver);
	setPhone(contact.getPhone(), driver);
	setUsername(contact.getUsername(), driver);
	setPassword(contact.getPassword(), driver);
	setConfirm_Pass(contact.getConfirm_password(), driver);
	MSA_check.click();
	setSignature(contact.getSignature(), driver);
	create_account_and_continue_button.click();
	return (AccountPage) PageFactory.initElements(driver, expectedPage);
}


public AccountPage validate_fields_for_new_account (NewUserInfo data)

{
 MSA_check.click();
 MSA_check.click();
 password2_input.sendKeys(data.getPassword());
 confirm_password_input.sendKeys(data.getWrong_password());
 email_input2.clear();
 email__with_invalid_input.sendKeys(data.getWrong_email());
 username2_input.sendKeys(data.getWrong_user());
 
 
 create_account_and_continue_button.click();
return this;
}


@Override
public AccountPage and() {
	// TODO Auto-generated method stub
	return this;
}

@Override
public AccountPage then() {
	// TODO Auto-generated method stub
	return this;
}

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
	
	public Validator new_account_validations_are_present (final WebDriver driver,AccountData data)   
    {
		return new Validator() {
			@Override
			public void Validate() {
			  String Text = Same_Password_validation.getText();
			  Assert.assertEquals(Text, "both password should be the same");
			  Text = email_validation.getText();
			  Assert.assertEquals(Text, "Email is invalid");
			  Text = username_validation.getText();
			  Assert.assertEquals(Text, "Username should have at least 8 characters");
			  Text = MSA_check_validation.getText();
			  Assert.assertEquals(Text, "Please confirm that you are authorized to sign this");
			  
			
			  
				
			}
			};
	 
    }
	
	public Validator ispaymentmethodspagedisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver, use_new_credit_cart_radiobutton);
			  Assert.assertTrue(use_new_credit_cart_radiobutton.isDisplayed());
			  
			 
				
			}
			};
		}
	public Validator isusernamedisplayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver, username2_input);
			  Assert.assertTrue(username2_input.isDisplayed());
			  
			 
				
			}
			};
		}
	public Validator is_reset_password_empthy(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver,forgot_password_input);
			  String text=forgot_password_input.getText();
			  Assert.assertEquals(text, "");
			  
			  
			 
				
			}
			};
		}
	public Validator ispayment_method_page_displayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver,payment_methods_label);
			  Assert.assertTrue(payment_methods_label.isDisplayed());
			  
			 
				
			}
			};
		}
	public Validator isaccount_Registration_page_displayed(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
			  WaitTool.waitForElementPresentAndVisible(driver,account_registration_label);
			  Assert.assertTrue(account_registration_label.isDisplayed());
			  
			}
			};
		}
}