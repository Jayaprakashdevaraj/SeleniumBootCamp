package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class EditOpportunity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("jayaprakash1803@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Jp@180393");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@role='navigation']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement opportunity = driver.findElement(By.xpath("//h2[text()='App Launcher']/following::p[text()='Opportunities']"));
		Actions a = new Actions(driver);
		a.moveToElement(opportunity).click().build().perform();
		
		driver.findElement(By.linkText("Salesforce Automation by Jayaprakash")).click();
	//	driver.findElement(By.xpath("//span[text()='Show more actions']")).click();
		WebElement more = driver.findElement(By.xpath("//span[text()='Show more actions']"));
		Actions clickMore = new Actions(driver);
		clickMore.moveToElement(more).click().perform();
		driver.findElement(By.xpath("//a[@name='Edit']")).click();
		
		WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		date.clear();
		date.sendKeys("12/02/2022");
		WebElement stageDropdown = driver.findElement(By.xpath("(//button[@type='button'][@role='combobox'])[2]"));
		driver.executeScript("arguments[0].click();", stageDropdown);
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		WebElement deliveryState = driver.findElement(By.xpath("(//button[@type='button'][@role='combobox'])[4]"));
		driver.executeScript("arguments[0].click();", deliveryState);
		//.click();
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Saleforec edit");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		String stage = driver.findElement(By.xpath("(//span[text()='Stage'])[2]/following::span")).getText();
		
		if(stage.equals("Perception Analysis")) {
			System.out.println("State edited successfully");
		}else {
			System.out.println("Stage is not edited successfully");
		}


	}

}
