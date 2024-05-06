package pages.impl;

import components.impl.SearchResultItemComponent;
import entities.SearchResultItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

import java.util.List;

public class SearchResultsPage extends WebPage {

    public static final String SEARCH_RESULT_ITEMS_CSS = "[data-testid='results-list'] > div";

    @FindBy(css = SEARCH_RESULT_ITEMS_CSS)
    private List<WebElement> searchResultItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchResultItem> searchResultItems() {
        waitForElementVisibility(By.cssSelector(SEARCH_RESULT_ITEMS_CSS));
        return searchResultItemComponents().stream()
                .map(SearchResultItemComponent::convertToSearchResultItem)
                .toList();
    }

    private List<SearchResultItemComponent> searchResultItemComponents() {
        return searchResultItems.stream()
                .map(SearchResultItemComponent::new)
                .toList();
    }
}
