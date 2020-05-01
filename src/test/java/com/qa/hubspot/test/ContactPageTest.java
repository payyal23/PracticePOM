package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pages.ContactPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pojo.Contacts;
import com.qa.hubspot.pojo.Credentails;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactPageTest extends TestBase {

	WebDriver driver;
	ContactPage cp;
	LoginPage lp;
	HomePage hp;
	TestBase testbase;
	Properties prop;
	Credentails credentails;
	Contacts contacts;

	@BeforeTest
	public void setup() {
		testbase = new TestBase();
		prop = testbase.init_prop();
		driver = testbase.init_driver(prop);
		lp= new LoginPage(driver);		
		credentails = new Credentails(prop.getProperty("usrname"), prop.getProperty("password"));
		hp = lp.doLogin(credentails);
		cp = hp.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifypageTitleTest() {
		String contactTitle = cp.verifypageTitle();
		Assert.assertEquals(contactTitle, AppConstants.ContactsPageTitle);
	}

	@Test(priority = 2)
	public void verifypresenceofImportBtn() {
		Assert.assertTrue(cp.presenceofImportBtn());
	}
	
	@DataProvider
	public Object[][] getContactsData() {
	Object	data[][] = ExcelUtil.getTestData(AppConstants.SheetPageTitle);
		return data;
		
	}
	@Test(priority = 3 , dataProvider = "getContactsData")
	public void createNewContacts(String email , String firstName , String lastName , String  jobTitle) {
		contacts = new Contacts(email, firstName, lastName, jobTitle);
		cp.createNewContact(contacts);
		
	}

	/*
	 * @Test(priority = 3) public void createNewContactsTest() { String email =
	 * cp.createNewContact(Randomutil.Useremail(),Randomutil.firstName(),Randomutil.
	 * LastName(),Randomutil.jobTitle());;
	 * 
	 * System.out.println("Email is : "+email.toLowerCase());
	 * Assert.assertEquals(email.toLowerCase(), cp.contactcreated());
	 * 
	 * 
	 * }
	 */
	
	@Test(priority=4)
	public void contactcreatedTest() {
		System.out.println(cp.contactcreated());
		
		
	}
}
