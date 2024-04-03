This repository contains automation test scripts for the Sauce Demo website using Cucumber and Selenium WebDriver.

Resources: 

    Chromedriver
    
Features: 

    1. checkout: as a user after log in, I can add products to my basket and checkout.
    
    2. login: successful and unsuccessful

Project Structure

    CheckoutSteps: Contains Cucumber step definitions for the checkout process.
    
    LoginSteps: Contains Cucumber step definitions for the login process.
    
    Page: Abstract class providing basic functionalities to all page objects.

    LoginPage: Page object representing the login page.
    
    CheckoutCart: Page object representing the checkout cart page.
    
    HomePage: Page object representing the home page.
    
    TestRunner: Cucumber test runner class.


After running the tests, detailed reports will be generated in the target directory:

    HTML report: target/testReport.html
    
    JSON report: target/jsonReport.json
