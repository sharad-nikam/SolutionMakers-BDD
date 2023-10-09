Feature: Login to Amazon Website
    As a user
    I want to be able to log into the Amazon website
    So that I can access my account and perform actions
@sanity
  Scenario: Successful login with valid credentials
    Given the Amazon homepage is open
    When I enter my valid username "supriyabyadav.june22@gmail.com" and valid password "SuPriya@1523"
    And I click on the "Sign In" button
    Then I should be logged in to my Amazon account
    And I should see my account name displayed
@sanity
  Scenario: Login with invalid credentials
    Given the Amazon homepage is open
    When I enter my invalid username "supriyabyadav.june@gmail.com"
    And I click on the "Sign In" continue button
    Then I should see an error message indicating invalid credentials

  Scenario: Login with empty fields
    Given the Amazon homepage is open
    When I leave the username and password fields empty
    And I click on the "Sign In" continue button
    Then I should see error messages indicating required fields

  Scenario: Forgot password link
    Given the Amazon homepage is open and I click on sign in button
    When I click on the "Forgot your password" link with username "supriyabyadav.june22@gmail.com"
    Then I should be redirected to the password recovery page
    And I should see or verify the title of password recovery page

  Scenario: Create new account link
    Given the Amazon homepage is open
    When I click on the "Create your Amazon account" button on homepage
    Then I should be redirected to the account creation page
