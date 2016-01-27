package com.cart.tests;
import java.io.IOException;
import java.net.URISyntaxException;
import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cart.data.AccountData;
import com.cart.data.Constants;
import com.cart.data.DeviceData;
import com.cart.data.NewUserInfo;
import com.cart.pages.AccountPage;
import com.cart.pages.ShoppingCartPage;
import com.ts.commons.DataSourceXls;
import com.cart.pages.ConfigurationPage;

public class Account_TestCase extends CartTestCase {
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException, URISyntaxException {
		return new DataSourceXls("DefaultData.xls").getData(0,1);
	}
	
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
@Test ()

public void Clicking_forgot_password_link_by_second_time_Cart_185(){
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
	accountPage
	.reset_password_fill(driver, AccountData.getNew()
	.setUsername(Constants.username)
)
	)
	.check
	(
	accountPage.is_reset_password_empthy(driver)		
	);

}
@Test (dataProvider = "data")

public void Create_an_account_in_sign_up_page_Cart_51_Cae34(String first_name,String Last_name,String Company, String Country,String Address,String City
		, String State,String Postal_code, String Phone,String Username, String Password,String Confirm_password, String Signature){
	configPage = PageFactory.initElements(driver, ConfigurationPage.class);
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
					NewUserInfo.getNew() 
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

@Test ()

public void Check_new_account_validations_cart_84_cart_88_cart_76(){
	configPage = PageFactory.initElements(driver, ConfigurationPage.class);
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
			.validate_fields_for_new_account(NewUserInfo.getNew()
			.setPassword(Constants.password)
			.setWrong_password(Constants.wrong_password)
			.setWrong_email(Constants.wrong_email)
			.setWrong_username(Constants.wrong_username)
			)
	)
	.check
	(
	accountPage.new_account_validations_are_present(driver, AccountData.getNew())			
	);			
}

}
