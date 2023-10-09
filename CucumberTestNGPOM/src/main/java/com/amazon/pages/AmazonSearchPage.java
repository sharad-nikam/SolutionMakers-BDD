package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPage {

	private final WebDriver driver;

	// 1. By Locators
	private final By searchBoxField = By.xpath("//input[@id='twotabsearchtextbox']");
	private final By searchButton = By.xpath("//input[@id='nav-search-submit-button']");
	private final By amazonProduct = By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]");
	private final By noResultsOnSearchMessage = By.xpath("//span[contains(text(),'Try checking your spelling or use more general terms')]");
	private final By suggestionsList = By.cssSelector(".left-pane-results-container");
	private final By firstSuggestion = By.xpath("//div[@aria-label='headphones']");


	// 2. Constructor of the page class
	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterSearchQuery(String searchQuery) {
      WebElement searchBox =  driver.findElement(searchBoxField); // Replace with actual ID
      searchBox.clear();  
      searchBox.sendKeys(searchQuery);
    }
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
     }
	
	public boolean verifyTheDisplayOfProductInSearchResults() {
		WebElement validProduct =  driver.findElement(amazonProduct);
		return (validProduct).isDisplayed();
	}
	
	public String retrieveNoProductSearchMessage() {
		WebElement resultMsg =  driver.findElement(noResultsOnSearchMessage);
		return resultMsg.getText();
	}
	
	public void refreshPage() {
        driver.navigate().refresh();
    }
	
	public boolean getSuggestionsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement suggList =  driver.findElement(suggestionsList);
		wait.until(ExpectedConditions.visibilityOf(suggList));
		return suggList.isDisplayed();
	}

	public String getFirstSuggestion() {
		WebElement fstSuggn =  driver.findElement(firstSuggestion);
		return fstSuggn.getText().toLowerCase();
	}
}
