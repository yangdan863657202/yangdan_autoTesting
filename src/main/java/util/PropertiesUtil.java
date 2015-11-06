package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	
	public static String getValue(String pathname,String key){
		Properties properties=new Properties();
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(pathname));
			return properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
