package listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGlisteners.class)  //If u have multiple classes u can just mention with (,) and write all classes
public class TestNGlistenersDemo2 {
	
	@Test
	public void test4() {
		System.out.println("I am inside Test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("I am inside Test 5");
		throw new SkipException("Its skipped hahahaha");
		
	}
	
	@Test
	public void test6() {
		System.out.println("I am inside Test 6");
		
	}

}
