package PriorityDemo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {  
	
	//Important Points to be considered during interview
	
	//Imp 1: When we set priority same for all the methods then it considers the alphabets of methods name
	//Imp 2: If there is no priority is given still it consider and goes with alphabetically
	//Imp 3: When we have mix of priority and non-priority methods, then first it will execute non-prioritized methods
	//Imp 4: When there are many non prioritized methods, then it executes alphabetically by reading method name
	
	@Test(priority = 1) 
	public void Test1() {
		System.out.println("I am Inside Test1");
	}
	
	@Test(priority = 1)
	public void Test2() {
		System.out.println("I am Inside Test2");
	}
	
	@Test(priority = -2)
	public void Test3() {
		System.out.println("I am Inside Test3");
	}
}


// Include and Exclude mvn tests
//http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html