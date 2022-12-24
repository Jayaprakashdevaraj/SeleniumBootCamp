package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DeleteOppurtunity {
	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//a[text()[normalize-space()='Salesforce Automation by Jayaprakash']]/following::span[@data-aura-rendered-by='1393:0']")).click();
	}

}
