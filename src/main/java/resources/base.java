package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver invokeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Harsha\\QuickenLoans\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\harsha\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harsha\\Desktop\\chromedriver.exe\\");
			driver = new ChromeDriver();
		} 
		else 
		{
			System.out.println("Please install the driver file of " + browserName + " and set the path");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	

	

}
