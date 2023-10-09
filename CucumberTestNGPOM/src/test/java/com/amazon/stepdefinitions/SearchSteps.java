package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.driverfactory.DriverFactory;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.AmazonSearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	private AmazonHomePage amazonHomePage = new AmazonHomePage(DriverFactory.getDriver());
	private AmazonSearchPage amazonSearchPage = new AmazonSearchPage(DriverFactory.getDriver());

	
	@Given("User is on the Amazon homepage")
	public void user_is_on_the_amazon_homepage() {
		amazonHomePage.open();
	}

	@When("User enters {string} in the search bar")
	public void user_enters_in_the_search_bar(String string) {
		amazonSearchPage.enterSearchQuery(string);
	}

	@When("User clicks the search button")
	public void user_clicks_the_search_button() {
		amazonSearchPage.clickSearchButton();
	}

	@Then("User should see expected product is displayed")
	public void user_should_see_expected_product_is_displayed() {
		amazonSearchPage.verifyTheDisplayOfProductInSearchResults();
	}

	@Then("User should see error message indicating try to check again")
	public void user_should_see_error_message_indicating_try_to_check_again() {
		String expectedErrorMessage = "Try checking your spelling or use more general terms";
		String actualErrorMessage = amazonSearchPage.retrieveNoProductSearchMessage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@When("User leaves the search bar empty")
	public void user_leaves_the_search_bar_empty() {
	   amazonSearchPage.enterSearchQuery(" "); 
	}

	@Then("User should see that page gets refreshed and user have to provide search query")
	public void user_should_see_that_page_gets_refreshed_and_user_have_to_provide_search_query() {
		amazonSearchPage.refreshPage();
	}

	@When("User starts typing {string} in the search bar")
	public void user_starts_typing_in_the_search_bar(String string) {
		amazonSearchPage.enterSearchQuery(string);
	}

	@Then("User should see auto-suggestions related to {string}")
	public void user_should_see_auto_suggestions_related_to(String string) {
		Assert.assertTrue(amazonSearchPage.getSuggestionsList(),"Auto-suggestions not displayed.");
        String suggestionText = amazonSearchPage.getFirstSuggestion();
        Assert.assertTrue(suggestionText.contains(string.toLowerCase()), "First suggestion does not contain the search query.");
	
	}
}
