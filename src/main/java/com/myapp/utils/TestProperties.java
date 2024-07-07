package com.myapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.myapp.Context.Constants;

public class TestProperties {
	
	public static Properties getProperties() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(Constants.configFilePath);
		prop.load(fis);
		return prop;
	}

}
