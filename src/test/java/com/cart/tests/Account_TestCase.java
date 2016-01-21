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



import com.cart.data.AccountData;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.data.newuserInfo;
import com.cart.pages.AccountPage;
import com.cart.pages.LoginPage;
import com.cart.pages.ShoppingCartPage;
import com.cart.pages.UI;
import com.ts.commons.DataSourceXls;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;
import com.ts.commons.Component;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cart.pages.configurationPage;


public class Account_TestCase extends CartTestCase {
	
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException, URISyntaxException {
		return new DataSourceXls("DefaultData.xls").getData(0,1);
	}	
	private configurationPage configPage ;
	private ShoppingCartPage  shoppingCartPage;
	private DeviceData data;
	private AccountPage accountPage;
	private newuserInfo newContact;
	
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
		andUsing
		(
		accountPage
		.login_fill(driver, AccountData.getNew()
		.setUsername(Constants.username)
		.setPassword(Constants.password))
		)
		.check
		(
		accountPage.ispayment_method_page_displayed(driver)		
		);

	}
@Test (dataProvider = "data")

public void Create_an_account_in_sign_up_page_Cart_51_Cae34(String first_name,String Last_name,String Company, String Country,String Address,String City
		, String State,String Postal_code, String Phone,String Username, String Password,String Confirm_password, String Signature){
	configPage = PageFactory.initElements(driver, configurationPage.class);
	accountPage =PageFactory.initElements(driver, AccountPage.class);
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
	andUsing
	(
	accountPage
	.email_address_fill(driver, AccountData.getNew()
	.setEmail(Constants.email))
	)
	.check
	(
	accountPage.isaccount_Registration_page_displayed(driver)		
	);
	using 
	(
			accountPage
			.fillContactDataFullParam(
					newContact = newuserInfo.getNew() 
					.setFirstname(first_name)
					.setLastname(Last_name)
					.setCompany(Company)
					.setCountry(Country)
					.setAddress(Address)
					.setCity(City)
					.setstate(State)
					.setPostal_code(Postal_code)
					.setPhone(Phone)
					.setUsername(Username+Math.random())
					.setPassword(Password)
					.setConfirm_password(Confirm_password)
					.setSignature(Signature)
					, driver, AccountPage.class
					)
		
	)
	.check
	(
	accountPage.ispayment_method_page_displayed(driver)			
	);			
}


}
