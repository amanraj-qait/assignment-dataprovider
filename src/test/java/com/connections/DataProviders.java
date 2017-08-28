package com.connections;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	ExcelFileReader action;

	@Test(dataProvider = "ComposeEmail")
	public void sendingMails(String recipient, String subject, String contentMail) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//Drivers//chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("arsc997@gmail.com");
		driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("arsc997#");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Mail']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[text()='COMPOSE']")).click();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.className("vO")).sendKeys(recipient);
		Thread.sleep(500);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		Thread.sleep(500);
		driver.findElement(By.xpath("(.//*[@aria-label='Message Body'])[2]")).sendKeys(contentMail);
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
		driver.findElement(By.xpath("//span[@class='gb_7a gbii']")).click();
		driver.findElement(By.xpath(".//a[@id='gb_71']")).click();
		Thread.sleep(5000);
	}

	@DataProvider(name = "ComposeEmail", parallel = true)
	public Object[][] ComposeEmail() throws IOException {
		action = new ExcelFileReader();
		Object[][] obj = action.readFromExcel();
		return obj;
	}

}