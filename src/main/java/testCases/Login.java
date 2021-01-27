package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IHookable;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages_Package.Account_Page;
import pages_Package.Home_Page;
import pages_Package.SingUp;
import vodafoneUtil.Browser;

public class Login extends Browser implements IHookable {

	static WebDriver driver = null;
	Home_Page Home = null;
	Account_Page Acc = null;
	SingUp SU = null;

	@Parameters("browser")
	@BeforeTest
	public void openURL(String browser) throws Exception {
		Browser br = new Browser();
		// br.BrowserSitting(browser);
		driver = br.BrowserSitting(browser);
		driver.navigate().to("http://automationpractice.com/index.php");
		Home = PageFactory.initElements(driver, Home_Page.class);
		Acc = PageFactory.initElements(driver, Account_Page.class);
		SU = PageFactory.initElements(driver, SingUp.class);
	}

	@Test
	public void Login_TestCase() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home.Login_Assert();
		Home.Login.click();
		SU.email_Assert();
		SU.email.sendKeys("Kareemtarik1619@gmail.com");
		SU.email.click();
		SU.passwd_Assert();
		SU.passwd.sendKeys("123456");
		SU.SubmitLogin_Assert();
		SU.SubmitLogin.click();

	}
}
