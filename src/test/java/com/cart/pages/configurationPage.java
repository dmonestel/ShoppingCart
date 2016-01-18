package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ts.commons.FirefoxDriver;
import com.ts.commons.Validator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cart.data.DeviceData;
import com.cart.data.PageUtils;
import com.ts.commons.Page;
import com.ts.commons.RaceConditions.WaitTool;

public class configurationPage extends Page {
////////////////////////////////////////////////XPATH////////////////////////////////////	
	@FindBy(xpath = "(//a[@class='action--click--configure_plan btn btn--primary'])[1]")
	private WebElement configure_button;
	
	@FindBy(xpath = "//a[@href[contains(.,'configurations')]]")
	private WebElement configuration_list_button;
	
	@FindBy(xpath = "//span[@class='productBlock-name action--text--configuration_title']")
	private WebElement configuration_server_title;
	
	@FindBy(xpath = "(//li[contains(.,'Dallas, TX (US Central)')])[3]")
	private WebElement localization_title;
	
	@FindBy(xpath = "(//li[contains(.,'CentOS 7')])[3]")
	private WebElement software_title;
	
	@FindBy(xpath = "//span[@class='price-amount action--text--monthly_price']")
	private WebElement monthly_price;
	
	@FindBy(xpath = "(//label[@class='is-disabled']//div[@class='optionsList-item-name field-input'])[1]")
	private WebElement microsoft1_db_centos;
	
	@FindBy(xpath = "(//label[@class='is-disabled']//div[@class='optionsList-item-name field-input'])[2]")
	private WebElement microsoft2_db_centos;
	
	@FindBy(xpath = "(//label[@class='is-disabled']//div[@class='optionsList-item-name field-input'])[3]")
	private WebElement microsoft3_db_centos;
	
	@FindBy(xpath = "//input[@id='hostname-1']")
	private WebElement hostname_input;
	
	@FindBy(xpath = "//a[@class='btn btn--block btn--large btn--reverse action--click--checkout']")
	private WebElement add_to_cart_button;
	
	

	
////////////////////////////////////////////////XPATH////////////////////////////////////

////////////////////////////////////////////////METHODS////////////////////////////////////
	public configurationPage configuration_Server_page_loading()
	{
		configuration_list_button.click();
		configure_button.click();
		
		return this;
	}
	
	public configurationPage hostname_fill (DeviceData data)
    
    {
		hostname_input.sendKeys(data.getHostname());
		return this;
    }
      
     
  

	
	
////////////////////////////////////////////////METHODS////////////////////////////////////
	
////////////////////////////////////////////////VALIDATIONS////////////////////////////////////	
	public Validator verify_summary_on_the_right(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,configuration_server_title);
				Assert.assertTrue(configuration_server_title.isDisplayed());
				Assert.assertTrue(localization_title.isDisplayed());
				Assert.assertTrue(software_title.isDisplayed());
				boolean price= monthly_price.isDisplayed();
				Assert.assertTrue(price, "The Monthly Price is not present");
				
			}
		};
	}
	
	public Validator verify_windows_db_with_centos(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,microsoft1_db_centos);
				
				boolean windows_db_option1= microsoft1_db_centos.isEnabled();
				Assert.assertTrue(windows_db_option1, "Microsoft SQL Server 2014 Web Edition is enabled");
				
				boolean windows_db_option2= microsoft2_db_centos.isEnabled();
				Assert.assertTrue(windows_db_option2, "Microsoft SQL Server 2014 Standard Edition is enabled");
				
				boolean windows_db_option3= microsoft3_db_centos.isEnabled();
				Assert.assertTrue(windows_db_option3, " Microsoft SQL Server 2014 Enterprise Edition is enabled");
				
				
			}
		};
	}
	
////////////////////////////////////////////////VALIDATIONS////////////////////////////////////	
	
	

	@Override
	public configurationPage and() {
		return this;
	}
	@Override
	public configurationPage then() {
		return this;
	}
	
	

}
