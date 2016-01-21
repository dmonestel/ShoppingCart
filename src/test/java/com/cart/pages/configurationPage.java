package com.cart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ts.commons.FirefoxDriver;
import com.ts.commons.Validator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.data.PageUtils;
import com.ts.commons.Page;
import com.ts.commons.RaceConditions.WaitTool;

public class configurationPage extends Page {

public int total;	
	
	
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
	private WebElement software_title_centos7;
	
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
	
	@FindBy(xpath = "(//div[@class='optionsList-item-name field-input']//span[contains(.,'Windows Server 2012 R2 Standard Edition')])[1]")
	private WebElement windows_radio_option;
	
	@FindBy(xpath = "(//span[contains(.,'Microsoft SQL Server 2014 Web Edition')])[1]")
	private WebElement windows_db_radiobutton;
	
	@FindBy(xpath = "(//li[contains(.,'Windows Server 2012 R2 Standard Edition')])[4]")
	private WebElement software_title_windows;
	
	@FindBy(xpath = "(//li[contains(.,'Microsoft SQL Server 2014 Web Edition')])[9]")
	private WebElement software_title_db_windows;
	
	@FindBy(xpath = "//h1[contains(.,'Your Shopping Cart')]")
	private WebElement your_shopping_cart_label;
	
	@FindBy(xpath = "//div[@class='optionsList-item-name field-input']//span[contains(.,'cPanel')]")
	private WebElement cPanel_radio_button;
	
	@FindBy(xpath = "//div[@class='optionsList-item-name field-input']//span[contains(.,'Server Backup Manager')]")
	private WebElement server_backup_manager_radio_button;
	
	@FindBy(xpath = "//div[@class='optionsList-item-name field-input']//span[contains(.,'1 Virtual Agent')]")
	private WebElement virtual_agent_radio_button;
	
	@FindBy(xpath = "(//li[contains(.,'cPanel')])[3]")
	private WebElement cPanel_summary;
	
	@FindBy(xpath = "(//li[contains(.,'1 Physical Agent')])[3]")
	private WebElement physical_agent_summary;
	
	@FindBy(xpath = "(//li[contains(.,'Server Backup Manager')])[3]")
	private WebElement SBM_summary;
	
	@FindBy(xpath = "(//li[contains(.,'1 Virtual Agent')])[3]")
	private WebElement virtual_agent_summary;
	
	@FindBy(xpath = "//span[contains(.,'Dallas, TX (US Central)')]")
	private WebElement Dallas_location;
	//Locations
	@FindBy(xpath = "//span[contains(.,'Montreal, QC (Canada East)')]")
	private WebElement Montreal_location;
	@FindBy(xpath = "//span[contains(.,'Santa Clara, CA (US West)')]")
	private WebElement S_Clara_location;
	@FindBy(xpath = "//span[contains(.,'Secaucus, NJ (US East)')]")
	private WebElement Secaucus_location;
	@FindBy(xpath = "//span[contains(.,'Amsterdam')]")
	private WebElement Amsterdam_location;
	@FindBy(xpath = "//span[contains(.,'London')]")
	private WebElement London_location;
	@FindBy(xpath = "//span[contains(.,'Hong Kong')]")
	private WebElement Hong_Kong_location;
	@FindBy(xpath = "//span[contains(.,'Singapore')]")
	private WebElement Singapure_location;
	//Locations
	
	@FindBy(xpath = "(//span[@class='action--text--option_name'][contains(.,'50GB Backup')])[1]")
	private WebElement fiftyGB_backup;
	
	@FindBy(xpath = "(//li[contains(.,'50GB Backup')])[5]")
	private WebElement universal_transfer_summary;

	@FindBy(xpath = ".//span[@class='price-amount action--text--monthly_price']")
	private WebElement totalMonthly_label;
	

	
////////////////////////////////////////////////XPATH////////////////////////////////////

////////////////////////////////////////////////METHODS////////////////////////////////////
	
	public configurationPage add_to_cart_click()
	{
		
		add_to_cart_button.click();
		
		return this;
	}
	
	public configurationPage configuration_Server_page_loading()
	{
		configuration_list_button.click();
		configure_button.click();
		
		return this;
	}
	
