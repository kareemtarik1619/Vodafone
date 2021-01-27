package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Home_Page {

	WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(className = "login")
	public WebElement Login;

	public void Login_Assert() {
		WebElement Login_asert = Login;
		Assert.assertEquals(Login_asert.isDisplayed(), true);
		Log.info("Found login btn");
	}

	@FindBy(id = "email_create")
	public WebElement Email;

	public void Email_Assert() {
		WebElement Login_asert = Email;
		Assert.assertEquals(Login_asert.isDisplayed(), true);
		Log.info("Found Email tBox");
	}

}
