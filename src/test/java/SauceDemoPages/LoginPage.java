package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {
    private By usernameBy = new By.ById(("user-name"));
    private By passWordBy = new By.ById("password");
    private By signInButtonBy = new By.ById("login-button");

    private By responseStringBy = new By.ByCssSelector("div.error-message-container.error");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillInUserName(String name) {
        WebElement userNameBox = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameBy));
        userNameBox.sendKeys(name);
    }

    public void fillInPassword(String password) {
        WebElement pwBox = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(passWordBy));
        pwBox.sendKeys(password);
    }

    public void click() {
        WebElement pwButton = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(signInButtonBy));
        pwButton.click();
    }

    public String getResponseString() {
        WebElement responseString = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(responseStringBy));
        return responseString.getText();
    }

}


