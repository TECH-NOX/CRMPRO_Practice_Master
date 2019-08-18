package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.Base;
import utility.ReusableMethods;

public class LoginPage extends Base {

	public LoginPage() {
		super();
	}

	By userName_textInput_name = By.name("username");
	By password_textInput_name = By.name("password");
	By login_button_xpath = By.xpath("//input[@value='Login']");

	public void login() {
		driver.findElement(userName_textInput_name).clear();
		driver.findElement(userName_textInput_name).sendKeys(prop.getProperty("username"));
		driver.findElement(password_textInput_name).clear();
		driver.findElement(password_textInput_name).sendKeys(prop.getProperty("password"));
		ReusableMethods.javaScriptExecutorClick(driver, driver.findElement(login_button_xpath));
	}
	
	public void login(String uname, String pWord) {
		driver.findElement(userName_textInput_name).clear();
		driver.findElement(userName_textInput_name).sendKeys(uname);
		driver.findElement(password_textInput_name).clear();
		driver.findElement(password_textInput_name).sendKeys(pWord);
		ReusableMethods.javaScriptExecutorClick(driver, driver.findElement(login_button_xpath));
	}

}
