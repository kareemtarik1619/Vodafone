package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Payment_Options {

	WebDriver driver;

	public Payment_Options(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(className = "bankwire")
	public WebElement bank_btn;

	public void bank_btn_Assert() {
		WebElement bank_btn_Assert = bank_btn;
		Assert.assertEquals(bank_btn_Assert.isDisplayed(), true);
		Log.info("bank_btn asert Done");
	}

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	public WebElement Confirm_btn;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p/a")
	public WebElement back_btn;

}
