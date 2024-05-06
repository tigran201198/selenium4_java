package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected WebPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementVisibility(By selector) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        }
        finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
}
