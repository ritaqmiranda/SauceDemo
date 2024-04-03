package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends Page {

    private By menuButtonBy = new By.ById("react-burger-menu-btn");
    private By dropDownMenuBy = new By.ByClassName("bm-menu");
    private By listOfPagesBy = new By.ByCssSelector("bm-menu-wrap");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void click() {
        WebElement pwButton = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(menuButtonBy));
        pwButton.click();
    }


        public boolean isDropdownDisplayed() {
            WebElement dropdown = webDriver.findElement(dropDownMenuBy);
            return dropdown.isDisplayed();

        }

    public boolean isListOfPagesDisplayed() {
        WebElement listOfPages = webDriver.findElement(listOfPagesBy);
        return listOfPages.isDisplayed();
    }

}
