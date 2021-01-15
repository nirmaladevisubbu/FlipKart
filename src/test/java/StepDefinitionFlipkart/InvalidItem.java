package StepDefinitionFlipkart;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.EarBuds;
import PageObject.HomeScreen;
import PageObject.Item;
import PageObject.LoginScreen;
import PageObject.MyAccountScreen;
import PageObject.ResultNotFound;
import PageObject.SearchScreen;


public class InvalidItem extends BaseClass {
	   
		@Test
		public void BeginTest() throws IOException {
			
			FileReader f = new FileReader("src\\test\\resources\\Utils\\data.properties");
			Properties prop = new Properties();
			prop.load(f);
			
			LoginScreen loginScreen = new LoginScreen(driver);
			HomeScreen homeScreen = new HomeScreen(driver);
			MyAccountScreen myaccountScreen = new MyAccountScreen(driver);
			SearchScreen searchScreen = new SearchScreen(driver);
			EarBuds res = new EarBuds(driver);
			Item item = new Item(driver);
			ResultNotFound noResults = new ResultNotFound(driver);
			
			loginScreen.closeScreen();
			homeScreen.clickMenu();
			homeScreen.clickMyAccount(prop.getProperty("myAccountText"));
			loginScreen.enterMobileNo(prop.getProperty("mobileNo"));
			loginScreen.enterPassword(prop.getProperty("password"));
			loginScreen.clickSignIn();
			
			
			Assert.assertEquals(myaccountScreen.getTitle(), prop.getProperty("myAccountText"));
			
			myaccountScreen.clickonSearch();
			
			searchScreen.enterSearchCategory(prop.getProperty("invalidSearchTerm"));		
			
			noResults.getErrorText("Sorry, no results found!");
			
			noResults.pressBackBtn();
			
			searchScreen.pressBackBtn();
			
			homeScreen.clickMenu();
			
			homeScreen.clickMyAccount(prop.getProperty("myAccountText"));
			
			myaccountScreen.pressLogout(prop.getProperty("indexLogout"));
			
	
			
		   
			
		}
	}
