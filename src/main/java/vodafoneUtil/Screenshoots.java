package vodafoneUtil;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class Screenshoots {

	WebDriver driver;

	public static void takeScreenShotMethod() {
		try {
			Thread.sleep(10000);
			long id = Thread.currentThread().getId();

			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

			ImageIO.write(image, "jpg", new File("./target/" + id + "screenshot.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshotElement(WebElement element) throws IOException {
		WrapsDriver wrapsDriver = (WrapsDriver) element;
		File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
		Point location = element.getLocation();
		BufferedImage bufferedImage = ImageIO.read(screenshot);
		BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
		ImageIO.write(destImage, "png", screenshot);
		File file = new File("C:\\Users\\ktarek\\eclipse-workspace\\Vodafone\\target\\elementscreenshot.jpg");
		FileUtils.copyFile(screenshot, file);
	}
}
