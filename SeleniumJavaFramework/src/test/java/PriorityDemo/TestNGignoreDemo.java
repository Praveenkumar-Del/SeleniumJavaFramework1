package PriorityDemo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore -U will not receive any output if you write before class
public class TestNGignoreDemo {
	
	@Ignore
	@Test
	//or @Ignore
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
	}
}
