package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.ElementActions;

public class HomePage {
	WebDriver driver;
	ElementActions elementActions;

	// Locators
	By HomePageHeader = By.xpath("//h1[text()='Service Dashboard']");
	By Loginuseravatar = By.xpath("//img[@class=\" nav-avatar \"] ");
	By LoginName = By.xpath("//div[@class='user-info-name']");
	By parentContacts = By.id("nav-primary-contacts-branch");
	By childContacts = By.id("nav-secondary-contacts");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}
	// Actions/methods

	public String isHomePageHeaderExist() {
		elementActions.waitforElementPresent(HomePageHeader);
		if (elementActions.isDisplayed(HomePageHeader)) {
			return elementActions.dogetText(HomePageHeader);
		}
		return null;

	}

	public String isloginnamecorrect() {
		elementActions.waitforElementPresent(Loginuseravatar);
		elementActions.doClick(Loginuseravatar);
		return elementActions.dogetText(LoginName);

	}

	public void clickonContacts() {		
		elementActions.waitforElementPresent(parentContacts);
		elementActions.doClick(parentContacts);
		elementActions.waitforElementPresent(childContacts);
		elementActions.doClick(childContacts);
		
	}
	
	public ContactPage goToContactsPage() {
		clickonContacts();
		return new ContactPage(driver);
	}

}
