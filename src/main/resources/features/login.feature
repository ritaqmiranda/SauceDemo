Feature: As a user, I want to be able to log in to the Sauce Demo website

  Scenario: successful login
    Given the user is on the login page
    When they enter valid credentials (username and password)
    And they click on the Login button
    Then they should be redirected to the home page

  Scenario: unsuccessful login
    Given the user is on the login page
    When they enter invalid credentials (username and/or password)
    And they click on the "Login" button
    Then they should see an error indicating invalid credentials
    And remain on the login page
