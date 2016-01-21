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
	
	@FindBy(xpath = "//div[@class='action--render--username']/input")
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
	@FindBy(xpath = "//label[@class='field-label']")
	private WebElement MSA_check;
	
	@FindBy(xpath = "//button[@class='btn btn--arrow-right btn--large action--click--signup']")
	private WebElement create_account_and_continue_button;
	
	 @FindBy(xpath = "//input[@class='action--radio--new_credit_card']")
	 private WebElement use_new_credit_cart_radiobutton;
	
	
////////////////////////////////////////////////METHODS///////////////////////////////////////	
public AccountPage login_fill (WebDriver driver,AccountData data)   
    {
	 username_input.sendKeys(data.getUsername());	
	 password_input.sendKeys(data.getPassword());
	 login_button.click();
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