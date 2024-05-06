package components.impl;

import components.WebComponent;
import entities.SearchResultItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.cssSelector(".search-title");
    private static final By DESCRIPTION_SELECTOR =
            By.xpath(".//h3/following-sibling::*/*[contains(@class, 'search-match')]");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public SearchResultItem convertToSearchResultItem() {
        return new SearchResultItem(
                retrieveTitle(),
                retrieveDescription()
        );
    }

    private String retrieveTitle() {
        return findElement(TITLE_SELECTOR).getText().toLowerCase();
    }

    private String retrieveDescription() {
        return findElement(DESCRIPTION_SELECTOR).getText().toLowerCase();
    }
}
