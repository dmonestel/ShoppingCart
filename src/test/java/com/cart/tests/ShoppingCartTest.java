package com.cart.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cart.data.AccountPage;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.pages.ShoppingCartPage;
import com.cart.pages.configurationPage;

public class ShoppingCartTest extends CartTestCase  {
	
	private configurationPage configPage ;
	private ShoppingCartPage  shoppingCartPage;
	private DeviceData data;
	private AccountPage accountPage;
	
	
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
	
	
	@Test ()
	public void Add_more_than_2_servers_to_the_cart_Cart_67(){
		configPage = PageFactory.initElements(driver, configurationPage.class);
		
		using
		(			
		configPage.configuration_Server_page_loading()	
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
				configPage=shoppingCartPage.gotToConfigurationPage(driver)
				.configuration_add_third_server(driver)
		)
		.check(
				configPage.is_configuration_displayed(driver)
		);
		andUsing(
				
				configPage.hostname_fill(DeviceData.getNew()
						.setHostname("secondServer.com"))
				
		).check
		(
		configPage.verify_windows_db_with_centos(driver)
		);	
		andUsing(
		shoppingCartPage= configPage.AddToCart(driver,data.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    );
	
	}
}
