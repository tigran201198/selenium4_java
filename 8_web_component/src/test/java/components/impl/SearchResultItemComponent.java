package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.cssSelector(".search-title");
    private static final By DESCRIPTION_SELECTOR =
            By.xpath(".//h3/following-sibling::*/*[contains(@class, 'search-match')]");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    private String retrieveTitleText() {
        return findElement(TITLE_SELECTOR).getText();
    }

    private String retrieveDescriptionText() {
        return findElement(DESCRIPTION_SELECTOR).getText();
    }
}
