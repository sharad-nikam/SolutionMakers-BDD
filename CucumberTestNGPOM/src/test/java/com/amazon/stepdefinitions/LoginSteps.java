package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.driverfactory.DriverFactory;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.AmazonLoginPage;
import com.amazon.pages.AmazonPasswordRecoveryPage;
import com.amazon.pages.CreateAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private AmazonHomePage amazonHomePage = new AmazonHomePage(DriverFactory.getDriver());
	private AmazonLoginPage amazonLoginPage = new AmazonLoginPage(DriverFactory.getDriver());
	private AmazonPasswordRecoveryPage amazonPwdRcPage = new AmazonPasswordRecoveryPage(DriverFactory.getDriver());
	private CreateAccountPage crAccPage = new CreateAccountPage(DriverFactory.getDriver());

	@Given("the Amazon homepage is open")
	public void the_amazon_homepage_is_open() {
		amazonHomePage.open();
	}

	@When("I enter my valid username {string} and valid password {string}")
	public void i_enter_my_valid_username_and_valid_password(String username, String password) {
		amazonHomePage.clickSignInButton();
		amazonLoginPage.enterUsername(username);
		amazonLoginPage.clickSignInContinueButton();
		amazonLoginPage.enterPassword(password);
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
		amazonLoginPage.clickSignInSubmitButton();

	}

	@Then("I should be logged in to my Amazon account")
	public void i_should_be_logged_in_to_my_amazon_account() {
		String expectedTitleOfHomepage = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitleOfHmPage = amazonHomePage.getHomePageTitle();
		Assert.assertEquals(expectedTitleOfHomepage, actualTitleOfHmPage);
	}

	@Then("I should see my account name displayed")
	public void i_should_see_my_account_name_displayed() {
		String expectedAccountName = "Hello, Supriya";
		Assert.assertTrue(amazonHomePage.isAccountNameDisplayed(expectedAccountName),
				"Expected: Account name should be displayed");
	}

	@When("I enter my invalid username {string}")
	public void i_enter_my_invalid_username(String invalidusername) {
		amazonHomePage.clickSignInButton();
		amazonLoginPage.enterUsername(invalidusername);
		amazonLoginPage.clickSignInContinueButton();

	}

	@When("I click on the {string} continue button")
	public void i_click_on_the_continue_button(String string) {
		amazonLoginPage.clickSignInContinueButton();

	}

	@Then("I should see an error message indicating invalid credentials")
	public void i_should_see_an_error_message_indicating_invalid_credentials() {
		String expectedErrorMessage = "We cannot find an account with that email address";
		String actualErrorMessage = amazonLoginPage.getErrorMessageForInvalid();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@When("I leave the username and password fields empty")
	public void i_leave_the_username_and_password_fields_empty() {
		amazonHomePage.clickSignInButton();
		amazonLoginPage.clickSignInContinueButton();
	}

	@Then("I should see error messages indicating required fields")
	public void i_should_see_error_messages_indicating_required_fields() {
		String expectedErrorMessage = "Enter your email or mobile phone number";
		String actualErrorMessage = amazonLoginPage.getErrorMessageForEmpty();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

	}

	@Given("the Amazon homepage is open and I click on sign in button")
	public void the_amazon_homepage_is_open_and_I_click_on_sign_in_button() {
		amazonHomePage.open();
		amazonHomePage.clickSignInButton();

	}

	@When("I click on the {string} link with username {string}")
	public void i_click_on_the_link_with_username(String forgotPwdLink, String username) {
		amazonLoginPage.enterUsername(username);
		amazonLoginPage.clickSignInContinueButton();
		amazonLoginPage.clickForgotPasswordLink(forgotPwdLink);
	}

	@Then("I should be redirected to the password recovery page")
	public void i_should_be_redirected_to_the_password_recovery_page() {
		String expectedCnfmMsg = "Enter the email address or mobile phone number associated with your Amazon account.";
		String actualCnfmMsg = amazonPwdRcPage.getcnfmMessageForRecovery();
		Assert.assertEquals(expectedCnfmMsg, actualCnfmMsg);

	}

	@Then("I should see or verify the title of password recovery page")
	public void i_should_see_or_verify_the_title_of_password_recovery_page() {
		String expectedTitleOfPwdRecoveryPage = "Amazon Password Assistance";
		String actualTitleOfPwdRecoveryPage = amazonPwdRcPage.getPwdrecoveryPageTitle();
		Assert.assertEquals(expectedTitleOfPwdRecoveryPage, actualTitleOfPwdRecoveryPage);
	}

	@When("I click on the {string} button on homepage")
	public void i_click_on_the_button_on_homepage(String string) {
		amazonHomePage.clickSignInButton();
		amazonHomePage.createNewAccountForNewCustomer();
	}

	@Then("I should be redirected to the account creation page")
	public void i_should_be_redirected_to_the_account_creation_page() {
		String expectedTitleCreateAccountPage = "Amazon Registration";
		String actualTitleOfCreateAccountPage = crAccPage.getCreateAccountPageTitle();
		Assert.assertEquals(expectedTitleCreateAccountPage, actualTitleOfCreateAccountPage);
	}
}
