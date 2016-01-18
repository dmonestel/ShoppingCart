package com.cart.data;

import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.NoSuchElementException;
import com.ts.commons.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.ts.commons.Validator;

public class PageUtils {

	public static void moveTo(WebElement element, FirefoxDriver driver) {
		Actions builder = new Actions(driver); 
		builder.moveToElement(element).perform();		
	}
	
	public static void selectOptionInDropDownByVisibleText(WebElement element, String TextOptionToSelect) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(TextOptionToSelect);
           
        } catch (NoSuchElementException e) {
            System.out.println("Option value not find in dropdown");
        }
    }
	
	public static <T> T selectDropDownOption(By selector, String option, FirefoxDriver driver, Class<T> expectedPage)
	{
		new Select(driver.findElement(selector)).selectByVisibleText(option);			
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	 public static <T> T selectDropDownOptionByWebElement(WebElement element, String option, FirefoxDriver driver, Class<T> expectedPage)
	 {
	  new Select(element).selectByVisibleText(option);
	  return PageFactory.initElements(driver, expectedPage); 
	 }
	
	public static <T> T selectListOption(By selectorList, By selectorOption, FirefoxDriver driver, Class<T> expectedPage)
	{
		driver.findElement(selectorList).click();
		driver.findElement(selectorOption).click();
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	public static <T> T clickModalOkButton(FirefoxDriver driver, Class<T> expectedPage)
	{
		driver.findElement(By.xpath("//div[@id='modal_content_area']//a[contains(.,'Ok')]")).click();
		return PageFactory.initElements(driver, expectedPage);
	}

	public static Validator isMessageDisplayed(final By selector, final String message, final FirefoxDriver driver){
		return new Validator()
			{
			   @Override
				public void Validate()
				{
					Assert.assertTrue(driver.findElement(selector).getText().toString().equals(message));					
				}
			};
	}
	
	public static Validator isMessageDisplayedwithWebElement(final WebElement element, final String message, final FirefoxDriver driver){
		return new Validator()
			{
			   @Override
				public void Validate()
				{
					Assert.assertTrue(element.getText().toString().equals(message));					
				}
			};
	}
	
	public static <T> T confirmPasswordModal(String password, FirefoxDriver driver, Class<T> expectedPage)
	{
		driver.findElement(By.id("re_enter_password")).sendKeys(password);
		driver.findElement(By.xpath("(//footer[@id='modal_footer']//a[@class='button primary'])[1]")).click();
		
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	public static <T> T confirmProcess(FirefoxDriver driver, Class<T> expectedPage)
	{
		driver.findElement(By.xpath("(//footer[@id='modal_footer']//a[@class='button primary'])[1]")).click();		
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	public static <T> T cancelProcess(FirefoxDriver driver, Class<T> expectedPage)
	{
		driver.findElement(By.xpath("(//footer[@id='modal_footer']//a[@class='button cancel'])[1]")).click();		
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	 public static boolean iselementPresent(FirefoxDriver driver, By by) {
		try {
			driver.findElement(by);     
			return true;     
		} catch (Exception e) {
			return false;
		}
	}
	 
	 public static boolean iselementPresent(WebElement element) {
			try {
				if(element.isDisplayed())     
					return true;     
				else
					return false;
			} catch (Exception e) {
				return false;
			}
		}
	 
	 public static boolean verifyValuesInDropdown(List <WebElement> listOfElements, String[] strValues) {
			boolean bValue = false;
			List <String> list = new ArrayList<String>();
			for (String strValue : strValues) {
				boolean bflag = false;
				for (WebElement element : listOfElements) {
					String elementValue = element.getText();
					if (strValue.equals(elementValue)) {
						bflag= true;
					}
				}
				if (!bflag)
					list.add(strValue);
			}
			if (list.size() > 0) {
				for(String strList : list) {
					System.out.println("Value not present in dropdown: "+strList);
				}
				//Assign false if any of the value not found in dropdown
				bValue = false;
			} else {
				//Assign true if all values found in dropdown
				System.out.println("All value(s) found in dropdown");
				bValue=true;
			}
			return bValue;
		}
	 
	 public static void manualPageRefresh(FirefoxDriver driver){
		 driver.navigate().refresh();  
	 } 
}