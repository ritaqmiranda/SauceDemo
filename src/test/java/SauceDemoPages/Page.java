package SauceDemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {

    protected WebDriver webDriver;
    protected Wait<WebDriver> webDriverWait;
    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }


}
