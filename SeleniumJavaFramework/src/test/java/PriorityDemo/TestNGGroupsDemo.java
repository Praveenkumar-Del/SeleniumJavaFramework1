package PriorityDemo;

import org.testng.annotations.Test;

//**************MetaGroups
/*<groups>

<define name="Regression1">
<include name="regression"></include>
<include name="smoke"></include>

</define>

<run>
<include name="Regression1"></include>
</run> 
</groups>*/

//*****************

//***********Regular Expressions - If you want to run on Windows or Linux
/*<run>
<include name="windows.*"></include>
</run> */
//***************

//**********Define Groups at class level
/*<run>
<include name="AllClassTests"></include>
</run> */

//testng5.xml

@Test(groups = {"AllClassTests"})
public class TestNGGroupsDemo {
	
	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("This is Test 1");
		
	}
	
	@Test(groups = {"sanity", "Smoke"})
	public void test2() {
		System.out.println("This is Test 2");
		
	}
	
	@Test(groups = {"regression", "sanity"})
	public void test3() {
		System.out.println("This is Test 3");
		
	}
	
	@Test(groups = {"windows.regression"})
	public void test4() {
		System.out.println("This is Test 4");
		
	}
	
	@Test(groups = {"linux.regrssion"})
	public void test5() {
		System.out.println("This is Test 5");
		
	}

}
