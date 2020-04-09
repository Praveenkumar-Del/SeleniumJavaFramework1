import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	//Used to set properties of browser like (BrowserName, )
	// Describes a series of key/ value pairs
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);   //If there are any settings causing problem with IE that can be handled by DesiredCapabilities
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\InternetExplorerDriver\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("ÄBCD");
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		driver.findElement(By.name("btnK")).click();
		
		driver.close();
		driver.quit();
	}
}
