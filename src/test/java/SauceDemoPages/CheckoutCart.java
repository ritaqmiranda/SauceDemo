package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCart extends Page{
    public CheckoutCart(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToCart() {
        WebElement cartIcon = webDriver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    public void clickOnCart() {
        WebElement cartIcon = webDriver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = webDriver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void fillInShippingInformation(String firstName, String lastName, String zipCode) {
        WebElement firstNameField = webDriver.findElement(By.id("first-name"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = webDriver.findElement(By.id("last-name"));
        lastNameField.sendKeys(lastName);

        WebElement zipCodeField = webDriver.findElement(By.id("postal-code"));
        zipCodeField.sendKeys(zipCode);
    }

    public void continueFromShippingInformation() {
        WebElement continueButton = webDriver.findElement(By.id("continue"));
        continueButton.click();
    }

    public void confirmOrder() {
        WebElement finishButton = webDriver.findElement(By.id("finish"));
        finishButton.click();
    }

    public boolean isCheckoutComplete() {
        WebElement checkoutBanner = webDriver.findElement(By.className("complete-header"));
        return checkoutBanner.isDisplayed();
    }

}

