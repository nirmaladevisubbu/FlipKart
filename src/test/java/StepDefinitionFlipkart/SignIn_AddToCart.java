package StepDefinitionFlipkart;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.EarBuds;
import PageObject.HomeScreen;
import PageObject.Item;
import PageObject.LoginScreen;
import PageObject.MyAccountScreen;
import PageObject.SearchScreen;


public class SignIn_AddToCart extends BaseClass{
	
	
	@Test
	public void BeginTest() throws IOException {
		
		FileReader file = new FileReader("src\\test\\resources\\Utils\\data.properties");
		Properties properties = new Properties();
		properties.load(file);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginScreen loginScreen = new LoginScreen(driver);
		HomeScreen homeScreen = new HomeScreen(driver);
		MyAccountScreen myaccountScreen = new MyAccountScreen(driver);
		SearchScreen searchScreen = new SearchScreen(driver);
		EarBuds res = new EarBuds(driver);
		Item item = new Item(driver);
		
	
		homeScreen.selectPreferenes();
		homeScreen.btnNone();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		loginScreen.enterMobileNo(properties.getProperty("mobileNo"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginScreen.enterPassword(properties.getProperty("password"));
		loginScreen.clickSignIn();	
		loginScreen.closeScreen();
		homeScreen.clickMenu();
		homeScreen.clickMyAccount(properties.getProperty("myAccount"));
		
		
		
		Assert.assertEquals(myaccountScreen.getTitle(), properties.getProperty("myAccount"));
		
		myaccountScreen.clickonSearch();
				
		searchScreen.enterSearchCategory(properties.getProperty("SearchProduct"));
		
		searchScreen.selectEarBuds();
				
		res.addBoseSportEarBuds();
		item.addToCart();
		
		
		
	   
		
	}

}
