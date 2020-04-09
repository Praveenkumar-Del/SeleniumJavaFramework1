package listeners;

import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGlisteners.class)  //If u have multiple classes u can just mention with (,) and write all classes
public class TestNGlistenersDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path :"+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");		
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("abc")).sendKeys("abcd");
		
		driver.close();
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
		
	}

}
