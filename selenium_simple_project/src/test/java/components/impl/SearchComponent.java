package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchComponent extends WebComponent {

    private static final By SEARCH_INPUT_SELECTOR = By.cssSelector("#query-builder-test");

    public SearchComponent(WebElement rootElement) {
        super(rootElement);
    }

    public void performSearch(String searchPhrase) {
        click();
        findElement(SEARCH_INPUT_SELECTOR).sendKeys(searchPhrase);
        findElement(SEARCH_INPUT_SELECTOR).sendKeys(Keys.ENTER);
    }
}
