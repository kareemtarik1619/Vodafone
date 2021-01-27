package pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Category {

	WebDriver driver;

	public Category(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(className = "sf-with-ul")
	public WebElement woman;

	public void woman_Assert() {
		WebElement woman_Assert = woman;
		Assert.assertEquals(woman_Assert.isDisplayed(), true);
		Log.info("woman Category asert Done");
	}

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	public WebElement Blouses;

	public void Mouse_hover() {
		Actions actions = new Actions(driver);
		WebElement menuOption = woman;
		actions.moveToElement(menuOption).perform();
		WebElement subMenuOption = Blouses;
		actions.moveToElement(subMenuOption).perform();
	}

}
