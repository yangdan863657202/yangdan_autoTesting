package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.testng.log4testng.Logger;

@SuppressWarnings("rawtypes")
public class MyLogger {

	private static final String Log4j = "log4j.properties";

	public static Logger getLogger(Class clazz, String pathLog4j) {
		PropertyConfigurator.configure(org.apache.log4j.Logger.class.getClassLoader()
				.getResource(pathLog4j));
		return Logger.getLogger(clazz);
	}

	public static Logger getLogger(Class clazz) {
		PropertyConfigurator.configure(Logger.class.getClassLoader()
				.getResource(Log4j));
		return Logger.getLogger(clazz);
	}
	
	public static Logger getLogger(String name) {
		PropertyConfigurator.configure(Logger.class.getClassLoader()
				.getResource(Log4j));
		return Logger.getLogger(name);
	}
}
