package com.demo.selenium.api.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseImplements implements ISeleniumBase {
	public RemoteWebDriver driver;
	
	public RemoteWebDriver launchBrowser(String browserName) {
		switch (browserName) {
		case "Chrome" :
			return driver = new ChromeDriver();
		case "firefox" :
			return driver = new FirefoxDriver();
		case "safari" :
			return driver = new SafariDriver();				
		}
		return null;
	}

	public void goTo(String url) {
		driver.get(url);
		
	}

	public void closeBrowser() {
		driver.close();
		
	}

	public void quitBrowser() {
		driver.quit();
		
	}

	public WebElement getLocator(String domEle) {
		WebElement ele = null;
		String[] arr =domEle.split("=", 2);
		if(arr[0].equalsIgnoreCase("id")) {
			return driver.findElement(By.id(arr[1]));
		}else if (arr[0].equalsIgnoreCase("name")) {
			return driver.findElement(By.name(arr[1]));
		}else if (arr[0].equalsIgnoreCase("class_name")) {
			return driver.findElement(By.className(arr[1]));
		}else if (arr[0].equalsIgnoreCase("LINK_TEXT")) {
			return driver.findElement(By.linkText(arr[1]));
		}else if (arr[0].equalsIgnoreCase("PARTIAL_LINKTEXT")) {
			return driver.findElement(By.partialLinkText(arr[1]));
		}else if (arr[0].equalsIgnoreCase("TAG_NAME")) {
			return driver.findElement(By.tagName(arr[1]));
		}else if (arr[0].equalsIgnoreCase("XPATH")) {
			return driver.findElement(By.xpath(arr[1]));
		}else if (arr[0].equalsIgnoreCase("CSS")) {
			return driver.findElement(By.cssSelector(arr[1]));
		}else {
			System.err.println("Locator is not valid");
		}
		return null;
	}

	public List<WebElement> getLocators(String domEle) {
		WebElement ele = null;
		String[] arr =domEle.split("=", 2);
		if(arr[0].equalsIgnoreCase("id")) {
			return driver.findElements(By.id(arr[1]));
		}else if (arr[0].equalsIgnoreCase("name")) {
			return driver.findElements(By.name(arr[1]));
		}else if (arr[0].equalsIgnoreCase("class_name")) {
			return driver.findElements(By.className(arr[1]));
		}else if (arr[0].equalsIgnoreCase("LINK_TEXT")) {
			return driver.findElements(By.linkText(arr[1]));
		}else if (arr[0].equalsIgnoreCase("PARTIAL_LINKTEXT")) {
			return driver.findElements(By.partialLinkText(arr[1]));
		}else if (arr[0].equalsIgnoreCase("TAG_NAME")) {
			return driver.findElements(By.tagName(arr[1]));
		}else if (arr[0].equalsIgnoreCase("XPATH")) {
			return driver.findElements(By.xpath(arr[1]));
		}else if (arr[0].equalsIgnoreCase("CSS")) {
			return driver.findElements(By.cssSelector(arr[1]));
		}else {
			System.err.println("Locator is not valid");
		}

		return null;
	}

	public void type(WebElement locator) {
		// TODO Auto-generated method stub
		
	}

	public void click(WebElement locator) {
		if(locator.isDisplayed()) {
			if (locator.isEnabled()) {
				locator.click();
			} else {
				driver.executeScript("arguments[0].click()", locator);
			}
		}else {
			System.err.println(locator + "is not displayed");
		}
		
	}

	public void switchToWindow(int index) {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			driver.switchTo().window(allhandles.get(index));
	}

	public void switchToWindow(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String eachWindow : allWindows) {
			driver.switchTo().window(eachWindow);
			if (driver.getTitle().equals(title)) {
				break;
			}	
		}	
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		
	}

	public void switchToFrame(WebElement locator) {
		driver.switchTo().frame(locator);		
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(getLocator(idOrName));		
	}

	public void defaultContent() {
		driver.switchTo().defaultContent();		
	}

	public boolean isTitleExpected(WebElement locator) {
		if(driver.getTitle().equals(locator)) {
			System.out.println("Page title "+locator+" is matched");
		}else {
			System.out.println("Page title is not "+locator+" is matched");
		}
		return false;
	}

	public boolean isTextExpected(WebElement locator) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTextContains(WebElement locator) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUrlExpected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUrlContains() {
		// TODO Auto-generated method stub
		return false;
	}

}
