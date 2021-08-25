package base;




	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;





	public class baseTest  {
		
		public static Properties config;
		public static WebDriver driver;
		
		

		
		
		public baseTest() {
		try {	
			config = new Properties();
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\resources\\config.properties");
			config.load(fin);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	  } 
		
		public static void initialization() {
			String browserName = config.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\CVS-workspace\\DRIVES-CVS\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browserName.equals("IE")){
				System.setProperty("webdriver.IE.driver","C:\\CVS-workspace\\DRIVES-CVS\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
	
			
			driver.get(config.getProperty("baseURL"));
			driver.manage().window().maximize();
		
		}


		
	}	
		









