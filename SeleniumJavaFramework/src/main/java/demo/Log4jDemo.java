package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4jDemo {

	// Check log4J files with different options changing it here 
	//logger.file.level = trace  and rootLogger.level = trace
	
	//1. trace - Result at the end will be increased with previous outcomes 
	// 2. debug - Only result will be shown
	// 3. off- It will not show any result in MyLog.log file
	private static Logger logger = (Logger) LogManager.getLogger(Log4jDemo.class); 
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello World...! \n");
		
		logger.trace("This is trace message");
		logger.info("This is Information messgae");
		logger.error("This is an error message");
		logger.warn("This is warning message");
		logger.fatal("This is fatal message");
		
		System.out.println("\n Completed");
	}
}
