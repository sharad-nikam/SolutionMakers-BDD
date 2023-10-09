package com.amazon.stepdefinitions;

import java.util.List;
import java.util.Map;

import com.amazon.driverfactory.DriverFactory;
import com.amazon.pages.AmazonProductsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {

	private AmazonProductsPage amazonProdPage = new AmazonProductsPage(DriverFactory.getDriver());

	@When("I search for {string}")
	public void searchForProduct(String searchQuery) {
		amazonProdPage.searchForProduct(searchQuery);
	}

	@And("I filter by {string}")
	public void filterByCategory(String category) {
		amazonProdPage.filterByCategory(category);
	}

	@And("I sort by {string}")
	public void sortByOption(String sortingOption) {
		amazonProdPage.sortByOption(sortingOption);
	}

	@Then("I should see a list of products")
	public void verifyProductList() {
		amazonProdPage.verifyProductList();
	}

	@And("I should be able to click on a product")
	public void clickOnProduct() {
		amazonProdPage.clickOnProduct();
	}

	@When("I search for products with the following criteria:")
	public void searchWithCriteria(DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : rows) {
			String searchQuery = row.get("search_query");
			String category = row.get("category");
			String sortingOption = row.get("sorting_option");
			searchWithCriteria(searchQuery, category, sortingOption);

		}
	}

	public void searchWithCriteria(String searchQuery, String category, String sortingOption) {
		amazonProdPage.searchForProduct(searchQuery);
		amazonProdPage.filterByCategory(category);
		amazonProdPage.sortByOption(sortingOption);

	}
}
