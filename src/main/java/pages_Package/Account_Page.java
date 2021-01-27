package pages_Package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import vodafoneUtil.Log;

public class Account_Page {
	WebDriver driver;

	public Account_Page(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
	public WebElement Gender;

	public void Gender_Assert() {
		WebElement Gender_Assert = Gender;
		Assert.assertEquals(Gender_Assert.isDisplayed(), true);
		Log.info("gender asert Done");
	}

	@FindBy(id = "customer_firstname")
	public WebElement FName;

	public void FName_Assert() {
		WebElement FName_Assert = FName;
		Assert.assertEquals(FName_Assert.isDisplayed(), true);
		Log.info("FName TextBox found");

	}

	@FindBy(id = "customer_lastname")
	public WebElement LName;

	@FindBy(id = "email")
	public WebElement email;

	public void LName_Assert() {
		WebElement LName_Assert = LName;
		Assert.assertEquals(LName_Assert.isDisplayed(), true);
		Log.info("LName TextBox found");

	}

	@FindBy(id = "passwd")
	public WebElement Password;

	public void Password_Assert() {
		WebElement Password_Assert = Password;
		Assert.assertEquals(Password_Assert.isDisplayed(), true);
		Log.info("Password TextBox found");

	}

	@FindBy(name = "days")
	public WebElement days;

	public void days_Select() {
		Select Days_dropdown = new Select(days);
		assertFalse(Days_dropdown.isMultiple());
		Days_dropdown.selectByIndex(17);
		assertEquals("17  ", Days_dropdown.getFirstSelectedOption().getText());

	}

	@FindBy(name = "months")
	public WebElement months;

	public void months_Select() {
		Select months_dropdown = new Select(months);
		assertFalse(months_dropdown.isMultiple());
		months_dropdown.selectByIndex(10);
		assertEquals("October ", months_dropdown.getFirstSelectedOption().getText());

	}

	@FindBy(name = "years")
	public WebElement years;

	public void years_Select() {
		Select years_dropdown = new Select(years);
		assertFalse(years_dropdown.isMultiple());
		years_dropdown.selectByIndex(29);
		assertEquals("1992  ", years_dropdown.getFirstSelectedOption().getText());

	}

	@FindBy(id = "newsletter")
	public WebElement newsletter;

	public void newsletter_Assert() {
		WebElement newsletter_Assert = Password;
		Assert.assertEquals(newsletter_Assert.isDisplayed(), true);
		Log.info("newsletter Checkbox found");

	}

	@FindBy(id = "firstname")
	public WebElement FriName;

	public void FriName_Assert() {
		WebElement FriName_Assert = FriName;
		Assert.assertEquals(FriName_Assert.isDisplayed(), true);
		Log.info("First customer Name TextBox found");

	}

	@FindBy(id = "lastname")
	public WebElement lasName;

	public void LasName_Assert() {
		WebElement LasName_Assert = lasName;
		Assert.assertEquals(LasName_Assert.isDisplayed(), true);
		Log.info("Last Customer Name TextBox found");

	}

	@FindBy(id = "company")
	public WebElement company;

	public void company_Assert() {
		WebElement company_Assert = company;
		Assert.assertEquals(company_Assert.isDisplayed(), true);
		Log.info("Company Name TextBox found");

	}

	@FindBy(id = "address1")
	public WebElement address1;

	public void address1_Assert() {
		WebElement address1_Assert = address1;
		Assert.assertEquals(address1_Assert.isDisplayed(), true);
		Log.info("Address TextBox found");

	}

	@FindBy(id = "city")
	public WebElement city;

	public void city_Assert() {
		WebElement city_Assert = city;
		Assert.assertEquals(city_Assert.isDisplayed(), true);
		Log.info("city TextBox found");

	}

	@FindBy(name = "id_state")
	public WebElement id_state;

	public void id_state_Select() {
		Select id_state_dropdown = new Select(id_state);
		assertFalse(id_state_dropdown.isMultiple());
		id_state_dropdown.selectByIndex(5);

	}

	@FindBy(id = "postcode")
	public WebElement postcode;

	public void postcode_Assert() {
		WebElement postcode_Assert = city;
		Assert.assertEquals(postcode_Assert.isDisplayed(), true);
		Log.info("postcode TextBox found");

	}

	@FindBy(name = "id_country")
	public WebElement id_country;

	public void id_country_Select() {
		Select id_country_dropdown = new Select(id_country);
		assertFalse(id_country_dropdown.isMultiple());
		id_country_dropdown.selectByIndex(1);

	}

	@FindBy(id = "phone_mobile")
	public WebElement phone_mobile;

	public void phone_mobile_Assert() {
		WebElement phone_mobile_Assert = phone_mobile;
		Assert.assertEquals(phone_mobile_Assert.isDisplayed(), true);
		Log.info("phone_mobile TextBox found");

	}

	@FindBy(id = "alias")
	public WebElement alias;

	public void alias_Assert() {
		WebElement alias_Assert = alias;
		Assert.assertEquals(alias_Assert.isDisplayed(), true);
		Log.info("aliasTextBox found");
	}

	@FindBy(id = "submitAccount")
	public WebElement submitAccount;

	public void Data() throws Exception {

	}

}
