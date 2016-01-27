package com.cart.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cart.pages.AccountPage;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.pages.ShoppingCartPage;
import com.cart.pages.ConfigurationPage;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class ShoppingCartTest extends CartTestCase  {
	
	private ConfigurationPage configPage ;
	private ShoppingCartPage  shoppingCartPage;
	private AccountPage accountPage;
	
	
	@Test ()
	public void add_server_to_Cart_Cart_175(){
		
		configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
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
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
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
	public void add_more_than_2_servers_to_the_cart_Cart_67(){
		configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
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
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
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
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    );
	
	}
	
	@Test ()
	public void adding_more_than_one_server_in_differents_locations_CART_157(){
		configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
		using
		(			
		configPage.configuration_Server_page_loading()	
		.hostname_fill(DeviceData.getNew()
		.setHostname(Constants.hostname)
		)
		.Asia_pacific_location_selection()
		)
		.check
		(
		configPage.verify_windows_db_with_centos(driver)
		
		);	
		andUsing(
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
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
						.amsterdam_location_selection()
				
		).check
		(
		configPage.verify_windows_db_with_centos(driver)
		);	
		andUsing(
		
				shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isLocationsDisplayed(driver)
	    );
	
	}
	
	@Test ()
	public void editing_a_product_in_shopping_cart_CART_153(){
		configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
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
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    );
		andUsing(
				configPage=shoppingCartPage.gotToEditOption(driver)
				.amsterdam_location_selection()
				.editHostname_fill(DeviceData.getNew()
						.setHostname("Edit"+Constants.hostname))
				
		)
		.check(
				configPage.is_configuration_for_edit_displayed(driver)
		);
		andUsing(
				
				shoppingCartPage=configPage.only_AddToCart(driver, DeviceData.getNew())
				
		).check
		(
	             shoppingCartPage.isEditItem(driver)
	    );
	
	}

	
	@Test ()
	public void remove_a_server_from_Cart_when_there_is_only_a_item_Cart_5(){
		
		configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
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
		shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    );
		andUsing(
				shoppingCartPage.clickRemovelink(driver)
		)
		.check(
				shoppingCartPage.isItemDeleted(driver)
		);
   }
	
	@Test ()
	public void remove_a_server_from_Cart_when_there_are_more_two_items_Cart_68(){
		
	configPage = PageFactory.initElements(driver, ConfigurationPage.class);
		
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
				shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
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
				shoppingCartPage= configPage.AddToCart(driver,DeviceData.getNew()) 
				
	   )
	    .check(
	    	  shoppingCartPage.isShoppingCartdisplayed(driver)
	    ); 
		andUsing(
				shoppingCartPage.clickRemovelink(driver)
		)
		.check(
				shoppingCartPage.isOnlyanItemDeleted(driver)
		);
		
   }

}
