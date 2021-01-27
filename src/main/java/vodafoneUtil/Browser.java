package vodafoneUtil;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import io.qameta.allure.Attachment;

public class Browser {

	// public static WebDriver driver;
	WebDriver driver = null;

	@Parameters("browser")

	public WebDriver BrowserSitting(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Resources\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().setSize(new Dimension(1024, 768));

			Log.info("use firefox browser");

		} else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\Resources\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			driver.manage().window().setSize(new Dimension(1024, 768));
			Log.info("use IE browser");

		} else if (browser.equalsIgnoreCase("chrome")) {

			String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1024, 768));
			Log.info("use Chrome browser");

		}
		return driver;

	}

	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
		iHookCallBack.runTestMethod(iTestResult);
		if (iTestResult.getThrowable() != null) {
			this.saveScreenshot(iTestResult.getName(), driver);
		}
	}

}
