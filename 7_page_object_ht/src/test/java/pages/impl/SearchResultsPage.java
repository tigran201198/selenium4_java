package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {

    private static final String SEARCH_RESULT_ITEMS_CSS = "[data-component-type='s-search-result'] h2 .a-link-normal";

    @FindBy(css = SEARCH_RESULT_ITEMS_CSS)
    private List<WebElement> searchResultsItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItemsText() {
        waitForElement(By.cssSelector(SEARCH_RESULT_ITEMS_CSS));
        return searchResultsItems.stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());
    }
}
