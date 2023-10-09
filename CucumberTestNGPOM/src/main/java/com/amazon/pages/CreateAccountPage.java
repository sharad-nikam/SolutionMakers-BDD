package com.amazon.pages;

import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
	private final WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCreateAccountPageTitle() {
		return driver.getTitle();
	}
}
