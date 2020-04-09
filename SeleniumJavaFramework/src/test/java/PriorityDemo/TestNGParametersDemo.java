package PriorityDemo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//testng6.xml
public class TestNGParametersDemo {
	
	@Test
	@Parameters({"My Name"})
	public void test(@Optional("Praveen") String name) {
		System.out.println("Name is :"+name);
	}

}
