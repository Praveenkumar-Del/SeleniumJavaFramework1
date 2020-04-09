package PriorityDemo;

import org.testng.annotations.Test;
// Video Link on youtube: Selenium Framework for Beginners 25| TestNG ............

// Imp 1: Dependence will be considered first than priority
// Imp 2: 
public class TestNGDependencyDemo {
	
	@Test(dependsOnGroups = {"sanity.*"}) 
	public void test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test(groups = {"sanity1"})
	public void test2() {
		System.out.println("I am inside Test2");
	}
	
	@Test(groups = {"sanity2"})
	public void test3() {
		System.out.println("I am inside Test3");
	}
}
