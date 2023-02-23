package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static String value;
	public static String getProperty(String key)
	{
		File file=new File(System.getProperty("user.dir")+"/config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			Properties pro=new Properties();
			pro.load(fis);
			
			value=pro.getProperty(key);
			}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return value;
	}

}
