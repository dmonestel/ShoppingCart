package com.cart.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cart.data.Constants;
import com.cart.pages.LoginPage;
import com.cart.pages.UI;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;

public class CartTestCase extends TestCaseUtil{
	
	protected FirefoxDriver driver = null;
	protected LoginPage loginPage = null;
	protected UI ui = null;	
	
	@BeforeSuite (alwaysRun = true)
	@Parameters({"automationfile"})
	public void initFramework(@Optional("automation.properties") String configfile) throws Exception {

		Properties p = new Properties();
		FileInputStream  conf = new FileInputStream(configfile);
		p.load(conf);

		Constants.setTIME_OUT(Integer.parseInt(p.getProperty( "TIME_OUT" ).toString()));
		Constants.setDomain(p.getProperty( "DOMAIN" ).toString());
		Constants.setLOGOUT_URL(p.getProperty( "LOGOUT_URL").toString());
		Constants.setHostname (p.getProperty("hostname" ).toString());
		Constants.setUsername (p.getProperty("username" ).toString());
		Constants.setPassword (p.getProperty("password" ).toString());
		Constants.setEmail (p.getProperty("email" ).toString());
		Constants.setTotalMes(0);
	
	}
	
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception {
		ui = new UI();
		driver = ui.getFirefoxDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();  
		driver.get(Constants.DOMAIN);
		loginPage = ui.getLandingPage();
		Constants.setTotalMes(0);
	}

	@AfterMethod (alwaysRun = true)
	public void close() throws Exception {
		//driver.close();
		
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public FirefoxDriver getDriver(){
		return driver;
	}
}