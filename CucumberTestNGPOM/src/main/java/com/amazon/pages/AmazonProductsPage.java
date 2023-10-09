package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductsPage {
	
	private final WebDriver driver;

	private final By searchBoxField = By.xpath("//input[@id='twotabsearchtextbox']");
	private final By searchButton = By.xpath("//input[@id='nav-search-submit-button']");
    private By categoryDropdown = By.cssSelector("select[title='Search in']");
    private By sortDropdown = By.cssSelector("select[name='s']");
    private By productItems = By.cssSelector("//body/div[@aria-hidden='false']/div[2]");

	
	// 2. Constructor of the page class
		public AmazonProductsPage(WebDriver driver) {
			this.driver = driver;
		}
		
		
		public void searchForProduct(String searchQuery) {
			WebElement searchBox =  driver.findElement(searchBoxField);  
		      searchBox.clear();  
		      searchBox.sendKeys(searchQuery);
				driver.findElement(searchButton).click();
	    }
	    
	    public void filterByCategory(String category) {
	        driver.findElement(categoryDropdown).sendKeys(category);
	    }
	    
	    public void sortByOption(String option) {
	        driver.findElement(sortDropdown).sendKeys(option);
	    }
	    
	    public void verifyProductList() {
	        
	    }
	    
	    public void clickOnProduct() {
	         
	    }

}
