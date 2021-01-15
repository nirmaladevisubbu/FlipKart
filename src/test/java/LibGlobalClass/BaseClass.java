package LibGlobalClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static AndroidDriver<MobileElement> driver;
	static URL url;

	public static AndroidDriver<MobileElement> lauchBrowser(String appPackage, String appActivity)
			throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OPPO A7");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersione", "8.1.0");
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);

		url = new URL(" http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("AirCanada  App launched");
		return driver;
	}

	public static void fill(MobileElement mobileElement, String text) {
		mobileElement.sendKeys(text);

	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void btnClick(MobileElement element) {
		element.click();
	}

	public static String takeText(MobileElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public static void performScroll(List<MobileElement> element) {
		while (element.size() == 0) {
			System.out.println("enter");
			Dimension size = driver.manage().window().getSize();
			// Dimension dim = window.getSize();
			Double startHeight = size.getHeight() * 0.5;

			int startPlace = startHeight.intValue();

			Dimension size1 = driver.manage().window().getSize();
			Double endHeight = size1.getHeight() * 0.2;

			int endPlace = endHeight.intValue();

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(0, startPlace)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(0, endPlace)).release().perform();

		}

	}

}
