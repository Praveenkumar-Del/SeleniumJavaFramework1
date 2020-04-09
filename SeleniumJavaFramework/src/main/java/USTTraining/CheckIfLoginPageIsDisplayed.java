package USTTraining;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckIfLoginPageIsDisplayed {

	static ChromeDriver chrome;
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		chrome= new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		chrome.manage().window().maximize();

		chrome.get("https://opensource-demo.orangehrmlive.com/");
		String ActWebpageTitle = chrome.getTitle();
		System.out.println("The title is :"+ActWebpageTitle);	
		String ExpWebpageTitle = "OrangeHRM";

		if (ActWebpageTitle.equals(ExpWebpageTitle)) {
			System.out.println("Home page is opened successfully");

		} 
		else {			
			System.out.println("Home page is not opened scuccessfully");

		}
		chrome.findElement(By.id("txtUsername")).sendKeys("Admin");
		chrome.findElement(By.id("txtPassword")).sendKeys("admin123");
		chrome.findElement(By.name("Submit")).click();
		String ActMessage = chrome.findElement(By.id("welcome")).getText();
		System.out.println("The Login Message is :"+ActMessage);
		String expMessage= "Welcome Admin";
		
		if (expMessage.equals(ActMessage)) {

			System.out.println("Login Credentials are absolute");
		} else {
			System.out.println("Login Credentials are not absolute");
		}
		
		chrome.close(); 
		System.out.println("Test executed Succesfully");
	}
}
