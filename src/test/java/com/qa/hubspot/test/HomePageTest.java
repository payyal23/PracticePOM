package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pojo.Credentails;
import com.qa.hubspot.util.AppConstants;

public class HomePageTest {
	TestBase testpage;
	Properties prop;
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	Credentails credentails;

	@BeforeTest
	public void setup() {
		testpage = new TestBase();
		prop = testpage.init_prop();
		driver = testpage.init_driver(prop);
		lp = new LoginPage(driver);
		credentails = new Credentails(prop.getProperty("usrname"), prop.getProperty("password"));
		hp = lp.doLogin(credentails);

	}
	@Test(priority=1)
	public void isHomePageHeaderExistTest() {
		String Headervalue = hp.isHomePageHeaderExist();
		Assert.assertEquals(Headervalue, AppConstants.HomePageHeader);
		
	}
	@Test(priority=2)
	public void isloginnamecorrectTest() {
		String username= hp.isloginnamecorrect();
		System.out.println("Login user as"+username );
		Assert.assertEquals(username, prop.getProperty("AccountName"));		
	}
	@Test(priority=4)
	public void clickonContactsTest() {
				hp.clickonContacts();
	}
	
	
	
	//@AfterTest
	//public void tearDown() {
		//driver.quit();
	//}
	

}
