package com.demo.selenium.api.design;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface ISeleniumBase {
	
	public RemoteWebDriver launchBrowser(String browserName);
	
	public void goTo(String url);
	
	public void closeBrowser();
	
	public void quitBrowser();
	
	public WebElement getLocator(String domEle);
	
	public List<WebElement> getLocators(String domEle);
	
	public void type(WebElement locator);
	
	public void click(WebElement locator);
	
	public void switchToWindow(int index);
	
	public void switchToWindow(String title);
	
	public void switchToFrame(int index);
	
	public void switchToFrame(WebElement locator);
	
	public void switchToFrame(String idOrName);
	
	public void defaultContent();
	
	public boolean isTitleExpected(WebElement locator);
	
	public boolean isTextExpected(WebElement locator);
	
	public boolean isTextContains(WebElement locator);
	
	public boolean isUrlExpected();
	
	public boolean isUrlContains();

}