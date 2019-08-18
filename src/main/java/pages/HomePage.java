package pages;

import org.openqa.selenium.By;

import base.Base;
import utility.ReusableMethods;

public class HomePage extends Base {

	By calendar_btn_xpath = By.xpath("//a[@title='Calendar']");
	By companies_btn_xpath = By.xpath("//a[@title='Companies']");
	By contacts_btn_xpath = By.xpath("//a[@title='Contacts']");
	By deals_btn_xpath = By.xpath("//a[@title='Deals']");
	By tasks_btn_xpath = By.xpath("//a[@title='Tasks']");
	By cases_btn_xpath = By.xpath("//a[@title='Cases']");
	By call_btn_xpath = By.xpath("//a[@title='Call']");
	By email_btn_xpath = By.xpath("//a[@title='Email']");
	By text_SMS_btn_xpath = By.xpath("//a[@title='Text/SMS']");
	By print_btn_xpath = By.xpath("//a[@title='Print']");
	By campaigns_btn_xpath = By.xpath("//a[@title='Campaigns']");
	By docs_btn_xpath = By.xpath("//a[@title='Docs']");
	By forms_btn_xpath = By.xpath("//a[@title='Forms']");
	By reports_btn_xpath = By.xpath("//a[@title='Reports']");
	By username_text_xpath = By.xpath("//td[@class='headertext' and contains(text(),'tech nox')]");

	public void navigateToCalendarPage() {
		ReusableMethods.switchtoFrame(driver, "mainpanel");
		driver.findElement(calendar_btn_xpath).click();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageUserName() {
		return driver.findElement(username_text_xpath).getText().trim();
	}
	
}