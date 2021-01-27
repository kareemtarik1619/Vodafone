package pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Order_History {

	WebDriver driver;

	public Order_History(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	public void message() {
		String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).getText();

		String[] trimmedText = text.split(":");

		for (String str : trimmedText) {
			System.out.println(str);
		}
	}

	@FindBy(partialLinkText = "BRDNKBDYT")
	public WebElement orders;

	public void orders_Assert() {
		WebElement orders_Assert = orders;
		Assert.assertEquals(orders_Assert.isDisplayed(), true);
		Log.info("orders founded asert Done");
	}

}
