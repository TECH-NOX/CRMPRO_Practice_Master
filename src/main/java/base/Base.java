package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.PageObjectManager;
import utility.UtilityVariables;

public class Base {

	private static WebDriver driver = null;

	public static WebDriver setUp() {
		WebDriverManager.chromedriver().version("76.0.3809").setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(UtilityVariables.PAGELOAGD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityVariables.IMPLICIT_WAIT_TIMEOUTS, TimeUnit.SECONDS);
		driver.get(PageObjectManager.getPropObj().getProp().getProperty("url"));
		return driver;
	}

	public static void tearDown() {
		driver.quit();
	}

}