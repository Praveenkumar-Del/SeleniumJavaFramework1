package PriorityDemo;

import org.junit.Assert;
import org.testng.annotations.Test;

// Manual Running of Failed test cases-Once u run through TestNG it will give in test-output folder with failed 
//test cases with name testng-failed.xml file, then u make alteration in the test cases and run it again that .xml file
//***********************
//Automated Running of Failed Test Cases- Run through the testng.xml file and also u get failed test cases in the test-output,
// u can run the test cases throgh .xml 

//Automatically retrying test whenever it fails
//By implementing IRetryAnalyzer in MyRetry.java class

public class TestNGRetryFailedDemo {

	@Test
	public void test1()
	{
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("I am inside Test 2");
	//	int i =1/0;
	}
	
	@Test(retryAnalyzer = listeners.MyRetry.class)
	public void test3()
	{
		System.out.println("I am inside Test 3");
		Assert.assertTrue(0>1);
	}
}
