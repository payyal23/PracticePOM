package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pojo.Contacts;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class ContactPage extends TestBase{

	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil jsUtil;
	By contactPageTitle = By.xpath("//i18n-string[text()='Contacts']");	
	By createcontact = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createcontactformbutton = By.xpath("//li[@class='uiListItem private-list__item p-bottom-1']/button[1]");
	By importbtn = By.xpath("//span[text()='Import']");
	By contactsnavigate = By.xpath("(//i18n-string[text()='Contacts'])[position()=2]");
	By contactscreated = By.xpath("//tbody[@class='Tbody-lhne0s-0 hqlPlm']/tr[1]/td[3]/a");


	// constructor
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	public String verifypageTitle() {
		return elementActions.dogetPagetitle(AppConstants.ContactsPageTitle);
		
	}

	public boolean presenceofImportBtn() {
		elementActions.waitforElementPresent(importbtn);
		return elementActions.isDisplayed(importbtn);
	}

	public String createNewContact(Contacts contacts) {
		
		elementActions.waitforElementPresent(createcontact);
		elementActions.doClick(createcontact);
		elementActions.waitforElementPresent(this.email);
		elementActions.doSendKeys(this.email, contacts.getEmail());
		elementActions.doSendKeys(this.firstName, contacts.getFirstName());
		elementActions.doSendKeys(this.lastName, contacts.getLastName());
		elementActions.waitforElementPresent(this.jobTitle);
		elementActions.doSendKeys(this.jobTitle, contacts.getJobTitle());
		elementActions.waitforElementPresent(createcontactformbutton);
		elementActions.doClick(createcontactformbutton);
		//jsUtil.clickElementByJS(elementActions.getElement(createcontactformbutton));	
		elementActions.waitforElementPresent(contactsnavigate);
		elementActions.doClick(contactsnavigate);	
		return contacts.getEmail();
		
	}
	
	public String contactcreated() {			
		//createNewContact(String email , String firstName , String lastName , String  jobTitle);
		elementActions.waitforElementPresent(contactscreated);
		String emailtext = elementActions.dogetText(contactscreated);
		return emailtext;
		
		
		
	}

}
