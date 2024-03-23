package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.DriverType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
        switch (driverType) {	    
        case FIREFOX: 
        	System.setProperty("webdriver.firefox.marionette", FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new FirefoxDriver();
	    	break;
        case CHROME:
        	//System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());

			String path = System.getProperty("user.dir");
			String driverpath = path + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);

			break;
        case INTERNETEXPLORER: 
        	System.setProperty("webdriver.ie.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new InternetExplorerDriver();
        }
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}
}