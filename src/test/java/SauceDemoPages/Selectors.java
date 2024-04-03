package SauceDemoPages;

import org.openqa.selenium.By;

public class Selectors {

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By homepageTitle = By.className("app_logo");
    By errorMessage = By.cssSelector(".error-message-container.error h3");
    By loginpageTitle = By.className("login_logo");
    By menu = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");
    By productBackpack = By.cssSelector("button[name*=sauce-labs-backpack]");
    By productBikelight = By.cssSelector("button[name*=sauce-labs-bike-light]");
    By productTshirt = By.cssSelector("button[name*=sauce-labs-bolt-t-shirt]");
    By productJacket = By.cssSelector("button[name*=sauce-labs-fleece-jacket]");
    By productOnesie = By.cssSelector("button[name*=sauce-labs-onesie]");
    By productTshirtRed = By.cssSelector("button[name*=allthethings]");
    By cart = By.className("shopping_cart_link");
    By checkout = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By checkoutBanner = By.className("complete-header");
    By inventoryItem = By.cssSelector("div.inventory_item[data-test='inventory-item']");

}
