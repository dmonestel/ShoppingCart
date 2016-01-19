package com.cart.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import jxl.read.biff.BiffException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cart.data.AccountPage;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.pages.LoginPage;
import com.cart.pages.ShoppingCartPage;
import com.cart.pages.UI;
import com.ts.commons.DataSourceXls;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cart.pages.configurationPage;


public class ConfigurationlistTest extends CartTestCase {
	
	
	private configurationPage configPage ;
	private ShoppingCartPage  shoppingCartPage;
	private DeviceData data;
	private AccountPage accountPage;
	
	
	
	@Test ()
	public void verify_summary_on_the_right_Cart_133(){
		configPage = PageFactory.initElements(driver, configurationPage.class);
		using
		(			
		configPage.configuration_Server_page_loading()	
		)
		.check
		(
		configPage.verify_summary_on_the_right(driver)		
		);
				
	}
	
	@Test ()
	public void Tooltip_for_the_unavailable_Microsoft_database_option_Cart_61(){
		configPage = PageFactory.initElements(driver, configurationPage.class);
		using
		(			
		configPage.configuration_Server_page_loading()	
		)
		.check
		(
		configPage.verify_windows_db_with_centos(driver)		
		);	
			
	}
	
	@Test ()
	
	public void add_server_to_Cart_Cart_175(){
		configPage = PageFactory.initElements(driver, configurationPage.class);
		using
		(			
		configPage.configuration_Server_page_loading()	
		)
		.check
		(
		configPage.verify_windows_db_with_centos(driver)		
		);
	
		andUsing
		(configPage
		.hostname_fill(DeviceData.getNew()
		.setHostname(Constants.hostname)
		)
		)
		.check
		(
		configPage.verify_windows_db_with_centos(driver)
		
		);
		andUsing(
				shoppingCartPage= configPage.AddToCart(driver,data.getNew()) 
				
	    )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    );
		andUsing(
				accountPage=shoppingCartPage.gotTocheckout(driver)
		)
		.check(
				accountPage.isAccountdisplayed(driver)
				);
		
		
		
	
		
		
		
	
	
	}
	
	
	

}
