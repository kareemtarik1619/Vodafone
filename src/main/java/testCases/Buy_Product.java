package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages_Package.Account_Page;
import pages_Package.Category;
import pages_Package.Checkout_Page;
import pages_Package.Home_Page;
import pages_Package.Order_History;
import pages_Package.Payment_Options;
import pages_Package.Products_Page;
import pages_Package.SingUp;
import vodafoneUtil.Browser;
import vodafoneUtil.Log;

public class Buy_Product {

	static WebDriver driver = null;

	Category Cat = null;
	Products_Page Pro = null;
	Checkout_Page checkout = null;
	Home_Page Home = null;
	Account_Page Acc = null;
	SingUp SU = null;
	Payment_Options options = null;
	Order_History orderhistory = null;

	@Parameters("browser")
	@BeforeTest
	public void Navegate(String browser) throws Exception {
		Browser br = new Browser();
		// br.BrowserSitting(browser);
		driver = br.BrowserSitting(browser);
		driver.navigate().to("http://automationpractice.com/index.php");

		Cat = PageFactory.initElements(driver, Category.class);
		Pro = PageFactory.initElements(driver, Products_Page.class);
		Home = PageFactory.initElements(driver, Home_Page.class);
		Acc = PageFactory.initElements(driver, Account_Page.class);
		SU = PageFactory.initElements(driver, SingUp.class);
		checkout = PageFactory.initElements(driver, Checkout_Page.class);
		options = PageFactory.initElements(driver, Payment_Options.class);
		orderhistory = PageFactory.initElements(driver, Order_History.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		Home.Login_Assert();
		Home.Login.click();
		SU.email_Assert();
		SU.email.sendKeys("Kareemtarik21q@gamil.com");
		SU.email.click();
		SU.passwd_Assert();
		SU.passwd.sendKeys("123456");
		SU.SubmitLogin_Assert();
		SU.SubmitLogin.click();

	}

	@Test(priority = 2, dependsOnMethods = { "Login" })
	public void Category_TestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Cat.Mouse_hover();
		Cat.Blouses.click();
		Pro.Add_Cart.click();

	}

	@Test(priority = 3, dependsOnMethods = { "Category_TestCase" })
	public void ResultedProduct_TestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		Pro.Proceed_to_checkout_Assert();
		Pro.Proceed_to_checkout.click();

	}

	@Test(priority = 4, dependsOnMethods = { "ResultedProduct_TestCase" })
	public void Checkout_TestCase() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout.Checkout_btn_Assert();
		checkout.Checkout_btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout.processAddress_Assert();
		checkout.processAddress.click();
		checkout.cgv_Checkbox.click();
		checkout.processCarrier_Assert();
		checkout.processCarrier.click();

	}

	@Test(priority = 5, dependsOnMethods = { "Checkout_TestCase" })
	public void SelectBank_TestCase() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		options.bank_btn_Assert();
		options.bank_btn.click();
		options.Confirm_btn.click();

	}

	@Test(priority = 6, dependsOnMethods = { "SelectBank_TestCase" })

	public void OrderVadlidation_TestCase() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orderhistory.message();
		options.back_btn.click();
		orderhistory.orders_Assert();
	}

	@AfterTest
	public void Drive_Close() {
		driver.close();
		Log.info("Driver Closed");

	}
}
