package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EarBuds extends BaseScreen{
	public EarBuds(AndroidDriver driver) {
		super(driver);
		
	}
	
    @AndroidFindBy(xpath="//android.widget.TextView[contains(text, 'Bose sport ear buds')]")
	public WebElement txtBoseSportEarBuds;
	
	
	public EarBuds addBoseSportEarBuds() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		txtBoseSportEarBuds.click();
		return this;
	}
}
