package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataDriven.ExcelUtils;
import pages_Package.Account_Page;
import pages_Package.Home_Page;
import vodafoneUtil.Browser;
import vodafoneUtil.Constant;
import vodafoneUtil.Log;
import vodafoneUtil.Screenshoots;

public class CreateAccount {

	static WebDriver driver = null;
	Home_Page Home = null;
	Account_Page Acc = null;
	public static WebElement element = null;

	@Parameters("browser")
	@BeforeTest

	public void BrowserNavigation(String browser) throws Exception {
		Browser br = new Browser();
		// br.BrowserSitting(browser);
		driver = br.BrowserSitting(browser);

		driver.navigate().to("http://automationpractice.com/index.php");
		Home = PageFactory.initElements(driver, Home_Page.class);
		Acc = PageFactory.initElements(driver, Account_Page.class);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		DOMConfigurator.configure("Log4j.xml");
		Log.startTestCase("TestCase1");
	}

	@Test
	public void Authenticate_TestCase() throws Exception {
		try {

			String sUserName = ExcelUtils.getCellData(1, 1);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Home.Login_Assert();
			Home.Login.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Home.Email.sendKeys(sUserName);
			Home.Email.sendKeys(Keys.ENTER);
			String bodyText = driver.findElement(By.tagName("body")).getText();
			Assert.assertFalse(bodyText.contains("An account using this email address has already been registered"));

		} catch (NoSuchElementException e) {

			// creenshoots.takeScreenshotElement(element);
			Screenshoots.takeScreenShotMethod();
			driver.close();

		}

	}

	@Test(dependsOnMethods = { "Authenticate_TestCase" })
	public void CreatAccount_TestCase() throws Exception {

		try {
			Acc.Gender_Assert();
			Acc.Gender.click();

			Acc.FName_Assert();
			Acc.FName.sendKeys("Kareem");

			Acc.LName_Assert();
			Acc.LName.sendKeys("Tarek");

			Acc.email.click();
			Acc.Password_Assert();
			Acc.Password.sendKeys("123456");

			Acc.days_Select();
			Acc.months_Select();
			Acc.years_Select();
			Acc.newsletter_Assert();
			Acc.newsletter.click();

			Acc.FriName_Assert();
			Acc.FriName.click();
			Acc.LasName_Assert();
			Acc.lasName.click();
			Acc.company_Assert();
			Acc.company_Assert();
			Acc.company.sendKeys("Vodafone");

			Acc.address1_Assert();
			Acc.address1.sendKeys("10");
			Acc.city_Assert();
			Acc.city.sendKeys("Cairo");
			Acc.id_state_Select();
			Acc.postcode_Assert();
			Acc.postcode.sendKeys("55555");
			Acc.id_country_Select();
			Acc.phone_mobile_Assert();
			Acc.phone_mobile.sendKeys("01234567891");
			Acc.alias_Assert();
			Acc.alias.sendKeys("street 10");
			Acc.id_country_Select();
			Acc.submitAccount.click();
		} catch (NoSuchElementException e) {

			Screenshoots.takeScreenshotElement(element);
			Screenshoots.takeScreenShotMethod();
			driver.close();

		}

	}

	@AfterTest
	public void Drive_Close() {
		driver.close();
		Log.info("Driver Closed");

	}

}