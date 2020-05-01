package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Payal
 * @param browserName
 * @return this method will return driver instance
 */
public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		Boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			if (isHeadless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (isHeadless) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}
		} else {
			System.out.println(browserName + "is not found , PLease pass the right browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

	public Properties init_prop() {
		prop = new Properties();
		try {
			fis = new FileInputStream(
					"C:\\Users\\Payal\\eclipse-workspace\\POMseries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not founded");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}
