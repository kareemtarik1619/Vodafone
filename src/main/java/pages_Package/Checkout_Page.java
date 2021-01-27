package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Checkout_Page {

	WebDriver driver;

	public Checkout_Page(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
	public WebElement Checkout_btn;

	public void Checkout_btn_Assert() {
		WebElement Checkout_btn_Assert = Checkout_btn;
		Assert.assertEquals(Checkout_btn_Assert.isDisplayed(), true);
		Log.info("Add_Cart asert Done");
	}

	@FindBy(name = "processAddress")
	public WebElement processAddress;

	public void processAddress_Assert() {
		WebElement processAddress_Assert = processAddress;
		Assert.assertEquals(processAddress_Assert.isDisplayed(), true);
		Log.info("Add_Cart asert Done");
	}

	@FindBy(id = "cgv")
	public WebElement cgv_Checkbox;

	@FindBy(name = "processCarrier")
	public WebElement processCarrier;

	public void processCarrier_Assert() {
		WebElement processCarrier_Assert = processCarrier;
		Assert.assertEquals(processCarrier_Assert.isDisplayed(), true);
		Log.info("Add_Cart asert Done");
	}

}
