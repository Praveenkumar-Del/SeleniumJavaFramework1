package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import test.ExcelUtils;

public class ExcelDataProvider {  //Create a class for ExcelUtils
	WebDriver driver = null; 
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();	
		
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
			driver = new ChromeDriver();					
	}	
	@Test(dataProvider="test1Data")
	public void test1(String userName, String password) throws InterruptedException {
		System.out.println(userName+ " / "+password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);		
		Thread.sleep(2000);
		
		driver.findElement(By.name("Submit")).click();
		String ActMessage = driver.findElement(By.id("welcome")).getText();
		System.out.println("The Login Message is :"+ActMessage);
		String expMessage= "Welcome Admin";
		
		if (expMessage.equals(ActMessage)) {

			System.out.println("Login Credentials are absolute");
		} else {
			System.out.println("Login Credentials are not absolute");
		}

		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.id("welcome-menu")).click();
		System.out.println("Successfully logged out");
		driver.close(); 		
		System.out.println("Test executed Succesfully");
	}
		
	@DataProvider(name="test1Data")
	public Object[][] getData() throws IOException {  //Why Object array??
		
		String excelPath= "E:\\JavaSelenium\\SeleniumJavaFramework\\excel\\Data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;		
	}
	
	public static Object[][] testData(String excelPath, String sheetName) throws IOException {  //static method is in order to call the data from main static method
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName); // Create a function and create object for ExcelUtils
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object [rowCount-1][colCount];  //rowCount-1 bz the header has to be removed
		
		for (int i = 1; i < rowCount; i++) {
			
			for (int j = 0; j < colCount; j++) {
				
				String cellData= excel.getCellDataString(i, j);
				System.out.print(cellData+" ");
				data[i-1][j]= cellData; //Here i starts with 1 but index in array starts with 0. so, i-1				
			}
			System.out.println();			
		}
		return data;		
	}

}
