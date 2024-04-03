package SauceDemoPages.myStepsDef;

import SauceDemoPages.CheckoutCart;
import SauceDemoPages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class CheckoutSteps {

    private static final String DRIVER_LOCATION = "src/main/resources/chromedriver";
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static ChromeDriverService service;
    private LoginPage loginPage;
    private WebDriver webDriver;
    private CheckoutCart checkoutCart;

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


    @Given("I open the web page")
    public void iOpenTheWebPage() {
        webDriver.get(BASE_URL);
        loginPage = new LoginPage(webDriver);
    }

    @When("I login as a {string} user")
    public void iLoginAsAUser(String arg0) {
        loginPage.fillInUserName("standard_user");
        loginPage.fillInPassword("secret_sauce");
        loginPage.click();
    }

    @And("I add {string} to the cart")
    public void iAddToTheCart(String productToAdd) {
        checkoutCart = new CheckoutCart(webDriver);
        checkoutCart.goToCart();
    }

    @And("I click on the cart")
    public void iClickOnTheCart() {
        checkoutCart.clickOnCart();
    }

    @And("I checkout")
    public void iCheckout() {
        checkoutCart.proceedToCheckout();

    }

    @And("I enter my information to continue")
    public void iEnterMyInformationToContinue(DataTable dataTable) {
        Map<String, String> userInfo = dataTable.transpose().asMap(String.class, String.class);
        String firstName = userInfo.get("firstName");
        String lastName = userInfo.get("lastName");
        String zipCode = userInfo.get("zipCode");
        checkoutCart.fillInShippingInformation(firstName, lastName, zipCode);
        checkoutCart.continueFromShippingInformation();
    }

    @Then("I confirm my order")
    public void iConfirmMyOrder() {
        checkoutCart.confirmOrder();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }
}
