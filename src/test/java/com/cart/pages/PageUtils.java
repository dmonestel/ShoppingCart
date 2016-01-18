package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ts.commons.FirefoxDriver;

public class PageUtils {
	
	public static <T> T selectDropDownOption(By selector, String option, FirefoxDriver driver, Class<T> expectedPage)
	{
		new Select(driver.findElement(selector)).selectByVisibleText(option);			
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
}