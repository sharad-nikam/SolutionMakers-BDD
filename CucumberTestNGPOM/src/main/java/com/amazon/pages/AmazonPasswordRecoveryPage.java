package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPasswordRecoveryPage {
	private final WebDriver driver;

	public AmazonPasswordRecoveryPage(WebDriver driver) {
		this.driver = driver;
	}

	private final By confirmationMessage = By
			.xpath("//p[contains(text(),'Enter the email address or mobile phone number ass')]");

	public String getPwdrecoveryPageTitle() {
		return driver.getTitle();
	}
	
	public String getcnfmMessageForRecovery() {
		WebElement cnfmElement = driver.findElement(confirmationMessage);
		return cnfmElement.getText();
	}
	
	
}
