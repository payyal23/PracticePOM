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

public class LoginPageTest extends TestBase {

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
		
	}

	@Test(priority = 2)
	public void verifyPageTitleTest() {
		String title = lp.getPagetitle();
		Assert.assertEquals(title, AppConstants.LoginPageTitle);

	}

	@Test(priority = 1)
	public void verifySgnuolinkTest() {

		Assert.assertTrue(lp.verifySignuplink());
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		
		hp = lp.doLogin(credentails);
		String username = hp.isloginnamecorrect();
		System.out.println("Login user as" + username);
		Assert.assertEquals(username, prop.getProperty("AccountName"));
	}
	// @DataProvider
//	public Object[][] getLoginInvalidDate() {
	// Object data[][] = {
	// {"test@test.com", "Pnt@123$"},
	// {"test@test.com", ""}

	// };
	// return data;
	// }

//	@Test(priority=4, dataProvider="getLoginInvalidDate")
	// public void validateErrorMessageTest(String emailID, String pass) {
	// lp.doLogin(emailID, pass);
	// Assert.assertTrue(lp.validateErrorMessage());
//	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
