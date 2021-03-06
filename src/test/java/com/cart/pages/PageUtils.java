package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageUtils {
	
	public static <T> T selectDropDownOption(By selector, String option, WebDriver driver, Class<T> expectedPage)
	{
		new Select(driver.findElement(selector)).selectByVisibleText(option);			
		return PageFactory.initElements(driver, expectedPage); 
	}
	
	public static boolean iselementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);     
			return true;     
		} catch (Exception e) {
			return false;
		}
	}
}