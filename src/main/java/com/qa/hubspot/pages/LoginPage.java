package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pojo.Credentails;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementActions;

public class LoginPage extends TestBase {
	WebDriver driver;
	ElementActions elementactions;

	// 1.initializing all locator or objects on the page.
	By login = By.xpath("//ul[@class='hsg-nav__group']//a[text()='Log in']");
	By username = By.id("username");
	By password = By.id("password");
	By signup = By.linkText("Sign up");
	By loginbtn = By.id("loginBtn");
	By ErrorMessage = By.cssSelector("h5.private-alert__title");

	// 2.Create constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(this.driver);

	}

    //3.Page methods
	public String getPagetitle() {
		return elementactions.dogetPagetitle(AppConstants.LoginPageTitle);
	}
	
	public boolean verifySignuplink() {
		elementactions.waitforElementPresent(signup);
		return elementactions.isDisplayed(signup);
	}
	public HomePage doLogin(Credentails credentails) {
		elementactions.waitforElementPresent(username);
		elementactions.doSendKeys(username, credentails.getEmailId());
		elementactions.getElement(username).clear();
		elementactions.doSendKeys(password, credentails.getPassword());
		elementactions.getElement(password).clear();
		elementactions.doClick(loginbtn);
		return new HomePage(driver);
		
	}
	public boolean validateErrorMessage() {
		return elementactions.isDisplayed(ErrorMessage);
	}

}
