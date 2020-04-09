package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Hello World..!");
			int i= 1/0;
			System.out.println("Completed");
			
		}
		catch(Exception exp) {   // catch should be followed with one block or multiple catch blocks
			System.out.println("I am inside catch block");
			System.out.println("Message is :"+exp.getMessage());
			System.out.println("The cause is :"+exp.getCause());
			exp.printStackTrace();
		}
		
		finally {   // It will be executed irrespective of any exception
			System.out.println("I am inside finally block");
			
		}
		
	}
}