	public configurationPage windows_server_creation()
	{
		
		windows_radio_option.click();
		windows_db_radiobutton.click();
		
	
		return this;
	}
	public configurationPage shared_backup_selection()
	{
		fiftyGB_backup.click();
		return this;
	}
	public configurationPage Centos__Cpanel_backup_management_server_creation()
	{
		
		cPanel_radio_button.click();
		server_backup_manager_radio_button.click();
		virtual_agent_radio_button.click();
		
	
		return this;
	}
	
	public configurationPage Asia_pacific_location_selection()
	{
		
		
		Hong_Kong_location.click();
		
		
	
		return this;
	}
	
	
	
	public configurationPage hostname_fill (DeviceData data)
    
    {
		hostname_input.sendKeys(data.getHostname());
		return this;
    }
public ShoppingCartPage AddToCart (WebDriver driver, DeviceData data)
    
    {
		add_to_cart_button.click();
		
		int totalCaracteres=totalMonthly_label.getText().length();
		
		
		
		total=Integer.valueOf(totalMonthly_label.getText().substring(1,(totalCaracteres-3)));
		Constants.setTotalMes(total);
		return PageFactory.initElements(driver, ShoppingCartPage.class);
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
				Assert.assertTrue(software_title_centos7.isDisplayed());
				boolean price= monthly_price.isDisplayed();
				Assert.assertTrue(price, "The Monthly Price is not present");
				
			}
		};
	}
	public Validator verify_UT_summary(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,configuration_server_title);
				boolean UT= universal_transfer_summary.isDisplayed();
				Assert.assertTrue(UT, "The Universal Transfer summary is not present");
				
			}
		};
	}
	
	public Validator verify_locations(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				boolean Location;
				WaitTool.isElementPresentAndDisplay(driver,configuration_server_title);
				Location = Dallas_location.isDisplayed();
				Assert.assertTrue(Location, "Dallas option is not present");
				Location = Montreal_location.isDisplayed();
				Assert.assertTrue(Location, "Montreal option is not present");
				Location = S_Clara_location.isDisplayed();
				Assert.assertTrue(Location, "Santa Clara option is not present");
				Location = Secaucus_location.isDisplayed();
				Assert.assertTrue(Location, "Secaucis option is not present");
				Location = Amsterdam_location.isDisplayed();
				Assert.assertTrue(Location, "Amsterdam option is not present");
				Location = London_location.isDisplayed();
				Assert.assertTrue(Location, "London option is not present");
				Location = Hong_Kong_location.isDisplayed();
				Assert.assertTrue(Location, "Hong Kong option is not present");
				Location = Singapure_location.isDisplayed();
				Assert.assertTrue(Location, "Singapure option is not present");			
			}
		};
	}
	
	public Validator verify_summary_with_windows(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,configuration_server_title);
				Assert.assertTrue(configuration_server_title.isDisplayed());
				Assert.assertTrue(localization_title.isDisplayed());
				Assert.assertTrue(software_title_windows.isDisplayed());
				Assert.assertTrue(software_title_db_windows.isDisplayed());
				boolean price= monthly_price.isDisplayed();
				Assert.assertTrue(price, "The Monthly Price is not present");
				
			}
		};
	}
	public Validator verify_summary_with_cPanel_SBM_Agents(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,configuration_server_title);
				Assert.assertTrue(configuration_server_title.isDisplayed());
				Assert.assertTrue(localization_title.isDisplayed());
				Assert.assertTrue(software_title_centos7.isDisplayed());
				Assert.assertTrue(cPanel_summary.isDisplayed());
				Assert.assertTrue(SBM_summary.isDisplayed());
				Assert.assertTrue(virtual_agent_summary.isDisplayed());
				Assert.assertTrue(physical_agent_summary.isDisplayed());
				boolean price= monthly_price.isDisplayed();
				Assert.assertTrue(price, "The Monthly Price is not present");
				
			}
		};
	}
	public Validator verify_your_shopping_cart_label(final WebDriver driver){
		return new Validator() {
			@Override
			public void Validate() {
				
				
				WaitTool.isElementPresentAndDisplay(driver,your_shopping_cart_label);
				
				boolean label= your_shopping_cart_label.isDisplayed();
				Assert.assertTrue(label, "The Your Shopping Cart Page is not shown");
				
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
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
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
