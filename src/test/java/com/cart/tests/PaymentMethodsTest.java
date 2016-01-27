package com.cart.tests;
import java.io.IOException;
import java.net.URISyntaxException;
import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cart.data.AccountData;
import com.cart.data.Constants;
import com.cart.data.CreditCardData;
import com.cart.data.DeviceData;
import com.cart.pages.AccountPage;
import com.cart.pages.PaymentMethodsPage;
import com.cart.pages.ReviewOrderPage;
import com.cart.pages.ShoppingCartPage;
import com.ts.commons.DataSourceXls;
import com.cart.pages.ConfigurationPage;

public class PaymentMethodsTest extends CartTestCase {
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException, URISyntaxException {
		return new DataSourceXls("DefaultData.xls").getData(1,1);
	}	
	private ConfigurationPage configPage ;
	private ShoppingCartPage  shoppingCartPage;
	private AccountPage accountPage;
	private PaymentMethodsPage paymentPage;
	private ReviewOrderPage reviewOrderPage;
	

	@Test (dataProvider = "data")

	public void addNewCreditCard_Cart53_Cart55_Cart56_Cart57_Cart58_Cart59(
			String firstName, 
			String lastName, 
			String type,
			String cardNumber, 
			String expirationMonth, 
			String expirationYear, 
			String securityCode, 
			String defaultCard, 
			String useNewAddress, 
			String address, 
			String country, 
			String state, 
			String city, 
			String postalCode
			){
		
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
		andUsing
		(
		paymentPage = accountPage 
		.login_fill(driver, AccountData.getNew()
			.setUsername(Constants.username)
			.setPassword(Constants.password))
		)
		.check
		(
				accountPage.ispayment_method_page_displayed(driver)
		);
		andUsing 
		(
				reviewOrderPage = paymentPage
				.useNewCreditCard(
						
						CreditCardData.getNew() 
						.setFirstName(firstName)
						.setLastName(lastName)
						.setCardNumber(cardNumber)
						.setExpirationMonth(expirationMonth)
						.setExpirationYear(expirationYear)
						.setSecurityCode(securityCode)
						.setDefaultCard(defaultCard)
				        .setAddress(address)
						.setCountry(country)
						.setState(state)
						.setCity(city)
						.setPostalCode(postalCode)
						, useNewAddress, driver
						)	
		)
		.check
		(
				reviewOrderPage.isEqualTheCreditCardNumber(cardNumber, driver)			
		);			
	}
}