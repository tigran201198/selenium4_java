package pages.impl;

import components.impl.SearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

public class HomePage extends WebPage {

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchComponent searchComponent() {
        return new SearchComponent(searchInput);
    }
}
