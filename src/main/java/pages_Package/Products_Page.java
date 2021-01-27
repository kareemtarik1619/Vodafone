package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Products_Page {
	WebDriver driver;

	public Products_Page(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
	public WebElement Add_Cart;

	public void Add_Cart_Assert() {
		WebElement Add_Cart_Assert = Add_Cart;
		Assert.assertEquals(Add_Cart_Assert.isDisplayed(), true);
		Log.info("Add_Cart asert Done");
	}

	@FindBy(partialLinkText = "Proceed to checkout")
	public WebElement Proceed_to_checkout;

	public void Proceed_to_checkout_Assert() {
		WebElement Proceed_to_checkout_Assert = Proceed_to_checkout;
		Assert.assertEquals(Proceed_to_checkout_Assert.isDisplayed(), true);
		Log.info("Proceed_to_checkout asert Done");
	}

	public static void popup_mang(WebDriver driver) {

		String parentWindow = driver.getWindowHandle();

		for (String childWindow : driver.getWindowHandles()) {

			driver.switchTo().window(childWindow);
			Log.info("Switch to child window");
			System.out.println("Switch to child window");

		}

	}

}
