package com.myapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static Properties getProperties() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Configurations\\config.properties");
		
		prop.load(fis);
		
		return prop;
	}

}