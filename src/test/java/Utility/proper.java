package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class proper {

	public static String  prop(String value) throws IOException {

		Properties pro =  new Properties();
		String path =System.getProperty("user.dir")+"/src/test/resources/testData/Config.properties";
		File f =  new File(path);

		FileInputStream fis =  new FileInputStream(f);   

		pro.load(fis);


		String values = pro.getProperty(value);


		return values;



	}

}
