
package PageObject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {
	
	String LIST_ID = "com.flipkart.android:id/flyout_recycler_view";
	
	public HomeScreen(AndroidDriver driver) {
		
		super(driver);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public WebElement menu;
	
	@AndroidFindBy(xpath="///android.widget.TextView[@text='My Account']")
	public WebElement myAccount;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[6]/android.widget.RelativeLayout")
	public WebElement btnEnglish;
	
	@AndroidFindBy(id="com.flipkart.android:id/select_btn")
	public WebElement btnContinue;
	
	@AndroidFindBy(id="com.google.android.gms:id/cancel")
	public WebElement btnNone;
	
	public void btnNone() {
		btnNone.click();
	}
	
	
	public String getLIST_ID() {
		return LIST_ID;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getBtnEnglish() {
		return btnEnglish;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectPreferenes() {
		btnEnglish.click();
		btnContinue.click();
	}

	public HomeScreen clickMenu() {
		
		menu.click();
		return this;
	}
	
	public HomeScreen clickMyAccount(String text) {
		MobileElement element = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\""+LIST_ID+"\")).scrollIntoView("
                + "new UiSelector().text(\""+text+"\"));");  
		
		element.click();
		
		return this;
	}

}
