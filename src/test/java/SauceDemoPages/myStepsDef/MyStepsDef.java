package SauceDemoPages.myStepsDef;

import SauceDemoPages.HomePage;
import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.hamcrest.Matchers.is;

public class MyStepsDef {

    private static final String DRIVER_LOCATION = "src/main/resources/chromedriver";
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static ChromeDriverService service;
    private WebDriver webDriver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private String homePageUrl = "https://www.saucedemo.com/inventory.html";
    private String productPageUrl="https://www.saucedemo.com/inventory-item.html?id=4";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Before
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        webDriver.get(BASE_URL);
        loginPage = new LoginPage(webDriver);
    }

    @When("they enter valid credentials \\(username and password)")
    public void theyEnterValidCredentialsUsernameAndPassword() {
        loginPage.fillInUserName("standard_user");
        loginPage.fillInUserName("problem_user");
        loginPage.fillInUserName("locked_out_user");
        loginPage.fillInUserName("performance_glitch_user");
        loginPage.fillInUserName("error_user");
        loginPage.fillInUserName("visual_user");

        // Fill in the password
        loginPage.fillInPassword("secret_sauce");
    }

    @And("they click on the Login button")
    public void theyClickOnTheLoginButton() {
        loginPage.click();
    }

    @Then("they should be redirected to the home page")
    public void theyShouldBeRedirectedToTheHomePage() {
        MatcherAssert.assertThat(homePageUrl,is("https://www.saucedemo.com/inventory.html"));
    }

    @When("they enter invalid credentials \\(username and\\/or password)")
    public void theyEnterInvalidCredentialsUsernameAndOrPassword() {
        loginPage.fillInUserName("invalid_username1");
        loginPage.fillInPassword("invalid_password1");

    }

    @And("they click on the {string} button")
    public void theyClickOnTheButton(String arg0) {
        loginPage.click();
    }

    @Then("they should see an error indicating invalid credentials")
    public void theyShouldSeeAnErrorIndicatingInvalidCredentials() {
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        MatcherAssert.assertThat(loginPage.getResponseString(), Matchers.containsString(expectedMessage));
    }

    @And("remain on the login page")
    public void remainOnTheLoginPage() {
        MatcherAssert.assertThat(loginPage.getUrl(), is(BASE_URL));
    }



//    @Given("the user is logged in")
//    public void theUserIsLoggedIn() {
//        homePage = new HomePage(webDriver);
//        MatcherAssert.assertThat(homePageUrl,is("https://www.saucedemo.com/inventory.html"));
//    }
//
////    @When("they click on the menu option")
////    public void theyClickOnTheMenuOption() {
////        homePage.click();
////    }
////
////    @Then("they should be shown a dropdown")
////    public void theyShouldBeShownADropdown() {
////        MatcherAssert.assertThat(homePage.isDropdownDisplayed(), is(true));
////    }
////
////    @And("they should see a list of available pages")
////    public void theyShouldSeeAListOfAvailablePages() {
////        MatcherAssert.assertThat(homePage.isListOfPagesDisplayed(), is(true));
////    }
//
//    @When("they click on a specific product")
//    public void theyClickOnASpecificProduct() {
//        productPage = homePage.goToProductPage();
//    }
//
//    @Then("they should be redirected to the product details page")
//    public void theyShouldBeRedirectedToTheProductDetailsPage() {
//        MatcherAssert.assertThat(productPage.getUrl(),is("https://magento.softwaretestingboard.com/what-is-new.html"));
//    }
//
//    @Given("the user is on the product details page")
//    public void theUserIsOnTheProductDetailsPage() {
//    }
//
//    @Then("they should be redirected to the previous page \\(shop page)")
//    public void theyShouldBeRedirectedToThePreviousPageShopPage() {
//
//    }
    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }
}