package Pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	// Steps
	// 1. Create a class for each web page
	// 2. Add object locators
	// 3. Add action methods
	// 4. Create class for test case
	
	WebDriver driver = null;  // U can add null or may delete it 
	//It is initialized as bz u r writing driver.findElement
	
	By textbox_search = By.name("q");  //Object locators
	By button_search = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {   // Create constructor to call the objects in test class
		this.driver = driver;   //driver= driver1;
	}
	
	public void setTextInSearchBox(String text){     //Methods for doing action on the objects
		driver.findElement(textbox_search).sendKeys(text);  //Don't hard code the value just take it from the method
	}

	public void clickSearchButton() {
		driver.findElement(button_search).click();     //sendKeys(Keys.RETURN);
	}
}
