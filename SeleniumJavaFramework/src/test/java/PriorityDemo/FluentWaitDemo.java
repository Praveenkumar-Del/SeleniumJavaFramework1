package PriorityDemo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

//CTRL+Shift+O --Which gives an automatic  
public class FluentWaitDemo {
	
	public static void main(String[] args) throws Exception {
	 test();
	}
	public static void test() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		driver.findElement(By.name("btnK")).click();
	
		//driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();  //As click is overlapped with result and i use RETURN enter keys
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement =  driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
		       
		       if (linkElement.isEnabled()) {
		    	   
		    	   System.out.println("Element found");
				
			}
			return linkElement;
		       
		       
		     }
		   });

		  element.click();
		
		   Thread.sleep(5000);
		   driver.close();
		   driver.quit();
	}

}
