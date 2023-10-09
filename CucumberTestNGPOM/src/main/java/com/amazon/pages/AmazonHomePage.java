package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.utils.ElementUtil;

public class AmazonHomePage {
	private final WebDriver driver;
	private ElementUtil eleUtil;


	// 1. By Locators
	private final By signInButton = By.xpath("//div[@class='nav-line-1-container']/span");
	private final By createAccountButton = By.xpath("//a[@class='a-button-text']");
	private final By accountNameElement = By.xpath("//span[@id='nav-link-accountList-nav-line-1' and @class='nav-line-1 nav-progressive-content']");

	// 2. Constructor of the page class
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions: features(Behaviors) of the page form of the methods
	public void open() {
		driver.get("https://www.amazon.in/");
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public boolean isAccountNameDisplayed(String expectedAccountName) {
        String actualAccountName = driver.findElement(accountNameElement).getText();
        return actualAccountName.equals(expectedAccountName);
    }
	// Page Chaining i.e. return/pass driver to the CreateAccountPage
	public CreateAccountPage createNewAccountForNewCustomer() {
		driver.findElement(createAccountButton).click();
		return new CreateAccountPage(driver);
	}

}
