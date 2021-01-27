package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class SingUp {
	
		WebDriver driver;
		public SingUp(WebDriver driver)
		{
			this.driver = driver;
			//PageFactory.initElements(driver, this);
		}
	
	@FindBy(id = "email")
	public WebElement email;
	
	
	public void email_Assert() {
		WebElement email_Assert=email;
		Assert.assertEquals(email_Assert.isDisplayed(), true);
		Log.info("email asert Done");
		}

	
	@FindBy(id = "passwd")
	public WebElement passwd;
	
	
	public void passwd_Assert() {
		WebElement passwd_Assert=passwd;
		Assert.assertEquals(passwd_Assert.isDisplayed(), true);
		Log.info("email asert Done");
		}
	
	
	
	@FindBy(id = "SubmitLogin")
	public WebElement SubmitLogin;
	
	
	public void SubmitLogin_Assert() {
		WebElement SubmitLogin_Assert=SubmitLogin;
		Assert.assertEquals(SubmitLogin_Assert.isDisplayed(), true);
		Log.info("email asert Done");
		}

	
	

}
