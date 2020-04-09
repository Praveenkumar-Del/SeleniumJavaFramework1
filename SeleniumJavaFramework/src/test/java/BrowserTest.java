import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path :"+projectPath);
		
	//	System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "E:\\JavaSelenium\\SeleniumJavaFramework\\Drivers\\ChromeDriver\\chromedriver1.exe");
		WebDriver driver= new ChromeDriver();
		
	//	System.setProperty("webdriver.ie.driver", "E:\\JavaSelenium\\SeleniumJavaFramework\\Drivers\\InternetExplorerDriver\\IEDriverServer.exe");
	//	WebDriver driver= new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("abcd");
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of Input Elements: "+count );
		
		Thread.sleep(3000);
		driver.quit();
	}
}
