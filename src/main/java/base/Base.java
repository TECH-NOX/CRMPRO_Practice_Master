package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.UtilityVariables;

public class Base {

	public static WebDriver driver = null;
	public static InputStream is = null;
	public static Properties prop = null;

	public Base() {
		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/configuration/config.properties");
			prop = new Properties();
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error with Loading Properties File");
		}
	}

	public static void setUp() {
		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().version("76.0.3809.68").setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().version("63.0").setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().version("76.0.3809.68").setup();
			driver = new ChromeDriver();
		}

		/*
		 * ------ Driver Codes common for all browser setup -----
		 */

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(UtilityVariables.PAGELOAGD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityVariables.IMPLICIT_WAIT_TIMEOUTS, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public static void tearDown() {
		driver.quit();
	}

}