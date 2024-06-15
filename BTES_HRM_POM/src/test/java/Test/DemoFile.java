package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFile {
	public static WebDriver driver;
	public static Properties prop;
	 
	  public static Properties read_prop_file() throws IOException {
		    String path =System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\properties_configuration";
		    FileInputStream f1 = new FileInputStream(path); 
		    prop = new Properties();
		    prop.load(f1);
		    return prop;
	}
	  public static void initialize() throws IOException {
		  driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  Properties p1 = read_prop_file();
		  driver.get(p1.getProperty("URL"));	  }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initialize();

	}

}
