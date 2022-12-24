package day1;

import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week6.day2.ReadData;

public class CreateNewOpportunity2 extends Base {
	
	@DataProvider(name="smoke")
	public String[][] fetchData() throws IOException {
		String[][] data =ReadData.readData(Login);
		return data;
	}

//	@Test(dataProvider = "createData", dataProviderClass = inputDataProvider.class)
	@Test(dataProvider = "smoke")
	public void CreateOpportunity(String sName, String date ) {
		
	
		driver.findElement(By.xpath("//div[@role='navigation']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement opportunity = driver.findElement(By.xpath("//h2[text()='App Launcher']/following::p[text()='Opportunities']"));
		Actions a = new Actions(driver);
		a.moveToElement(opportunity).click().build().perform();
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(sName);
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
//		driver.findElement(By.xpath("//input[@name='CloseDate']/following::button[text()='Today']")).click();

		driver.findElement(By.xpath("//button[@type='button'][@role='combobox']")).click();
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Details']")).click();
	
		String opp = driver.findElement(By.xpath("(//span[text()='Opportunity Name'])[2]/following::lightning-formatted-text")).getText();
		
		Assert.assertEquals(opp, sName);
/*		if(opp.equals("Salesforce Automation by Jayaprakash")) {
			System.out.println("opp created successfully");
		}else {
			System.out.println("opp not created successfully");
		}
*/	
		

	}
}


