package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.cssSelector("h2 .a-link-normal");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    private String retrieveTitleText() {
        return findElement(TITLE_SELECTOR).getText();
    }

    private String retrieveTitleHref() {
        return findElement(TITLE_SELECTOR).getAttribute("href");
    }
}
