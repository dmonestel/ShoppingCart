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

import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.pages.LoginPage;
import com.cart.pages.UI;
import com.ts.commons.DataSourceXls;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cart.pages.configurationPage;


public class ConfigurationlistTest extends CartTestCase {
	
	
	private configurationPage configPage ;
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
	}
	
	@Test ()
	
	public void Add_configuration_Windows_Cart_63()
	{
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
		.setHostname(Constants.hostname))
		)
		.check
		(
		configPage.verify_summary_on_the_right(driver)		
		);
		andUsing
		(
		configPage.windows_server_creation()		
		)
		.check
		(
		configPage.verify_summary_with_windows(driver)
		);
		andUsing
		(
		configPage.add_to_cart_click()		
		)
		.check
		(
		configPage.verify_your_shopping_cart_label(driver)
		);
		
	}
@Test ()
	
	public void Add_configuration_CentOS_Cart_66()
	{
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
		.setHostname(Constants.hostname))
		)
		.check
		(
		configPage.verify_summary_on_the_right(driver)		
		);
		andUsing
		(
		configPage.Centos__Cpanel_backup_management_server_creation()	
		)
		.check
		(
		configPage.verify_summary_with_cPanel_SBM_Agents(driver)
		);		
	}

@Test ()

public void Verify_server_locations_cart_119()
{
	configPage = PageFactory.initElements(driver, configurationPage.class);
	using
	(			
	configPage.configuration_Server_page_loading()	
	)
	.check
	(
	configPage.verify_locations(driver)	
	);
	
	
	
	
	
}	

//Tengo que analizar este caso
@Test ()
public void Adding_bandwidth_depending_of_the_location_selected_Cart_162(){
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
//
@Test ()
public void add_add_on_services_shared_backup (){
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
	.setHostname(Constants.hostname))
	)
	.check
	(
	configPage.verify_summary_on_the_right(driver)		
	);
	andUsing
	(
	configPage.shared_backup_selection()		
	)
	.check
	(
	configPage.verify_UT_summary(driver)		
	);
  }
}


