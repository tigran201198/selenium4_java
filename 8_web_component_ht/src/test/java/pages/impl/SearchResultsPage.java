package pages.impl;

import components.WebComponent;
import components.impl.SearchResultItemComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {

    private static final String SEARCH_RESULT_ITEM_CSS = "[data-component-type='s-search-result']";

    @FindBy(css = SEARCH_RESULT_ITEM_CSS)
    private List<WebElement> searchResultItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItemsText() {
        return searchResultItemComponents().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultItemComponents() {
        waitForElements(By.cssSelector(SEARCH_RESULT_ITEM_CSS));
        return searchResultItems.stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }
}
